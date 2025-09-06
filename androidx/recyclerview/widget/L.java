package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;

public final class l extends AnimatorListenerAdapter {
    public final int a;
    public final O0 b;
    public final View c;
    public final ViewPropertyAnimator d;
    public final q e;

    public l(q q0, O0 o00, View view0, ViewPropertyAnimator viewPropertyAnimator0) {
        this.a = 1;
        this.e = q0;
        this.b = o00;
        this.c = view0;
        this.d = viewPropertyAnimator0;
        super();
    }

    public l(q q0, O0 o00, ViewPropertyAnimator viewPropertyAnimator0, View view0) {
        this.a = 0;
        this.e = q0;
        this.b = o00;
        this.d = viewPropertyAnimator0;
        this.c = view0;
        super();
    }

    @Override  // android.animation.AnimatorListenerAdapter
    public void onAnimationCancel(Animator animator0) {
        if(this.a != 1) {
            super.onAnimationCancel(animator0);
            return;
        }
        this.c.setAlpha(1.0f);
    }

    @Override  // android.animation.AnimatorListenerAdapter
    public final void onAnimationEnd(Animator animator0) {
        if(this.a != 0) {
            this.d.setListener(null);
            this.e.c(this.b);
            this.e.o.remove(this.b);
            this.e.i();
            return;
        }
        this.d.setListener(null);
        this.c.setAlpha(1.0f);
        this.e.c(this.b);
        this.e.q.remove(this.b);
        this.e.i();
    }

    @Override  // android.animation.AnimatorListenerAdapter
    public final void onAnimationStart(Animator animator0) {
        if(this.a != 0) {
            this.e.getClass();
            return;
        }
        this.e.getClass();
    }
}

