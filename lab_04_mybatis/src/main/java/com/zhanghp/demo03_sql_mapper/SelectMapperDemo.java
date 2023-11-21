package com.zhanghp.demo03_sql_mapper;

import com.zhanghp.connect.ConnectUtil;
import com.zhanghp.dao.mapper.DemoMapper;
import com.zhanghp.dao.pojo.Demo;
import com.zhanghp.utils.CommonUtil;
import org.apache.ibatis.session.SqlSession;

/**
 * @author zhanghp
 * @date 2023/6/26 13:30
 */
public class SelectMapperDemo {

	private final SqlSession SQLSESSION = ConnectUtil.getSqlSession();

	private final DemoMapper MAPPER = SQLSESSION.getMapper(DemoMapper.class);

	public void queryAll() {
		try {
			CommonUtil.printList(MAPPER.queryAll());
		}
		finally {
			ConnectUtil.release(SQLSESSION);
		}
	}

	public void insertOneByDemo(Demo demo) {
		try {
			System.out.println(MAPPER.insertOneByDemo(demo));
		}
		finally {
			ConnectUtil.release(SQLSESSION);
		}
	}

	public void updateOneByDemo(Demo demo) {
		try {
			System.out.println(MAPPER.updateOneByDemo(demo));
		}
		finally {
			ConnectUtil.release(SQLSESSION);
		}
	}

	public void deleteOneById(Integer id) {
		try {
			System.out.println(MAPPER.deleteOneById(id));
		}
		finally {
			ConnectUtil.release(SQLSESSION);
		}
	}

}
