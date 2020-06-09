package com.business.mapper;

import com.business.bean.SaleInfo;
import com.business.utils.base.IBaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SaleInfoMapper extends IBaseMapper<SaleInfo> {
    List<SaleInfo> selectAllSaleInfo(@Param("keyWord") String keyWord);
}