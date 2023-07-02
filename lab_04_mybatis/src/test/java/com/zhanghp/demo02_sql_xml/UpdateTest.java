package com.zhanghp.demo02_sql_xml;

import com.zhanghp.dao.pojo.Demo;
import org.junit.Test;

/**
 * @author zhanghp
 * @date 2023/6/26 8:34
 */
public class UpdateTest {
    private final UpdateDemo updateDemo = new UpdateDemo();

    @Test
    public void updateOne() {
        // sql: update demo set name = '小陈', age = 18 where id = 1
        updateDemo.updateOne();
    }

    @Test
    public void updateByDemo() {
        // sql: update demo set name = '小胡', age = 50 where id = 4
        updateDemo.updateByDemo(new Demo(4, "小胡", 50));
    }
}
