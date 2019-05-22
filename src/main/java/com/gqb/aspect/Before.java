package com.gqb.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)//order表示切面的执行顺序，数字越小越先执行，该注解只对类有效，对方法无效
@Aspect //标注切面
@Component //标注这个类为Spring的一个组件，相当于在xml中注册一个bean
public class Before {
    public void init(){
        System.out.println("初始化一个学生");
    }

    //监控切入点 切入到com包及其子包下的所有类的方法
    @org.aspectj.lang.annotation.Before("execution(* com..*.*(..))")
    public void getInfo(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature().getName());//获得切入点方法名并输出
    }
}
