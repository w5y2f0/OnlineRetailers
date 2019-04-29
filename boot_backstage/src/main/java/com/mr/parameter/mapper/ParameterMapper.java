package com.mr.parameter.mapper;

import com.mr.parameter.pojo.Parameter;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ParameterMapper {
    int deleteByPrimaryKey(Integer parId);

    int insert(Parameter record);

    int insertSelective(Parameter record);

    Parameter selectByPrimaryKey(Integer parId);

    int updateByPrimaryKeySelective(Parameter record);

    int updateByPrimaryKey(Parameter record);
}