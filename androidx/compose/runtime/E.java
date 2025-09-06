package androidx.compose.runtime;

import androidx.compose.foundation.S;
import d5.n;
import df.v;
import e1.u;
import ie.o;
import java.util.ArrayList;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.r;
import kotlinx.coroutines.CancellableContinuationImpl;
import m0.a;
import me.g;
import me.h;
import me.i;
import we.k;

public final class e implements W {
    public final r a;
    public final Object b;
    public Throwable c;
    public ArrayList d;
    public ArrayList e;
    public final a f;

    public e(we.a a0) {
        this.a = (r)a0;
        this.b = new Object();
        this.d = new ArrayList();
        this.e = new ArrayList();
        this.f = new a(0);  // 初始化器: Ljava/util/concurrent/atomic/AtomicInteger;-><init>(I)V
    }

    public final void a(long v) {
        o o0;
        synchronized(this.b) {
            ArrayList arrayList0 = this.d;
            this.d = this.e;
            this.e = arrayList0;
            this.f.set(0);
            int v3 = arrayList0.size();
            for(int v2 = 0; v2 < v3; ++v2) {
                d d0 = (d)arrayList0.get(v2);
                CancellableContinuationImpl cancellableContinuationImpl0 = d0.b;
                try {
                    o0 = d0.a.invoke(v);
                }
                catch(Throwable throwable0) {
                    o0 = n.t(throwable0);
                }
                cancellableContinuationImpl0.resumeWith(o0);
            }
            arrayList0.clear();
        }
    }

    @Override  // androidx.compose.runtime.W
    public final Object c(k k0, Continuation continuation0) {
        CancellableContinuationImpl cancellableContinuationImpl0 = new CancellableContinuationImpl(u.D(continuation0), 1);
        cancellableContinuationImpl0.initCancellability();
        d d0 = new d(k0, cancellableContinuationImpl0);
        synchronized(this.b) {
            Throwable throwable0 = this.c;
            if(throwable0 != null) {
                cancellableContinuationImpl0.resumeWith(n.t(throwable0));
                return cancellableContinuationImpl0.getResult();
            }
            boolean z = this.d.isEmpty();
            this.d.add(d0);
            if(z) {
                this.f.set(1);
            }
        }
        cancellableContinuationImpl0.invokeOnCancellation(new S(4, this, d0));
        if(z) {
            try {
                ((we.a)this.a).invoke();
                return cancellableContinuationImpl0.getResult();
            }
            catch(Throwable throwable1) {
                Object object1 = this.b;
                __monitor_enter(object1);
                try {
                    if(this.c == null) {
                        this.c = throwable1;
                        ArrayList arrayList0 = this.d;
                        int v1 = arrayList0.size();
                        for(int v2 = 0; v2 < v1; ++v2) {
                            ((d)arrayList0.get(v2)).b.resumeWith(n.t(throwable1));
                        }
                        this.d.clear();
                        this.f.set(0);
                        goto label_40;
                    }
                    goto label_42;
                }
                catch(Throwable throwable2) {
                }
                __monitor_exit(object1);
                throw throwable2;
            label_40:
                __monitor_exit(object1);
                return cancellableContinuationImpl0.getResult();
            label_42:
                __monitor_exit(object1);
                return cancellableContinuationImpl0.getResult();
            }
        }
        return cancellableContinuationImpl0.getResult();
    }

    @Override  // me.i
    public final Object fold(Object object0, we.n n0) {
        return v.v(this, object0, n0);
    }

    @Override  // me.i
    public final g get(h h0) {
        return v.w(this, h0);
    }

    @Override  // me.i
    public final i minusKey(h h0) {
        return v.E(this, h0);
    }

    @Override  // me.i
    public final i plus(i i0) {
        return v.F(i0, this);
    }
}

