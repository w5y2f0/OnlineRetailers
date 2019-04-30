package com.mr.pojo;

import java.io.Serializable;

public class Car  implements Serializable{//反序列化
    private Integer carId;

    private Integer goId;

    private Integer piId;

    private Integer carNum;

    private Double carSum;

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public Integer getGoId() {
        return goId;
    }

    public void setGoId(Integer goId) {
        this.goId = goId;
    }

    public Integer getPiId() {
        return piId;
    }

    public void setPiId(Integer piId) {
        this.piId = piId;
    }

    public Integer getCarNum() {
        return carNum;
    }

    public void setCarNum(Integer carNum) {
        this.carNum = carNum;
    }

    public Double getCarSum() {
        return carSum;
    }

    public void setCarSum(Double carSum) {
        this.carSum = carSum;
    }
}