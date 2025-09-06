package com.google.android.material.tabs;

import D6.b;
import D6.c;
import D6.d;
import D6.h;
import D6.i;
import D6.j;
import D6.l;
import D6.m;
import android.animation.Animator.AnimatorListener;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo.CollectionInfo;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout.LayoutParams;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.a;
import androidx.viewpager.widget.f;
import b2.e;
import c2.M;
import com.google.android.material.internal.B;
import d5.w;
import e1.n;
import java.util.ArrayList;
import java.util.Iterator;

@f
public class TabLayout extends HorizontalScrollView {
    public final float B;
    public final float D;
    public final int E;
    public int G;
    public final int I;
    public final int M;
    public final int N;
    public final int S;
    public int T;
    public final int V;
    public int W;
    public int a;
    public final ArrayList b;
    public int b0;
    public i c;
    public boolean c0;
    public final h d;
    public boolean d0;
    public final int e;
    public int e0;
    public final int f;
    public int f0;
    public final int g;
    public boolean g0;
    public final int h;
    public z6.f h0;
    public final int i;
    public final TimeInterpolator i0;
    public final int j;
    public d j0;
    public final int k;
    public final ArrayList k0;
    public ColorStateList l;
    public m l0;
    public ColorStateList m;
    public ValueAnimator m0;
    public ColorStateList n;
    public ViewPager n0;
    public Drawable o;
    public a o0;
    public D6.f p0;
    public j q0;
    public int r;
    public c r0;
    public boolean s0;
    public int t0;
    public final e u0;
    public static final b2.f v0;
    public final PorterDuff.Mode w;

    static {
        TabLayout.v0 = new b2.f(16);
    }

    public TabLayout(Context context0) {
        this(context0, null);
    }

