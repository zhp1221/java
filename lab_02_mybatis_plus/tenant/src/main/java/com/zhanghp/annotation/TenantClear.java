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

    /**
     * <p>是否全局过滤租户标志</p>
     * <ul>
     *     <li>true：执行完该线程之前，默认后续对db操作不添加租户操作</li>
     *     <li>false：执行完带有注解的方法后，默认后续的db操作添加租户操作</li>
     * </ul>
     *
     * @return 默认后续不添加租户操作
     */
    boolean globalFlag() default true;
}
