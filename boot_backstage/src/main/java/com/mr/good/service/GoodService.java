package com.mr.good.service;

import com.mr.pojo.Goods;
import com.mr.pojo.Goods;
import com.mr.utils.Page;
import com.mr.utils.ResultVo;

import java.util.List;

/**
 * Created by 黄圣博 on 2019/4/29.
 */
public interface GoodService {
    public List<Goods> selectAll(Page page);
    public ResultVo insertGood(Goods goods);
    public ResultVo deleteGood(String goodid);
    public ResultVo updateGood(Goods goods);
    public Goods selectById(String goodid);
}
