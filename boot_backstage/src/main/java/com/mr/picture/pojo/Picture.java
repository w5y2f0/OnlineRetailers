package com.mr.picture.pojo;

/**
 *图片表
 */
public class Picture {
    private Integer piId;

    private Integer goId;

    private String piUrl;

    private Integer piOrder;

    public Integer getPiId() {
        return piId;
    }

    public void setPiId(Integer piId) {
        this.piId = piId;
    }

    public Integer getGoId() {
        return goId;
    }

    public void setGoId(Integer goId) {
        this.goId = goId;
    }

    public String getPiUrl() {
        return piUrl;
    }

    public void setPiUrl(String piUrl) {
        this.piUrl = piUrl == null ? null : piUrl.trim();
    }

    public Integer getPiOrder() {
        return piOrder;
    }

    public void setPiOrder(Integer piOrder) {
        this.piOrder = piOrder;
    }
}