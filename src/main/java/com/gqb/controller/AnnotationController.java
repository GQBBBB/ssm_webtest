package com.gqb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AnnotationController {

    @RequestMapping("/anno")
    public String anno(Model model){
        //model
        model.addAttribute("name", "gqb");
        //view
        return "girl";
    }
}
