package com.mr.index.controller;

import com.mr.address.Address;
import com.mr.address.service.AddressService;
import com.mr.index.service.IndexService;
import com.mr.pojo.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Fan on 2019/4/29.
 */
@Controller
public class indexController {

    @Autowired
    private IndexService indexService;

    @Autowired
    private AddressService addressService;

    @RequestMapping("shopcart")
    public ModelAndView toShopCart() {
        ModelAndView view = new ModelAndView("shopcart");
        return view;
    }

    @RequestMapping("personalCenter")
    public ModelAndView toPersonalCenter() {
        ModelAndView view = new ModelAndView("personalCenter");
        return view;
    }

    @RequestMapping("register")
    public ModelAndView toRegister() {
        ModelAndView view = new ModelAndView("register");
        return view;
    }

    @RequestMapping("toIndex")
    public ModelAndView toIndex() {
        ModelAndView view = new ModelAndView("index");
        return view;
    }

    @RequestMapping("toSearch")
    public ModelAndView toSearch() {
        ModelAndView view = new ModelAndView("search");
        return view;
    }

    @RequestMapping("toPay")
    public ModelAndView topay() {
        ModelAndView view = new ModelAndView("pay");
        return view;
    }

    @RequestMapping("toFoot")
    public ModelAndView toFoot() {
        ModelAndView view = new ModelAndView("foot");
        List<Goods> goodsList = indexService.selectAllFoot();
        view.addObject("goodsList", goodsList);
        return view;
    }

    @RequestMapping("toAddress")
    public ModelAndView toAddress() {
        ModelAndView view = new ModelAndView("address");
        List<Address> addressList = addressService.selectAllAddress();
        view.addObject("addressList", addressList);
        return view;
    }

    //-----------------------------------------------------------------------------------
    @RequestMapping("addFoot")
    @ResponseBody
    public void addFoot(Goods goods) {
        indexService.addFoot(goods);
    }

    @RequestMapping("addAddress")
    @ResponseBody
    public void addAddress(Address address) {
        addressService.addAdddress(address);
    }

    @RequestMapping("deleteAddress")
    @ResponseBody
    public void deleteAddress(Integer aId){
        addressService.deleteAddress(aId);
    }
}