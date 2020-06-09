package com.business.service;

import com.business.bean.SaleInfo;
import com.business.bean.SaleRefundInfo;
import com.business.bean.SearchParam;
import com.business.mapper.SaleRefundInfoMapper;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
* @Description:    销售退货服务
* @Author:         ccm
* @CreateDate:     2019/3/24 10:24
*/
@Service
public class SaleRefundInfoService {
    private final static Logger logger = LoggerFactory.getLogger(SaleRefundInfoService.class);

    @Resource
    private SaleRefundInfoMapper saleRefundInfoMapper;

    /**
     * 查询所有销售退货信息
     */
    public List<SaleRefundInfo> selectAllSaleRefund(SearchParam searchParam) {
        logger.info("SaleRefundService ==> selectAllSaleRefund");
        if (searchParam.getPageNum() != null || searchParam.getPageSize() != null) {
            PageHelper.startPage(searchParam);
        }
        return saleRefundInfoMapper.selectAllSaleRefund(searchParam.getKeyWord());
    }

    /**
     * 销售退货信息查询(已测试)
     */
    public List<SaleRefundInfo> selectSaleRefundInfoByExample(String keyWord) {
        if (keyWord == null) {
            logger.info("SaleRefundInfoService == > selectSaleRefundInfoByExample the keyWord is null");
            return null;
        }
        String newKeyWord = "%"+keyWord+"%";
        Example example = new Example(SaleRefundInfo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andLike("orderNumber", newKeyWord);
        criteria.orLike("tableMakedate", newKeyWord);
        criteria.orLike("customer", newKeyWord);
        criteria.orLike("customerPhone", newKeyWord);
        criteria.orLike("returnManber", newKeyWord);
        criteria.orLike("returnManberPhone", newKeyWord);
        criteria.orLike("receiveDate", newKeyWord);
        criteria.orLike("sreturnDate", newKeyWord);
        criteria.orLike("warehouseNumber", newKeyWord);
        criteria.orLike("reasion", newKeyWord);
        criteria.orLike("product", newKeyWord);
        criteria.orLike("produceName", newKeyWord);
        criteria.orLike("model", newKeyWord);
        criteria.orLike("number", newKeyWord);
        criteria.orLike("unit", newKeyWord);
        criteria.orLike("unitPrice", newKeyWord);
        criteria.orLike("warehouseAdress", newKeyWord);
        criteria.orLike("combine", newKeyWord);
        criteria.orLike("returnGoodsNote", newKeyWord);
        criteria.orLike("audit", newKeyWord);
        criteria.orLike("keepAccount", newKeyWord);
        criteria.orLike("departmentHead", newKeyWord);
        criteria.orLike("tableMaker", newKeyWord);
        criteria.orLike("returnNote", newKeyWord);
        criteria.orLike("anotherReturnNote", newKeyWord);

        List<SaleRefundInfo> saleRefundInfos = saleRefundInfoMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(saleRefundInfos)) {
            logger.info("SaleRefundInfoService == > selectSaleRefundInfoByExample the product is null");
            return null;
        }
        return saleRefundInfos;
    }


    /**
     * 根据销售退货单号修改质检单信息(已测试)
     */
    @Transactional(rollbackFor = Exception.class)
    public Integer updateSaleRefundInfo(SaleRefundInfo saleRefundInfo) {
        if (saleRefundInfo == null) {
            logger.info("SaleRefundInfoService == > updateSaleRefundInfo the inputInfo is null");
            return null;
        }
        Example example = new Example(SaleRefundInfo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("orderNumber",saleRefundInfo.getOrderNumber());
        if (saleRefundInfoMapper.selectByExample(example).isEmpty()) {
            logger.info("SaleRefundInfoService == > updateSaleRefundInfo the orderNumber is null");
            return null;
        }
        return saleRefundInfoMapper.updateByExample(saleRefundInfo,example);
    }


    /**
     * 删除质检单(已测试)
     */
    public void deleteSaleRefundInfo(SaleRefundInfo saleRefundInfo) {
        Example example = new Example(SaleRefundInfo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("orderNumber", saleRefundInfo.getOrderNumber());
        saleRefundInfoMapper.deleteByExample(example);
    }


    /**
     * 添加质检单(已测试)
     */
    public void insetSaleRefundInfo(SaleRefundInfo saleRefundInfo) {
        saleRefundInfoMapper.insert(saleRefundInfo);
    }
}
