package com.zhanghp.demo03_sql_mapper;

import com.zhanghp.connect.ConnectUtil;
import com.zhanghp.dao.mapper.DemoAnnotationMapper;
import com.zhanghp.dao.pojo.Demo;
import com.zhanghp.utils.CommonUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhanghp
 * @date 2023/6/26 11:21
 */
public class DemoAnnotationTest {
    final SqlSession SQLSESSION = ConnectUtil.getSqlSession();
    final DemoAnnotationMapper mapper = SQLSESSION.getMapper(DemoAnnotationMapper.class);

    @Test
    public void queryAll() {
        CommonUtil.printList(mapper.queryAll());
    }

    @Test
    public void queryById() {
        System.out.println(mapper.queryById(1));
    }

    @Test
    public void queryByMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "小陈");
        map.put("age", 18);
        CommonUtil.printList(mapper.queryByMap(map));
    }

    @Test
    public void queryByDemo() {
        CommonUtil.printList(mapper.queryByDemo(new Demo(null, "小陈", 18)));
    }

    @Test
    public void insertByMap() {
        Map<String, Object> map = new HashMap<String, Object>() {{
            put("id", 200);
            put("name", "小白");
            put("age", 10);
        }};
        System.out.println(mapper.insertByMap(map));
    }

    @Test
    public void insertByDemo() {
        System.out.println(mapper.insertByDemo(new Demo(300, "小黑", 10)));
    }

    @Test
    public void updateByParams() {
        System.out.println(mapper.updateByParams("小红", 20, 300));
    }

    @Test
    public void deleteById() {
        System.out.println(mapper.deleteById(300));
    }

}
