package w1;

import M6.B;
import df.v;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
import k8.Y;

public abstract class i implements B {
    public volatile Object a;
    public volatile d b;
    public volatile h c;
    public static final boolean d;
    public static final Logger e;
    public static final v f;
    public static final Object g;

    static {
        e e0;
        i.d = false;
        i.e = Logger.getLogger("w1.i");
        try {
            e0 = new e(AtomicReferenceFieldUpdater.newUpdater(h.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(h.class, h.class, "b"), AtomicReferenceFieldUpdater.newUpdater(i.class, h.class, "c"), AtomicReferenceFieldUpdater.newUpdater(i.class, d.class, "b"), AtomicReferenceFieldUpdater.newUpdater(i.class, Object.class, "a"));
            throwable0 = null;
        }
        catch(Throwable throwable0) {
            e0 = new g();  // 初始化器: Ljava/lang/Object;-><init>()V
        }
        i.f = e0;
        if(throwable0 != null) {
            i.e.log(Level.SEVERE, "SafeAtomicHelper is broken!", throwable0);
        }
        i.g = new Object();
    }

    public final void a(StringBuilder stringBuilder0) {
        try {
            Object object0 = i.f(this);
            stringBuilder0.append("SUCCESS, result=[");
            stringBuilder0.append((object0 == this ? "this future" : String.valueOf(object0)));
            stringBuilder0.append("]");
        }
        catch(ExecutionException executionException0) {
            stringBuilder0.append("FAILURE, cause=[");
            stringBuilder0.append(executionException0.getCause());
            stringBuilder0.append("]");
        }
        catch(CancellationException unused_ex) {
            stringBuilder0.append("CANCELLED");
        }
        catch(RuntimeException runtimeException0) {
            stringBuilder0.append("UNKNOWN, cause=[");
            stringBuilder0.append(runtimeException0.getClass());
            stringBuilder0.append(" thrown from get()]");
        }
    }

    @Override  // M6.B
    public final void addListener(Runnable runnable0, Executor executor0) {
        runnable0.getClass();
        executor0.getClass();
        d d0 = this.b;
        d d1 = d.d;
        if(d0 != d1) {
            d d2 = new d(runnable0, executor0);
            while(true) {
                d2.c = d0;
                if(i.f.o(this, d0, d2)) {
                    return;
                }
                d0 = this.b;
                if(d0 == d1) {
                    break;
                }
            }
        }
        i.d(runnable0, executor0);
    }

    public void b() {
    }

    public static void c(i i0) {
        d d2;
        d d1;
        d d0;
        h h0;
        do {
            h0 = i0.c;
        }
        while(!i.f.q(i0, h0, h.c));
        while(true) {
            d0 = null;
            if(h0 == null) {
                break;
            }
            Thread thread0 = h0.a;
            if(thread0 != null) {
                h0.a = null;
                LockSupport.unpark(thread0);
            }
            h0 = h0.b;
        }
        i0.b();
        do {
            d1 = i0.b;
        }
        while(!i.f.o(i0, d1, d.d));
        while(true) {
            d2 = d0;
            d0 = d1;
            if(d0 == null) {
                break;
            }
            d1 = d0.c;
            d0.c = d2;
        }
        while(d2 != null) {
            d d3 = d2.c;
            Runnable runnable0 = d2.a;
            if(!(runnable0 instanceof f)) {
                i.d(runnable0, d2.b);
                d2 = d3;
                continue;
            }
            runnable0.getClass();
            throw new ClassCastException();
        }
    }

    @Override
    public final boolean cancel(boolean z) {
        a a0;
        if(this.a == null) {
            if(i.d) {
                a0 = new a(z, new CancellationException("Future.cancel() was called."));
            }
            else {
                a0 = z ? a.c : a.d;
            }
            if(i.f.p(this, null, a0)) {
                i.c(this);
                return true;
            }
        }
        return false;
    }

    public static void d(Runnable runnable0, Executor executor0) {
        try {
            executor0.execute(runnable0);
        }
        catch(RuntimeException runtimeException0) {
            i.e.log(Level.SEVERE, "RuntimeException while executing runnable " + runnable0 + " with executor " + executor0, runtimeException0);
        }
    }

    public static Object e(Object object0) {
        if(!(object0 instanceof a)) {
            if(object0 instanceof c) {
                throw new ExecutionException(((c)object0).a);
            }
            return object0 == i.g ? null : object0;
        }
        CancellationException cancellationException0 = new CancellationException("Task was cancelled.");
        cancellationException0.initCause(((a)object0).b);
        throw cancellationException0;
    }

    public static Object f(Future future0) {
        Object object0;
        boolean z = false;
        while(true) {
            try {
                object0 = future0.get();
                break;
            }
            catch(InterruptedException unused_ex) {
                z = true;
            }
            catch(Throwable throwable0) {
                if(z) {
                    Thread.currentThread().interrupt();
                }
                throw throwable0;
            }
        }
        if(z) {
            Thread.currentThread().interrupt();
        }
        return object0;
    }

    // 去混淆评级： 低(20)
    public String g() {
        return this instanceof ScheduledFuture ? "remaining delay=[" + ((ScheduledFuture)this).getDelay(TimeUnit.MILLISECONDS) + " ms]" : null;
    }

    @Override
    public final Object get() {
        h h0 = h.c;
        if(Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object object0 = this.a;
        if(object0 != null) {
            return i.e(object0);
        }
        h h1 = this.c;
        if(h1 != h0) {
            h h2 = new h();
            while(true) {
                i.f.H(h2, h1);
                if(i.f.q(this, h1, h2)) {
                    while(true) {
                        LockSupport.park(this);
                        if(Thread.interrupted()) {
                            break;
                        }
                        Object object1 = this.a;
                        if(object1 != null) {
                            return i.e(object1);
                        }
                    }
                    this.h(h2);
                    throw new InterruptedException();
                }
                h1 = this.c;
                if(h1 == h0) {
                    break;
                }
            }
        }
        return i.e(this.a);
    }

    @Override
    public final Object get(long v, TimeUnit timeUnit0) {
        h h0 = h.c;
        long v1 = timeUnit0.toNanos(v);
        if(Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object object0 = this.a;
        if(object0 != null) {
            return i.e(object0);
        }
        long v2 = v1 <= 0L ? 0L : System.nanoTime() + v1;
        if(v1 >= 1000L) {
            h h1 = this.c;
            if(h1 != h0) {
                h h2 = new h();
                while(true) {
                    i.f.H(h2, h1);
                    if(i.f.q(this, h1, h2)) {
                        do {
                            LockSupport.parkNanos(this, v1);
                            if(Thread.interrupted()) {
                                this.h(h2);
                                throw new InterruptedException();
                            }
                            Object object1 = this.a;
                            if(object1 != null) {
                                return i.e(object1);
                            }
                            v1 = v2 - System.nanoTime();
                        }
                        while(v1 >= 1000L);
                        this.h(h2);
                        goto label_27;
                    }
                    h1 = this.c;
                    if(h1 == h0) {
                        break;
                    }
                }
            }
            return i.e(this.a);
        }
    label_27:
        while(v1 > 0L) {
            Object object2 = this.a;
            if(object2 != null) {
                return i.e(object2);
            }
            if(Thread.interrupted()) {
                throw new InterruptedException();
            }
            v1 = v2 - System.nanoTime();
        }
        String s = this.toString();
        Locale locale0 = Locale.ROOT;
        String s1 = timeUnit0.toString().toLowerCase(locale0);
        StringBuilder stringBuilder0 = Y.o(v, "Waited ", " ");
        stringBuilder0.append(timeUnit0.toString().toLowerCase(locale0));
        String s2 = stringBuilder0.toString();
        if(v1 + 1000L < 0L) {
            String s3 = s2 + " (plus ";
            long v3 = timeUnit0.convert(-v1, TimeUnit.NANOSECONDS);
            long v4 = -v1 - timeUnit0.toNanos(v3);
            int v5 = Long.compare(v3, 0L);
            boolean z = v5 == 0 || v4 > 1000L;
            if(v5 > 0) {
                s3 = (z ? s3 + v3 + " " + s1 + "," : s3 + v3 + " " + s1) + " ";
            }
            if(z) {
                s3 = s3 + v4 + " nanoseconds ";
            }
            s2 = s3 + "delay)";
        }
        throw this.isDone() ? new TimeoutException(s2 + " but future completed as timeout expired") : new TimeoutException(s2 + " for " + s);
    }

    public final void h(h h0) {
        h0.a = null;
    alab1:
        h h1;
        while((h1 = this.c) != h.c) {
            h h2 = null;
            while(true) {
                if(h1 == null) {
                    break alab1;
                }
                h h3 = h1.b;
                if(h1.a != null) {
                    h2 = h1;
                }
                else if(h2 == null) {
                    if(i.f.q(this, h1, h3)) {
                        h1 = h3;
                        continue;
                    }
                    break;
                }
                else {
                    h2.b = h3;
                    if(h2.a == null) {
                        break;
                    }
                }
                h1 = h3;
            }
        }
    }

    public boolean i(Object object0) {
        if(object0 == null) {
            object0 = i.g;
        }
        if(i.f.p(this, null, object0)) {
            i.c(this);
            return true;
        }
        return false;
    }

    @Override
    public final boolean isCancelled() {
        return this.a instanceof a;
    }

    @Override
    public final boolean isDone() {
        return this.a != null;
    }

    public boolean j(Throwable throwable0) {
        throwable0.getClass();
        c c0 = new c(throwable0);
        if(i.f.p(this, null, c0)) {
            i.c(this);
            return true;
        }
        return false;
    }

    @Override
    public final String toString() {
        String s;
        StringBuilder stringBuilder0 = new StringBuilder();
        stringBuilder0.append(super.toString());
        stringBuilder0.append("[status=");
        if(this.a instanceof a) {
            stringBuilder0.append("CANCELLED");
        }
        else if(this.isDone()) {
            this.a(stringBuilder0);
        }
        else {
            try {
                s = this.g();
            }
            catch(RuntimeException runtimeException0) {
                s = "Exception thrown from implementation: " + runtimeException0.getClass();
            }
            if(s != null && !s.isEmpty()) {
                va.e.g(stringBuilder0, "PENDING, info=[", s, "]");
            }
            else if(this.isDone()) {
                this.a(stringBuilder0);
            }
            else {
                stringBuilder0.append("PENDING");
            }
        }
        stringBuilder0.append("]");
        return stringBuilder0.toString();
    }
}

