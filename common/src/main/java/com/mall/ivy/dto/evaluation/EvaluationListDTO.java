package com.mall.ivy.dto.evaluation;

import lombok.Data;

/**
 * evaluationListDTO
 * Created by Ivy.
 */
@Data
public class EvaluationListDTO {

    private Integer userId;

    private Integer goodsId;

    private String content;

    private Byte star;

    private Boolean del;


    public EvaluationListDTO() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Byte getStar() {
        return star;
    }

    public void setStar(Byte star) {
        this.star = star;
    }

    public Boolean getDel() {
        return del;
    }

    public void setDel(Boolean del) {
        this.del = del;
    }
}
