package io.netty.util.concurrent;

import io.netty.util.internal.ObjectUtil;
import java.util.concurrent.Executor;

public final class ImmediateExecutor implements Executor {
    public static final ImmediateExecutor INSTANCE;

    static {
        ImmediateExecutor.INSTANCE = new ImmediateExecutor();
    }

    @Override
    public void execute(Runnable runnable0) {
        ((Runnable)ObjectUtil.checkNotNull(runnable0, "command")).run();
    }
}

