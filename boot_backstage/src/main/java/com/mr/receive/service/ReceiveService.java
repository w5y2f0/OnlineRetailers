package com.mr.receive.service;

import com.github.pagehelper.PageHelper;
import com.mr.pojo.Receive;
import com.mr.utils.Page;
import com.mr.utils.ResultVo;

import java.util.List;

/**
 * Created by 黄圣博 on 2019/4/29.
 */
public interface ReceiveService {

    public List<Receive> selectAll(Page page);
    public ResultVo insertReceive(Receive parameter);
    public ResultVo deleteReceive(String id);
    public Receive selectById(String id);
    public ResultVo updateReceive(Receive parameter);
}
