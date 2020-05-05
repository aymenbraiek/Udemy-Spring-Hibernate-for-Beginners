package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ShootingJavaDemoApp {
    public static void main(String[] args) {

        // read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);

        // get the bean from spring container
        ShootingCoach theCoach = context.getBean("shootingCoach", ShootingCoach.class);

        // call a method on the bean
        System.out.println(theCoach.getDailyWorkout());

        // call method to get daily fortune
        System.out.println(theCoach.getDailyFortune());

        // call our new bike coach methods .. has the props values injected
       /* System.out.println(theCoach.getEmail());
        System.out.println(theCoach.getTeam());*/

        // close the context
        context.close();
    }
}
