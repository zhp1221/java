package com.zhanghp.lab01.sub;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

/**
 * @author zhanghp
 * @date 2023/7/20 19:54
 */
@Slf4j
@Component
public class RedisByteSub implements MessageListener {

	@Override
	public void onMessage(Message message, byte[] pattern) {
		log.info("RedisByteSub 收到一条消息：{}", message.toString());
	}

}
