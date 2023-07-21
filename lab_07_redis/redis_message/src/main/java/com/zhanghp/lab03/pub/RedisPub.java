package com.zhanghp.lab03.pub;

import com.zhanghp.enums.ChannelEnum;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author zhanghp
 * @date 2023/7/21 17:56
 */
@Component
public class RedisPub {
    @Resource
    private RedisTemplate<String, String> redisTemplate;

    public void pub() {
        redisTemplate.convertAndSend(ChannelEnum.LAB03_CONTAINER_CHANNEL.getChannel(), "发送消息");
    }
}
