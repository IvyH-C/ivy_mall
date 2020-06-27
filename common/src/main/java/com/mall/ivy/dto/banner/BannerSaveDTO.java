package com.mall.ivy.dto.banner;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * bannerSaveDTO
 * Created by Ivy.
 */
@Data
public class BannerSaveDTO {

    @NotNull
    private String img;

    @NotNull
    private String url;

    @NotNull
    public BannerSaveDTO() {
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
