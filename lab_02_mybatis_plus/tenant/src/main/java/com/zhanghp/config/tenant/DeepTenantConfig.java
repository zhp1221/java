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
                // 获取租户
                Long tenantId = TenantContextHolder.getTenantId();
                // 租户为空则返回空
                if (tenantId == null) {
                    return new NullValue();
                }
                // 返回租户
                return new LongValue(tenantId);
            }

            @Override
            public String getTenantIdColumn() {
                return properties.getTenantId();
            }

            // 这是 default 方法,默认返回 false 表示所有表都需要拼多租户条件
            @Override
            public boolean ignoreTable(String tableName) {
                // 1.是否跳过租户对该表对操作
                if (TenantContextHolder.getTenantSkip()) {
                    return Boolean.TRUE;
                }
                // 2.租户为空，则对该表不进行租户的操作
                Long tenantId = TenantContextHolder.getTenantId();
                if (tenantId == null) {
                    return Boolean.TRUE;
                }
                // 3.忽略表对配置为空，则所有表都进行租户操作
                if (IterUtil.isEmpty(properties.getIgnoreTables())) {
                    return false;
                }
                // 4.指定的表永远不进行租户操作
                if (properties.getIgnoreTables().contains(tableName)) {
                    return true;
                }
                return false;
            }
        }));
        return interceptor;
    }

}
