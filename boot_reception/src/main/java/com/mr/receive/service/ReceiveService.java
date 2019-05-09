package com.mr.receive.service;

import com.mr.pojo.Coupon;
import com.mr.pojo.CouponVo;
import com.mr.pojo.Receive;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Fan on 2019/5/8.
 */
@FeignClient(value = "PROVIDER")
public interface ReceiveService {

    @RequestMapping(value = "/receive/selectReceive")
    List<Receive> selectAll();

    @RequestMapping(value = "/coupon/selectCouponVo")
    List<CouponVo> selectCouponVo();

}
