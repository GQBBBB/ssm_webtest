package com.gqb.aspect;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Exception {
    @AfterThrowing(pointcut = "execution(* com.gqb.service.StudentService.testException(..))", throwing = "msg")
    public void exe(RuntimeException msg){
        System.out.println("刚刚抛出了一个异常:" + msg);
    }
}
