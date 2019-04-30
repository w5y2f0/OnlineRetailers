package com.mr.picture.controller;

import com.github.pagehelper.PageHelper;
import com.mr.picture.service.PictureService;
import com.mr.picture.service.impl.PictureServiceImpl;
import com.mr.pojo.Picture;
import com.mr.utils.Page;
import com.mr.utils.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 黄圣博 on 2019/4/29.
 */
public class PictureController {
    @Autowired
    private PictureService pictureService;

    public  Map<String,Object> selectAll(Page page){
        List<Picture> list= pictureService.selectAll(page);
        Map<String,Object> resultMap = new HashMap<String, Object>();
        resultMap.put("code",0);
        resultMap.put("msg","");
        resultMap.put("count",list.size());
        resultMap.put("data",list);
        return resultMap;
    }
    public ResultVo insertPicture(Picture parameter){
        ResultVo resultVo = pictureService.insertPicture(parameter);
        return resultVo;
    }
    public ResultVo deletePicture(String id){
        ResultVo resultVo = pictureService.deletePicture(id);
        return resultVo;
    }
    public Picture selectById(String id){
        Picture parameter = pictureService.selectById(id);
        return parameter;
    }
    public ResultVo updatePicture(Picture parameter){
        ResultVo resultVo = pictureService.updatePicture(parameter);
        return resultVo;
    }
}
