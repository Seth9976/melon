package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;

public final class m extends AnimatorListenerAdapter {
    public final O0 a;
    public final int b;
    public final View c;
    public final int d;
    public final ViewPropertyAnimator e;
    public final q f;

    public m(q q0, O0 o00, int v, View view0, int v1, ViewPropertyAnimator viewPropertyAnimator0) {
        this.f = q0;
        this.a = o00;
        this.b = v;
        this.c = view0;
        this.d = v1;
        this.e = viewPropertyAnimator0;
        super();
    }

    @Override  // android.animation.AnimatorListenerAdapter
    public final void onAnimationCancel(Animator animator0) {
        View view0 = this.c;
        if(this.b != 0) {
            view0.setTranslationX(0.0f);
        }
        if(this.d != 0) {
            view0.setTranslationY(0.0f);
        }
    }

    @Override  // android.animation.AnimatorListenerAdapter
    public final void onAnimationEnd(Animator animator0) {
        this.e.setListener(null);
        this.f.c(this.a);
        this.f.p.remove(this.a);
        this.f.i();
    }

    @Override  // android.animation.AnimatorListenerAdapter
    public final void onAnimationStart(Animator animator0) {
        this.f.getClass();
    }
}

