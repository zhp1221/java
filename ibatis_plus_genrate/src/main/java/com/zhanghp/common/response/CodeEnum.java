package com.zhanghp.common.response;

/**
 * @author: zhanghp
 * @date: 2022-06-23 21:53
 */
public enum CodeEnum {
    SUCCESS("A0000", "服务请求成功"),
    CHECK_FAILURE("A0110", "校验失败"),
    USER_EXIST("A0111", "用户名已存在"),
    USER_NAME_CONTAIN_SENSITIVE_CHARACTER("A0112", "用户名包含敏感字符"),
    USER_NAME_CONTAIN_SPECIAL_CHARACTER("A0113", "用户名包含特殊字符"),
    PASSWORD_VERIFICATION_FAILURE("A0120", "密码校验失败"),
    PASSWORD_LENGTH("A0121", "密码长度不够"),
    USER_INFORMATION_VERIFICATION_FAULURE("A0150", "用户基本信息校验失败"),
    PHONE_VERIFICATION_FAILURE("A0151", "手机格式校验失败"),
    FAIL("A0500", "服务请求失败");


    CodeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private final String code;

    private final String msg;

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
