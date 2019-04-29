package com.mr.good.service.impl;

import com.github.pagehelper.PageHelper;
import com.mr.good.mapper.GoodsMapper;
import com.mr.good.pojo.Goods;
import com.mr.good.service.GoodService;
import com.mr.utils.Page;
import com.mr.utils.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 黄圣博 on 2019/4/29.
 */
@Service
public class GoodServiceImpl implements GoodService {
    @Autowired
    private GoodsMapper goodsMapper;

    public List<Goods> selectAll(Page page){
        PageHelper.startPage(page.getPage(),page.getLimit());
        List<Goods> goods = goodsMapper.selectAll();
        return goods;
    }
    public ResultVo insertGood(Goods goods){
        int insert = goodsMapper.insert(goods);
        if(insert>0){
            return ResultVo.success("商品添加成功");
        }else{
            return ResultVo.error(500,"商品添加失败");
        }
    }
    public ResultVo deleteGood(String goodid){
        int i = goodsMapper.deleteByPrimaryKey(Integer.parseInt(goodid));
        if(i>0){
            return ResultVo.success("商品删除成功");
        }else{
            return ResultVo.error(500,"商品删除失败");
        }
    }
    public ResultVo updateGood(Goods goods){
        int i = goodsMapper.updateByPrimaryKeySelective(goods);
        if(i>0){
            return ResultVo.success("商品修改成功");
        }else{
            return ResultVo.error(500,"商品修改失败");
        }
    }
    public Goods selectById(String goodid){
        Goods goods = goodsMapper.selectByPrimaryKey(Integer.parseInt(goodid));
        return goods;
    }
}
