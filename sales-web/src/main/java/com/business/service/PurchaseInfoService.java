package com.business.service;

import com.business.bean.PurchaseInfo;
import com.business.bean.SaleInfo;
import com.business.bean.SearchParam;
import com.business.dto.InventoryByPurchaseDTO;
import com.business.dto.OutputInfoDTO;
import com.business.dto.PurchaseDTO;
import com.business.dto.PurchaseInputDTO;
import com.business.mapper.PurchaseInfoMapper;
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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *@Auther: ccm
 *@Description: 采购信息操作
 *@Date: 2019/3/10 16:20
 */
@Service
public class PurchaseInfoService {
    private final static Logger logger = LoggerFactory.getLogger(PurchaseInfoService.class);

    @Resource
    PurchaseInfoMapper purchaseInfoMapper;

    @Resource
    SaleInfoMapper saleInfoMapper;

    @Resource
    SaleInfoService saleInfoService;

    /**
     * 查询所有采购信息
     * @param searchParam
     * @return
     */
    public List<PurchaseInfo> selectAllPurchaseIf(SearchParam searchParam) {
        logger.info("PurchaseInfoService ==> selectAllPurchaseIf");
        if (searchParam.getPageNum() != null || searchParam.getPageSize() != null) {
            PageHelper.startPage(searchParam);
        }
        return purchaseInfoMapper.selectAllPurchaseInfo(searchParam.getKeyWord());
    }

    /**
     * 采购信息查询
     */
    public List<PurchaseInfo> selectPurchaseInfoByExample(String keyWord) {
        if (keyWord == null) {
            logger.info("PurchaseService == > selectPurchaseInfoByExample the keyWord is null");
            return null;
        }
        String newKeyWord = "%"+keyWord+"%";
        Example example = new Example(PurchaseInfo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andLike("orderNumber", newKeyWord);
        criteria.orLike("tableMakedate", newKeyWord);
        criteria.orLike("purchaseman", newKeyWord);
        criteria.orLike("purchasemanPhone", newKeyWord);
        criteria.orLike("purchaseDate", newKeyWord);
        criteria.orLike("purchaseNote", newKeyWord);
        criteria.orLike("provider", newKeyWord);
        criteria.orLike("providerCode", newKeyWord);
        criteria.orLike("providerLinkman", newKeyWord);
        criteria.orLike("providerLinkmanPhone", newKeyWord);
        criteria.orLike("providerAdress", newKeyWord);
        criteria.orLike("demander", newKeyWord);
        criteria.orLike("demanderLinkman", newKeyWord);
        criteria.orLike("demanderPhone", newKeyWord);
        criteria.orLike("demanderAdress", newKeyWord);
        criteria.orLike("purchaseManufacturers", newKeyWord);
        criteria.orLike("goodsArrivalDate", newKeyWord);
        criteria.orLike("produceNumber", newKeyWord);
        criteria.orLike("produceName", newKeyWord);
        criteria.orLike("model", newKeyWord);
        criteria.orLike("specification", newKeyWord);
        criteria.orLike("amount", newKeyWord);
        criteria.orLike("unit", newKeyWord);
        criteria.orLike("unitPrice", newKeyWord);
        criteria.orLike("predictGoodsArrivalDate", newKeyWord);
        criteria.orLike("inputBarCode", newKeyWord);
        criteria.orLike("warehouseAdress", newKeyWord);
        criteria.orLike("purchaseProduceSum", newKeyWord);
        criteria.orLike("purchaseReceiveAdress", newKeyWord);
        criteria.orLike("clearingForm", newKeyWord);
        criteria.orLike("containingRate", newKeyWord);
        criteria.orLike("transportatinoWay", newKeyWord);

        List<PurchaseInfo> purchaseInfos = purchaseInfoMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(purchaseInfos)) {
            logger.info("PurchaseService == > selectPurchaseInfoByExample the product is null");
            return null;
        }
        return purchaseInfos;
    }


