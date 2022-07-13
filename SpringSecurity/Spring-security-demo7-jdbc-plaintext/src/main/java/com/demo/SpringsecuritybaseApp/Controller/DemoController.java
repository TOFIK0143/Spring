package com.demo.SpringsecuritybaseApp.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    @GetMapping("/")
    public String showHome()
    {
        return "home";
    }

    @GetMapping("/leaders")
    public String getLeaders()
    {
       return "leaders";
    }

    @GetMapping("/systems")
    public String showSystems()
    {
        return "systems";
    }
}
