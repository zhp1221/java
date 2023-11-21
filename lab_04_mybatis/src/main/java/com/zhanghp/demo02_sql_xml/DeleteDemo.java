package com.zhanghp.demo02_sql_xml;

import com.zhanghp.connect.ConnectUtil;
import org.apache.ibatis.session.SqlSession;

/**
 * 删除
 *
 * @author zhanghp
 * @date 2023/6/26 8:31
 */
public class DeleteDemo {

	/**
	 * 获取SqlSession
	 */
	private final SqlSession SQLSESSION = ConnectUtil.getSqlSession();

	/**
	 * 删除固定一条记录
	 */
	public void deleteOne() {
		try {
			final int rows = SQLSESSION.delete("deleteOne");
			System.out.println("删除成功的行数：" + rows);
		}
		finally {
			ConnectUtil.release(SQLSESSION);
		}
	}

	/**
	 * 通过主键id删除固定一条记录
	 */
	public void deleteOneById(Integer id) {
		try {
			final int rows = SQLSESSION.delete("deleteOneById", id);
			System.out.println("删除成功的行数：" + rows);
		}
		finally {
			ConnectUtil.release(SQLSESSION);
		}
	}

}
