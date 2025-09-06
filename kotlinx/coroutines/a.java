package kotlinx.coroutines;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public final class a implements ThreadFactory {
    public final int a;
    public final String b;
    public final AtomicInteger c;

    public a(int v, String s, AtomicInteger atomicInteger0) {
        this.a = v;
        this.b = s;
        this.c = atomicInteger0;
    }

    @Override
    public final Thread newThread(Runnable runnable0) {
        return ThreadPoolDispatcherKt__ThreadPoolDispatcherKt.newFixedThreadPoolContext$lambda$2$ThreadPoolDispatcherKt__ThreadPoolDispatcherKt(this.a, this.b, this.c, runnable0);
    }
}

