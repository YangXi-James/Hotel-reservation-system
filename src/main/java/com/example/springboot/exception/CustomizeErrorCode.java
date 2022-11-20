package com.example.springboot.exception;

/**
 * 自定义枚举类
 */
public enum CustomizeErrorCode {
    EMAIL_IS_EXIST(201,"邮箱已经注册过了"),
    EMAIL_IS_NOT_EXIST(207,"该邮箱没有注册过"),
    EMAIL_OR_PWD_BLANK(203,"邮箱或密码不能为空"),
    INVALID_ADDRESSES(204,"邮箱不正确，无效的地址！"),
    VERIFY_IS_ERROR(205,"验证码错误"),
    REGISTER_FAIL(206,"注册失败"),
    DELETE_HOTEL_ERROR(301,"删除酒店失败"),
    DELETE_Standrad_ERROR(302,"删除房型失败，可能与部分订单相关联，请先删除相关订单"),
    EMAIL_OR_PWD_ERROR(208,"昵称、密码或验证码错误，登录失败"),
    PASSWORD_SAME(202,"新密码和原密码相同");



    private Integer code;
    private String message;

    public String getMessage() {
        return message;
    }

    public Integer getCode() {
        return code;
    }

    CustomizeErrorCode(Integer code,String message) {
        this.message = message;
        this.code = code;
    }

}
