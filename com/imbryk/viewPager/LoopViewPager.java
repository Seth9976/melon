package com.imbryk.viewPager;

import D9.a;
import D9.b;
import android.content.Context;
import android.support.v4.view.NonSwipeableViewPager;
import android.util.AttributeSet;
import androidx.viewpager.widget.j;

public class LoopViewPager extends NonSwipeableViewPager {
    public j a;
    public a b;
    public static final int c;

    static {
    }

    public LoopViewPager(Context context0) {
        super(context0);
        super.setOnPageChangeListener(new b(this));
    }

    public LoopViewPager(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        super.setOnPageChangeListener(new b(this));
    }

    @Override  // androidx.viewpager.widget.ViewPager
    public androidx.viewpager.widget.a getAdapter() {
        return this.b == null ? null : this.b.a;
    }

    public int getCount() {
        return this.b == null ? 0 : this.b.getCount();
    }

    @Override  // androidx.viewpager.widget.ViewPager
    public int getCurrentItem() {
        return this.b == null ? 0 : this.b.a(super.getCurrentItem());
    }

    public static int m(LoopViewPager loopViewPager0) {
        return loopViewPager0.super.getCurrentItem();
    }

    @Override  // androidx.viewpager.widget.ViewPager
    public void setAdapter(androidx.viewpager.widget.a a0) {
        if(a0 == null) {
            super.setAdapter(null);
            return;
        }
        a a1 = new a();  // 初始化器: Landroidx/viewpager/widget/a;-><init>()V
        a1.a = a0;
        this.b = a1;
        super.setAdapter(a1);
        this.setCurrentItem(0, false);
    }

    @Override  // androidx.viewpager.widget.ViewPager
    public void setCurrentItem(int v) {
        if(this.getCurrentItem() != v) {
            this.setCurrentItem(v, false);
        }
    }

    @Override  // androidx.viewpager.widget.ViewPager
    public final void setCurrentItem(int v, boolean z) {
        a a0 = this.b;
        if(a0 == null) {
            return;
        }
        a0.getClass();
        super.setCurrentItem(v + 1, z);
    }

    @Override  // androidx.viewpager.widget.ViewPager
    public void setOnPageChangeListener(j j0) {
        this.a = j0;
    }
}

