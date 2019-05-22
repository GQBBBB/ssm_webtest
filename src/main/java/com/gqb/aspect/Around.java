package com.gqb.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

public class Around {
    public Object around(ProceedingJoinPoint proceedingJoinPoint) {
        try {
            System.out.println("around aspect执行");
            return proceedingJoinPoint.proceed();//只有这样 around 才能放任程序继续执行
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return null;
        }
    }
//错误使用，around 以下程序（包括其他切面）不会继续执行
//    public void around(){
//        System.out.println("around aspect执行");
//    }
}
