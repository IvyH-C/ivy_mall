package com.mall.ivy.core.exception;

import com.mall.ivy.core.enums.ResultEnum;


/**
* 自定义异常类
* Created by Ivy.
*/
public class CustomException extends RuntimeException {

    private Integer code;

    public CustomException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public CustomException(Integer code, String msg) {
        super(msg);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
