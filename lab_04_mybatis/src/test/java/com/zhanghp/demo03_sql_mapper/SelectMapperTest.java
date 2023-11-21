package com.zhanghp.demo03_sql_mapper;

import com.zhanghp.dao.pojo.Demo;
import org.junit.Test;

/**
 * @author zhanghp
 * @date 2023/6/26 13:35
 */
public class SelectMapperTest {

	private final SelectMapperDemo DEMO = new SelectMapperDemo();

	@Test
	public void queryAll() {
		// select * from demo
		DEMO.queryAll();
	}

	@Test
	public void insertOneByDemo() {
		// insert into demo values (null, '小刘', 22)
		DEMO.insertOneByDemo(new Demo(null, "小刘", 22));
	}

	@Test
	public void updateOneByDemo() {
		// update demo set name = '小贺', age = '11' where id = 1
		DEMO.updateOneByDemo(new Demo(1, "小贺", 11));
	}

	@Test
	public void deleteOneById() {
		// delete from demo where id = 1
		DEMO.deleteOneById(1);
	}

}
