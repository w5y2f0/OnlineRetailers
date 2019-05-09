package com.mr.coupon.service;

import com.github.pagehelper.PageHelper;
import com.mr.pojo.Coupon;
import com.mr.pojo.CouponVo;
import com.mr.utils.Page;
import com.mr.utils.ResultVo;

import java.util.List;

/**
 * Created by 黄圣博 on 2019/4/29.
 */
public interface  CouponService {
    public List<Coupon> selectAll(Page page);
    public List<CouponVo> selectAll();
    public ResultVo insertCoupon(Coupon coupon);
    public ResultVo deleteCoupon(String id);
    public Coupon selectById(String id);
    public ResultVo updateCoupon(Coupon coupon);
}
