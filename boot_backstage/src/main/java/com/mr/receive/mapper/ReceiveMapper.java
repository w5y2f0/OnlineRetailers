package com.mr.receive.mapper;

import com.mr.pojo.Receive;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReceiveMapper {
    int deleteByPrimaryKey(Integer reId);

    int insert(Receive record);

    int insertSelective(Receive record);

    Receive selectByPrimaryKey(Integer reId);

    int updateByPrimaryKeySelective(Receive record);

    int updateByPrimaryKey(Receive record);
}