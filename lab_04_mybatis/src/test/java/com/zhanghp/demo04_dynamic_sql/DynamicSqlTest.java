package com.zhanghp.demo04_dynamic_sql;

import org.junit.Test;

/**
 * @author zhanghp
 * @date 2023/6/27 19:07
 */
public class DynamicSqlTest {
    private final DynamicSqlDemo DEMO = new DynamicSqlDemo();

    @Test
    public void dynamicIf() {
        DEMO.dynamicIf();
    }

    @Test
    public void dynamicIfByDemo() {
        DEMO.dynamicIfByDemo();
    }

    @Test
    public void dynamicIfFuzzy() {
        DEMO.dynamicIfFuzzy();
    }

    @Test
    public void dynamicChooseWhenAndOtherwise() {
        DEMO.dynamicChooseWhenAndOtherwise();
    }

    @Test
    public void dynamicWhere() {
        DEMO.dynamicWhere();
    }

    @Test
    public void dynamicTrim() {
        DEMO.dynamicTrim();
    }

    @Test
    public void dynamicSet() {
        DEMO.dynamicSet();
    }

    @Test
    public void dynamicForeach() {
        DEMO.dynamicForeach();
    }

    @Test
    public void dynamicSql() {
        DEMO.dynamicSql();
    }

    @Test
    public void dynamicBind() {
        DEMO.dynamicBind();
    }


}
