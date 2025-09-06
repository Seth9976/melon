package r6;

import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.animation.ValueAnimator;
import android.graphics.Matrix;
import e6.a;

public final class k implements ValueAnimator.AnimatorUpdateListener {
    public final float a;
    public final float b;
    public final float c;
    public final float d;
    public final float e;
    public final float f;
    public final float g;
    public final Matrix h;
    public final o i;

    public k(o o0, float f, float f1, float f2, float f3, float f4, float f5, float f6, Matrix matrix0) {
        this.i = o0;
        this.a = f;
        this.b = f1;
        this.c = f2;
        this.d = f3;
        this.e = f4;
        this.f = f5;
        this.g = f6;
        this.h = matrix0;
    }

    @Override  // android.animation.ValueAnimator$AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator0) {
        float f = (float)(((Float)valueAnimator0.getAnimatedValue()));
        this.i.v.setAlpha(a.b(this.a, this.b, 0.0f, 0.2f, f));
        this.i.v.setScaleX(a.a(this.c, this.d, f));
        this.i.v.setScaleY(a.a(this.e, this.d, f));
        this.i.p = a.a(this.f, this.g, f);
        this.i.a(a.a(this.f, this.g, f), this.h);
        this.i.v.setImageMatrix(this.h);
    }
}

