package com.zhanghp;

import com.alibaba.fastjson.JSON;
import com.zhanghp.entity.ListenerObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

@SpringBootTest
class RedisTest {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    void testConnect() {
        stringRedisTemplate.opsForValue().set("zhp","123");
        redisTemplate.setValueSerializer(RedisSerializer.string());
        ListenerObject userDTO = new ListenerObject("sharloon", 18);
        redisTemplate.convertAndSend("topic_1", JSON.toJSONString(userDTO));
    }

}
