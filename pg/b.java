package pg;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.q;

public final class b implements ThreadFactory {
    public final String a;
    public final AtomicInteger b;
    public final ThreadGroup c;
    public final int d;

    public b(String s, int v) {
        ThreadGroup threadGroup0;
        this.d = v;
        this.a = "mmupnp-" + s;
        this.b = new AtomicInteger(1);
        SecurityManager securityManager0 = System.getSecurityManager();
        if(securityManager0 == null) {
        label_8:
            Thread thread0 = Thread.currentThread();
            q.f(thread0, "Thread.currentThread()");
            threadGroup0 = thread0.getThreadGroup();
        }
        else {
            threadGroup0 = securityManager0.getThreadGroup();
            if(threadGroup0 == null) {
                goto label_8;
            }
        }
        this.c = threadGroup0;
    }

    @Override
    public final Thread newThread(Runnable runnable0) {
        q.g(runnable0, "runnable");
        Thread thread0 = new Thread(this.c, runnable0, this.a + this.b.getAndIncrement());
        int v = this.d;
        if(thread0.getPriority() != v) {
            thread0.setPriority(v);
        }
        return thread0;
    }
}

