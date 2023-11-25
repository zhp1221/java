package com.zhanghp.service.impl;

import com.zhanghp.annotation.TenantClear;
import com.zhanghp.dao.bean.Demo;
import com.zhanghp.dao.mapper.DemoMapper;
import com.zhanghp.service.DemoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
	public int addOne(Demo demo) {
		return baseMapper.insert(demo);
	}

	@Override
	public List<Demo> getAll() {
		return super.list();
	}

	@Override
	@TenantClear(globalFlag = false)
	public List<Demo> getAllByTenantClear() {
		return super.list();
	}

}
