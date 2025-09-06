package io.netty.util;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public interface Timer {
    Timeout newTimeout(TimerTask arg1, long arg2, TimeUnit arg3);

    Set stop();
}

