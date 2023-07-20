package com.zhanghp.connection;

import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author zhanghp
 * @date 2023/7/20 19:57
 */
@Repository
public class JedisCon {

    @Bean("jedisConnectionFactory")
    public JedisConnectionFactory jedisConnectionFactory(){
        return new JedisConnectionFactory();
    }

    @Bean("jedisConnection")
    public JedisConnection jedisConnection(){
        JedisPool jedisPool = new JedisPool("localhost", 6379);
        Jedis jedis = jedisPool.getResource();
        return new JedisConnection(jedis);
    }
}
