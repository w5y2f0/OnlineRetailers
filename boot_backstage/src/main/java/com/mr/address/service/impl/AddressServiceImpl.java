package com.mr.address.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mr.address.Address;
import com.mr.address.mapper.AddressMapper;
import com.mr.address.service.AddressService;
import com.mr.utils.Page;
import com.mr.utils.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Fan on 2019/4/30.
 */
@Service
public class AddressServiceImpl  implements AddressService{

    @Autowired
    private AddressMapper addressMapper;


    @Override
    public PageInfo<Address> selectAll(Page page) {
        if (page == null) {
            page = new Page();
        }
        PageHelper.startPage(page.getPage(), page.getLimit());
        List<Address> bankList = addressMapper.selectAll();
        PageInfo<Address> pageList = new PageInfo<>(bankList);
        return pageList;
    }

    @Override
    public List<Address> selectAll() {
        return addressMapper.selectAll();
    }

    @Override
    public ResultVo addAddress(Address address) {

        addressMapper.insert(address);
        return ResultVo.success("增加成功");
    }

    @Override
    public ResultVo deleteById(Integer aId) {
        addressMapper.deleteByPrimaryKey(aId);
        return ResultVo.success("删除成功");
    }

    @Override
    public ResultVo updateAddress(Address address) {
        addressMapper.updateByPrimaryKey(address);
        return ResultVo.success("修改成功");
    }

    @Override
    public Address selectById(Integer aId) {
        return addressMapper.selectByPrimaryKey(aId);
    }

    @Override
    public ResultVo deleteAddressTest(Integer id) {
       addressMapper.deleteByPrimaryKey(id);
       return ResultVo.success("删除成功！！！");
    }
}
