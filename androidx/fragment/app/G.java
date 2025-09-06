package androidx.fragment.app;

import android.animation.AnimatorSet;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import b.a;
import kotlin.jvm.internal.q;

public final class g extends K0 {
    public final e c;
    public AnimatorSet d;

    public g(e e0) {
        this.c = e0;
    }

    @Override  // androidx.fragment.app.K0
    public final void b(ViewGroup viewGroup0) {
        q.g(viewGroup0, "container");
        AnimatorSet animatorSet0 = this.d;
        e e0 = this.c;
        if(animatorSet0 == null) {
            e0.a.c(this);
            return;
        }
        L0 l00 = e0.a;
        if(l00.g) {
            i.a.a(animatorSet0);
        }
        else {
            animatorSet0.end();
        }
        if(l0.P(2)) {
            Log.v("FragmentManager", "Animator from operation " + l00 + " has been canceled" + (l00.g ? " with seeking." : ".") + ' ');
        }
    }

    @Override  // androidx.fragment.app.K0
    public final void c(ViewGroup viewGroup0) {
        q.g(viewGroup0, "container");
        L0 l00 = this.c.a;
        AnimatorSet animatorSet0 = this.d;
        if(animatorSet0 == null) {
            l00.c(this);
            return;
        }
        animatorSet0.start();
        if(l0.P(2)) {
            Log.v("FragmentManager", "Animator from operation " + l00 + " has started.");
        }
    }

    @Override  // androidx.fragment.app.K0
    public final void d(a a0, ViewGroup viewGroup0) {
        q.g(viewGroup0, "container");
        L0 l00 = this.c.a;
        AnimatorSet animatorSet0 = this.d;
        if(animatorSet0 == null) {
            l00.c(this);
            return;
        }
        if(Build.VERSION.SDK_INT >= 34 && l00.c.mTransitioning) {
            if(l0.P(2)) {
                Log.v("FragmentManager", "Adding BackProgressCallbacks for Animators to operation " + l00);
            }
            long v = h.a.a(animatorSet0);
            long v1 = Long.compare(((long)(a0.c * ((float)v))), 0L) == 0 ? 1L : ((long)(a0.c * ((float)v)));
            if(v1 == v) {
                v1 = v - 1L;
            }
            if(l0.P(2)) {
                Log.v("FragmentManager", "Setting currentPlayTime to " + v1 + " for Animator " + animatorSet0 + " on operation " + l00);
            }
            i.a.b(animatorSet0, v1);
        }
    }

    @Override  // androidx.fragment.app.K0
    public final void e(ViewGroup viewGroup0) {
        q.g(viewGroup0, "container");
        e e0 = this.c;
        if(!e0.a()) {
            Context context0 = viewGroup0.getContext();
            q.f(context0, "context");
            N n0 = e0.b(context0);
            this.d = n0 == null ? null : ((AnimatorSet)n0.b);
            L0 l00 = e0.a;
            boolean z = l00.a == 3;
            View view0 = l00.c.mView;
            viewGroup0.startViewTransition(view0);
            AnimatorSet animatorSet0 = this.d;
            if(animatorSet0 != null) {
                animatorSet0.addListener(new f(viewGroup0, view0, z, l00, this));
            }
            AnimatorSet animatorSet1 = this.d;
            if(animatorSet1 != null) {
                animatorSet1.setTarget(view0);
            }
        }
    }
}

