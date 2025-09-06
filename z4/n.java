package z4;

import Cc.o1;
import Vd.w;
import h7.u0;
import java.util.concurrent.locks.ReentrantLock;
import je.p;
import ke.b;
import kotlin.jvm.internal.H;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.sync.Semaphore;
import kotlinx.coroutines.sync.SemaphoreKt;
import oe.c;
import we.a;

public final class n {
    public final int a;
    public final a b;
    public final ReentrantLock c;
    public int d;
    public boolean e;
    public final h[] f;
    public final Semaphore g;
    public final w h;

    public n(int v, a a0) {
        this.a = v;
        this.b = a0;
        this.c = new ReentrantLock();
        this.f = new h[v];
        this.g = SemaphoreKt.Semaphore$default(v, 0, 2, null);
        w w0 = new w(2, 0);
        if(v >= 1) {
            if(v <= 0x40000000) {
                if(Integer.bitCount(v) != 1) {
                    v = Integer.highestOneBit(v - 1) << 1;
                }
                w0.d = v - 1;
                w0.e = new Object[v];
                this.h = w0;
                return;
            }
            E.a.c("capacity must be <= 2^30");
            throw null;
        }
        E.a.c("capacity must be >= 1");
        throw null;
    }

    public final Object a(c c0) {
        n n0;
        k k0;
        if(c0 instanceof k) {
            k0 = (k)c0;
            int v = k0.D;
            if((v & 0x80000000) == 0) {
                k0 = new k(this, c0);
            }
            else {
                k0.D = v ^ 0x80000000;
            }
        }
        else {
            k0 = new k(this, c0);
        }
        Object object0 = k0.w;
        ne.a a0 = ne.a.a;
        switch(k0.D) {
            case 0: {
                d5.n.D(object0);
                k0.r = this;
                k0.D = 1;
                if(this.g.acquire(k0) == a0) {
                    return a0;
                }
                n0 = this;
                break;
            }
            case 1: {
                n0 = k0.r;
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        try {
            ReentrantLock reentrantLock0 = n0.c;
            w w0 = n0.h;
            reentrantLock0.lock();
            try {
                if(!n0.e) {
                    if(w0.b == w0.c && n0.d < n0.a) {
                        h h0 = new h(((G4.a)n0.b.invoke()));
                        int v2 = n0.d;
                        n0.d = v2 + 1;
                        n0.f[v2] = h0;
                        w0.c(h0);
                    }
                    int v3 = w0.b;
                    if(v3 == w0.c) {
                        throw new ArrayIndexOutOfBoundsException();
                    }
                    Object[] arr_object = (Object[])w0.e;
                    Object object1 = arr_object[v3];
                    arr_object[v3] = null;
                    w0.b = v3 + 1 & w0.d;
                    return (h)object1;
                }
                u0.S(21, "Connection pool is closed");
            }
            finally {
                reentrantLock0.unlock();
            }
            throw null;
        }
        catch(Throwable throwable0) {
            n0.g.release();
            throw throwable0;
        }
    }

    public final Object b(long v, o1 o10, c c0) {
        H h3;
        a a1;
        H h0;
        n n0;
        l l0;
        if(c0 instanceof l) {
            l0 = (l)c0;
            int v1 = l0.I;
            if((v1 & 0x80000000) == 0) {
                l0 = new l(this, c0);
            }
            else {
                l0.I = v1 ^ 0x80000000;
            }
        }
        else {
            l0 = new l(this, c0);
        }
        Object object0 = l0.E;
        ne.a a0 = ne.a.a;
        switch(l0.I) {
            case 0: {
                d5.n.D(object0);
                n0 = this;
                goto label_42;
            }
            case 1: {
                try {
                    v = l0.D;
                    h0 = l0.B;
                    a1 = l0.w;
                    n0 = l0.r;
                    d5.n.D(object0);
                    break;
                }
                catch(Throwable throwable0) {
                    goto label_55;
                }
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        while(true) {
            H h1 = h0;
            o10 = a1;
            l l1 = l0;
            Throwable throwable1 = null;
            while(true) {
                try {
                    if(throwable1 instanceof TimeoutCancellationException) {
                        o10.invoke();
                    }
                    else {
                        if(throwable1 != null) {
                            throw throwable1;
                        }
                        Object object1 = h1.a;
                        if(object1 != null) {
                            return object1;
                        }
                    }
                    l0 = l1;
                    goto label_42;
                }
                catch(Throwable throwable2) {
                }
                h h2 = (h)h1.a;
                if(h2 != null) {
                    n0.e(h2);
                }
                throw throwable2;
            label_42:
                h3 = new H();  // 初始化器: Ljava/lang/Object;-><init>()V
                try {
                    m m0 = new m(h3, n0, null);
                    l0.r = n0;
                    l0.w = o10;
                    l0.B = h3;
                    l0.D = v;
                    l0.I = 1;
                    if(TimeoutKt.withTimeout-KLykuaI(v, m0, l0) != a0) {
                        break;
                    }
                    return a0;
                }
                catch(Throwable throwable3) {
                    a1 = o10;
                    h0 = h3;
                    throwable0 = throwable3;
                }
            label_55:
                h1 = h0;
                o10 = a1;
                l1 = l0;
                throwable1 = throwable0;
            }
            a1 = o10;
            h0 = h3;
        }
    }

    public final void c() {
        ReentrantLock reentrantLock0 = this.c;
        reentrantLock0.lock();
        try {
            this.e = true;
            h[] arr_h = this.f;
            for(int v1 = 0; v1 < arr_h.length; ++v1) {
                h h0 = arr_h[v1];
                if(h0 != null) {
                    h0.close();
                }
            }
        }
        finally {
            reentrantLock0.unlock();
        }
    }

    public final void d(StringBuilder stringBuilder0) {
        w w0 = this.h;
        ReentrantLock reentrantLock0 = this.c;
        reentrantLock0.lock();
        try {
            b b0 = e.k.l();
            int v1 = w0.c - w0.b & w0.d;
            for(int v3 = 0; v3 < v1; ++v3) {
                if(v3 < 0) {
                    throw new ArrayIndexOutOfBoundsException();
                }
                int v4 = w0.b;
                int v5 = w0.d;
                if(v3 >= (w0.c - v4 & v5)) {
                    throw new ArrayIndexOutOfBoundsException();
                }
                Object object0 = ((Object[])w0.e)[v4 + v3 & v5];
                q.d(object0);
                b0.add(object0);
            }
            b b1 = e.k.h(b0);
            stringBuilder0.append('\t' + this.toString() + " (");
            stringBuilder0.append("capacity=" + this.a + ", ");
            stringBuilder0.append("permits=" + this.g.getAvailablePermits() + ", ");
            stringBuilder0.append("queue=(size=" + b1.b() + ")[" + p.q0(b1, null, null, null, null, 0x3F) + "], ");
            stringBuilder0.append(")");
            stringBuilder0.append('\n');
            h[] arr_h = this.f;
            int v6 = 0;
            for(int v2 = 0; v2 < arr_h.length; ++v2) {
                h h0 = arr_h[v2];
                ++v6;
                stringBuilder0.append("\t\t[" + v6 + "] - " + (h0 == null ? null : h0.a.toString()));
                stringBuilder0.append('\n');
                if(h0 != null) {
                    h0.c(stringBuilder0);
                }
            }
        }
        finally {
            reentrantLock0.unlock();
        }
    }

    public final void e(h h0) {
        q.g(h0, "connection");
        this.c.lock();
        try {
            this.h.c(h0);
        }
        finally {
            this.c.unlock();
        }
        this.g.release();
    }
}

