package com.mr.receive.service.impl;

import com.github.pagehelper.PageHelper;
import com.mr.pojo.Picture;
import com.mr.pojo.Receive;
import com.mr.receive.mapper.ReceiveMapper;
import com.mr.receive.service.ReceiveService;
import com.mr.utils.Page;
import com.mr.utils.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 黄圣博 on 2019/4/29.
 */
@Service
public class ReceiveServiceImpl implements ReceiveService {
    @Autowired
    private ReceiveMapper receiveMapper;

    public List<Receive> selectAll(Page page){
        PageHelper.startPage(page.getPage(),page.getLimit());
        List<Receive> list= receiveMapper.selectAll();
        return list;
    }
    public ResultVo insertReceive(Receive parameter){
        int insert = receiveMapper.insert(parameter);
        if(insert>0){
            return ResultVo.success("领取成功");
        }else{
            return ResultVo.error(500,"领取失败");
        }
    }
    public ResultVo deleteReceive(String id){
        int i = receiveMapper.deleteByPrimaryKey(Integer.parseInt(id));
        if (i>0){
            return ResultVo.success("删除成功");
        }else{
            return ResultVo.error(500,"删除错误");
        }
    }
    public Receive selectById(String id){
        Receive parameter = receiveMapper.selectByPrimaryKey(Integer.parseInt(id));
        return parameter;
    }
    public ResultVo updatePicture(Receive parameter){
        int i = receiveMapper.updateByPrimaryKey(parameter);
        if(i>0){
            return ResultVo.success("修改成功");
        }else{
            return ResultVo.error(500,"失败");
        }
    }
}
