package io.netty.util.concurrent;

import java.util.EventListener;

public interface GenericFutureListener extends EventListener {
    void operationComplete(Future arg1);
}

