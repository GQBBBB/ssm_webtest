package com.gqb.service;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class StudentService {
    public int read(){
        System.out.println("学生读了一本书");
        return 123;
    }

    public void testException(){
        System.out.println("抛出异常");
        throw new RuntimeException("我故意的");
    }
}
