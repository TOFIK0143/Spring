package com.demo.springdemoIOC_DI;

public class TrackCoach implements Coach {

    private FortuneService fortuneService;
    public TrackCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }


    @Override
    public String getDailyWorkout() {
        return "Run a hard 5k";
    }

    @Override
    public String getDailyFortune() {
        return "Just do it!!! "+fortuneService.getFortune();
    }

    //add init method
    public void doMyStartupStuff()
    {
        System.out.println("inside the doMyStartupStuff method");
    }
    //add destroy method
    public void doMyCleanupStuff()
    {
        System.out.println("inside the doMyCleanupStuff method");
    }

}
