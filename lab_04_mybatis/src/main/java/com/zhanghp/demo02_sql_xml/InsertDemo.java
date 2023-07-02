package com.zhanghp.demo02_sql_xml;

import com.zhanghp.connect.ConnectUtil;
import com.zhanghp.dao.pojo.Demo;
import org.apache.ibatis.session.SqlSession;

/**
 * 插入
 *
 * @author zhanghp
 * @date 2023/6/26 8:31
 */
public class InsertDemo {
    /**
     * 获取SqlSession
     */
    private final SqlSession SQLSESSION = ConnectUtil.getSqlSession();

    /**
     * 插入固定数据
     */
    public void addOne() {
        try {
            final int rows = SQLSESSION.insert("addOne");
            System.out.println("插入成功的行数：" + rows);
        } finally {
            ConnectUtil.release(SQLSESSION);
        }
    }

    /**
     * 通过对象作为参数传递，新增一条记录
     */
    public void addOneByDemo(Demo demo) {
        try {
            final int rows = SQLSESSION.insert("addOneByDemo", demo);
            System.out.println("插入成功的行数：" + rows);
        } finally {
            ConnectUtil.release(SQLSESSION);
        }
    }

    /**
     * 通过对象作为参数传递，使用数据库主键自增策略，实现新增一条记录
     */
    public void addOneByDemoUseGenerateKey(Demo demo) {
        try {
            final int rows = SQLSESSION.insert("addOneByDemo", demo);
            System.out.println("插入成功的行数：" + rows);
        } finally {
            ConnectUtil.release(SQLSESSION);
        }
    }

}
