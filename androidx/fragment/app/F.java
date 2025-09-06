package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.o;
import kotlin.jvm.internal.q;

public final class f extends AnimatorListenerAdapter {
    public final ViewGroup a;
    public final View b;
    public final boolean c;
    public final L0 d;
    public final g e;

    public f(ViewGroup viewGroup0, View view0, boolean z, L0 l00, g g0) {
        this.a = viewGroup0;
        this.b = view0;
        this.c = z;
        this.d = l00;
        this.e = g0;
        super();
    }

    @Override  // android.animation.AnimatorListenerAdapter
    public final void onAnimationEnd(Animator animator0) {
        q.g(animator0, "anim");
        ViewGroup viewGroup0 = this.a;
        View view0 = this.b;
        viewGroup0.endViewTransition(view0);
        L0 l00 = this.d;
        if(this.c) {
            int v = l00.a;
            q.f(view0, "viewToAnimate");
            o.a(v, view0, viewGroup0);
        }
        this.e.c.a.c(this.e);
        if(l0.P(2)) {
            Log.v("FragmentManager", "Animator from operation " + l00 + " has ended.");
        }
    }
}

