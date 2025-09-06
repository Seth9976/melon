package androidx.viewpager2.widget;

import Mc.b;
import R4.a;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.View.BaseSavedState;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo.CollectionInfo;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.recyclerview.widget.j0;
import androidx.recyclerview.widget.q0;
import c2.W;
import d5.i;
import java.util.ArrayList;

public final class ViewPager2 extends ViewGroup {
    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator CREATOR;
        public int a;
        public int b;
        public Parcelable c;

        static {
            SavedState.CREATOR = new o();  // 初始化器: Ljava/lang/Object;-><init>()V
        }

        @Override  // android.view.View$BaseSavedState
        public final void writeToParcel(Parcel parcel0, int v) {
            super.writeToParcel(parcel0, v);
            parcel0.writeInt(this.a);
            parcel0.writeInt(this.b);
            parcel0.writeParcelable(this.c, v);
        }
    }

    public boolean B;
    public int D;
    public i E;
    public final Rect a;
    public final Rect b;
    public final b c;
    public int d;
    public boolean e;
    public final f f;
    public androidx.viewpager2.widget.i g;
    public int h;
    public Parcelable i;
    public n j;
    public m k;
    public e l;
    public b m;
    public androidx.viewpager2.widget.b n;
    public c o;
    public q0 r;
    public boolean w;

    public ViewPager2(Context context0) {
        super(context0);
        this.a = new Rect();
        this.b = new Rect();
        this.c = new b();
        this.e = false;
        this.f = new f(this, 0);
        this.h = -1;
        this.r = null;
        this.w = false;
        this.B = true;
        this.D = -1;
        this.a(context0, null);
    }

    public ViewPager2(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.a = new Rect();
        this.b = new Rect();
        this.c = new b();
        this.e = false;
        this.f = new f(this, 0);
        this.h = -1;
        this.r = null;
        this.w = false;
        this.B = true;
        this.D = -1;
        this.a(context0, attributeSet0);
    }

    public ViewPager2(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        this.a = new Rect();
        this.b = new Rect();
        this.c = new b();
        this.e = false;
        this.f = new f(this, 0);
        this.h = -1;
        this.r = null;
        this.w = false;
        this.B = true;
        this.D = -1;
        this.a(context0, attributeSet0);
    }

    public final void a(Context context0, AttributeSet attributeSet0) {
        i i0 = new i();  // 初始化器: Ljava/lang/Object;-><init>()V
        i0.d = this;
        i0.a = new k(i0, 0);
        i0.b = new k(i0, 1);
        this.E = i0;
        n n0 = new n(this, context0);
        this.j = n0;
        n0.setId(View.generateViewId());
        this.j.setDescendantFocusability(0x20000);
        androidx.viewpager2.widget.i i1 = new androidx.viewpager2.widget.i(this, context0);
        this.g = i1;
        this.j.setLayoutManager(i1);
        this.j.setScrollingTouchSlop(1);
        TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, a.a);
        W.n(this, context0, a.a, attributeSet0, typedArray0, 0);
        try {
            this.setOrientation(typedArray0.getInt(0, 0));
        }
        finally {
            typedArray0.recycle();
        }
        this.j.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.j.addOnChildAttachStateChangeListener(new h());  // 初始化器: Ljava/lang/Object;-><init>()V
        e e0 = new e(this);
        this.l = e0;
        this.n = new androidx.viewpager2.widget.b(this, e0, this.j);
        m m0 = new m(this);
        this.k = m0;
        m0.a(this.j);
        this.j.addOnScrollListener(this.l);
        b b0 = new b();
        this.m = b0;
        this.l.a = b0;
        g g0 = new g(this, 0);
        g g1 = new g(this, 1);
        ((ArrayList)b0.b).add(g0);
        ((ArrayList)this.m.b).add(g1);
        i i2 = this.E;
        n n1 = this.j;
        i2.getClass();
        n1.setImportantForAccessibility(2);
        i2.c = new f(i2, 1);
        ViewPager2 viewPager20 = (ViewPager2)i2.d;
        if(viewPager20.getImportantForAccessibility() == 0) {
            viewPager20.setImportantForAccessibility(1);
        }
        ((ArrayList)this.m.b).add(this.c);
        c c0 = new c();  // 初始化器: Ljava/lang/Object;-><init>()V
        this.o = c0;
        ((ArrayList)this.m.b).add(c0);
        this.attachViewToParent(this.j, 0, this.j.getLayoutParams());
    }

    public final void b() {
        if(this.h != -1) {
            j0 j00 = this.getAdapter();
            if(j00 != null) {
                Parcelable parcelable0 = this.i;
                if(parcelable0 != null) {
                    if(j00 instanceof androidx.viewpager2.adapter.h) {
                        ((androidx.viewpager2.adapter.h)j00).restoreState(parcelable0);
                    }
                    this.i = null;
                }
                int v = Math.max(0, Math.min(this.h, j00.getItemCount() - 1));
                this.d = v;
                this.h = -1;
                this.j.scrollToPosition(v);
                this.E.i();
            }
        }
    }

    public final void c(int v, boolean z) {
        if(this.n.b.m) {
            throw new IllegalStateException("Cannot change current item when ViewPager2 is fake dragging");
        }
        this.d(v, z);
    }

    @Override  // android.view.View
    public final boolean canScrollHorizontally(int v) {
        return this.j.canScrollHorizontally(v);
    }

    @Override  // android.view.View
    public final boolean canScrollVertically(int v) {
        return this.j.canScrollVertically(v);
    }

    public final void d(int v, boolean z) {
        j0 j00 = this.getAdapter();
        boolean z1 = false;
        if(j00 == null) {
            if(this.h != -1) {
                this.h = Math.max(v, 0);
            }
        }
        else if(j00.getItemCount() > 0) {
            int v1 = Math.min(Math.max(v, 0), j00.getItemCount() - 1);
            int v2 = this.d;
            if(v1 == v2 && this.l.f == 0) {
                return;
            }
            if(v1 != v2 || !z) {
                double f = (double)v2;
                this.d = v1;
                this.E.i();
                e e0 = this.l;
                if(e0.f != 0) {
                    e0.e();
                    f = ((double)e0.g.b) + ((double)e0.g.a);
                }
                e e1 = this.l;
                e1.getClass();
                e1.e = z ? 2 : 3;
                e1.m = false;
                if(e1.i != v1) {
                    z1 = true;
                }
                e1.i = v1;
                e1.b(2);
                if(z1) {
                    e1.a(v1);
                }
                if(!z) {
                    this.j.scrollToPosition(v1);
                    return;
                }
                if(Math.abs(((double)v1) - f) > 3.0) {
                    this.j.scrollToPosition((((double)v1) > f ? v1 - 3 : v1 + 3));
                    this.j.post(new Z1.a(v1, this.j));
                    return;
                }
                this.j.smoothScrollToPosition(v1);
            }
        }
    }

    @Override  // android.view.ViewGroup
    public final void dispatchRestoreInstanceState(SparseArray sparseArray0) {
        Parcelable parcelable0 = (Parcelable)sparseArray0.get(this.getId());
        if(parcelable0 instanceof SavedState) {
            int v = ((SavedState)parcelable0).a;
            sparseArray0.put(this.j.getId(), ((Parcelable)sparseArray0.get(v)));
            sparseArray0.remove(v);
        }
        super.dispatchRestoreInstanceState(sparseArray0);
        this.b();
    }

    public final void e() {
        m m0 = this.k;
        if(m0 == null) {
            throw new IllegalStateException("Design assumption violated.");
        }
        View view0 = m0.e(this.g);
        if(view0 == null) {
            return;
        }
        int v = this.g.getPosition(view0);
        if(v != this.d && this.getScrollState() == 0) {
            this.m.onPageSelected(v);
        }
        this.e = false;
    }

    @Override  // android.view.ViewGroup
    public CharSequence getAccessibilityClassName() {
        this.E.getClass();
        this.E.getClass();
        return "androidx.viewpager.widget.ViewPager";
    }

    public j0 getAdapter() {
        return this.j.getAdapter();
    }

    public int getCurrentItem() {
        return this.d;
    }

    public int getItemDecorationCount() {
        return this.j.getItemDecorationCount();
    }

    public int getOffscreenPageLimit() {
        return this.D;
    }

    public int getOrientation() {
        return this.g.getOrientation() == 1 ? 1 : 0;
    }

    public int getPageSize() {
        n n0 = this.j;
        return this.getOrientation() == 0 ? n0.getWidth() - n0.getPaddingLeft() - n0.getPaddingRight() : n0.getHeight() - n0.getPaddingTop() - n0.getPaddingBottom();
    }

    public int getScrollState() {
        return this.l.f;
    }

    @Override  // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo0) {
        int v1;
        int v;
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo0);
        ViewPager2 viewPager20 = (ViewPager2)this.E.d;
        if(viewPager20.getAdapter() == null) {
            v = 0;
            v1 = 0;
        }
        else if(viewPager20.getOrientation() == 1) {
            v = viewPager20.getAdapter().getItemCount();
            v1 = 1;
        }
        else {
            v1 = viewPager20.getAdapter().getItemCount();
            v = 1;
        }
        accessibilityNodeInfo0.setCollectionInfo(((AccessibilityNodeInfo.CollectionInfo)B6.f.d(v, v1, 0, false).a));
        j0 j00 = viewPager20.getAdapter();
        if(j00 != null) {
            int v2 = j00.getItemCount();
            if(v2 != 0 && viewPager20.B) {
                if(viewPager20.d > 0) {
                    accessibilityNodeInfo0.addAction(0x2000);
                }
                if(viewPager20.d < v2 - 1) {
                    accessibilityNodeInfo0.addAction(0x1000);
                }
                accessibilityNodeInfo0.setScrollable(true);
            }
        }
    }

    @Override  // android.view.ViewGroup
    public final void onLayout(boolean z, int v, int v1, int v2, int v3) {
        int v4 = this.j.getMeasuredWidth();
        int v5 = this.j.getMeasuredHeight();
        this.a.left = this.getPaddingLeft();
        this.a.right = v2 - v - this.getPaddingRight();
        this.a.top = this.getPaddingTop();
        this.a.bottom = v3 - v1 - this.getPaddingBottom();
        Gravity.apply(0x800033, v4, v5, this.a, this.b);
        this.j.layout(this.b.left, this.b.top, this.b.right, this.b.bottom);
        if(this.e) {
            this.e();
        }
    }

    @Override  // android.view.View
    public final void onMeasure(int v, int v1) {
        this.measureChild(this.j, v, v1);
        int v2 = this.j.getMeasuredWidth();
        int v3 = this.j.getMeasuredHeight();
        int v4 = this.j.getMeasuredState();
        int v5 = this.getPaddingLeft();
        int v6 = this.getPaddingRight();
        int v7 = this.getPaddingTop();
        int v8 = this.getPaddingBottom();
        int v9 = Math.max(v6 + v5 + v2, this.getSuggestedMinimumWidth());
        int v10 = Math.max(v8 + v7 + v3, this.getSuggestedMinimumHeight());
        this.setMeasuredDimension(View.resolveSizeAndState(v9, v, v4), View.resolveSizeAndState(v10, v1, v4 << 16));
    }

    @Override  // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable0) {
        if(!(parcelable0 instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable0);
            return;
        }
        super.onRestoreInstanceState(((SavedState)parcelable0).getSuperState());
        this.h = ((SavedState)parcelable0).b;
        this.i = ((SavedState)parcelable0).c;
    }

    @Override  // android.view.View
    public final Parcelable onSaveInstanceState() {
        Parcelable parcelable0 = new SavedState(super.onSaveInstanceState());  // 初始化器: Landroid/view/View$BaseSavedState;-><init>(Landroid/os/Parcelable;)V
        parcelable0.a = this.j.getId();
        parcelable0.b = this.h == -1 ? this.d : this.h;
        Parcelable parcelable1 = this.i;
        if(parcelable1 != null) {
            parcelable0.c = parcelable1;
            return parcelable0;
        }
        j0 j00 = this.j.getAdapter();
        if(j00 instanceof androidx.viewpager2.adapter.h) {
            parcelable0.c = ((androidx.viewpager2.adapter.h)j00).saveState();
        }
        return parcelable0;
    }

    @Override  // android.view.ViewGroup
    public final void onViewAdded(View view0) {
        throw new IllegalStateException("ViewPager2 does not support direct child views");
    }

    @Override  // android.view.View
    public final boolean performAccessibilityAction(int v, Bundle bundle0) {
        this.E.getClass();
        if(v != 0x1000 && v != 0x2000) {
            return super.performAccessibilityAction(v, bundle0);
        }
        i i0 = this.E;
        ViewPager2 viewPager20 = (ViewPager2)i0.d;
        int v1 = v == 0x2000 ? viewPager20.getCurrentItem() - 1 : viewPager20.getCurrentItem() + 1;
        ViewPager2 viewPager21 = (ViewPager2)i0.d;
        if(viewPager21.B) {
            viewPager21.d(v1, true);
        }
        return true;
    }

    public void setAdapter(j0 j00) {
        j0 j01 = this.j.getAdapter();
        i i0 = this.E;
        if(j01 == null) {
            i0.getClass();
        }
        else {
            j01.unregisterAdapterDataObserver(((f)i0.c));
        }
        f f0 = this.f;
        if(j01 != null) {
            j01.unregisterAdapterDataObserver(f0);
        }
        this.j.setAdapter(j00);
        this.d = 0;
        this.b();
        i i1 = this.E;
        i1.i();
        if(j00 != null) {
            j00.registerAdapterDataObserver(((f)i1.c));
        }
        if(j00 != null) {
            j00.registerAdapterDataObserver(f0);
        }
    }

    public void setCurrentItem(int v) {
        this.c(v, true);
    }

    @Override  // android.view.View
    public void setLayoutDirection(int v) {
        super.setLayoutDirection(v);
        this.E.i();
    }

    public void setOffscreenPageLimit(int v) {
        if(v < 1 && v != -1) {
            throw new IllegalArgumentException("Offscreen page limit must be OFFSCREEN_PAGE_LIMIT_DEFAULT or a number > 0");
        }
        this.D = v;
        this.j.requestLayout();
    }

    public void setOrientation(int v) {
        this.g.setOrientation(v);
        this.E.i();
    }

    public void setPageTransformer(l l0) {
        if(l0 != null) {
            if(!this.w) {
                this.r = this.j.getItemAnimator();
                this.w = true;
            }
            this.j.setItemAnimator(null);
        }
        else if(this.w) {
            this.j.setItemAnimator(this.r);
            this.r = null;
            this.w = false;
        }
        this.o.getClass();
        if(l0 == null) {
            return;
        }
        this.o.getClass();
        this.o.getClass();
    }

    public void setUserInputEnabled(boolean z) {
        this.B = z;
        this.E.i();
    }
}

