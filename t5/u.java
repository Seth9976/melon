package t5;

import androidx.lifecycle.D;
import androidx.lifecycle.t;
import i5.n;
import java.util.concurrent.CancellationException;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job.DefaultImpls;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.MainCoroutineDispatcher;
import v5.a;
import x5.g;

public final class u implements r {
    public final n a;
    public final j b;
    public final a c;
    public final t d;
    public final Job e;

    public u(n n0, j j0, a a0, t t0, Job job0) {
        this.a = n0;
        this.b = j0;
        this.c = a0;
        this.d = t0;
        this.e = job0;
    }

    @Override  // t5.r
    public final void h() {
        a a0 = this.c;
        if(a0.b.isAttachedToWindow()) {
            return;
        }
        w w0 = g.c(a0.b);
        u u0 = w0.d;
        if(u0 != null) {
            t t0 = u0.d;
            DefaultImpls.cancel$default(u0.e, null, 1, null);
            a a1 = u0.c;
            if(a1 != null) {
                t0.c(a1);
            }
            t0.c(u0);
        }
        w0.d = this;
        throw new CancellationException("\'ViewTarget.view\' must be attached to a window.");
    }

    @Override  // androidx.lifecycle.f
    public final void onDestroy(D d0) {
        w w0 = g.c(this.c.b);
        synchronized(w0) {
            Job job0 = w0.c;
            if(job0 != null) {
                DefaultImpls.cancel$default(job0, null, 1, null);
            }
            MainCoroutineDispatcher mainCoroutineDispatcher0 = Dispatchers.getMain().getImmediate();
            v v1 = new v(w0, null);
            w0.c = BuildersKt__Builders_commonKt.launch$default(() -> me.j.a, mainCoroutineDispatcher0, null, v1, 2, null);
            w0.b = null;
        }
    }

    @Override  // t5.r
    public final void start() {
        t t0 = this.d;
        t0.a(this);
        a a0 = this.c;
        if(a0 != null) {
            t0.c(a0);
            t0.a(a0);
        }
        w w0 = g.c(a0.b);
        u u0 = w0.d;
        if(u0 != null) {
            t t1 = u0.d;
            DefaultImpls.cancel$default(u0.e, null, 1, null);
            a a1 = u0.c;
            if(a1 != null) {
                t1.c(a1);
            }
            t1.c(u0);
        }
        w0.d = this;
    }
}

