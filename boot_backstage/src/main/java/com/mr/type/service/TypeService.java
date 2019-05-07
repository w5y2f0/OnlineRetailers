package com.mr.type.service;

import com.github.pagehelper.PageInfo;
import com.mr.pojo.Type;
import com.mr.utils.Page;
import com.mr.utils.ResultVo;

import java.util.List;

/**
 * Created by ASUS on 2019/4/30.
 */
public interface TypeService {
    //查询所有
    PageInfo<Type> selectAll(Page page);

    //新增
    ResultVo insertType(Type type);

    //删除
    ResultVo deleteType(Integer typeId);

    //修改
    ResultVo updateType(Type type);

    //根据编号查询
    Type selectTypeById(Integer typeId);


}
