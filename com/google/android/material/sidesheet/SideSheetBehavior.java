package com.google.android.material.sidesheet;

import A6.d;
import A6.e;
import A6.f;
import A6.g;
import A6.j;
import E9.h;
import U4.x;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.customview.view.AbsSavedState;
import c2.M;
import c2.W;
import e1.n;
import j2.c;
import java.lang.ref.WeakReference;
import java.util.LinkedHashSet;
import u6.b;
import u6.i;
import z6.m;
import z6.o;

public class SideSheetBehavior extends Behavior implements b {
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator CREATOR;
        public final int c;

        static {
            SavedState.CREATOR = new a();  // 初始化器: Ljava/lang/Object;-><init>()V
        }

        public SavedState(Parcel parcel0, ClassLoader classLoader0) {
            super(parcel0, classLoader0);
            this.c = parcel0.readInt();
        }

        public SavedState(SideSheetBehavior sideSheetBehavior0) {
            super(android.view.AbsSavedState.EMPTY_STATE);
            this.c = sideSheetBehavior0.h;
        }

        @Override  // androidx.customview.view.AbsSavedState
        public final void writeToParcel(Parcel parcel0, int v) {
            super.writeToParcel(parcel0, v);
            parcel0.writeInt(this.c);
        }
    }

    public final int B;
    public VelocityTracker D;
    public i E;
    public int G;
    public final LinkedHashSet I;
    public final g M;
    public h a;
    public final z6.i b;
    public final ColorStateList c;
    public final o d;
    public final A6.i e;
    public final float f;
    public final boolean g;
    public int h;
    public c i;
    public boolean j;
    public final float k;
    public int l;
    public int m;
    public int n;
    public int o;
    public WeakReference r;
    public WeakReference w;

    public SideSheetBehavior() {
        this.e = new A6.i(this);
        this.g = true;
        this.h = 5;
        this.k = 0.1f;
        this.B = -1;
        this.I = new LinkedHashSet();
        this.M = new g(this, 0);
    }

    public SideSheetBehavior(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.e = new A6.i(this);
        this.g = true;
        this.h = 5;
        this.k = 0.1f;
        this.B = -1;
        this.I = new LinkedHashSet();
        this.M = new g(this, 0);
        TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, d6.a.Z);
        if(typedArray0.hasValue(3)) {
            this.c = n.r(context0, typedArray0, 3);
        }
        if(typedArray0.hasValue(6)) {
            this.d = o.d(context0, attributeSet0, 0, 0x7F140456).a();  // style:Widget.Material3.SideSheet
        }
        if(typedArray0.hasValue(5)) {
            int v = typedArray0.getResourceId(5, -1);
            this.B = v;
            WeakReference weakReference0 = this.w;
            if(weakReference0 != null) {
                weakReference0.clear();
            }
            this.w = null;
            WeakReference weakReference1 = this.r;
            if(weakReference1 != null) {
                View view0 = (View)weakReference1.get();
                if(v != -1 && view0.isLaidOut()) {
                    view0.requestLayout();
                }
            }
        }
        o o0 = this.d;
        if(o0 != null) {
            z6.i i0 = new z6.i(o0);
            this.b = i0;
            i0.k(context0);
            ColorStateList colorStateList0 = this.c;
            if(colorStateList0 == null) {
                TypedValue typedValue0 = new TypedValue();
                context0.getTheme().resolveAttribute(0x1010031, typedValue0, true);
                this.b.setTint(typedValue0.data);
            }
            else {
                this.b.m(colorStateList0);
            }
        }
        this.f = typedArray0.getDimension(2, -1.0f);
        this.g = typedArray0.getBoolean(4, true);
        typedArray0.recycle();
        ViewConfiguration.get(context0).getScaledMaximumFlingVelocity();
    }

    public final void A() {
        WeakReference weakReference0 = this.r;
        if(weakReference0 != null) {
            View view0 = (View)weakReference0.get();
            if(view0 != null) {
                W.l(view0, 0x40000);
                W.i(view0, 0);
                W.l(view0, 0x100000);
                W.i(view0, 0);
                if(this.h != 5) {
                    e e0 = new e(this, 5, 0);
                    W.m(view0, d2.c.n, null, e0);
                }
                if(this.h != 3) {
                    e e1 = new e(this, 3, 0);
                    W.m(view0, d2.c.l, null, e1);
                }
            }
        }
    }

    @Override  // u6.b
    public final void a(b.a a0) {
        i i0 = this.E;
        if(i0 == null) {
            return;
        }
        i0.f = a0;
    }

    @Override  // u6.b
    public final void b() {
        i i0 = this.E;
        if(i0 == null) {
            return;
        }
        i0.b();
    }

    @Override  // u6.b
    public final void c(b.a a0) {
        i i0 = this.E;
        if(i0 != null) {
            int v = this.a == null || this.a.K() == 0 ? 5 : 3;
            if(i0.f == null) {
                Log.w("MaterialBackHelper", "Must call startBackProgress() before updateBackProgress()");
            }
            b.a a1 = i0.f;
            i0.f = a0;
            if(a1 != null) {
                i0.d(v, a0.d == 0, a0.c);
            }
            if(this.r != null && this.r.get() != null) {
                View view0 = (View)this.r.get();
                View view1 = this.w == null ? null : ((View)this.w.get());
                if(view1 != null) {
                    ViewGroup.MarginLayoutParams viewGroup$MarginLayoutParams0 = (ViewGroup.MarginLayoutParams)view1.getLayoutParams();
                    if(viewGroup$MarginLayoutParams0 != null) {
                        float f = (float)this.l;
                        float f1 = view0.getScaleX();
                        this.a.c0(viewGroup$MarginLayoutParams0, ((int)(f1 * f + ((float)this.o))));
                        view1.requestLayout();
                    }
                }
            }
        }
    }

    @Override  // u6.b
    public final void d() {
        i i0 = this.E;
        if(i0 == null) {
            return;
        }
        b.a a0 = i0.f;
        ValueAnimator.AnimatorUpdateListener valueAnimator$AnimatorUpdateListener0 = null;
        i0.f = null;
        int v = 5;
        if(a0 != null && Build.VERSION.SDK_INT >= 34) {
            if(this.a != null && this.a.K() != 0) {
                v = 3;
            }
            A6.h h0 = new A6.h(this, 0);
            View view0 = this.w == null ? null : ((View)this.w.get());
            if(view0 != null) {
                ViewGroup.MarginLayoutParams viewGroup$MarginLayoutParams0 = (ViewGroup.MarginLayoutParams)view0.getLayoutParams();
                if(viewGroup$MarginLayoutParams0 != null) {
                    valueAnimator$AnimatorUpdateListener0 = new f(this, viewGroup$MarginLayoutParams0, this.a.z(viewGroup$MarginLayoutParams0), view0);
                }
            }
            i0.c(a0, v, h0, valueAnimator$AnimatorUpdateListener0);
            return;
        }
        this.w(5);
    }

    @Override  // androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior
    public final void g(androidx.coordinatorlayout.widget.c c0) {
        this.r = null;
        this.i = null;
        this.E = null;
    }

    @Override  // androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior
    public final void j() {
        this.r = null;
        this.i = null;
        this.E = null;
    }

    @Override  // androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior
    public final boolean k(CoordinatorLayout coordinatorLayout0, View view0, MotionEvent motionEvent0) {
        if((view0.isShown() || W.e(view0) != null) && this.g) {
            int v = motionEvent0.getActionMasked();
            if(v == 0) {
                VelocityTracker velocityTracker0 = this.D;
                if(velocityTracker0 != null) {
                    velocityTracker0.recycle();
                    this.D = null;
                }
            }
            if(this.D == null) {
                this.D = VelocityTracker.obtain();
            }
            this.D.addMovement(motionEvent0);
            switch(v) {
                case 0: {
                    this.G = (int)motionEvent0.getX();
                    return !this.j && (this.i != null && this.i.t(motionEvent0));
                label_14:
                    if(v == 3) {
                        goto label_15;
                    }
                    break;
                }
                case 1: {
                label_15:
                    if(this.j) {
                        this.j = false;
                        return false;
                    }
                    break;
                }
                default: {
                    goto label_14;
                }
            }
            return !this.j && (this.i != null && this.i.t(motionEvent0));
        }
        this.j = true;
        return false;
    }

    @Override  // androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior
    public final boolean l(CoordinatorLayout coordinatorLayout0, View view0, int v) {
        if(coordinatorLayout0.getFitsSystemWindows() && !view0.getFitsSystemWindows()) {
            view0.setFitsSystemWindows(true);
        }
        z6.i i0 = this.b;
        int v1 = 0;
        if(this.r == null) {
            this.r = new WeakReference(view0);
            this.E = new i(view0);
            if(i0 == null) {
                ColorStateList colorStateList0 = this.c;
                if(colorStateList0 != null) {
                    M.j(view0, colorStateList0);
                }
            }
            else {
                view0.setBackground(i0);
                i0.l((this.f == -1.0f ? M.e(view0) : this.f));
            }
            int v2 = this.h == 5 ? 4 : 0;
            if(view0.getVisibility() != v2) {
                view0.setVisibility(v2);
            }
            this.A();
            if(view0.getImportantForAccessibility() == 0) {
                view0.setImportantForAccessibility(1);
            }
            if(W.e(view0) == null) {
                W.p(view0, "Side Sheet");
            }
        }
        int v3 = Gravity.getAbsoluteGravity(((androidx.coordinatorlayout.widget.c)view0.getLayoutParams()).c, v) == 3 ? 1 : 0;
        if(this.a == null || this.a.K() != v3) {
            androidx.coordinatorlayout.widget.c c0 = null;
            o o0 = this.d;
            if(v3 == 0) {
                this.a = new A6.a(this, 1);
                if(o0 != null) {
                    WeakReference weakReference0 = this.r;
                    if(weakReference0 != null) {
                        View view1 = (View)weakReference0.get();
                        if(view1 != null && view1.getLayoutParams() instanceof androidx.coordinatorlayout.widget.c) {
                            c0 = (androidx.coordinatorlayout.widget.c)view1.getLayoutParams();
                        }
                    }
                    if(c0 == null || c0.rightMargin <= 0) {
                        m m0 = o0.g();
                        m0.f = new z6.a(0.0f);
                        m0.g = new z6.a(0.0f);
                        o o1 = m0.a();
                        if(i0 != null) {
                            i0.setShapeAppearanceModel(o1);
                        }
                    }
                }
            }
            else {
                this.a = new A6.a(this, 0);
                if(o0 != null) {
                    WeakReference weakReference1 = this.r;
                    if(weakReference1 != null) {
                        View view2 = (View)weakReference1.get();
                        if(view2 != null && view2.getLayoutParams() instanceof androidx.coordinatorlayout.widget.c) {
                            c0 = (androidx.coordinatorlayout.widget.c)view2.getLayoutParams();
                        }
                    }
                    if(c0 == null || c0.leftMargin <= 0) {
                        m m1 = o0.g();
                        m1.e = new z6.a(0.0f);
                        m1.h = new z6.a(0.0f);
                        o o2 = m1.a();
                        if(i0 != null) {
                            i0.setShapeAppearanceModel(o2);
                        }
                    }
                }
            }
        }
        if(this.i == null) {
            this.i = new c(coordinatorLayout0.getContext(), coordinatorLayout0, this.M);
        }
        int v4 = this.a.I(view0);
        coordinatorLayout0.p(view0, v);
        this.m = coordinatorLayout0.getWidth();
        this.n = this.a.J(coordinatorLayout0);
        this.l = view0.getWidth();
        ViewGroup.MarginLayoutParams viewGroup$MarginLayoutParams0 = (ViewGroup.MarginLayoutParams)view0.getLayoutParams();
        this.o = viewGroup$MarginLayoutParams0 == null ? 0 : this.a.o(viewGroup$MarginLayoutParams0);
        int v5 = this.h;
        if(v5 == 1) {
            v1 = v4 - this.a.I(view0);
        }
        else {
            switch(v5) {
                case 2: {
                    v1 = v4 - this.a.I(view0);
                    break;
                }
                case 3: {
                    break;
                }
                case 5: {
                    v1 = this.a.D();
                    break;
                }
                default: {
                    throw new IllegalStateException("Unexpected value: " + this.h);
                }
            }
        }
        view0.offsetLeftAndRight(v1);
        if(this.w == null) {
            int v6 = this.B;
            if(v6 != -1) {
                View view3 = coordinatorLayout0.findViewById(v6);
                if(view3 != null) {
                    this.w = new WeakReference(view3);
                }
            }
        }
        for(Object object0: this.I) {
            j j0 = (j)object0;
            if(j0 instanceof j) {
                j0.getClass();
            }
        }
        return true;
    }

    @Override  // androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior
    public final boolean m(CoordinatorLayout coordinatorLayout0, View view0, int v, int v1, int v2) {
        ViewGroup.MarginLayoutParams viewGroup$MarginLayoutParams0 = (ViewGroup.MarginLayoutParams)view0.getLayoutParams();
        int v3 = coordinatorLayout0.getPaddingLeft();
        int v4 = ViewGroup.getChildMeasureSpec(v, coordinatorLayout0.getPaddingRight() + v3 + viewGroup$MarginLayoutParams0.leftMargin + viewGroup$MarginLayoutParams0.rightMargin + v1, viewGroup$MarginLayoutParams0.width);
        int v5 = coordinatorLayout0.getPaddingTop();
        view0.measure(v4, ViewGroup.getChildMeasureSpec(v2, coordinatorLayout0.getPaddingBottom() + v5 + viewGroup$MarginLayoutParams0.topMargin + viewGroup$MarginLayoutParams0.bottomMargin, viewGroup$MarginLayoutParams0.height));
        return true;
    }

    @Override  // androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior
    public final void r(View view0, Parcelable parcelable0) {
        int v = ((SavedState)parcelable0).c;
        if(v == 1 || v == 2) {
            v = 5;
        }
        this.h = v;
    }

    @Override  // androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior
    public final Parcelable s(View view0) {
        return new SavedState(this);
    }

    @Override  // androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior
    public final boolean v(CoordinatorLayout coordinatorLayout0, View view0, MotionEvent motionEvent0) {
        if(!view0.isShown()) {
            return false;
        }
        int v = motionEvent0.getActionMasked();
        if(this.h == 1 && v == 0) {
            return true;
        }
        if(this.y()) {
            this.i.m(motionEvent0);
        }
        if(v == 0) {
            VelocityTracker velocityTracker0 = this.D;
            if(velocityTracker0 != null) {
                velocityTracker0.recycle();
                this.D = null;
            }
        }
        if(this.D == null) {
            this.D = VelocityTracker.obtain();
        }
        this.D.addMovement(motionEvent0);
        if(this.y() && v == 2 && !this.j && this.y()) {
            float f = Math.abs(((float)this.G) - motionEvent0.getX());
            c c0 = this.i;
            if(f > ((float)c0.b)) {
                c0.c(view0, motionEvent0.getPointerId(motionEvent0.getActionIndex()));
            }
        }
        return !this.j;
    }

    public final void w(int v) {
        if(v == 1 || v == 2) {
            throw new IllegalArgumentException(x.m(new StringBuilder("STATE_"), (v == 1 ? "DRAGGING" : "SETTLING"), " should not be set externally."));
        }
        if(this.r != null && this.r.get() != null) {
            View view0 = (View)this.r.get();
            d d0 = new d(this, v, 0);
            ViewParent viewParent0 = view0.getParent();
            if(viewParent0 != null && viewParent0.isLayoutRequested() && view0.isAttachedToWindow()) {
                view0.post(d0);
                return;
            }
            d0.run();
            return;
        }
        this.x(v);
    }

    public final void x(int v) {
        if(this.h != v) {
            this.h = v;
            WeakReference weakReference0 = this.r;
            if(weakReference0 != null) {
                View view0 = (View)weakReference0.get();
                if(view0 != null) {
                    int v1 = this.h == 5 ? 4 : 0;
                    if(view0.getVisibility() != v1) {
                        view0.setVisibility(v1);
                    }
                    for(Object object0: this.I) {
                        j j0 = (j)object0;
                        if(v == 5) {
                            j0.a.cancel();
                        }
                        else {
                            j0.getClass();
                        }
                    }
                    this.A();
                }
            }
        }
    }

    public final boolean y() {
        return this.i != null && (this.g || this.h == 1);
    }

    public final void z(View view0, int v, boolean z) {
        int v1;
        switch(v) {
            case 3: {
                v1 = this.a.C();
                break;
            }
            case 5: {
                v1 = this.a.D();
                break;
            }
            default: {
                throw new IllegalArgumentException("Invalid state to get outer edge offset: " + v);
            }
        }
        c c0 = this.i;
        if(c0 != null) {
            if(!z) {
                if(c0.u(view0, v1, view0.getTop())) {
                    this.x(2);
                    this.e.a(v);
                    return;
                }
            }
            else if(c0.s(v1, view0.getTop())) {
                this.x(2);
                this.e.a(v);
                return;
            }
        }
        this.x(v);
    }
}

