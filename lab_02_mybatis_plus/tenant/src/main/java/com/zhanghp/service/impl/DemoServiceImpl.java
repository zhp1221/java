package com.zhanghp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhanghp.annotation.TenantClear;
import com.zhanghp.dao.bean.Demo;
import com.zhanghp.dao.mapper.DemoMapper;
import com.zhanghp.service.DemoService;
import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * mybatis - demo表 服务实现类
 * </p>
 *
 * @author zhp
 * @since 2023-11-20
 */
@Service
public class DemoServiceImpl extends ServiceImpl<DemoMapper, Demo> implements DemoService {

    @Override
    @TenantClear(globalFlag = false)
    public List<Demo> getAllByTenantClear() {
        return super.list();
    }

    @Override
    public void b() {

        super.list();
    }

    @Override
    @TenantClear(globalFlag = false)
    public void a() {
        super.list();
    }

    @Override
    @TenantClear(globalFlag = true)
    public void c() {
        super.list();
    }

    @Override
    public void d() {
		// aop方法内调用会失效
		// 解决引进当前代理对象
		// 在启动器加@EnableAspectJAutoProxy(proxyTargetClass = true,exposeProxy = true)
        DemoServiceImpl d = (DemoServiceImpl) AopContext.currentProxy();
        d.a();
        super.list();
    }
}
