package com.gqb.aspect;

public class After {
    public void afterReturn(Object returnValue){
        System.out.println("返回值：" + returnValue);
    }
}
