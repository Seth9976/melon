package com.airbnb.lottie.utils;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class LottieThreadFactory implements ThreadFactory {
    private final ThreadGroup group;
    private final String namePrefix;
    private static final AtomicInteger poolNumber;
    private final AtomicInteger threadNumber;

    static {
        LottieThreadFactory.poolNumber = new AtomicInteger(1);
    }

    public LottieThreadFactory() {
        this.threadNumber = new AtomicInteger(1);
        SecurityManager securityManager0 = System.getSecurityManager();
        this.group = securityManager0 == null ? Thread.currentThread().getThreadGroup() : securityManager0.getThreadGroup();
        this.namePrefix = "lottie-" + LottieThreadFactory.poolNumber.getAndIncrement() + "-thread-";
    }

    @Override
    public Thread newThread(Runnable runnable0) {
        Thread thread0 = new Thread(this.group, runnable0, this.namePrefix + this.threadNumber.getAndIncrement(), 0L);
        thread0.setDaemon(false);
        thread0.setPriority(10);
        return thread0;
    }
}

