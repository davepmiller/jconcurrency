package com.davepmiller.jvmpasta;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class FuturesTest {
    @Test
    void runThread_lastsFiveSeconds() {
        int taskTime = 5;
        Instant before = Instant.now();
        Instant after = before;
        try {
            new Futures().submitTask(Task.sayHiAndSleep(taskTime)).get();
            after = Instant.now();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        assertTrue(Duration.between(before, after).toSeconds() >= taskTime);
    }
}
