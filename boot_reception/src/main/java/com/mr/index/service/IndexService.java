package com.mr.index.service;

import com.mr.pojo.Goods;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
}
