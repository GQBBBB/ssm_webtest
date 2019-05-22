package com.gqb.controller;

import com.gqb.pojo.Student;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("json")
public class JsonController {

    @RequestMapping("get")
    public Student get(){
        Student student = new Student();
        student.setId(1);
        student.setName("guan");
        student.setFriends(new String[]{"zz", "ss"});
        return student;//直接返回json形式
    }

    @RequestMapping("set")
    public String set(@RequestBody Student student){//只有加上@RequestBody才能处理提交过来的json数据，否则只能处理form表单提交的
        System.out.println(student);
        return "student";//直接返回json形式
    }
}
