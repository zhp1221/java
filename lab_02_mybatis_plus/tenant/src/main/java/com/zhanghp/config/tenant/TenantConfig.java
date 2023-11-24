package com.zhanghp.config.tenant;

import cn.hutool.core.collection.IterUtil;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.handler.TenantLineHandler;
import com.baomidou.mybatisplus.extension.plugins.inner.TenantLineInnerInterceptor;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.LongValue;
import net.sf.jsqlparser.expression.NullValue;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhanghp
 * @since 2023/11/20 14:29
 */
@Configuration
public class TenantConfig {

	/**
	 * 新多租户插件配置,一缓和二缓遵循mybatis的规则,需要设置 MybatisConfiguration#useDeprecatedExecutor = false
	 * 避免缓存万一出现问题
	 */
	@Bean
	@ConditionalOnMissingBean
	public MybatisPlusInterceptor mybatisPlusInterceptor(TenantProperties properties) {
		MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
		interceptor.addInnerInterceptor(new TenantLineInnerInterceptor(new TenantLineHandler() {
			@Override
			public Expression getTenantId() {
				return new LongValue(1);
			}

			@Override
			public String getTenantIdColumn() {
				return properties.getTenantId();
			}

			// 这是 default 方法,默认返回 false 表示所有表都需要拼多租户条件
			@Override
			public boolean ignoreTable(String tableName) {
				return false;
			}
		}));
		return interceptor;
	}

}
