package com.business.service;

import com.business.bean.*;
import com.business.dto.CheckInfoDTO;
import com.business.dto.PurchaseDTO;
import com.business.dto.PurchaseRefundInfoDTO;
import com.business.mapper.CheckInfoMapper;
import com.business.mapper.InputInfoMapper;
import com.business.mapper.PurchaseInfoMapper;
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
* @Description:    质检服务
* @Author:         ccm
* @CreateDate:     2019/3/24 10:00
*/
@Service
public class CheckInfoService {
    private final static Logger logger = LoggerFactory.getLogger(CheckInfoService.class);

    @Resource
    CheckInfoMapper checkInfoMapper;

    @Resource
    InputInfoMapper inputInfoMapper;

    @Resource
    PurchaseInfoMapper purchaseInfoMapper;

    @Resource
    InputInfoService inputInfoService;

    @Resource
    PurchaseInfoService purchaseInfoService;

    /**
     * 质检信息查询(已测试)
     */
    public List<CheckInfo> selectCheckInfoByExample(SearchParam searchParam) {
        logger.info("CheckInfoService ==> selectCheckInfoByExample");
        if (searchParam.getPageNum() != null || searchParam.getPageSize() != null) {
            PageHelper.startPage(searchParam);
        }
        return checkInfoMapper.selectAllCheckInfo(searchParam.getKeyWord());
    }


    /**
     * 根据质检订单号修改质检单信息(已测试)
     */
    @Transactional(rollbackFor = Exception.class)
    public Integer updateCheckInfo(CheckInfo checkInfo) {
        if (checkInfo == null) {
            logger.info("CheckService == > updateCheckInfo the inputInfo is null");
            return null;
        }
        Example example = new Example(CheckInfo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("checkOrder",checkInfo.getCheckOrder());
        if (checkInfoMapper.selectByExample(example).isEmpty()) {
            logger.info("CheckService == > updateCheckInfo the checkOrder is null");
            return null;
        }
        return checkInfoMapper.updateByExample(checkInfo,example);
    }


    /**
     * 添加质检单（已测试）
     */
    public void insertCheckInfo(CheckInfo checkInfo) {
        checkInfoMapper.insert(checkInfo);
    }


    /**
     * 删除质检单（已测试）
     */
    public void deleteCheckInfo(CheckInfo checkInfo) {
        Example example = new Example(CheckInfo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("checkOrder", checkInfo.getCheckOrder());
        checkInfoMapper.deleteByExample(example);
    }


    /**
     * 更改质检单的状态"status"
     */
    @Transactional(rollbackFor = Exception.class)
    public Integer updateCheckInfoStatus(String orderNumber, String newStatus) {
        Example example = new Example(CheckInfo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("checkOrder", orderNumber);
        CheckInfo checkInfo = checkInfoMapper.selectByExample(example).get(0);
        checkInfo.setStatus(newStatus);
        return updateCheckInfo(checkInfo);
    }


    /**
     * 质检员获取入库单中的数据
     */
    public List<CheckInfoDTO> purchaseManSelectAllSaleInfo(String status) {
        Example example = new Example(InputInfo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("status", status);

        List<InputInfo> inputInfos = inputInfoMapper.selectByExample(example);

        List<CheckInfoDTO> checkInfoDTOS = new ArrayList<CheckInfoDTO>();

        InputInfo inputInfo = new InputInfo();
        for (Iterator iterator = inputInfos.iterator(); iterator.hasNext();) {
            inputInfo = (InputInfo)iterator.next();
            CheckInfoDTO checkInfoDTO = inputInfoService.encapsulationInputInfoToCheck(inputInfo);
            checkInfoDTOS.add(checkInfoDTO);
        }
        return checkInfoDTOS;
    }

    /**
     * 从采购单、入库单、质检单中提取出采购退货单中需要的数据
     */
    public PurchaseRefundInfoDTO encapsulationPurchaseInfoDTO(CheckInfo checkInfo) {
        PurchaseRefundInfoDTO purchaseRefundInfoDTO = new PurchaseRefundInfoDTO();

        //质检
        purchaseRefundInfoDTO.setProvider(checkInfo.getProvider());
        purchaseRefundInfoDTO.setProviderPhone(checkInfo.getProviderPhone());
        purchaseRefundInfoDTO.setCheckAmount(checkInfo.getCheckAmount());
        purchaseRefundInfoDTO.setBadNumber(checkInfo.getBadNumber());
        purchaseRefundInfoDTO.setCheckResult(checkInfo.getCheckResult());

        //入库
        InputInfo inputInfo = inputInfoMapper.selectByPrimaryKey(checkInfo.getInputId());
        purchaseRefundInfoDTO.setWarehouseNumber(inputInfo.getWarehouseNumber());
        purchaseRefundInfoDTO.setName(inputInfo.getProduct());
        purchaseRefundInfoDTO.setModel(inputInfo.getModel());
        purchaseRefundInfoDTO.setNumber(inputInfo.getNumber());
        purchaseRefundInfoDTO.setAddress(inputInfo.getAddress());
        purchaseRefundInfoDTO.setCombine(inputInfo.getCombine());

        //采购
        PurchaseInfo purchaseInfo = purchaseInfoMapper.selectByPrimaryKey(inputInfo.getPurchaseId());
        purchaseRefundInfoDTO.setUnit(purchaseInfo.getUnit());
        purchaseRefundInfoDTO.setUnitPrice(purchaseInfo.getUnitPrice());

        return purchaseRefundInfoDTO;
    }


    /**
     * 检查是否存在指定状态的质检单
     * @param status
     * @return
     */
    public Boolean checkIsEmptyStatus(String status) {
        if (StringUtils.isBlank(status)) {
            logger.info("CheckInfoService == > checkIsEmptyStatus the status is blank");
            return null;
        }
        Example example = new Example(CheckInfo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("status", status);
        List<CheckInfo> checkInfos = checkInfoMapper.selectByExample(example);
        return CollectionUtils.isEmpty(checkInfos);
    }
}
