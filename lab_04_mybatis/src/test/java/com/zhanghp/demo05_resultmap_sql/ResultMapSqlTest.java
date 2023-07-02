package com.zhanghp.demo05_resultmap_sql;

import org.junit.Test;

/**
 * @author zhanghp
 * @date 2023/7/2 21:47
 */
public class ResultMapSqlTest {

    private final ResultMapSqlDemo DEMO = new ResultMapSqlDemo();

    @Test
    public void queryResultMap() {
        DEMO.queryResultMap();
    }

    @Test
    public void queryConstructor() {
        DEMO.queryConstructor();
    }

    @Test
    public void oneToOne() {
        DEMO.queryAssociation();
        DEMO.queryAssociation2();
        DEMO.queryAssociation3();
    }

    @Test
    public void oneToMulti() {
        DEMO.queryOneToMulti();
    }

    @Test
    public void multiToMulti() {
        DEMO.queryMultiToMulti();
    }

    @Test
    public void callProcedure() {
        DEMO.callProcedure(20);
    }
}
