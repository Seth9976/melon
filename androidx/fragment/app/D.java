package androidx.fragment.app;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import kotlin.jvm.internal.q;

public final class d extends K0 {
    public final e c;

    public d(e e0) {
        this.c = e0;
    }

    @Override  // androidx.fragment.app.K0
    public final void b(ViewGroup viewGroup0) {
        q.g(viewGroup0, "container");
        L0 l00 = this.c.a;
        View view0 = l00.c.mView;
        view0.clearAnimation();
        viewGroup0.endViewTransition(view0);
        this.c.a.c(this);
        if(l0.P(2)) {
            Log.v("FragmentManager", "Animation from operation " + l00 + " has been cancelled.");
        }
    }

    @Override  // androidx.fragment.app.K0
    public final void c(ViewGroup viewGroup0) {
        q.g(viewGroup0, "container");
        e e0 = this.c;
        L0 l00 = e0.a;
        if(e0.a()) {
            l00.c(this);
            return;
        }
        Context context0 = viewGroup0.getContext();
        View view0 = l00.c.mView;
        q.f(context0, "context");
        N n0 = e0.b(context0);
        if(n0 == null) {
            throw new IllegalStateException("Required value was null.");
        }
        Animation animation0 = (Animation)n0.a;
        if(animation0 == null) {
            throw new IllegalStateException("Required value was null.");
        }
        if(l00.a != 1) {
            view0.startAnimation(animation0);
            l00.c(this);
            return;
        }
        viewGroup0.startViewTransition(view0);
        O o0 = new O(animation0, viewGroup0, view0);
        o0.setAnimationListener(new c(l00, viewGroup0, view0, this));
        view0.startAnimation(o0);
        if(l0.P(2)) {
            Log.v("FragmentManager", "Animation from operation " + l00 + " has started.");
        }
    }
}

