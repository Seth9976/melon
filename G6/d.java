package G6;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import m6.e;

public final class d extends AnimatorListenerAdapter {
    public final int a;
    public final e b;

    public d(e e0, int v) {
        this.a = v;
        this.b = e0;
        super();
    }

    @Override  // android.animation.AnimatorListenerAdapter
    public final void onAnimationEnd(Animator animator0) {
        if(this.a != 0) {
            this.b.b();
            return;
        }
        m6.d d0 = this.b.getRevealInfo();
        d0.c = 3.402823E+38f;
        this.b.setRevealInfo(d0);
    }

    @Override  // android.animation.AnimatorListenerAdapter
    public void onAnimationStart(Animator animator0) {
        if(this.a != 1) {
            super.onAnimationStart(animator0);
            return;
        }
        this.b.a();
    }
}

