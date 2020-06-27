package com.mall.ivy.dto.goodsCategory;

import lombok.Data;

/**
 * goodsCategorySaveDTO
 * Created by Ivy.
 */
@Data
public class GoodsCategorySaveDTO {

    private Integer fatherId;

    private String categoryName;

    public GoodsCategorySaveDTO() {
    }

    public Integer getFatherId() {
        return fatherId;
    }

    public void setFatherId(Integer fatherId) {
        this.fatherId = fatherId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
