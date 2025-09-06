package com.google.android.material.navigationrail;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View.MeasureSpec;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import androidx.lifecycle.b;
import com.google.android.material.internal.B;
import com.google.android.material.navigation.NavigationBarMenuView;
import com.google.android.material.navigation.k;
import d5.m;
import d6.a;

public class NavigationRailView extends k {
    public final int f;
    public final View g;
    public final Boolean h;
    public final Boolean i;
    public final Boolean j;

    public NavigationRailView(Context context0) {
        this(context0, null);
    }

    public NavigationRailView(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0x7F040483);  // attr:navigationRailStyle
    }

    public NavigationRailView(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v, 0x7F1404C3);  // style:Widget.MaterialComponents.NavigationRailView
        this.h = null;
        this.i = null;
        this.j = null;
        int v1 = this.getResources().getDimensionPixelSize(0x7F0703B2);  // dimen:mtrl_navigation_rail_margin
        this.f = v1;
        Context context1 = this.getContext();
        m m0 = B.n(context1, attributeSet0, a.P, v, 0x7F1404C3, new int[0]);  // style:Widget.MaterialComponents.NavigationRailView
        TypedArray typedArray0 = (TypedArray)m0.c;
        int v2 = typedArray0.getResourceId(0, 0);
        if(v2 != 0) {
            View view0 = LayoutInflater.from(this.getContext()).inflate(v2, this, false);
            View view1 = this.g;
            if(view1 != null) {
                this.removeView(view1);
                this.g = null;
            }
            this.g = view0;
            FrameLayout.LayoutParams frameLayout$LayoutParams0 = new FrameLayout.LayoutParams(-2, -2);
            frameLayout$LayoutParams0.gravity = 49;
            frameLayout$LayoutParams0.topMargin = v1;
            this.addView(view0, 0, frameLayout$LayoutParams0);
        }
        this.setMenuGravity(typedArray0.getInt(2, 49));
        if(typedArray0.hasValue(1)) {
            this.setItemMinimumHeight(typedArray0.getDimensionPixelSize(1, -1));
        }
        if(typedArray0.hasValue(5)) {
            this.h = Boolean.valueOf(typedArray0.getBoolean(5, false));
        }
        if(typedArray0.hasValue(3)) {
            this.i = Boolean.valueOf(typedArray0.getBoolean(3, false));
        }
        if(typedArray0.hasValue(4)) {
            this.j = Boolean.valueOf(typedArray0.getBoolean(4, false));
        }
        int v3 = this.getResources().getDimensionPixelOffset(0x7F07027B);  // dimen:m3_navigation_rail_item_padding_top_with_large_font
        int v4 = this.getResources().getDimensionPixelOffset(0x7F070279);  // dimen:m3_navigation_rail_item_padding_bottom_with_large_font
        float f = e6.a.b(0.0f, 1.0f, 0.3f, 1.0f, context1.getResources().getConfiguration().fontScale - 1.0f);
        int v5 = this.getItemPaddingTop();
        int v6 = this.getItemPaddingBottom();
        this.setItemPaddingTop(Math.round(e6.a.c(v5, v3, f)));
        this.setItemPaddingBottom(Math.round(e6.a.c(v6, v4, f)));
        m0.t();
        B.f(this, new b(this, 24));
    }

    @Override  // com.google.android.material.navigation.k
    public final NavigationBarMenuView a(Context context0) {
        return new NavigationRailMenuView(context0);
    }

    public View getHeaderView() {
        return this.g;
    }

    public int getItemMinimumHeight() {
        return ((NavigationRailMenuView)this.getMenuView()).getItemMinimumHeight();
    }

    @Override  // com.google.android.material.navigation.k
    public int getMaxItemCount() {
        return 7;
    }

    public int getMenuGravity() {
        return this.getNavigationRailMenuView().getMenuGravity();
    }

    private NavigationRailMenuView getNavigationRailMenuView() {
        return (NavigationRailMenuView)this.getMenuView();
    }

    @Override  // android.widget.FrameLayout
    public final void onLayout(boolean z, int v, int v1, int v2, int v3) {
        super.onLayout(z, v, v1, v2, v3);
        NavigationRailMenuView navigationRailMenuView0 = this.getNavigationRailMenuView();
        int v4 = this.f;
        if(this.g != null && this.g.getVisibility() != 8) {
            int v5 = this.g.getBottom() + v4;
            int v6 = navigationRailMenuView0.getTop();
            v4 = v6 < v5 ? v5 - v6 : 0;
        }
        else if((navigationRailMenuView0.h0.gravity & 0x70) != 0x30) {
            v4 = 0;
        }
        if(v4 > 0) {
            navigationRailMenuView0.layout(navigationRailMenuView0.getLeft(), navigationRailMenuView0.getTop() + v4, navigationRailMenuView0.getRight(), navigationRailMenuView0.getBottom() + v4);
        }
    }

    @Override  // android.widget.FrameLayout
    public final void onMeasure(int v, int v1) {
        int v2 = this.getSuggestedMinimumWidth();
        if(View.MeasureSpec.getMode(v) != 0x40000000 && v2 > 0) {
            int v3 = this.getPaddingLeft();
            int v4 = this.getPaddingRight();
            v = View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(v), v4 + v3 + v2), 0x40000000);
        }
        super.onMeasure(v, v1);
        if(this.g != null && this.g.getVisibility() != 8) {
            this.measureChild(this.getNavigationRailMenuView(), v, View.MeasureSpec.makeMeasureSpec(this.getMeasuredHeight() - this.g.getMeasuredHeight() - this.f, 0x80000000));
        }
    }

    public void setItemMinimumHeight(int v) {
        ((NavigationRailMenuView)this.getMenuView()).setItemMinimumHeight(v);
    }

    public void setMenuGravity(int v) {
        this.getNavigationRailMenuView().setMenuGravity(v);
    }
}

