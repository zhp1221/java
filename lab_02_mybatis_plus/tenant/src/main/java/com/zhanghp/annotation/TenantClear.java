package com.zhanghp.annotation;

import java.lang.annotation.*;

/**
 * @author zhanghp
 * @since 2023/11/21 20:41
 */
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TenantClear {

}
