package com.mr.address.controller;

import com.github.pagehelper.PageInfo;
import com.mr.address.Address;
import com.mr.address.service.AddressService;
import com.mr.utils.DataGridVo;
import com.mr.utils.Page;
import com.mr.utils.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Fan on 2019/4/30.
 */
@Controller
@RequestMapping("address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @RequestMapping("selectAll")
    @ResponseBody
    public DataGridVo selectAll(Page page) {
        PageInfo<Address> pageInfo = addressService.selectAll(page);
        DataGridVo gridVo = new DataGridVo();
        gridVo.setCode(0);
        gridVo.setCount(pageInfo.getTotal());
        gridVo.setData(pageInfo.getList());
        return gridVo;
    }

    @RequestMapping("deleteAddress")
    @ResponseBody
    public ResultVo deleteAddress(Integer aId){
        return addressService.deleteById(aId);
    }
    @RequestMapping("updateAddress")
    @ResponseBody
    public ResultVo updateAddress(Address address){
        return addressService.updateAddress(address);
    }
    @RequestMapping("selectById")
    @ResponseBody
    public Address selectById(Integer aId){
        return addressService.selectById(aId);
    }
}
