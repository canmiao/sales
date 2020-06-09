package com.business.mapper;

import com.business.bean.InputInfo;
import com.business.utils.base.IBaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InputInfoMapper extends IBaseMapper<InputInfo> {
    List<InputInfo> selectAllInputInfo(@Param("keyWord") String keyWord);
}