package androidx.lifecycle;

import G.S;
import d5.n;
import df.e;
import ie.H;
import kotlinx.coroutines.CancellableContinuationImpl;

public final class t0 implements B {
    public final t a;
    public final CancellableContinuationImpl b;
    public final e c;

    public t0(t t0, CancellableContinuationImpl cancellableContinuationImpl0, e e0) {
        this.a = t0;
        this.b = cancellableContinuationImpl0;
        this.c = e0;
    }

    @Override  // androidx.lifecycle.B
    public final void onStateChanged(D d0, r r0) {
        H h0;
        r.Companion.getClass();
        CancellableContinuationImpl cancellableContinuationImpl0 = this.b;
        t t0 = this.a;
        if(r0 == p.b(s.e)) {
            t0.c(this);
            try {
                this.c.invoke();
                h0 = H.a;
            }
            catch(Throwable throwable0) {
                h0 = n.t(throwable0);
            }
            cancellableContinuationImpl0.resumeWith(h0);
            return;
        }
        if(r0 == r.ON_DESTROY) {
            t0.c(this);
            cancellableContinuationImpl0.resumeWith(n.t(new S(null, 5)));
        }
    }
}

