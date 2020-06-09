package com.business.service;

import com.business.bean.SaleInfo;
import com.business.bean.SearchParam;
import com.business.dto.OutputInfoDTO;
import com.business.dto.PurchaseDTO;
import com.business.mapper.SaleInfoMapper;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * 销售信息
 * @author taoye
 */
@Service
public class SaleInfoService {
    @Resource
    private SaleInfoMapper saleInfoMapper;

    private final static Logger logger = LoggerFactory.getLogger(InventoryInfoService.class);

    /**
     * 新增信息
     * @param saleInfo
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public Integer insert(SaleInfo saleInfo){
        return saleInfoMapper.insert(saleInfo);
    }


    public List<SaleInfo> selectAll(){
        List<SaleInfo> saleInfos = saleInfoMapper.selectAll();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        for (SaleInfo saleInfo:saleInfos){
            String format = sf.format(saleInfo.getTableMakeTime());
            try {
                saleInfo.setTableMakeTime(sf.parse(format));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return saleInfos;
    }


    /**
     *查询商品信息（已测试）
     */
    public List<SaleInfo> selectSaleInfoByExample(String keyWord) {
        if (keyWord == null) {
            logger.info("SaleInfoService == > selectSaleInfoByExample the keyWord is null");
            return null;
        }
        String newKeyWord = "%"+keyWord+"%";
        Example example = new Example(SaleInfo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andLike("product", newKeyWord);
        criteria.orLike("productName", newKeyWord);
        criteria.orLike("model", newKeyWord);
        criteria.orLike("size", newKeyWord);
        criteria.orLike("number", newKeyWord);
        criteria.orLike("unit", newKeyWord);
        criteria.orLike("unitPrice", newKeyWord);
        criteria.orLike("warehouseAddress", newKeyWord);
        criteria.orLike("combine", newKeyWord);
        criteria.orLike("orderNumber", newKeyWord);
        criteria.orLike("tableMakeTime", newKeyWord);
        criteria.orLike("customer", newKeyWord);
        criteria.orLike("customerPhone", newKeyWord);
        criteria.orLike("customerCompany", newKeyWord);
        criteria.orLike("paymentType", newKeyWord);
        criteria.orLike("cuType", newKeyWord);
        criteria.orLike("paymentAccount", newKeyWord);
        criteria.orLike("saler", newKeyWord);
        criteria.orLike("salerPhone", newKeyWord);
        criteria.orLike("orderTime", newKeyWord);
        criteria.orLike("salerRemark", newKeyWord);
        criteria.orLike("receiver", newKeyWord);
        criteria.orLike("receiverAddress", newKeyWord);
        criteria.orLike("receiverExpressCode", newKeyWord);
        criteria.orLike("receiverMobilephone", newKeyWord);
        criteria.orLike("receiverPhone", newKeyWord);
        criteria.orLike("receiverProvince", newKeyWord);
        criteria.orLike("receiverCity", newKeyWord);
        criteria.orLike("receiverCounty", newKeyWord);
        criteria.orLike("productComment", newKeyWord);

        List<SaleInfo> saleInfos = saleInfoMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(saleInfos)) {
            logger.info("SaleInfoService == > selectSaleInfoByExample the product is null");
            return null;
        }
        return saleInfos;
    }


