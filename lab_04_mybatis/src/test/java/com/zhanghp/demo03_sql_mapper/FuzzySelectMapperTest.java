package com.zhanghp.demo03_sql_mapper;

import org.junit.Test;

/**
 * @author zhanghp
 * @date 2023/6/26 23:09
 */
public class FuzzySelectMapperTest {

	private final FuzzySelectMapperDemo DEMO = new FuzzySelectMapperDemo();

	@Test
	public void fuzzyQuery() {
		DEMO.fuzzyQuery("小");
	}

}
