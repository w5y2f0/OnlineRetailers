package com.mr.parameter.service;

import com.github.pagehelper.PageHelper;
import com.mr.pojo.Parameter;
import com.mr.utils.Page;
import com.mr.utils.ResultVo;

import java.util.List;

/**
 * Created by 黄圣博 on 2019/4/29.
 */
public interface ParameterService {

    public List<Parameter> selectAll(Page page);
    public ResultVo insertParameter(Parameter parameter);
    public ResultVo deleteParameter(String id);
    public Parameter selectById(String id);
    public ResultVo updateParameter(Parameter parameter);
}
