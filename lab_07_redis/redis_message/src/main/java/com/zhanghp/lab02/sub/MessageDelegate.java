package com.zhanghp.lab02.sub;

import java.io.Serializable;
import java.util.Map;

/**
 * @author zhanghp
 * @date 2023/7/21 9:51
 */
public interface MessageDelegate {
    void handleMessage(String message);

    void handleMessage(Map message);

    void handleMessage(byte[] message);

    void handleMessage(Serializable message);

    // pass the channel/pattern as well
    void q(Serializable message, String channel);
}
