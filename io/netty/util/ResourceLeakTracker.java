package io.netty.util;

public interface ResourceLeakTracker {
    boolean close(Object arg1);

    void record();

    void record(Object arg1);
}

