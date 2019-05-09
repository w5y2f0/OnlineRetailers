package com.mr.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Fan on 2019/5/9.
 */
public class CouponVo {

    private Integer coId;//卷编号
    private Double coMoney;//价值
    private Double coLimit;//限制价格
    private Date coValid;//有效时间
    private Date reTime;//领取时间
    private Integer reUse;//使用状态
    private Integer reTerm;//过期状态


    private String getReTimeStr(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String format1 = format.format(reTerm);
        return format1;
    }

    private String getCoValidStr(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String format1 = format.format(coValid);
        return format1;
    }
    @Override
    public String toString() {
        return "CouponVo{" +
                "coId=" + coId +
                ", coMoney=" + coMoney +
                ", coLimit=" + coLimit +
                ", coValid=" + coValid +
                ", reTime=" + reTime +
                ", reUse=" + reUse +
                ", reTerm=" + reTerm +
                '}';
    }

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
