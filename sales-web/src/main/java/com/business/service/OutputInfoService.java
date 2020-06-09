package com.business.service;

import com.business.bean.OutputInfo;
import com.business.bean.SaleInfo;
import com.business.bean.SearchParam;
import com.business.dto.OutputInfoDTO;
import com.business.mapper.OutputInfoMapper;
import com.business.mapper.SaleInfoMapper;
import com.github.pagehelper.PageHelper;
import javafx.beans.InvalidationListener;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.*;

/**
* @Description:    出库单操作
* @Author:         ccm
* @CreateDate:     2019/3/23 15:40
*/
@Service
public class OutputInfoService {
    private final static Logger logger = LoggerFactory.getLogger(OutputInfoService.class);

    @Resource
    private OutputInfoMapper outputInfoMapper;

    @Resource
    private SaleInfoMapper saleInfoMapper;

    @Resource
    private SaleInfoService saleInfoService;


    /**
     * 出库信息查询更新版
     */
    public List<OutputInfo> selectAllOutputIf(SearchParam searchParam) {
        logger.info("OutputInfoService ==> selectAllOutputIf");
        if (searchParam.getPageNum() != null || searchParam.getPageSize() != null) {
            PageHelper.startPage(searchParam);
        }
        return outputInfoMapper.selectAllOutput(searchParam.getKeyWord());
    }

    /**
     * 出库信息查询(已测试)
     */
    public List<OutputInfo> selectOutputInfoByExample(String keyWord) {
        if (keyWord == null) {
            logger.info("OutputInfoService == > selectOutputInfoByExample the keyWord is null");
            return null;
        }
        String newKeyWord = "%"+keyWord+"%";
        Example example = new Example(OutputInfo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andLike("orderNumber", newKeyWord);
        criteria.orLike("tableMakedate", newKeyWord);
        criteria.orLike("customer", newKeyWord);
        criteria.orLike("customerPhone", newKeyWord);
        criteria.orLike("customerCompany", newKeyWord);
        criteria.orLike("paymentMethod", newKeyWord);
        criteria.orLike("cuType", newKeyWord);
        criteria.orLike("payAccount", newKeyWord);
        criteria.orLike("deliveryMember", newKeyWord);
        criteria.orLike("deliveryMemberPhone", newKeyWord);
        criteria.orLike("shippingDate", newKeyWord);
        criteria.orLike("deliveryRequirements", newKeyWord);
        criteria.orLike("outboundType", newKeyWord);
        criteria.orLike("warehouseNumber", newKeyWord);
        criteria.orLike("customerNote", newKeyWord);
        criteria.orLike("goodsName", newKeyWord);
        criteria.orLike("model", newKeyWord);
        criteria.orLike("specification", newKeyWord);
        criteria.orLike("barcode", newKeyWord);
        criteria.orLike("batchNumber", newKeyWord);
        criteria.orLike("number", newKeyWord);
        criteria.orLike("unit", newKeyWord);
        criteria.orLike("discount", newKeyWord);
        criteria.orLike("afterDiscount", newKeyWord);
        criteria.orLike("produceNote", newKeyWord);
        criteria.orLike("consignee", newKeyWord);
        criteria.orLike("shippingAdress", newKeyWord);
        criteria.orLike("receivingZipCode", newKeyWord);
        criteria.orLike("receiverMobilePhone", newKeyWord);
        criteria.orLike("receiverPhone", newKeyWord);
        criteria.orLike("province", newKeyWord);
        criteria.orLike("city", newKeyWord);
        criteria.orLike("audit", newKeyWord);
        criteria.orLike("keepAccount", newKeyWord);
        criteria.orLike("departmentHead", newKeyWord);
        criteria.orLike("controller", newKeyWord);
        criteria.orLike("tableMaker", newKeyWord);
        criteria.orLike("salesDirector", newKeyWord);
        criteria.orLike("salesman", newKeyWord);
        criteria.orLike("carNumber", newKeyWord);
        criteria.orLike("deliver", newKeyWord);
        criteria.orLike("receiver", newKeyWord);
        criteria.orLike("county", newKeyWord);

        List<OutputInfo> outputInfos = outputInfoMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(outputInfos)) {
            logger.info("OutputInfoService == > selectOutputInfoByExample the product is null");
            return null;
        }
        return outputInfos;
    }


    /**
     * 根据入库订单号修改入库单信息(已测试)
     */
    @Transactional(rollbackFor = Exception.class)
    public Integer updateOutputInfo(OutputInfo outputInfo) {
        if (outputInfo == null) {
            logger.info("OutputInfoService == > updateOutputInfo the inputInfo is null");
            return null;
        }
        Example example = new Example(OutputInfo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("orderNumber",outputInfo.getOrderNumber());
        if (outputInfoMapper.selectByExample(example).isEmpty()) {
            logger.info("OutputInfoService == > updateOutputInfo the orderNumber is null");
            return null;
        }
        return outputInfoMapper.updateByExample(outputInfo,example);
    }


    /**
     * 删除出库单（已测试）
     */
    public void deleteOutputInfo(OutputInfo outputInfo) {
        Example example = new Example(OutputInfo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("orderNumber", outputInfo.getOrderNumber());
        outputInfoMapper.deleteByExample(example);
    }


    /**
     * 添加出库单（已测试）
     */
    public void insetOutputInfo(OutputInfo outputInfo) {
        outputInfoMapper.insert(outputInfo);
        //改变对应销售单的状态
        saleInfoService.updateSaleInfoStatus(outputInfo.getSaleinfoId(), "5");
    }


    /**
     * 更新出库单中“status”的属性
     */
    @Transactional(rollbackFor = Exception.class)
    public Integer updateOutputStatus(String orderNumber, String newStatus) {
        OutputInfo outputInfo = selectOutputInfoByExample(orderNumber).get(0);

        outputInfo.setStatus(newStatus);

        return updateOutputInfo(outputInfo);
    }


    /**
     * 出库员自动获取销售主管审批通过的销售信息
     */
    public List<OutputInfoDTO> selectOutputInfoDtoBySaleInfo(String status) {

        Example example = new Example(SaleInfo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("status", status);
        List<SaleInfo> saleInfos = saleInfoMapper.selectByExample(example);

        List<OutputInfoDTO> outputInfoDTOS = new ArrayList<OutputInfoDTO>();

        SaleInfo saleInfo;
        for (Iterator iterator = saleInfos.iterator();iterator.hasNext();) {
            saleInfo = (SaleInfo)iterator.next();
            OutputInfoDTO outputInfoDTO = saleInfoService.encapsulationOutPutDTO(saleInfo);
            outputInfoDTOS.add(outputInfoDTO);
        }
        return outputInfoDTOS;
    }


    /**
     * 检查是否存在指定状态的出库单
     * @param status
     * @return
     */
    public Boolean checkIsEmptyStatus(String status) {
        if (StringUtils.isBlank(status)) {
            logger.info("OutputInfoService == > checkIsEmptyStatus the status is blank");
            return null;
        }
        Example example = new Example(OutputInfo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("status", status);
        List<OutputInfo> outputInfos = outputInfoMapper.selectByExample(example);
        return CollectionUtils.isEmpty(outputInfos);
    }
}
