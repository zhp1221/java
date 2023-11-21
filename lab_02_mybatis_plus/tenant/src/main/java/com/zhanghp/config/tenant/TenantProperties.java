package com.zhanghp.config.tenant;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author zhanghp
 * @since 2023/11/20 20:47
 */
@Data
@Component
@ConfigurationProperties(prefix = "custom.tenant")
public class TenantProperties {

	/**
	 * 租户字段名
	 */
	private String tenantId;

	/**
	 * 过滤表
	 */
	private List<String> ignoreTables;

}
