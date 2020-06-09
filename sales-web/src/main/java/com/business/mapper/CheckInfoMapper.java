package com.business.mapper;

import com.business.bean.CheckInfo;
import com.business.bean.PurchaseInfo;
import com.business.utils.base.IBaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CheckInfoMapper extends IBaseMapper<CheckInfo> {
    List<CheckInfo> selectAllCheckInfo(@Param("keyWord") String keyWord);
}