package com.iloen.melon.task;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

public class MainThreadExecutor implements Executor {
    public final Handler a;

    public MainThreadExecutor() {
        this.a = new Handler(Looper.getMainLooper());
    }

    @Override
    public void execute(Runnable runnable0) {
        this.a.post(runnable0);
    }
}

