package com.mr.type.controller;

import com.github.pagehelper.PageInfo;
import com.mr.pojo.Type;
import com.mr.type.service.TypeService;
import com.mr.utils.DataGridVo;
import com.mr.utils.Page;
import com.mr.utils.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ASUS on 2019/4/30.
 * 商品类型表，字典表，控制层
 */
@RestController
@RequestMapping("type")
public class TypeController {

    @Autowired
    private TypeService typeService;

    //查询全部【商品类型表】
    @GetMapping("selectAll")
    public Map<String,Object> selectAll(Page page){
        List<Type> typeList = typeService.selectAll(page);
        Map<String,Object> resultMap = new HashMap<String,Object>();
        resultMap.put("code",0);
        resultMap.put("msg","");
        resultMap.put("count",typeList.size());
        resultMap.put("data",typeList);
        return resultMap;
    }

    //新增
    @PostMapping("insertType")
    public ResultVo insertType(Type type){
        ResultVo resultVo =  typeService.insertType(type);
        return resultVo;
    }

    //删除数据
    @PostMapping("deleteType")
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
