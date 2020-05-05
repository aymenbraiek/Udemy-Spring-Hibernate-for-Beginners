package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomFortuneService implements FortuneService {

    // create an array of Strings
    public String[] list = {
            "1. Beware of the wolf",
            "2. Diligence is the mother of good luck ",
            "3.The journey is the reward "};

    // create a random number generator
    Random random = new Random();

    @Override
    public String getFortune() {
        // pick a random String from the array
        int  index = random.nextInt(list.length);
        return list[index];
    }
}
