package com.mr.picture.mapper;

import com.mr.pojo.Picture;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PictureMapper {
    int deleteByPrimaryKey(Integer piId);

    int insert(Picture record);

    int insertSelective(Picture record);

    Picture selectByPrimaryKey(Integer piId);

    int updateByPrimaryKeySelective(Picture record);

    int updateByPrimaryKey(Picture record);
}