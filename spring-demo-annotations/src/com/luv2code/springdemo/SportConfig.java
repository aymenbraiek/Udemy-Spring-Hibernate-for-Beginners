package com.luv2code.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
/*@ComponentScan("com.luv2code.springdemo")*/
@PropertySource("classpath:sport.properties")

public class SportConfig {

    // define bean for our sad fortune service
    @Bean
    public FortuneService sadFortuneService() {
        return new SadFortuneService();
    }

    @Bean
    public FortuneService luckyFortuneService() {
        return new LuckyFortuneService();
    }

    // define bean for swim coach and inject dependency
    @Bean
    public Coach bikeCoach() {
        return new BikeCoach(sadFortuneService());
    }

    @Bean
    public Coach shootingCoach() {
        return new ShootingCoach(luckyFortuneService());
    }
}
