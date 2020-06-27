package com.mall.ivy.vo.goodsCategory;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
* goodsCategory详情
* Created by Ivy.
*/
@Data
public class GoodsCategoryVO {

    private Integer id;

    private Integer fatherId;

    private String categoryName;

    private Date gmtCreate;

    private Date gmtModify;

    public GoodsCategoryVO() {
    }

    public GoodsCategoryVO(Integer id, Integer fatherId, String categoryName, Date gmtCreate, Date gmtModify) {
        this.id = id;
        this.fatherId = fatherId;
        this.categoryName = categoryName;
        this.gmtCreate = gmtCreate;
        this.gmtModify = gmtModify;
    }


}