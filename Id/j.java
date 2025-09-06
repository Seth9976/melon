package id;

import J8.A2;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Animation;
import kotlin.jvm.internal.q;

public final class j implements Animation.AnimationListener {
    public final k a;
    public final A2 b;

    public j(k k0, A2 a20) {
        this.a = k0;
        this.b = a20;
    }

    @Override  // android.view.animation.Animation$AnimationListener
    public final void onAnimationEnd(Animation animation0) {
        q.g(animation0, "animation");
        this.b.d.startAnimation(this.a.k);
    }

    @Override  // android.view.animation.Animation$AnimationListener
    public final void onAnimationRepeat(Animation animation0) {
        q.g(animation0, "animation");
    }

    @Override  // android.view.animation.Animation$AnimationListener
    public final void onAnimationStart(Animation animation0) {
        q.g(animation0, "animation");
        this.a.n = true;
    }
}

