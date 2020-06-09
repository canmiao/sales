package com.business.mapper;

import com.business.bean.SaleInfo;
import com.business.bean.SaleRefundInfo;
import com.business.utils.base.IBaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SaleRefundInfoMapper extends IBaseMapper<SaleRefundInfo> {
    List<SaleRefundInfo> selectAllSaleRefund(@Param("keyWord") String keyWord);
}
