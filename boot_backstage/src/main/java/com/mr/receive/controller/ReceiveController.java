package com.mr.receive.controller;

import com.mr.receive.service.ReceiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 黄圣博 on 2019/4/29.
 */
@RestController
@RequestMapping("receive")
public class ReceiveController {
    @Autowired
    private ReceiveService receiveService;
}
