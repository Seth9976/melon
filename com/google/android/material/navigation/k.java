package com.google.android.material.navigation;

import E6.a;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.FrameLayout;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.lifecycle.b;
import com.google.android.material.internal.B;
import d5.m;
import e1.n;
import k.y;
import z6.o;

public abstract class k extends FrameLayout {
    public final e a;
    public final NavigationBarMenuView b;
    public final g c;
    public SupportMenuInflater d;
    public i e;

    public k(Context context0, AttributeSet attributeSet0, int v, int v1) {
        super(a.a(context0, attributeSet0, v, v1), attributeSet0, v);
        g g0 = new g();  // 初始化器: Ljava/lang/Object;-><init>()V
        g0.b = false;
        this.c = g0;
        Context context1 = this.getContext();
        m m0 = B.n(context1, attributeSet0, d6.a.O, v, v1, new int[]{12, 10});
        Class class0 = this.getClass();
        e e0 = new e(context1, this.getMaxItemCount(), class0);
        this.a = e0;
        NavigationBarMenuView navigationBarMenuView0 = this.a(context1);
        this.b = navigationBarMenuView0;
        g0.a = navigationBarMenuView0;
        g0.c = 1;
        navigationBarMenuView0.setPresenter(g0);
        e0.b(g0, e0.a);
        this.getContext();
        g0.a.d0 = e0;
        TypedArray typedArray0 = (TypedArray)m0.c;
        if(typedArray0.hasValue(6)) {
            navigationBarMenuView0.setIconTintList(m0.j(6));
        }
        else {
            navigationBarMenuView0.setIconTintList(navigationBarMenuView0.c());
        }
        this.setItemIconSize(typedArray0.getDimensionPixelSize(5, this.getResources().getDimensionPixelSize(0x7F0703A4)));  // dimen:mtrl_navigation_bar_item_default_icon_size
        if(typedArray0.hasValue(12)) {
            this.setItemTextAppearanceInactive(typedArray0.getResourceId(12, 0));
        }
        if(typedArray0.hasValue(10)) {
            this.setItemTextAppearanceActive(typedArray0.getResourceId(10, 0));
        }
        this.setItemTextAppearanceActiveBoldEnabled(typedArray0.getBoolean(11, true));
        if(typedArray0.hasValue(13)) {
            this.setItemTextColor(m0.j(13));
        }
        Drawable drawable0 = this.getBackground();
        ColorStateList colorStateList0 = e2.a.F(drawable0);
        if(drawable0 == null || colorStateList0 != null) {
            z6.i i0 = new z6.i(o.d(context1, attributeSet0, v, v1).a());
            if(colorStateList0 != null) {
                i0.m(colorStateList0);
            }
            i0.k(context1);
            this.setBackground(i0);
        }
        if(typedArray0.hasValue(8)) {
            this.setItemPaddingTop(typedArray0.getDimensionPixelSize(8, 0));
        }
        if(typedArray0.hasValue(7)) {
            this.setItemPaddingBottom(typedArray0.getDimensionPixelSize(7, 0));
        }
        if(typedArray0.hasValue(0)) {
            this.setActiveIndicatorLabelPadding(typedArray0.getDimensionPixelSize(0, 0));
        }
        if(typedArray0.hasValue(2)) {
            this.setElevation(((float)typedArray0.getDimensionPixelSize(2, 0)));
        }
        ColorStateList colorStateList1 = n.s(context1, m0, 1);
        this.getBackground().mutate().setTintList(colorStateList1);
        this.setLabelVisibilityMode(typedArray0.getInteger(14, -1));
        int v2 = typedArray0.getResourceId(4, 0);
        if(v2 == 0) {
            this.setItemRippleColor(n.s(context1, m0, 9));
        }
        else {
            navigationBarMenuView0.setItemBackgroundRes(v2);
        }
        int v3 = typedArray0.getResourceId(3, 0);
        if(v3 != 0) {
            this.setItemActiveIndicatorEnabled(true);
            TypedArray typedArray1 = context1.obtainStyledAttributes(v3, d6.a.N);
            this.setItemActiveIndicatorWidth(typedArray1.getDimensionPixelSize(1, 0));
            this.setItemActiveIndicatorHeight(typedArray1.getDimensionPixelSize(0, 0));
            this.setItemActiveIndicatorMarginHorizontal(typedArray1.getDimensionPixelOffset(3, 0));
            this.setItemActiveIndicatorColor(n.r(context1, typedArray1, 2));
            this.setItemActiveIndicatorShapeAppearance(o.a(context1, typedArray1.getResourceId(4, 0), 0).a());
            typedArray1.recycle();
        }
        if(typedArray0.hasValue(15)) {
            int v4 = typedArray0.getResourceId(15, 0);
            g0.b = true;
            this.getMenuInflater().inflate(v4, e0);
            g0.b = false;
            g0.i(true);
        }
        m0.t();
        this.addView(navigationBarMenuView0);
        e0.e = new b(this, 22);
    }

    public abstract NavigationBarMenuView a(Context arg1);

    public int getActiveIndicatorLabelPadding() {
        return this.b.getActiveIndicatorLabelPadding();
    }

    public ColorStateList getItemActiveIndicatorColor() {
        return this.b.getItemActiveIndicatorColor();
    }

    public int getItemActiveIndicatorHeight() {
        return this.b.getItemActiveIndicatorHeight();
    }

    public int getItemActiveIndicatorMarginHorizontal() {
        return this.b.getItemActiveIndicatorMarginHorizontal();
    }

    public o getItemActiveIndicatorShapeAppearance() {
        return this.b.getItemActiveIndicatorShapeAppearance();
    }

