package com.mr.type.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mr.pojo.Type;
import com.mr.type.mapper.TypeMapper;
import com.mr.type.service.TypeService;
import com.mr.utils.Page;
import com.mr.utils.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ASUS on 2019/4/30.
 */
@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeMapper typeMapper;

    //查询所有
    @Override
    public PageInfo<Type> selectAll(Page page) {
        if(page == null){
            page = new Page();
        }
        PageHelper.startPage(page.getPage(),page.getLimit());
        List<Type> typeList = typeMapper.selectAll();
        PageInfo<Type> typePageInfo = new PageInfo<>(typeList);
        return typePageInfo;
    }

    //新增
    @Override
    public ResultVo insertType(Type type) {
            typeMapper.insertType(type);
            return ResultVo.success("商品类型信息，新增成功！！！");
    }


    //根据编号删除
    @Override
    public ResultVo deleteType(Integer typeId) {
        typeMapper.deleteType(typeId);
        return ResultVo.success("商品类型信息，删除成功！！！");
    }

    //修改数据
    @Override
    public ResultVo updateType(Type type) {
        typeMapper.updateType(type);
        return ResultVo.success("商品类型信息，修改成功！！！");
    }

    //根据编号查询对应数据
    @Override
    public Type selectTypeById(Integer typeId) {
       Type type = typeMapper.selectTypeById(typeId);
       return type;
    }
}
