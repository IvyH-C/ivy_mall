package com.mall.ivy.vo.banner;

import lombok.Data;

/**
* banner详情
* Created by Ivy.
*/
@Data
public class BannerVO {

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

    public BannerVO( ) {
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}