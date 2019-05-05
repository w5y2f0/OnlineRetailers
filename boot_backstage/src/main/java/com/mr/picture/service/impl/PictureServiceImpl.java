package com.mr.picture.service.impl;

import com.github.pagehelper.PageHelper;
import com.mr.picture.mapper.PictureMapper;
import com.mr.picture.service.PictureService;
import com.mr.pojo.Parameter;
import com.mr.pojo.Picture;
import com.mr.utils.Page;
import com.mr.utils.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 黄圣博 on 2019/4/29.
 */
@Service
public class PictureServiceImpl implements PictureService {
    @Autowired
    private PictureMapper pictureMapper;

    public List<Picture> selectAll(){
        List<Picture> list= pictureMapper.selectAll();
        return list;
    }
    public ResultVo insertPicture(Picture parameter){
        int insert = pictureMapper.insert(parameter);
        if(insert>0){
            return ResultVo.success("图片添加成功");
        }else{
            return ResultVo.error(500,"添加失败");
        }
    }
    public ResultVo deletePicture(String id){
        int i = pictureMapper.deleteByPrimaryKey(Integer.parseInt(id));
        if (i>0){
            return ResultVo.success("图片删除成功");
        }else{
            return ResultVo.error(500,"删除错误");
        }
    }
    public Picture selectById(String id){
        Picture parameter = pictureMapper.selectByPrimaryKey(Integer.parseInt(id));
        return parameter;
    }
    public ResultVo updatePicture(Picture parameter){
        int i = pictureMapper.updateByPrimaryKey(parameter);
        if(i>0){
            return ResultVo.success("图片修改成功");
        }else{
            return ResultVo.error(500,"修改失败");
        }
    }
}
