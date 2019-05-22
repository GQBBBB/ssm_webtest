package com.gqb;

import com.gqb.pojo.Student;
import com.gqb.service.StudentService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//Spring
public class Test2 {
    @Test
    public void m1(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student = (Student) ctx.getBean("student");
        System.out.println(student);

    }

    @Test
    public void m2(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student = (Student) ctx.getBean("student2");
        System.out.println(student);

    }

    @Test
    public void m3(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentService studentService = (StudentService) ctx.getBean("studentService");
        studentService.read();

    }

    @Test
    public void m4(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentService studentService = (StudentService) ctx.getBean("studentService");
        studentService.testException();

    }

}
