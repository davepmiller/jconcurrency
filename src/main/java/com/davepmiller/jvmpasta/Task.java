package com.davepmiller.jvmpasta;

import java.util.concurrent.TimeUnit;

public class Task {
    static Runnable sayHiAndSleep(int seconds) {
        return () -> {
            try {
                System.out.println("Hello world, from thread id " + Thread.currentThread().getId());
                TimeUnit.SECONDS.sleep(seconds);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
    }
}
