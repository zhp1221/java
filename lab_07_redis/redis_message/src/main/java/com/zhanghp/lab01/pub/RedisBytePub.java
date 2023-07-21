package com.zhanghp.lab01.pub;

import com.zhanghp.enums.ChannelEnum;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnection;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author zhanghp
 * @date 2023/7/20 19:54
 */
@Component
public class RedisBytePub {
    @Resource(name = "jedisConnection")
    private JedisConnection jedisCon;

    @Resource(name = "redisConnection")
    private RedisConnection redisCon;

    public void pubByJedisCon() {
        // 字节方式
        byte[] channel = ChannelEnum.LAB01_BYTE_CHANNEL.getChannel().getBytes();
        byte[] message = "Jedis连接器 -- message".getBytes();
        jedisCon.publish(channel, message);
    }

    public void pubByRedisCon() {
        byte[] channel = ChannelEnum.LAB01_BYTE_CHANNEL.getChannel().getBytes();
        byte[] message = "Redis连接器 -- message".getBytes();
        redisCon.publish(channel, message);
    }
}
