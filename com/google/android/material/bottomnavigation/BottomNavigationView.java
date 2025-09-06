package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import com.google.android.material.internal.B;
import com.google.android.material.navigation.NavigationBarMenuView;
import com.google.android.material.navigation.k;
import d5.m;
import d6.a;
import e3.h;
import h6.b;

public class BottomNavigationView extends k {
    public BottomNavigationView(Context context0) {
        this(context0, null);
    }

    public BottomNavigationView(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0x7F04009A);  // attr:bottomNavigationStyle
    }

    public BottomNavigationView(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v, 0x7F1403BE);  // style:Widget.Design.BottomNavigationView
        m m0 = B.n(this.getContext(), attributeSet0, a.f, v, 0x7F1403BE, new int[0]);  // style:Widget.Design.BottomNavigationView
        TypedArray typedArray0 = (TypedArray)m0.c;
        this.setItemHorizontalTranslationEnabled(typedArray0.getBoolean(2, true));
        if(typedArray0.hasValue(0)) {
            this.setMinimumHeight(typedArray0.getDimensionPixelSize(0, 0));
        }
        typedArray0.getBoolean(1, true);
        m0.t();
        B.f(this, new h());  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    @Override  // com.google.android.material.navigation.k
    public final NavigationBarMenuView a(Context context0) {
        return new BottomNavigationMenuView(context0);
    }

    @Override  // com.google.android.material.navigation.k
    public int getMaxItemCount() {
        return 5;
    }

    @Override  // android.widget.FrameLayout
    public final void onMeasure(int v, int v1) {
        int v2 = this.getSuggestedMinimumHeight();
        if(View.MeasureSpec.getMode(v1) != 0x40000000 && v2 > 0) {
            int v3 = this.getPaddingTop();
            int v4 = this.getPaddingBottom();
            v1 = View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(v1), v4 + v3 + v2), 0x40000000);
        }
        super.onMeasure(v, v1);
    }

    public void setItemHorizontalTranslationEnabled(boolean z) {
        BottomNavigationMenuView bottomNavigationMenuView0 = (BottomNavigationMenuView)this.getMenuView();
        if(bottomNavigationMenuView0.k0 != z) {
            bottomNavigationMenuView0.setItemHorizontalTranslationEnabled(z);
            this.getPresenter().i(false);
        }
    }

    @Deprecated
    public void setOnNavigationItemReselectedListener(h6.a a0) {
    }

    @Deprecated
    public void setOnNavigationItemSelectedListener(b b0) {
        this.setOnItemSelectedListener(b0);
    }
}

