package androidx.compose.runtime;

import F.e;
import h0.b;
import ie.H;
import java.util.Collection;
import java.util.List;
import je.p;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import ne.a;
import oe.i;
import p0.m;
import we.n;

public final class r0 extends i implements n {
    public Object B;
    public final u0 D;
    public final t0 E;
    public final W G;
    public j3.n r;
    public int w;

    public r0(u0 u00, t0 t00, W w0, Continuation continuation0) {
        this.D = u00;
        this.E = t00;
        this.G = w0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new r0(this.D, this.E, this.G, continuation0);
        continuation1.B = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((r0)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        List list0;
        Throwable throwable0;
        j3.n n1;
        Job job0;
        a a0 = a.a;
        switch(this.w) {
            case 0: {
                d5.n.D(object0);
                job0 = JobKt.getJob(((CoroutineScope)this.B).getCoroutineContext());
                u0 u00 = this.D;
                synchronized(u00.c) {
                    throwable0 = u00.e;
                    if(throwable0 == null) {
                        if(((o0)u00.u.getValue()).compareTo(o0.b) <= 0) {
                            throw new IllegalStateException("Recomposer shut down");
                        }
                        if(u00.d != null) {
                            throw new IllegalStateException("Recomposer already running");
                        }
                        u00.d = job0;
                        u00.u();
                        e e0 = new e(this.D, 17);
                        m.f(p0.a.h);
                        synchronized(m.b) {
                            m.g = p.z0(e0, ((Collection)m.g));
                        }
                        j3.n n0 = new j3.n(e0, 5);
                        V v2 = this.D.x;
                        do {
                            MutableStateFlow mutableStateFlow0 = u0.y;
                            b b0 = (b)mutableStateFlow0.getValue();
                            k0.b b1 = (k0.b)b0;
                            l0.b b2 = l0.b.a;
                            j0.b b3 = b1.c;
                            if(!b3.containsKey(v2)) {
                                if(b1.isEmpty()) {
                                    b1 = new k0.b(v2, v2, b3.a(v2, new k0.a(b2, b2)));
                                }
                                else {
                                    Object object2 = b3.get(b1.b);
                                    q.d(object2);
                                    k0.a a1 = new k0.a(((k0.a)object2).a, v2);
                                    j0.b b4 = b3.a(b1.b, a1).a(v2, new k0.a(b1.b, b2));
                                    b1 = new k0.b(b1.a, v2, b4);
                                }
                            }
                        }
                        while(b0 != b1 && !mutableStateFlow0.compareAndSet(b0, b1));
                        try {
                            synchronized(this.D.c) {
                                list0 = this.D.x();
                            }
                            int v4 = list0.size();
                            for(int v5 = 0; v5 < v4; ++v5) {
                                ((v)list0.get(v5)).r();
                            }
                            q0 q00 = new q0(this.E, this.G, null);
                            this.B = job0;
                            this.r = n0;
                            this.w = 1;
                            if(CoroutineScopeKt.coroutineScope(q00, this) == a0) {
                                return a0;
                            }
                        }
                        catch(Throwable throwable1) {
                            n1 = n0;
                            goto label_78;
                        }
                        n1 = n0;
                        break;
                    }
                }
                throw throwable0;
            }
            case 1: {
                n1 = this.r;
                job0 = (Job)this.B;
                try {
                    d5.n.D(object0);
                    break;
                }
                catch(Throwable throwable1) {
                }
            label_78:
                n1.d();
                u0 u01 = this.D;
                synchronized(u01.c) {
                    if(u01.d == job0) {
                        u01.d = null;
                    }
                    u01.u();
                }
                V.b(this.D.x);
                throw throwable1;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        n1.d();
        u0 u02 = this.D;
        synchronized(u02.c) {
            if(u02.d == job0) {
                u02.d = null;
            }
            u02.u();
        }
        V.b(this.D.x);
        return H.a;
    }
}

