package N4;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.Transition;
import androidx.transition.Visibility;

public final class m0 extends AnimatorListenerAdapter implements S {
    public final ViewGroup a;
    public final View b;
    public final View c;
    public boolean d;
    public final Visibility e;

    public m0(Visibility visibility0, ViewGroup viewGroup0, View view0, View view1) {
        this.e = visibility0;
        super();
        this.d = true;
        this.a = viewGroup0;
        this.b = view0;
        this.c = view1;
    }

    @Override  // N4.S
    public final void a() {
    }

    @Override  // N4.S
    public final void d() {
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
        if(this.d) {
            this.h();
        }
    }

    public final void h() {
        this.c.setTag(0x7F0A0A1F, null);  // id:save_overlay_view
        this.a.getOverlay().remove(this.b);
        this.d = false;
    }

    @Override  // android.animation.AnimatorListenerAdapter
    public final void onAnimationEnd(Animator animator0) {
        this.h();
    }

    @Override  // android.animation.Animator$AnimatorListener
    public final void onAnimationEnd(Animator animator0, boolean z) {
        if(!z) {
            this.h();
        }
    }

    @Override  // android.animation.AnimatorListenerAdapter
    public final void onAnimationPause(Animator animator0) {
        this.a.getOverlay().remove(this.b);
    }

    @Override  // android.animation.AnimatorListenerAdapter
    public final void onAnimationResume(Animator animator0) {
        View view0 = this.b;
        if(view0.getParent() == null) {
            this.a.getOverlay().add(view0);
            return;
        }
        this.e.cancel();
    }

    @Override  // android.animation.Animator$AnimatorListener
    public final void onAnimationStart(Animator animator0, boolean z) {
        if(z) {
            this.c.setTag(0x7F0A0A1F, this.b);  // id:save_overlay_view
            this.a.getOverlay().add(this.b);
            this.d = true;
        }
    }
}

