package com.zhanghp.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

/**
 * @author zhanghp
 * @date 2023/7/12 16:33
 */
@Getter
@AllArgsConstructor
public enum SexEnum {
    UN_DEFINED(0, "未填写"),
    MAN(1, "男"),
    WOMEN(2, "女"),
    ;
    private final Integer type;
    private final String name;

    public static Integer getType(String sex) {
        Integer result = SexEnum.UN_DEFINED.getType();
        if (Objects.isNull(sex)) {
            return result;
        }
        for (SexEnum it : SexEnum.values()) {
            if (it.getName().equals(sex)) {
                result = it.getType();
            }
        }
        return result;
    }

    public static String getName(Integer type) {
        String result = SexEnum.UN_DEFINED.getName();
        if (Objects.isNull(type)) {
            return result;
        }
        for (SexEnum it : SexEnum.values()) {
            if (type.equals(it.getType())) {
                result = it.getName();
            }
        }
        return result;
    }
}
