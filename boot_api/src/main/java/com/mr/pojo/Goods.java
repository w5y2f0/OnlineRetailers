package com.mr.pojo;

import org.apache.solr.client.solrj.beans.Field;

import java.util.Date;

public class Goods {
    @Field("go_id")
    private Integer goId;
    @Field("go_name")
    private String goName;
    @Field("go_synopsis")
    private String goSynopsis;
    @Field("go_detailed")
    private String goDetailed;
    @Field("go_type")
    private Integer goType;
    @Field("go_states")
    private Integer goStates;
    @Field("go_datetimes")
    private Date goDatetimes;
    @Field("go_sales")
    private Integer goSales;
    @Field("go_old")
    private Double goOld;
    @Field("go_new")
    private Double goNew;
    @Field("go_num")
    private Integer goNum;

    @Override
    public String toString() {
        return "Goods{" +
                "goId=" + goId +
                ", goName='" + goName + '\'' +
                ", goSynopsis='" + goSynopsis + '\'' +
                ", goDetailed='" + goDetailed + '\'' +
                ", goType=" + goType +
                ", goStates=" + goStates +
                ", goDatetimes=" + goDatetimes +
                ", goSales=" + goSales +
                ", goOld=" + goOld +
                ", goNew=" + goNew +
                ", goNum=" + goNum +
                '}';
    }

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

    public String getGoDetailed() {
        return goDetailed;
    }

    public void setGoDetailed(String goDetailed) {
        this.goDetailed = goDetailed == null ? null : goDetailed.trim();
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