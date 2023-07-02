package com.zhanghp.demo03_sql_mapper;

import com.zhanghp.connect.ConnectUtil;
import com.zhanghp.dao.mapper.DemoMapper;
import com.zhanghp.dao.pojo.Demo;
import com.zhanghp.utils.CommonUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

/**
 * 参数传递的几种查询方式
 *
 * @author zhanghp
 * @date 2023/6/26 21:09
 */
public class SelectByParamMapperDemo {
    private final SqlSession SQLSESSION = ConnectUtil.getSqlSession();
    private final DemoMapper MAPPER = SQLSESSION.getMapper(DemoMapper.class);

    /**
     * 通过单个基本数据类型查询
     *
     * @param name 姓名
     */
    public void selectBySingleType(String name) {
        try {
            final List<Demo> demos = MAPPER.selectBySingleType(name);
            CommonUtil.printList(demos);
        } finally {
            ConnectUtil.release(SQLSESSION);
        }
    }

    /**
     * 通过多个基本数据类型查询
     *
     * @param name 姓名
     * @param age  年龄
     */
    public void selectByMultiType(String name, Integer age) {
        try {
            final List<Demo> demos = MAPPER.selectByMultiType(name, age);
            CommonUtil.printList(demos);
        } finally {
            ConnectUtil.release(SQLSESSION);
        }
    }

    /**
     * 通过实体类查询
     *
     * @param demo 实体类
     */
    public void selectByBean(Demo demo) {
        try {
            final List<Demo> demos = MAPPER.selectByBean(demo);
            CommonUtil.printList(demos);
        } finally {
            ConnectUtil.release(SQLSESSION);
        }
    }

    /**
     * 通过多个实体类查询
     *
     * @param demo01 实体类1
     * @param demo02 实体类2
     */
    public void selectByMultiBean(Demo demo01, Demo demo02) {
        try {
            final List<Demo> demos = MAPPER.selectByMultiBean(demo01, demo02);
            CommonUtil.printList(demos);
        } finally {
            ConnectUtil.release(SQLSESSION);
        }
    }

    /**
     * 通过map集合查询
     *
     * @param map map集合
     */
    public void selectByMap(Map<String, Object> map) {
        try {
            final List<Demo> demos = MAPPER.selectByMap(map);
            CommonUtil.printList(demos);
        } finally {
            ConnectUtil.release(SQLSESSION);
        }
    }
}
