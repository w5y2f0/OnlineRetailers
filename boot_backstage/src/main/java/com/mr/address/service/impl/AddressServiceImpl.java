package com.mr.address.service.impl;

import com.mr.address.mapper.AddressMapper;
import com.mr.address.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Fan on 2019/4/30.
 */
@Service
public class AddressServiceImpl  implements AddressService{

    @Autowired
    private AddressMapper addressMapper;


}
