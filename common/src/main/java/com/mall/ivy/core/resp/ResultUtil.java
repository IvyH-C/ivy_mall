package com.mall.ivy.core.resp;

import com.mall.ivy.core.enums.ResultEnum;

import java.util.HashMap;

/**
* 接口请求返回对象工具类
* Created by Ivy.
*/
public class ResultUtil {

    public ResultUtil() {
    }

    /*
    * 请求成功
    */
    public  static <T> Result success(T t){
        return new Result(t);
    }

    /*
    * 请求成功
    */
    public static Result success(){
        return success(new HashMap<>());
    }

    /*
    * 请求失败
    */
    public static Result error(Integer code, String msg){
        return new Result(code, msg);
    }

    /*
    * 请求失败
    */
    public static Result error(ResultEnum resultEnum) {
        return new Result(resultEnum.getCode(), resultEnum.getMsg());
    }

    /*
    * 请求失败
    */
    public static <T> Result error(Integer code, String msg, T t){
        return new Result(code, msg,t);
    }
}
