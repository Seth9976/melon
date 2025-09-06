package io.netty.util.concurrent;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public final class DefaultEventExecutorChooserFactory implements EventExecutorChooserFactory {
    static final class GenericEventExecutorChooser implements EventExecutorChooser {
        private final EventExecutor[] executors;
        private final AtomicLong idx;

        public GenericEventExecutorChooser(EventExecutor[] arr_eventExecutor) {
            this.idx = new AtomicLong();
            this.executors = arr_eventExecutor;
        }

        @Override  // io.netty.util.concurrent.EventExecutorChooserFactory$EventExecutorChooser
        public EventExecutor next() {
            return this.executors[((int)Math.abs(this.idx.getAndIncrement() % ((long)this.executors.length)))];
        }
    }

    static final class PowerOfTwoEventExecutorChooser implements EventExecutorChooser {
        private final EventExecutor[] executors;
        private final AtomicInteger idx;

        public PowerOfTwoEventExecutorChooser(EventExecutor[] arr_eventExecutor) {
            this.idx = new AtomicInteger();
            this.executors = arr_eventExecutor;
        }

        @Override  // io.netty.util.concurrent.EventExecutorChooserFactory$EventExecutorChooser
        public EventExecutor next() {
            return this.executors[this.idx.getAndIncrement() & this.executors.length - 1];
        }
    }

    public static final DefaultEventExecutorChooserFactory INSTANCE;

    static {
        DefaultEventExecutorChooserFactory.INSTANCE = new DefaultEventExecutorChooserFactory();
    }

    private static boolean isPowerOfTwo(int v) {
        return (-v & v) == v;
    }

    @Override  // io.netty.util.concurrent.EventExecutorChooserFactory
    public EventExecutorChooser newChooser(EventExecutor[] arr_eventExecutor) {
        return DefaultEventExecutorChooserFactory.isPowerOfTwo(arr_eventExecutor.length) ? new PowerOfTwoEventExecutorChooser(arr_eventExecutor) : new GenericEventExecutorChooser(arr_eventExecutor);
    }
}

