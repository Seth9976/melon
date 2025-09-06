package v6;

import O4.c;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

public final class g extends AnimatorListenerAdapter {
    public final int a;
    public final h b;

    public g(h h0, int v) {
        this.a = v;
        this.b = h0;
        super();
    }

    @Override  // android.animation.AnimatorListenerAdapter
    public void onAnimationEnd(Animator animator0) {
        if(this.a != 1) {
            super.onAnimationEnd(animator0);
            return;
        }
        super.onAnimationEnd(animator0);
        h h0 = this.b;
        h0.c();
        c c0 = h0.j;
        if(c0 != null) {
            c0.a(((o)h0.a));
        }
    }

    @Override  // android.animation.AnimatorListenerAdapter
    public void onAnimationRepeat(Animator animator0) {
        if(this.a != 0) {
            super.onAnimationRepeat(animator0);
            return;
        }
        super.onAnimationRepeat(animator0);
        this.b.g = (this.b.g + 4) % this.b.f.c.length;
    }
}

