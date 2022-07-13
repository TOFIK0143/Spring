package com.SpringBoot.Demo.propertiesdemo.Rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class FunRestController {

    //inject properties
    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    @GetMapping("/")
    public String sayHello()
    {
        return "Hello World!! Time on server is "+ LocalDateTime.now();
    }

    @GetMapping("/workout")
    public String workout()
    {
        return  "daily workout for 1 hour";
    }

    @GetMapping("/fortune")
    public String getDailyFortune() {
        return "Today is your lucky day.";
    }

    @GetMapping("/teamInfo")
    public String getTeamInfo()
    {
        return coachName+" "+teamName;
    }

}