    /**
     * 根据采购订单号修改采购单信息(已测试)
     */
    @Transactional(rollbackFor = Exception.class)
    public Integer updatePurchaseInfo(PurchaseInfo purchaseInfo) {
        if (purchaseInfo == null) {
            logger.info("PurchaseService == > updatePurchaseInfo the inputInfo is null");
            return null;
        }
        Example example = new Example(PurchaseInfo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("orderNumber",purchaseInfo.getOrderNumber());
        if (purchaseInfoMapper.selectByExample(example).isEmpty()) {
            logger.info("PurchaseService == > updatePurchaseInfo the orderNumber is null");
            return null;
        }
        return purchaseInfoMapper.updateByExample(purchaseInfo,example);
    }


    /**
     * 添加采购单（已测试）
     */
    public void insertPurchaseInfo(PurchaseInfo purchaseInfo) {
        purchaseInfoMapper.insert(purchaseInfo);
    }


    /**
     * 删除采购单（已测试）
     */
    public void deletePurchaseInfo(PurchaseInfo purchaseInfo) {
        Example example = new Example(PurchaseInfo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("orderNumber", purchaseInfo.getOrderNumber());
        purchaseInfoMapper.deleteByExample(example);
    }


    /**
     * 采购员获取到销售主管审批通过的销售信息
     */
    public List<PurchaseDTO> purchaseManSelectAllSaleInfo() {
        Example example = new Example(SaleInfo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("status", "3");

        List<SaleInfo> saleInfos = saleInfoMapper.selectByExample(example);

        List<PurchaseDTO> purchaseDTOS = new ArrayList<PurchaseDTO>();

        SaleInfo saleInfo = new SaleInfo();
        for (Iterator iterator = saleInfos.iterator(); iterator.hasNext();) {
            saleInfo = (SaleInfo)iterator.next();
            PurchaseDTO purchaseDTO = saleInfoService.encapsulationSaleInfoToPurchaseDTO(saleInfo);
            purchaseDTOS.add(purchaseDTO);
        }

        return purchaseDTOS;
    }

    /**
     * 自动获取到未审批的采购单
     */
    public List<PurchaseInfo> selectNoAuditPurchaseInfoByExample() {
        Example example = new Example(PurchaseInfo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("status", "0");
        List<PurchaseInfo> purchaseInfos = purchaseInfoMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(purchaseInfos)) {
            logger.info("PurchaseService == > selectPurchaseInfoByExample the product is null");
            return null;
        }
        return purchaseInfos;
    }

    /**
     * 检查是否存在指定状态的采购单
     * @param status
     * @return
     */
    public Boolean checkIsEmptyStatus(String status) {
        if (StringUtils.isBlank(status)) {
            logger.info("PurchaseService == > checkIsEmptyStatus the status is blank");
            return null;
        }
        Example example = new Example(PurchaseInfo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("status", status);
        List<PurchaseInfo> purchaseInfos = purchaseInfoMapper.selectByExample(example);
        return CollectionUtils.isEmpty(purchaseInfos);
    }


    /**
     * 根据采购单状态获取采购单
     */
    public List<PurchaseInfo> selectPurchaseByStatus(String status) {
        Example example = new Example(PurchaseInfo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("status", status);
        List<PurchaseInfo> purchaseInfos = purchaseInfoMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(purchaseInfos)) {
            logger.info("PurchaseService == > selectPurchaseByStatus the product is null");
            return null;
        }
        return purchaseInfos;
    }


    /**
     * 从采购单中提取出库管员能看到的数据
     */
    public InventoryByPurchaseDTO encapsulationPurchaseInfo(PurchaseInfo purchaseInfo) {
        InventoryByPurchaseDTO inventoryByPurchaseDTO = new InventoryByPurchaseDTO();
        inventoryByPurchaseDTO.setProvider(purchaseInfo.getProvider());
        inventoryByPurchaseDTO.setProviderLinkmanPhone(purchaseInfo.getProviderLinkmanPhone());
        inventoryByPurchaseDTO.setProduceName(purchaseInfo.getProduceName());
        inventoryByPurchaseDTO.setModel(purchaseInfo.getModel());
        inventoryByPurchaseDTO.setAmount(purchaseInfo.getAmount());
        inventoryByPurchaseDTO.setWarehouseAdress(purchaseInfo.getWarehouseAdress());
        inventoryByPurchaseDTO.setPurchaseProduceSum(purchaseInfo.getPurchaseProduceSum());
        inventoryByPurchaseDTO.setClearingForm(purchaseInfo.getClearingForm());
        return inventoryByPurchaseDTO;
    }


    /**
     * 从采购单中提取出入库员能看到的数据
     */
    public PurchaseInputDTO encapsulationPurchaseInfoToInputMan(PurchaseInfo purchaseInfo) {
        PurchaseInputDTO purchaseInputDTO = new PurchaseInputDTO();
        purchaseInputDTO.setPurchseId(purchaseInfo.getId());
        purchaseInputDTO.setProvider(purchaseInfo.getProvider());
        purchaseInputDTO.setProviderLinkmanPhone(purchaseInfo.getProviderLinkmanPhone());
        purchaseInputDTO.setProduceName(purchaseInfo.getProduceName());
        purchaseInputDTO.setModel(purchaseInfo.getModel());
        purchaseInputDTO.setAmount(purchaseInfo.getAmount());
        purchaseInputDTO.setWarehouseAdress(purchaseInfo.getWarehouseAdress());
        purchaseInputDTO.setPurchaseProduceSum(purchaseInfo.getPurchaseProduceSum());
        return purchaseInputDTO;
    }


    /**
     * 改变销售单的“status”状态
     */
    @Transactional(rollbackFor = Exception.class)
    public Integer updatePurchasenfoStatus(String orderNumber, String newStatus) {
        PurchaseInfo purchaseInfo = selectPurchaseInfoByExample(orderNumber).get(0);

        purchaseInfo.setStatus(newStatus);

        return updatePurchaseInfo(purchaseInfo);
    }
}
