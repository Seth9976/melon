package androidx.fragment.app;

import I7.k;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Animation;
import kotlin.jvm.internal.q;

public final class c implements Animation.AnimationListener {
    public final L0 a;
    public final ViewGroup b;
    public final View c;
    public final d d;

    public c(L0 l00, ViewGroup viewGroup0, View view0, d d0) {
        this.a = l00;
        this.b = viewGroup0;
        this.c = view0;
        this.d = d0;
    }

    @Override  // android.view.animation.Animation$AnimationListener
    public final void onAnimationEnd(Animation animation0) {
        q.g(animation0, "animation");
        k k0 = new k(this.b, this.c, this.d, 8);
        this.b.post(k0);
        if(l0.P(2)) {
            Log.v("FragmentManager", "Animation from operation " + this.a + " has ended.");
        }
    }

    @Override  // android.view.animation.Animation$AnimationListener
    public final void onAnimationRepeat(Animation animation0) {
        q.g(animation0, "animation");
    }

    @Override  // android.view.animation.Animation$AnimationListener
    public final void onAnimationStart(Animation animation0) {
        q.g(animation0, "animation");
        if(l0.P(2)) {
            Log.v("FragmentManager", "Animation from operation " + this.a + " has reached onAnimationStart.");
        }
    }
}

