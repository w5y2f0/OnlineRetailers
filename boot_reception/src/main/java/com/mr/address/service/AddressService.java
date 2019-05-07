package com.mr.address.service;

import com.mr.address.Address;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Fan on 2019/5/7.
 */
@FeignClient(value = "PROVIDER")
public interface AddressService {

    @RequestMapping(value = "/address/selectAddress")
    List<Address> selectAllAddress();
}
