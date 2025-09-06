package u6;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

public final class h extends AnimatorListenerAdapter {
    public final boolean a;
    public final int b;
    public final i c;

    public h(i i0, boolean z, int v) {
        this.c = i0;
        this.a = z;
        this.b = v;
        super();
    }

    @Override  // android.animation.AnimatorListenerAdapter
    public final void onAnimationEnd(Animator animator0) {
        this.c.b.setTranslationX(0.0f);
        this.c.d(this.b, this.a, 0.0f);
    }
}

