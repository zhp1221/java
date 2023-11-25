package com.zhanghp.service;

import com.zhanghp.dao.bean.Demo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * mybatis - demo表 服务类
 * </p>
 *
 * @author zhp
 * @since 2023-11-20
 */
public interface DemoService extends IService<Demo> {

	List<Demo> getAllByTenantClear();

	void b();

	void a();

	void c();

	void d();


}
