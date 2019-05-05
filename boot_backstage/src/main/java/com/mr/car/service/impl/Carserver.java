package com.mr.car.service.impl;

import com.mr.car.mapper.CarMapper;
import com.mr.car.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Mr.Bai on 2019/4/30.
 */
@Service
public class Carserver implements CarService {

    @Autowired
   private CarMapper carMapper;

}