    /**
     * 根据销售订单号修改销售单信息（已测试）
     */
    @Transactional(rollbackFor = Exception.class)
    public Integer updateSaleInfo(SaleInfo saleInfo) {
        if (saleInfo == null) {
            logger.info("SaleInfoService == > updateSaleInfo the saleInfo is null");
            return null;
        }
        Example example = new Example(SaleInfo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("orderNumber",saleInfo.getOrderNumber());
        if (saleInfoMapper.selectByExample(example).isEmpty()) {
            logger.info("SaleInfoService == > updateSaleInfo the saleInfo is null");
            return null;
        }
        return saleInfoMapper.updateByExample(saleInfo,example);
    }


    /**
     * 删除销售单（已测试）
     */
    public void deleteSaleInfo(SaleInfo saleInfo) {
        Example example = new Example(SaleInfo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("orderNumber", saleInfo.getOrderNumber());
        saleInfoMapper.deleteByExample(example);
    }


    /**
     * 检测是否存在指定状态的销售单
     * @param status
     * @return
     */
    public Boolean checkIsEmptyStatus(String status) {
        if (StringUtils.isBlank(status)) {
            logger.info("SaleInfoService == > checkIsEmptyStatus the status is blank");
            return null;
        }
        Example example = new Example(SaleInfo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("status", status);
        List<SaleInfo> saleInfos = saleInfoMapper.selectByExample(example);
        return CollectionUtils.isEmpty(saleInfos);
    }

    /**
     * 通过id更新销售单中“status”的状态
     */
    @Transactional(rollbackFor = Exception.class)
    public Integer updateSaleInfoStatus(Long id, String newStatus) {
        Example example = new Example(SaleInfo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id", id);
        SaleInfo saleInfo = saleInfoMapper.selectByExample(example).get(0);
        saleInfo.setStatus(newStatus);
        return updateSaleInfo(saleInfo);
    }


    /**
     * 通过oderNumber更新销售单中“status”的状态
     */
    @Transactional(rollbackFor = Exception.class)
    public Integer updateSaleInfoStatusByOrderNumber(String OrderNumber, String newStatus) {
        Example example = new Example(SaleInfo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("orderNumber", OrderNumber);
        SaleInfo saleInfo = saleInfoMapper.selectByExample(example).get(0);
        saleInfo.setStatus(newStatus);
        return updateSaleInfo(saleInfo);
    }


    /**
     * 从销售单中提取出库员能看到的信息
     */
    public OutputInfoDTO encapsulationOutPutDTO(SaleInfo saleInfo) {
        OutputInfoDTO outputInfoDTO = new OutputInfoDTO();
        outputInfoDTO.setId(saleInfo.getId());
        outputInfoDTO.setCustomer(saleInfo.getCustomer());
        outputInfoDTO.setCustomerPhone(saleInfo.getCustomerPhone());
        outputInfoDTO.setCustomerCompany(saleInfo.getCustomerCompany());
        outputInfoDTO.setPaymentType(saleInfo.getPaymentType());
        outputInfoDTO.setCuType(saleInfo.getCuType());
        outputInfoDTO.setPaymentAccount(saleInfo.getPaymentAccount());
        outputInfoDTO.setModel(saleInfo.getModel());
        outputInfoDTO.setNumber(saleInfo.getNumber());
        outputInfoDTO.setUnit(saleInfo.getUnit());
        outputInfoDTO.setProductComment(saleInfo.getProductComment());
        outputInfoDTO.setReceiver(saleInfo.getReceiver());
        outputInfoDTO.setReceiverAddress(saleInfo.getReceiverAddress());
        outputInfoDTO.setReceiverExpressCode(saleInfo.getReceiverExpressCode());
        outputInfoDTO.setReceiverMobilephone(saleInfo.getReceiverMobilephone());
        outputInfoDTO.setReceiverPhone(saleInfo.getReceiverPhone());
        outputInfoDTO.setReceiverProvince(saleInfo.getReceiverProvince());
        outputInfoDTO.setReceiverCity(saleInfo.getReceiverCity());
        outputInfoDTO.setReceiverCounty(saleInfo.getReceiverCounty());
        return outputInfoDTO;
    }


    /**
     * 封装销售单中采购员需要的信息
     */
    public PurchaseDTO encapsulationSaleInfoToPurchaseDTO(SaleInfo saleInfo) {
        PurchaseDTO purchaseDTO = new PurchaseDTO();
        purchaseDTO.setSaleInfoId(saleInfo.getId());
        purchaseDTO.setModel(saleInfo.getModel());
        purchaseDTO.setNumber(saleInfo.getNumber());
        purchaseDTO.setUnit(saleInfo.getUnit());
        purchaseDTO.setUnitPrice(saleInfo.getUnitPrice());
        purchaseDTO.setWarehouseAddress(saleInfo.getWarehouseAddress());
        return purchaseDTO;
    }


    /**
     * 查询所有销售信息
     */
    public List<SaleInfo> selectAllSaleIf(SearchParam searchParam) {
        logger.info("SaleInfoService ==> selectAllSaleIf");
        if (searchParam.getPageNum() != null || searchParam.getPageSize() != null) {
            PageHelper.startPage(searchParam);
        }
        return saleInfoMapper.selectAllSaleInfo(searchParam.getKeyWord());
    }


    /**
     * 根据销售单状态获取销售单
     */
    public List<SaleInfo> selectSaleInfoByStatus(String status) {
        Example example = new Example(SaleInfo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("status", status);
        List<SaleInfo> saleInfos = saleInfoMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(saleInfos)) {
            logger.info("SaleInfoService == > selectSaleInfoByStatus the product is null");
            return null;
        }
        return saleInfos;
    }
}
