package io.netty.util.internal;

import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.security.SecureRandom;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public final class ThreadLocalRandom extends Random {
    private static final long addend = 11L;
    private static volatile long initialSeedUniquifier = 0L;
    boolean initialized;
    private static final InternalLogger logger = null;
    private static final long mask = 0xFFFFFFFFFFFFL;
    private static final long multiplier = 25214903917L;
    private long pad0;
    private long pad1;
    private long pad2;
    private long pad3;
    private long pad4;
    private long pad5;
    private long pad6;
    private long pad7;
    private long rnd;
    private static volatile long seedGeneratorEndTime = 0L;
    private static final long seedGeneratorStartTime = 0L;
    private static final Thread seedGeneratorThread = null;
    private static final BlockingQueue seedQueue = null;
    private static final AtomicLong seedUniquifier = null;
    private static final long serialVersionUID = -5851777807851030925L;

    static {
        ThreadLocalRandom.logger = InternalLoggerFactory.getInstance(ThreadLocalRandom.class);
        ThreadLocalRandom.seedUniquifier = new AtomicLong();
        ThreadLocalRandom.initialSeedUniquifier = SystemPropertyUtil.getLong("io.netty.initialSeedUniquifier", 0L);
        if(Long.compare(ThreadLocalRandom.initialSeedUniquifier, 0L) == 0) {
            if(SystemPropertyUtil.getBoolean("java.util.secureRandomSeed", false)) {
                ThreadLocalRandom.seedQueue = new LinkedBlockingQueue();
                ThreadLocalRandom.seedGeneratorStartTime = System.nanoTime();
                io.netty.util.internal.ThreadLocalRandom.1 threadLocalRandom$10 = new Thread("initialSeedUniquifierGenerator") {
                    @Override
                    public void run() {
                        byte[] arr_b = new SecureRandom().generateSeed(8);
                        ThreadLocalRandom.seedGeneratorEndTime = System.nanoTime();
                        ThreadLocalRandom.seedQueue.add(((long)((((long)arr_b[0]) & 0xFFL) << 56 | (((long)arr_b[1]) & 0xFFL) << 0x30 | (((long)arr_b[2]) & 0xFFL) << 40 | (((long)arr_b[3]) & 0xFFL) << 0x20 | (((long)arr_b[4]) & 0xFFL) << 24 | (((long)arr_b[5]) & 0xFFL) << 16 | (((long)arr_b[6]) & 0xFFL) << 8 | ((long)arr_b[7]) & 0xFFL)));
                    }
                };
                ThreadLocalRandom.seedGeneratorThread = threadLocalRandom$10;
                threadLocalRandom$10.setDaemon(true);
                threadLocalRandom$10.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
                    @Override
                    public void uncaughtException(Thread thread0, Throwable throwable0) {
                        ThreadLocalRandom.logger.debug("An exception has been raised by {}", thread0.getName(), throwable0);
                    }
                });
                threadLocalRandom$10.start();
                return;
            }
            ThreadLocalRandom.initialSeedUniquifier = 0x3FA7E13CC4099247L;
            ThreadLocalRandom.seedGeneratorThread = null;
            ThreadLocalRandom.seedQueue = null;
            ThreadLocalRandom.seedGeneratorStartTime = 0L;
            return;
        }
        ThreadLocalRandom.seedGeneratorThread = null;
        ThreadLocalRandom.seedQueue = null;
        ThreadLocalRandom.seedGeneratorStartTime = 0L;
    }

    public ThreadLocalRandom() {
        super(ThreadLocalRandom.newSeed());
        this.initialized = true;
    }

    public static ThreadLocalRandom current() {
        return InternalThreadLocalMap.get().random();
    }

    public static long getInitialSeedUniquifier() {
        boolean z;
        long v = ThreadLocalRandom.initialSeedUniquifier;
        if(v != 0L) {
            return v;
        }
        synchronized(ThreadLocalRandom.class) {
            long v2 = ThreadLocalRandom.initialSeedUniquifier;
            if(v2 != 0L) {
                return v2;
            }
            long v3 = TimeUnit.SECONDS.toNanos(3L);
            long v4 = ThreadLocalRandom.seedGeneratorStartTime + v3;
            while(true) {
                try {
                    z = false;
                    long v5 = v4 - System.nanoTime();
                    int v6 = Long.compare(v5, 0L);
                    Long long0 = v6 > 0 ? ((Long)ThreadLocalRandom.seedQueue.poll(v5, TimeUnit.NANOSECONDS)) : ((Long)ThreadLocalRandom.seedQueue.poll());
                    if(long0 != null) {
                        v2 = (long)long0;
                        break;
                    }
                    if(v6 <= 0) {
                        goto label_26;
                    }
                    continue;
                }
                catch(InterruptedException unused_ex) {
                    ThreadLocalRandom.logger.warn("Failed to generate a seed from SecureRandom due to an InterruptedException.");
                    z = true;
                    break;
                }
            label_26:
                ThreadLocalRandom.seedGeneratorThread.interrupt();
                ThreadLocalRandom.logger.warn("Failed to generate a seed from SecureRandom within {} seconds. Not enough entropy?", 3L);
                break;
            }
            long v7 = v2 ^ 3627065505421648153L ^ Long.reverse(System.nanoTime());
            ThreadLocalRandom.initialSeedUniquifier = v7;
            if(z) {
                Thread.currentThread().interrupt();
                ThreadLocalRandom.seedGeneratorThread.interrupt();
            }
            if(ThreadLocalRandom.seedGeneratorEndTime == 0L) {
                ThreadLocalRandom.seedGeneratorEndTime = System.nanoTime();
            }
            return v7;
        }
    }

    private static long mix64(long v) [...] // 潜在的解密器

    private static long newSeed() {
        long v2;
        do {
            long v = ThreadLocalRandom.seedUniquifier.get();
            int v1 = Long.compare(v, 0L);
            v2 = v1 == 0 ? ThreadLocalRandom.getInitialSeedUniquifier() : v;
        }
        while(!ThreadLocalRandom.seedUniquifier.compareAndSet(v, 0x285D320AD33FDB5L * v2));
        if(v1 == 0) {
            InternalLogger internalLogger0 = ThreadLocalRandom.logger;
            if(internalLogger0.isDebugEnabled()) {
                if(ThreadLocalRandom.seedGeneratorEndTime != 0L) {
                    internalLogger0.debug(String.format("-Dio.netty.initialSeedUniquifier: 0x%016x (took %d ms)", v2, TimeUnit.NANOSECONDS.toMillis(ThreadLocalRandom.seedGeneratorEndTime - ThreadLocalRandom.seedGeneratorStartTime)));
                    return System.nanoTime() ^ 0x285D320AD33FDB5L * v2;
                }
                internalLogger0.debug(String.format("-Dio.netty.initialSeedUniquifier: 0x%016x", v2));
            }
        }
        return System.nanoTime() ^ 0x285D320AD33FDB5L * v2;
    }

    @Override
    public int next(int v) {
        long v1 = this.rnd * 25214903917L + 11L & 0xFFFFFFFFFFFFL;
        this.rnd = v1;
        return (int)(v1 >>> 0x30 - v);
    }

    @Override
    public double nextDouble(double f) {
        ObjectUtil.checkPositive(f, "n");
        return this.nextDouble() * f;
    }

    @Override
    public double nextDouble(double f, double f1) {
        if(f >= f1) {
            throw new IllegalArgumentException();
        }
        return (f1 - f) * this.nextDouble() + f;
    }

    @Override
    public int nextInt(int v, int v1) {
        if(v >= v1) {
            throw new IllegalArgumentException();
        }
        return this.nextInt(v1 - v) + v;
    }

    @Override
    public long nextLong(long v) {
        ObjectUtil.checkPositive(v, "n");
        long v1 = 0L;
        while(v >= 0x7FFFFFFFL) {
            int v2 = this.next(2);
            long v3 = (v2 & 2) == 0 ? v >>> 1 : v - (v >>> 1);
            if((v2 & 1) == 0) {
                v1 = v - v3 + v1;
            }
            v = v3;
        }
        return v1 + ((long)this.nextInt(((int)v)));
    }

    @Override
    public long nextLong(long v, long v1) {
        if(v >= v1) {
            throw new IllegalArgumentException();
        }
        return this.nextLong(v1 - v) + v;
    }

    public static void setInitialSeedUniquifier(long v) {
        ThreadLocalRandom.initialSeedUniquifier = v;
    }

    @Override
    public void setSeed(long v) {
        if(this.initialized) {
            throw new UnsupportedOperationException();
        }
        this.rnd = (v ^ 25214903917L) & 0xFFFFFFFFFFFFL;
    }
}

