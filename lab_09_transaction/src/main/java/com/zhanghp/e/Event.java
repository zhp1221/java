package com.zhanghp.e;

import org.springframework.context.ApplicationEvent;

/**
 * @author zhanghp
 * @since 2023/9/14 16:32
 */
public class Event extends ApplicationEvent {
    public Event(Object source) {
        super(source);
        System.out.println("我是event");
    }
}
