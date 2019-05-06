package com.mr.pojo;

/**
 * Created by Fan on 2019/5/6.
 */
public class Foot {

    private Integer footId;

    private Goods goods;

    @Override
    public String toString() {
        return "Foot{" +
                "footId=" + footId +
                ", goods=" + goods +
                '}';
    }

    public Integer getFootId() {
        return footId;
    }

    public void setFootId(Integer footId) {
        this.footId = footId;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }
}