    public TabLayout(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0x7F0405DA);  // attr:tabStyle
    }

    public TabLayout(Context context0, AttributeSet attributeSet0, int v) {
        super(E6.a.a(context0, attributeSet0, v, 0x7F1403C5), attributeSet0, v);  // style:Widget.Design.TabLayout
        float f;
        this.a = -1;
        this.b = new ArrayList();
        this.k = -1;
        this.r = 0;
        this.G = 0x7FFFFFFF;
        this.e0 = -1;
        this.k0 = new ArrayList();
        this.u0 = new e(12, 0);
        Context context1 = this.getContext();
        this.setHorizontalScrollBarEnabled(false);
        h h0 = new h(this, context1);
        this.d = h0;
        super.addView(h0, 0, new FrameLayout.LayoutParams(-2, -1));
        TypedArray typedArray0 = B.m(context1, attributeSet0, d6.a.e0, v, 0x7F1403C5, new int[]{24});  // style:Widget.Design.TabLayout
        ColorStateList colorStateList0 = e2.a.F(this.getBackground());
        if(colorStateList0 != null) {
            z6.i i0 = new z6.i();
            i0.m(colorStateList0);
            i0.k(context1);
            i0.l(M.e(this));
            this.setBackground(i0);
        }
        this.setSelectedTabIndicator(n.u(context1, typedArray0, 5));
        this.setSelectedTabIndicatorColor(typedArray0.getColor(8, 0));
        h0.b(typedArray0.getDimensionPixelSize(11, -1));
        this.setSelectedTabIndicatorGravity(typedArray0.getInt(10, 0));
        this.setTabIndicatorAnimationMode(typedArray0.getInt(7, 0));
        this.setTabIndicatorFullWidth(typedArray0.getBoolean(9, true));
        int v1 = typedArray0.getDimensionPixelSize(16, 0);
        this.h = v1;
        this.g = v1;
        this.f = v1;
        this.e = typedArray0.getDimensionPixelSize(19, v1);
        this.f = typedArray0.getDimensionPixelSize(20, v1);
        this.g = typedArray0.getDimensionPixelSize(18, v1);
        this.h = typedArray0.getDimensionPixelSize(17, v1);
        this.i = e1.m.z(context1, 0x7F040328, false) ? 0x7F04060B : 0x7F0405EC;  // attr:isMaterial3Theme
        int v2 = typedArray0.getResourceId(24, 0x7F14024D);  // style:TextAppearance.Design.Tab
        this.j = v2;
        int[] arr_v = g.a.z;
        TypedArray typedArray1 = context1.obtainStyledAttributes(v2, arr_v);
        try {
            f = (float)typedArray1.getDimensionPixelSize(0, 0);
            this.B = f;
            this.l = n.r(context1, typedArray1, 3);
        }
        finally {
            typedArray1.recycle();
        }
        if(typedArray0.hasValue(22)) {
            this.k = typedArray0.getResourceId(22, v2);
        }
        int v4 = this.k;
        int[] arr_v1 = HorizontalScrollView.EMPTY_STATE_SET;
        int[] arr_v2 = HorizontalScrollView.SELECTED_STATE_SET;
        if(v4 != -1) {
            TypedArray typedArray2 = context1.obtainStyledAttributes(v4, arr_v);
            try {
                typedArray2.getDimensionPixelSize(0, ((int)f));
                ColorStateList colorStateList1 = n.r(context1, typedArray2, 3);
                if(colorStateList1 != null) {
                    int v6 = this.l.getDefaultColor();
                    int v7 = colorStateList1.getDefaultColor();
                    int v8 = colorStateList1.getColorForState(new int[]{0x10100A1}, v7);
                    int[][] arr2_v = new int[2][];
                    int[] arr_v3 = new int[2];
                    arr2_v[0] = arr_v2;
                    arr_v3[0] = v8;
                    arr2_v[1] = arr_v1;
                    arr_v3[1] = v6;
                    this.l = new ColorStateList(arr2_v, arr_v3);
                }
            }
            finally {
                typedArray2.recycle();
            }
        }
        if(typedArray0.hasValue(25)) {
            this.l = n.r(context1, typedArray0, 25);
        }
        if(typedArray0.hasValue(23)) {
            int v9 = typedArray0.getColor(23, 0);
            int v10 = this.l.getDefaultColor();
            this.l = new ColorStateList(new int[][]{arr_v2, arr_v1}, new int[]{v9, v10});
        }
        this.m = n.r(context1, typedArray0, 3);
        this.w = B.o(typedArray0.getInt(4, -1), null);
        this.n = n.r(context1, typedArray0, 21);
        this.V = typedArray0.getInt(6, 300);
        this.i0 = n.C(context1, 0x7F040464, e6.a.b);  // attr:motionEasingEmphasizedInterpolator
        this.I = typedArray0.getDimensionPixelSize(14, -1);
        this.M = typedArray0.getDimensionPixelSize(13, -1);
        this.E = typedArray0.getResourceId(0, 0);
        this.S = typedArray0.getDimensionPixelSize(1, 0);
        this.b0 = typedArray0.getInt(15, 1);
        this.T = typedArray0.getInt(2, 0);
        this.c0 = typedArray0.getBoolean(12, false);
        this.g0 = typedArray0.getBoolean(26, false);
        typedArray0.recycle();
        Resources resources0 = this.getResources();
        this.D = (float)resources0.getDimensionPixelSize(0x7F0700E1);  // dimen:design_tab_text_size_2line
        this.N = resources0.getDimensionPixelSize(0x7F0700DF);  // dimen:design_tab_scrollable_min_width
        this.d();
    }

    public final void a(i i0, boolean z) {
        ArrayList arrayList0 = this.b;
        int v = arrayList0.size();
        if(i0.f != this) {
            throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
        }
        i0.d = v;
        arrayList0.add(v, i0);
        int v1 = arrayList0.size();
        int v2 = v + 1;
        int v3 = -1;
        while(v2 < v1) {
            if(((i)arrayList0.get(v2)).d == this.a) {
                v3 = v2;
            }
            ((i)arrayList0.get(v2)).d = v2;
            ++v2;
        }
        this.a = v3;
        l l0 = i0.g;
        l0.setSelected(false);
        l0.setActivated(false);
        int v4 = i0.d;
        LinearLayout.LayoutParams linearLayout$LayoutParams0 = new LinearLayout.LayoutParams(-2, -1);
        if(this.b0 != 1 || this.T != 0) {
            linearLayout$LayoutParams0.width = -2;
            linearLayout$LayoutParams0.weight = 0.0f;
        }
        else {
            linearLayout$LayoutParams0.width = 0;
            linearLayout$LayoutParams0.weight = 1.0f;
        }
        this.d.addView(l0, v4, linearLayout$LayoutParams0);
        if(z) {
            TabLayout tabLayout0 = i0.f;
            if(tabLayout0 == null) {
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            tabLayout0.j(i0, true);
        }
    }

    @Override  // android.widget.HorizontalScrollView
    public final void addView(View view0) {
        this.b(view0);
    }

    @Override  // android.widget.HorizontalScrollView
    public final void addView(View view0, int v) {
        this.b(view0);
    }

    @Override  // android.widget.HorizontalScrollView
    public final void addView(View view0, int v, ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        this.b(view0);
    }

    @Override  // android.widget.HorizontalScrollView
    public final void addView(View view0, ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        this.b(view0);
    }

    public final void b(View view0) {
        if(!(view0 instanceof TabItem)) {
            throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
        }
        i i0 = this.h();
        CharSequence charSequence0 = ((TabItem)view0).a;
        if(charSequence0 != null) {
            if(TextUtils.isEmpty(i0.c) && !TextUtils.isEmpty(charSequence0)) {
                i0.g.setContentDescription(charSequence0);
            }
            i0.b = charSequence0;
            i0.a();
        }
        Drawable drawable0 = ((TabItem)view0).b;
        if(drawable0 != null) {
            i0.a = drawable0;
            TabLayout tabLayout0 = i0.f;
            if(tabLayout0.T == 1 || tabLayout0.b0 == 2) {
                tabLayout0.n(true);
            }
            i0.a();
        }
        int v = ((TabItem)view0).c;
        if(v != 0) {
            i0.e = LayoutInflater.from(i0.g.getContext()).inflate(v, i0.g, false);
            i0.a();
        }
        if(!TextUtils.isEmpty(((TabItem)view0).getContentDescription())) {
            i0.c = ((TabItem)view0).getContentDescription();
            i0.a();
        }
        this.a(i0, this.b.isEmpty());
    }

    public final void c(int v) {
        if(v == -1) {
            return;
        }
        if(this.getWindowToken() != null && this.isLaidOut()) {
            h h0 = this.d;
            int v1 = h0.getChildCount();
            for(int v2 = 0; v2 < v1; ++v2) {
                if(h0.getChildAt(v2).getWidth() <= 0) {
                    this.l(v, 0.0f, true, true, true);
                    return;
                }
            }
            int v3 = this.getScrollX();
            int v4 = this.e(0.0f, v);
            if(v3 != v4) {
                this.f();
                this.m0.setIntValues(new int[]{v3, v4});
                this.m0.start();
            }
            if(h0.a != null && h0.a.isRunning() && h0.b.a != v) {
                h0.a.cancel();
            }
            h0.d(v, this.V, true);
            return;
        }
        this.l(v, 0.0f, true, true, true);
    }

    public final void d() {
        h h0 = this.d;
        h0.setPaddingRelative((this.b0 == 0 || this.b0 == 2 ? Math.max(0, this.S - this.e) : 0), 0, 0, 0);
    alab1:
        switch(this.b0) {
            case 0: {
                switch(this.T) {
                    case 0: {
                        Log.w("TabLayout", "MODE_SCROLLABLE + GRAVITY_FILL is not supported, GRAVITY_START will be used instead");
                        break;
                    }
                    case 1: {
                        h0.setGravity(1);
                        break alab1;
                    }
                    case 2: {
                        break;
                    }
                    default: {
                        break alab1;
                    }
                }
                h0.setGravity(0x800003);
                break;
            }
            case 1: 
            case 2: {
                if(this.T == 2) {
                    Log.w("TabLayout", "GRAVITY_START is not supported with the current tab mode, GRAVITY_CENTER will be used instead");
                }
                h0.setGravity(1);
            }
        }
        this.n(true);
    }

    public final int e(float f, int v) {
        int v1 = 0;
        if(this.b0 != 0 && this.b0 != 2) {
            return 0;
        }
        h h0 = this.d;
        View view0 = h0.getChildAt(v);
        if(view0 == null) {
            return 0;
        }
        View view1 = v + 1 >= h0.getChildCount() ? null : h0.getChildAt(v + 1);
        int v2 = view0.getWidth();
        if(view1 != null) {
            v1 = view1.getWidth();
        }
        int v3 = v2 / 2 + view0.getLeft() - this.getWidth() / 2;
        int v4 = (int)(((float)(v2 + v1)) * 0.5f * f);
        return this.getLayoutDirection() == 0 ? v3 + v4 : v3 - v4;
    }

    public final void f() {
        if(this.m0 == null) {
            ValueAnimator valueAnimator0 = new ValueAnimator();
            this.m0 = valueAnimator0;
            valueAnimator0.setInterpolator(this.i0);
            this.m0.setDuration(((long)this.V));
            this.m0.addUpdateListener(new b(this, 0));
        }
    }

    public final i g(int v) {
        return v < 0 || v >= this.getTabCount() ? null : ((i)this.b.get(v));
    }

    @Override  // android.widget.FrameLayout
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet0) {
        return this.generateDefaultLayoutParams();
    }

    @Override  // android.widget.FrameLayout
    public final FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet0) {
        return this.generateDefaultLayoutParams();
    }

    private int getDefaultHeight() {
        ArrayList arrayList0 = this.b;
        int v = arrayList0.size();
        for(int v1 = 0; v1 < v; ++v1) {
            i i0 = (i)arrayList0.get(v1);
            if(i0 != null && i0.a != null && !TextUtils.isEmpty(i0.b)) {
                return this.c0 ? 0x30 : 72;
            }
        }
        return 0x30;
    }

    public int getSelectedTabPosition() {
        return this.c == null ? -1 : this.c.d;
    }

    public int getTabCount() {
        return this.b.size();
    }

    public int getTabGravity() {
        return this.T;
    }

    public ColorStateList getTabIconTint() {
        return this.m;
    }

    public int getTabIndicatorAnimationMode() {
        return this.f0;
    }

    public int getTabIndicatorGravity() {
        return this.W;
    }

    public int getTabMaxWidth() {
        return this.G;
    }

    private int getTabMinWidth() {
        int v = this.I;
        if(v != -1) {
            return v;
        }
        return this.b0 == 0 || this.b0 == 2 ? this.N : 0;
    }

    public int getTabMode() {
        return this.b0;
    }

    public ColorStateList getTabRippleColor() {
        return this.n;
    }

    private int getTabScrollRange() {
        return Math.max(0, this.d.getWidth() - this.getWidth() - this.getPaddingLeft() - this.getPaddingRight());
    }

    public Drawable getTabSelectedIndicator() {
        return this.o;
    }

    public ColorStateList getTabTextColors() {
        return this.l;
    }

    public final i h() {
        i i0 = (i)TabLayout.v0.acquire();
        if(i0 == null) {
            i0 = new i();  // 初始化器: Ljava/lang/Object;-><init>()V
            i0.d = -1;
        }
        i0.f = this;
        l l0 = this.u0 == null ? null : ((l)this.u0.acquire());
        if(l0 == null) {
            l0 = new l(this, this.getContext());
        }
        l0.setTab(i0);
        l0.setFocusable(true);
        l0.setMinimumWidth(this.getTabMinWidth());
        if(TextUtils.isEmpty(i0.c)) {
            l0.setContentDescription(i0.b);
        }
        else {
            l0.setContentDescription(i0.c);
        }
        i0.g = l0;
        return i0;
    }

    public final void i() {
        h h0 = this.d;
        for(int v = h0.getChildCount() - 1; v >= 0; --v) {
            l l0 = (l)h0.getChildAt(v);
            h0.removeViewAt(v);
            if(l0 != null) {
                l0.setTab(null);
                l0.setSelected(false);
                this.u0.release(l0);
            }
            this.requestLayout();
        }
        Iterator iterator0 = this.b.iterator();
        while(iterator0.hasNext()) {
            Object object0 = iterator0.next();
            iterator0.remove();
            ((i)object0).f = null;
            ((i)object0).g = null;
            ((i)object0).a = null;
            ((i)object0).b = null;
            ((i)object0).c = null;
            ((i)object0).d = -1;
            ((i)object0).e = null;
            TabLayout.v0.release(((i)object0));
        }
        this.c = null;
        a a0 = this.o0;
        if(a0 != null) {
            int v1 = a0.getCount();
            for(int v2 = 0; v2 < v1; ++v2) {
                i i0 = this.h();
                if(TextUtils.isEmpty(i0.c) && !TextUtils.isEmpty(null)) {
                    i0.g.setContentDescription(null);
                }
                i0.b = null;
                i0.a();
                this.a(i0, false);
            }
            ViewPager viewPager0 = this.n0;
            if(viewPager0 != null && v1 > 0) {
                int v3 = viewPager0.getCurrentItem();
                if(v3 != this.getSelectedTabPosition() && v3 < this.getTabCount()) {
                    this.j(this.g(v3), true);
                }
            }
        }
    }

    public final void j(i i0, boolean z) {
        i i1 = this.c;
        ArrayList arrayList0 = this.k0;
        if(i1 != i0) {
            int v1 = i0 == null ? -1 : i0.d;
            if(z) {
                if(i1 != null && i1.d != -1 || v1 == -1) {
                    this.c(v1);
                }
                else {
                    this.l(v1, 0.0f, true, true, true);
                }
                if(v1 != -1) {
                    this.setSelectedTabView(v1);
                }
            }
            this.c = i0;
            if(i1 != null && i1.f != null) {
                for(int v2 = arrayList0.size() - 1; v2 >= 0; --v2) {
                    ((d)arrayList0.get(v2)).onTabUnselected(i1);
                }
            }
            if(i0 != null) {
                for(int v3 = arrayList0.size() - 1; v3 >= 0; --v3) {
                    ((d)arrayList0.get(v3)).onTabSelected(i0);
                }
            }
        }
        else if(i1 != null) {
            for(int v = arrayList0.size() - 1; v >= 0; --v) {
                ((d)arrayList0.get(v)).onTabReselected(i0);
            }
            this.c(i0.d);
        }
    }

    public final void k(a a0, boolean z) {
        a a1 = this.o0;
        if(a1 != null) {
            D6.f f0 = this.p0;
            if(f0 != null) {
                a1.unregisterDataSetObserver(f0);
            }
        }
        this.o0 = a0;
        if(z && a0 != null) {
            if(this.p0 == null) {
                this.p0 = new D6.f(this, 0);
            }
            a0.registerDataSetObserver(this.p0);
        }
        this.i();
    }

    public final void l(int v, float f, boolean z, boolean z1, boolean z2) {
        float f1 = ((float)v) + f;
        int v1 = Math.round(f1);
        if(v1 >= 0) {
            h h0 = this.d;
            if(v1 < h0.getChildCount()) {
                if(z1) {
                    h0.b.a = Math.round(f1);
                    if(h0.a != null && h0.a.isRunning()) {
                        h0.a.cancel();
                    }
                    h0.c(h0.getChildAt(v), h0.getChildAt(v + 1), f);
                }
                if(this.m0 != null && this.m0.isRunning()) {
                    this.m0.cancel();
                }
                int v2 = this.e(f, v);
                int v3 = this.getScrollX();
                boolean z3 = v < this.getSelectedTabPosition() && v2 >= v3 || v > this.getSelectedTabPosition() && v2 <= v3 || v == this.getSelectedTabPosition();
                if(this.getLayoutDirection() == 1) {
                    z3 = v < this.getSelectedTabPosition() && v2 <= v3 || v > this.getSelectedTabPosition() && v2 >= v3 || v == this.getSelectedTabPosition();
                }
                if(z3 || this.t0 == 1 || z2) {
                    if(v < 0) {
                        v2 = 0;
                    }
                    this.scrollTo(v2, 0);
                }
                if(z) {
                    this.setSelectedTabView(v1);
                }
            }
        }
    }

    public final void m(ViewPager viewPager0, boolean z) {
        ViewPager viewPager1 = this.n0;
        if(viewPager1 != null) {
            j j0 = this.q0;
            if(j0 != null) {
                viewPager1.removeOnPageChangeListener(j0);
            }
            c c0 = this.r0;
            if(c0 != null) {
                this.n0.removeOnAdapterChangeListener(c0);
            }
        }
        m m0 = this.l0;
        ArrayList arrayList0 = this.k0;
        if(m0 != null) {
            arrayList0.remove(m0);
            this.l0 = null;
        }
        if(viewPager0 == null) {
            this.n0 = null;
            this.k(null, false);
        }
        else {
            this.n0 = viewPager0;
            if(this.q0 == null) {
                this.q0 = new j(this);
            }
            this.q0.c = 0;
            this.q0.b = 0;
            viewPager0.addOnPageChangeListener(this.q0);
            m m1 = new m(viewPager0);
            this.l0 = m1;
            if(!arrayList0.contains(m1)) {
                arrayList0.add(m1);
            }
            a a0 = viewPager0.getAdapter();
            if(a0 != null) {
                this.k(a0, true);
            }
            if(this.r0 == null) {
                this.r0 = new c(this);
            }
            this.r0.a = true;
            viewPager0.addOnAdapterChangeListener(this.r0);
            this.l(viewPager0.getCurrentItem(), 0.0f, true, true, true);
        }
        this.s0 = z;
    }

    public final void n(boolean z) {
        for(int v = 0; true; ++v) {
            h h0 = this.d;
            if(v >= h0.getChildCount()) {
                break;
            }
            View view0 = h0.getChildAt(v);
            view0.setMinimumWidth(this.getTabMinWidth());
            LinearLayout.LayoutParams linearLayout$LayoutParams0 = (LinearLayout.LayoutParams)view0.getLayoutParams();
            if(this.b0 != 1 || this.T != 0) {
                linearLayout$LayoutParams0.width = -2;
                linearLayout$LayoutParams0.weight = 0.0f;
            }
            else {
                linearLayout$LayoutParams0.width = 0;
                linearLayout$LayoutParams0.weight = 1.0f;
            }
            if(z) {
                view0.requestLayout();
            }
        }
    }

    @Override  // android.view.ViewGroup
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        d5.n.B(this);
        if(this.n0 == null) {
            ViewParent viewParent0 = this.getParent();
            if(viewParent0 instanceof ViewPager) {
                this.m(((ViewPager)viewParent0), true);
            }
        }
    }

    @Override  // android.view.ViewGroup
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if(this.s0) {
            this.setupWithViewPager(null);
            this.s0 = false;
        }
    }

    @Override  // android.view.View
    public final void onDraw(Canvas canvas0) {
        for(int v = 0; true; ++v) {
            h h0 = this.d;
            if(v >= h0.getChildCount()) {
                break;
            }
            View view0 = h0.getChildAt(v);
            if(view0 instanceof l) {
                Drawable drawable0 = ((l)view0).i;
                if(drawable0 != null) {
                    drawable0.setBounds(((l)view0).getLeft(), ((l)view0).getTop(), ((l)view0).getRight(), ((l)view0).getBottom());
                    ((l)view0).i.draw(canvas0);
                }
            }
        }
        super.onDraw(canvas0);
    }

    @Override  // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo0) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo0);
        accessibilityNodeInfo0.setCollectionInfo(((AccessibilityNodeInfo.CollectionInfo)B6.f.d(1, this.getTabCount(), 1, false).a));
    }

    @Override  // android.widget.HorizontalScrollView
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent0) {
        return (this.getTabMode() == 0 || this.getTabMode() == 2) && super.onInterceptTouchEvent(motionEvent0);
    }

    @Override  // android.widget.HorizontalScrollView
    public final void onMeasure(int v, int v1) {
        int v2 = Math.round(B.g(this.getContext(), this.getDefaultHeight()));
        switch(View.MeasureSpec.getMode(v1)) {
            case 0x80000000: {
                if(this.getChildCount() == 1 && View.MeasureSpec.getSize(v1) >= v2) {
                    this.getChildAt(0).setMinimumHeight(v2);
                }
                break;
            }
            case 0: {
                int v3 = this.getPaddingTop();
                v1 = View.MeasureSpec.makeMeasureSpec(this.getPaddingBottom() + (v3 + v2), 0x40000000);
            }
        }
        int v4 = View.MeasureSpec.getSize(v);
        if(View.MeasureSpec.getMode(v) != 0) {
            this.G = this.M > 0 ? this.M : ((int)(((float)v4) - B.g(this.getContext(), 56)));
        }
        super.onMeasure(v, v1);
        if(this.getChildCount() == 1) {
            View view0 = this.getChildAt(0);
            int v5 = this.b0;
            switch(v5) {
                case 0: {
                label_18:
                    if(view0.getMeasuredWidth() < this.getMeasuredWidth()) {
                        goto label_22;
                    }
                    break;
                }
                case 1: {
                    if(view0.getMeasuredWidth() == this.getMeasuredWidth()) {
                        return;
                    }
                label_22:
                    int v6 = this.getPaddingTop();
                    int v7 = ViewGroup.getChildMeasureSpec(v1, this.getPaddingBottom() + v6, view0.getLayoutParams().height);
                    view0.measure(View.MeasureSpec.makeMeasureSpec(this.getMeasuredWidth(), 0x40000000), v7);
                    break;
                }
                default: {
                    if(v5 != 2) {
                        return;
                    }
                    goto label_18;
                }
            }
        }
    }

    @Override  // android.widget.HorizontalScrollView
    public final boolean onTouchEvent(MotionEvent motionEvent0) {
        return motionEvent0.getActionMasked() != 8 || (this.getTabMode() == 0 || this.getTabMode() == 2) ? super.onTouchEvent(motionEvent0) : false;
    }

    @Override  // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        d5.n.z(this, f);
    }

    public void setInlineLabel(boolean z) {
        if(this.c0 != z) {
            this.c0 = z;
            for(int v = 0; true; ++v) {
                h h0 = this.d;
                if(v >= h0.getChildCount()) {
                    break;
                }
                View view0 = h0.getChildAt(v);
                if(view0 instanceof l) {
                    ((l)view0).setOrientation(!((l)view0).k.c0);
                    TextView textView0 = ((l)view0).g;
                    if(textView0 != null || ((l)view0).h != null) {
                        ((l)view0).g(textView0, ((l)view0).h, false);
                    }
                    else {
                        ((l)view0).g(((l)view0).b, ((l)view0).c, true);
                    }
                }
            }
            this.d();
        }
    }

    public void setInlineLabelResource(int v) {
        this.setInlineLabel(this.getResources().getBoolean(v));
    }

    @Deprecated
    public void setOnTabSelectedListener(d d0) {
        d d1 = this.j0;
        ArrayList arrayList0 = this.k0;
        if(d1 != null) {
            arrayList0.remove(d1);
        }
        this.j0 = d0;
        if(d0 != null && !arrayList0.contains(d0)) {
            arrayList0.add(d0);
        }
    }

    @Deprecated
    public void setOnTabSelectedListener(D6.e e0) {
        this.setOnTabSelectedListener(e0);
    }

    public void setScrollAnimatorListener(Animator.AnimatorListener animator$AnimatorListener0) {
        this.f();
        this.m0.addListener(animator$AnimatorListener0);
    }

    public void setSelectedTabIndicator(int v) {
        if(v != 0) {
            this.setSelectedTabIndicator(w.B(this.getContext(), v));
            return;
        }
        this.setSelectedTabIndicator(null);
    }

    public void setSelectedTabIndicator(Drawable drawable0) {
        if(drawable0 == null) {
            drawable0 = new GradientDrawable();
        }
        Drawable drawable1 = drawable0.mutate();
        this.o = drawable1;
        int v = this.r;
        if(v == 0) {
            drawable1.setTintList(null);
        }
        else {
            drawable1.setTint(v);
        }
        int v1 = this.e0 == -1 ? this.o.getIntrinsicHeight() : this.e0;
        this.d.b(v1);
    }

    public void setSelectedTabIndicatorColor(int v) {
        this.r = v;
        Drawable drawable0 = this.o;
        if(v == 0) {
            drawable0.setTintList(null);
        }
        else {
            drawable0.setTint(v);
        }
        this.n(false);
    }

    public void setSelectedTabIndicatorGravity(int v) {
        if(this.W != v) {
            this.W = v;
            this.d.postInvalidateOnAnimation();
        }
    }

    @Deprecated
    public void setSelectedTabIndicatorHeight(int v) {
        this.e0 = v;
        this.d.b(v);
    }

    private void setSelectedTabView(int v) {
        h h0 = this.d;
        int v1 = h0.getChildCount();
        if(v < v1) {
            for(int v2 = 0; v2 < v1; ++v2) {
                View view0 = h0.getChildAt(v2);
                boolean z = true;
                if((v2 != v || view0.isSelected()) && (v2 == v || !view0.isSelected())) {
                    view0.setSelected(v2 == v);
                    if(v2 != v) {
                        z = false;
                    }
                    view0.setActivated(z);
                }
                else {
                    view0.setSelected(v2 == v);
                    if(v2 != v) {
                        z = false;
                    }
                    view0.setActivated(z);
                    if(view0 instanceof l) {
                        ((l)view0).f();
                    }
                }
            }
        }
    }

    public void setTabGravity(int v) {
        if(this.T != v) {
            this.T = v;
            this.d();
        }
    }

    public void setTabIconTint(ColorStateList colorStateList0) {
        if(this.m != colorStateList0) {
            this.m = colorStateList0;
            ArrayList arrayList0 = this.b;
            int v = arrayList0.size();
            for(int v1 = 0; v1 < v; ++v1) {
                ((i)arrayList0.get(v1)).a();
            }
        }
    }

    public void setTabIconTintResource(int v) {
        this.setTabIconTint(P1.c.getColorStateList(this.getContext(), v));
    }

    public void setTabIndicatorAnimationMode(int v) {
        this.f0 = v;
        switch(v) {
            case 0: {
                this.h0 = new z6.f(9);
                return;
            }
            case 1: {
                this.h0 = new D6.a(0);
                return;
            }
            case 2: {
                this.h0 = new D6.a(1);
                return;
            }
            default: {
                throw new IllegalArgumentException(v + " is not a valid TabIndicatorAnimationMode");
            }
        }
    }

    public void setTabIndicatorFullWidth(boolean z) {
        this.d0 = z;
        int v = this.d.b.getSelectedTabPosition();
        this.d.a(v);
        this.d.postInvalidateOnAnimation();
    }

    public void setTabMode(int v) {
        if(v != this.b0) {
            this.b0 = v;
            this.d();
        }
    }

    public void setTabRippleColor(ColorStateList colorStateList0) {
        if(this.n != colorStateList0) {
            this.n = colorStateList0;
            for(int v = 0; true; ++v) {
                h h0 = this.d;
                if(v >= h0.getChildCount()) {
                    break;
                }
                View view0 = h0.getChildAt(v);
                if(view0 instanceof l) {
                    ((l)view0).e(this.getContext());
                }
            }
        }
    }

    public void setTabRippleColorResource(int v) {
        this.setTabRippleColor(P1.c.getColorStateList(this.getContext(), v));
    }

    public void setTabTextColors(ColorStateList colorStateList0) {
        if(this.l != colorStateList0) {
            this.l = colorStateList0;
            ArrayList arrayList0 = this.b;
            int v = arrayList0.size();
            for(int v1 = 0; v1 < v; ++v1) {
                ((i)arrayList0.get(v1)).a();
            }
        }
    }

    @Deprecated
    public void setTabsFromPagerAdapter(a a0) {
        this.k(a0, false);
    }

    public void setUnboundedRipple(boolean z) {
        if(this.g0 != z) {
            this.g0 = z;
            for(int v = 0; true; ++v) {
                h h0 = this.d;
                if(v >= h0.getChildCount()) {
                    break;
                }
                View view0 = h0.getChildAt(v);
                if(view0 instanceof l) {
                    ((l)view0).e(this.getContext());
                }
            }
        }
    }

    public void setUnboundedRippleResource(int v) {
        this.setUnboundedRipple(this.getResources().getBoolean(v));
    }

    public void setupWithViewPager(ViewPager viewPager0) {
        this.m(viewPager0, false);
    }

    @Override  // android.widget.HorizontalScrollView
    public final boolean shouldDelayChildPressedState() {
        return this.getTabScrollRange() > 0;
    }
}