    public int getItemActiveIndicatorWidth() {
        return this.b.getItemActiveIndicatorWidth();
    }

    public Drawable getItemBackground() {
        return this.b.getItemBackground();
    }

    @Deprecated
    public int getItemBackgroundResource() {
        return this.b.getItemBackgroundRes();
    }

    public int getItemIconSize() {
        return this.b.getItemIconSize();
    }

    public ColorStateList getItemIconTintList() {
        return this.b.getIconTintList();
    }

    public int getItemPaddingBottom() {
        return this.b.getItemPaddingBottom();
    }

    public int getItemPaddingTop() {
        return this.b.getItemPaddingTop();
    }

    public ColorStateList getItemRippleColor() {
        return this.b.getItemRippleColor();
    }

    public int getItemTextAppearanceActive() {
        return this.b.getItemTextAppearanceActive();
    }

    public int getItemTextAppearanceInactive() {
        return this.b.getItemTextAppearanceInactive();
    }

    public ColorStateList getItemTextColor() {
        return this.b.getItemTextColor();
    }

    public int getLabelVisibilityMode() {
        return this.b.getLabelVisibilityMode();
    }

    public abstract int getMaxItemCount();

    public Menu getMenu() {
        return this.a;
    }

    private MenuInflater getMenuInflater() {
        if(this.d == null) {
            this.d = new SupportMenuInflater(this.getContext());
        }
        return this.d;
    }

    public y getMenuView() {
        return this.b;
    }

    public g getPresenter() {
        return this.c;
    }

    public int getSelectedItemId() {
        return this.b.getSelectedItemId();
    }

    @Override  // android.view.ViewGroup
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        d5.n.B(this);
    }

    @Override  // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable0) {
        if(!(parcelable0 instanceof NavigationBarView.SavedState)) {
            super.onRestoreInstanceState(parcelable0);
            return;
        }
        super.onRestoreInstanceState(((NavigationBarView.SavedState)parcelable0).a);
        this.a.t(((NavigationBarView.SavedState)parcelable0).c);
    }

    @Override  // android.view.View
    public final Parcelable onSaveInstanceState() {
        Parcelable parcelable0 = new NavigationBarView.SavedState(super.onSaveInstanceState());  // 初始化器: Landroidx/customview/view/AbsSavedState;-><init>(Landroid/os/Parcelable;)V
        Bundle bundle0 = new Bundle();
        parcelable0.c = bundle0;
        this.a.v(bundle0);
        return parcelable0;
    }

    public void setActiveIndicatorLabelPadding(int v) {
        this.b.setActiveIndicatorLabelPadding(v);
    }

    @Override  // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        d5.n.z(this, f);
    }

    public void setItemActiveIndicatorColor(ColorStateList colorStateList0) {
        this.b.setItemActiveIndicatorColor(colorStateList0);
    }

    public void setItemActiveIndicatorEnabled(boolean z) {
        this.b.setItemActiveIndicatorEnabled(z);
    }

    public void setItemActiveIndicatorHeight(int v) {
        this.b.setItemActiveIndicatorHeight(v);
    }

    public void setItemActiveIndicatorMarginHorizontal(int v) {
        this.b.setItemActiveIndicatorMarginHorizontal(v);
    }

    public void setItemActiveIndicatorShapeAppearance(o o0) {
        this.b.setItemActiveIndicatorShapeAppearance(o0);
    }

    public void setItemActiveIndicatorWidth(int v) {
        this.b.setItemActiveIndicatorWidth(v);
    }

    public void setItemBackground(Drawable drawable0) {
        this.b.setItemBackground(drawable0);
    }

    public void setItemBackgroundResource(int v) {
        this.b.setItemBackgroundRes(v);
    }

    public void setItemIconSize(int v) {
        this.b.setItemIconSize(v);
    }

    public void setItemIconSizeRes(int v) {
        this.setItemIconSize(this.getResources().getDimensionPixelSize(v));
    }

    public void setItemIconTintList(ColorStateList colorStateList0) {
        this.b.setIconTintList(colorStateList0);
    }

    public void setItemPaddingBottom(int v) {
        this.b.setItemPaddingBottom(v);
    }

    public void setItemPaddingTop(int v) {
        this.b.setItemPaddingTop(v);
    }

    public void setItemRippleColor(ColorStateList colorStateList0) {
        this.b.setItemRippleColor(colorStateList0);
    }

    public void setItemTextAppearanceActive(int v) {
        this.b.setItemTextAppearanceActive(v);
    }

    public void setItemTextAppearanceActiveBoldEnabled(boolean z) {
        this.b.setItemTextAppearanceActiveBoldEnabled(z);
    }

    public void setItemTextAppearanceInactive(int v) {
        this.b.setItemTextAppearanceInactive(v);
    }

    public void setItemTextColor(ColorStateList colorStateList0) {
        this.b.setItemTextColor(colorStateList0);
    }

    public void setLabelVisibilityMode(int v) {
        NavigationBarMenuView navigationBarMenuView0 = this.b;
        if(navigationBarMenuView0.getLabelVisibilityMode() != v) {
            navigationBarMenuView0.setLabelVisibilityMode(v);
            this.c.i(false);
        }
    }

    public void setOnItemReselectedListener(h h0) {
    }

    public void setOnItemSelectedListener(i i0) {
        this.e = i0;
    }

    public void setSelectedItemId(int v) {
        MenuItem menuItem0 = this.a.findItem(v);
        if(menuItem0 != null && !this.a.q(menuItem0, this.c, 0)) {
            menuItem0.setChecked(true);
        }
    }
}

