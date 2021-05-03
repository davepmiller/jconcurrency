package com.davepmiller.jvmpasta;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String... args) {
        Futures futures = new Futures();
        List<Future<?>> futureList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            futureList.add(futures.submitTask(Task.sayHiAndSleep(5)));
        }

        futureList.forEach(f -> {
            try {
                f.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });

        System.exit(0);
    }
}
