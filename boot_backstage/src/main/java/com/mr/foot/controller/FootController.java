package com.mr.foot.controller;

import com.mr.foot.serivce.FootService;
import com.mr.pojo.Foot;
import com.mr.pojo.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Fan on 2019/5/6.
 */
@Controller
@RequestMapping("foot")
public class FootController {

    @Autowired
    private FootService footService;

    @RequestMapping("addFoot")
    public void addFoot(Goods goods) {
        footService.insertFoot(goods);
    }

    @RequestMapping("selectAllFoot")
    @ResponseBody
    public List<Goods> selectAllFoot() {
        List<Goods> footList = footService.selectAllFoot();
        return footList;
    }
}
