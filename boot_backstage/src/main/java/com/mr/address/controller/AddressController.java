package com.mr.address.controller;

import com.mr.address.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Fan on 2019/4/30.
 */
@Controller
@RequestMapping("address")
public class AddressController {

    @Autowired
    private AddressService addressService;

}
