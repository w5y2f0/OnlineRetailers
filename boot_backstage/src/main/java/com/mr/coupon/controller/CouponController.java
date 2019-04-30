package com.mr.coupon.controller;

import com.github.pagehelper.PageHelper;
import com.mr.coupon.service.CouponService;
import com.mr.pojo.Coupon;
import com.mr.utils.Page;
import com.mr.utils.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.GET;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 黄圣博 on 2019/4/29.
 */
@RestController
@RequestMapping("coupon")
public class CouponController {
    @Autowired
    private CouponService couponService;
@GetMapping("selectAll")
    public  Map<String,Object> selectAll(Page page){
        List<Coupon> coupons = couponService.selectAll(page);
    Map<String,Object> resultMap = new HashMap<String, Object>();
    resultMap.put("code",0);
    resultMap.put("msg","");
    resultMap.put("count",coupons.size());
    resultMap.put("data",coupons);
        return resultMap;
    }
    @PostMapping("insertCoupon")
    public ResultVo insertCoupon(Coupon coupon){
        ResultVo resultVo = couponService.insertCoupon(coupon);
        return resultVo;
    }
    @PostMapping("deleteCoupon")
    public ResultVo deleteCoupon(String id){
        ResultVo resultVo = couponService.deleteCoupon(id);
        return resultVo;
    }
    @GetMapping("selectById")
    public Coupon selectById(String id){
        Coupon coupon = couponService.selectById(id);
        return coupon;
    }
    @PostMapping("updateCoupon")
    public ResultVo updateCoupon(Coupon coupon){
        ResultVo resultVo = couponService.updateCoupon(coupon);
        return resultVo;
    }
}
