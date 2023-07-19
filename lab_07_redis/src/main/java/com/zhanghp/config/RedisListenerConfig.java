package com.zhanghp.config;

import com.zhanghp.entity.ListenerObject;
import com.zhanghp.listen.RedisAnotherListener;
import com.zhanghp.listen.RedisListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.RedisSerializer;

@Configuration
public class RedisListenerConfig {

    public static final String TOPIC = "topic_1";

    /**
     * 监听注册
     *
     * @param connectionFactory redis连接工厂
     * @param redisAdapter 监听对象bean
     * @param redisAnotherAdapter 监听对象bean2
     * @return 监听容器
     */
    @Bean
    RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory, MessageListenerAdapter redisAdapter,
                                            MessageListenerAdapter redisAnotherAdapter) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.addMessageListener(redisAdapter, new PatternTopic(TOPIC));
        container.addMessageListener(redisAnotherAdapter, new PatternTopic(TOPIC));
        return container;
    }

    // 若不指定bean名称，则根据方法名进行注册
    @Bean("redisAdapter")
    MessageListenerAdapter listenerAdapter(RedisListener listener1) {
        System.out.println("listener1 register");
        MessageListenerAdapter listenerAdapter = new MessageListenerAdapter(listener1, "onMessage");
        listenerAdapter.setSerializer(RedisSerializer.json());
        return listenerAdapter;
    }

    @Bean("redisAnotherAdapter")
    MessageListenerAdapter listenerAdapter2(RedisAnotherListener listener2) {
        System.out.println("listener2 register");
        MessageListenerAdapter listenerAdapter = new MessageListenerAdapter(listener2, "onMessage");
        listenerAdapter.setSerializer(RedisSerializer.java());
        return listenerAdapter;
    }
}