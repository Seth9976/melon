package b;

import Ic.h;
import androidx.lifecycle.B;
import androidx.lifecycle.D;
import androidx.lifecycle.t;
import kotlin.jvm.internal.q;

public final class r implements B, b {
    public final t a;
    public final n b;
    public s c;
    public final b.t d;

    public r(b.t t0, t t1, n n0) {
        q.g(n0, "onBackPressedCallback");
        this.d = t0;
        this.a = t1;
        this.b = n0;
        t1.a(this);
    }

    @Override  // b.b
    public final void cancel() {
        this.a.c(this);
        this.b.removeCancellable(this);
        s s0 = this.c;
        if(s0 != null) {
            s0.cancel();
        }
        this.c = null;
    }

    @Override  // androidx.lifecycle.B
    public final void onStateChanged(D d0, androidx.lifecycle.r r0) {
        if(r0 == androidx.lifecycle.r.ON_START) {
            this.d.getClass();
            q.g(this.b, "onBackPressedCallback");
            this.d.b.addLast(this.b);
            s s0 = new s(this.d, this.b);
            this.b.addCancellable(s0);
            this.d.e();
            h h0 = new h(0, this.d, b.t.class, "updateEnabledCallbacks", "updateEnabledCallbacks()V", 0, 8);
            this.b.setEnabledChangedCallback$activity_release(h0);
            this.c = s0;
            return;
        }
        if(r0 == androidx.lifecycle.r.ON_STOP) {
            s s1 = this.c;
            if(s1 != null) {
                s1.cancel();
            }
        }
        else if(r0 == androidx.lifecycle.r.ON_DESTROY) {
            this.cancel();
        }
    }
}

