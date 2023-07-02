package com.zhanghp.demo03_sql_mapper;

import com.zhanghp.dao.pojo.Demo;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhanghp
 * @date 2023/6/26 23:22
 */
public class SelectByParamMapperTest {
    private final SelectByParamMapperDemo DEMO = new SelectByParamMapperDemo();

    @Test
    public void selectBySingleType() {
        DEMO.selectBySingleType("小白");
    }

    @Test
    public void selectByMultiType() {
        DEMO.selectByMultiType("小白", 10);
    }

    @Test
    public void selectByBean() {
        DEMO.selectByBean(new Demo(null, "小白", 10));
    }

    @Test
    public void selectByMultiBean() {
        DEMO.selectByMultiBean(new Demo(null, "小白", null),
                new Demo(null, null, 10));
    }

    @Test
    public void selectByMap() {
        Map<String, Object> map = new HashMap<String, Object>() {{
            put("name", "小白");
            put("age", 10);
        }};
        DEMO.selectByMap(map);
    }

}
