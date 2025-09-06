package Q0;

import Ld.p;
import androidx.compose.runtime.r;
import androidx.compose.runtime.v;
import androidx.lifecycle.B;
import androidx.lifecycle.D;
import androidx.lifecycle.t;
import we.n;

public final class u1 implements r, B {
    public final u a;
    public final v b;
    public boolean c;
    public t d;
    public n e;

    public u1(u u0, v v0) {
        this.a = u0;
        this.b = v0;
        this.e = j0.a;
    }

    @Override  // androidx.compose.runtime.r
    public final void a() {
        if(!this.c) {
            this.c = true;
            this.a.setTag(0x7F0A0DF4, null);  // id:wrapped_composition_tag
            t t0 = this.d;
            if(t0 != null) {
                t0.c(this);
            }
        }
        this.b.a();
    }

    public final void b(n n0) {
        p p0 = new p(11, this, n0);
        this.a.setOnViewTreeOwnersAvailable(p0);
    }

    @Override  // androidx.lifecycle.B
    public final void onStateChanged(D d0, androidx.lifecycle.r r0) {
        if(r0 == androidx.lifecycle.r.ON_DESTROY) {
            this.a();
            return;
        }
        if(r0 == androidx.lifecycle.r.ON_CREATE && !this.c) {
            this.b(this.e);
        }
    }
}

