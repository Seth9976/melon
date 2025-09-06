package v6;

import O4.c;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

public final class r extends AnimatorListenerAdapter {
    public final int a;
    public final s b;

    public r(s s0, int v) {
        this.a = v;
        this.b = s0;
        super();
    }

    @Override  // android.animation.AnimatorListenerAdapter
    public void onAnimationEnd(Animator animator0) {
        if(this.a != 1) {
            super.onAnimationEnd(animator0);
            return;
        }
        super.onAnimationEnd(animator0);
        s s0 = this.b;
        s0.c();
        c c0 = s0.j;
        if(c0 != null) {
            c0.a(((o)s0.a));
        }
    }

    @Override  // android.animation.AnimatorListenerAdapter
    public void onAnimationRepeat(Animator animator0) {
        if(this.a != 0) {
            super.onAnimationRepeat(animator0);
            return;
        }
        super.onAnimationRepeat(animator0);
        this.b.g = (this.b.g + 1) % this.b.f.c.length;
        this.b.h = true;
    }
}

