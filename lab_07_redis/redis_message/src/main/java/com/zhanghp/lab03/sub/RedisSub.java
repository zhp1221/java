package com.zhanghp.lab03.sub;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

/**
 * @author zhanghp
 * @date 2023/7/21 17:57
 */
@Slf4j
@Component
public class RedisSub implements MessageListener {

	@Override
	public void onMessage(Message message, byte[] pattern) {
		log.info("RedisSub 接收一条消息:{}", message);
	}

}
