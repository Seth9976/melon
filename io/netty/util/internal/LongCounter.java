package io.netty.util.internal;

public interface LongCounter {
    void add(long arg1);

    void decrement();

    void increment();

    long value();
}

