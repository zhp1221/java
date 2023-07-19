package com.zhanghp.lab02_converter.annotation;

import java.lang.annotation.*;

/**
 * @author zhanghp
 * @date 2023/7/12 16:35
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ExcelEnum {

    Class<? extends Enum<?>> enumClass();
}
