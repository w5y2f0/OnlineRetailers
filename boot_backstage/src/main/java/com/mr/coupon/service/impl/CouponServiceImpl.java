package com.mr.coupon.service.impl;

import com.github.pagehelper.PageHelper;
import com.mr.coupon.mapper.CouponMapper;
import com.mr.coupon.service.CouponService;
import com.mr.pojo.Coupon;
import com.mr.utils.Page;
import com.mr.utils.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 黄圣博 on 2019/4/29.
 */
@Service
public class CouponServiceImpl implements CouponService {
    @Autowired
    private CouponMapper couponMapper;

    public List<Coupon> selectAll(Page page){
        PageHelper.startPage(page.getPage(),page.getLimit());
        List<Coupon> coupons = couponMapper.selectAll();
        return coupons;
    }
    public ResultVo insertCoupon(Coupon coupon){
        int insert = couponMapper.insert(coupon);
        if(insert>0){
            return ResultVo.success("优惠券添加成功");
        }else{
            return ResultVo.error(500,"优惠券添加失败");
        }
    }
    public ResultVo deleteCoupon(String id){
        int i = couponMapper.deleteByPrimaryKey(Integer.parseInt(id));
        if (i>0){
            return ResultVo.success("优惠券删除成功");
        }else{
            return ResultVo.error(500,"优惠券删除错误");
        }
    }
    public Coupon selectById(String id){
        Coupon coupon = couponMapper.selectByPrimaryKey(Integer.parseInt(id));
        return coupon;
    }
    public ResultVo updateCoupon(Coupon coupon){
        int i = couponMapper.updateByPrimaryKey(coupon);
        if(i>0){
            return ResultVo.success("优惠券信息修改成功");
        }else{
            return ResultVo.error(500,"优惠券信息修改失败");
        }
    }
}
