package com.zhanghp.config.tenant;

import com.alibaba.ttl.TransmittableThreadLocal;
import lombok.Data;
import lombok.experimental.UtilityClass;

/**
 * @author zhanghp
 * @since 2023/11/20 20:28
 */
@Data
@UtilityClass
public class TenantContextHolder {

	/**
	 * tenant_id
	 */
	private final ThreadLocal<Long> TENAT_ID = new TransmittableThreadLocal<>();

	/**
	 * 租户过滤标识
	 */
	private final ThreadLocal<Boolean> TENANT_SKIP = new TransmittableThreadLocal<>();

	/**
	 * 获取租户
	 * @return 租户id
	 */
	public Long getTenantId() {
		return TENAT_ID.get();
	}

	/**
	 * 设置租户
	 * @param tenantId 租户
	 */
	public void setTenantId(Long tenantId) {
		TENAT_ID.set(tenantId);
	}

	/**
	 * 设置是否过滤的标识
	 */
	public void setTenantSkip() {
		TENANT_SKIP.set(Boolean.TRUE);
	}

	/**
	 * 获取是否跳过租户过滤的标识
	 * @return true-过滤 false-不过滤
	 */
	public Boolean getTenantSkip() {
		return TENANT_SKIP.get() != null && TENANT_SKIP.get();
	}

	/**
	 * 清空租户信息
	 */
	public void clear() {
		TENAT_ID.remove();
		clearSkip();
	}

	public void clearSkip(){
		TENANT_SKIP.remove();
	}

}
