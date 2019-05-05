package com.mr.index.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Fan on 2019/4/29.
 */
@Controller
public class indexController {

    @RequestMapping("shopcart")
    public ModelAndView toShopCart(){
        ModelAndView view  =new ModelAndView("shopcart");
        return view;
    }
}
