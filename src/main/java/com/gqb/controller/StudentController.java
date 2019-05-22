package com.gqb.controller;

import com.gqb.pojo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@RequestMapping("/student")
//@SessionAttributes("student") 将名字为student的Model填充到会话里面去，能使重定向后可访问内容
@SessionAttributes("student")
public class StudentController {

    @RequestMapping("new")
    public String newStudent(Model model){
        Student student = new Student();
        student.setId(1);
        student.setName("gqb");
        student.setFriends(new String[]{"xx", "zzz"});
        model.addAttribute("student", student);
        return "student";
//        return "forward:/student/new";//请求转发到另一个Controller
    }

    //重定向
    @RequestMapping("redirect")
    public String redirect(Model model){
        Student student = new Student();
        student.setId(2);
        student.setName("redirect");
        student.setFriends(new String[]{"xx", "zzz"});
        model.addAttribute("student", student);
        return "redirect:/jsp/student.jsp";//执行重定向转发到另一个页面，model中的内容不会带过去 ps:加上@SessionAttributes("student")可以
//        return "redirect:/student/new";//执行重定向转发到另一个Controller，model中的内容不会带过去
    }

    //
    @RequestMapping("get")
    //在Session里取出名为student的属性，该属性必须先存在
    //比如先执行new，这样session里就存在student，在执行该方法即可取出，否则就出错
    public String get(@SessionAttribute Student student){
        return "student";
    }
}
