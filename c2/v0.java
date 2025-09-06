package c2;

import S1.d;
import android.view.WindowInsets;

public class v0 extends u0 {
    public d o;
    public d p;
    public d q;

    public v0(B0 b00, WindowInsets windowInsets0) {
        super(b00, windowInsets0);
        this.o = null;
        this.p = null;
        this.q = null;
    }

    public v0(B0 b00, v0 v00) {
        super(b00, v00);
        this.o = null;
        this.p = null;
        this.q = null;
    }

    @Override  // c2.y0
    public d i() {
        if(this.p == null) {
            this.p = d.d(this.c.getMandatorySystemGestureInsets());
        }
        return this.p;
    }

    @Override  // c2.y0
    public d k() {
        if(this.o == null) {
            this.o = d.d(this.c.getSystemGestureInsets());
        }
        return this.o;
    }

    @Override  // c2.y0
    public d m() {
        if(this.q == null) {
            this.q = d.d(this.c.getTappableElementInsets());
        }
        return this.q;
    }

    @Override  // c2.s0
    public B0 n(int v, int v1, int v2, int v3) {
        return B0.h(null, this.c.inset(v, v1, v2, v3));
    }

    @Override  // c2.t0
    public void u(d d0) {
    }
}

