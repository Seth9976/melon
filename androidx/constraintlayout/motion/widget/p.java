package androidx.constraintlayout.motion.widget;

import A1.e;
import android.view.animation.Interpolator;

public final class p implements Interpolator {
    public final int a;
    public final e b;

    public p(e e0, int v) {
        this.a = v;
        this.b = e0;
        super();
    }

    @Override  // android.animation.TimeInterpolator
    public final float getInterpolation(float f) {
        switch(this.a) {
            case 0: {
                return (float)this.b.a(((double)f));
            }
            case 1: {
                return (float)this.b.a(((double)f));
            }
            default: {
                return (float)this.b.a(((double)f));
            }
        }
    }
}

