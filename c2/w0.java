package c2;

import S1.d;
import android.view.View;
import android.view.WindowInsets;

public class w0 extends v0 {
    public static final B0 r;

    static {
        w0.r = B0.h(null, WindowInsets.CONSUMED);
    }

    public w0(B0 b00, WindowInsets windowInsets0) {
        super(b00, windowInsets0);
    }

    public w0(B0 b00, w0 w00) {
        super(b00, w00);
    }

    @Override  // c2.s0
    public final void d(View view0) {
    }

    @Override  // c2.s0
    public d g(int v) {
        int v1 = z0.a(v);
        return d.d(this.c.getInsets(v1));
    }

    @Override  // c2.s0
    public d h(int v) {
        int v1 = z0.a(v);
        return d.d(this.c.getInsetsIgnoringVisibility(v1));
    }

    @Override  // c2.s0
    public boolean q(int v) {
        int v1 = z0.a(v);
        return this.c.isVisible(v1);
    }
}

