package v6;

import N4.b;
import O4.c;
import Q0.a;
import android.animation.ObjectAnimator;
import com.google.android.material.progressindicator.CircularProgressIndicatorSpec;
import java.util.ArrayList;

public final class h extends a {
    public ObjectAnimator c;
    public ObjectAnimator d;
    public final P2.a e;
    public final CircularProgressIndicatorSpec f;
    public int g;
    public float h;
    public float i;
    public c j;
    public static final int[] k;
    public static final int[] l;
    public static final int[] m;
    public static final b n;
    public static final b o;

    static {
        h.k = new int[]{0, 1350, 2700, 4050};
        h.l = new int[]{667, 2017, 0xD27, 4717};
        h.m = new int[]{1000, 2350, 3700, 5050};
        h.n = new b("animationFraction", 15, Float.class);
        h.o = new b("completeEndFraction", 16, Float.class);
    }

    public h(CircularProgressIndicatorSpec circularProgressIndicatorSpec0) {
        super(1);
        this.g = 0;
        this.j = null;
        this.f = circularProgressIndicatorSpec0;
        this.e = new P2.a(1);
    }

    @Override  // Q0.a
    public final void c() {
        ObjectAnimator objectAnimator0 = this.c;
        if(objectAnimator0 != null) {
            objectAnimator0.cancel();
        }
    }

    @Override  // Q0.a
    public final void n() {
        this.g = 0;
        m m0 = (m)((ArrayList)this.b).get(0);
        m0.c = this.f.c[0];
        this.i = 0.0f;
    }

    @Override  // Q0.a
    public final void t(v6.c c0) {
        this.j = c0;
    }

    @Override  // Q0.a
    public final void u() {
        if(this.d != null && !this.d.isRunning()) {
            if(((o)this.a).isVisible()) {
                this.d.start();
                return;
            }
            this.c();
        }
    }

    @Override  // Q0.a
    public final void w() {
        if(this.c == null) {
            ObjectAnimator objectAnimator0 = ObjectAnimator.ofFloat(this, h.n, new float[]{0.0f, 1.0f});
            this.c = objectAnimator0;
            objectAnimator0.setDuration(5400L);
            this.c.setInterpolator(null);
            this.c.setRepeatCount(-1);
            this.c.addListener(new g(this, 0));
        }
        if(this.d == null) {
            ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(this, h.o, new float[]{0.0f, 1.0f});
            this.d = objectAnimator1;
            objectAnimator1.setDuration(333L);
            this.d.setInterpolator(this.e);
            this.d.addListener(new g(this, 1));
        }
        this.g = 0;
        m m0 = (m)((ArrayList)this.b).get(0);
        m0.c = this.f.c[0];
        this.i = 0.0f;
        this.c.start();
    }

    @Override  // Q0.a
    public final void x() {
        this.j = null;
    }
}

