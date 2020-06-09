package com.business.mapper;

import com.business.bean.PurchaseInfo;
import com.business.utils.base.IBaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PurchaseInfoMapper extends IBaseMapper<PurchaseInfo> {
    List<PurchaseInfo> selectAllPurchaseInfo(@Param("keyWord") String keyWord);
}