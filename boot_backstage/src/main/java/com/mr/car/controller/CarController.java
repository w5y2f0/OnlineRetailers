package com.mr.car.controller;

import com.mr.car.service.CarService;
import com.mr.pojo.Car;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Mr.Bai on 2019/4/30.
 */
public class CarController {
     @Autowired
    private CarService carService;


    /**
     * 打开购物车面
     * @return
     */

    public String  car(){

        return "shopcart";

    }

    /**
     * 查询购物车全部信息
     * @return
     */
    public  String carlist( ){

       // List<Car> list=carService.carlist();

        return "list";
    }

}
