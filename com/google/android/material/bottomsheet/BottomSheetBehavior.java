package com.google.android.material.bottomsheet;

import A6.g;
import A6.h;
import A6.i;
import Gf.l;
import T3.e;
import U4.x;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.RoundedCorner;
import android.view.VelocityTracker;
import android.view.View.AccessibilityDelegate;
import android.view.View.MeasureSpec;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;
import androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.customview.view.AbsSavedState;
import c2.M;
import c2.W;
import com.google.android.material.internal.B;
import e1.n;
import j2.c;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import u6.b;
import u6.f;
import z6.o;

public class BottomSheetBehavior extends Behavior implements b {
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator CREATOR;
        public final int c;
        public final int d;
        public final boolean e;
        public final boolean f;
        public final boolean g;

        static {
            SavedState.CREATOR = new a();  // 初始化器: Ljava/lang/Object;-><init>()V
        }

        public SavedState(Parcel parcel0, ClassLoader classLoader0) {
            super(parcel0, classLoader0);
            this.c = parcel0.readInt();
            this.d = parcel0.readInt();
            boolean z = false;
            this.e = parcel0.readInt() == 1;
            this.f = parcel0.readInt() == 1;
            if(parcel0.readInt() == 1) {
                z = true;
            }
            this.g = z;
        }

        public SavedState(BottomSheetBehavior bottomSheetBehavior0) {
            super(android.view.AbsSavedState.EMPTY_STATE);
            this.c = bottomSheetBehavior0.h0;
            this.d = bottomSheetBehavior0.e;
            this.e = bottomSheetBehavior0.b;
            this.f = bottomSheetBehavior0.e0;
            this.g = bottomSheetBehavior0.f0;
        }

