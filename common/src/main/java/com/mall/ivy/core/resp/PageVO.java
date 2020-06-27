package com.mall.ivy.core.resp;

import lombok.Data;

import java.util.List;

/**
* 分页返回的封装类
* Created by Ivy.
*/
@Data
public class PageVO<T> {

    private List<T> list;
    private long rowCount;

    public PageVO(List<T> list, long rowCount) {
        this.list = list;
        this.rowCount = rowCount;
    }

    public PageVO() {
    }


}