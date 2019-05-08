package com.mr.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 优惠券表
 */
public class Coupon {
    private Integer coId;

    private Double coMoney;

    private Double coLimit;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date coValid;

    private Integer coStates;

    private Integer coNum;

    public Integer getCoId() {
        return coId;
    }

    public void setCoId(Integer coId) {
        this.coId = coId;
    }

    public Double getCoMoney() {
        return coMoney;
    }

    public void setCoMoney(Double coMoney) {
        this.coMoney = coMoney;
    }

    public Double getCoLimit() {
        return coLimit;
    }

    public void setCoLimit(Double coLimit) {
        this.coLimit = coLimit;
    }

    public Date getCoValid() {
        return coValid;
    }

    public void setCoValid(Date coValid) {
        this.coValid = coValid;
    }

    public Integer getCoStates() {
        return coStates;
    }

    public void setCoStates(Integer coStates) {
        this.coStates = coStates;
    }

    public Integer getCoNum() {
        return coNum;
    }

    public void setCoNum(Integer coNum) {
        this.coNum = coNum;
    }
}