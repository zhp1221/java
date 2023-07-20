package com.zhanghp.connection;

import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Redis 连接器配置
 *
 * @author zhanghp
 * @date 2023/7/20 19:57
 */
@Repository
public class RedisCon {

    /**
     * Jedis连接工厂bean注入
     *
     * @return {@link JedisConnectionFactory}
     */
    @Bean("jedisConnectionFactory")
    public JedisConnectionFactory jedisConnectionFactory(){
        return new JedisConnectionFactory();
    }

    /**
     * jedis连接bean注入
     *
     * @return {@link JedisConnection}
     */
    @Bean("jedisConnection")
    public JedisConnection jedisConnection(){
        return new JedisConnection(new Jedis());
    }

    /**
     * 通过JedisFactory工厂生成RedisConnection
     *
     * @param jedisConnectionFactory 注入的Jedis工厂bean
     * @return {@link RedisConnection}
     */
    @Bean("redisConnection")
    public RedisConnection redisConnection(JedisConnectionFactory jedisConnectionFactory){
        return jedisConnectionFactory.getConnection();
    }
}
