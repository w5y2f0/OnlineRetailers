package com.mr.picture.service;

import com.github.pagehelper.PageHelper;
import com.mr.pojo.Picture;
import com.mr.utils.Page;
import com.mr.utils.ResultVo;

import java.util.List;

/**
 * Created by 黄圣博 on 2019/4/29.
 *
 */
public interface PictureService {

    public List<Picture> selectAll(Page page);
    public ResultVo insertPicture(Picture parameter);
    public ResultVo deletePicture(String id);
    public Picture selectById(String id);
    public ResultVo updatePicture(Picture parameter);
}
