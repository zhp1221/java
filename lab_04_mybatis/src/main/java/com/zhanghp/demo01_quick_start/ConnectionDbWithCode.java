package com.zhanghp.demo01_quick_start;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import java.io.IOException;
import java.io.InputStream;

/**
 * Java Code 构建 SqlSessionFactory
 *
 * @author zhanghp
 * @date 2023/6/25 14:24
 */
public class ConnectionDbWithCode {

	private static final String RESOURCE = "mybatis-config.xml";

	private static final SqlSessionFactory SQL_SESSION_FACTORY;

	static {
		InputStream resourceAsStream = null;
		try {
			resourceAsStream = Resources.getResourceAsStream(RESOURCE);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		SQL_SESSION_FACTORY = new SqlSessionFactoryBuilder().build(resourceAsStream);
	}

	public void connect() {

		final MysqlDataSource mysqlDataSource = new MysqlDataSource();
		mysqlDataSource.setUser("root");
		mysqlDataSource.setPassword("zhp.1221");
		mysqlDataSource.setUrl(
				"jdbc:mysql://127.0.0.1:3306/test?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC");
		final JdbcTransactionFactory jdbcTransactionFactory = new JdbcTransactionFactory();
		final Environment environment = new Environment("connect_demo", jdbcTransactionFactory, mysqlDataSource);
		final Configuration configuration = new Configuration(environment);

	}

}
