package W;

import L.a;
import P0.j0;
import P0.l;
import P0.m;
import P0.q;
import U.f0;
import Y.Q;
import androidx.compose.runtime.O0;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.w;
import r0.p;

public final class r extends p implements l, m, q {
    public t a;
    public f0 b;
    public Q c;
    public final b0 d;

    public r(t t0, f0 f00, Q q0) {
        this.a = t0;
        this.b = f00;
        this.c = q0;
        this.d = w.s(null);
    }

    @Override  // P0.q
    public final void I(j0 j00) {
        ((O0)this.d).setValue(j00);
    }

    @Override  // r0.p
    public final void onAttach() {
        t t0 = this.a;
        if(t0.a != null) {
            a.c("Expected textInputModifierNode to be null");
        }
        t0.a = this;
    }

    @Override  // r0.p
    public final void onDetach() {
        this.a.i(this);
    }
}

