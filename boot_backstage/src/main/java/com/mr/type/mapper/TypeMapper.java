package com.mr.type.mapper;

import com.mr.pojo.Type;

import java.util.List;

/**
 * Created by ASUS on 2019/4/30.
 */
public interface TypeMapper {
    //查询
    List<Type> selectAll();

    //新增
    void insertType(Type type);

    //删除
    void deleteType(Integer typeId);

    //修改
    void updateType(Type type);

    //根据编号查询对应数据
    Type selectTypeById(Integer typeId);
}
