package com.gqb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("cookie")
public class CookieController {

    @RequestMapping("get")
    public String c1(@CookieValue("JSESSIONID") String name){
        System.out.println(name);
        return "girl";//没有存在model里，所以girl页面读不出来
    }
}
