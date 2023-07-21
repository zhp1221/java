package com.zhanghp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

/**
 * @author zhanghp
 * @date 2023/7/21 17:57
 */
@Configuration
public class RedisConfig {
    @Bean("redisTemplate")
    RedisTemplate<String, String> redisTemplate(JedisConnectionFactory jedisConnectionFactory) {
        RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();
        // 配置连接工厂
        redisTemplate.setConnectionFactory(jedisConnectionFactory);
        // 配置序列化方式
        redisTemplate.setValueSerializer(RedisSerializer.json());
        return redisTemplate;
    }
}
