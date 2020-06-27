package com.mall.ivy.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.ibatis.annotations.Options;

import java.io.Serializable;
import java.util.Date;

public class Goods implements Serializable {
    /**
     * 商品编号
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     * 商品名称
     *
     * @mbg.generated
     */
    private String name;

    /**
     * 商品库存
     *
     * @mbg.generated
     */
    private Integer stock;

    /**
     * 商品价格
     *
     * @mbg.generated
     */
    private Double price;

    /**
     * 商品详情
     *
     * @mbg.generated
     */
    private String details;

    /**
     * 商品主图
     *
     * @mbg.generated
     */
    private String mainImg;

    /**
     * 商品子图
     *
     * @mbg.generated
     */
    private String subImg;

    /**
     * 是否删除：0-未删除；1已删除
     *
     * @mbg.generated
     */
    private Boolean del;

    @JsonFormat(pattern = "yy-MM-dd hh hh:mm:ss",timezone = "GMT+8")
    private Date gmtCreate;

    @JsonFormat(pattern = "yy-MM-dd hh hh:mm:ss",timezone = "GMT+8")
    private Date gmtModify;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getMainImg() {
        return mainImg;
    }

    public void setMainImg(String mainImg) {
        this.mainImg = mainImg;
    }

    public String getSubImg() {
        return subImg;
    }

    public void setSubImg(String subImg) {
        this.subImg = subImg;
    }

    public Boolean getDel() {
        return del;
    }

    public void setDel(Boolean del) {
        this.del = del;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModify() {
        return gmtModify;
    }

    public void setGmtModify(Date gmtModify) {
        this.gmtModify = gmtModify;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", stock=").append(stock);
        sb.append(", price=").append(price);
        sb.append(", details=").append(details);
        sb.append(", mainImg=").append(mainImg);
        sb.append(", subImg=").append(subImg);
        sb.append(", del=").append(del);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtModify=").append(gmtModify);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Goods other = (Goods) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getStock() == null ? other.getStock() == null : this.getStock().equals(other.getStock()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
            && (this.getDetails() == null ? other.getDetails() == null : this.getDetails().equals(other.getDetails()))
            && (this.getMainImg() == null ? other.getMainImg() == null : this.getMainImg().equals(other.getMainImg()))
            && (this.getSubImg() == null ? other.getSubImg() == null : this.getSubImg().equals(other.getSubImg()))
            && (this.getDel() == null ? other.getDel() == null : this.getDel().equals(other.getDel()))
            && (this.getGmtCreate() == null ? other.getGmtCreate() == null : this.getGmtCreate().equals(other.getGmtCreate()))
            && (this.getGmtModify() == null ? other.getGmtModify() == null : this.getGmtModify().equals(other.getGmtModify()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getStock() == null) ? 0 : getStock().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getDetails() == null) ? 0 : getDetails().hashCode());
        result = prime * result + ((getMainImg() == null) ? 0 : getMainImg().hashCode());
        result = prime * result + ((getSubImg() == null) ? 0 : getSubImg().hashCode());
        result = prime * result + ((getDel() == null) ? 0 : getDel().hashCode());
        result = prime * result + ((getGmtCreate() == null) ? 0 : getGmtCreate().hashCode());
        result = prime * result + ((getGmtModify() == null) ? 0 : getGmtModify().hashCode());
        return result;
    }
}