package com.google.android.exoplayer2.scheduler;

public interface Scheduler {
    boolean cancel();

    boolean schedule(Requirements arg1, String arg2, String arg3);
}

