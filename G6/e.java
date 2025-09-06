package G6;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import androidx.appcompat.widget.ScrollingTabContainerView;
import androidx.recyclerview.widget.C;
import com.google.android.material.search.l;

public final class e extends AnimatorListenerAdapter {
    public final int a;
    public boolean b;
    public final Object c;

    public e(View view0, boolean z) {
        this.a = 0;
        this.b = z;
        this.c = view0;
        super();
    }

    public e(l l0, boolean z) {
        this.a = 3;
        this.c = l0;
        this.b = z;
        super();
    }

    public e(Object object0, int v) {
        this.a = v;
        this.c = object0;
        super();
        this.b = false;
    }

    @Override  // android.animation.AnimatorListenerAdapter
    public void onAnimationCancel(Animator animator0) {
        switch(this.a) {
            case 1: {
                this.b = true;
                return;
            }
            case 2: {
                this.b = true;
                return;
            }
            default: {
                super.onAnimationCancel(animator0);
            }
        }
    }

    @Override  // android.animation.AnimatorListenerAdapter
    public final void onAnimationEnd(Animator animator0) {
        switch(this.a) {
            case 0: {
                if(!this.b) {
                    ((View)this.c).setVisibility(4);
                }
                return;
            }
            case 1: {
                ScrollingTabContainerView scrollingTabContainerView0 = (ScrollingTabContainerView)this.c;
                if(!this.b) {
                    scrollingTabContainerView0.setVisibility(0);
                }
                return;
            }
            case 2: {
                C c0 = (C)this.c;
                if(this.b) {
                    this.b = false;
                    return;
                }
                if(((float)(((Float)c0.z.getAnimatedValue()))) == 0.0f) {
                    c0.A = 0;
                    c0.f(0);
                    return;
                }
                c0.A = 2;
                c0.s.invalidate();
                return;
            }
            default: {
                l.a(((l)this.c), (this.b ? 1.0f : 0.0f));
                ((l)this.c).c.a = null;
                ((l)this.c).c.b = 0.0f;
                ((l)this.c).c.invalidate();
            }
        }
    }

    @Override  // android.animation.AnimatorListenerAdapter
    public void onAnimationStart(Animator animator0) {
        switch(this.a) {
            case 0: {
                if(this.b) {
                    ((View)this.c).setVisibility(0);
                }
                return;
            }
            case 1: {
                ((ScrollingTabContainerView)this.c).setVisibility(0);
                this.b = false;
                return;
            }
            case 3: {
                l.a(((l)this.c), (this.b ? 0.0f : 1.0f));
                return;
            }
            default: {
                super.onAnimationStart(animator0);
            }
        }
    }
}

