package com.iloen.melon.custom.tablayout;

import E8.e;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.LinearLayout;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.ui.ViewUtils;
import k8.t1;

public class ScrollTabLayout extends AbsTabIndicatorLayout {
    public int i;
    public int j;
    public int k;
    public View l;
    public View m;
    public HorizontalScrollView n;
    public int o;
    public e r;

    public ScrollTabLayout(Context context0) {
        this(context0, null);
    }

    public ScrollTabLayout(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.i = 0;
        this.j = -1;
        this.k = -1;
        this.o = 0;
        int v = this.getResources().getDimensionPixelOffset(0x7F0700B2);  // dimen:default_scrolltablayout_scrolloffset
        TypedArray typedArray0 = this.getContext().obtainStyledAttributes(attributeSet0, t1.C, 0, 0);
        this.i = typedArray0.getDimensionPixelOffset(2, v);
        this.j = typedArray0.getResourceId(0, -1);
        this.k = typedArray0.getResourceId(1, -1);
        typedArray0.recycle();
    }

    @Override  // com.iloen.melon.custom.tablayout.AbsTabIndicatorLayout
    public void a(TabInfo tabInfo0, int v) {
        if(this.a == null) {
            LogU.w("ScrollTabLayout", "TabContainer is invalid!!");
            return;
        }
        TabView tabView0 = new TabView(this.getContext());
        tabView0.setTabInfo(tabInfo0);
        tabView0.setId(v);
        tabView0.setFocusable(true);
        tabView0.setOnClickListener(this.h);
        LinearLayout.LayoutParams linearLayout$LayoutParams0 = new LinearLayout.LayoutParams(-2, -1);
        this.a.addView(tabView0, linearLayout$LayoutParams0);
    }

    @Override  // com.iloen.melon.custom.tablayout.AbsTabIndicatorLayout
    public final void d() {
        View.inflate(this.getContext(), this.getLayoutResId(), this);
        this.l = this.findViewById(0x7F0A0485);  // id:fade_left
        this.m = this.findViewById(0x7F0A0486);  // id:fade_right
        int v = this.j;
        if(v > 0) {
            this.l.setBackgroundResource(v);
        }
        int v1 = this.k;
        if(v1 > 0) {
            this.m.setBackgroundResource(v1);
        }
        this.n = (HorizontalScrollView)this.findViewById(0x7F0A0A33);  // id:scrollview
        this.a = (LinearLayout)this.findViewById(0x7F0A0B12);  // id:tab_container
    }

    public final void f(int v, int v1) {
        if(this.a != null && (this.b != null && this.b.getAdapter().getCount() != 0)) {
            ViewUtils.showWhen(this.l, true);
            ViewUtils.showWhen(this.m, true);
            e e0 = this.r;
            if(e0 != null) {
                this.removeCallbacks(e0);
            }
            TabView tabView0 = (TabView)this.a.getChildAt(v);
            if(tabView0 != null) {
                e e1 = new e(this, v, tabView0, v1);
                this.r = e1;
                this.post(e1);
            }
        }
    }

    public int getLayoutResId() {
        return 0x7F0D086B;  // layout:tab_layout_scroll
    }

    public int getLeftFade() {
        return this.j;
    }

    public int getRightFade() {
        return this.k;
    }

    public int getScrollOffset() {
        return this.i;
    }

    @Override  // android.view.ViewGroup
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        e e0 = this.r;
        if(e0 != null) {
            this.post(e0);
        }
    }

    @Override  // android.view.ViewGroup
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e e0 = this.r;
        if(e0 != null) {
            this.removeCallbacks(e0);
        }
    }

    @Override  // android.view.View
    public final void onDraw(Canvas canvas0) {
        super.onDraw(canvas0);
    }

    @Override  // android.widget.FrameLayout
    public final void onMeasure(int v, int v1) {
        super.onMeasure(v, v1);
    }

    @Override  // com.iloen.melon.custom.tablayout.AbsTabIndicatorLayout
    public final void onPageScrolled(int v, float f, int v1) {
        LinearLayout linearLayout0 = this.a;
        if(linearLayout0 != null) {
            View view0 = linearLayout0.getChildAt(v);
            if(view0 != null) {
                this.f(v, ((int)(((float)view0.getWidth()) * f)));
                this.invalidate();
            }
        }
        super.onPageScrolled(v, f, v1);
    }

    @Override  // com.iloen.melon.custom.tablayout.AbsTabIndicatorLayout
    public final void onPageSelected(int v) {
        this.setCurrentItem(v);
        super.onPageSelected(v);
    }

    @Override  // com.iloen.melon.custom.tablayout.AbsTabIndicatorLayout
    public void setCurrentItem(int v) {
        super.setCurrentItem(v);
        this.f(v, 0);
    }

    public void setLeftFade(int v) {
        this.j = v;
        if(v > 0) {
            this.l.setBackgroundResource(v);
        }
    }

    public void setRightFade(int v) {
        this.k = v;
        if(v > 0) {
            this.m.setBackgroundResource(v);
        }
    }

    public void setScrollOffset(int v) {
        this.i = v;
        this.invalidate();
    }
}

