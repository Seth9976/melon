package com.google.android.exoplayer2.util;

import java.util.concurrent.ThreadFactory;

public final class e implements ThreadFactory {
    public final int a;
    public final String b;

    public e(String s, int v) {
        this.a = v;
        this.b = s;
        super();
    }

    @Override
    public final Thread newThread(Runnable runnable0) {
        switch(this.a) {
            case 0: {
                return Util.lambda$newSingleThreadExecutor$0(this.b, runnable0);
            }
            case 1: {
                return new Thread(runnable0, this.b);
            }
            case 2: {
                return new Thread(runnable0, this.b);
            }
            default: {
                Thread thread0 = new Thread(runnable0, this.b);
                thread0.setPriority(10);
                return thread0;
            }
        }
    }
}

