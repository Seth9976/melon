package c2;

import Qc.l;
import S1.d;
import android.graphics.Insets;
import android.view.WindowInsets.Builder;
import android.view.WindowInsets;

public class o0 extends r0 {
    public final WindowInsets.Builder c;

    public o0() {
        this.c = n0.j();
    }

    public o0(B0 b00) {
        super(b00);
        WindowInsets windowInsets0 = b00.g();
        this.c = windowInsets0 == null ? n0.j() : n0.k(windowInsets0);
    }

    @Override  // c2.r0
    public B0 b() {
        this.a();
        B0 b00 = B0.h(null, this.c.build());
        b00.a.r(this.b);
        return b00;
    }

    @Override  // c2.r0
    public void d(d d0) {
        Insets insets0 = d0.e();
        this.c.setMandatorySystemGestureInsets(insets0);
    }

    @Override  // c2.r0
    public void e(d d0) {
        Insets insets0 = d0.e();
        n0.r(this.c, insets0);
    }

    @Override  // c2.r0
    public void f(d d0) {
        Insets insets0 = d0.e();
        this.c.setSystemGestureInsets(insets0);
    }

    @Override  // c2.r0
    public void g(d d0) {
        Insets insets0 = d0.e();
        l.x(this.c, insets0);
    }

    @Override  // c2.r0
    public void h(d d0) {
        Insets insets0 = d0.e();
        this.c.setTappableElementInsets(insets0);
    }
}

