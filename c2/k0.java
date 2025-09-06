package c2;

import android.view.animation.Interpolator;

public abstract class k0 {
    public final int a;
    public float b;
    public final Interpolator c;
    public final long d;

    public k0(int v, Interpolator interpolator0, long v1) {
        this.a = v;
        this.c = interpolator0;
        this.d = v1;
    }

    public float a() {
        return 1.0f;
    }

    public long b() {
        return this.d;
    }

    public float c() {
        return this.c == null ? this.b : this.c.getInterpolation(this.b);
    }

    public int d() {
        return this.a;
    }

    public void e(float f) {
        this.b = f;
    }
}

