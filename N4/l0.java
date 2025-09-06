package N4;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.Transition;

public final class l0 extends AnimatorListenerAdapter implements S {
    public final View a;
    public final int b;
    public final ViewGroup c;
    public final boolean d;
    public boolean e;
    public boolean f;

    public l0(View view0, int v) {
        this.f = false;
        this.a = view0;
        this.b = v;
        this.c = (ViewGroup)view0.getParent();
        this.d = true;
        this.h(true);
    }

    @Override  // N4.S
    public final void a() {
        this.h(false);
        if(!this.f) {
            e0.c(this.a, this.b);
        }
    }

    @Override  // N4.S
    public final void d() {
        this.h(true);
        if(!this.f) {
            e0.c(this.a, 0);
        }
    }

    @Override  // N4.S
    public final void e(Transition transition0) {
    }

    @Override  // N4.S
    public final void f(Transition transition0) {
        transition0.A(this);
    }

    @Override  // N4.S
    public final void g(Transition transition0) {
    }

    public final void h(boolean z) {
        if(this.d && this.e != z) {
            ViewGroup viewGroup0 = this.c;
            if(viewGroup0 != null) {
                this.e = z;
                L.l(viewGroup0, z);
            }
        }
    }

    @Override  // android.animation.AnimatorListenerAdapter
    public final void onAnimationCancel(Animator animator0) {
        this.f = true;
    }

    @Override  // android.animation.AnimatorListenerAdapter
    public final void onAnimationEnd(Animator animator0) {
        if(!this.f) {
            e0.c(this.a, this.b);
            ViewGroup viewGroup0 = this.c;
            if(viewGroup0 != null) {
                viewGroup0.invalidate();
            }
        }
        this.h(false);
    }

    @Override  // android.animation.Animator$AnimatorListener
    public final void onAnimationEnd(Animator animator0, boolean z) {
        if(!z) {
            if(!this.f) {
                e0.c(this.a, this.b);
                ViewGroup viewGroup0 = this.c;
                if(viewGroup0 != null) {
                    viewGroup0.invalidate();
                }
            }
            this.h(false);
        }
    }

    @Override  // android.animation.AnimatorListenerAdapter
    public final void onAnimationRepeat(Animator animator0) {
    }

    @Override  // android.animation.AnimatorListenerAdapter
    public final void onAnimationStart(Animator animator0) {
    }

    @Override  // android.animation.Animator$AnimatorListener
    public final void onAnimationStart(Animator animator0, boolean z) {
        if(z) {
            e0.c(this.a, 0);
            ViewGroup viewGroup0 = this.c;
            if(viewGroup0 != null) {
                viewGroup0.invalidate();
            }
        }
    }
}

