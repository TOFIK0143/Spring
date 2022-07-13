package com.demo.rest_demo.Rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class DemoRestController {


    // add code for

    @GetMapping("/hello")
    public String sayHello()
    {
        return "Hello World";
    }

}
