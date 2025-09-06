package com.google.android.material.appbar;

import E9.h;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View.MeasureSpec;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.c;
import c2.B0;
import com.google.android.material.search.SearchBar.ScrollingViewBehavior;
import java.util.ArrayList;

abstract class HeaderScrollingViewBehavior extends ViewOffsetBehavior {
    public final Rect c;
    public final Rect d;
    public int e;
    public int f;

    public HeaderScrollingViewBehavior() {
        this.c = new Rect();
        this.d = new Rect();
        this.e = 0;
    }

    public HeaderScrollingViewBehavior(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.c = new Rect();
        this.d = new Rect();
        this.e = 0;
    }

    public abstract AppBarLayout A(ArrayList arg1);

    public float B(View view0) {
        return 1.0f;
    }

    public int C(View view0) {
        return view0.getMeasuredHeight();
    }

    @Override  // androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior
    public boolean m(CoordinatorLayout coordinatorLayout0, View view0, int v, int v1, int v2) {
        int v3 = view0.getLayoutParams().height;
        if(v3 == -2 || v3 == -1) {
            AppBarLayout appBarLayout0 = this.A(coordinatorLayout0.i(view0));
            if(appBarLayout0 != null) {
                int v4 = View.MeasureSpec.getSize(v2);
                if(v4 <= 0) {
                    v4 = coordinatorLayout0.getHeight();
                }
                else if(appBarLayout0.getFitsSystemWindows()) {
                    B0 b00 = coordinatorLayout0.getLastWindowInsets();
                    if(b00 != null) {
                        int v5 = b00.d();
                        v4 += b00.a() + v5;
                    }
                }
                int v6 = v4 + this.C(appBarLayout0);
                int v7 = appBarLayout0.getMeasuredHeight();
                if(this instanceof ScrollingViewBehavior) {
                    view0.setTranslationY(((float)(-v7)));
                }
                else {
                    view0.setTranslationY(0.0f);
                    v6 -= v7;
                }
                coordinatorLayout0.q(view0, v, v1, View.MeasureSpec.makeMeasureSpec(v6, (v3 == -1 ? 0x40000000 : 0x80000000)));
                return true;
            }
        }
        return false;
    }

    @Override  // com.google.android.material.appbar.ViewOffsetBehavior
    public final void y(CoordinatorLayout coordinatorLayout0, View view0, int v) {
        AppBarLayout appBarLayout0 = this.A(coordinatorLayout0.i(view0));
        int v1 = 0;
        if(appBarLayout0 != null) {
            c c0 = (c)view0.getLayoutParams();
            int v2 = coordinatorLayout0.getPaddingLeft() + c0.leftMargin;
            int v3 = appBarLayout0.getBottom() + c0.topMargin;
            int v4 = coordinatorLayout0.getWidth() - coordinatorLayout0.getPaddingRight() - c0.rightMargin;
            int v5 = coordinatorLayout0.getHeight();
            int v6 = appBarLayout0.getBottom();
            int v7 = coordinatorLayout0.getPaddingBottom();
            Rect rect0 = this.c;
            rect0.set(v2, v3, v4, v6 + v5 - v7 - c0.bottomMargin);
            B0 b00 = coordinatorLayout0.getLastWindowInsets();
            if(b00 != null && coordinatorLayout0.getFitsSystemWindows() && !view0.getFitsSystemWindows()) {
                int v8 = rect0.left;
                rect0.left = b00.b() + v8;
                rect0.right -= b00.c();
            }
            int v9 = view0.getMeasuredWidth();
            int v10 = view0.getMeasuredHeight();
            Rect rect1 = this.d;
            Gravity.apply((c0.c == 0 ? 0x800033 : c0.c), v9, v10, rect0, rect1, v);
            if(this.f != 0) {
                v1 = h.r(((int)(this.B(appBarLayout0) * ((float)this.f))), 0, this.f);
            }
            view0.layout(rect1.left, rect1.top - v1, rect1.right, rect1.bottom - v1);
            this.e = rect1.top - appBarLayout0.getBottom();
            return;
        }
        coordinatorLayout0.p(view0, v);
        this.e = 0;
    }
}

