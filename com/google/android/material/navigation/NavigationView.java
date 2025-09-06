package com.google.android.material.navigation;

import E6.a;
import G6.c;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Pair;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View.MeasureSpec;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.customview.view.AbsSavedState;
import androidx.drawerlayout.widget.DrawerLayout.LayoutParams;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.media3.session.legacy.V;
import c2.B0;
import c2.W;
import com.google.android.material.internal.NavigationMenu;
import com.google.android.material.internal.NavigationMenuView;
import com.google.android.material.internal.ScrimInsetsFrameLayout;
import com.google.android.material.internal.j;
import com.google.android.material.internal.r;
import e1.n;
import java.util.ArrayList;
import u6.b;
import u6.i;
import z6.A;
import z6.B;
import z6.z;

public class NavigationView extends ScrimInsetsFrameLayout implements b {
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator CREATOR;
        public Bundle c;

        static {
            SavedState.CREATOR = new o();  // 初始化器: Ljava/lang/Object;-><init>()V
        }

        public SavedState(Parcel parcel0, ClassLoader classLoader0) {
            super(parcel0, classLoader0);
            this.c = parcel0.readBundle(classLoader0);
        }

        @Override  // androidx.customview.view.AbsSavedState
        public final void writeToParcel(Parcel parcel0, int v) {
            super.writeToParcel(parcel0, v);
            parcel0.writeBundle(this.c);
        }
    }

    public final int B;
    public final z D;
    public final i E;
    public final V G;
    public final l I;
    public static final int[] M;
    public static final int[] N;
    public final NavigationMenu h;
    public final r i;
    public final int j;
    public final int[] k;
    public SupportMenuInflater l;
    public final m m;
    public boolean n;
    public boolean o;
    public int r;
    public final boolean w;

    static {
        NavigationView.M = new int[]{0x10100A0};
        NavigationView.N = new int[]{0xFEFEFF62};
    }

    public NavigationView(Context context0) {
        this(context0, null);
    }

    public NavigationView(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0x7F040484);  // attr:navigationViewStyle
    }

    public NavigationView(Context context0, AttributeSet attributeSet0, int v) {
        super(a.a(context0, attributeSet0, v, 0x7F1403C2), attributeSet0, v);  // style:Widget.Design.NavigationView
        d5.m m1;
        r r0 = new r();
        this.i = r0;
        this.k = new int[2];
        this.n = true;
        this.o = true;
        this.r = 0;
        B b0 = Build.VERSION.SDK_INT >= 33 ? new B(this) : new A(this);
        this.D = b0;
        this.E = new i(this);
        this.G = new V(this, this);
        this.I = new l(this);
        Context context1 = this.getContext();
        NavigationMenu navigationMenu0 = new NavigationMenu(context1);
        this.h = navigationMenu0;
        d5.m m0 = com.google.android.material.internal.B.n(context1, attributeSet0, d6.a.Q, v, 0x7F1403C2, new int[0]);  // style:Widget.Design.NavigationView
        TypedArray typedArray0 = (TypedArray)m0.c;
        if(typedArray0.hasValue(1)) {
            this.setBackground(m0.k(1));
        }
        int v1 = typedArray0.getDimensionPixelSize(7, 0);
        this.r = v1;
        this.w = v1 == 0;
        this.B = this.getResources().getDimensionPixelSize(0x7F070266);  // dimen:m3_navigation_drawer_layout_corner_size
        Drawable drawable0 = this.getBackground();
        ColorStateList colorStateList0 = e2.a.F(drawable0);
        if(drawable0 == null || colorStateList0 != null) {
            z6.i i0 = new z6.i(z6.o.d(context1, attributeSet0, v, 0x7F1403C2).a());  // style:Widget.Design.NavigationView
            if(colorStateList0 != null) {
                i0.m(colorStateList0);
            }
            i0.k(context1);
            this.setBackground(i0);
        }
        if(typedArray0.hasValue(8)) {
            this.setElevation(((float)typedArray0.getDimensionPixelSize(8, 0)));
        }
        this.setFitsSystemWindows(typedArray0.getBoolean(2, false));
        this.j = typedArray0.getDimensionPixelSize(3, 0);
        ColorStateList colorStateList1 = typedArray0.hasValue(0x1F) ? m0.j(0x1F) : null;
        int v2 = typedArray0.hasValue(34) ? typedArray0.getResourceId(34, 0) : 0;
        if(v2 == 0 && colorStateList1 == null) {
            colorStateList1 = this.f(0x1010038);
        }
        ColorStateList colorStateList2 = typedArray0.hasValue(14) ? m0.j(14) : this.f(0x1010038);
        int v3 = typedArray0.hasValue(24) ? typedArray0.getResourceId(24, 0) : 0;
        boolean z = typedArray0.getBoolean(25, true);
        if(typedArray0.hasValue(13)) {
            this.setItemIconSize(typedArray0.getDimensionPixelSize(13, 0));
        }
        ColorStateList colorStateList3 = typedArray0.hasValue(26) ? m0.j(26) : null;
        if(v3 == 0 && colorStateList3 == null) {
            colorStateList3 = this.f(0x1010036);
        }
        Drawable drawable1 = m0.k(10);
        if(drawable1 != null || !typedArray0.hasValue(17) && !typedArray0.hasValue(18)) {
            m1 = m0;
        }
        else {
            drawable1 = this.g(m0, n.s(this.getContext(), m0, 19));
            ColorStateList colorStateList4 = n.s(context1, m0, 16);
            if(colorStateList4 == null) {
                m1 = m0;
            }
            else {
                InsetDrawable insetDrawable0 = this.g(m0, null);
                m1 = m0;
                r0.n = new RippleDrawable(x6.a.c(colorStateList4), null, insetDrawable0);
                r0.i(false);
            }
        }
        if(typedArray0.hasValue(11)) {
            this.setItemHorizontalPadding(typedArray0.getDimensionPixelSize(11, 0));
        }
        if(typedArray0.hasValue(27)) {
            this.setItemVerticalPadding(typedArray0.getDimensionPixelSize(27, 0));
        }
        this.setDividerInsetStart(typedArray0.getDimensionPixelSize(6, 0));
        this.setDividerInsetEnd(typedArray0.getDimensionPixelSize(5, 0));
        this.setSubheaderInsetStart(typedArray0.getDimensionPixelSize(33, 0));
        this.setSubheaderInsetEnd(typedArray0.getDimensionPixelSize(0x20, 0));
        this.setTopInsetScrimEnabled(typedArray0.getBoolean(35, this.n));
        this.setBottomInsetScrimEnabled(typedArray0.getBoolean(4, this.o));
        int v4 = typedArray0.getDimensionPixelSize(12, 0);
        this.setItemMaxLines(typedArray0.getInt(15, 1));
        navigationMenu0.e = new androidx.lifecycle.b(this, 23);
        r0.d = 1;
        r0.k(context1, navigationMenu0);
        if(v2 != 0) {
            r0.g = v2;
            r0.i(false);
        }
        r0.h = colorStateList1;
        r0.i(false);
        r0.l = colorStateList2;
        r0.i(false);
        int v5 = this.getOverScrollMode();
        r0.W = v5;
        NavigationMenuView navigationMenuView0 = r0.a;
        if(navigationMenuView0 != null) {
            navigationMenuView0.setOverScrollMode(v5);
        }
        if(v3 != 0) {
            r0.i = v3;
            r0.i(false);
        }
        r0.j = z;
        r0.i(false);
        r0.k = colorStateList3;
        r0.i(false);
        r0.m = drawable1;
        r0.i(false);
        r0.w = v4;
        r0.i(false);
        navigationMenu0.b(r0, navigationMenu0.a);
        if(r0.a == null) {
            NavigationMenuView navigationMenuView1 = (NavigationMenuView)r0.f.inflate(0x7F0D01F3, this, false);  // layout:design_navigation_menu
            r0.a = navigationMenuView1;
            navigationMenuView1.setAccessibilityDelegateCompat(new com.google.android.material.internal.o(r0, r0.a));
            if(r0.e == null) {
                j j0 = new j(r0);
                r0.e = j0;
                j0.setHasStableIds(true);
            }
            int v6 = r0.W;
            if(v6 != -1) {
                r0.a.setOverScrollMode(v6);
            }
            LinearLayout linearLayout0 = (LinearLayout)r0.f.inflate(0x7F0D01F0, r0.a, false);  // layout:design_navigation_item_header
            r0.b = linearLayout0;
            linearLayout0.setImportantForAccessibility(2);
            r0.a.setAdapter(r0.e);
        }
        this.addView(r0.a);
        if(typedArray0.hasValue(28)) {
            int v7 = typedArray0.getResourceId(28, 0);
            j j1 = r0.e;
            if(j1 != null) {
                j1.c = true;
            }
            this.getMenuInflater().inflate(v7, navigationMenu0);
            j j2 = r0.e;
            if(j2 != null) {
                j2.c = false;
            }
            r0.i(false);
        }
        if(typedArray0.hasValue(9)) {
            int v8 = typedArray0.getResourceId(9, 0);
            View view0 = r0.f.inflate(v8, r0.b, false);
            r0.b.addView(view0);
            r0.a.setPadding(0, 0, 0, r0.a.getPaddingBottom());
        }
        m1.t();
        this.m = new m(this, 0);
        this.getViewTreeObserver().addOnGlobalLayoutListener(this.m);
    }

    @Override  // u6.b
    public final void a(b.a a0) {
        this.i();
        this.E.f = a0;
    }

    @Override  // u6.b
    public final void b() {
        this.i();
        this.E.b();
        if(this.w && this.r != 0) {
            this.r = 0;
            this.h(this.getWidth(), this.getHeight());
        }
    }

    @Override  // u6.b
    public final void c(b.a a0) {
        float f = a0.c;
        int v = ((LayoutParams)this.i().second).a;
        i i0 = this.E;
        if(i0.f == null) {
            Log.w("MaterialBackHelper", "Must call startBackProgress() before updateBackProgress()");
        }
        b.a a1 = i0.f;
        i0.f = a0;
        if(a1 != null) {
            i0.d(v, a0.d == 0, f);
        }
        if(this.w) {
            float f1 = i0.a.getInterpolation(f);
            this.r = e6.a.c(0, this.B, f1);
            this.h(this.getWidth(), this.getHeight());
        }
    }

    @Override  // u6.b
    public final void d() {
        Pair pair0 = this.i();
        DrawerLayout drawerLayout0 = (DrawerLayout)pair0.first;
        i i0 = this.E;
        b.a a0 = i0.f;
        i0.f = null;
        if(a0 != null && Build.VERSION.SDK_INT >= 34) {
            i0.c(a0, ((LayoutParams)pair0.second).a, new c(4, drawerLayout0, this), new com.google.android.exoplayer2.ui.a(drawerLayout0, 1));
            return;
        }
        drawerLayout0.b(this, true);
    }

    @Override  // android.view.ViewGroup
    public final void dispatchDraw(Canvas canvas0) {
        Path path0 = this.D.e;
        if(this.D.b() && !path0.isEmpty()) {
            canvas0.save();
            canvas0.clipPath(path0);
            super.dispatchDraw(canvas0);
            canvas0.restore();
            return;
        }
        super.dispatchDraw(canvas0);
    }

    @Override  // com.google.android.material.internal.ScrimInsetsFrameLayout
    public final void e(B0 b00) {
        r r0 = this.i;
        r0.getClass();
        int v = b00.d();
        if(r0.T != v) {
            r0.T = v;
            int v1 = r0.b.getChildCount() > 0 || !r0.N ? 0 : r0.T;
            r0.a.setPadding(0, v1, 0, r0.a.getPaddingBottom());
        }
        r0.a.setPadding(0, r0.a.getPaddingTop(), 0, b00.a());
        W.b(r0.b, b00);
    }

    public final ColorStateList f(int v) {
        TypedValue typedValue0 = new TypedValue();
        if(this.getContext().getTheme().resolveAttribute(v, typedValue0, true)) {
            ColorStateList colorStateList0 = P1.c.getColorStateList(this.getContext(), typedValue0.resourceId);
            if(this.getContext().getTheme().resolveAttribute(0x7F040182, typedValue0, true)) {  // attr:colorPrimary
                int v1 = typedValue0.data;
                int v2 = colorStateList0.getDefaultColor();
                return new ColorStateList(new int[][]{NavigationView.N, NavigationView.M, FrameLayout.EMPTY_STATE_SET}, new int[]{colorStateList0.getColorForState(NavigationView.N, v2), v1, v2});
            }
        }
        return null;
    }

    public final InsetDrawable g(d5.m m0, ColorStateList colorStateList0) {
        TypedArray typedArray0 = (TypedArray)m0.c;
        int v = typedArray0.getResourceId(17, 0);
        int v1 = typedArray0.getResourceId(18, 0);
        z6.i i0 = new z6.i(z6.o.a(this.getContext(), v, v1).a());
        i0.m(colorStateList0);
        return new InsetDrawable(i0, typedArray0.getDimensionPixelSize(22, 0), typedArray0.getDimensionPixelSize(23, 0), typedArray0.getDimensionPixelSize(21, 0), typedArray0.getDimensionPixelSize(20, 0));
    }

    public i getBackHelper() {
        return this.E;
    }

    public MenuItem getCheckedItem() {
        return this.i.e.b;
    }

    public int getDividerInsetEnd() {
        return this.i.E;
    }

    public int getDividerInsetStart() {
        return this.i.D;
    }

    public int getHeaderCount() {
        return this.i.b.getChildCount();
    }

    public Drawable getItemBackground() {
        return this.i.m;
    }

    public int getItemHorizontalPadding() {
        return this.i.o;
    }

    public int getItemIconPadding() {
        return this.i.w;
    }

    public ColorStateList getItemIconTintList() {
        return this.i.l;
    }

    public int getItemMaxLines() {
        return this.i.S;
    }

    public ColorStateList getItemTextColor() {
        return this.i.k;
    }

    public int getItemVerticalPadding() {
        return this.i.r;
    }

    public Menu getMenu() {
        return this.h;
    }

    private MenuInflater getMenuInflater() {
        if(this.l == null) {
            this.l = new SupportMenuInflater(this.getContext());
        }
        return this.l;
    }

    public int getSubheaderInsetEnd() {
        return this.i.I;
    }

    public int getSubheaderInsetStart() {
        return this.i.G;
    }

    public final void h(int v, int v1) {
        if(this.getParent() instanceof DrawerLayout && this.getLayoutParams() instanceof LayoutParams && (this.r > 0 || this.w) && this.getBackground() instanceof z6.i) {
            boolean z = Gravity.getAbsoluteGravity(((LayoutParams)this.getLayoutParams()).a, this.getLayoutDirection()) == 3;
            z6.i i0 = (z6.i)this.getBackground();
            z6.m m0 = i0.a.a.g();
            m0.c(((float)this.r));
            if(z) {
                m0.e = new z6.a(0.0f);
                m0.h = new z6.a(0.0f);
            }
            else {
                m0.f = new z6.a(0.0f);
                m0.g = new z6.a(0.0f);
            }
            z6.o o0 = m0.a();
            i0.setShapeAppearanceModel(o0);
            this.D.c = o0;
            this.D.c();
            this.D.a(this);
            this.D.d = new RectF(0.0f, 0.0f, ((float)v), ((float)v1));
            this.D.c();
            this.D.a(this);
            this.D.b = true;
            this.D.a(this);
        }
    }

    public final Pair i() {
        ViewParent viewParent0 = this.getParent();
        ViewGroup.LayoutParams viewGroup$LayoutParams0 = this.getLayoutParams();
        if(!(viewParent0 instanceof DrawerLayout) || !(viewGroup$LayoutParams0 instanceof LayoutParams)) {
            throw new IllegalStateException("NavigationView back progress requires the direct parent view to be a DrawerLayout.");
        }
        return new Pair(((DrawerLayout)viewParent0), ((LayoutParams)viewGroup$LayoutParams0));
    }

    @Override  // com.google.android.material.internal.ScrimInsetsFrameLayout
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        d5.n.B(this);
        ViewParent viewParent0 = this.getParent();
        if(viewParent0 instanceof DrawerLayout) {
            V v0 = this.G;
            if(((u6.c)v0.a) != null) {
                l l0 = this.I;
                if(l0 == null) {
                    ((DrawerLayout)viewParent0).getClass();
                }
                else {
                    ArrayList arrayList0 = ((DrawerLayout)viewParent0).E;
                    if(arrayList0 != null) {
                        arrayList0.remove(l0);
                    }
                }
                if(l0 != null) {
                    if(((DrawerLayout)viewParent0).E == null) {
                        ((DrawerLayout)viewParent0).E = new ArrayList();
                    }
                    ((DrawerLayout)viewParent0).E.add(l0);
                }
                if(DrawerLayout.j(this)) {
                    v0.z(true);
                }
            }
        }
    }

    @Override  // com.google.android.material.internal.ScrimInsetsFrameLayout
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.getViewTreeObserver().removeOnGlobalLayoutListener(this.m);
        ViewParent viewParent0 = this.getParent();
        if(viewParent0 instanceof DrawerLayout) {
            l l0 = this.I;
            if(l0 == null) {
                ((DrawerLayout)viewParent0).getClass();
                return;
            }
            ArrayList arrayList0 = ((DrawerLayout)viewParent0).E;
            if(arrayList0 != null) {
                arrayList0.remove(l0);
            }
        }
    }

    @Override  // android.widget.FrameLayout
    public final void onMeasure(int v, int v1) {
        int v2 = View.MeasureSpec.getMode(v);
        int v3 = this.j;
        switch(v2) {
            case 0x80000000: {
                v = View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(v), v3), 0x40000000);
                break;
            }
            case 0: {
                v = View.MeasureSpec.makeMeasureSpec(v3, 0x40000000);
            }
        }
        super.onMeasure(v, v1);
    }

    @Override  // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable0) {
        if(!(parcelable0 instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable0);
            return;
        }
        super.onRestoreInstanceState(((SavedState)parcelable0).a);
        this.h.t(((SavedState)parcelable0).c);
    }

    @Override  // android.view.View
    public final Parcelable onSaveInstanceState() {
        Parcelable parcelable0 = new SavedState(super.onSaveInstanceState());  // 初始化器: Landroidx/customview/view/AbsSavedState;-><init>(Landroid/os/Parcelable;)V
        Bundle bundle0 = new Bundle();
        parcelable0.c = bundle0;
        this.h.v(bundle0);
        return parcelable0;
    }

    @Override  // android.view.View
    public final void onSizeChanged(int v, int v1, int v2, int v3) {
        super.onSizeChanged(v, v1, v2, v3);
        this.h(v, v1);
    }

    public void setBottomInsetScrimEnabled(boolean z) {
        this.o = z;
    }

    public void setCheckedItem(int v) {
        MenuItem menuItem0 = this.h.findItem(v);
        if(menuItem0 != null) {
            this.i.e.b(((k.m)menuItem0));
        }
    }

    public void setCheckedItem(MenuItem menuItem0) {
        int v = menuItem0.getItemId();
        MenuItem menuItem1 = this.h.findItem(v);
        if(menuItem1 == null) {
            throw new IllegalArgumentException("Called setCheckedItem(MenuItem) with an item that is not in the current menu.");
        }
        this.i.e.b(((k.m)menuItem1));
    }

    public void setDividerInsetEnd(int v) {
        this.i.E = v;
        this.i.i(false);
    }

    public void setDividerInsetStart(int v) {
        this.i.D = v;
        this.i.i(false);
    }

    @Override  // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        d5.n.z(this, f);
    }

    public void setForceCompatClippingEnabled(boolean z) {
        z z1 = this.D;
        if(z != z1.a) {
            z1.a = z;
            z1.a(this);
        }
    }

    public void setItemBackground(Drawable drawable0) {
        this.i.m = drawable0;
        this.i.i(false);
    }

    public void setItemBackgroundResource(int v) {
        this.setItemBackground(P1.c.getDrawable(this.getContext(), v));
    }

    public void setItemHorizontalPadding(int v) {
        this.i.o = v;
        this.i.i(false);
    }

    public void setItemHorizontalPaddingResource(int v) {
        this.i.o = this.getResources().getDimensionPixelSize(v);
        this.i.i(false);
    }

    public void setItemIconPadding(int v) {
        this.i.w = v;
        this.i.i(false);
    }

    public void setItemIconPaddingResource(int v) {
        this.i.w = this.getResources().getDimensionPixelSize(v);
        this.i.i(false);
    }

    public void setItemIconSize(int v) {
        r r0 = this.i;
        if(r0.B != v) {
            r0.B = v;
            r0.M = true;
            r0.i(false);
        }
    }

    public void setItemIconTintList(ColorStateList colorStateList0) {
        this.i.l = colorStateList0;
        this.i.i(false);
    }

    public void setItemMaxLines(int v) {
        this.i.S = v;
        this.i.i(false);
    }

    public void setItemTextAppearance(int v) {
        this.i.i = v;
        this.i.i(false);
    }

    public void setItemTextAppearanceActiveBoldEnabled(boolean z) {
        this.i.j = z;
        this.i.i(false);
    }

    public void setItemTextColor(ColorStateList colorStateList0) {
        this.i.k = colorStateList0;
        this.i.i(false);
    }

    public void setItemVerticalPadding(int v) {
        this.i.r = v;
        this.i.i(false);
    }

    public void setItemVerticalPaddingResource(int v) {
        this.i.r = this.getResources().getDimensionPixelSize(v);
        this.i.i(false);
    }

    public void setNavigationItemSelectedListener(com.google.android.material.navigation.n n0) {
    }

    @Override  // android.view.View
    public void setOverScrollMode(int v) {
        super.setOverScrollMode(v);
        r r0 = this.i;
        if(r0 != null) {
            r0.W = v;
            NavigationMenuView navigationMenuView0 = r0.a;
            if(navigationMenuView0 != null) {
                navigationMenuView0.setOverScrollMode(v);
            }
        }
    }

    public void setSubheaderInsetEnd(int v) {
        this.i.I = v;
        this.i.i(false);
    }

    public void setSubheaderInsetStart(int v) {
        this.i.G = v;
        this.i.i(false);
    }

    public void setTopInsetScrimEnabled(boolean z) {
        this.n = z;
    }
}

