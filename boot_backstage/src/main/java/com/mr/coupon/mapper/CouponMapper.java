package com.mr.coupon.mapper;

import com.mr.pojo.Coupon;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CouponMapper  {
    int deleteByPrimaryKey(Integer coId);

    int insert(Coupon record);

    int insertSelective(Coupon record);

    Coupon selectByPrimaryKey(Integer coId);

    int updateByPrimaryKeySelective(Coupon record);

    int updateByPrimaryKey(Coupon record);
}