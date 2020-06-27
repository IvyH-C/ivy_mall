package com.mall.ivy.dto.goods;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * goodsListDTO
 * Created by Ivy.
 */
@Data
public class GoodsListDTO {

    private Integer id;

    private String name;

    private Integer stock;

    private Double price;

    private String details;

    private String  mainImg;

    private String subImg;

    @JsonFormat(pattern = "yy-MM-dd hh hh:mm:ss",timezone = "GMT+8")
    private Date gmtCreate;

    @JsonFormat(pattern = "yy-MM-dd hh hh:mm:ss",timezone = "GMT+8")
    private Date gmtModify;

    public GoodsListDTO() {
    }

    public GoodsListDTO(Integer id, String name, Integer stock, Double price, String details, String mainImg, String subImg) {
        this.id = id;
        this.name = name;
        this.stock = stock;
        this.price = price;
        this.details = details;
        this.mainImg = mainImg;
        this.subImg = subImg;
    }


}
