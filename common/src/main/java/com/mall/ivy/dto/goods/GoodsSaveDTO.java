package com.mall.ivy.dto.goods;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * goodsSaveDTO
 * Created by Ivy.
 */
@Data
public class GoodsSaveDTO {

    @NotNull
    private String name;

    @NotNull
    private Integer stock;

    @NotNull
    private Double price;

    @NotNull
    private String details;

    @NotNull
    private String mainImg;

    @NotNull
    private String subImg;

    public GoodsSaveDTO() {
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
}
