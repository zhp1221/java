package com.zhanghp.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.zhanghp.config.tenant.TenantContextHolder;
import org.apache.ibatis.reflection.MetaObject;

/**
 * @author zhanghp
 * @since 2023/11/20 20:25
 */
public class CustomMetaObjectHandler implements MetaObjectHandler {

    private static final String TENANT_ID = "tenantId";

    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName(TENANT_ID, TenantContextHolder.getTenantId(), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {

    }
}
