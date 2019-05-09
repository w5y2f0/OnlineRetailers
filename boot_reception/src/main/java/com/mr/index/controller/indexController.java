package com.mr.index.controller;

import com.mr.address.Address;
import com.mr.address.service.AddressService;
import com.mr.index.service.IndexService;
import com.mr.pojo.CouponVo;
import com.mr.pojo.Goods;
import com.mr.pojo.GoodsSolr;
import com.mr.pojo.GoodsVo;
import com.mr.receive.service.ReceiveService;
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
    private ReceiveService receiveService;
    @Autowired
    private IndexService indexService;

    @Autowired
    private AddressService addressService;

    @RequestMapping("toReceive")
    public ModelAndView selectReceive() {
        ModelAndView view = new ModelAndView("coupon");

        List<CouponVo> couponVoList = receiveService.selectCouponVo();

        view.addObject("couponVoList", couponVoList);
        return view;
    }

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
    public ModelAndView toSearch(String name) {
        if(null == name|| name.equals("")){
            name="*";
        }
        List<GoodsSolr> goods = indexService.selectsolr(name);
        System.err.println(goods);

        ModelAndView view = new ModelAndView("search");
        view.addObject("data",goods);
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

    @RequestMapping("Search")
    @ResponseBody
    public List Search(String type) {
        List<GoodsVo> goods = indexService.selectByType(type);
        return goods;
    }
}