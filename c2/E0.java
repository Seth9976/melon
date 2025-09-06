package c2;

import S1.d;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.animation.ValueAnimator;
import android.os.Build.VERSION;
import android.view.View;
import java.util.Collections;
import java.util.List;

public final class e0 implements ValueAnimator.AnimatorUpdateListener {
    public final l0 a;
    public final B0 b;
    public final B0 c;
    public final int d;
    public final View e;

    public e0(l0 l00, B0 b00, B0 b01, int v, View view0) {
        this.a = l00;
        this.b = b00;
        this.c = b01;
        this.d = v;
        this.e = view0;
    }

    @Override  // android.animation.ValueAnimator$AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator0) {
        o0 o00;
        float f = valueAnimator0.getAnimatedFraction();
        l0 l00 = this.a;
        l00.a.e(f);
        B0 b00 = this.b;
        y0 y00 = b00.a;
        float f1 = l00.a.c();
        int v = Build.VERSION.SDK_INT;
        if(v >= 34) {
            o00 = new q0(b00);
        }
        else if(v >= 30) {
            o00 = new p0(b00);
        }
        else if(v >= 29) {
            o00 = new o0(b00);
        }
        else {
            o00 = new m0(b00);
        }
        for(int v1 = 1; v1 <= 0x200; v1 <<= 1) {
            if((this.d & v1) == 0) {
                o00.c(v1, y00.g(v1));
            }
            else {
                d d0 = y00.g(v1);
                d d1 = this.c.a.g(v1);
                o00.c(v1, B0.e(d0, ((int)(((double)(((float)(d0.a - d1.a)) * (1.0f - f1))) + 0.5)), ((int)(((double)(((float)(d0.b - d1.b)) * (1.0f - f1))) + 0.5)), ((int)(((double)(((float)(d0.c - d1.c)) * (1.0f - f1))) + 0.5)), ((int)(((double)(((float)(d0.d - d1.d)) * (1.0f - f1))) + 0.5))));
            }
        }
        B0 b01 = o00.b();
        List list0 = Collections.singletonList(l00);
        g0.h(this.e, b01, list0);
    }
}

