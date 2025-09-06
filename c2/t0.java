package c2;

import S1.d;
import android.view.WindowInsets;

public class t0 extends s0 {
    public d n;

    public t0(B0 b00, WindowInsets windowInsets0) {
        super(b00, windowInsets0);
        this.n = null;
    }

    public t0(B0 b00, t0 t00) {
        super(b00, t00);
        this.n = t00.n;
    }

    @Override  // c2.y0
    public B0 b() {
        return B0.h(null, this.c.consumeStableInsets());
    }

    @Override  // c2.y0
    public B0 c() {
        return B0.h(null, this.c.consumeSystemWindowInsets());
    }

    @Override  // c2.y0
    public final d j() {
        if(this.n == null) {
            this.n = d.c(this.c.getStableInsetLeft(), this.c.getStableInsetTop(), this.c.getStableInsetRight(), this.c.getStableInsetBottom());
        }
        return this.n;
    }

    @Override  // c2.y0
    public boolean o() {
        return this.c.isConsumed();
    }

    @Override  // c2.y0
    public void u(d d0) {
        this.n = d0;
    }
}

