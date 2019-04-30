package com.mr.parameter.service.impl;

import com.github.pagehelper.PageHelper;
import com.mr.parameter.mapper.ParameterMapper;
import com.mr.parameter.service.ParameterService;
import com.mr.pojo.Parameter;
import com.mr.utils.Page;
import com.mr.utils.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 黄圣博 on 2019/4/29.
 */
@Service
public class ParameterServiceImpl implements ParameterService {
    @Autowired
    private ParameterMapper parameterMapper;

    public List<Parameter> selectAll(Page page){
        PageHelper.startPage(page.getPage(),page.getLimit());
        List<Parameter> parameter = parameterMapper.selectAll();
        return parameter;
    }
    public ResultVo insertParameter(Parameter parameter){
        int insert = parameterMapper.insert(parameter);
        if(insert>0){
            return ResultVo.success("添加成功");
        }else{
            return ResultVo.error(500,"添加失败");
        }
    }
    public ResultVo deleteParameter(String id){
        int i = parameterMapper.deleteByPrimaryKey(Integer.parseInt(id));
        if (i>0){
            return ResultVo.success("删除成功");
        }else{
            return ResultVo.error(500,"删除错误");
        }
    }
    public Parameter selectById(String id){
        Parameter parameter = parameterMapper.selectByPrimaryKey(Integer.parseInt(id));
        return parameter;
    }
    public ResultVo updateParameter(Parameter parameter){
        int i = parameterMapper.updateByPrimaryKey(parameter);
        if(i>0){
            return ResultVo.success("修改成功");
        }else{
            return ResultVo.error(500,"修改失败");
        }
    }
}
