package androidx.lifecycle;

import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt__JobKt;
import me.i;
import we.n;

public final class y implements B, CoroutineScope {
    public final t a;
    public final i b;

    public y(t t0, i i0) {
        q.g(i0, "coroutineContext");
        super();
        this.a = t0;
        this.b = i0;
        if(t0.b() == s.a) {
            JobKt__JobKt.cancel$default(i0, null, 1, null);
        }
    }

    public final void a(n n0) {
        BuildersKt__Builders_commonKt.launch$default(this, null, null, new v(this, n0, null), 3, null);
    }

    public final void b(n n0) {
        BuildersKt__Builders_commonKt.launch$default(this, null, null, new w(this, n0, null), 3, null);
    }

    @Override  // kotlinx.coroutines.CoroutineScope
    public final i getCoroutineContext() {
        return this.b;
    }

    @Override  // androidx.lifecycle.B
    public final void onStateChanged(D d0, r r0) {
        t t0 = this.a;
        if(t0.b().compareTo(s.a) <= 0) {
            t0.c(this);
            JobKt__JobKt.cancel$default(this.b, null, 1, null);
        }
    }
}

