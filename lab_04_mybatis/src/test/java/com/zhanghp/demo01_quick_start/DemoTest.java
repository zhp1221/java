package com.zhanghp.demo01_quick_start;

import org.junit.Test;

/**
 * @author zhanghp
 * @date 2023/6/25 15:00
 */
public class DemoTest {

    @Test
    public void testConnectAndSelectOneRecord() {
        final ConnectionDbWithXml connectionDBWithXml = new ConnectionDbWithXml();
        connectionDBWithXml.connect();
    }
}
