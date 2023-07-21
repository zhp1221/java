package com.zhanghp.lab02.sub;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Map;

/**
 * @author zhanghp
 * @date 2023/7/21 9:58
 */
@Slf4j
@Component
public class DefaultMessageDelegate implements MessageDelegate {
    @Override
    public void handleMessage(String message) {
        log.info("DefaultMessageDelegate 接收到一条消息，消息类型为String：{}", message);
    }

    @Override
    public void handleMessage(Map message) {
        log.info("DefaultMessageDelegate 接收到一条消息，消息类型为map:{}", message);
    }

    @Override
    public void handleMessage(byte[] message) {
        log.info("DefaultMessageDelegate 接收到一条消息，消息类型为字节码:{}", message);
        log.info("字节码转换：{}", String.valueOf(message));
    }

    @Override
    public void handleMessage(Serializable message) {
        log.info("DefaultMessageDelegate 接收到一条消息，消息类型为Serializable:{}", message);
    }

    @Override
    public void q(Serializable message, String channel) {
        log.info("channel为：{}", channel);
        log.info("DefaultMessageDelegate 接收到一条消息，消息类型为Serializable:{}", message);
    }
}
