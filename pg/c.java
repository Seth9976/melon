package pg;

import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import jg.i;
import kotlin.jvm.internal.q;
import pc.t;

public final class c {
    public FutureTask a;
    public final ReentrantLock b;
    public final Condition c;
    public boolean d;
    public final t e;
    public static final long f;

    static {
        c.f = TimeUnit.SECONDS.toNanos(5L);
    }

    public c(t t0) {
        q.g(t0, "execute");
        super();
        this.e = t0;
        ReentrantLock reentrantLock0 = new ReentrantLock();
        this.b = reentrantLock0;
        this.c = reentrantLock0.newCondition();
    }

    public final boolean a() {
        return this.a == null ? true : this.a.isCancelled();
    }

    public final void b() {
        this.b.lock();
        try {
            this.d = true;
            this.c.signalAll();
        }
        finally {
            this.b.unlock();
        }
    }

    public final void c(Runnable runnable0) {
        q.g(runnable0, "runnable");
        this.b.lock();
        try {
            this.d = false;
            FutureTask futureTask0 = new FutureTask(runnable0, null);
            this.a = futureTask0;
            this.e.getClass();
            ((i)this.e.b).execute(futureTask0);
        }
        finally {
            this.b.unlock();
        }
    }

    public final void d() {
        ReentrantLock reentrantLock0 = this.b;
        reentrantLock0.lock();
        try {
            FutureTask futureTask0 = this.a;
            if(futureTask0 != null) {
                futureTask0.cancel(false);
            }
            this.a = null;
        }
        finally {
            reentrantLock0.unlock();
        }
    }

    public final boolean e() {
        ReentrantLock reentrantLock0 = this.b;
        reentrantLock0.lock();
        try {
            FutureTask futureTask0 = this.a;
            if(futureTask0 != null) {
                if(futureTask0.isDone()) {
                    return false;
                }
                if(!this.d) {
                    try {
                        this.c.awaitNanos(c.f);
                    }
                    catch(InterruptedException unused_ex) {
                    }
                }
                return this.d;
            }
            return false;
        }
        finally {
            reentrantLock0.unlock();
        }
    }
}