        @Override  // androidx.customview.view.AbsSavedState
        public final void writeToParcel(Parcel parcel0, int v) {
            super.writeToParcel(parcel0, v);
            parcel0.writeInt(this.c);
            parcel0.writeInt(this.d);
            parcel0.writeInt(((int)this.e));
            parcel0.writeInt(((int)this.f));
            parcel0.writeInt(((int)this.g));
        }
    }

    public final SparseIntArray A0;
    public final boolean B;
    public final g B0;
    public final boolean D;
    public final boolean E;
    public final boolean G;
    public int I;
    public int M;
    public final boolean N;
    public final o S;
    public boolean T;
    public final i V;
    public final ValueAnimator W;
    public final int X;
    public int Y;
    public int Z;
    public final int a;
    public boolean b;
    public final float b0;
    public final float c;
    public int c0;
    public final int d;
    public final float d0;
    public int e;
    public boolean e0;
    public boolean f;
    public boolean f0;
    public int g;
    public boolean g0;
    public final int h;
    public int h0;
    public final z6.i i;
    public c i0;
    public final ColorStateList j;
    public boolean j0;
    public final int k;
    public int k0;
    public final int l;
    public boolean l0;
    public int m;
    public final float m0;
    public final boolean n;
    public int n0;
    public final boolean o;
    public int o0;
    public int p0;
    public WeakReference q0;
    public final boolean r;
    public WeakReference r0;
    public WeakReference s0;
    public final ArrayList t0;
    public VelocityTracker u0;
    public f v0;
    public final boolean w;
    public int w0;
    public int x0;
    public boolean y0;
    public HashMap z0;

    public BottomSheetBehavior() {
        this.a = 0;
        this.b = true;
        this.k = -1;
        this.l = -1;
        this.V = new i(this);
        this.b0 = 0.5f;
        this.d0 = -1.0f;
        this.g0 = true;
        this.h0 = 4;
        this.m0 = 0.1f;
        this.t0 = new ArrayList();
        this.x0 = -1;
        this.A0 = new SparseIntArray();
        this.B0 = new g(this, 1);
    }

    public BottomSheetBehavior(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.a = 0;
        this.b = true;
        this.k = -1;
        this.l = -1;
        this.V = new i(this);
        this.b0 = 0.5f;
        this.d0 = -1.0f;
        this.g0 = true;
        this.h0 = 4;
        this.m0 = 0.1f;
        this.t0 = new ArrayList();
        this.x0 = -1;
        this.A0 = new SparseIntArray();
        this.B0 = new g(this, 1);
        this.h = context0.getResources().getDimensionPixelSize(0x7F0703A3);  // dimen:mtrl_min_touch_target_size
        TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, d6.a.g);
        if(typedArray0.hasValue(3)) {
            this.j = n.r(context0, typedArray0, 3);
        }
        if(typedArray0.hasValue(21)) {
            this.S = o.d(context0, attributeSet0, 0x7F04009D, 0x7F1403BF).a();  // attr:bottomSheetStyle
        }
        o o0 = this.S;
        if(o0 != null) {
            z6.i i0 = new z6.i(o0);
            this.i = i0;
            i0.k(context0);
            ColorStateList colorStateList0 = this.j;
            if(colorStateList0 == null) {
                TypedValue typedValue0 = new TypedValue();
                context0.getTheme().resolveAttribute(0x1010031, typedValue0, true);
                this.i.setTint(typedValue0.data);
            }
            else {
                this.i.m(colorStateList0);
            }
        }
        ValueAnimator valueAnimator0 = ValueAnimator.ofFloat(new float[]{this.y(), 1.0f});
        this.W = valueAnimator0;
        valueAnimator0.setDuration(500L);
        D6.b b0 = new D6.b(this, 5);
        this.W.addUpdateListener(b0);
        this.d0 = typedArray0.getDimension(2, -1.0f);
        if(typedArray0.hasValue(0)) {
            this.k = typedArray0.getDimensionPixelSize(0, -1);
        }
        if(typedArray0.hasValue(1)) {
            this.l = typedArray0.getDimensionPixelSize(1, -1);
        }
        TypedValue typedValue1 = typedArray0.peekValue(9);
        if(typedValue1 == null || typedValue1.data != -1) {
            this.L(typedArray0.getDimensionPixelSize(9, -1));
        }
        else {
            this.L(-1);
        }
        this.K(typedArray0.getBoolean(8, false));
        this.n = typedArray0.getBoolean(13, false);
        this.J(typedArray0.getBoolean(6, true));
        this.f0 = typedArray0.getBoolean(12, false);
        this.g0 = typedArray0.getBoolean(4, true);
        this.a = typedArray0.getInt(10, 0);
        float f = typedArray0.getFloat(7, 0.5f);
        if(f <= 0.0f || f >= 1.0f) {
            throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
        }
        this.b0 = f;
        if(this.q0 != null) {
            this.Z = (int)((1.0f - f) * ((float)this.p0));
        }
        TypedValue typedValue2 = typedArray0.peekValue(5);
        if(typedValue2 != null && typedValue2.type == 16) {
            int v = typedValue2.data;
            if(v < 0) {
                throw new IllegalArgumentException("offset must be greater than or equal to 0");
            }
            this.X = v;
        }
        else {
            int v1 = typedArray0.getDimensionPixelOffset(5, 0);
            if(v1 < 0) {
                throw new IllegalArgumentException("offset must be greater than or equal to 0");
            }
            this.X = v1;
        }
        this.S(this.h0, true);
        this.d = typedArray0.getInt(11, 500);
        this.o = typedArray0.getBoolean(17, false);
        this.r = typedArray0.getBoolean(18, false);
        this.w = typedArray0.getBoolean(19, false);
        this.B = typedArray0.getBoolean(20, true);
        this.D = typedArray0.getBoolean(14, false);
        this.E = typedArray0.getBoolean(15, false);
        this.G = typedArray0.getBoolean(16, false);
        this.N = typedArray0.getBoolean(23, true);
        typedArray0.recycle();
        this.c = (float)ViewConfiguration.get(context0).getScaledMaximumFlingVelocity();
    }

    public final void A(View view0, int v) {
        if(view0 != null) {
            W.l(view0, 0x80000);
            W.i(view0, 0);
            W.l(view0, 0x40000);
            W.i(view0, 0);
            W.l(view0, 0x100000);
            W.i(view0, 0);
            SparseIntArray sparseIntArray0 = this.A0;
            int v1 = sparseIntArray0.get(v, -1);
            if(v1 != -1) {
                W.l(view0, v1);
                W.i(view0, 0);
                sparseIntArray0.delete(v);
            }
        }
    }

    public final void B(int v) {
        float f1;
        float f;
        View view0 = (View)this.q0.get();
        if(view0 != null) {
            ArrayList arrayList0 = this.t0;
            if(!arrayList0.isEmpty()) {
                if(v > this.c0 || this.c0 == this.F()) {
                    f = (float)(this.c0 - v);
                    f1 = (float)(this.p0 - this.c0);
                }
                else {
                    f = (float)(this.c0 - v);
                    f1 = (float)(this.c0 - this.F());
                }
                for(int v1 = 0; v1 < arrayList0.size(); ++v1) {
                    ((i6.a)arrayList0.get(v1)).onSlide(view0, f / f1);
                }
            }
        }
    }

    public static View C(View view0) {
        if(view0.getVisibility() == 0) {
            if(M.i(view0)) {
                return view0;
            }
            if(view0 instanceof ViewGroup) {
                int v = ((ViewGroup)view0).getChildCount();
                for(int v1 = 0; v1 < v; ++v1) {
                    View view1 = BottomSheetBehavior.C(((ViewGroup)view0).getChildAt(v1));
                    if(view1 != null) {
                        return view1;
                    }
                }
            }
        }
        return null;
    }

    public static BottomSheetBehavior D(View view0) {
        ViewGroup.LayoutParams viewGroup$LayoutParams0 = view0.getLayoutParams();
        if(!(viewGroup$LayoutParams0 instanceof androidx.coordinatorlayout.widget.c)) {
            throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
        }
        Behavior coordinatorLayout$Behavior0 = ((androidx.coordinatorlayout.widget.c)viewGroup$LayoutParams0).a;
        if(!(coordinatorLayout$Behavior0 instanceof BottomSheetBehavior)) {
            throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
        }
        return (BottomSheetBehavior)coordinatorLayout$Behavior0;
    }

    public static int E(int v, int v1, int v2, int v3) {
        int v4 = ViewGroup.getChildMeasureSpec(v, v1, v3);
        if(v2 == -1) {
            return v4;
        }
        int v5 = View.MeasureSpec.getMode(v4);
        int v6 = View.MeasureSpec.getSize(v4);
        if(v5 != 0x40000000) {
            if(v6 != 0) {
                v2 = Math.min(v6, v2);
            }
            return View.MeasureSpec.makeMeasureSpec(v2, 0x80000000);
        }
        return View.MeasureSpec.makeMeasureSpec(Math.min(v6, v2), 0x40000000);
    }

    public final int F() {
        if(this.b) {
            return this.Y;
        }
        return this.B ? Math.max(this.X, 0) : Math.max(this.X, this.M);
    }

    public final int G(int v) {
        switch(v) {
            case 3: {
                return this.F();
            }
            case 4: {
                return this.c0;
            }
            case 5: {
                return this.p0;
            }
            case 6: {
                return this.Z;
            }
            default: {
                throw new IllegalArgumentException("Invalid state to get top offset: " + v);
            }
        }
    }

    public final boolean H() {
        if(this.q0 != null && this.q0.get() != null) {
            int[] arr_v = new int[2];
            ((View)this.q0.get()).getLocationOnScreen(arr_v);
            return arr_v[1] == 0;
        }
        return false;
    }

    public final void I(BottomSheetDragHandleView bottomSheetDragHandleView0) {
        if(bottomSheetDragHandleView0 == null) {
            WeakReference weakReference0 = this.r0;
            if(weakReference0 != null) {
                this.A(((View)weakReference0.get()), 1);
                this.r0 = null;
                return;
            }
        }
        this.r0 = new WeakReference(bottomSheetDragHandleView0);
        this.R(bottomSheetDragHandleView0, 1);
    }

    public final void J(boolean z) {
        if(this.b == z) {
            return;
        }
        this.b = z;
        if(this.q0 != null) {
            this.x();
        }
        this.N((!this.b || this.h0 != 6 ? this.h0 : 3));
        this.S(this.h0, true);
        this.Q();
    }

    public final void K(boolean z) {
        if(this.e0 != z) {
            this.e0 = z;
            if(!z && this.h0 == 5) {
                this.M(4);
            }
            this.Q();
        }
    }

    public final void L(int v) {
        if(v == -1) {
            if(this.f) {
                return;
            }
            this.f = true;
        }
        else {
            if(!this.f && this.e == v) {
                return;
            }
            this.f = false;
            this.e = Math.max(0, v);
        }
        this.U();
    }

    public final void M(int v) {
        if(v == 1 || v == 2) {
            throw new IllegalArgumentException(x.m(new StringBuilder("STATE_"), (v == 1 ? "DRAGGING" : "SETTLING"), " should not be set externally."));
        }
        if(!this.e0 && v == 5) {
            x.u(5, "Cannot set state: ", "BottomSheetBehavior");
            return;
        }
        int v1 = v != 6 || !this.b || this.G(6) > this.Y ? v : 3;
        if(this.q0 != null && this.q0.get() != null) {
            Object object0 = this.q0.get();
            X4.i i0 = new X4.i(v1, 3, this, ((View)object0), false);
            ViewParent viewParent0 = ((View)object0).getParent();
            if(viewParent0 != null && viewParent0.isLayoutRequested() && ((View)object0).isAttachedToWindow()) {
                ((View)object0).post(i0);
                return;
            }
            i0.run();
            return;
        }
        this.N(v);
    }

    public final void N(int v) {
        if(this.h0 != v) {
            this.h0 = v;
            WeakReference weakReference0 = this.q0;
            if(weakReference0 != null) {
                View view0 = (View)weakReference0.get();
                if(view0 != null) {
                    if(v == 3) {
                        this.T(true);
                    }
                    else if(v == 4 || v == 5 || v == 6) {
                        this.T(false);
                    }
                    this.S(v, true);
                    for(int v1 = 0; true; ++v1) {
                        ArrayList arrayList0 = this.t0;
                        if(v1 >= arrayList0.size()) {
                            break;
                        }
                        ((i6.a)arrayList0.get(v1)).onStateChanged(view0, v);
                    }
                    this.Q();
                }
            }
        }
    }

    public final boolean O(View view0, float f) {
        if(this.f0) {
            return true;
        }
        if(view0.getTop() < this.c0) {
            return false;
        }
        int v = this.z();
        float f1 = (float)view0.getTop();
        return Math.abs(f * this.m0 + f1 - ((float)this.c0)) / ((float)v) > 0.5f;
    }

    public final void P(View view0, int v, boolean z) {
        int v1 = this.G(v);
        c c0 = this.i0;
        if(c0 != null) {
            if(!z) {
                if(c0.u(view0, view0.getLeft(), v1)) {
                    this.N(2);
                    this.S(v, true);
                    this.V.a(v);
                    return;
                }
            }
            else if(c0.s(view0.getLeft(), v1)) {
                this.N(2);
                this.S(v, true);
                this.V.a(v);
                return;
            }
        }
        this.N(v);
    }

    public final void Q() {
        WeakReference weakReference0 = this.q0;
        if(weakReference0 != null) {
            this.R(((View)weakReference0.get()), 0);
        }
        WeakReference weakReference1 = this.r0;
        if(weakReference1 != null) {
            this.R(((View)weakReference1.get()), 1);
        }
    }

    public final void R(View view0, int v) {
        c2.b b0;
        int v9;
        int v3;
        if(view0 != null) {
            this.A(view0, v);
            int v1 = 6;
            if(!this.b && this.h0 != 6) {
                e e0 = new e(this, 6);
                ArrayList arrayList0 = W.f(view0);
                for(int v2 = 0; true; ++v2) {
                    if(v2 >= arrayList0.size()) {
                        int v5 = -1;
                        for(int v4 = 0; true; ++v4) {
                            int[] arr_v = W.e;
                            if(v4 >= 0x20 || v5 != -1) {
                                break;
                            }
                            int v6 = arr_v[v4];
                            int v8 = 1;
                            for(int v7 = 0; v7 < arrayList0.size(); ++v7) {
                                v8 &= (((d2.c)arrayList0.get(v7)).a() == v6 ? 0 : 1);
                            }
                            if(v8 != 0) {
                                v5 = v6;
                            }
                        }
                        v3 = v5;
                        break;
                    }
                    if(TextUtils.equals("Expand halfway", ((AccessibilityNodeInfo.AccessibilityAction)((d2.c)arrayList0.get(v2)).a).getLabel())) {
                        v3 = ((d2.c)arrayList0.get(v2)).a();
                        break;
                    }
                }
                if(v3 == -1) {
                    v9 = -1;
                }
                else {
                    v9 = v3;
                    d2.c c0 = new d2.c(null, v9, "Expand halfway", e0, null);
                    View.AccessibilityDelegate view$AccessibilityDelegate0 = W.d(view0);
                    if(view$AccessibilityDelegate0 == null) {
                        b0 = null;
                    }
                    else {
                        b0 = view$AccessibilityDelegate0 instanceof c2.a ? ((c2.a)view$AccessibilityDelegate0).a : new c2.b(view$AccessibilityDelegate0);
                    }
                    if(b0 == null) {
                        b0 = new c2.b();
                    }
                    W.o(view0, b0);
                    W.l(view0, c0.a());
                    W.f(view0).add(c0);
                    W.i(view0, 0);
                }
                this.A0.put(v, v9);
            }
            if(this.e0 && this.h0 != 5) {
                e e1 = new e(this, 5);
                W.m(view0, d2.c.n, null, e1);
            }
            switch(this.h0) {
                case 3: {
                    if(this.b) {
                        v1 = 4;
                    }
                    e e2 = new e(this, v1);
                    W.m(view0, d2.c.m, null, e2);
                    return;
                }
                case 4: {
                    if(this.b) {
                        v1 = 3;
                    }
                    e e3 = new e(this, v1);
                    W.m(view0, d2.c.l, null, e3);
                    return;
                }
                case 6: {
                    e e4 = new e(this, 4);
                    W.m(view0, d2.c.m, null, e4);
                    e e5 = new e(this, 3);
                    W.m(view0, d2.c.l, null, e5);
                }
            }
        }
    }

    public final void S(int v, boolean z) {
        if(v != 2) {
            boolean z1 = this.h0 == 3 && (this.N || this.H());
            if(this.T != z1) {
                z6.i i0 = this.i;
                if(i0 != null) {
                    this.T = z1;
                    ValueAnimator valueAnimator0 = this.W;
                    float f = 1.0f;
                    if(z && valueAnimator0 != null) {
                        if(valueAnimator0.isRunning()) {
                            valueAnimator0.reverse();
                            return;
                        }
                        float f1 = i0.a.i;
                        if(z1) {
                            f = this.y();
                        }
                        valueAnimator0.setFloatValues(new float[]{f1, f});
                        valueAnimator0.start();
                        return;
                    }
                    if(valueAnimator0 != null && valueAnimator0.isRunning()) {
                        valueAnimator0.cancel();
                    }
                    if(this.T) {
                        f = this.y();
                    }
                    i0.n(f);
                }
            }
        }
    }

    public final void T(boolean z) {
        int v1;
        WeakReference weakReference0 = this.q0;
        if(weakReference0 != null) {
            ViewParent viewParent0 = ((View)weakReference0.get()).getParent();
            if(viewParent0 instanceof CoordinatorLayout) {
                int v = ((CoordinatorLayout)viewParent0).getChildCount();
                if(!z) {
                    v1 = 0;
                label_11:
                    while(v1 < v) {
                        View view0 = ((CoordinatorLayout)viewParent0).getChildAt(v1);
                        if(view0 != this.q0.get() && z) {
                            this.z0.put(view0, view0.getImportantForAccessibility());
                        }
                        ++v1;
                    }
                    if(!z) {
                        this.z0 = null;
                    }
                }
                else if(this.z0 == null) {
                    this.z0 = new HashMap(v);
                    v1 = 0;
                    goto label_11;
                }
            }
        }
    }

    public final void U() {
        if(this.q0 != null) {
            this.x();
            if(this.h0 == 4) {
                View view0 = (View)this.q0.get();
                if(view0 != null) {
                    view0.requestLayout();
                }
            }
        }
    }

    @Override  // u6.b
    public final void a(b.a a0) {
        f f0 = this.v0;
        if(f0 == null) {
            return;
        }
        f0.f = a0;
    }

    @Override  // u6.b
    public final void b() {
        f f0 = this.v0;
        if(f0 == null || f0.a() == null) {
            return;
        }
        AnimatorSet animatorSet0 = f0.b();
        animatorSet0.setDuration(((long)f0.e));
        animatorSet0.start();
    }

    @Override  // u6.b
    public final void c(b.a a0) {
        f f0 = this.v0;
        if(f0 != null) {
            if(f0.f == null) {
                Log.w("MaterialBackHelper", "Must call startBackProgress() before updateBackProgress()");
            }
            b.a a1 = f0.f;
            f0.f = a0;
            if(a1 != null) {
                f0.c(a0.c);
            }
        }
    }

    @Override  // u6.b
    public final void d() {
        f f0 = this.v0;
        if(f0 == null) {
            return;
        }
        int v = f0.d;
        int v1 = f0.c;
        b.a a0 = f0.f;
        f0.f = null;
        int v2 = 4;
        if(a0 != null) {
            float f1 = a0.c;
            if(Build.VERSION.SDK_INT >= 34) {
                if(this.e0) {
                    h h0 = new h(this, 9);
                    float f2 = (float)f0.b.getHeight();
                    float[] arr_f = {f0.b.getScaleY() * f2};
                    ObjectAnimator objectAnimator0 = ObjectAnimator.ofFloat(f0.b, View.TRANSLATION_Y, arr_f);
                    objectAnimator0.setInterpolator(new P2.a(1));
                    objectAnimator0.setDuration(((long)e6.a.c(v1, v, f1)));
                    objectAnimator0.addListener(new h(f0, 11));
                    objectAnimator0.addListener(h0);
                    objectAnimator0.start();
                    return;
                }
                AnimatorSet animatorSet0 = f0.b();
                animatorSet0.setDuration(((long)e6.a.c(v1, v, f1)));
                animatorSet0.start();
                this.M(4);
                return;
            }
        }
        if(this.e0) {
            v2 = 5;
        }
        this.M(v2);
    }

    @Override  // androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior
    public final void g(androidx.coordinatorlayout.widget.c c0) {
        this.q0 = null;
        this.i0 = null;
        this.v0 = null;
    }

    @Override  // androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior
    public final void j() {
        this.q0 = null;
        this.i0 = null;
        this.v0 = null;
    }

    @Override  // androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior
    public boolean k(CoordinatorLayout coordinatorLayout0, View view0, MotionEvent motionEvent0) {
        if(view0.isShown() && this.g0) {
            int v = motionEvent0.getActionMasked();
            View view1 = null;
            if(v == 0) {
                this.w0 = -1;
                this.x0 = -1;
                VelocityTracker velocityTracker0 = this.u0;
                if(velocityTracker0 != null) {
                    velocityTracker0.recycle();
                    this.u0 = null;
                }
            }
            if(this.u0 == null) {
                this.u0 = VelocityTracker.obtain();
            }
            this.u0.addMovement(motionEvent0);
            switch(v) {
                case 0: {
                    int v1 = (int)motionEvent0.getX();
                    this.x0 = (int)motionEvent0.getY();
                    if(this.h0 != 2) {
                        View view2 = this.s0 == null ? null : ((View)this.s0.get());
                        if(view2 != null && coordinatorLayout0.n(view2, v1, this.x0)) {
                            this.w0 = motionEvent0.getPointerId(motionEvent0.getActionIndex());
                            this.y0 = true;
                        }
                    }
                    this.j0 = this.w0 == -1 && !coordinatorLayout0.n(view0, v1, this.x0);
                    break;
                }
                case 1: {
                label_25:
                    this.y0 = false;
                    this.w0 = -1;
                    if(this.j0) {
                        this.j0 = false;
                        return false;
                    }
                    break;
                }
                default: {
                    if(v == 3) {
                        goto label_25;
                    }
                }
            }
            if(this.j0 || (this.i0 == null || !this.i0.t(motionEvent0))) {
                WeakReference weakReference0 = this.s0;
                if(weakReference0 != null) {
                    view1 = (View)weakReference0.get();
                }
                return v == 2 && view1 != null && !this.j0 && this.h0 != 1 && !coordinatorLayout0.n(view1, ((int)motionEvent0.getX()), ((int)motionEvent0.getY())) && this.i0 != null && (this.x0 != -1 && Math.abs(((float)this.x0) - motionEvent0.getY()) > ((float)this.i0.b));
            }
            return true;
        }
        this.j0 = true;
        return false;
    }

    @Override  // androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior
    public final boolean l(CoordinatorLayout coordinatorLayout0, View view0, int v) {
        if(coordinatorLayout0.getFitsSystemWindows() && !view0.getFitsSystemWindows()) {
            view0.setFitsSystemWindows(true);
        }
        if(this.q0 == null) {
            this.g = coordinatorLayout0.getResources().getDimensionPixelSize(0x7F0700C2);  // dimen:design_bottom_sheet_peek_height_min
            boolean z = Build.VERSION.SDK_INT >= 29 && !this.n && !this.f;
            if(this.o || this.r || this.w || this.D || this.E || this.G || z) {
                B.f(view0, new l(this, z, 7));
            }
            W.q(view0, new i6.e(view0));
            this.q0 = new WeakReference(view0);
            this.v0 = new f(view0);
            z6.i i0 = this.i;
            if(i0 == null) {
                ColorStateList colorStateList0 = this.j;
                if(colorStateList0 != null) {
                    M.j(view0, colorStateList0);
                }
            }
            else {
                view0.setBackground(i0);
                i0.l((this.d0 == -1.0f ? M.e(view0) : this.d0));
            }
            this.Q();
            if(view0.getImportantForAccessibility() == 0) {
                view0.setImportantForAccessibility(1);
            }
        }
        if(this.i0 == null) {
            this.i0 = new c(coordinatorLayout0.getContext(), coordinatorLayout0, this.B0);
        }
        int v2 = view0.getTop();
        coordinatorLayout0.p(view0, v);
        this.o0 = coordinatorLayout0.getWidth();
        this.p0 = coordinatorLayout0.getHeight();
        int v3 = view0.getHeight();
        this.n0 = v3;
        int v4 = this.p0;
        int v5 = this.M;
        if(v4 - v3 < v5) {
            int v6 = this.l;
            if(this.B) {
                if(v6 != -1) {
                    v4 = Math.min(v4, v6);
                }
                this.n0 = v4;
            }
            else {
                this.n0 = v6 == -1 ? v4 - v5 : Math.min(v4 - v5, v6);
            }
        }
        this.Y = Math.max(0, this.p0 - this.n0);
        this.Z = (int)((1.0f - this.b0) * ((float)this.p0));
        this.x();
        int v7 = this.h0;
        if(v7 == 3) {
            view0.offsetTopAndBottom(this.F());
        }
        else if(v7 == 6) {
            view0.offsetTopAndBottom(this.Z);
        }
        else if(!this.e0 || v7 != 5) {
            switch(v7) {
                case 1: 
                case 2: {
                    view0.offsetTopAndBottom(v2 - view0.getTop());
                    break;
                }
                case 4: {
                    view0.offsetTopAndBottom(this.c0);
                }
            }
        }
        else {
            view0.offsetTopAndBottom(this.p0);
        }
        this.S(this.h0, false);
        this.s0 = new WeakReference(BottomSheetBehavior.C(view0));
        for(int v1 = 0; true; ++v1) {
            ArrayList arrayList0 = this.t0;
            if(v1 >= arrayList0.size()) {
                break;
            }
            ((i6.a)arrayList0.get(v1)).a(view0);
        }
        return true;
    }

    @Override  // androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior
    public final boolean m(CoordinatorLayout coordinatorLayout0, View view0, int v, int v1, int v2) {
        ViewGroup.MarginLayoutParams viewGroup$MarginLayoutParams0 = (ViewGroup.MarginLayoutParams)view0.getLayoutParams();
        int v3 = coordinatorLayout0.getPaddingLeft();
        int v4 = BottomSheetBehavior.E(v, coordinatorLayout0.getPaddingRight() + v3 + viewGroup$MarginLayoutParams0.leftMargin + viewGroup$MarginLayoutParams0.rightMargin + v1, this.k, viewGroup$MarginLayoutParams0.width);
        int v5 = coordinatorLayout0.getPaddingTop();
        view0.measure(v4, BottomSheetBehavior.E(v2, coordinatorLayout0.getPaddingBottom() + v5 + viewGroup$MarginLayoutParams0.topMargin + viewGroup$MarginLayoutParams0.bottomMargin, this.l, viewGroup$MarginLayoutParams0.height));
        return true;
    }

    @Override  // androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior
    public final boolean n(View view0) {
        return this.s0 != null && view0 == this.s0.get() && this.h0 != 3;
    }

    @Override  // androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior
    public final void o(CoordinatorLayout coordinatorLayout0, View view0, View view1, int v, int v1, int[] arr_v, int v2) {
        if(v2 != 1 && view1 == (this.s0 == null ? null : ((View)this.s0.get()))) {
            int v3 = view0.getTop();
            int v4 = v3 - v1;
            if(v1 > 0) {
                if(v4 < this.F()) {
                    int v5 = v3 - this.F();
                    arr_v[1] = v5;
                    view0.offsetTopAndBottom(-v5);
                    this.N(3);
                    this.B(view0.getTop());
                    this.k0 = v1;
                    this.l0 = true;
                    return;
                }
                if(this.g0) {
                    arr_v[1] = v1;
                    view0.offsetTopAndBottom(-v1);
                    this.N(1);
                    this.B(view0.getTop());
                    this.k0 = v1;
                    this.l0 = true;
                }
            }
            else {
                if(v1 >= 0 || view1.canScrollVertically(-1)) {
                    this.B(view0.getTop());
                    this.k0 = v1;
                    this.l0 = true;
                    return;
                }
                int v6 = this.c0;
                boolean z = false;
                if(v4 > v6 && !this.e0) {
                    z = true;
                    int v7 = v3 - v6;
                    arr_v[1] = v7;
                    view0.offsetTopAndBottom(-v7);
                    this.N(4);
                }
                else if(this.g0) {
                    z = true;
                    arr_v[1] = v1;
                    view0.offsetTopAndBottom(-v1);
                    this.N(1);
                }
                if(z) {
                    this.B(view0.getTop());
                    this.k0 = v1;
                    this.l0 = true;
                }
            }
        }
    }

    @Override  // androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior
    public final void p(CoordinatorLayout coordinatorLayout0, View view0, int v, int v1, int v2, int[] arr_v) {
    }

    @Override  // androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior
    public final void r(View view0, Parcelable parcelable0) {
        int v = this.a;
        if(v != 0) {
            if(v == -1 || (v & 1) == 1) {
                this.e = ((SavedState)parcelable0).d;
            }
            if(v == -1 || (v & 2) == 2) {
                this.b = ((SavedState)parcelable0).e;
            }
            if(v == -1 || (v & 4) == 4) {
                this.e0 = ((SavedState)parcelable0).f;
            }
            if(v == -1 || (v & 8) == 8) {
                this.f0 = ((SavedState)parcelable0).g;
            }
        }
        int v1 = ((SavedState)parcelable0).c;
        if(v1 != 1 && v1 != 2) {
            this.h0 = v1;
            return;
        }
        this.h0 = 4;
    }

    @Override  // androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior
    public final Parcelable s(View view0) {
        return new SavedState(this);
    }

    @Override  // androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior
    public final boolean t(CoordinatorLayout coordinatorLayout0, View view0, View view1, View view2, int v, int v1) {
        this.k0 = 0;
        this.l0 = false;
        return (v & 2) != 0;
    }

    @Override  // androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior
    public final void u(CoordinatorLayout coordinatorLayout0, View view0, View view1, int v) {
        float f;
        int v1 = 3;
        if(view0.getTop() == this.F()) {
            this.N(3);
            return;
        }
        if(this.s0 != null && view1 == this.s0.get() && this.l0) {
            if(this.k0 <= 0) {
                if(this.e0) {
                    VelocityTracker velocityTracker0 = this.u0;
                    if(velocityTracker0 == null) {
                        f = 0.0f;
                    }
                    else {
                        velocityTracker0.computeCurrentVelocity(1000, this.c);
                        f = this.u0.getYVelocity(this.w0);
                    }
                    if(this.O(view0, f)) {
                        v1 = 5;
                        this.P(view0, v1, false);
                        this.l0 = false;
                        return;
                    }
                    goto label_19;
                }
                else {
                label_19:
                    if(this.k0 == 0) {
                        int v2 = view0.getTop();
                        if(!this.b) {
                            int v3 = this.Z;
                            if(v2 >= v3) {
                                v1 = Math.abs(v2 - v3) < Math.abs(v2 - this.c0) ? 6 : 4;
                            }
                            else if(v2 >= Math.abs(v2 - this.c0)) {
                                v1 = 6;
                            }
                        }
                        else if(Math.abs(v2 - this.Y) >= Math.abs(v2 - this.c0)) {
                            v1 = 4;
                        }
                    }
                    else if(this.b) {
                        v1 = 4;
                    }
                    else {
                        int v4 = view0.getTop();
                        v1 = Math.abs(v4 - this.Z) < Math.abs(v4 - this.c0) ? 6 : 4;
                    }
                }
            }
            else if(!this.b && view0.getTop() > this.Z) {
                v1 = 6;
            }
            this.P(view0, v1, false);
            this.l0 = false;
        }
    }

    @Override  // androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior
    public final boolean v(CoordinatorLayout coordinatorLayout0, View view0, MotionEvent motionEvent0) {
        if(!view0.isShown()) {
            return false;
        }
        int v = motionEvent0.getActionMasked();
        int v1 = this.h0;
        if(v1 == 1 && v == 0) {
            return true;
        }
        c c0 = this.i0;
        if(c0 != null && (this.g0 || v1 == 1)) {
            c0.m(motionEvent0);
        }
        if(v == 0) {
            this.w0 = -1;
            this.x0 = -1;
            VelocityTracker velocityTracker0 = this.u0;
            if(velocityTracker0 != null) {
                velocityTracker0.recycle();
                this.u0 = null;
            }
        }
        if(this.u0 == null) {
            this.u0 = VelocityTracker.obtain();
        }
        this.u0.addMovement(motionEvent0);
        if(this.i0 != null && (this.g0 || this.h0 == 1) && v == 2 && !this.j0) {
            float f = Math.abs(((float)this.x0) - motionEvent0.getY());
            c c1 = this.i0;
            if(f > ((float)c1.b)) {
                c1.c(view0, motionEvent0.getPointerId(motionEvent0.getActionIndex()));
            }
        }
        return !this.j0;
    }

    public final void w(i6.a a0) {
        ArrayList arrayList0 = this.t0;
        if(!arrayList0.contains(a0)) {
            arrayList0.add(a0);
        }
    }

    public final void x() {
        int v = this.z();
        if(this.b) {
            this.c0 = Math.max(this.p0 - v, this.Y);
            return;
        }
        this.c0 = this.p0 - v;
    }

    public final float y() {
        float f3;
        float f = 0.0f;
        if(this.i != null && (this.q0 != null && this.q0.get() != null && Build.VERSION.SDK_INT >= 0x1F)) {
            View view0 = (View)this.q0.get();
            if(this.H()) {
                WindowInsets windowInsets0 = view0.getRootWindowInsets();
                if(windowInsets0 != null) {
                    float f1 = this.i.i();
                    RoundedCorner roundedCorner0 = i3.i.k(windowInsets0);
                    if(roundedCorner0 == null) {
                        f3 = 0.0f;
                    }
                    else {
                        float f2 = (float)roundedCorner0.getRadius();
                        f3 = f2 <= 0.0f || f1 <= 0.0f ? 0.0f : f2 / f1;
                    }
                    float f4 = this.i.a.a.f.a(this.i.g());
                    RoundedCorner roundedCorner1 = i3.i.C(windowInsets0);
                    if(roundedCorner1 != null) {
                        float f5 = (float)roundedCorner1.getRadius();
                        if(f5 > 0.0f && f4 > 0.0f) {
                            f = f5 / f4;
                        }
                    }
                    return Math.max(f3, f);
                }
            }
        }
        return 0.0f;
    }

    public final int z() {
        if(this.f) {
            return Math.min(Math.max(this.g, this.p0 - this.o0 * 9 / 16), this.n0) + this.I;
        }
        if(!this.n && !this.o) {
            return this.m <= 0 ? this.e + this.I : Math.max(this.e, this.m + this.h);
        }
        return this.e + this.I;
    }
}

