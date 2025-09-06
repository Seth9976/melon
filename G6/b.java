package G6;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import d5.e;
import e2.a;
import r6.o;

public final class b extends AnimatorListenerAdapter {
    public final int a;
    public final boolean b;
    public final Object c;
    public final Object d;

    public b(o o0, boolean z, e e0) {
        this.a = 1;
        this.d = o0;
        this.b = z;
        this.c = e0;
        super();
    }

    public b(boolean z, View view0, View view1) {
        this.a = 0;
        this.b = z;
        this.c = view0;
        this.d = view1;
        super();
    }

    @Override  // android.animation.AnimatorListenerAdapter
    public final void onAnimationEnd(Animator animator0) {
        if(this.a != 0) {
            ((o)this.d).r = 0;
            ((o)this.d).l = null;
            e e0 = (e)this.c;
            if(e0 != null) {
                ((a)e0.b).O();
            }
            return;
        }
        View view0 = (View)this.d;
        if(!this.b) {
            ((View)this.c).setVisibility(4);
            view0.setAlpha(1.0f);
            view0.setVisibility(0);
        }
    }

    @Override  // android.animation.AnimatorListenerAdapter
    public final void onAnimationStart(Animator animator0) {
        if(this.a != 0) {
            ((o)this.d).v.a(0, this.b);
            ((o)this.d).r = 2;
            ((o)this.d).l = animator0;
            return;
        }
        View view0 = (View)this.d;
        if(this.b) {
            ((View)this.c).setVisibility(0);
            view0.setAlpha(0.0f);
            view0.setVisibility(4);
        }
    }
}

