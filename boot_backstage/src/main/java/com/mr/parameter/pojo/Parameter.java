package com.mr.parameter.pojo;

/**
 * 商品参数表
 */
public class Parameter {
    private Integer parId;

    private Integer goId;

    private String paColor;

    private Integer paWeight;

    private String goSpecs;

    private String goMaterial;

    private String goPacking;

    public Integer getParId() {
        return parId;
    }

    public void setParId(Integer parId) {
        this.parId = parId;
    }

    public Integer getGoId() {
        return goId;
    }

    public void setGoId(Integer goId) {
        this.goId = goId;
    }

    public String getPaColor() {
        return paColor;
    }

    public void setPaColor(String paColor) {
        this.paColor = paColor == null ? null : paColor.trim();
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
        this.goSpecs = goSpecs == null ? null : goSpecs.trim();
    }

    public String getGoMaterial() {
        return goMaterial;
    }

    public void setGoMaterial(String goMaterial) {
        this.goMaterial = goMaterial == null ? null : goMaterial.trim();
    }

    public String getGoPacking() {
        return goPacking;
    }

    public void setGoPacking(String goPacking) {
        this.goPacking = goPacking == null ? null : goPacking.trim();
    }
}