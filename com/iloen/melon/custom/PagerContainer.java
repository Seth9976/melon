package com.iloen.melon.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.FrameLayout.LayoutParams;
import android.widget.FrameLayout;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.a;
import androidx.viewpager.widget.j;
import java.lang.ref.WeakReference;
import k8.t1;

public class PagerContainer extends FrameLayout implements j {
    public E0 a;
    public boolean b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public boolean i;
    public boolean j;
    public final Point k;
    public final Point l;
    public static final int m;

    public PagerContainer(Context context0) {
        super(context0);
        this.b = false;
        this.c = -1;
        this.d = -1;
        this.k = new Point();
        this.l = new Point();
        this.b(context0);
    }

    public PagerContainer(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.b = false;
        this.c = -1;
        this.d = -1;
        this.k = new Point();
        this.l = new Point();
        this.a(attributeSet0);
        this.b(context0);
    }

    public PagerContainer(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        this.b = false;
        this.c = -1;
        this.d = -1;
        this.k = new Point();
        this.l = new Point();
        this.a(attributeSet0);
        this.b(context0);
    }

    public final void a(AttributeSet attributeSet0) {
        TypedArray typedArray0 = this.getContext().obtainStyledAttributes(attributeSet0, t1.O);
        if(typedArray0 != null) {
            int v = typedArray0.getIndexCount();
            for(int v1 = 0; v1 < v; ++v1) {
                switch(typedArray0.getIndex(v1)) {
                    case 0: {
                        boolean z = typedArray0.getBoolean(0, false);
                        this.i = z;
                        this.j = z;
                        break;
                    }
                    case 1: {
                        this.i = typedArray0.getBoolean(1, false);
                        break;
                    }
                    case 2: {
                        this.j = typedArray0.getBoolean(2, false);
                        break;
                    }
                    case 3: {
                        this.d = typedArray0.getDimensionPixelSize(3, 0);
                        break;
                    }
                    case 4: {
                        this.e = typedArray0.getDimensionPixelSize(4, 0);
                        break;
                    }
                    case 6: {
                        this.g = typedArray0.getDimensionPixelSize(6, 0);
                        break;
                    }
                    case 7: {
                        this.f = typedArray0.getDimensionPixelSize(7, 0);
                        break;
                    }
                    case 8: {
                        this.h = typedArray0.getDimensionPixelSize(8, 0);
                        break;
                    }
                    case 9: {
                        this.c = typedArray0.getDimensionPixelSize(9, 0);
                    }
                }
            }
            typedArray0.recycle();
        }
    }

    public final void b(Context context0) {
        this.setClipChildren(false);
        E0 e00 = new E0(context0);  // 初始化器: Landroidx/viewpager/widget/ViewPager;-><init>(Landroid/content/Context;)V
        e00.a = new WeakReference(this);
        e00.e = ViewConfiguration.get(e00.getContext()).getScaledPagingTouchSlop() / 2;
        this.a = e00;
        e00.setOnPageChangeListener(this);
        int v = this.e;
        if(v > 0) {
            this.a.setPageMargin(v);
        }
        FrameLayout.LayoutParams frameLayout$LayoutParams0 = new FrameLayout.LayoutParams(this.c, this.d);
        int v1 = this.g;
        if(v1 > 0 || this.h > 0) {
            frameLayout$LayoutParams0.leftMargin = v1;
            frameLayout$LayoutParams0.rightMargin = this.h;
        }
        else {
            int v2 = this.f;
            if(v2 > 0) {
                frameLayout$LayoutParams0.leftMargin = v2;
                frameLayout$LayoutParams0.rightMargin = v2;
            }
        }
        frameLayout$LayoutParams0.gravity = 1;
        this.addView(this.a, frameLayout$LayoutParams0);
    }

    public a getAdapter() {
        return this.a == null ? null : this.a.getAdapter();
    }

    public ViewPager getViewPager() {
        return this.a;
    }

    @Override  // androidx.viewpager.widget.j
    public final void onPageScrollStateChanged(int v) {
        this.b = v != 0;
    }

    @Override  // androidx.viewpager.widget.j
    public final void onPageScrolled(int v, float f, int v1) {
        if(this.b) {
            this.invalidate();
        }
    }

    @Override  // androidx.viewpager.widget.j
    public final void onPageSelected(int v) {
    }

    @Override  // android.view.View
    public final void onSizeChanged(int v, int v1, int v2, int v3) {
        this.k.x = v / 2;
        this.k.y = v1 / 2;
    }

    @Override  // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent0) {
        int v = motionEvent0.getAction();
        Point point0 = this.l;
        if(v == 0) {
            point0.x = (int)motionEvent0.getX();
            point0.y = (int)motionEvent0.getY();
        }
        motionEvent0.offsetLocation(((float)(this.k.x - point0.x)), ((float)(this.k.y - point0.y)));
        return this.a.dispatchTouchEvent(motionEvent0);
    }

    public void setAdapter(a a0) {
        E0 e00 = this.a;
        if(e00 != null) {
            e00.setAdapter(a0);
        }
    }

    public void setCurrentItem(int v) {
        E0 e00 = this.a;
        if(e00 != null) {
            e00.setCurrentItem(v);
        }
    }

    public void setEnableScroll(boolean z) {
        this.i = z;
        this.j = z;
    }

    public void setEnableScrollLeft(boolean z) {
        this.i = z;
    }

    public void setEnableScrollRight(boolean z) {
        this.j = z;
    }

    public void setOnPageChangeListener(F0 f00) {
    }

    public void setOnPageSelectListener(G0 g00) {
    }

    public void setPageMargin(int v) {
        this.e = v;
    }

    public void setSideMargin(int v) {
        this.f = v;
    }
}

