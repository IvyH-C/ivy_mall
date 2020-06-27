package com.mall.ivy.vo.evaluation;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
* evaluation详情
* Created by Ivy.
*/
@Data
public class EvaluationVO {

    private Integer id;

    private Integer userId;

    private Integer goodsId;

    private String content;

    private Byte star;

    private Date gmtCreate;

    private Date gmtModify;

    private Boolean del;

    public EvaluationVO() {
    }


    public Integer getUserId() {
        return userId;
    }

    public EvaluationVO(Integer id, Integer userId, Integer goodsId, String content, Byte star, Date gmtCreate, Date gmtModify, Boolean del) {
        this.id = id;
        this.userId = userId;
        this.goodsId = goodsId;
        this.content = content;
        this.star = star;
        this.gmtCreate = gmtCreate;
        this.gmtModify = gmtModify;
        this.del = del;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Boolean getDel() {
        return del;
    }

    public void setDel(Boolean del) {
        this.del = del;
    }
}