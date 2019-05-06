package com.mr.foot.controller;

import com.mr.foot.serivce.FootService;
import com.mr.pojo.Foot;
import com.mr.pojo.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Fan on 2019/5/6.
 */
@Controller
@RequestMapping("foot")
public class FootController {

    @Autowired
    private FootService footService;

    public void addFoot(Goods goods) {
        footService.insertFoot(goods);
    }

    public List<Foot> selectAllFoot() {
        return footService.selectAllFoot();
    }
}
