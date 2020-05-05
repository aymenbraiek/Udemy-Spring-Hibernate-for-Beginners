package com.luv2code.springdemo;
import java.util.Random;

public class RandomFortuneService implements FortuneService {


    // create an array of strings
    private String[] data = {"Beware of the wolf in sheep's clothing",
            "Diligence is the mother of good luck",
            "The journey is the reward"};

    // create a random number generator
    private Random random = new Random();



    @Override
    public String getFortune() {
        int index = random.nextInt(data.length);
        return data[index];
    }


}
