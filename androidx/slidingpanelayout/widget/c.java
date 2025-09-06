package androidx.slidingpanelayout.widget;

import android.view.View;
import e.k;

public final class c extends k {
    public final SlidingPaneLayout f;

    public c(SlidingPaneLayout slidingPaneLayout0) {
        this.f = slidingPaneLayout0;
    }

    @Override  // e.k
    public final void D(int v, int v1) {
        this.f.o.c(this.f.g, v1);
    }

    @Override  // e.k
    public final void F(View view0, int v) {
        SlidingPaneLayout slidingPaneLayout0 = this.f;
        int v1 = slidingPaneLayout0.getChildCount();
        for(int v2 = 0; v2 < v1; ++v2) {
            View view1 = slidingPaneLayout0.getChildAt(v2);
            if(view1.getVisibility() == 4) {
                view1.setVisibility(0);
            }
        }
    }

    @Override  // e.k
    public final void G(int v) {
        SlidingPaneLayout slidingPaneLayout0 = this.f;
        if(slidingPaneLayout0.o.a == 0) {
            if(Float.compare(slidingPaneLayout0.h, 0.0f) == 0) {
                slidingPaneLayout0.f(slidingPaneLayout0.g);
                slidingPaneLayout0.sendAccessibilityEvent(0x20);
                slidingPaneLayout0.r = false;
                return;
            }
            slidingPaneLayout0.sendAccessibilityEvent(0x20);
            slidingPaneLayout0.r = true;
        }
    }

    @Override  // e.k
    public final void H(View view0, int v, int v1) {
        SlidingPaneLayout slidingPaneLayout0 = this.f;
        if(slidingPaneLayout0.g == null) {
            slidingPaneLayout0.h = 0.0f;
        }
        else {
            boolean z = slidingPaneLayout0.c();
            LayoutParams slidingPaneLayout$LayoutParams0 = (LayoutParams)slidingPaneLayout0.g.getLayoutParams();
            int v2 = slidingPaneLayout0.g.getWidth();
            if(z) {
                v = slidingPaneLayout0.getWidth() - v - v2;
            }
            float f = ((float)(v - ((z ? slidingPaneLayout0.getPaddingRight() : slidingPaneLayout0.getPaddingLeft()) + (z ? slidingPaneLayout$LayoutParams0.rightMargin : slidingPaneLayout$LayoutParams0.leftMargin)))) / ((float)slidingPaneLayout0.j);
            slidingPaneLayout0.h = f;
            if(slidingPaneLayout0.l != 0) {
                slidingPaneLayout0.d(f);
            }
            if(slidingPaneLayout$LayoutParams0.c) {
                slidingPaneLayout0.a(slidingPaneLayout0.g, slidingPaneLayout0.h, slidingPaneLayout0.a);
            }
        }
        slidingPaneLayout0.invalidate();
    }

    @Override  // e.k
    public final void I(View view0, float f, float f1) {
        int v2;
        LayoutParams slidingPaneLayout$LayoutParams0 = (LayoutParams)view0.getLayoutParams();
        SlidingPaneLayout slidingPaneLayout0 = this.f;
        if(slidingPaneLayout0.c()) {
            int v = slidingPaneLayout0.getPaddingRight() + slidingPaneLayout$LayoutParams0.rightMargin;
            if(f < 0.0f || f == 0.0f && slidingPaneLayout0.h > 0.5f) {
                v += slidingPaneLayout0.j;
            }
            int v1 = slidingPaneLayout0.g.getWidth();
            v2 = slidingPaneLayout0.getWidth() - v - v1;
        }
        else {
            int v3 = slidingPaneLayout0.getPaddingLeft();
            v2 = slidingPaneLayout$LayoutParams0.leftMargin + v3;
            int v4 = Float.compare(f, 0.0f);
            if(v4 > 0 || v4 == 0 && slidingPaneLayout0.h > 0.5f) {
                v2 += slidingPaneLayout0.j;
            }
        }
        int v5 = view0.getTop();
        slidingPaneLayout0.o.s(v2, v5);
        slidingPaneLayout0.invalidate();
    }

    // 去混淆评级： 低(20)
    @Override  // e.k
    public final boolean P(View view0, int v) {
        return this.f.k ? false : ((LayoutParams)view0.getLayoutParams()).b;
    }

    @Override  // e.k
    public final int j(View view0, int v) {
        SlidingPaneLayout slidingPaneLayout0 = this.f;
        LayoutParams slidingPaneLayout$LayoutParams0 = (LayoutParams)slidingPaneLayout0.g.getLayoutParams();
        if(slidingPaneLayout0.c()) {
            int v1 = slidingPaneLayout0.getWidth();
            int v2 = slidingPaneLayout0.getPaddingRight() + slidingPaneLayout$LayoutParams0.rightMargin;
            int v3 = v1 - (slidingPaneLayout0.g.getWidth() + v2);
            return Math.max(Math.min(v, v3), v3 - slidingPaneLayout0.j);
        }
        int v4 = slidingPaneLayout0.getPaddingLeft() + slidingPaneLayout$LayoutParams0.leftMargin;
        return Math.min(Math.max(v, v4), slidingPaneLayout0.j + v4);
    }

    @Override  // e.k
    public final int k(View view0, int v) {
        return view0.getTop();
    }

    @Override  // e.k
    public final int v(View view0) {
        return this.f.j;
    }
}

