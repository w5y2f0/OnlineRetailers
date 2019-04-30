package com.mr.pojo;


/**
 * 字典表【商品类型】
 */
public class Type {

    private Integer typeId;//编号

    private String typeName;//名称

    @java.lang.Override
    public java.lang.String toString() {
        return "Type{" +
                "typeId=" + typeId +
                ", typeName='" + typeName + '\'' +
                '}';
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Type() {

    }

    public Type(Integer typeId, String typeName) {

        this.typeId = typeId;
        this.typeName = typeName;
    }

}