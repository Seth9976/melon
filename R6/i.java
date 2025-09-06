package r6;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import d5.e;
import e2.a;

public final class i extends AnimatorListenerAdapter {
    public boolean a;
    public final boolean b;
    public final e c;
    public final o d;

    public i(o o0, boolean z, e e0) {
        this.d = o0;
        this.b = z;
        this.c = e0;
        super();
    }

    @Override  // android.animation.AnimatorListenerAdapter
    public final void onAnimationCancel(Animator animator0) {
        this.a = true;
    }

    @Override  // android.animation.AnimatorListenerAdapter
    public final void onAnimationEnd(Animator animator0) {
        o o0 = this.d;
        o0.r = 0;
        o0.l = null;
        if(!this.a) {
            o0.v.a((this.b ? 8 : 4), this.b);
            e e0 = this.c;
            if(e0 != null) {
                ((a)e0.b).N(((FloatingActionButton)e0.c));
            }
        }
    }

    @Override  // android.animation.AnimatorListenerAdapter
    public final void onAnimationStart(Animator animator0) {
        this.d.v.a(0, this.b);
        this.d.r = 1;
        this.d.l = animator0;
        this.a = false;
    }
}

