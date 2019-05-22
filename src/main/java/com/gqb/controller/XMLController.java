package com.gqb.controller;

import com.gqb.pojo.Student;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("XML")
public class XMLController {

    @RequestMapping(value = "get", produces = {MediaType.APPLICATION_XML_VALUE})//MediaType.APPLICATION_XML_VALUE = application/xml不要写错
    @ResponseBody
    public Student get(){//返回xml格式
        Student student = new Student();
        student.setId(111);
        student.setName("过去不去");
        student.setFriends(new String[]{"ass", "回去回去"});
        return student;
    }
}
