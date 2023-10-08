package com.zhanghp;

import com.zhanghp.p.Publisher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationEventPublisher;

/**
 * @author zhanghp
 * @since 2023/9/14 16:35
 */
@SpringBootTest
public class PL {
    @Autowired
    private Publisher eventPublisher;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Test
    public void testCustomEvent() {
        // 发布自定义事件
        eventPublisher.publishCustomEvent("测试消息");

        // 在这里添加断言或其他验证逻辑，确保监听器是否被调用
    }
}
