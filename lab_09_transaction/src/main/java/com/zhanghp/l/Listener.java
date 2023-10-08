package com.zhanghp.l;

import com.zhanghp.e.Event;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author zhanghp
 * @since 2023/9/14 16:32
 */
@Component
public class Listener {
    @EventListener
    public void handleCustomEvent(Event event) {
        // 在这里处理自定义事件
        System.out.println("接收到自定义事件: " + event.toString());
    }
}
