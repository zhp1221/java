package com.zhanghp.config.tenant;

import cn.hutool.core.collection.IterUtil;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.handler.TenantLineHandler;
import com.baomidou.mybatisplus.extension.plugins.inner.TenantLineInnerInterceptor;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.LongValue;
import net.sf.jsqlparser.expression.NullValue;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

/**
 * @author zhanghp
 * @since 2023/11/24 17:51
 */
@Configuration
public class DeepTenantConfig {

    @Bean
    @Order(Integer.MIN_VALUE)
    @ConditionalOnProperty(prefix = "custom.tenant", value = "deep-config", havingValue = "true")
    public MybatisPlusInterceptor mybatisPlusInterceptor(TenantProperties properties) {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new TenantLineInnerInterceptor(new TenantLineHandler() {
            @Override
            public Expression getTenantId() {
                Long tenantId = TenantContextHolder.getTenantId();
                if (tenantId == null) {
                    return new NullValue();
                }
                return new LongValue(tenantId);
            }

            @Override
            public String getTenantIdColumn() {
                return properties.getTenantId();
            }

            // 这是 default 方法,默认返回 false 表示所有表都需要拼多租户条件
            @Override
            public boolean ignoreTable(String tableName) {
                if (TenantContextHolder.getTenantSkip()) {
                    return Boolean.TRUE;
                }
                Long tenantId = TenantContextHolder.getTenantId();
                if (tenantId == null) {
                    return Boolean.TRUE;
                }
                if (IterUtil.isEmpty(properties.getIgnoreTables())) {
                    return false;
                }
                if (properties.getIgnoreTables().contains(tableName)) {
                    return true;
                }
                return false;
            }
        }));
        return interceptor;
    }

}
