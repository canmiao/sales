package com.business.service;

import com.business.bean.*;
import com.business.dto.InventoryDTO;
import com.business.dto.PurchaseRefundInfoDTO;
import com.business.mapper.InventoryInfoMapper;
import com.github.pagehelper.PageHelper;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;


import javax.annotation.Resource;
import java.util.List;

/**
 *@Auther: ccm
 *@Description: inventory service
 *@Date: 2019/3/3 16:05
 */
@Service
public class InventoryInfoService {

    private final static Logger logger = LoggerFactory.getLogger(OutputInfoService.class);

    @Resource
    private InventoryInfoMapper inventoryInfoMapper;

    /**
     * 查询所有库存信息
     */
    public List<InventoryInfo> selectAllInventotyInfoByExample() {
        return inventoryInfoMapper.selectAll();
    }


    /**
     * 查询是否存在库存
     */
    public Boolean checkByProductName(String product) {
        if (StringUtils.isBlank(product)) {
            logger.info("InventoryInfoService == > checkByProductName the username is blank");
            return null;
        }
        Example example = new Example(InventoryInfo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("productName", product);
        List<InventoryInfo> inventoryInfos = inventoryInfoMapper.selectByExample(example);
        return CollectionUtils.isEmpty(inventoryInfos);
    }

    /**
     * 库存信息查询(原版)
     */
    public List<InventoryInfo> selectInventotyInfoByExample(String keyWord) {
        if (keyWord == null) {
            logger.info("InventoryInfoService == > selectInventotyInfoByExample the keyWord is null");
            return null;
        }
        Example example = new Example(InventoryInfo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("productName", keyWord);
        List<InventoryInfo> inventoryInfos = inventoryInfoMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(inventoryInfos)) {
            logger.info("InventoryInfoService == > selectInventotyInfoByExample the product is null");
            return null;
        }
        return inventoryInfos;
    }


    /**
     * 查询库存（新版）
     * @param searchParam
     * @return
     */
    public List<InventoryInfo> selectAllInventoryInfo(SearchParam searchParam) {
        logger.info("InventoryService ==> selectAllInventoryInfo");
        if (searchParam.getPageNum() != null || searchParam.getPageSize() != null) {
            PageHelper.startPage(searchParam);
        }
        return inventoryInfoMapper.selectAllInventoryInfo(searchParam.getKeyWord());
    }


    /**
     * 商品出库时，减少库存数量
     */
    @Transactional(rollbackFor = Exception.class)
    public Integer updateInventoryInfoNmuber(String productName, int  number) {
        InventoryInfo inventoryInfo = selectInventotyInfoByExample(productName).get(0);
        if (inventoryInfo == null) {
            logger.info("InventoryInfoService  ==>  updateInventoryInfoNmuber inventotyinfo is null");
            return null;
        }
        inventoryInfo.setNumber(inventoryInfo.getNumber() - number);
        return updateInventoryInfo(inventoryInfo);
    }


    /**
     * 修改库存单信息
     */
    @Transactional(rollbackFor = Exception.class)
    public Integer updateInventoryInfo(InventoryInfo inventoryInfo) {
        if (inventoryInfo == null) {
            logger.info("InventoryInfoService == > updateInventoryInfo the inputInfo is null");
            return null;
        }
        Example example = new Example(InventoryInfo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("productName",inventoryInfo.getProductName());
        if (inventoryInfoMapper.selectByExample(example).isEmpty()) {
            logger.info("InventoryInfoService == > updateInventoryInfo the orderNumber is null");
            return null;
        }
        return inventoryInfoMapper.updateByExample(inventoryInfo,example);
    }


    /**
     * 删除库存单
     */
    public void deleteInventoryInfo(InventoryInfo inventoryInfo) {
        Example example = new Example(InventoryInfo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("productName", inventoryInfo.getProductName());
        inventoryInfoMapper.deleteByExample(example);
    }


    /**
     * 添加出库单（已测试）
     */
    public void insetInventoryInfo(InventoryInfo inventoryInfo) {
        inventoryInfoMapper.insert(inventoryInfo);
    }



    /**
     * 更新库存数量入库时使用
     */
    public void updateInventoryInfoIncreaseNmuber(InventoryInfo inventoryInfo) {
        if (inventoryInfo == null) {
            logger.info("InventoryService == > updateInventoryInfoIncreaseNmuber the productName or number is isEmpty");
        }
        List<InventoryInfo> inventoryInfos = selectInventotyInfoByExample(inventoryInfo.getProductName());
        //库存中无此类商品
        if (CollectionUtils.isEmpty(inventoryInfos) ){
            insetInventoryInfo(inventoryInfo);
        }
        //库存中还剩有此类商品
        int newNumber = inventoryInfos.get(0).getNumber() + inventoryInfo.getNumber();
        inventoryInfo.setNumber(newNumber);
        updateInventoryInfo(inventoryInfo);
    }


    /**
     * 从入库单中封装库存数据
     */
    public InventoryInfo encapsulationInputInfo(InputInfo inputInfo) {
        InventoryInfo inventoryInfo = new InventoryInfo();
        inventoryInfo.setProductName(inputInfo.getProduct());
        inventoryInfo.setNumber(inputInfo.getNumber());
        return inventoryInfo;
    }


    /**
     * 从库存中提取数据
     */
    public InventoryDTO encapsulationInventoryInfoByInventory(InventoryInfo inventoryInfo) {
        InventoryDTO inventoryDTO = new InventoryDTO();
        inventoryDTO.setProductName(inventoryInfo.getProductName());
        inventoryDTO.setNumber(inventoryInfo.getNumber());
        return inventoryDTO;
    }
}
