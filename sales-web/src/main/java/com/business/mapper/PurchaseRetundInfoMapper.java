package com.business.mapper;

import com.business.bean.PurchaseRetundInfo;
import com.business.utils.base.IBaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PurchaseRetundInfoMapper extends IBaseMapper<PurchaseRetundInfo> {
    List<PurchaseRetundInfo> selectAllPurchaseRetundInfo(@Param("keyWord") String keyWord);
}