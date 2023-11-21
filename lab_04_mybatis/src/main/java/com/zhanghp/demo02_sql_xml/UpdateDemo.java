package com.zhanghp.demo02_sql_xml;

import com.zhanghp.connect.ConnectUtil;
import com.zhanghp.dao.pojo.Demo;
import org.apache.ibatis.session.SqlSession;

/**
 * 更新
 *
 * @author zhanghp
 * @date 2023/6/26 8:31
 */
public class UpdateDemo {

	/**
	 * 获取SqlSession
	 */
	private final SqlSession SQLSESSION = ConnectUtil.getSqlSession();

	/**
	 * 固定更新一条数据
	 */
	public void updateOne() {
		try {
			final int rows = SQLSESSION.insert("updateOne");
			System.out.println("更新成功的行数：" + rows);
		}
		finally {
			ConnectUtil.release(SQLSESSION);
		}
	}

	/**
	 * 通过传入的对象，通过主键，更新其余的属性
	 */
	public void updateByDemo(Demo demo) {
		try {
			final int rows = SQLSESSION.update("updateByDemo", demo);
			System.out.println("更新成功的行数：" + rows);
		}
		finally {
			ConnectUtil.release(SQLSESSION);
		}
	}

}
