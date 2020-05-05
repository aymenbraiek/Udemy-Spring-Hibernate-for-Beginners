package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class RugbyCoach implements Coach {

    @Autowired
    @Qualifier("happyFortuneService")
    private FortuneService fortuneService;

    // define a default constructor
    public RugbyCoach() {
        System.out.println(">> RugbyCoach: inside default constructor");
    }

    /*    // define a setter method
    @Autowired
    public void setFortuneService(FortuneService fortuneService) {
        System.out.println(">> RugbyCoach: inside setFortuneService() method");
        this.fortuneService = fortuneService;
    }*/

    /*   @Autowired
    public void doSomeCrazyStuff(FortuneService fortuneService) {
        System.out.println(">> RugbyCoach: inside doSomeCrazyStuff() method");
        this.fortuneService = fortuneService;
    }*/

    /* @Autowired
    public RugbyCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }*/

    @Override
    public String getDailyWorkout() {
        return "Do 30 pushups each day";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
