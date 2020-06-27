package com.mall.ivy.core.exception;

import com.mall.ivy.core.enums.ResultEnum;
import com.mall.ivy.core.resp.Result;
import com.mall.ivy.core.resp.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
/**
* 统一异常控制类
* Created by Ivy.
*/
@RestControllerAdvice
public class ExceptionHandle {

    private final static Logger logger= LoggerFactory.getLogger(ExceptionHandle.class);

    /**
    * 参数为空异常处理
    *
    * @param ex
    * @return
    */
    @ExceptionHandler({MissingServletRequestParameterException.class})
    public Result<String> paramIsNull(Exception ex) {
        //        return ResultUtil.error(ResultEnum.WRONG_REQUEST_PARAMETER.getCode(),ResultEnum.WRONG_REQUEST_PARAMETER.getMsg());
        return ResultUtil.error(ResultEnum.WRONG_REQUEST_PARAMETER.getCode(), ex.getMessage());
    }


    /**
    * 请求方法错误
    * @param e
    * @return
    */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseBody   //返回Json格式
    public Result requestMethod(Exception e){
        if(e instanceof CustomException){
            CustomException customException =(CustomException)e;
            return ResultUtil.error(customException.getCode(), customException.getMessage());
        }else{
            return ResultUtil.error(ResultEnum.REQUIRED_METHOD_ERROR.getCode(),ResultEnum.REQUIRED_METHOD_ERROR.getMsg());
        }
    }

    /**
    * 数据格式异常
    * @param e
    * @return
    */
    @ExceptionHandler(NumberFormatException.class)
    @ResponseBody
    public Result numberFormatException(Exception e){
        if(e instanceof CustomException){
            CustomException customException =(CustomException)e;
            return ResultUtil.error(customException.getCode(), customException.getMessage());
        }else{
            return ResultUtil.error(ResultEnum.NUMBER_FORMAT.getCode(),ResultEnum.NUMBER_FORMAT.getMsg());
        }
    }

    /**
    * 请求需要用户验证
    * @param e
    * @return
    */
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseBody
    public Result loginFilter(Exception e){
        if(e instanceof CustomException){
            CustomException customException =(CustomException)e;
            return ResultUtil.error(customException.getCode(), customException.getMessage());
        }else{
            e.printStackTrace();
            return ResultUtil.error(ResultEnum.REQUIRES_USER_AUTHENTICATION.getCode(),ResultEnum.REQUIRES_USER_AUTHENTICATION.getMsg());
        }
    }


    @ExceptionHandler(Exception.class)
    @ResponseBody   //返回Json格式
    public Result handle(Exception e){
        if(e instanceof CustomException){
            CustomException customException =(CustomException)e;
            return ResultUtil.error(customException.getCode(), customException.getMessage());
        }else{
            logger.error("【系统异常】{}",e);
            return ResultUtil.error(ResultEnum.UNKONW_ERROR.getCode(),ResultEnum.UNKONW_ERROR.getMsg());
            //            return ResultUtil.error(500,e.getMessage());
        }
    }

}
