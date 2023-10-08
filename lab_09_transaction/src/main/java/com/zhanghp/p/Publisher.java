package com.zhanghp.p;

import com.zhanghp.e.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 * @author zhanghp
 * @since 2023/9/14 16:32
 */
@Component
public class Publisher {
    @Autowired
    private ApplicationEventPublisher eventPublisher;

    public void publishCustomEvent(String message){
        System.out.println("发送: " + message);
        Event event = new Event(this);
        eventPublisher.publishEvent(event);
    }
}
