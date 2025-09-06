package com.viewpagerindicator;

import M6.u;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.j;

public class IconPageIndicator extends HorizontalScrollView implements j {
    public final LinearLayout a;
    public ViewPager b;
    public j c;
    public u d;

    public IconPageIndicator(Context context0) {
        this(context0, null);
    }

    public IconPageIndicator(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.setHorizontalScrollBarEnabled(false);
        LinearLayout linearLayout0 = new LinearLayout(context0);
        this.a = linearLayout0;
        this.addView(linearLayout0, new FrameLayout.LayoutParams(-1, -1, 17));
    }

    public int getCurrentItem() {
        return 0;
    }

    @Override  // android.view.ViewGroup
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        u u0 = this.d;
        if(u0 != null) {
            this.post(u0);
        }
    }

    @Override  // android.view.ViewGroup
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        u u0 = this.d;
        if(u0 != null) {
            this.removeCallbacks(u0);
        }
    }

    @Override  // androidx.viewpager.widget.j
    public final void onPageScrollStateChanged(int v) {
        j j0 = this.c;
        if(j0 != null) {
            j0.onPageScrollStateChanged(v);
        }
    }

    @Override  // androidx.viewpager.widget.j
    public final void onPageScrolled(int v, float f, int v1) {
        j j0 = this.c;
        if(j0 != null) {
            j0.onPageScrolled(v, f, v1);
        }
    }

    @Override  // androidx.viewpager.widget.j
    public final void onPageSelected(int v) {
        this.setCurrentItem(v);
        j j0 = this.c;
        if(j0 != null) {
            j0.onPageSelected(v);
        }
    }

    public void setCurrentItem(int v) {
        ViewPager viewPager0 = this.b;
        if(viewPager0 == null) {
            throw new IllegalStateException("ViewPager has not been bound.");
        }
        viewPager0.setCurrentItem(v);
        LinearLayout linearLayout0 = this.a;
        int v1 = linearLayout0.getChildCount();
        for(int v2 = 0; v2 < v1; ++v2) {
            boolean z = v2 == v;
            linearLayout0.getChildAt(v2).setSelected(z);
            if(z) {
                View view0 = linearLayout0.getChildAt(v);
                u u0 = this.d;
                if(u0 != null) {
                    this.removeCallbacks(u0);
                }
                u u1 = new u(this, view0, false, 16);
                this.d = u1;
                this.post(u1);
            }
        }
    }

    public void setMargin(float f) {
    }

    public void setOnPageChangeListener(j j0) {
        this.c = j0;
    }

    public void setViewPager(ViewPager viewPager0) {
        ViewPager viewPager1 = this.b;
        if(viewPager1 == viewPager0) {
            return;
        }
        if(viewPager1 != null) {
            viewPager1.setOnPageChangeListener(null);
        }
        if(viewPager0.getAdapter() == null) {
            throw new IllegalStateException("ViewPager does not have adapter instance.");
        }
        this.b = viewPager0;
        viewPager0.setOnPageChangeListener(this);
        this.a.removeAllViews();
        this.b.getAdapter().getClass();
        throw new ClassCastException();
    }
}

