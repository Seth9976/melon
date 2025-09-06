package com.iloen.melon.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.view.NonSwipeableViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.viewpager.widget.ViewPager;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import com.viewpagerindicator.CirclePageIndicator;
import k8.t1;

public class ItemsPagerContainer extends RelativeLayout {
    public final int a;
    public final CirclePageIndicator b;
    public final NonSwipeableViewPager c;
    public final View d;
    public final View e;
    public final ImageView f;
    public final ImageView g;
    public final boolean h;
    public boolean i;
    public boolean j;
    public boolean k;
    public final boolean l;
    public boolean m;
    public int n;
    public a0 o;

    public ItemsPagerContainer(Context context0) {
        this(context0, null);
    }

    public ItemsPagerContainer(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.h = false;
        this.i = false;
        this.j = false;
        this.k = false;
        this.l = false;
        this.m = false;
        if(!this.isInEditMode()) {
            TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, t1.n, 0, 0);
            if(typedArray0 != null) {
                this.h = typedArray0.getBoolean(2, false);
                this.i = typedArray0.getBoolean(4, false);
                this.j = typedArray0.getBoolean(0, false);
                this.m = typedArray0.getBoolean(3, false);
                this.k = typedArray0.getBoolean(1, false);
                this.l = typedArray0.getBoolean(5, false);
                typedArray0.recycle();
            }
            if(this.l) {
                LayoutInflater.from(this.getContext()).inflate(0x7F0D042F, this);  // layout:items_pager_container_overlap_indicator
            }
            else {
                LayoutInflater.from(this.getContext()).inflate(0x7F0D042E, this);  // layout:items_pager_container
            }
            this.a = this.getContext().getResources().getConfiguration().orientation;
            if(this.h) {
                NonSwipeableViewPager nonSwipeableViewPager0 = (NonSwipeableViewPager)this.findViewById(0x7F0A08FB);  // id:pager_loop
                this.c = nonSwipeableViewPager0;
                ViewUtils.showWhen(nonSwipeableViewPager0, true);
                ViewUtils.showWhen(this.findViewById(0x7F0A08F9), false);  // id:pager
            }
            else {
                NonSwipeableViewPager nonSwipeableViewPager1 = (NonSwipeableViewPager)this.findViewById(0x7F0A08F9);  // id:pager
                this.c = nonSwipeableViewPager1;
                ViewUtils.showWhen(nonSwipeableViewPager1, true);
                ViewUtils.showWhen(this.findViewById(0x7F0A08FB), false);  // id:pager_loop
            }
            this.b = (CirclePageIndicator)this.findViewById(0x7F0A0574);  // id:indicator
            this.d = this.findViewById(0x7F0A016E);  // id:btn_left_container
            this.e = this.findViewById(0x7F0A01A5);  // id:btn_right_container
            this.f = (ImageView)this.findViewById(0x7F0A016D);  // id:btn_left
            this.g = (ImageView)this.findViewById(0x7F0A01A4);  // id:btn_right
            NonSwipeableViewPager nonSwipeableViewPager2 = this.c;
            if(nonSwipeableViewPager2 != null) {
                nonSwipeableViewPager2.enableSwipe(true, true);
                CirclePageIndicator circlePageIndicator0 = this.b;
                if(circlePageIndicator0 != null) {
                    ViewUtils.showWhen(circlePageIndicator0, true);
                    CirclePageIndicator circlePageIndicator1 = (CirclePageIndicator)this.findViewById(0x7F0A0574);  // id:indicator
                    this.b = circlePageIndicator1;
                    circlePageIndicator1.setFillColor(ColorUtils.getColor(this.getContext(), 0x7F0604A0));  // color:white
                    int v = ColorUtils.getColor(this.getContext(), 0x7F0604BE);  // color:white_40
                    this.b.setStrokeColor(v);
                    float f = (float)ScreenUtils.dipToPixel(this.getContext(), 3.0f);
                    this.b.setRadius(f);
                }
                ViewUtils.showWhen(this.f, true);
                ViewUtils.showWhen(this.g, true);
                Z z0 = new Z(this, 0);
                ViewUtils.setOnClickListener(this.d, z0);
                Z z1 = new Z(this, 1);
                ViewUtils.setOnClickListener(this.e, z1);
            }
        }
    }

    public static void b(ItemsPagerContainer itemsPagerContainer0) {
        if(itemsPagerContainer0.m && (itemsPagerContainer0.c != null && itemsPagerContainer0.c.getAdapter() != null)) {
            itemsPagerContainer0.setCurrentItem(itemsPagerContainer0.c.getCurrentItem() + 1);
        }
        a0 a00 = itemsPagerContainer0.o;
        if(a00 != null) {
            a00.removeMessages(0);
        }
    }

    public int getItemCountPerPage() {
        return this.n;
    }

    public ViewPager getPager() {
        return this.c;
    }

    @Override  // android.view.ViewGroup
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        boolean z = this.j;
        ViewUtils.showWhen(this.f, z);
        ViewUtils.showWhen(this.g, z);
        this.c.enableSwipe(this.i, this.i);
        ViewUtils.showWhen(this.b, this.k);
        if(this.m) {
            if(this.o == null) {
                this.o = new a0(this, 0);
            }
            a0 a00 = this.o;
            if(a00 != null) {
                a00.removeMessages(0);
            }
        }
        else {
            a0 a01 = this.o;
            if(a01 != null) {
                a01.removeMessages(0);
            }
        }
    }

    @Override  // android.view.ViewGroup
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a0 a00 = this.o;
        if(a00 != null) {
            a00.removeMessages(0);
        }
    }

    public void setArrowButtons(boolean z) {
        this.j = z;
        ViewUtils.showWhen(this.f, z);
        ViewUtils.showWhen(this.g, z);
    }

    private void setButtonsClickable(int v) {
        if(!this.h) {
            boolean z = false;
            boolean z1 = true;
            this.d.setClickable(v != 0);
            ViewUtils.showWhen(this.d, v != 0);
            if(this.c != null && this.c.getAdapter() != null) {
                if(this.c.getAdapter().getCount() >= 2 && v != this.c.getAdapter().getCount() - 1) {
                    z = true;
                }
                z1 = z;
            }
            this.e.setClickable(z1);
            ViewUtils.showWhen(this.e, z1);
        }
    }

    private void setCurrentItem(int v) {
        this.c.setCurrentItem(v, true);
    }

    public void setIndicator(boolean z) {
        this.k = z;
        ViewUtils.showWhen(this.b, z);
    }

    private void setItemCountPerPage(int v) {
        if(v > 0) {
            this.n = v;
            return;
        }
        if(2 == this.a) {
            this.n = 5;
            return;
        }
        this.n = 3;
    }

    public void setSlideShow(boolean z) {
        this.m = z;
        if(z) {
            if(this.o == null) {
                this.o = new a0(this, 0);
            }
            a0 a00 = this.o;
            if(a00 != null) {
                a00.removeMessages(0);
            }
        }
        else {
            a0 a01 = this.o;
            if(a01 != null) {
                a01.removeMessages(0);
            }
        }
    }

    public void setSwipe(boolean z) {
        this.i = z;
        this.c.enableSwipe(z, z);
    }
}

