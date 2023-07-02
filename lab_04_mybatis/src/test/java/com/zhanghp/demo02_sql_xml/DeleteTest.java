package com.zhanghp.demo02_sql_xml;

import org.junit.Test;

/**
 * @author zhanghp
 * @date 2023/6/26 8:34
 */
public class DeleteTest {
    private final DeleteDemo deleteDemo = new DeleteDemo();

    @Test
    public void deleteOne() {
        // sql:  delete from demo where id = 101
        deleteDemo.deleteOne();
    }

    @Test
    public void deleteOneById() {
        // sql:  delete from demo where id = 100
        deleteDemo.deleteOneById(100);
    }
}
