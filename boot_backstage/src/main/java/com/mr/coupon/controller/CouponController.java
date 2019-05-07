package com.mr.coupon.controller;

import com.github.pagehelper.PageHelper;
import com.mr.coupon.service.CouponService;
import com.mr.pojo.Coupon;
import com.mr.utils.Page;
import com.mr.utils.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.GET;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 黄圣博 on 2019/4/29.
 */
@Controller
@RequestMapping("coupon")
public class CouponController {
    @Autowired
    private CouponService couponService;
@GetMapping("selectAll")
@ResponseBody
    public  Map<String,Object> selectAll(Page page){
        List<Coupon> coupons = couponService.selectAll(page);
    Map<String,Object> resultMap = new HashMap<String, Object>();
    resultMap.put("code",0);
    resultMap.put("msg","");
    resultMap.put("count",coupons.size());
    resultMap.put("data",coupons);
        return resultMap;
    }
    @GetMapping("addCoupon")
    public String  addGoods(){
        return "addCoupon";
    }
    @PostMapping("insertCoupon")
    @ResponseBody
    public ResultVo insertCoupon(Coupon coupon){
        coupon.setCoStates(1);
        ResultVo resultVo = couponService.insertCoupon(coupon);
        return resultVo;
    }
    @PostMapping("deleteCoupon")
    @ResponseBody
    public ResultVo deleteCoupon(String id){
        ResultVo resultVo = couponService.deleteCoupon(id);
        return resultVo;
    }
    @GetMapping("selectById")
    @ResponseBody
    public Coupon selectById(String id){
        Coupon coupon = couponService.selectById(id);
        return coupon;
    }
    @PostMapping("updateCoupon")
    @ResponseBody
    public ResultVo updateCoupon(Coupon coupon){
        ResultVo resultVo = couponService.updateCoupon(coupon);
        return resultVo;
    }
}
