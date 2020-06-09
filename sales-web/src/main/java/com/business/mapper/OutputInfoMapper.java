package com.business.mapper;

import com.business.bean.OutputInfo;
import com.business.utils.base.IBaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OutputInfoMapper extends IBaseMapper<OutputInfo> {
    List<OutputInfo> selectAllOutput(@Param("keyWord") String keyWord);
}