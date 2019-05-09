package com.mr.coupon.mapper;

import com.mr.pojo.Coupon;
import com.mr.pojo.CouponVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CouponMapper  {

//    default int qwer(Integer coId){
//        return 1;
//    }
    int deleteByPrimaryKey(Integer coId);

    int insert(Coupon record);

    int insertSelective(Coupon record);

    Coupon selectByPrimaryKey(Integer coId);

    int updateByPrimaryKeySelective(Coupon record);

    int updateByPrimaryKey(Coupon record);

    List<Coupon> selectAll();

    List<CouponVo> selectCouponVo();
}