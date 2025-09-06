package w6;

import R1.a;
import android.graphics.Typeface;
import e1.u;

public final class b extends a {
    public final u h;
    public final d i;

    public b(d d0, u u0) {
        this.i = d0;
        this.h = u0;
    }

    @Override  // R1.a
    public final void j(int v) {
        this.i.m = true;
        this.h.K(v);
    }

    @Override  // R1.a
    public final void k(Typeface typeface0) {
        this.i.n = Typeface.create(typeface0, this.i.c);
        this.i.m = true;
        this.h.L(this.i.n, false);
    }
}

