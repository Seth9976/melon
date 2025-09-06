package c2;

import android.view.WindowInsetsAnimation;

public final class j0 extends k0 {
    public final WindowInsetsAnimation e;

    public j0(WindowInsetsAnimation windowInsetsAnimation0) {
        super(0, null, 0L);
        this.e = windowInsetsAnimation0;
    }

    @Override  // c2.k0
    public final float a() {
        return this.e.getAlpha();
    }

    @Override  // c2.k0
    public final long b() {
        return this.e.getDurationMillis();
    }

    @Override  // c2.k0
    public final float c() {
        return this.e.getInterpolatedFraction();
    }

    @Override  // c2.k0
    public final int d() {
        return this.e.getTypeMask();
    }

    @Override  // c2.k0
    public final void e(float f) {
        this.e.setFraction(f);
    }
}

