package com.zhanghp.handle;

import org.springframework.stereotype.Component;

/**
 * @author zhanghp
 * @since 2023/9/11 16:05
 */
@Component
public class MethodTest {

    public void test(){
        System.out.println("我进来了");
        System.out.println("发生异常了");
        System.out.println("我出去了");
    }

    public void test2(int a, int b){
        System.out.println("我进来了");
           nestTest3();
        System.out.println("我出去了");
    }

    public void nestTest3(){
        System.out.println("nestTest3");
        int i = 1/0;
    }

}
