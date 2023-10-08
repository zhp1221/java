package com.zhanghp;

import com.zhanghp.handle.MethodTest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author zhanghp
 * @since 2023/9/11 16:13
 */
@SpringBootTest
public class ApplicationTest {
    @Resource
    private MethodTest methodTest;

    @Test
    public void testt(){
        methodTest.test2(1,2 );
    }
}
