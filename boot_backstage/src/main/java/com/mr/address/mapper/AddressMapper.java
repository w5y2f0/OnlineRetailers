package com.mr.address.mapper;


import com.mr.address.Address;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AddressMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Address record);

    int insertSelective(Address record);

    Address selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Address record);

    int updateByPrimaryKey(Address record);
}