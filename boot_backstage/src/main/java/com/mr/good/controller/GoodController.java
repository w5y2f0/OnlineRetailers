package com.mr.good.controller;

import com.mr.pojo.Goods;
import com.mr.good.service.GoodService;
import com.mr.utils.Page;
import com.mr.utils.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 黄圣博 on 2019/4/29.
 */
@RestController
@RequestMapping("goods")
public class GoodController {
    @Autowired
    private GoodService goodService;

    @GetMapping(value = "selectAll")
    public  Map<String,Object> selectAll(Page page){
        List<Goods> goods = goodService.selectAll(page);
        Map<String,Object> resultMap = new HashMap<String, Object>();
        resultMap.put("code",0);
        resultMap.put("msg","");
        resultMap.put("count",goods.size());
        resultMap.put("data",goods);
        return resultMap;
    }
    @PostMapping(value = "insertGood")
    public ResultVo insertGood(Goods goods){
        ResultVo resultVo = goodService.insertGood(goods);
        return resultVo;
    }
    @PostMapping(value = "deleteGood")
    public ResultVo deleteGood(String id){
        ResultVo resultVo = goodService.deleteGood(id);
        return resultVo;
    }
    @PostMapping("updateGood")
    public ResultVo updateGood(Goods goods){
        ResultVo resultVo = goodService.updateGood(goods);
        return resultVo;
    }
    @GetMapping("selectById")
    public Goods selectById(String id){
        Goods goods = goodService.selectById(id);
        return goods;
    }
}
