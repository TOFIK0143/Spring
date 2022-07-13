package com.demo.controller;

import com.demo.Entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class DemoController {
    @RequestMapping("/")

    public String homePage() {
        return "main-menu";
    }
@RequestMapping("/studentform")
    public String confirmation(Model model) {
        model.addAttribute("student",new Student());
        return "student-form";
    }
}
