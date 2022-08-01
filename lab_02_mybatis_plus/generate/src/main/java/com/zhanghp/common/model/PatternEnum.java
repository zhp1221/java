package com.zhanghp.common.model;

/**
 * @author: zhanghp
 * @date: 2022-06-28 1:50
 */
public enum PatternEnum {
    // 汉字+空格
    // \u0020：半角空格（英文符号）
    // \u3000  全角空格（中文符号）
    ONLY_CHINESE_BLANK("^[\\u4E00-\\u9FA5\\uF900-\\uFA2D\\u0020]*$"),
    // 英文+空格
    ONLY_ENGLISH_BLANK("^[A-Za-z\\u0020]*$");

    private final String value;

    public String getValue() {
        return value;
    }

    PatternEnum(String value) {
        this.value = value;
    }

}
