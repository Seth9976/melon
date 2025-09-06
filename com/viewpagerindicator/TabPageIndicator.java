package com.viewpagerindicator;

import E8.a;
import M6.u;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout.LayoutParams;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.j;

public class TabPageIndicator extends HorizontalScrollView implements j {
    public u a;
    public final a b;
    public final b c;
    public ViewPager d;
    public j e;
    public int f;
    public int g;

    public TabPageIndicator(Context context0) {
        this(context0, null);
    }

    public TabPageIndicator(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.b = new a(this, 9);
        this.setHorizontalScrollBarEnabled(false);
        b b0 = new b(context0);  // 初始化器: Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
        TypedArray typedArray0 = context0.obtainStyledAttributes(null, b.f, 0x7F0406AC, 0);  // attr:vpiTabPageIndicatorStyle
        b0.setDividerDrawable(typedArray0.getDrawable(0));
        b0.e = typedArray0.getDimensionPixelSize(2, 0);
        b0.d = typedArray0.getInteger(1, 0);
        typedArray0.recycle();
        this.c = b0;
        this.addView(b0, new ViewGroup.LayoutParams(-2, -1));
    }

    public int getCurrentItem() {
        ViewPager viewPager0 = this.d;
        if(viewPager0 == null) {
            throw new IllegalStateException("ViewPager has not been bound.");
        }
        return viewPager0.getCurrentItem();
    }

    @Override  // android.view.ViewGroup
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        u u0 = this.a;
        if(u0 != null) {
            this.post(u0);
        }
    }

    @Override  // android.view.ViewGroup
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        u u0 = this.a;
        if(u0 != null) {
            this.removeCallbacks(u0);
        }
    }

    @Override  // android.widget.HorizontalScrollView
    public final void onMeasure(int v, int v1) {
        int v2 = View.MeasureSpec.getMode(v);
        this.setFillViewport(v2 == 0x40000000);
        int v3 = this.c.getChildCount();
        if(v3 <= 1 || v2 != 0x80000000 && v2 != 0x40000000) {
            this.f = -1;
        }
        else if(v3 > 2) {
            this.f = (int)(((float)View.MeasureSpec.getSize(v)) * 0.4f);
        }
        else {
            this.f = View.MeasureSpec.getSize(v) / 2;
        }
        int v4 = this.getMeasuredWidth();
        super.onMeasure(v, v1);
        if(v2 == 0x40000000 && v4 != this.getMeasuredWidth()) {
            this.setCurrentItem(this.g);
        }
    }

    @Override  // androidx.viewpager.widget.j
    public final void onPageScrollStateChanged(int v) {
        j j0 = this.e;
        if(j0 != null) {
            j0.onPageScrollStateChanged(v);
        }
    }

    @Override  // androidx.viewpager.widget.j
    public final void onPageScrolled(int v, float f, int v1) {
        j j0 = this.e;
        if(j0 != null) {
            j0.onPageScrolled(v, f, v1);
        }
    }

    @Override  // androidx.viewpager.widget.j
    public final void onPageSelected(int v) {
        this.setCurrentItem(v);
        j j0 = this.e;
        if(j0 != null) {
            j0.onPageSelected(v);
        }
    }

    public void setCurrentItem(int v) {
        ViewPager viewPager0 = this.d;
        if(viewPager0 == null) {
            throw new IllegalStateException("ViewPager has not been bound.");
        }
        this.g = v;
        viewPager0.setCurrentItem(v);
        b b0 = this.c;
        int v1 = b0.getChildCount();
        for(int v2 = 0; v2 < v1; ++v2) {
            boolean z = v2 == v;
            b0.getChildAt(v2).setSelected(z);
            if(z) {
                View view0 = b0.getChildAt(v);
                u u0 = this.a;
                if(u0 != null) {
                    this.removeCallbacks(u0);
                }
                u u1 = new u(this, view0, false, 17);
                this.a = u1;
                this.post(u1);
            }
        }
    }

    public void setOnPageChangeListener(j j0) {
        this.e = j0;
    }

    public void setOnTabReselectedListener(c c0) {
    }

    public void setViewPager(ViewPager viewPager0) {
        ViewPager viewPager1 = this.d;
        if(viewPager1 == viewPager0) {
            return;
        }
        if(viewPager1 != null) {
            viewPager1.setOnPageChangeListener(null);
        }
        if(viewPager0.getAdapter() == null) {
            throw new IllegalStateException("ViewPager does not have adapter instance.");
        }
        this.d = viewPager0;
        viewPager0.setOnPageChangeListener(this);
        b b0 = this.c;
        b0.removeAllViews();
        int v = this.d.getAdapter().getCount();
        for(int v1 = 0; v1 < v; ++v1) {
            d d0 = new d(this, this.getContext());
            d0.a = v1;
            d0.setFocusable(true);
            d0.setOnClickListener(this.b);
            d0.setText("");
            b0.addView(d0, new LinearLayout.LayoutParams(0, -1, 1.0f));
        }
        if(this.g > v) {
            this.g = v - 1;
        }
        this.setCurrentItem(this.g);
        this.requestLayout();
    }
}

