package com.zhanghp.interceptor;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.zhanghp.config.tenant.TenantContextHolder;
import com.zhanghp.config.tenant.TenantProperties;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zhanghp
 * @date 2023-11-25 13:48
 */
public class TenantInterceptor implements HandlerInterceptor {

    @Resource
    private TenantProperties properties;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String tenantId = request.getHeader(properties.getTenantId());
        if (StrUtil.isNotBlank(tenantId)) {
            TenantContextHolder.setTenantId(Convert.toLong(tenantId));
        }
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        TenantContextHolder.clear();
    }
}
