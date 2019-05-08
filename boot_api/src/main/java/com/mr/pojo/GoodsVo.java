package com.mr.pojo;

import javax.annotation.sql.DataSourceDefinition;
import javax.swing.*;
import java.util.Date;
import java.util.List;

/**
 * Created by 黄圣博 on 2019/5/6.
 */
public class GoodsVo {

    private Integer goId;

    private String goName;

    private String goSynopsis;

    private String goDetailed;

    private Integer goType;

    private Integer goStates;

    private Date goDatetimes;

    private Integer goSales;

    private Double goOld;

    private Double goNew;

    private Integer goNum;

    private Integer parId;

    private String paColor;

    private Integer paWeight;

    private String goSpecs;

    private String goMaterial;

    private String goPacking;

    private String piUrl;

    public GoodsVo() {
    }

    public GoodsVo(Integer goId, String goName, String goSynopsis, String goDetailed, Integer goType, Integer goStates, Date goDatetimes, Integer goSales, Double goOld, Double goNew, Integer goNum, Integer parId, String paColor, Integer paWeight, String goSpecs, String goMaterial, String goPacking, String piUrl) {
        this.goId = goId;
        this.goName = goName;
        this.goSynopsis = goSynopsis;
        this.goDetailed = goDetailed;
        this.goType = goType;
        this.goStates = goStates;
        this.goDatetimes = goDatetimes;
        this.goSales = goSales;
        this.goOld = goOld;
        this.goNew = goNew;
        this.goNum = goNum;
        this.parId = parId;
        this.paColor = paColor;
        this.paWeight = paWeight;
        this.goSpecs = goSpecs;
        this.goMaterial = goMaterial;
        this.goPacking = goPacking;
        this.piUrl = piUrl;
    }

    @Override
    public String toString() {
        return "GoodsVo{" +
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
                ", parId=" + parId +
                ", paColor='" + paColor + '\'' +
                ", paWeight=" + paWeight +
                ", goSpecs='" + goSpecs + '\'' +
                ", goMaterial='" + goMaterial + '\'' +
                ", goPacking='" + goPacking + '\'' +
                ", piUrl=" + piUrl +
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
        this.goName = goName;
    }

    public String getGoSynopsis() {
        return goSynopsis;
    }

    public void setGoSynopsis(String goSynopsis) {
        this.goSynopsis = goSynopsis;
    }

    public String getGoDetailed() {
        return goDetailed;
    }

    public void setGoDetailed(String goDetailed) {
        this.goDetailed = goDetailed;
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

    public Integer getParId() {
        return parId;
    }

    public void setParId(Integer parId) {
        this.parId = parId;
    }

    public String getPaColor() {
        return paColor;
    }

    public void setPaColor(String paColor) {
        this.paColor = paColor;
    }

    public Integer getPaWeight() {
        return paWeight;
    }

    public void setPaWeight(Integer paWeight) {
        this.paWeight = paWeight;
    }

    public String getGoSpecs() {
        return goSpecs;
    }

    public void setGoSpecs(String goSpecs) {
        this.goSpecs = goSpecs;
    }

    public String getGoMaterial() {
        return goMaterial;
    }

    public void setGoMaterial(String goMaterial) {
        this.goMaterial = goMaterial;
    }

    public String getGoPacking() {
        return goPacking;
    }

    public void setGoPacking(String goPacking) {
        this.goPacking = goPacking;
    }

    public String getPiUrl() {
        return piUrl;
    }

    public void setPiUrl(String piUrl) {
        this.piUrl = piUrl;
    }
}
