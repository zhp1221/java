package com.zhanghp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

/**
 *
 *
 * @author zhanghp
 * @date 2023/7/19 18:57
 */
@Configuration
public class JedisConnectionPoolsConfig {
    @Bean("simpleConnection")
    public JedisConnectionFactory redisConnectionFactory(){
        return new JedisConnectionFactory();
    }
    @Bean("configConnection")
    public JedisConnectionFactory redisConnectionFactory2(){
        final RedisStandaloneConfiguration config = new RedisStandaloneConfiguration("localhost", 6379);
        return new JedisConnectionFactory(config);

    }
}
