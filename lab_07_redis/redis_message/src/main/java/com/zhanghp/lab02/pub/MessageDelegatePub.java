package com.zhanghp.lab02.pub;

import com.zhanghp.enums.ChannelEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author zhanghp
 * @date 2023/7/21 9:38
 */
@Slf4j
@Component
public class MessageDelegatePub {
    @Resource(name = "redisTemplate")
    private RedisTemplate<String, String> redisTemplate;

    public void pub() {
        log.info("开始推送数据...");
        redisTemplate.convertAndSend(ChannelEnum.LAB02_DELEAGTE_CHANNEL.getChannel(), "推送数据");
    }
}
