package com.zhanghp.lab02.config;

import com.zhanghp.enums.ChannelEnum;
import com.zhanghp.lab02.sub.DefaultMessageDelegate;
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
 * @date 2023/7/21 9:35
 */
@Slf4j
@Configuration
public class RedisMessageDelegateConfig {

	@Bean("redisMessageDelegate")
	RedisMessageListenerContainer listenerContainer(JedisConnectionFactory jedisConnectionFactory,
			MessageListenerAdapter messageDelegate) {
		RedisMessageListenerContainer container = new RedisMessageListenerContainer();
		container.setConnectionFactory(jedisConnectionFactory);
		container.addMessageListener(messageDelegate, ChannelTopic.of(ChannelEnum.LAB02_DELEAGTE_CHANNEL.getChannel()));
		return container;
	}

	@Bean("messageDelegate")
	MessageListenerAdapter messageDelegate(DefaultMessageDelegate listener) {
		log.info("DefaultMessageDelegate register");
		// MessageListenerAdapter messageListenerAdapter = new
		// MessageListenerAdapter(listener, "handleMessage");
		MessageListenerAdapter messageListenerAdapter = new MessageListenerAdapter(listener);
		messageListenerAdapter.setSerializer(RedisSerializer.json());
		return messageListenerAdapter;
	}

}
