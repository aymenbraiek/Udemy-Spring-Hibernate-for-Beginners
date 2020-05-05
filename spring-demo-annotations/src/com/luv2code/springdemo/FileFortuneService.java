package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class FileFortuneService implements FortuneService {

    private Random random = new Random();
    private List<String> theFortunes;

    public FileFortuneService() throws IOException {
        String fileName = "src/com/luv2code/springdemo/fortune-data.txt";
        File theFile = new File(fileName);
        System.out.println("Reading fortunes from file: " + theFile);
        System.out.println("File exists: " + theFile.exists());

        // initialize array list
        theFortunes = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(theFile));
        // read from file
        // read fortunes from file
        String tempLine;
        while ((tempLine = reader.readLine()) != null) {
            theFortunes.add(tempLine);
        }

    }
    @Override
    public String getFortune() {
        int index = random.nextInt(theFortunes.size());
        return theFortunes.get(index);
    }

    @PostConstruct
    public void doSomeStuff() {
        System.out.println(">>FileFortuneService : inside doSomeStuff");
    }

    @PreDestroy
    public void doSomeCleanupStuff() {
        System.out.println(">>FileFortuneService : inside doSomeCleanupStuff");
    }
}
