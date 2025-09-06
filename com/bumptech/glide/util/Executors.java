package com.bumptech.glide.util;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public final class Executors {
    private static final Executor DIRECT_EXECUTOR;
    private static final Executor MAIN_THREAD_EXECUTOR;

    static {
        Executors.MAIN_THREAD_EXECUTOR = new Executor() {
            @Override
            public void execute(Runnable runnable0) {
                Util.postOnUiThread(runnable0);
            }
        };
        Executors.DIRECT_EXECUTOR = new Executor() {
            @Override
            public void execute(Runnable runnable0) {
                runnable0.run();
            }
        };
    }

    public static Executor directExecutor() {
        return Executors.DIRECT_EXECUTOR;
    }

    public static Executor mainThreadExecutor() {
        return Executors.MAIN_THREAD_EXECUTOR;
    }

    public static void shutdownAndAwaitTermination(ExecutorService executorService0) {
        executorService0.shutdownNow();
        try {
            TimeUnit timeUnit0 = TimeUnit.SECONDS;
            if(!executorService0.awaitTermination(5L, timeUnit0)) {
                executorService0.shutdownNow();
                if(!executorService0.awaitTermination(5L, timeUnit0)) {
                    throw new RuntimeException("Failed to shutdown");
                }
            }
        }
        catch(InterruptedException interruptedException0) {
            executorService0.shutdownNow();
            Thread.currentThread().interrupt();
            throw new RuntimeException(interruptedException0);
        }
    }
}

