package com.zhanghp.connect;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * 连接数据库工具类
 *
 * @author zhanghp
 * @date 2023/6/25 23:53
 */
public class ConnectUtil {

	/**
	 * xml配置路径
	 */
	private static final String RESOURCE = "mybatis-config.xml";

	public ConnectUtil() {
	}

	/**
	 * 获取SqlSession
	 * @return {@link org.apache.ibatis.session.SqlSession}
	 */
	public static SqlSession getSqlSession() {
		InputStream resourceAsStream = null;
		try {
			// MyBatis 包含一个名叫 Resources 的工具类，它包含一些实用方法，使得从类路径或其它位置加载资源文件更加容易。
			resourceAsStream = Resources.getResourceAsStream(RESOURCE);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		// 初始化SqlSessionFactory：连接数据库的工厂类
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
		// 增删改需要手动提交事务
		// openSession(true)；设置是否自动提交事务，true为自动提交，false为不自动提交（例子：修改方法）
		// Spring整合后，就不在需要手动处理事务
		return sqlSessionFactory.openSession(true);
	}

	/**
	 * 释放资源
	 * @param session {@link org.apache.ibatis.session.SqlSession}
	 */
	public static void release(SqlSession session) {
		session.close();
	}

}
