package com.mall.ivy.core.enums;

/**
* 系统响应状态码
* Created by Ivy.
*/
public enum ResultEnum {

    /**
    *     响应状态码
    *
    *     返回的响应状态码遵循RFC 2616 section 6.1.1
    *
    *     1xx: Informational - Request received, continuing process.
    *     2xx: Success - The action was successfully received, understood, and accepted.
    *     3xx: Redirection - Further action must be taken in order to complete the request.
    *     4xx: Client Error - The request contains bad syntax or cannot be fulfilled.
    *     5xx: Server Error - The server failed to fulfill an apparently valid request.
    */

    UNKONW_ERROR(-1, "未知错误"),
    SUCCESS(200, "操作成功"),
    INVALID_ACCOUNT(209, "无效的账号"),
    CODE_INVALID(210, "code失效"),
    DO_NOT_REPETITION(211, "请勿重复操作"),
    DATA_EXISIS(212,"该数据已存在"),
    TOKEN_INVALID(220, "您的token已失效"),
    MOBILE_REGISTERED(221, "该手机号已被注册,可直接登录或换个手机号注册"),
    INVALID_CODE(222, "无效的验证码"),
    MOBILE_NOT_RULES(223, "手机号不正确"),
    PASSWORD_EMPTY(224, "密码不能为空"),
    MOBILE_NOT_MATCH(225, "与获取验证码的手机号不一致"),
    BUSINESS_LIMIT_CONTROL(226, "默认流控：使用同一个签名，对同一个手机号码发送短信验证码，支持1条/分钟，5条/小时，累计10条/天"),
    BINDING_FAILURE(227, "绑定失败"),
    EMAIL_NOT_RULES(228,"邮箱格式不符合规范"),
    NAME_EMPTY(229,"名称不能为空"),
    UNAUTHENTICATION(230, "身份过期，请重新登录!"),
    BINDING_WECHAT(231, "请去绑定微信"),
    BINDING_MOBILE(232, "请去绑定手机号"),
    EMAIL_EMPTY(233,"邮箱不能为空"),
    ACCOUNT_EMPTY(234,"账号不能为空"),
    NOT_FOUND_COMPANY(235, "不能填写一个未在工商局备案的公司名称！"),
    MOBILE_EMPTY(236,"手机号不能为空"),
    CATEGORY_EMPTY(237, "分类名称不能为空"),
    FATHERID_EMPTY(238,"父类编号不能为空"),
    UNAUTHORIZED(240, "权限不够,可通过超级管理员增加权限"),
    NUMBER_FORMAT(250, "服务器数据格式异常"),
    DATA_PROBLEM(251, "数据库数据问题"),
    FAILURE(4000, "找不到资源"),
    WRONG_REQUEST_PARAMETER(4001, "请求参数有误"),
    TOKEN_MISS(4002, "token参数缺失"),
    UNSUBSCRIBE(4003, "成功关注过公众号的用户才可提现"),
    REQUIRES_USER_AUTHENTICATION(401, "请求需要用户验证"),
    USERNAME_PASSWORD_ERROR(4011, "用户名或密码错误"),
    MOBILE_PASSWORD_ERROR(4012, "手机号或密码错误"),
    REQUIRED_METHOD_ERROR(402, "请求方法错误"),
    TIME_OUT(408, "请求超时"),
    OPERATION_FAILURE(500, "服务器操作异常"),
    HANDLE_FAILURE(505, "操作失败"),
    UNDER_STOCK(510, "库存不足"),
    LACK_INTEGRAL(520, "积分不足"),
    INSUFFICIENT_FUND(522, "可提现金额不足"),
    NOT_VALID_PERIOD(530, "不在有效兑换期"),
    SERVICE_RESIDUE_INSUFFICIENT(540, "套餐次数不足"),
    COMPLETE_INFORMATION(542, "请完善信息"),
    ILLEGAL_INFO(5000,"抱歉您填写的内容包含违禁信息"),
    ILLEGAL_IMAGE(5001,"抱歉您上传图片含违禁信息"),
    ILLEGAL_IMAGEANDINFO(5003,"抱歉您上传图片和文本含违禁信息"),
    FILE_TYPE_ERROR(5005,"文件类型出错"),
    ACCOUNT_CHECKING(5006, "账号审核中"),
    ACCOUNT_CHECK_FAIL(5007, "账号审核失败");

    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
