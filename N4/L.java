package N4;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Matrix;
import android.view.View;
import c2.M;

public final class l extends AnimatorListenerAdapter {
    public boolean a;
    public final Matrix b;
    public final boolean c;
    public final boolean d;
    public final View e;
    public final n f;
    public final m g;
    public final Matrix h;

    public l(View view0, n n0, m m0, Matrix matrix0, boolean z, boolean z1) {
        this.b = new Matrix();
        this.c = z;
        this.d = z1;
        this.e = view0;
        this.f = n0;
        this.g = m0;
        this.h = matrix0;
    }

    @Override  // android.animation.AnimatorListenerAdapter
    public final void onAnimationCancel(Animator animator0) {
        this.a = true;
    }

    @Override  // android.animation.AnimatorListenerAdapter
    public final void onAnimationEnd(Animator animator0) {
        n n0 = this.f;
        View view0 = this.e;
        if(!this.a) {
            if(!this.c || !this.d) {
                view0.setTag(0x7F0A0BE5, null);  // id:transition_transform
                view0.setTag(0x7F0A0903, null);  // id:parent_matrix
            }
            else {
                this.b.set(this.h);
                view0.setTag(0x7F0A0BE5, this.b);  // id:transition_transform
                view0.setTranslationX(n0.a);
                view0.setTranslationY(n0.b);
                M.p(view0, n0.c);
                view0.setScaleX(n0.d);
                view0.setScaleY(n0.e);
                view0.setRotationX(n0.f);
                view0.setRotationY(n0.g);
                view0.setRotation(n0.h);
            }
        }
        e0.a.m(view0, null);
        view0.setTranslationX(n0.a);
        view0.setTranslationY(n0.b);
        M.p(view0, n0.c);
        view0.setScaleX(n0.d);
        view0.setScaleY(n0.e);
        view0.setRotationX(n0.f);
        view0.setRotationY(n0.g);
        view0.setRotation(n0.h);
    }

    @Override  // android.animation.AnimatorListenerAdapter
    public final void onAnimationPause(Animator animator0) {
        this.b.set(this.g.a);
        this.e.setTag(0x7F0A0BE5, this.b);  // id:transition_transform
        this.e.setTranslationX(this.f.a);
        this.e.setTranslationY(this.f.b);
        M.p(this.e, this.f.c);
        this.e.setScaleX(this.f.d);
        this.e.setScaleY(this.f.e);
        this.e.setRotationX(this.f.f);
        this.e.setRotationY(this.f.g);
        this.e.setRotation(this.f.h);
    }

    @Override  // android.animation.AnimatorListenerAdapter
    public final void onAnimationResume(Animator animator0) {
        this.e.setTranslationX(0.0f);
        this.e.setTranslationY(0.0f);
        M.p(this.e, 0.0f);
        this.e.setScaleX(1.0f);
        this.e.setScaleY(1.0f);
        this.e.setRotationX(0.0f);
        this.e.setRotationY(0.0f);
        this.e.setRotation(0.0f);
    }
}

