package com.gqb;

import com.gqb.service.StudentService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//Spring 注解测试
public class Test3 {
    @Test
    public void m1(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("SpringAnnotation/applicationContext.xml");
        StudentService studentService = (StudentService) ctx.getBean("studentService");
        studentService.read();
    }

    @Test
    public void m2(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("SpringAnnotation/applicationContext.xml");
        StudentService studentService = (StudentService) ctx.getBean("studentService");
        studentService.testException();
    }
}
