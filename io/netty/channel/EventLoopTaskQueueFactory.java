package io.netty.channel;

import java.util.Queue;

public interface EventLoopTaskQueueFactory {
    Queue newTaskQueue(int arg1);
}

