package com.davepmiller.jvmpasta;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Futures {
    ExecutorService executorService = Executors.newCachedThreadPool();

    public Future<?> submitTask(Runnable task) {
        return executorService.submit(task);
    }
}
