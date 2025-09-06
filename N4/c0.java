package N4;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import androidx.transition.Transition;

public final class c0 extends AnimatorListenerAdapter implements S {
    public final View a;
    public final View b;
    public int[] c;
    public float d;
    public float e;
    public final float f;
    public final float g;
    public boolean h;

    public c0(View view0, View view1, float f, float f1) {
        this.b = view0;
        this.a = view1;
        this.f = f;
        this.g = f1;
        int[] arr_v = (int[])view1.getTag(0x7F0A0BE3);  // id:transition_position
        this.c = arr_v;
        if(arr_v != null) {
            view1.setTag(0x7F0A0BE3, null);  // id:transition_position
        }
    }

    @Override  // N4.S
    public final void a() {
        if(this.c == null) {
            this.c = new int[2];
        }
        this.b.getLocationOnScreen(this.c);
        this.a.setTag(0x7F0A0BE3, this.c);  // id:transition_position
        this.d = this.b.getTranslationX();
        this.e = this.b.getTranslationY();
        this.b.setTranslationX(this.f);
        this.b.setTranslationY(this.g);
    }

    @Override  // N4.S
    public final void c(Transition transition0) {
        if(!this.h) {
            this.a.setTag(0x7F0A0BE3, null);  // id:transition_position
        }
    }

    @Override  // N4.S
    public final void d() {
        this.b.setTranslationX(this.d);
        this.b.setTranslationY(this.e);
    }

    @Override  // N4.S
    public final void e(Transition transition0) {
    }

    @Override  // N4.S
    public final void f(Transition transition0) {
        this.c(transition0);
    }

    @Override  // N4.S
    public final void g(Transition transition0) {
        this.h = true;
        this.b.setTranslationX(this.f);
        this.b.setTranslationY(this.g);
    }

    @Override  // android.animation.AnimatorListenerAdapter
    public final void onAnimationCancel(Animator animator0) {
        this.h = true;
        this.b.setTranslationX(this.f);
        this.b.setTranslationY(this.g);
    }

    @Override  // android.animation.AnimatorListenerAdapter
    public final void onAnimationEnd(Animator animator0) {
        this.onAnimationEnd(animator0, false);
    }

    @Override  // android.animation.Animator$AnimatorListener
    public final void onAnimationEnd(Animator animator0, boolean z) {
        if(!z) {
            this.b.setTranslationX(this.f);
            this.b.setTranslationY(this.g);
        }
    }
}

