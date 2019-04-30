package com.mr.parameter.controller;

import com.github.pagehelper.PageHelper;
import com.mr.parameter.service.ParameterService;
import com.mr.picture.service.PictureService;
import com.mr.pojo.Parameter;
import com.mr.utils.Page;
import com.mr.utils.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.POST;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 黄圣博 on 2019/4/29.
 */
@RestController
@RequestMapping("parameter")
public class ParameterController {
    @Autowired
    private ParameterService parameterService;
@GetMapping("selectAll")
    public  Map<String,Object> selectAll(Page page){
        List<Parameter> parameter = parameterService.selectAll(page);
    Map<String,Object> resultMap = new HashMap<String, Object>();
    resultMap.put("code",0);
    resultMap.put("msg","");
    resultMap.put("count",parameter.size());
    resultMap.put("data",parameter);
        return resultMap;
    }
    @PostMapping("insertParameter")
    public ResultVo insertParameter(Parameter parameter){
        ResultVo resultVo = parameterService.insertParameter(parameter);
        return resultVo;
    }
    @PostMapping("deleteParameter")
    public ResultVo deleteParameter(String id){
        ResultVo resultVo = parameterService.deleteParameter(id);
        return resultVo;
    }
    @GetMapping("selectById")
    public Parameter selectById(String id){
        Parameter parameter = parameterService.selectById(id);
        return parameter;
    }
    @PostMapping("updateParameter")
    public ResultVo updateParameter(Parameter parameter){
        ResultVo resultVo = parameterService.updateParameter(parameter);
        return resultVo;
    }
}
