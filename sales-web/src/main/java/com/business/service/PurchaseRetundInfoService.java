package com.business.service;

import com.business.bean.*;
import com.business.dto.CheckInfoDTO;
import com.business.dto.PurchaseRefundInfoDTO;
import com.business.mapper.CheckInfoMapper;
import com.business.mapper.InputInfoMapper;
import com.business.mapper.PurchaseRetundInfoMapper;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
* @Description:    采购退货服务
* @Author:         ccm
* @CreateDate:     2019/3/24 10:57
*/
@Service
public class PurchaseRetundInfoService {
    private final static Logger logger = LoggerFactory.getLogger(PurchaseRetundInfoService.class);

    @Resource
    private PurchaseRetundInfoMapper purchaseRetundInfoMapper;

    @Resource
    private CheckInfoService checkInfoService;

    @Resource
    private CheckInfoMapper checkInfoMapper;

    @Resource
    private InputInfoService inputInfoService;

    @Resource
    private InputInfoMapper inputInfoMapper;


    /**
     * 采购退货信息查询(已测试)
     */
    public List<PurchaseRetundInfo> selectPurchaseRetundInfoByExample(SearchParam searchParam) {
        logger.info("PurchaseRetundInfoService ==> selectPurchaseRetundInfoByExample");
        if (searchParam.getPageNum() != null || searchParam.getPageSize() != null) {
            PageHelper.startPage(searchParam);
        }
        return purchaseRetundInfoMapper.selectAllPurchaseRetundInfo(searchParam.getKeyWord());
    }


    /**
     * 根据采购退货单号修改采购退货单信息(已测试)
     */
    @Transactional(rollbackFor = Exception.class)
    public Integer updatePurchaseRetundInfo(PurchaseRetundInfo purchaseRetundInfo) {
        if (purchaseRetundInfo == null) {
            logger.info("PurchaseRetundInfoService == > updatePurchaseRetundInfo the purchaseRetundInfo is null");
            return null;
        }
        Example example = new Example(PurchaseRetundInfo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("orderNumber",purchaseRetundInfo.getOrderNumber());
        if (purchaseRetundInfoMapper.selectByExample(example).isEmpty()) {
            logger.info("PurchaseRetundInfoService == > updatePurchaseRetundInfo the orderNumber is null");
            return null;
        }
        return purchaseRetundInfoMapper.updateByExample(purchaseRetundInfo,example);
    }


    /**
     * 删除采购退货单（已测试）
     */
    public void deletePurchaseRetundInfo(PurchaseRetundInfo purchaseRetundInfo) {
        Example example = new Example(PurchaseRetundInfo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("orderNumber", purchaseRetundInfo.getOrderNumber());
        purchaseRetundInfoMapper.deleteByExample(example);
    }


    /**
     * 添加采购退货单，并改变对应入库单的状态
     */
    public void insetPurchaseRetundInfo(PurchaseRetundInfo purchaseRetundInfo) {
        purchaseRetundInfoMapper.insert(purchaseRetundInfo);
        //更新对应入库单的状态
        inputInfoService.updateInputInfoStatus(inputInfoMapper.selectByPrimaryKey(checkInfoMapper.selectByPrimaryKey(purchaseRetundInfo.getCheckId()).getInputId()).getId(), "-2");
    }


    /**
     * 采购退货员获取采购退货所需要的信息
     */
    public List<PurchaseRefundInfoDTO> purchaseReturnManSelectAllInfo(String status) {
        Example example = new Example(CheckInfo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("status", status);
        List<CheckInfo> checkInfos = checkInfoMapper.selectByExample(example);
        List<PurchaseRefundInfoDTO> purchaseRefundInfoDTOS = new ArrayList<PurchaseRefundInfoDTO>();
        CheckInfo checkInfo;
        for (Iterator iterator = checkInfos.iterator(); iterator.hasNext(); ) {
            checkInfo = (CheckInfo) iterator.next();
            PurchaseRefundInfoDTO purchaseRefundInfoDTO = checkInfoService.encapsulationPurchaseInfoDTO(checkInfo);
            purchaseRefundInfoDTOS.add(purchaseRefundInfoDTO);
        }
        return purchaseRefundInfoDTOS;
    }


    /**
     * 检查是否存在指定状态的采购退货
     * @param status
     * @return
     */
    public Boolean checkIsEmptyStatus(String status) {
        if (StringUtils.isBlank(status)) {
            logger.info("PurchaseRetundInfoService == > checkIsEmptyStatus the status is blank");
            return null;
        }
        Example example = new Example(PurchaseRetundInfo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("status", status);
        List<PurchaseRetundInfo> purchaseInfos = purchaseRetundInfoMapper.selectByExample(example);
        return CollectionUtils.isEmpty(purchaseInfos);
    }
}
