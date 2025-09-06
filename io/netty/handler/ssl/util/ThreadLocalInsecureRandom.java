package io.netty.handler.ssl.util;

import io.netty.util.internal.PlatformDependent;
import java.security.SecureRandom;
import java.util.Random;

final class ThreadLocalInsecureRandom extends SecureRandom {
    private static final SecureRandom INSTANCE = null;
    private static final long serialVersionUID = 0x8E12177ED7994E91L;

    static {
        ThreadLocalInsecureRandom.INSTANCE = new ThreadLocalInsecureRandom();
    }

    public static SecureRandom current() {
        return ThreadLocalInsecureRandom.INSTANCE;
    }

    @Override
    public byte[] generateSeed(int v) {
        byte[] arr_b = new byte[v];
        ThreadLocalInsecureRandom.random().nextBytes(arr_b);
        return arr_b;
    }

    @Override
    public String getAlgorithm() {
        return "insecure";
    }

    @Override
    public boolean nextBoolean() {
        return ThreadLocalInsecureRandom.random().nextBoolean();
    }

    @Override
    public void nextBytes(byte[] arr_b) {
        ThreadLocalInsecureRandom.random().nextBytes(arr_b);
    }

    @Override
    public double nextDouble() {
        return ThreadLocalInsecureRandom.random().nextDouble();
    }

    @Override
    public float nextFloat() {
        return ThreadLocalInsecureRandom.random().nextFloat();
    }

    @Override
    public double nextGaussian() {
        return ThreadLocalInsecureRandom.random().nextGaussian();
    }

    @Override
    public int nextInt() {
        return ThreadLocalInsecureRandom.random().nextInt();
    }

    @Override
    public int nextInt(int v) {
        return ThreadLocalInsecureRandom.random().nextInt(v);
    }

    @Override
    public long nextLong() {
        return ThreadLocalInsecureRandom.random().nextLong();
    }

    private static Random random() {
        return PlatformDependent.threadLocalRandom();
    }

    @Override
    public void setSeed(long v) {
    }

    @Override
    public void setSeed(byte[] arr_b) {
    }
}

