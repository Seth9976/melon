package androidx.viewpager.widget;

import android.view.animation.Interpolator;

public final class e implements Interpolator {
    public final int a;

    public e(int v) {
        this.a = v;
        super();
    }

    @Override  // android.animation.TimeInterpolator
    public final float getInterpolation(float f) {
        return (f - 1.0f) * (f - 1.0f) * (f - 1.0f) * (f - 1.0f) * (f - 1.0f) + 1.0f;
    }
}

