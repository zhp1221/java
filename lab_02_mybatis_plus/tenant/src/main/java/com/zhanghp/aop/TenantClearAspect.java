package com.zhanghp.aop;

import com.zhanghp.annotation.TenantClear;
import com.zhanghp.config.tenant.TenantContextHolder;
import lombok.SneakyThrows;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

/**
 * @author zhanghp
 * @since 2023/11/21 20:41
 */
@Aspect
@Component
public class TenantClearAspect {

	@SneakyThrows
	@Around("@within(clear) || @annotation(clear)")
	public Object around(ProceedingJoinPoint point, TenantClear clear) {
		// 如果在类上，而不是在方法上，则为空
		if (clear == null) {
			Class<?> aClass = point.getTarget().getClass();
			clear = AnnotationUtils.findAnnotation(aClass, TenantClear.class);
		}
		if (clear != null) {
			TenantContextHolder.setTenantSkip();
		}
		return point.proceed();
	}

}
