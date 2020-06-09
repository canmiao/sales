package com.business.mapper;

import com.business.bean.InventoryInfo;
import com.business.utils.base.IBaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InventoryInfoMapper extends IBaseMapper<InventoryInfo> {
    List<InventoryInfo> selectAllInventoryInfo(@Param("keyWord") String keyWord);
}