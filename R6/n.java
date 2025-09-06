package r6;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.animation.ValueAnimator;
import z6.i;

public abstract class n extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {
    public boolean a;
    public float b;
    public float c;
    public final q d;

    public n(q q0) {
        this.d = q0;
        super();
    }

    public abstract float a();

    @Override  // android.animation.AnimatorListenerAdapter
    public final void onAnimationEnd(Animator animator0) {
        float f = (float)(((int)this.c));
        i i0 = this.d.b;
        if(i0 != null) {
            i0.l(f);
        }
        this.a = false;
    }

    @Override  // android.animation.ValueAnimator$AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator0) {
        q q0 = this.d;
        if(!this.a) {
            this.b = q0.b == null ? 0.0f : q0.b.a.m;
            this.c = this.a();
            this.a = true;
        }
        float f = this.b;
        float f1 = this.c - f;
        float f2 = valueAnimator0.getAnimatedFraction();
        i i0 = q0.b;
        if(i0 != null) {
            i0.l(((float)(((int)(f2 * f1 + f)))));
        }
    }
}

