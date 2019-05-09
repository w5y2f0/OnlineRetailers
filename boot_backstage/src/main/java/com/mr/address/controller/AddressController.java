package com.mr.address.controller;

import com.github.pagehelper.PageInfo;
import com.mr.address.Address;
import com.mr.address.service.AddressService;
import com.mr.utils.DataGridVo;
import com.mr.utils.Page;
import com.mr.utils.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Fan on 2019/4/30.
 */
@Controller
@RequestMapping("address")
public class AddressController {

    @Autowired
    private AddressService addressService;



    //去查询页面
    @RequestMapping("toSelect")
    public String toSelect(){
        return "address/list_address";
    }

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

    @RequestMapping("selectAddress")
    @ResponseBody
    public List<Address> selectAddress() {
        return addressService.selectAll();
    }

    @RequestMapping("addAddress")
    @ResponseBody
    public void addAddress( Address address) {
        addressService.addAddress(address);
    }

    @RequestMapping("deleteAddress")
    @ResponseBody
    public ResultVo deleteAddress(@RequestBody Integer aId) {
        return addressService.deleteById(aId);
    }

    @RequestMapping("deleteAddressTest")
    @ResponseBody
    public ResultVo deleteAddressTest(Integer id){
        return addressService.deleteAddressTest(id);
    }

    @RequestMapping("updateAddress")
    @ResponseBody
    public ResultVo updateAddress(Address address) {
        return addressService.updateAddress(address);
    }

    @RequestMapping("selectById")
    @ResponseBody
    public Address selectById(Integer aId) {
        return addressService.selectById(aId);
    }
}
