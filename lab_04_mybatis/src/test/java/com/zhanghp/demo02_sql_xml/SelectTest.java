package com.zhanghp.demo02_sql_xml;

import com.zhanghp.dao.pojo.Demo;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhanghp
 * @date 2023/6/26 0:04
 */
public class SelectTest {

	private final SelectDemo SELECT_DEMO = new SelectDemo();

	@Test
	public void queryAll() {
		// select * from demo
		SELECT_DEMO.queryAll();
	}

	@Test
	public void queryReturnMap() {
		// sql: select * from demo
		SELECT_DEMO.queryReturnMap();
	}

	@Test
	public void queryById() {
		// sql: select * from demo where id = 1
		SELECT_DEMO.queryById(1);
	}

	@Test
	public void queryByMap() {
		// sql: select * from demo where name = '张三' and age = 18
		Map<String, Object> map = new HashMap<>();
		map.put("name", "张三");
		map.put("age", 18);
		SELECT_DEMO.queryByMap(map);
	}

	@Test
	public void queryByDemo() {
		// sql: select * from demo where age = 20
		final Demo demo = new Demo();
		demo.setAge(20);
		SELECT_DEMO.queryByDemo(demo);
	}

}
