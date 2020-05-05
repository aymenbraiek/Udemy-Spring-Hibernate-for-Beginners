package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {
    public static void main(String[] args) {

        // read spring config file
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        // get the bean from spring container
        Coach theCoach = context.getBean("tennisCoach", Coach.class);
        Coach rugbyCoach = context.getBean("rugbyCoach", Coach.class);
        SwimCoach swimCoach = context.getBean("swimCoach", SwimCoach.class);
        PingPongCoach pingPongCoach = context.getBean("pingPongCoach", PingPongCoach.class);

        // call a method on the bean
        System.out.println(theCoach.getDailyWorkout());
        System.out.println(rugbyCoach.getDailyWorkout());
        System.out.println(swimCoach.getDailyWorkout());
        System.out.println(pingPongCoach.getDailyWorkout());

        // call method to get daily fortune
        System.out.println(theCoach.getDailyFortune());
        System.out.println(rugbyCoach.getDailyFortune());
        System.out.println(swimCoach.getDailyFortune());
        System.out.println(pingPongCoach.getDailyFortune());

        System.out.println(swimCoach.getEmail());
        System.out.println(swimCoach.getTeam());

        // close the context
        context.close();
    }
}
