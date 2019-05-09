package com.mr.pojo;

import java.util.Date;

/**
 * 优惠券领取表
 */
public class Receive {
    private Integer reId;

    private Integer goId;

    private Integer uId;

    private Integer coId;

    private Date reTime;

    private Integer reUse;

    private Integer reTerm;


    public Integer getUId() {
        return uId;
    }

    public void setUId(Integer uId) {
        this.uId = uId;
    }

    public Integer getReId() {
        return reId;
    }

    public void setReId(Integer reId) {
        this.reId = reId;
    }

    public Integer getGoId() {
        return goId;
    }

    public void setGoId(Integer goId) {
        this.goId = goId;
    }

    public Integer getCoId() {
        return coId;
    }

    public void setCoId(Integer coId) {
        this.coId = coId;
    }

    public Date getReTime() {
        return reTime;
    }

    public void setReTime(Date reTime) {
        this.reTime = reTime;
    }

    public Integer getReUse() {
        return reUse;
    }

    public void setReUse(Integer reUse) {
        this.reUse = reUse;
    }

    public Integer getReTerm() {
        return reTerm;
    }

    public void setReTerm(Integer reTerm) {
        this.reTerm = reTerm;
    }
}