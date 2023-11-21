package com.zhanghp.demo02_sql_xml;

import com.zhanghp.dao.pojo.Demo;
import org.junit.Test;

/**
 * @author zhanghp
 * @date 2023/6/26 8:34
 */
public class InsertTest {

	private final InsertDemo insertDemo = new InsertDemo();

	@Test
	public void addOne() {
		// sql: insert into demo values (100, '测试', 30)
		insertDemo.addOne();
	}

	@Test
	public void addOneByDemo() {
		// sql: insert into demo values (4, '小胡', 30)
		insertDemo.addOneByDemo(new Demo(4, "小胡", 30));
	}

	@Test
	public void addOneByDemoUseGenerateKey() {
		// sql: insert into demo values (null, '小李', 30)
		insertDemo.addOneByDemoUseGenerateKey(new Demo(null, "小李", 40));
	}

}
