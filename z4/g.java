package z4;

import Cc.o1;
import Uf.d;
import android.database.SQLException;
import d5.v;
import h7.u0;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.H;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.ThreadContextElementKt;
import me.i;
import w4.f;
import x1.a;

public final class g implements b {
    public final n a;
    public final n b;
    public final ThreadLocal c;
    public final AtomicBoolean d;
    public final long e;

    public g(v v0) {
        this.c = new ThreadLocal();
        this.d = new AtomicBoolean(false);
        this.e = a.P(30, d.d);
        n n0 = new n(1, new xd.b(v0, 1));
        this.a = n0;
        this.b = n0;
    }

    public g(v v0, String s, int v1) {
        q.g(s, "fileName");
        super();
        this.c = new ThreadLocal();
        this.d = new AtomicBoolean(false);
        this.e = a.P(30, d.d);
        if(v1 <= 0) {
            throw new IllegalArgumentException("Maximum number of readers must be greater than 0");
        }
        this.a = new n(v1, new c(v0, s, 0));
        this.b = new n(1, new c(v0, s, 1));
    }

    @Override
    public final void close() {
        if(this.d.compareAndSet(false, true)) {
            this.a.c();
            this.b.c();
        }
    }

    @Override  // z4.b
    public final Object d(boolean z, we.n n0, Continuation continuation0) {
        Throwable throwable1;
        H h1;
        n n1;
        H h0;
        n n4;
        g g1;
        i i1;
        we.n n3;
        H h2;
        Object object3;
        i i3;
        z4.d d0;
        if(continuation0 instanceof z4.d) {
            d0 = (z4.d)continuation0;
            int v = d0.S;
            if((v & 0x80000000) == 0) {
                d0 = new z4.d(this, continuation0);
            }
            else {
                d0.S = v ^ 0x80000000;
            }
        }
        else {
            d0 = new z4.d(this, continuation0);
        }
        Object object0 = d0.M;
        ne.a a0 = ne.a.a;
        switch(d0.S) {
            case 0: {
                d5.n.D(object0);
                if(!this.d.get()) {
                    ThreadLocal threadLocal0 = this.c;
                    u u0 = (u)threadLocal0.get();
                    f f0 = z4.a.b;
                    if(u0 == null) {
                        z4.a a1 = (z4.a)d0.getContext().get(f0);
                        u0 = a1 == null ? null : a1.a;
                    }
                    if(u0 == null) {
                        n n5 = z ? this.a : this.b;
                        h1 = new H();  // 初始化器: Ljava/lang/Object;-><init>()V
                        try {
                            i3 = d0.getContext();
                            o1 o10 = new o1(this, z, 2);
                            d0.r = this;
                            d0.w = n0;
                            d0.B = n5;
                            d0.D = h1;
                            d0.E = i3;
                            d0.G = h1;
                            d0.I = z;
                            d0.S = 3;
                            object3 = n5.b(this.e, o10, d0);
                        }
                        catch(Throwable throwable3) {
                            throwable1 = throwable3;
                            n1 = n5;
                            throw throwable1;
                        }
                        if(object3 != a0) {
                            n4 = n5;
                            object0 = object3;
                            i1 = i3;
                            g1 = this;
                            n3 = n0;
                            h2 = h1;
                            try {
                            label_93:
                                ((h)object0).getClass();
                                q.g(i1, "context");
                                ((h)object0).c = i1;
                                ((h)object0).d = new Throwable();
                                h2.a = new u(((h)object0), g1.a != g1.b && z);
                                Object object4 = h1.a;
                                if(object4 == null) {
                                    throw new IllegalArgumentException("Required value was null.");
                                }
                                z4.a a3 = new z4.a(((u)object4));
                                q.g(g1.c, "<this>");
                                i i4 = df.v.F(ThreadContextElementKt.asContextElement(g1.c, ((u)object4)), a3);
                                z4.f f1 = new z4.f(n3, h1, null);
                                d0.r = n4;
                                d0.w = h1;
                                d0.B = null;
                                d0.D = null;
                                d0.E = null;
                                d0.G = null;
                                d0.S = 4;
                                object0 = BuildersKt.withContext(i4, f1, d0);
                                goto label_130;
                            }
                            catch(Throwable throwable4) {
                                throwable1 = throwable4;
                                n1 = n4;
                            }
                            try {
                                throw throwable1;
                            }
                            catch(Throwable throwable5) {
                                try {
                                    u u1 = (u)h1.a;
                                    if(u1 != null) {
                                        if(u1.d.compareAndSet(false, true)) {
                                            try {
                                                u0.w("ROLLBACK TRANSACTION", u1.a);
                                            }
                                            catch(SQLException unused_ex) {
                                            }
                                        }
                                        u1.a.c = null;
                                        u1.a.d = null;
                                        n1.e(u1.a);
                                    }
                                }
                                catch(Throwable throwable6) {
                                    e2.a.q(throwable1, throwable6);
                                }
                                throw throwable5;
                            }
                        label_130:
                            if(object0 != a0) {
                                h0 = h1;
                                n1 = n4;
                                try {
                                label_133:
                                    u u2 = (u)h0.a;
                                    if(u2 != null) {
                                        h h4 = u2.a;
                                        if(u2.d.compareAndSet(false, true)) {
                                            try {
                                                u0.w("ROLLBACK TRANSACTION", h4);
                                            }
                                            catch(SQLException unused_ex) {
                                            }
                                        }
                                        h4.c = null;
                                        h4.d = null;
                                        n1.e(h4);
                                    }
                                }
                                catch(Throwable unused_ex) {
                                }
                                return object0;
                            }
                        }
                    }
                    else {
                        if(!z && u0.b) {
                            u0.S(1, "Cannot upgrade connection from reader to writer");
                            throw null;
                        }
                        if(d0.getContext().get(f0) == null) {
                            z4.a a2 = new z4.a(u0);
                            q.g(threadLocal0, "<this>");
                            i i2 = df.v.F(ThreadContextElementKt.asContextElement(threadLocal0, u0), a2);
                            e e0 = new e(n0, u0, null);
                            d0.S = 1;
                            Object object1 = BuildersKt.withContext(i2, e0, d0);
                            if(object1 != a0) {
                                return object1;
                            }
                        }
                        else {
                            d0.S = 2;
                            Object object2 = n0.invoke(u0, d0);
                            if(object2 != a0) {
                                return object2;
                            }
                        }
                    }
                    return a0;
                }
                u0.S(21, "Connection pool is closed");
                throw null;
            }
            case 1: {
                d5.n.D(object0);
                return object0;
            }
            case 2: {
                d5.n.D(object0);
                return object0;
            }
            case 3: {
                z = d0.I;
                h2 = d0.G;
                i i0 = d0.E;
                H h3 = d0.D;
                n n2 = d0.B;
                n3 = (we.n)d0.w;
                g g0 = (g)d0.r;
                try {
                    d5.n.D(object0);
                    i1 = i0;
                    h1 = h3;
                    g1 = g0;
                    n4 = n2;
                    goto label_93;
                }
                catch(Throwable throwable2) {
                    throwable1 = throwable2;
                    h1 = h3;
                    n1 = n2;
                    throw throwable1;
                }
            }
            case 4: {
                h0 = (H)d0.w;
                n1 = (n)d0.r;
                try {
                    d5.n.D(object0);
                    goto label_133;
                }
                catch(Throwable throwable0) {
                    h1 = h0;
                    throwable1 = throwable0;
                    throw throwable1;
                }
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

