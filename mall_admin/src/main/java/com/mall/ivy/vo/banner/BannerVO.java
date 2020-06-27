package com.mall.ivy.vo.banner;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
* banner详情
* Created by Ivy.
*/
@Data
public class BannerVO {

    private Integer id;

    /**
     * 轮播图图片
     *
     * @mbg.generated
     */
    private String img;

    /**
     * 跳转链接，自定义协议goods://goods_id
     *
     * @mbg.generated
     */
    private String url;

    @JsonFormat(pattern = "yy-MM-dd hh:mm:ss", timezone = "GMT-8")
    private Date gmtCreate;

    @JsonFormat(pattern = "yy-MM-dd hh:mm:ss", timezone = "GMT-8")
    private Date gmtModify;


    public BannerVO(Integer id, String img, String url, Date gmtCreate, Date gmtModify) {
        this.id = id;
        this.img = img;
        this.url = url;
        this.gmtCreate = gmtCreate;
        this.gmtModify = gmtModify;
    }

    public BannerVO() {
    }
}