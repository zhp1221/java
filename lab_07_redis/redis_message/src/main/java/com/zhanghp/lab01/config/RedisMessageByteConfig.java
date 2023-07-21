package com.zhanghp.lab01.config;

import com.zhanghp.enums.ChannelEnum;
import com.zhanghp.lab01.sub.RedisByteSub;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.RedisSerializer;

/**
 * @author zhanghp
 * @date 2023/7/20 20:06
 */
@Slf4j
@Configuration
public class RedisMessageByteConfig {

    @Bean
    RedisMessageListenerContainer messageContainer(JedisConnectionFactory jedisConnectionFactory, MessageListenerAdapter messageByteListener) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(jedisConnectionFactory);
        container.addMessageListener(messageByteListener, ChannelTopic.of(ChannelEnum.LAB01_BYTE_CHANNEL.getChannel()));
        return container;
    }

    @Bean("messageByteListener")
    MessageListenerAdapter redisSub(RedisByteSub listener) {
        log.info("RedisByteSub register");
        MessageListenerAdapter listenerAdapter = new MessageListenerAdapter(listener, "onMessage");
        listenerAdapter.setSerializer(RedisSerializer.json());
        return listenerAdapter;
    }
}
