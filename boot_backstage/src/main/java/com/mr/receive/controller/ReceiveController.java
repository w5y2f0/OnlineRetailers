package com.mr.receive.controller;

import com.mr.pojo.Coupon;
import com.mr.pojo.Receive;
import com.mr.receive.service.ReceiveService;
import com.mr.utils.Page;
import com.mr.utils.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 黄圣博 on 2019/4/29.
 */
@RestController
@RequestMapping("receive")
public class ReceiveController {
    @Autowired
    private ReceiveService receiveService;

    @GetMapping("selectAll")
    @ResponseBody
    public Map<String,Object> selectAll(Page page){
        List<Receive> coupons = receiveService.selectAll(page);
        Map<String,Object> resultMap = new HashMap<String, Object>();
        resultMap.put("code",0);
        resultMap.put("msg","");
        resultMap.put("count",coupons.size());
        resultMap.put("data",coupons);
        return resultMap;
    }
    @GetMapping("addReceive")
    public String  addGoods(){
        return "addCoupon";
    }
    @PostMapping("insertReceive")
    @ResponseBody
    public ResultVo insertReceive(Receive receive){
        ResultVo resultVo = receiveService.insertReceive(receive);
        return resultVo;
    }
    @PostMapping("deleteReceive")
    @ResponseBody
    public ResultVo deleteReceive(String id){
        ResultVo resultVo = receiveService.deleteReceive(id);
        return resultVo;
    }
    @GetMapping("selectById")
    @ResponseBody
    public Receive selectById(String id){
        Receive coupon = receiveService.selectById(id);
        return coupon;
    }
    @PostMapping("updateReceive")
    @ResponseBody
    public ResultVo updateCoupon(Receive receive){
        ResultVo resultVo = receiveService.updateReceive(receive);
        return resultVo;
    }
}
