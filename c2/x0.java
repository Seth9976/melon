package c2;

import S1.d;
import android.view.WindowInsets;

public final class x0 extends w0 {
    public static final B0 s;

    static {
        x0.s = B0.h(null, WindowInsets.CONSUMED);
    }

    public x0(B0 b00, WindowInsets windowInsets0) {
        super(b00, windowInsets0);
    }

    public x0(B0 b00, x0 x00) {
        super(b00, x00);
    }

    @Override  // c2.w0
    public d g(int v) {
        int v1 = A0.a(v);
        return d.d(this.c.getInsets(v1));
    }

    @Override  // c2.w0
    public d h(int v) {
        int v1 = A0.a(v);
        return d.d(this.c.getInsetsIgnoringVisibility(v1));
    }

    @Override  // c2.w0
    public boolean q(int v) {
        int v1 = A0.a(v);
        return this.c.isVisible(v1);
    }
}

