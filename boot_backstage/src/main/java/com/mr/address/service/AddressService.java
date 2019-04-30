package com.mr.address.service;

import com.github.pagehelper.PageInfo;
import com.mr.address.Address;
import com.mr.utils.Page;
import com.mr.utils.ResultVo;

/**
 * Created by Fan on 2019/4/30.
 */
public interface AddressService {

    PageInfo<Address> selectAll(Page page);

    ResultVo addAddress(Address address);

    ResultVo deleteById(Integer aId);

    ResultVo updateAddress(Address address);

    Address selectById(Integer aId);

}
