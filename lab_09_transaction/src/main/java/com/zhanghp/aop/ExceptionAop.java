package com.zhanghp.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author zhanghp
 * @since 2023/9/11 16:05
 */
@Component
@Aspect
public class ExceptionAop {
    @Pointcut("within(com.zhanghp.handle..*)")
    public void po(){}

    @Before("po()")
    public void before(){
        System.out.println("before ------------------------>");
    }
    @AfterThrowing(pointcut = "po()", throwing="ex")
    public void throwAdvice(JoinPoint joinPoint, Exception ex){
        System.out.println("********** 【Aspectj异常通知】执行开始 **********");
        System.out.println(joinPoint.getArgs()[0]);
        System.out.println("出现异常：" + ex.getMessage());
        System.out.println("********** 【Aspectj异常通知】执行结束 **********");
    }

//    @Around("po()")
//    public Object logException(ProceedingJoinPoint joinPoint) throws Throwable {
//
//        System.out.println("方法环绕begin...参数："+ Arrays.toString(joinPoint.getArgs()));
//        try {
//            Object ret= joinPoint.proceed();
//            System.out.println("方法环绕end...结果："+ret);
//            return ret;
//        } catch (Throwable throwable) {
//            System.out.println("抛异常啦！");
//            throwable.printStackTrace();
//        }
//        return null;
//
//    }

}
