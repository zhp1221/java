package com.zhanghp.lab03.config;

import com.zhanghp.enums.ChannelEnum;
import com.zhanghp.lab03.sub.RedisSub;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.RedisSerializer;

/**
 * @author zhanghp
 * @date 2023/7/21 18:03
 */
@Slf4j
@Configuration
public class RedisMessageContainerConfig {

    @Bean("redisMessageContainer")
    RedisMessageListenerContainer redisMessageContainer(JedisConnectionFactory jedisConnectionFactory, MessageListenerAdapter messageContainerListener) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(jedisConnectionFactory);
        container.addMessageListener(messageContainerListener, new PatternTopic(ChannelEnum.LAB03_CONTAINER_CHANNEL.getChannel()));
        return container;
    }

    @Bean("messageContainerListener")
    MessageListenerAdapter messageContainerListener(RedisSub redisSub) {
        log.info("RedisSub register");
//        MessageListenerAdapter messageListenerAdapter = new MessageListenerAdapter(redisSub, "onMessage");
        // 默认回调"onMessage()"方法，方法参数可不用写
        MessageListenerAdapter messageListenerAdapter = new MessageListenerAdapter(redisSub);
        messageListenerAdapter.setSerializer(RedisSerializer.json());
        return messageListenerAdapter;
    }
}
