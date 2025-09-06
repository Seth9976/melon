package io.netty.util.concurrent;

import io.netty.util.internal.ObjectUtil;

final class FastThreadLocalRunnable implements Runnable {
    private final Runnable runnable;

    private FastThreadLocalRunnable(Runnable runnable0) {
        this.runnable = (Runnable)ObjectUtil.checkNotNull(runnable0, "runnable");
    }

    @Override
    public void run() {
        try {
            this.runnable.run();
        }
        finally {
            FastThreadLocal.removeAll();
        }
    }

    public static Runnable wrap(Runnable runnable0) {
        return runnable0 instanceof FastThreadLocalRunnable ? runnable0 : new FastThreadLocalRunnable(runnable0);
    }
}

