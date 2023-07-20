package com.zhanghp;

import com.zhanghp.lab01.pub.RedisPub;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;

/**
 * @author zhanghp
 * @date 2023/7/20 20:14
 */
public class Lab01Test extends RedisMessageApplicationTests{
    @Resource
    private RedisPub redisPub;
    @Test
    public void sub(){
        redisPub.publishByBytes();
    }
}
