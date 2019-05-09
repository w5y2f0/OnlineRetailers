package com.mr.index.service;

import com.mr.pojo.Goods;
import com.mr.pojo.GoodsSolr;
import com.mr.pojo.GoodsVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Fan on 2019/5/5.
 */
@FeignClient(value = "PROVIDER")
public interface IndexService {

    @RequestMapping(value = "/foot/selectAllFoot",method = RequestMethod.GET)
    List<Goods> selectAllFoot();

    @RequestMapping(value = "/foot/addFoot")
    void addFoot(Goods goods);

    @RequestMapping(value = "/goods/selectByType",method = RequestMethod.GET)
    List<GoodsVo> selectByType(@RequestParam("type") String type);

    @RequestMapping(value = "/goods/selectsolr",method = RequestMethod.GET)
    List<GoodsSolr> selectsolr(@RequestParam("name") String name);
}
