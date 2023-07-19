package com.zhanghp.listen;

import com.alibaba.fastjson.JSONObject;
import com.zhanghp.entity.ListenerObject;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

/**
 * @author zhanghp
 * @date 2023/7/19 15:27
 */
@Component
public class RedisListener implements MessageListener {
    @Override
    public void onMessage(Message message, byte[] pattern) {
        final ListenerObject listenerObject = JSONObject.parseObject(message.toString(), ListenerObject.class);
        System.out.println(listenerObject);
    }
}
