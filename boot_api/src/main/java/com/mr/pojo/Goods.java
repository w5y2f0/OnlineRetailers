package com.mr.pojo;

import java.util.Date;

public class Goods {
    private Integer goId;

    private String goName;

    private String goSynopsis;

    private Integer goType;

    private Integer goStates;

    private Date goDatetimes;

    private Integer goSales;

    private Double goOld;

    private Double goNew;

    private Integer goNum;

    public Integer getGoId() {
        return goId;
    }

    public void setGoId(Integer goId) {
        this.goId = goId;
    }

    public String getGoName() {
        return goName;
    }

    public void setGoName(String goName) {
        this.goName = goName == null ? null : goName.trim();
    }

    public String getGoSynopsis() {
        return goSynopsis;
    }

    public void setGoSynopsis(String goSynopsis) {
        this.goSynopsis = goSynopsis == null ? null : goSynopsis.trim();
    }

    public Integer getGoType() {
        return goType;
    }

    public void setGoType(Integer goType) {
        this.goType = goType;
    }

    public Integer getGoStates() {
        return goStates;
    }

    public void setGoStates(Integer goStates) {
        this.goStates = goStates;
    }

    public Date getGoDatetimes() {
        return goDatetimes;
    }

    public void setGoDatetimes(Date goDatetimes) {
        this.goDatetimes = goDatetimes;
    }

    public Integer getGoSales() {
        return goSales;
    }

    public void setGoSales(Integer goSales) {
        this.goSales = goSales;
    }

    public Double getGoOld() {
        return goOld;
    }

    public void setGoOld(Double goOld) {
        this.goOld = goOld;
    }

    public Double getGoNew() {
        return goNew;
    }

    public void setGoNew(Double goNew) {
        this.goNew = goNew;
    }

    public Integer getGoNum() {
        return goNum;
    }

    public void setGoNum(Integer goNum) {
        this.goNum = goNum;
    }
}