package com.zhanghp.lab01.pub;

import com.zhanghp.enums.ChannelEnum;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author zhanghp
 * @date 2023/7/20 19:54
 */
@Component
public class RedisPub {
    @Resource(name = "jedisConnection")
    private JedisConnection con;

    public void publishByBytes(){
        // 字节方式
        byte[] channel = ChannelEnum.LAB01_CHANNEL.getChannel().getBytes();
        byte[] message = "Jedis连接池 -- message".getBytes();
        con.publish(channel, message);
    }
}
