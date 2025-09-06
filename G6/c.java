package G6;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.collection.f;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.transition.Transition;
import c2.d0;
import c2.g0;
import c2.l0;
import com.google.android.material.navigation.NavigationView;
import m6.e;

public final class c extends AnimatorListenerAdapter {
    public final int a;
    public final Object b;
    public final Object c;

    public c(int v, Object object0, Object object1) {
        this.a = v;
        this.b = object0;
        this.c = object1;
        super();
    }

    public c(Transition transition0, f f0) {
        this.a = 1;
        this.c = transition0;
        this.b = f0;
        super();
    }

    @Override  // android.animation.AnimatorListenerAdapter
    public void onAnimationCancel(Animator animator0) {
        if(this.a != 2) {
            super.onAnimationCancel(animator0);
            return;
        }
        ((d0)this.b).a();
    }

    @Override  // android.animation.AnimatorListenerAdapter
    public final void onAnimationEnd(Animator animator0) {
        switch(this.a) {
            case 0: {
                ((e)this.b).setCircularRevealOverlayDrawable(null);
                return;
            }
            case 1: {
                ((f)this.b).remove(animator0);
                ((Transition)this.c).n.remove(animator0);
                return;
            }
            case 2: {
                ((d0)this.b).onAnimationEnd();
                return;
            }
            case 3: {
                ((l0)this.b).a.e(1.0f);
                g0.f(((View)this.c), ((l0)this.b));
                return;
            }
            default: {
                ((DrawerLayout)this.b).b(((NavigationView)this.c), false);
                ((DrawerLayout)this.b).setScrimColor(0x99000000);
            }
        }
    }

    @Override  // android.animation.AnimatorListenerAdapter
    public void onAnimationStart(Animator animator0) {
        switch(this.a) {
            case 0: {
                ((e)this.b).setCircularRevealOverlayDrawable(((Drawable)this.c));
                return;
            }
            case 1: {
                ((Transition)this.c).n.add(animator0);
                return;
            }
            case 2: {
                ((d0)this.b).onAnimationStart();
                return;
            }
            default: {
                super.onAnimationStart(animator0);
            }
        }
    }
}

