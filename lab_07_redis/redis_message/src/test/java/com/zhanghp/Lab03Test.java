package com.zhanghp;

import com.zhanghp.lab03.pub.RedisPub;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;

/**
 * @author zhanghp
 * @date 2023/7/21 18:09
 */
public class Lab03Test extends RedisMessageApplicationTests {
    @Resource
    private RedisPub redisPub;

    @Test
    public void pub() {
        redisPub.pub();
    }
}
