package com.zhanghp;

import com.zhanghp.dao.bean.Demo;
import com.zhanghp.dao.mapper.DemoMapper;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;

/**
 * @author zhanghp
 * @since 2023/11/20 14:21
 */
public class MpTest extends AppTest {

	@Resource
	private DemoMapper demoMapper;

	@Test
	public void select() {
		demoMapper.selectList(null);
	}

	@Test
	public void insert() {
		demoMapper.insert(Demo.builder().id(100).age(18).name("草莓熊").build());
	}

	@Test
	public void update() {
		demoMapper.updateById(Demo.builder().id(100).age(20).name("皮卡").build());
	}

	@Test
	public void delete() {
		demoMapper.deleteById(Demo.builder().id(100).build());
	}

}
