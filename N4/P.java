package N4;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import androidx.transition.Transition;

public final class p extends AnimatorListenerAdapter implements S {
    public final View a;
    public boolean b;

    public p(View view0) {
        this.b = false;
        this.a = view0;
    }

    @Override  // N4.S
    public final void a() {
        float f = this.a.getVisibility() == 0 ? e0.a.g(this.a) : 0.0f;
        this.a.setTag(0x7F0A0BE2, f);  // id:transition_pause_alpha
    }

    @Override  // N4.S
    public final void b(Transition transition0) {
    }

    @Override  // N4.S
    public final void d() {
        this.a.setTag(0x7F0A0BE2, null);  // id:transition_pause_alpha
    }

    @Override  // N4.S
    public final void e(Transition transition0) {
    }

    @Override  // N4.S
    public final void f(Transition transition0) {
    }

    @Override  // N4.S
    public final void g(Transition transition0) {
    }

    @Override  // android.animation.AnimatorListenerAdapter
    public final void onAnimationCancel(Animator animator0) {
        e0.b(this.a, 1.0f);
    }

    @Override  // android.animation.AnimatorListenerAdapter
    public final void onAnimationEnd(Animator animator0) {
        this.onAnimationEnd(animator0, false);
    }

    @Override  // android.animation.Animator$AnimatorListener
    public final void onAnimationEnd(Animator animator0, boolean z) {
        View view0 = this.a;
        if(this.b) {
            view0.setLayerType(0, null);
        }
        if(!z) {
            e0.b(view0, 1.0f);
            e0.a.getClass();
        }
    }

    @Override  // android.animation.AnimatorListenerAdapter
    public final void onAnimationStart(Animator animator0) {
        View view0 = this.a;
        if(view0.hasOverlappingRendering() && view0.getLayerType() == 0) {
            this.b = true;
            view0.setLayerType(2, null);
        }
    }
}

