package com.zhanghp.demo05_resultmap_sql;

import com.zhanghp.connect.ConnectOptionalEnvironmentUtil;
import com.zhanghp.connect.ConnectUtil;
import com.zhanghp.dao.pojo.Dept;
import com.zhanghp.dao.pojo.Emp;
import com.zhanghp.dao.pojo.Project;
import com.zhanghp.utils.CommonUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @author zhanghp
 * @date 2023/6/27 8:45
 */
public class ResultMapSqlDemo {
    private final String ENVIRONMENT = "deep_practice";
    private final SqlSession SQLSESSION = ConnectOptionalEnvironmentUtil.getSqlSession(ENVIRONMENT);

    /**
     * resultMap基本使用
     */
    public void queryResultMap() {
        try {
            // test1 : MyBatis 会在幕后自动创建一个 ResultMap，若属性名和列名不匹配，会返回null
            final List<Emp> results1 = SQLSESSION.selectList("queryResultType");
            CommonUtil.printList(results1);
            // test2 : resultMap 映射后，会重新自动转换名称不一致问题
            final List<Emp> results2 = SQLSESSION.selectList("queryResultMap");
            CommonUtil.printList(results2);
        } finally {
            ConnectUtil.release(SQLSESSION);
        }
    }

    /**
     * 通过<constructor/>元素查询
     */
    public void queryConstructor() {
        try {
            // test1 : MyBatis 会在幕后自动创建一个 ResultMap，若属性名和列名不匹配，会返回null
            final List<Dept> results = SQLSESSION.selectList("queryConstructor");
            CommonUtil.printList(results);
        } finally {
            ConnectUtil.release(SQLSESSION);
        }
    }

    /**
     * 一对一
     */
    public void queryAssociation() {
        try {
            final List<Emp> results1 = SQLSESSION.selectList("queryAssociation");
            CommonUtil.printList(results1);
        } finally {
            ConnectUtil.release(SQLSESSION);
        }
    }

    /**
     * 一对一
     * 引用select，引用外部的id
     */
    public void queryAssociation2() {
        try {
            // association对应的select属性查询dept表，是一个一个sql查询，比较消耗时间
            final List<Emp> results1 = SQLSESSION.selectList("queryAssociation2");
            CommonUtil.printList(results1);
        } finally {
            ConnectUtil.release(SQLSESSION);
        }
    }

    /**
     * 一对一
     * 引用select，引用内部的id
     */
    public void queryAssociation3() {
        try {
            // association对应的select属性查询dept表，是一个一个sql查询，比较消耗时间
            final List<Emp> results1 = SQLSESSION.selectList("queryAssociation3");
            CommonUtil.printList(results1);
        } finally {
            ConnectUtil.release(SQLSESSION);
        }
    }

    /**
     * 一对多查询
     */
    public void queryOneToMulti() {
        try {
            final List<Dept> results1 = SQLSESSION.selectList("queryOneToMulti");
            CommonUtil.printList(results1);
        } finally {
            ConnectUtil.release(SQLSESSION);
        }
    }

    /**
     * 多对多查询
     */
    public void queryMultiToMulti() {
        try {
            final List<Project> results1 = SQLSESSION.selectList("queryMultiToMulti");
            CommonUtil.printList(results1);
        } finally {
            ConnectUtil.release(SQLSESSION);
        }
    }

    /**
     * 调用存储过程
     */
    public void callProcedure(Integer deptno) {
        try {
            // association对应的select属性查询dept表，是一个一个sql查询，比较消耗时间
            final List<Emp> results1 = SQLSESSION.selectList("callProcedure", deptno);
            CommonUtil.printList(results1);
        } finally {
            ConnectUtil.release(SQLSESSION);
        }
    }

}
