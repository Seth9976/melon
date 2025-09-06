package b;

import kotlin.jvm.internal.q;
import we.a;

public final class s implements b {
    public final n a;
    public final t b;

    public s(t t0, n n0) {
        q.g(n0, "onBackPressedCallback");
        this.b = t0;
        this.a = n0;
    }

    @Override  // b.b
    public final void cancel() {
        t t0 = this.b;
        n n0 = this.a;
        t0.b.remove(n0);
        if(q.b(t0.c, n0)) {
            n0.handleOnBackCancelled();
            t0.c = null;
        }
        n0.removeCancellable(this);
        a a0 = n0.getEnabledChangedCallback$activity_release();
        if(a0 != null) {
            a0.invoke();
        }
        n0.setEnabledChangedCallback$activity_release(null);
    }
}

