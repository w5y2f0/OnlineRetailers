package com.mr.type.controller;

import com.github.pagehelper.PageInfo;
import com.mr.pojo.Type;
import com.mr.type.service.TypeService;
import com.mr.utils.DataGridVo;
import com.mr.utils.Page;
import com.mr.utils.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ASUS on 2019/4/30.
 * 商品类型表，字典表，控制层
 */
@Controller
@RequestMapping("type")
public class TypeController {

    @Autowired
    private TypeService typeService;


    @RequestMapping("toSelect")
    public String toSelect(){
        return "type/list_type";
    }

    //查询全部【商品类型表】
    @GetMapping("selectAll")
    @ResponseBody
    public DataGridVo<Type> selectAll(Page page){
        PageInfo<Type> pageInfo = typeService.selectAll(page);
        DataGridVo<Type> typeDataGridVo = new DataGridVo();
        typeDataGridVo.setCode(0);
        typeDataGridVo.setCount(pageInfo.getTotal());
        typeDataGridVo.setData(pageInfo.getList());
        return typeDataGridVo;
    }

    //新增
    @RequestMapping("insertType")
    @ResponseBody
    public ResultVo insertType(Type type){
        ResultVo resultVo =  typeService.insertType(type);
        return resultVo;
    }

    //删除数据
    @RequestMapping("deleteType")
    @ResponseBody
    public ResultVo deleteType(Integer typeId){
        ResultVo resultVo = typeService.deleteType(typeId);
        return resultVo;
    }

    //修改数据
    @PostMapping("updateType")
    public ResultVo updateType(Type type){
        ResultVo resultVo = typeService.updateType(type);
        return resultVo;
    }

    //根据编号查询
    @GetMapping("selectTypeById")
    public Type selectTypeById(Integer typeId){
        Type type = typeService.selectTypeById(typeId);
        return type;
    }
}
