package com.zhanghp.demo01_quick_start;

import cn.hutool.core.util.ObjectUtil;
import com.zhanghp.dao.pojo.Demo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * XML 中构建 SqlSessionFactory
 *
 * @author zhanghp
 * @date 2023/6/25 14:24
 */
public class ConnectionDbWithXml {

    /**
     * xml配置路径
     */
    private static final String RESOURCE = "mybatis-config.xml";
    /**
     * 连接数据库的工厂类
     */
    private static final SqlSessionFactory SQL_SESSION_FACTORY;

    static {
        InputStream resourceAsStream = null;
        try {
            // MyBatis 包含一个名叫 Resources 的工具类，它包含一些实用方法，使得从类路径或其它位置加载资源文件更加容易。
            resourceAsStream = Resources.getResourceAsStream(RESOURCE);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 初始化SqlSessionFactory
        SQL_SESSION_FACTORY = new SqlSessionFactoryBuilder().build(resourceAsStream);
    }

    public void connect() {
        // SqlSession 提供了在数据库执行 SQL 命令所需的所有方法
        try (SqlSession session = SQL_SESSION_FACTORY.openSession()) {
            // DemoMapper.xml中的select的id：selectOneRecord
            Demo record = session.selectOne("selectOneRecord");
            System.out.println(record);
            System.out.println("---------------------------------");
            List<Demo> recordList = session.selectList("selectDemo");
            if (ObjectUtil.isNotEmpty(record)) {
                recordList.forEach(System.out::println);
            }
        }
    }
}
