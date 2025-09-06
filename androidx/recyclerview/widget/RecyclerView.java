package androidx.recyclerview.widget;

import Q0.Y0;
import Q1.c;
import U4.x;
import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import android.os.SystemClock;
import android.os.Trace;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View.MeasureSpec;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.appcompat.app.o;
import androidx.collection.V;
import androidx.collection.s;
import androidx.core.widget.EdgeEffectCompat;
import androidx.customview.view.AbsSavedState;
import c2.P;
import c2.W;
import c2.h;
import c2.q;
import c2.r;
import d5.l;
import e.k;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import x4.a;

public class RecyclerView extends ViewGroup implements q {
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public O0 a;
        public final Rect b;
        public boolean c;
        public boolean d;

        public LayoutParams(int v, int v1) {
            super(v, v1);
            this.b = new Rect();
            this.c = true;
            this.d = false;
        }

        public LayoutParams(Context context0, AttributeSet attributeSet0) {
            super(context0, attributeSet0);
            this.b = new Rect();
            this.c = true;
            this.d = false;
        }

        public LayoutParams(ViewGroup.LayoutParams viewGroup$LayoutParams0) {
            super(viewGroup$LayoutParams0);
            this.b = new Rect();
            this.c = true;
            this.d = false;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams viewGroup$MarginLayoutParams0) {
            super(viewGroup$MarginLayoutParams0);
            this.b = new Rect();
            this.c = true;
            this.d = false;
        }

        public LayoutParams(LayoutParams recyclerView$LayoutParams0) {
            super(recyclerView$LayoutParams0);
            this.b = new Rect();
            this.c = true;
            this.d = false;
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator CREATOR;
        public Parcelable c;

        static {
            SavedState.CREATOR = new G0();  // 初始化器: Ljava/lang/Object;-><init>()V
        }

        public SavedState(Parcel parcel0, ClassLoader classLoader0) {
            super(parcel0, classLoader0);
            if(classLoader0 == null) {
                classLoader0 = w0.class.getClassLoader();
            }
            this.c = parcel0.readParcelable(classLoader0);
        }

        @Override  // androidx.customview.view.AbsSavedState
        public final void writeToParcel(Parcel parcel0, int v) {
            super.writeToParcel(parcel0, v);
            parcel0.writeParcelable(this.c, 0);
        }
    }

    public final N0 A0;
    public z0 B;
    public F B0;
    public final D C0;
    public boolean D;
    public final K0 D0;
    public boolean E;
    public A0 E0;
    public ArrayList F0;
    public boolean G;
    public boolean G0;
    public boolean H0;
    public static final int HORIZONTAL = 0;
    public int I;
    public final h0 I0;
    public static final int INVALID_TYPE = -1;
    public boolean J0;
    public Q0 K0;
    public final int[] L0;
    public boolean M;
    public r M0;
    public boolean N;
    public final int[] N0;
    public static final long NO_ID = -1L;
    public static final int NO_POSITION = -1;
    public final int[] O0;
    public final int[] P0;
    public final ArrayList Q0;
    public final g0 R0;
    public boolean S;
    public boolean S0;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    public int T;
    public int T0;
    public static final int TOUCH_SLOP_DEFAULT = 0;
    public static final int TOUCH_SLOP_PAGING = 1;
    public int U0;
    public static final int UNDEFINED_DURATION = 0x80000000;
    public boolean V;
    public final boolean V0;
    public static final int VERTICAL = 1;
    public final AccessibilityManager W;
    public final h0 W0;
    public final h X0;
    public static boolean Y0 = false;
    public static boolean Z0 = false;
    public final float a;
    public static final int[] a1;
    public final F0 b;
    public ArrayList b0;
    public static final float b1;
    public final D0 c;
    public boolean c0;
    public static final boolean c1;
    public SavedState d;
    public boolean d0;
    public static final boolean d1;
    public final b e;
    public int e0;
    public static final Class[] e1;
    public final j f;
    public int f0;
    public static final K f1;
    public final l g;
    public o0 g0;
    public static final L0 g1;
    public boolean h;
    public EdgeEffect h0;
    public final g0 i;
    public EdgeEffect i0;
    public final Rect j;
    public EdgeEffect j0;
    public final Rect k;
    public EdgeEffect k0;
    public final RectF l;
    public q0 l0;
    public j0 m;
    public int m0;
    public w0 n;
    public int n0;
    public final ArrayList o;
    public VelocityTracker o0;
    public int p0;
    public int q0;
    public final ArrayList r;
    public int r0;
    public int s0;
    public int t0;
    public y0 u0;
    public final int v0;
    public final ArrayList w;
    public final int w0;
    public final float x0;
    public final float y0;
    public boolean z0;

    static {
        RecyclerView.a1 = new int[]{0x1010436};
        RecyclerView.b1 = 2.358202f;
        RecyclerView.c1 = true;
        RecyclerView.d1 = true;
        RecyclerView.e1 = new Class[]{Context.class, AttributeSet.class, Integer.TYPE, Integer.TYPE};
        RecyclerView.f1 = new K(2);
        RecyclerView.g1 = new L0();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public RecyclerView(Context context0) {
        this(context0, null);
    }

    public RecyclerView(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0x7F040502);  // attr:recyclerViewStyle
    }

    public RecyclerView(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        Constructor constructor0;
        TypedArray typedArray1;
        this.b = new F0(this);
        this.c = new D0(this);
        this.g = new l(6);
        this.i = new g0(this, 0);
        this.j = new Rect();
        this.k = new Rect();
        this.l = new RectF();
        this.o = new ArrayList();
        this.r = new ArrayList();
        this.w = new ArrayList();
        this.I = 0;
        this.c0 = false;
        this.d0 = false;
        this.e0 = 0;
        this.f0 = 0;
        this.g0 = RecyclerView.g1;
        androidx.recyclerview.widget.q q0 = new androidx.recyclerview.widget.q();  // 初始化器: Ljava/lang/Object;-><init>()V
        Object[] arr_object = null;
        q0.a = null;
        q0.b = new ArrayList();
        q0.c = 120L;
        q0.d = 120L;
        q0.e = 0xFAL;
        q0.f = 0xFAL;
        q0.g = true;
        q0.h = new ArrayList();
        q0.i = new ArrayList();
        q0.j = new ArrayList();
        q0.k = new ArrayList();
        q0.l = new ArrayList();
        q0.m = new ArrayList();
        q0.n = new ArrayList();
        q0.o = new ArrayList();
        q0.p = new ArrayList();
        q0.q = new ArrayList();
        q0.r = new ArrayList();
        this.l0 = q0;
        this.m0 = 0;
        this.n0 = -1;
        this.x0 = 1.401298E-45f;
        this.y0 = 1.401298E-45f;
        this.z0 = true;
        this.A0 = new N0(this);
        this.C0 = new D();  // 初始化器: Ljava/lang/Object;-><init>()V
        K0 k00 = new K0();  // 初始化器: Ljava/lang/Object;-><init>()V
        k00.a = -1;
        k00.b = 0;
        k00.c = 0;
        k00.d = 1;
        k00.e = 0;
        k00.f = false;
        k00.g = false;
        k00.h = false;
        k00.i = false;
        k00.j = false;
        k00.k = false;
        this.D0 = k00;
        this.G0 = false;
        this.H0 = false;
        h0 h00 = new h0(this);
        this.I0 = h00;
        this.J0 = false;
        this.L0 = new int[2];
        this.N0 = new int[2];
        this.O0 = new int[2];
        this.P0 = new int[2];
        this.Q0 = new ArrayList();
        this.R0 = new g0(this, 1);
        this.T0 = 0;
        this.U0 = 0;
        this.W0 = new h0(this);
        h0 h01 = new h0(this);
        this.X0 = new h(this.getContext(), h01);
        this.setScrollContainer(true);
        this.setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration0 = ViewConfiguration.get(context0);
        this.t0 = viewConfiguration0.getScaledTouchSlop();
        this.x0 = viewConfiguration0.getScaledHorizontalScrollFactor();
        this.y0 = viewConfiguration0.getScaledVerticalScrollFactor();
        this.v0 = viewConfiguration0.getScaledMinimumFlingVelocity();
        this.w0 = viewConfiguration0.getScaledMaximumFlingVelocity();
        this.a = context0.getResources().getDisplayMetrics().density * 51890.199219f;
        this.setWillNotDraw(this.getOverScrollMode() == 2);
        this.l0.a = h00;
        this.e = new b(new h0(this));
        this.f = new j(new h0(this));
        if(P.a(this) == 0) {
            P.b(this, 8);
        }
        if(this.getImportantForAccessibility() == 0) {
            this.setImportantForAccessibility(1);
        }
        this.W = (AccessibilityManager)this.getContext().getSystemService("accessibility");
        this.setAccessibilityDelegateCompat(new Q0(this));
        TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, a.a, v, 0);
        W.n(this, context0, a.a, attributeSet0, typedArray0, v);
        String s = typedArray0.getString(8);
        if(typedArray0.getInt(2, -1) == -1) {
            this.setDescendantFocusability(0x40000);
        }
        this.h = typedArray0.getBoolean(1, true);
        if(typedArray0.getBoolean(3, false)) {
            StateListDrawable stateListDrawable0 = (StateListDrawable)typedArray0.getDrawable(6);
            Drawable drawable0 = typedArray0.getDrawable(7);
            StateListDrawable stateListDrawable1 = (StateListDrawable)typedArray0.getDrawable(4);
            Drawable drawable1 = typedArray0.getDrawable(5);
            if(stateListDrawable0 == null || drawable0 == null || stateListDrawable1 == null || drawable1 == null) {
                throw new IllegalArgumentException(o.l(this, new StringBuilder("Trying to set fast scroller without both required drawables.")));
            }
            Resources resources0 = this.getContext().getResources();
            typedArray1 = typedArray0;
            new C(this, stateListDrawable0, drawable0, stateListDrawable1, drawable1, resources0.getDimensionPixelSize(0x7F070116), resources0.getDimensionPixelSize(0x7F070118), resources0.getDimensionPixelOffset(0x7F070117));  // dimen:fastscroll_default_thickness
        }
        else {
            typedArray1 = typedArray0;
        }
        typedArray1.recycle();
        this.V0 = context0.getPackageManager().hasSystemFeature("android.hardware.rotaryencoder.lowres");
        if(s != null) {
            String s1 = s.trim();
            if(!s1.isEmpty()) {
                if(s1.charAt(0) == 46) {
                    s1 = "com.iloen.melon" + s1;
                }
                else if(!s1.contains(".")) {
                    s1 = RecyclerView.class.getPackage().getName() + '.' + s1;
                }
                try {
                    Class class0 = Class.forName(s1, false, (this.isInEditMode() ? this.getClass().getClassLoader() : context0.getClassLoader())).asSubclass(w0.class);
                    try {
                        constructor0 = class0.getConstructor(RecyclerView.e1);
                        arr_object = new Object[]{context0, attributeSet0, v, 0};
                    }
                    catch(NoSuchMethodException noSuchMethodException0) {
                        try {
                            constructor0 = class0.getConstructor(null);
                        }
                        catch(NoSuchMethodException noSuchMethodException1) {
                            noSuchMethodException1.initCause(noSuchMethodException0);
                            throw new IllegalStateException(attributeSet0.getPositionDescription() + ": Error creating LayoutManager " + s1, noSuchMethodException1);
                        }
                    }
                    constructor0.setAccessible(true);
                    this.setLayoutManager(((w0)constructor0.newInstance(arr_object)));
                    goto label_148;
                }
                catch(ClassNotFoundException classNotFoundException0) {
                }
                catch(InvocationTargetException invocationTargetException0) {
                    throw new IllegalStateException(attributeSet0.getPositionDescription() + ": Could not instantiate the LayoutManager: " + s1, invocationTargetException0);
                }
                catch(InstantiationException instantiationException0) {
                    throw new IllegalStateException(attributeSet0.getPositionDescription() + ": Could not instantiate the LayoutManager: " + s1, instantiationException0);
                }
                catch(IllegalAccessException illegalAccessException0) {
                    throw new IllegalStateException(attributeSet0.getPositionDescription() + ": Cannot access non-public constructor " + s1, illegalAccessException0);
                }
                catch(ClassCastException classCastException0) {
                    throw new IllegalStateException(attributeSet0.getPositionDescription() + ": Class is not a LayoutManager " + s1, classCastException0);
                }
                throw new IllegalStateException(attributeSet0.getPositionDescription() + ": Unable to find LayoutManager " + s1, classNotFoundException0);
            }
        }
    label_148:
        TypedArray typedArray2 = context0.obtainStyledAttributes(attributeSet0, RecyclerView.a1, v, 0);
        W.n(this, context0, RecyclerView.a1, attributeSet0, typedArray2, v);
        boolean z = typedArray2.getBoolean(0, true);
        typedArray2.recycle();
        this.setNestedScrollingEnabled(z);
        this.setTag(0x7F0A0593, Boolean.TRUE);  // id:is_pooling_container_tag
    }

    public final boolean A(MotionEvent motionEvent0) {
        int v = motionEvent0.getAction();
        ArrayList arrayList0 = this.w;
        int v1 = arrayList0.size();
        for(int v2 = 0; v2 < v1; ++v2) {
            z0 z00 = (z0)arrayList0.get(v2);
            if(z00.onInterceptTouchEvent(this, motionEvent0) && v != 3) {
                this.B = z00;
                return true;
            }
        }
        return false;
    }

    public final void B(int[] arr_v) {
        int v = this.f.e();
        if(v == 0) {
            arr_v[0] = -1;
            arr_v[1] = -1;
            return;
        }
        int v1 = 0x7FFFFFFF;
        int v2 = 0x80000000;
        for(int v3 = 0; v3 < v; ++v3) {
            O0 o00 = RecyclerView.H(this.f.d(v3));
            if(!o00.shouldIgnore()) {
                int v4 = o00.getLayoutPosition();
                if(v4 < v1) {
                    v1 = v4;
                }
                if(v4 > v2) {
                    v2 = v4;
                }
            }
        }
        arr_v[0] = v1;
        arr_v[1] = v2;
    }

    public static RecyclerView C(View view0) {
        if(!(view0 instanceof ViewGroup)) {
            return null;
        }
        if(view0 instanceof RecyclerView) {
            return (RecyclerView)view0;
        }
        int v = ((ViewGroup)view0).getChildCount();
        for(int v1 = 0; v1 < v; ++v1) {
            RecyclerView recyclerView0 = RecyclerView.C(((ViewGroup)view0).getChildAt(v1));
            if(recyclerView0 != null) {
                return recyclerView0;
            }
        }
        return null;
    }

    public final O0 D(int v, boolean z) {
        int v1 = this.f.h();
        O0 o00 = null;
        int v2 = 0;
        while(v2 < v1) {
            O0 o01 = RecyclerView.H(this.f.g(v2));
            if(o01 != null && !o01.isRemoved()) {
                if(z) {
                    if(o01.mPosition == v) {
                        goto label_10;
                    }
                    else {
                        goto label_14;
                    }
                    goto label_9;
                }
                else {
                label_9:
                    if(o01.getLayoutPosition() == v) {
                    label_10:
                        if(this.f.c.contains(o01.itemView)) {
                            o00 = o01;
                            goto label_14;
                        }
                        return o01;
                    }
                }
            }
        label_14:
            ++v2;
        }
        return o00;
    }

    public final boolean E(int v, int v1, int v2, int v3) {
        int v20;
        int v17;
        int v16;
        int v14;
        boolean z3;
        d0 d00;
        int v7;
        int v6;
        w0 w00 = this.n;
        if(w00 == null) {
            Log.e("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        }
        if(!this.N) {
            boolean z = w00.canScrollHorizontally();
            boolean z1 = this.n.canScrollVertically();
            int v4 = !z || Math.abs(v) < v2 ? 0 : v;
            int v5 = !z1 || Math.abs(v1) < v2 ? 0 : v1;
            if(v4 != 0 || v5 != 0) {
                if(v4 == 0) {
                    v6 = 0;
                }
                else if(this.h0 != null && EdgeEffectCompat.a(this.h0) != 0.0f) {
                    if(this.c0(this.h0, -v4, this.getWidth())) {
                        this.h0.onAbsorb(-v4);
                        v4 = 0;
                    }
                    v6 = v4;
                    v4 = 0;
                }
                else if(this.j0 == null || EdgeEffectCompat.a(this.j0) == 0.0f) {
                    v6 = 0;
                }
                else {
                    if(this.c0(this.j0, v4, this.getWidth())) {
                        this.j0.onAbsorb(v4);
                        v4 = 0;
                    }
                    v6 = v4;
                    v4 = 0;
                }
                if(v5 == 0) {
                    v7 = 0;
                    v5 = 0;
                }
                else if(this.i0 != null && EdgeEffectCompat.a(this.i0) != 0.0f) {
                    if(this.c0(this.i0, -v5, this.getHeight())) {
                        this.i0.onAbsorb(-v5);
                        v5 = 0;
                    }
                    v7 = 0;
                }
                else if(this.k0 == null || EdgeEffectCompat.a(this.k0) == 0.0f) {
                    v7 = v5;
                    v5 = 0;
                }
                else {
                    if(this.c0(this.k0, v5, this.getHeight())) {
                        this.k0.onAbsorb(v5);
                        v5 = 0;
                    }
                    v7 = 0;
                }
                N0 n00 = this.A0;
                if(v6 != 0 || v5 != 0) {
                    v6 = Math.max(-v3, Math.min(v6, v3));
                    v5 = Math.max(-v3, Math.min(v5, v3));
                    this.f0(1);
                    n00.a(v6, v5);
                }
                if(v4 == 0 && v7 == 0) {
                    return v6 != 0 || v5 != 0;
                }
                if(!this.dispatchNestedPreFling(((float)v4), ((float)v7))) {
                    boolean z2 = z || z1;
                    this.dispatchNestedFling(((float)v4), ((float)v7), z2);
                    y0 y00 = this.u0;
                    if(y00 == null) {
                        z3 = z2;
                    }
                    else {
                        w0 w01 = ((f0)y00).a.getLayoutManager();
                        if(w01 == null || ((f0)y00).a.getAdapter() == null) {
                            z3 = z2;
                        }
                        else {
                            View view0 = null;
                            int v8 = ((f0)y00).a.getMinFlingVelocity();
                            if(Math.abs(v7) <= v8 && Math.abs(v4) <= v8 || !(w01 instanceof I0)) {
                                z3 = z2;
                            }
                            else {
                                e0 e00 = w01 instanceof I0 ? new e0(((f0)y00), ((f0)y00).a.getContext()) : null;
                                if(e00 == null) {
                                    z3 = z2;
                                }
                                else {
                                    int v9 = w01.getItemCount();
                                    if(v9 == 0) {
                                        z3 = z2;
                                        v17 = -1;
                                    }
                                    else {
                                        if(w01.canScrollVertically()) {
                                            d00 = ((f0)y00).g(w01);
                                        }
                                        else {
                                            d00 = w01.canScrollHorizontally() ? ((f0)y00).f(w01) : null;
                                        }
                                        if(d00 == null) {
                                            z3 = z2;
                                            v17 = -1;
                                        }
                                        else {
                                            int v10 = w01.getChildCount();
                                            View view1 = null;
                                            int v11 = 0x80000000;
                                            int v12 = 0x7FFFFFFF;
                                            z3 = z2;
                                            for(int v13 = 0; v13 < v10; v13 = v14 + 1) {
                                                View view2 = w01.getChildAt(v13);
                                                if(view2 == null) {
                                                    v14 = v13;
                                                }
                                                else {
                                                    v14 = v13;
                                                    int v15 = f0.c(view2, d00);
                                                    if(v15 <= 0 && v15 > v11) {
                                                        v11 = v15;
                                                        view1 = view2;
                                                    }
                                                    if(v15 >= 0 && v15 < v12) {
                                                        v12 = v15;
                                                        view0 = view2;
                                                    }
                                                }
                                            }
                                            if(!w01.canScrollHorizontally()) {
                                                v16 = v7 <= 0 ? 0 : 1;
                                            }
                                            else if(v4 > 0) {
                                                v16 = 1;
                                            }
                                            else {
                                                v16 = 0;
                                            }
                                            if(v16 != 0 && view0 != null) {
                                                v17 = w01.getPosition(view0);
                                            }
                                            else if(v16 != 0 || view1 == null) {
                                                if(v16 != 0) {
                                                    view0 = view1;
                                                }
                                                if(view0 == null) {
                                                    v17 = -1;
                                                }
                                                else {
                                                    int v18 = w01.getPosition(view0);
                                                    int v19 = w01.getItemCount();
                                                    if(w01 instanceof I0) {
                                                        PointF pointF0 = ((I0)w01).computeScrollVectorForPosition(v19 - 1);
                                                        v20 = pointF0 != null && (pointF0.x < 0.0f || pointF0.y < 0.0f) ? 1 : 0;
                                                    }
                                                    else {
                                                        v20 = 0;
                                                    }
                                                    v17 = (v20 == v16 ? -1 : 1) + v18;
                                                    if(v17 < 0 || v17 >= v9) {
                                                        v17 = -1;
                                                    }
                                                }
                                            }
                                            else {
                                                v17 = w01.getPosition(view1);
                                            }
                                        }
                                    }
                                    if(v17 != -1) {
                                        e00.setTargetPosition(v17);
                                        w01.startSmoothScroll(e00);
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                    if(z3) {
                        this.f0(1);
                        n00.a(Math.max(-v3, Math.min(v4, v3)), Math.max(-v3, Math.min(v7, v3)));
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final int F(O0 o00) {
        if(!o00.hasAnyOfTheFlags(0x20C) && o00.isBound()) {
            int v = o00.mPosition;
            ArrayList arrayList0 = (ArrayList)this.e.c;
            int v1 = arrayList0.size();
            for(int v2 = 0; v2 < v1; ++v2) {
                androidx.recyclerview.widget.a a0 = (androidx.recyclerview.widget.a)arrayList0.get(v2);
                switch(a0.a) {
                    case 1: {
                        if(a0.b <= v) {
                            v += a0.d;
                        }
                        break;
                    }
                    case 2: {
                        int v3 = a0.b;
                        if(v3 <= v) {
                            int v4 = a0.d;
                            if(v3 + v4 > v) {
                                return -1;
                            }
                            v -= v4;
                        }
                        break;
                    }
                    case 8: {
                        int v5 = a0.b;
                        if(v5 == v) {
                            v = a0.d;
                        }
                        else {
                            if(v5 < v) {
                                --v;
                            }
                            if(a0.d <= v) {
                                ++v;
                            }
                        }
                    }
                }
            }
            return v;
        }
        return -1;
    }

    // 去混淆评级： 低(20)
    public final long G(O0 o00) {
        return this.m.hasStableIds() ? o00.getItemId() : ((long)o00.mPosition);
    }

    public static O0 H(View view0) {
        return view0 == null ? null : ((LayoutParams)view0.getLayoutParams()).a;
    }

    public static void I(View view0, Rect rect0) {
        LayoutParams recyclerView$LayoutParams0 = (LayoutParams)view0.getLayoutParams();
        rect0.set(view0.getLeft() - recyclerView$LayoutParams0.b.left - recyclerView$LayoutParams0.leftMargin, view0.getTop() - recyclerView$LayoutParams0.b.top - recyclerView$LayoutParams0.topMargin, view0.getRight() + recyclerView$LayoutParams0.b.right + recyclerView$LayoutParams0.rightMargin, view0.getBottom() + recyclerView$LayoutParams0.b.bottom + recyclerView$LayoutParams0.bottomMargin);
    }

    public final Rect J(View view0) {
        LayoutParams recyclerView$LayoutParams0 = (LayoutParams)view0.getLayoutParams();
        Rect rect0 = recyclerView$LayoutParams0.b;
        if(recyclerView$LayoutParams0.c) {
            K0 k00 = this.D0;
            if(!k00.g || !recyclerView$LayoutParams0.a.isUpdated() && !recyclerView$LayoutParams0.a.isInvalid()) {
                rect0.set(0, 0, 0, 0);
                ArrayList arrayList0 = this.r;
                int v = arrayList0.size();
                for(int v1 = 0; v1 < v; ++v1) {
                    this.j.set(0, 0, 0, 0);
                    ((r0)arrayList0.get(v1)).getItemOffsets(this.j, view0, this, k00);
                    rect0.left += this.j.left;
                    rect0.top += this.j.top;
                    rect0.right += this.j.right;
                    rect0.bottom += this.j.bottom;
                }
                recyclerView$LayoutParams0.c = false;
                return rect0;
            }
        }
        return rect0;
    }

    public final void K(int v) {
        if(this.n == null) {
            return;
        }
        this.setScrollState(2);
        this.n.scrollToPosition(v);
        this.awakenScrollBars();
    }

    public final void L() {
        int v = this.f.h();
        for(int v2 = 0; v2 < v; ++v2) {
            ((LayoutParams)this.f.g(v2).getLayoutParams()).c = true;
        }
        ArrayList arrayList0 = this.c.c;
        int v3 = arrayList0.size();
        for(int v1 = 0; v1 < v3; ++v1) {
            LayoutParams recyclerView$LayoutParams0 = (LayoutParams)((O0)arrayList0.get(v1)).itemView.getLayoutParams();
            if(recyclerView$LayoutParams0 != null) {
                recyclerView$LayoutParams0.c = true;
            }
        }
    }

    public final void M(int v, int v1, MotionEvent motionEvent0) {
        w0 w00 = this.n;
        if(w00 == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if(this.N) {
            return;
        }
        int[] arr_v = this.P0;
        int v2 = 0;
        arr_v[0] = 0;
        arr_v[1] = 0;
        boolean z = w00.canScrollHorizontally();
        boolean z1 = this.n.canScrollVertically();
        int v3 = z1 ? z | 2 : z;
        float f = motionEvent0 == null ? ((float)this.getHeight()) / 2.0f : motionEvent0.getY();
        float f1 = motionEvent0 == null ? ((float)this.getWidth()) / 2.0f : motionEvent0.getX();
        int v4 = v - this.W(f, v);
        int v5 = v1 - this.X(f1, v1);
        this.startNestedScroll(v3, 1);
        if(this.dispatchNestedPreScroll((z ? v4 : 0), (z1 ? v5 : 0), this.P0, this.N0, 1)) {
            v4 -= arr_v[0];
            v5 -= arr_v[1];
        }
        if(z1) {
            v2 = v5;
        }
        this.Z((z ? v4 : 0), v2, motionEvent0, 1);
        F f2 = this.B0;
        if(f2 != null && (v4 != 0 || v5 != 0)) {
            f2.a(this, v4, v5);
        }
        this.stopNestedScroll(1);
    }

    public final void N(int v, int v1, boolean z) {
        int v2 = v + v1;
        int v3 = this.f.h();
        for(int v4 = 0; v4 < v3; ++v4) {
            O0 o00 = RecyclerView.H(this.f.g(v4));
            if(o00 != null && !o00.shouldIgnore()) {
                int v5 = o00.mPosition;
                K0 k00 = this.D0;
                if(v5 >= v2) {
                    if(RecyclerView.Z0) {
                        Log.d("RecyclerView", "offsetPositionRecordsForRemove attached child " + v4 + " holder " + o00 + " now at position " + (o00.mPosition - v1));
                    }
                    o00.offsetPosition(-v1, z);
                    k00.f = true;
                }
                else if(v5 >= v) {
                    if(RecyclerView.Z0) {
                        Log.d("RecyclerView", "offsetPositionRecordsForRemove attached child " + v4 + " holder " + o00 + " now REMOVED");
                    }
                    o00.flagRemovedAndOffsetPosition(v - 1, -v1, z);
                    k00.f = true;
                }
            }
        }
        D0 d00 = this.c;
        ArrayList arrayList0 = d00.c;
        for(int v6 = arrayList0.size() - 1; v6 >= 0; --v6) {
            O0 o01 = (O0)arrayList0.get(v6);
            if(o01 != null) {
                int v7 = o01.mPosition;
                if(v7 >= v2) {
                    if(RecyclerView.Z0) {
                        Log.d("RecyclerView", "offsetPositionRecordsForRemove cached " + v6 + " holder " + o01 + " now at position " + (o01.mPosition - v1));
                    }
                    o01.offsetPosition(-v1, z);
                }
                else if(v7 >= v) {
                    o01.addFlags(8);
                    d00.g(v6);
                }
            }
        }
        this.requestLayout();
    }

    public final void O() {
        ++this.e0;
    }

    public final void P(boolean z) {
        int v = this.e0 - 1;
        this.e0 = v;
        if(v < 1) {
            if(RecyclerView.Y0 && v < 0) {
                throw new IllegalStateException(o.l(this, new StringBuilder("layout or scroll counter cannot go below zero.Some calls are not matching")));
            }
            this.e0 = 0;
            if(z) {
                int v1 = this.T;
                this.T = 0;
                if(v1 != 0 && (this.W != null && this.W.isEnabled())) {
                    AccessibilityEvent accessibilityEvent0 = AccessibilityEvent.obtain();
                    accessibilityEvent0.setEventType(0x800);
                    accessibilityEvent0.setContentChangeTypes(v1);
                    this.sendAccessibilityEventUnchecked(accessibilityEvent0);
                }
                ArrayList arrayList0 = this.Q0;
                for(int v2 = arrayList0.size() - 1; v2 >= 0; --v2) {
                    O0 o00 = (O0)arrayList0.get(v2);
                    if(o00.itemView.getParent() == this && !o00.shouldIgnore()) {
                        int v3 = o00.mPendingAccessibilityState;
                        if(v3 != -1) {
                            o00.itemView.setImportantForAccessibility(v3);
                            o00.mPendingAccessibilityState = -1;
                        }
                    }
                }
                arrayList0.clear();
            }
        }
    }

    public final void Q(MotionEvent motionEvent0) {
        int v = motionEvent0.getActionIndex();
        if(motionEvent0.getPointerId(v) == this.n0) {
            int v1 = v == 0 ? 1 : 0;
            this.n0 = motionEvent0.getPointerId(v1);
            float f = motionEvent0.getX(v1);
            this.r0 = (int)(f + 0.5f);
            this.p0 = (int)(f + 0.5f);
            float f1 = motionEvent0.getY(v1);
            this.s0 = (int)(f1 + 0.5f);
            this.q0 = (int)(f1 + 0.5f);
        }
    }

    public final void R() {
        if(!this.J0 && this.D) {
            this.postOnAnimation(this.R0);
            this.J0 = true;
        }
    }

    public final void S() {
        boolean z = false;
        if(this.c0) {
            this.e.n(((ArrayList)this.e.c));
            this.e.n(((ArrayList)this.e.d));
            this.e.a = 0;
            if(this.d0) {
                this.n.onItemsChanged(this);
            }
        }
        if(this.l0 == null || !this.n.supportsPredictiveItemAnimations()) {
            this.e.d();
        }
        else {
            this.e.m();
        }
        boolean z1 = this.G0 || this.H0;
        boolean z2 = this.G && this.l0 != null && ((this.c0 || z1 || this.n.mRequestedSimpleAnimations) && (!this.c0 || this.m.hasStableIds()));
        K0 k00 = this.D0;
        k00.j = z2;
        if(z2 && z1 && !this.c0 && this.l0 != null && this.n.supportsPredictiveItemAnimations()) {
            z = true;
        }
        k00.k = z;
    }

    public final void T(boolean z) {
        this.d0 |= z;
        this.c0 = true;
        int v = this.f.h();
        for(int v2 = 0; v2 < v; ++v2) {
            O0 o00 = RecyclerView.H(this.f.g(v2));
            if(o00 != null && !o00.shouldIgnore()) {
                o00.addFlags(6);
            }
        }
        this.L();
        D0 d00 = this.c;
        ArrayList arrayList0 = d00.c;
        int v3 = arrayList0.size();
        for(int v1 = 0; v1 < v3; ++v1) {
            O0 o01 = (O0)arrayList0.get(v1);
            if(o01 != null) {
                o01.addFlags(6);
                o01.addChangePayload(null);
            }
        }
        j0 j00 = d00.h.m;
        if(j00 != null && j00.hasStableIds()) {
            return;
        }
        d00.f();
    }

    public final void U(O0 o00, p0 p00) {
        o00.setFlags(0, 0x2000);
        l l0 = this.g;
        if(this.D0.h && o00.isUpdated() && !o00.isRemoved() && !o00.shouldIgnore()) {
            long v = this.G(o00);
            ((s)l0.c).f(v, o00);
        }
        V v1 = (V)l0.b;
        a1 a10 = (a1)v1.get(o00);
        if(a10 == null) {
            a10 = a1.a();
            v1.put(o00, a10);
        }
        a10.b = p00;
        a10.a |= 4;
    }

    public final void V() {
        boolean z;
        EdgeEffect edgeEffect0 = this.h0;
        if(edgeEffect0 == null) {
            z = false;
        }
        else {
            edgeEffect0.onRelease();
            z = this.h0.isFinished();
        }
        EdgeEffect edgeEffect1 = this.i0;
        if(edgeEffect1 != null) {
            edgeEffect1.onRelease();
            z |= this.i0.isFinished();
        }
        EdgeEffect edgeEffect2 = this.j0;
        if(edgeEffect2 != null) {
            edgeEffect2.onRelease();
            z |= this.j0.isFinished();
        }
        EdgeEffect edgeEffect3 = this.k0;
        if(edgeEffect3 != null) {
            edgeEffect3.onRelease();
            z |= this.k0.isFinished();
        }
        if(z) {
            this.postInvalidateOnAnimation();
        }
    }

    public final int W(float f, int v) {
        float f1 = f / ((float)this.getHeight());
        float f2 = ((float)v) / ((float)this.getWidth());
        float f3 = 0.0f;
        if(this.h0 != null && EdgeEffectCompat.a(this.h0) != 0.0f) {
            if(this.canScrollHorizontally(-1)) {
                this.h0.onRelease();
            }
            else {
                float f4 = EdgeEffectCompat.b(this.h0, -f2, 1.0f - f1);
                if(EdgeEffectCompat.a(this.h0) == 0.0f) {
                    this.h0.onRelease();
                }
                f3 = -f4;
            }
            this.invalidate();
            return Math.round(f3 * ((float)this.getWidth()));
        }
        if(this.j0 != null && EdgeEffectCompat.a(this.j0) != 0.0f) {
            if(this.canScrollHorizontally(1)) {
                this.j0.onRelease();
            }
            else {
                float f5 = EdgeEffectCompat.b(this.j0, f2, f1);
                if(EdgeEffectCompat.a(this.j0) == 0.0f) {
                    this.j0.onRelease();
                }
                f3 = f5;
            }
            this.invalidate();
        }
        return Math.round(f3 * ((float)this.getWidth()));
    }

    public final int X(float f, int v) {
        float f1 = f / ((float)this.getWidth());
        float f2 = ((float)v) / ((float)this.getHeight());
        float f3 = 0.0f;
        if(this.i0 != null && EdgeEffectCompat.a(this.i0) != 0.0f) {
            if(this.canScrollVertically(-1)) {
                this.i0.onRelease();
            }
            else {
                float f4 = EdgeEffectCompat.b(this.i0, -f2, f1);
                if(EdgeEffectCompat.a(this.i0) == 0.0f) {
                    this.i0.onRelease();
                }
                f3 = -f4;
            }
            this.invalidate();
            return Math.round(f3 * ((float)this.getHeight()));
        }
        if(this.k0 != null && EdgeEffectCompat.a(this.k0) != 0.0f) {
            if(this.canScrollVertically(1)) {
                this.k0.onRelease();
            }
            else {
                float f5 = EdgeEffectCompat.b(this.k0, f2, 1.0f - f1);
                if(EdgeEffectCompat.a(this.k0) == 0.0f) {
                    this.k0.onRelease();
                }
                f3 = f5;
            }
            this.invalidate();
        }
        return Math.round(f3 * ((float)this.getHeight()));
    }

    public final void Y(View view0, View view1) {
        View view2 = view1 == null ? view0 : view1;
        int v = view2.getWidth();
        int v1 = view2.getHeight();
        Rect rect0 = this.j;
        rect0.set(0, 0, v, v1);
        ViewGroup.LayoutParams viewGroup$LayoutParams0 = view2.getLayoutParams();
        if(viewGroup$LayoutParams0 instanceof LayoutParams && !((LayoutParams)viewGroup$LayoutParams0).c) {
            rect0.left -= ((LayoutParams)viewGroup$LayoutParams0).b.left;
            rect0.right += ((LayoutParams)viewGroup$LayoutParams0).b.right;
            rect0.top -= ((LayoutParams)viewGroup$LayoutParams0).b.top;
            rect0.bottom += ((LayoutParams)viewGroup$LayoutParams0).b.bottom;
        }
        if(view1 != null) {
            this.offsetDescendantRectToMyCoords(view1, rect0);
            this.offsetRectIntoDescendantCoords(view0, rect0);
        }
        this.n.requestChildRectangleOnScreen(this, view0, this.j, !this.G, view1 == null);
    }

    public final boolean Z(int v, int v1, MotionEvent motionEvent0, int v2) {
        boolean z;
        int v6;
        int v5;
        int v4;
        int v3;
        this.n();
        int[] arr_v = this.P0;
        if(this.m == null) {
            v3 = 0;
            v4 = 0;
            v5 = 0;
            v6 = 0;
        }
        else {
            arr_v[0] = 0;
            arr_v[1] = 0;
            this.a0(v, v1, arr_v);
            v3 = arr_v[0];
            v4 = arr_v[1];
            v5 = v - v3;
            v6 = v1 - v4;
        }
        if(!this.r.isEmpty()) {
            this.invalidate();
        }
        arr_v[0] = 0;
        arr_v[1] = 0;
        this.dispatchNestedScroll(v3, v4, v5, v6, this.N0, v2, arr_v);
        int v7 = arr_v[0];
        int v8 = arr_v[1];
        int v9 = this.r0;
        int v10 = this.N0[0];
        this.r0 = v9 - v10;
        int v11 = this.s0;
        int v12 = this.N0[1];
        this.s0 = v11 - v12;
        this.O0[0] += v10;
        this.O0[1] += v12;
        if(this.getOverScrollMode() != 2) {
            if(motionEvent0 != null && !E9.h.Q(motionEvent0, 0x2002)) {
                float f = motionEvent0.getX();
                float f1 = (float)(v5 - v7);
                float f2 = motionEvent0.getY();
                float f3 = (float)(v6 - v8);
                if(Float.compare(f1, 0.0f) < 0) {
                    this.v();
                    EdgeEffectCompat.b(this.h0, -f1 / ((float)this.getWidth()), 1.0f - f2 / ((float)this.getHeight()));
                    z = true;
                }
                else if(f1 > 0.0f) {
                    this.w();
                    EdgeEffectCompat.b(this.j0, f1 / ((float)this.getWidth()), f2 / ((float)this.getHeight()));
                    z = true;
                }
                else {
                    z = false;
                }
                if(f3 < 0.0f) {
                    this.x();
                    EdgeEffectCompat.b(this.i0, -f3 / ((float)this.getHeight()), f / ((float)this.getWidth()));
                    z = true;
                }
                else if(f3 > 0.0f) {
                    this.u();
                    EdgeEffectCompat.b(this.k0, f3 / ((float)this.getHeight()), 1.0f - f / ((float)this.getWidth()));
                    z = true;
                }
                if(z || f1 != 0.0f || f3 != 0.0f) {
                    this.postInvalidateOnAnimation();
                }
                if(Build.VERSION.SDK_INT >= 0x1F && E9.h.Q(motionEvent0, 0x400000)) {
                    this.V();
                }
            }
            this.l(v, v1);
        }
        if(v3 != 0 || v4 != 0) {
            this.t(v3, v4);
        }
        if(!this.awakenScrollBars()) {
            this.invalidate();
        }
        return v7 != 0 || v8 != 0 || v3 != 0 || v4 != 0;
    }

    public final void a0(int v, int v1, int[] arr_v) {
        this.e0();
        this.O();
        Trace.beginSection("RV Scroll");
        this.z(this.D0);
        int v2 = v == 0 ? 0 : this.n.scrollHorizontallyBy(v, this.c, this.D0);
        int v3 = v1 == 0 ? 0 : this.n.scrollVerticallyBy(v1, this.c, this.D0);
        Trace.endSection();
        int v4 = this.f.e();
        for(int v5 = 0; v5 < v4; ++v5) {
            View view0 = this.f.d(v5);
            O0 o00 = this.getChildViewHolder(view0);
            if(o00 != null) {
                O0 o01 = o00.mShadowingHolder;
                if(o01 != null) {
                    View view1 = o01.itemView;
                    int v6 = view0.getLeft();
                    int v7 = view0.getTop();
                    if(v6 != view1.getLeft() || v7 != view1.getTop()) {
                        view1.layout(v6, v7, view1.getWidth() + v6, view1.getHeight() + v7);
                    }
                }
            }
        }
        this.P(true);
        this.g0(false);
        if(arr_v != null) {
            arr_v[0] = v2;
            arr_v[1] = v3;
        }
    }

    @Override  // android.view.ViewGroup
    public void addFocusables(ArrayList arrayList0, int v, int v1) {
        super.addFocusables(arrayList0, v, v1);
    }

    public void addItemDecoration(r0 r00) {
        this.addItemDecoration(r00, -1);
    }

    public void addItemDecoration(r0 r00, int v) {
        w0 w00 = this.n;
        if(w00 != null) {
            w00.assertNotInLayoutOrScroll("Cannot add item decoration during a scroll  or layout");
        }
        ArrayList arrayList0 = this.r;
        if(arrayList0.isEmpty()) {
            this.setWillNotDraw(false);
        }
        if(v < 0) {
            arrayList0.add(r00);
        }
        else {
            arrayList0.add(v, r00);
        }
        this.L();
        this.requestLayout();
    }

    public void addOnChildAttachStateChangeListener(x0 x00) {
        if(this.b0 == null) {
            this.b0 = new ArrayList();
        }
        this.b0.add(x00);
    }

    public void addOnItemTouchListener(z0 z00) {
        this.w.add(z00);
    }

    public void addOnScrollListener(A0 a00) {
        if(this.F0 == null) {
            this.F0 = new ArrayList();
        }
        this.F0.add(a00);
    }

    public void addRecyclerListener(E0 e00) {
        c.l(e00 != null, "\'listener\' arg cannot be null.");
        this.o.add(e00);
    }

    public final void b0(j0 j00, boolean z, boolean z1) {
        j0 j01 = this.m;
        F0 f00 = this.b;
        if(j01 != null) {
            j01.unregisterAdapterDataObserver(f00);
            this.m.onDetachedFromRecyclerView(this);
        }
        D0 d00 = this.c;
        if(!z || z1) {
            q0 q00 = this.l0;
            if(q00 != null) {
                q00.e();
            }
            w0 w00 = this.n;
            if(w00 != null) {
                w00.removeAndRecycleAllViews(d00);
                this.n.removeAndRecycleScrapInt(d00);
            }
            d00.a.clear();
            d00.f();
        }
        this.e.n(((ArrayList)this.e.c));
        this.e.n(((ArrayList)this.e.d));
        this.e.a = 0;
        j0 j02 = this.m;
        this.m = j00;
        if(j00 != null) {
            j00.registerAdapterDataObserver(f00);
            j00.onAttachedToRecyclerView(this);
        }
        w0 w01 = this.n;
        if(w01 != null) {
            w01.onAdapterChanged(j02, this.m);
        }
        j0 j03 = this.m;
        d00.a.clear();
        d00.f();
        d00.e(j02, true);
        C0 c00 = d00.c();
        if(j02 != null) {
            --c00.b;
        }
        if(!z && c00.b == 0) {
            SparseArray sparseArray0 = c00.a;
            for(int v = 0; v < sparseArray0.size(); ++v) {
                B0 b00 = (B0)sparseArray0.valueAt(v);
                for(Object object0: b00.a) {
                    k.i(((O0)object0).itemView);
                }
                b00.a.clear();
            }
        }
        if(j03 == null) {
            c00.getClass();
        }
        else {
            ++c00.b;
        }
        d00.d();
        this.D0.f = true;
    }

    public final boolean c0(EdgeEffect edgeEffect0, int v, int v1) {
        if(v <= 0) {
            float f = EdgeEffectCompat.a(edgeEffect0);
            return ((float)(Math.exp(((double)RecyclerView.b1) / (((double)RecyclerView.b1) - 1.0) * Math.log(((float)Math.abs(-v)) * 0.35f / (this.a * 0.015f))) * ((double)(this.a * 0.015f)))) < f * ((float)v1);
        }
        return true;
    }

    // 去混淆评级： 低(20)
    @Override  // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        return viewGroup$LayoutParams0 instanceof LayoutParams && this.n.checkLayoutParams(((LayoutParams)viewGroup$LayoutParams0));
    }

    public void clearOnChildAttachStateChangeListeners() {
        ArrayList arrayList0 = this.b0;
        if(arrayList0 != null) {
            arrayList0.clear();
        }
    }

    public void clearOnScrollListeners() {
        ArrayList arrayList0 = this.F0;
        if(arrayList0 != null) {
            arrayList0.clear();
        }
    }

    @Override  // android.view.View
    public int computeHorizontalScrollExtent() {
        return this.n == null || !this.n.canScrollHorizontally() ? 0 : this.n.computeHorizontalScrollExtent(this.D0);
    }

    @Override  // android.view.View
    public int computeHorizontalScrollOffset() {
        return this.n == null || !this.n.canScrollHorizontally() ? 0 : this.n.computeHorizontalScrollOffset(this.D0);
    }

    @Override  // android.view.View
    public int computeHorizontalScrollRange() {
        return this.n == null || !this.n.canScrollHorizontally() ? 0 : this.n.computeHorizontalScrollRange(this.D0);
    }

    @Override  // android.view.View
    public int computeVerticalScrollExtent() {
        return this.n == null || !this.n.canScrollVertically() ? 0 : this.n.computeVerticalScrollExtent(this.D0);
    }

    @Override  // android.view.View
    public int computeVerticalScrollOffset() {
        return this.n == null || !this.n.canScrollVertically() ? 0 : this.n.computeVerticalScrollOffset(this.D0);
    }

    @Override  // android.view.View
    public int computeVerticalScrollRange() {
        return this.n == null || !this.n.canScrollVertically() ? 0 : this.n.computeVerticalScrollRange(this.D0);
    }

    public static boolean d(RecyclerView recyclerView0) {
        return recyclerView0.awakenScrollBars();
    }

    public final void d0(int v, int v1, Interpolator interpolator0, int v2, boolean z) {
        int v3 = 0;
        w0 w00 = this.n;
        if(w00 == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if(!this.N) {
            if(!w00.canScrollHorizontally()) {
                v = 0;
            }
            if(!this.n.canScrollVertically()) {
                v1 = 0;
            }
            if(v != 0 || v1 != 0) {
                if(v2 != 0x80000000 && v2 <= 0) {
                    this.scrollBy(v, v1);
                    return;
                }
                if(z) {
                    if(v != 0) {
                        v3 = 1;
                    }
                    if(v1 != 0) {
                        v3 |= 2;
                    }
                    this.startNestedScroll(v3, 1);
                }
                this.A0.c(v, v1, interpolator0, v2);
            }
        }
    }

    @Override  // android.view.ViewGroup
    public boolean dispatchKeyEvent(KeyEvent keyEvent0) {
        if(super.dispatchKeyEvent(keyEvent0)) {
            return true;
        }
        w0 w00 = this.getLayoutManager();
        int v = 0;
        if(w00 != null) {
            if(w00.canScrollVertically()) {
                int v1 = keyEvent0.getKeyCode();
                switch(v1) {
                    case 92: 
                    case 93: {
                        int v2 = this.getMeasuredHeight();
                        if(v1 == 93) {
                            this.smoothScrollBy(0, v2, null, 0x80000000);
                            return true;
                        }
                        this.smoothScrollBy(0, -v2, null, 0x80000000);
                        return true;
                    }
                    case 0x7A: 
                    case 0x7B: {
                        boolean z = w00.isLayoutReversed();
                        if(v1 != 0x7A) {
                            if(!z) {
                                v = this.getAdapter().getItemCount();
                            }
                        }
                        else if(z) {
                            v = this.getAdapter().getItemCount();
                        }
                        this.smoothScrollToPosition(v);
                        return true;
                    }
                    default: {
                        return false;
                    }
                }
            }
            if(w00.canScrollHorizontally()) {
                int v3 = keyEvent0.getKeyCode();
                switch(v3) {
                    case 92: 
                    case 93: {
                        int v4 = this.getMeasuredWidth();
                        if(v3 == 93) {
                            this.smoothScrollBy(v4, 0, null, 0x80000000);
                            return true;
                        }
                        this.smoothScrollBy(-v4, 0, null, 0x80000000);
                        return true;
                    }
                    case 0x7A: 
                    case 0x7B: {
                        boolean z1 = w00.isLayoutReversed();
                        if(v3 != 0x7A) {
                            if(!z1) {
                                v = this.getAdapter().getItemCount();
                            }
                        }
                        else if(z1) {
                            v = this.getAdapter().getItemCount();
                        }
                        this.smoothScrollToPosition(v);
                        return true;
                    }
                    default: {
                        return false;
                    }
                }
            }
        }
        return false;
    }

    @Override  // android.view.View
    public boolean dispatchNestedFling(float f, float f1, boolean z) {
        return this.getScrollingChildHelper().a(f, f1, z);
    }

    @Override  // android.view.View
    public boolean dispatchNestedPreFling(float f, float f1) {
        return this.getScrollingChildHelper().b(f, f1);
    }

    @Override  // android.view.View
    public boolean dispatchNestedPreScroll(int v, int v1, int[] arr_v, int[] arr_v1) {
        return this.getScrollingChildHelper().c(v, v1, arr_v, arr_v1, 0);
    }

    public boolean dispatchNestedPreScroll(int v, int v1, int[] arr_v, int[] arr_v1, int v2) {
        return this.getScrollingChildHelper().c(v, v1, arr_v, arr_v1, v2);
    }

    public final void dispatchNestedScroll(int v, int v1, int v2, int v3, int[] arr_v, int v4, int[] arr_v1) {
        this.getScrollingChildHelper().d(v, v1, v2, v3, arr_v, v4, arr_v1);
    }

    @Override  // android.view.View
    public boolean dispatchNestedScroll(int v, int v1, int v2, int v3, int[] arr_v) {
        return this.getScrollingChildHelper().d(v, v1, v2, v3, arr_v, 0, null);
    }

    @Override  // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent0) {
        this.onPopulateAccessibilityEvent(accessibilityEvent0);
        return true;
    }

    @Override  // android.view.ViewGroup
    public void dispatchRestoreInstanceState(SparseArray sparseArray0) {
        this.dispatchThawSelfOnly(sparseArray0);
    }

    @Override  // android.view.ViewGroup
    public void dispatchSaveInstanceState(SparseArray sparseArray0) {
        this.dispatchFreezeSelfOnly(sparseArray0);
    }

    @Override  // android.view.View
    public void draw(Canvas canvas0) {
        int v6;
        int v3;
        super.draw(canvas0);
        ArrayList arrayList0 = this.r;
        int v = arrayList0.size();
        int v1 = 0;
        for(int v2 = 0; true; ++v2) {
            v3 = 1;
            if(v2 >= v) {
                break;
            }
            ((r0)arrayList0.get(v2)).onDrawOver(canvas0, this, this.D0);
        }
        if(this.h0 == null || this.h0.isFinished()) {
            v6 = 0;
        }
        else {
            int v4 = canvas0.save();
            int v5 = this.h ? this.getPaddingBottom() : 0;
            canvas0.rotate(270.0f);
            canvas0.translate(((float)(v5 - this.getHeight())), 0.0f);
            v6 = this.h0 == null || !this.h0.draw(canvas0) ? 0 : 1;
            canvas0.restoreToCount(v4);
        }
        if(this.i0 != null && !this.i0.isFinished()) {
            int v7 = canvas0.save();
            if(this.h) {
                canvas0.translate(((float)this.getPaddingLeft()), ((float)this.getPaddingTop()));
            }
            v6 |= (this.i0 == null || !this.i0.draw(canvas0) ? 0 : 1);
            canvas0.restoreToCount(v7);
        }
        if(this.j0 != null && !this.j0.isFinished()) {
            int v8 = canvas0.save();
            int v9 = this.getWidth();
            int v10 = this.h ? this.getPaddingTop() : 0;
            canvas0.rotate(90.0f);
            canvas0.translate(((float)v10), ((float)(-v9)));
            v6 |= (this.j0 == null || !this.j0.draw(canvas0) ? 0 : 1);
            canvas0.restoreToCount(v8);
        }
        if(this.k0 != null && !this.k0.isFinished()) {
            int v11 = canvas0.save();
            canvas0.rotate(180.0f);
            if(this.h) {
                int v12 = this.getWidth();
                int v13 = this.getPaddingRight();
                int v14 = this.getHeight();
                canvas0.translate(((float)(v13 - v12)), ((float)(this.getPaddingBottom() - v14)));
            }
            else {
                canvas0.translate(((float)(-this.getWidth())), ((float)(-this.getHeight())));
            }
            if(this.k0 != null && this.k0.draw(canvas0)) {
                v1 = 1;
            }
            v6 |= v1;
            canvas0.restoreToCount(v11);
        }
        if(v6 != 0 || this.l0 == null || arrayList0.size() <= 0 || !this.l0.f()) {
            v3 = v6;
        }
        if(v3 != 0) {
            this.postInvalidateOnAnimation();
        }
    }

    @Override  // android.view.ViewGroup
    public boolean drawChild(Canvas canvas0, View view0, long v) {
        return super.drawChild(canvas0, view0, v);
    }

    public final void e0() {
        int v = this.I + 1;
        this.I = v;
        if(v == 1 && !this.N) {
            this.M = false;
        }
    }

    public final void f0(int v) {
        boolean z = this.n.canScrollHorizontally();
        if(this.n.canScrollVertically()) {
            z |= 2;
        }
        this.startNestedScroll(((int)z), v);
    }

    public View findChildViewUnder(float f, float f1) {
        for(int v = this.f.e() - 1; v >= 0; --v) {
            View view0 = this.f.d(v);
            float f2 = view0.getTranslationX();
            float f3 = view0.getTranslationY();
            if(f >= ((float)view0.getLeft()) + f2 && f <= ((float)view0.getRight()) + f2 && f1 >= ((float)view0.getTop()) + f3 && f1 <= ((float)view0.getBottom()) + f3) {
                return view0;
            }
        }
        return null;
    }

    public View findContainingItemView(View view0) {
        ViewParent viewParent0;
        for(viewParent0 = view0.getParent(); viewParent0 != null && viewParent0 != this && viewParent0 instanceof View; viewParent0 = view0.getParent()) {
            view0 = (View)viewParent0;
        }
        return viewParent0 == this ? view0 : null;
    }

    public O0 findContainingViewHolder(View view0) {
        View view1 = this.findContainingItemView(view0);
        return view1 == null ? null : this.getChildViewHolder(view1);
    }

    public O0 findViewHolderForAdapterPosition(int v) {
        O0 o00 = null;
        if(this.c0) {
            return null;
        }
        int v1 = this.f.h();
        for(int v2 = 0; v2 < v1; ++v2) {
            O0 o01 = RecyclerView.H(this.f.g(v2));
            if(o01 != null && !o01.isRemoved() && this.F(o01) == v) {
                if(this.f.c.contains(o01.itemView)) {
                    o00 = o01;
                    continue;
                }
                return o01;
            }
        }
        return o00;
    }

    public O0 findViewHolderForItemId(long v) {
        O0 o00 = null;
        if(this.m != null && this.m.hasStableIds()) {
            int v1 = this.f.h();
            for(int v2 = 0; v2 < v1; ++v2) {
                O0 o01 = RecyclerView.H(this.f.g(v2));
                if(o01 != null && !o01.isRemoved() && o01.getItemId() == v) {
                    if(this.f.c.contains(o01.itemView)) {
                        o00 = o01;
                        continue;
                    }
                    return o01;
                }
            }
        }
        return o00;
    }

    public O0 findViewHolderForLayoutPosition(int v) {
        return this.D(v, false);
    }

    @Deprecated
    public O0 findViewHolderForPosition(int v) {
        return this.D(v, false);
    }

    public boolean fling(int v, int v1) {
        return this.E(v, v1, this.v0, this.w0);
    }

    @Override  // android.view.ViewGroup
    public View focusSearch(View view0, int v) {
        int v11;
        int v8;
        View view1;
        boolean z = this.m != null && this.n != null && !this.isComputingLayout() && !this.N;
        FocusFinder focusFinder0 = FocusFinder.getInstance();
        K0 k00 = this.D0;
        D0 d00 = this.c;
        if(!z || v != 1 && v != 2) {
            View view2 = focusFinder0.findNextFocus(this, view0, v);
            if(view2 != null || !z) {
                view1 = view2;
            }
            else {
                this.n();
                if(this.findContainingItemView(view0) == null) {
                    return null;
                }
                this.e0();
                view1 = this.n.onFocusSearchFailed(view0, v, d00, k00);
                this.g0(false);
            }
        }
        else {
            boolean z1 = this.n.canScrollVertically() && focusFinder0.findNextFocus(this, view0, (v == 2 ? 130 : 33)) == null;
            if(!z1 && this.n.canScrollHorizontally()) {
                z1 = focusFinder0.findNextFocus(this, view0, (((this.n.getLayoutDirection() == 1 ? 1 : 0) ^ (v == 2 ? 1 : 0)) == 0 ? 17 : 66)) == null;
            }
            if(z1) {
                this.n();
                if(this.findContainingItemView(view0) == null) {
                    return null;
                }
                this.e0();
                this.n.onFocusSearchFailed(view0, v, d00, k00);
                this.g0(false);
            }
            view1 = focusFinder0.findNextFocus(this, view0, v);
        }
        if(view1 != null && !view1.hasFocusable()) {
            if(this.getFocusedChild() == null) {
                return super.focusSearch(view0, v);
            }
            this.Y(view1, null);
            return view0;
        }
        if(view1 == null || view1 == this || view1 == view0 || this.findContainingItemView(view1) == null) {
            return super.focusSearch(view0, v);
        }
        if(view0 != null && this.findContainingItemView(view0) != null) {
            int v1 = view0.getWidth();
            int v2 = view0.getHeight();
            Rect rect0 = this.j;
            rect0.set(0, 0, v1, v2);
            int v3 = view1.getWidth();
            int v4 = view1.getHeight();
            Rect rect1 = this.k;
            rect1.set(0, 0, v3, v4);
            this.offsetDescendantRectToMyCoords(view0, rect0);
            this.offsetDescendantRectToMyCoords(view1, rect1);
            int v5 = this.n.getLayoutDirection() == 1 ? -1 : 1;
            int v6 = rect0.left;
            int v7 = rect1.left;
            if(v6 >= v7 && rect0.right > v7 || rect0.right >= rect1.right) {
                v8 = rect0.right <= rect1.right && v6 < rect1.right || v6 <= v7 ? 0 : -1;
            }
            else {
                v8 = 1;
            }
            int v9 = rect0.top;
            int v10 = rect1.top;
            if(v9 >= v10 && rect0.bottom > v10 || rect0.bottom >= rect1.bottom) {
                v11 = rect0.bottom <= rect1.bottom && v9 < rect1.bottom || v9 <= v10 ? 0 : -1;
            }
            else {
                v11 = 1;
            }
            switch(v) {
                case 1: {
                    return v11 >= 0 && (v11 != 0 || v8 * v5 >= 0) ? super.focusSearch(view0, 1) : view1;
                }
                case 2: {
                    return v11 <= 0 && (v11 != 0 || v8 * v5 <= 0) ? super.focusSearch(view0, 2) : view1;
                }
                case 17: {
                    return v8 >= 0 ? super.focusSearch(view0, 17) : view1;
                }
                case 33: {
                    return v11 >= 0 ? super.focusSearch(view0, 33) : view1;
                }
                case 66: {
                    return v8 <= 0 ? super.focusSearch(view0, 66) : view1;
                }
                case 130: {
                    return v11 > 0 ? view1 : super.focusSearch(view0, 130);
                }
                default: {
                    StringBuilder stringBuilder0 = new StringBuilder("Invalid direction: ");
                    stringBuilder0.append(v);
                    throw new IllegalArgumentException(o.l(this, stringBuilder0));
                }
            }
        }
        return view1;
    }

    public final void g0(boolean z) {
        if(this.I < 1) {
            if(RecyclerView.Y0) {
                throw new IllegalStateException(o.l(this, new StringBuilder("stopInterceptRequestLayout was called more times than startInterceptRequestLayout.")));
            }
            this.I = 1;
        }
        if(!z && !this.N) {
            this.M = false;
        }
        if(this.I == 1) {
            if(z && this.M && !this.N && this.n != null && this.m != null) {
                this.q();
            }
            if(!this.N) {
                this.M = false;
            }
        }
        --this.I;
    }

    @Override  // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        w0 w00 = this.n;
        if(w00 == null) {
            throw new IllegalStateException(o.l(this, new StringBuilder("RecyclerView has no LayoutManager")));
        }
        return w00.generateDefaultLayoutParams();
    }

    @Override  // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet0) {
        w0 w00 = this.n;
        if(w00 == null) {
            throw new IllegalStateException(o.l(this, new StringBuilder("RecyclerView has no LayoutManager")));
        }
        return w00.generateLayoutParams(this.getContext(), attributeSet0);
    }

    @Override  // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        w0 w00 = this.n;
        if(w00 == null) {
            throw new IllegalStateException(o.l(this, new StringBuilder("RecyclerView has no LayoutManager")));
        }
        return w00.generateLayoutParams(viewGroup$LayoutParams0);
    }

    @Override  // android.view.ViewGroup
    public CharSequence getAccessibilityClassName() {
        return "androidx.recyclerview.widget.RecyclerView";
    }

    public j0 getAdapter() {
        return this.m;
    }

    @Override  // android.view.View
    public int getBaseline() {
        return this.n == null ? super.getBaseline() : -1;
    }

    public int getChildAdapterPosition(View view0) {
        O0 o00 = RecyclerView.H(view0);
        return o00 == null ? -1 : o00.getAbsoluteAdapterPosition();
    }

    @Override  // android.view.ViewGroup
    public int getChildDrawingOrder(int v, int v1) {
        return super.getChildDrawingOrder(v, v1);
    }

    public long getChildItemId(View view0) {
        if(this.m != null && this.m.hasStableIds()) {
            O0 o00 = RecyclerView.H(view0);
            return o00 == null ? -1L : o00.getItemId();
        }
        return -1L;
    }

    public int getChildLayoutPosition(View view0) {
        O0 o00 = RecyclerView.H(view0);
        return o00 == null ? -1 : o00.getLayoutPosition();
    }

    @Deprecated
    public int getChildPosition(View view0) {
        return this.getChildAdapterPosition(view0);
    }

    public O0 getChildViewHolder(View view0) {
        ViewParent viewParent0 = view0.getParent();
        if(viewParent0 != null && viewParent0 != this) {
            throw new IllegalArgumentException("View " + view0 + " is not a direct child of " + this);
        }
        return RecyclerView.H(view0);
    }

    @Override  // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.h;
    }

    public Q0 getCompatAccessibilityDelegate() {
        return this.K0;
    }

    public void getDecoratedBoundsWithMargins(View view0, Rect rect0) {
        RecyclerView.I(view0, rect0);
    }

    public o0 getEdgeEffectFactory() {
        return this.g0;
    }

    public q0 getItemAnimator() {
        return this.l0;
    }

    public r0 getItemDecorationAt(int v) {
        int v1 = this.getItemDecorationCount();
        if(v < 0 || v >= v1) {
            throw new IndexOutOfBoundsException(v + " is an invalid index for size " + v1);
        }
        return (r0)this.r.get(v);
    }

    public int getItemDecorationCount() {
        return this.r.size();
    }

    public w0 getLayoutManager() {
        return this.n;
    }

    public int getMaxFlingVelocity() {
        return this.w0;
    }

    public int getMinFlingVelocity() {
        return this.v0;
    }

    public long getNanoTime() [...] // 潜在的解密器

    public y0 getOnFlingListener() {
        return this.u0;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.z0;
    }

    public C0 getRecycledViewPool() {
        return this.c.c();
    }

    public int getScrollState() {
        return this.m0;
    }

    private r getScrollingChildHelper() {
        if(this.M0 == null) {
            this.M0 = new r(this);
        }
        return this.M0;
    }

    public final void h(O0 o00) {
        View view0 = o00.itemView;
        boolean z = view0.getParent() == this;
        O0 o01 = this.getChildViewHolder(view0);
        this.c.l(o01);
        if(o00.isTmpDetached()) {
            ViewGroup.LayoutParams viewGroup$LayoutParams0 = view0.getLayoutParams();
            this.f.b(view0, -1, viewGroup$LayoutParams0, true);
            return;
        }
        if(!z) {
            this.f.a(view0, -1, true);
            return;
        }
        j j0 = this.f;
        int v = j0.a.a.indexOfChild(view0);
        if(v < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view0);
        }
        j0.b.F(v);
        j0.i(view0);
    }

    public boolean hasFixedSize() {
        return this.E;
    }

    @Override  // android.view.View
    public boolean hasNestedScrollingParent() {
        return this.getScrollingChildHelper().f(0);
    }

    public boolean hasNestedScrollingParent(int v) {
        return this.getScrollingChildHelper().f(v);
    }

    // 去混淆评级： 低(30)
    public boolean hasPendingAdapterUpdates() {
        return !this.G || this.c0 || this.e.j();
    }

    public final void i(String s) {
        if(this.isComputingLayout()) {
            throw s == null ? new IllegalStateException(o.l(this, new StringBuilder("Cannot call this method while RecyclerView is computing a layout or scrolling"))) : new IllegalStateException(s);
        }
        if(this.f0 > 0) {
            Log.w("RecyclerView", "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException(o.l(this, new StringBuilder(""))));
        }
    }

    public void invalidateItemDecorations() {
        if(this.r.size() == 0) {
            return;
        }
        w0 w00 = this.n;
        if(w00 != null) {
            w00.assertNotInLayoutOrScroll("Cannot invalidate item decorations during a scroll or layout");
        }
        this.L();
        this.requestLayout();
    }

    public boolean isAnimating() {
        return this.l0 != null && this.l0.f();
    }

    @Override  // android.view.View
    public boolean isAttachedToWindow() {
        return this.D;
    }

    public boolean isComputingLayout() {
        return this.e0 > 0;
    }

    @Deprecated
    public boolean isLayoutFrozen() {
        return this.isLayoutSuppressed();
    }

    @Override  // android.view.ViewGroup
    public final boolean isLayoutSuppressed() {
        return this.N;
    }

    @Override  // android.view.View
    public boolean isNestedScrollingEnabled() {
        return this.getScrollingChildHelper().d;
    }

    public static void j(O0 o00) {
        WeakReference weakReference0 = o00.mNestedRecyclerView;
        if(weakReference0 != null) {
            for(View view0 = (View)weakReference0.get(); true; view0 = viewParent0 instanceof View ? ((View)viewParent0) : null) {
                if(view0 == null) {
                    o00.mNestedRecyclerView = null;
                    break;
                }
                if(view0 == o00.itemView) {
                    break;
                }
                ViewParent viewParent0 = view0.getParent();
            }
        }
    }

    public final void k() {
        int v = this.f.h();
        for(int v2 = 0; v2 < v; ++v2) {
            O0 o00 = RecyclerView.H(this.f.g(v2));
            if(!o00.shouldIgnore()) {
                o00.clearOldPosition();
            }
        }
        D0 d00 = this.c;
        ArrayList arrayList0 = d00.a;
        ArrayList arrayList1 = d00.c;
        int v3 = arrayList1.size();
        for(int v4 = 0; v4 < v3; ++v4) {
            ((O0)arrayList1.get(v4)).clearOldPosition();
        }
        int v5 = arrayList0.size();
        for(int v6 = 0; v6 < v5; ++v6) {
            ((O0)arrayList0.get(v6)).clearOldPosition();
        }
        ArrayList arrayList2 = d00.b;
        if(arrayList2 != null) {
            int v7 = arrayList2.size();
            for(int v1 = 0; v1 < v7; ++v1) {
                ((O0)d00.b.get(v1)).clearOldPosition();
            }
        }
    }

    public final void l(int v, int v1) {
        boolean z;
        if(this.h0 == null || this.h0.isFinished() || v <= 0) {
            z = false;
        }
        else {
            this.h0.onRelease();
            z = this.h0.isFinished();
        }
        if(this.j0 != null && !this.j0.isFinished() && v < 0) {
            this.j0.onRelease();
            z |= this.j0.isFinished();
        }
        if(this.i0 != null && !this.i0.isFinished() && v1 > 0) {
            this.i0.onRelease();
            z |= this.i0.isFinished();
        }
        if(this.k0 != null && !this.k0.isFinished() && v1 < 0) {
            this.k0.onRelease();
            z |= this.k0.isFinished();
        }
        if(z) {
            this.postInvalidateOnAnimation();
        }
    }

    public static int m(int v, EdgeEffect edgeEffect0, EdgeEffect edgeEffect1, int v1) {
        if(v > 0 && edgeEffect0 != null && EdgeEffectCompat.a(edgeEffect0) != 0.0f) {
            int v2 = Math.round(EdgeEffectCompat.b(edgeEffect0, ((float)(-v)) * 4.0f / ((float)v1), 0.5f) * (((float)(-v1)) / 4.0f));
            if(v2 != v) {
                edgeEffect0.finish();
            }
            return v - v2;
        }
        if(v < 0 && edgeEffect1 != null && EdgeEffectCompat.a(edgeEffect1) != 0.0f) {
            int v3 = Math.round(EdgeEffectCompat.b(edgeEffect1, ((float)v) * 4.0f / ((float)v1), 0.5f) * (((float)v1) / 4.0f));
            if(v3 != v) {
                edgeEffect1.finish();
            }
            return v - v3;
        }
        return v;
    }

    public final void n() {
        if(this.G && !this.c0) {
            if(this.e.j()) {
                b b0 = this.e;
                if((b0.a & 4) != 0 && (b0.a & 11) == 0) {
                    Trace.beginSection("RV PartialInvalidate");
                    this.e0();
                    this.O();
                    this.e.m();
                    if(!this.M) {
                        int v = this.f.e();
                        for(int v1 = 0; true; ++v1) {
                            if(v1 >= v) {
                                this.e.c();
                                break;
                            }
                            O0 o00 = RecyclerView.H(this.f.d(v1));
                            if(o00 != null && !o00.shouldIgnore() && o00.isUpdated()) {
                                this.q();
                                break;
                            }
                        }
                    }
                    this.g0(true);
                    this.P(true);
                    Trace.endSection();
                    return;
                }
                if(b0.j()) {
                    Trace.beginSection("RV FullInvalidate");
                    this.q();
                    Trace.endSection();
                }
            }
            return;
        }
        Trace.beginSection("RV FullInvalidate");
        this.q();
        Trace.endSection();
    }

    public void nestedScrollBy(int v, int v1) {
        this.M(v, v1, null);
    }

    public final void o(int v, int v1) {
        int v2 = this.getPaddingLeft();
        int v3 = w0.chooseSize(v, this.getPaddingRight() + v2, this.getMinimumWidth());
        int v4 = this.getPaddingTop();
        this.setMeasuredDimension(v3, w0.chooseSize(v1, this.getPaddingBottom() + v4, this.getMinimumHeight()));
    }

    public void offsetChildrenHorizontal(int v) {
        int v1 = this.f.e();
        for(int v2 = 0; v2 < v1; ++v2) {
            this.f.d(v2).offsetLeftAndRight(v);
        }
    }

    public void offsetChildrenVertical(int v) {
        int v1 = this.f.e();
        for(int v2 = 0; v2 < v1; ++v2) {
            this.f.d(v2).offsetTopAndBottom(v);
        }
    }

    @Override  // android.view.ViewGroup
    public void onAttachedToWindow() {
        float f1;
        super.onAttachedToWindow();
        this.e0 = 0;
        boolean z = true;
        this.D = true;
        if(!this.G || this.isLayoutRequested()) {
            z = false;
        }
        this.G = z;
        this.c.d();
        w0 w00 = this.n;
        if(w00 != null) {
            w00.dispatchAttachedToWindow(this);
        }
        this.J0 = false;
        ThreadLocal threadLocal0 = F.e;
        F f0 = (F)threadLocal0.get();
        this.B0 = f0;
        if(f0 == null) {
            this.B0 = new F();
            Display display0 = this.getDisplay();
            if(this.isInEditMode() || display0 == null) {
                f1 = 60.0f;
            }
            else {
                f1 = display0.getRefreshRate();
                if(f1 < 30.0f) {
                    f1 = 60.0f;
                }
            }
            F f2 = this.B0;
            f2.c = (long)(1000000000.0f / f1);
            threadLocal0.set(f2);
        }
        ArrayList arrayList0 = this.B0.a;
        if(RecyclerView.Y0 && arrayList0.contains(this)) {
            throw new IllegalStateException("RecyclerView already present in worker list!");
        }
        arrayList0.add(this);
    }

    public void onChildAttachedToWindow(View view0) {
    }

    public void onChildDetachedFromWindow(View view0) {
    }

    @Override  // android.view.ViewGroup
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        q0 q00 = this.l0;
        if(q00 != null) {
            q00.e();
        }
        this.stopScroll();
        this.D = false;
        w0 w00 = this.n;
        D0 d00 = this.c;
        if(w00 != null) {
            w00.dispatchDetachedFromWindow(this, d00);
        }
        this.Q0.clear();
        this.removeCallbacks(this.R0);
        this.g.getClass();
        while(a1.d.acquire() != null) {
        }
        ArrayList arrayList0 = d00.c;
        for(int v1 = 0; v1 < arrayList0.size(); ++v1) {
            k.i(((O0)arrayList0.get(v1)).itemView);
        }
        d00.e(d00.h.m, false);
        for(int v = 0; v < this.getChildCount(); ++v) {
            View view0 = this.getChildAt(v);
            if(view0 == null) {
                throw new IndexOutOfBoundsException();
            }
            ArrayList arrayList1 = k.t(view0).a;
            for(int v2 = k.s(arrayList1); -1 < v2; --v2) {
                ((Y0)arrayList1.get(v2)).a.c();
            }
        }
        F f0 = this.B0;
        if(f0 != null) {
            boolean z = f0.a.remove(this);
            if(RecyclerView.Y0 && !z) {
                throw new IllegalStateException("RecyclerView removal failed!");
            }
            this.B0 = null;
        }
    }

    @Override  // android.view.View
    public void onDraw(Canvas canvas0) {
        super.onDraw(canvas0);
        ArrayList arrayList0 = this.r;
        int v = arrayList0.size();
        for(int v1 = 0; v1 < v; ++v1) {
            ((r0)arrayList0.get(v1)).onDraw(canvas0, this, this.D0);
        }
    }

    @Override  // android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent0) {
        int v;
        float f2;
        boolean z;
        float f = 0.0f;
        if(this.n != null && !this.N && motionEvent0.getAction() == 8) {
            if((motionEvent0.getSource() & 2) != 0) {
                float f1 = this.n.canScrollVertically() ? -motionEvent0.getAxisValue(9) : 0.0f;
                if(this.n.canScrollHorizontally()) {
                    f = motionEvent0.getAxisValue(10);
                }
                z = false;
                f2 = f;
                f = f1;
                v = 0;
            }
            else if((motionEvent0.getSource() & 0x400000) == 0) {
                v = 0;
                z = false;
                f2 = 0.0f;
            }
            else {
                v = 26;
                f2 = motionEvent0.getAxisValue(26);
                if(this.n.canScrollVertically()) {
                    float f3 = -f2;
                    f2 = 0.0f;
                    f = f3;
                }
                else if(!this.n.canScrollHorizontally()) {
                    f2 = 0.0f;
                }
                z = this.V0;
            }
            int v1 = (int)(f * this.y0);
            int v2 = (int)(f2 * this.x0);
            if(z) {
                OverScroller overScroller0 = this.A0.c;
                int v3 = overScroller0.getFinalY();
                int v4 = overScroller0.getCurrY();
                this.d0(overScroller0.getFinalX() - overScroller0.getCurrX() + v2, v3 - v4 + v1, null, 0x80000000, true);
            }
            else {
                this.M(v2, v1, motionEvent0);
            }
            if(v != 0 && !z) {
                this.X0.a(motionEvent0, v);
            }
        }
        return false;
    }

    @Override  // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent0) {
        boolean z3;
        boolean z2;
        if(!this.N) {
            this.B = null;
            if(this.A(motionEvent0)) {
                VelocityTracker velocityTracker0 = this.o0;
                if(velocityTracker0 != null) {
                    velocityTracker0.clear();
                }
                this.stopNestedScroll(0);
                this.V();
                this.setScrollState(0);
                return true;
            }
            w0 w00 = this.n;
            if(w00 != null) {
                boolean z = w00.canScrollHorizontally();
                boolean z1 = this.n.canScrollVertically();
                if(this.o0 == null) {
                    this.o0 = VelocityTracker.obtain();
                }
                this.o0.addMovement(motionEvent0);
                int v = motionEvent0.getActionMasked();
                int v1 = motionEvent0.getActionIndex();
                switch(v) {
                    case 0: {
                        if(this.S) {
                            this.S = false;
                        }
                        this.n0 = motionEvent0.getPointerId(0);
                        float f = motionEvent0.getX();
                        this.r0 = (int)(f + 0.5f);
                        this.p0 = (int)(f + 0.5f);
                        float f1 = motionEvent0.getY();
                        this.s0 = (int)(f1 + 0.5f);
                        this.q0 = (int)(f1 + 0.5f);
                        if(this.h0 == null || EdgeEffectCompat.a(this.h0) == 0.0f || this.canScrollHorizontally(-1)) {
                            z2 = false;
                        }
                        else {
                            EdgeEffectCompat.b(this.h0, 0.0f, 1.0f - motionEvent0.getY() / ((float)this.getHeight()));
                            z2 = true;
                        }
                        if(this.j0 != null && EdgeEffectCompat.a(this.j0) != 0.0f && !this.canScrollHorizontally(1)) {
                            EdgeEffectCompat.b(this.j0, 0.0f, motionEvent0.getY() / ((float)this.getHeight()));
                            z2 = true;
                        }
                        if(this.i0 != null && EdgeEffectCompat.a(this.i0) != 0.0f && !this.canScrollVertically(-1)) {
                            EdgeEffectCompat.b(this.i0, 0.0f, motionEvent0.getX() / ((float)this.getWidth()));
                            z2 = true;
                        }
                        if(this.k0 != null && EdgeEffectCompat.a(this.k0) != 0.0f && !this.canScrollVertically(1)) {
                            EdgeEffectCompat.b(this.k0, 0.0f, 1.0f - motionEvent0.getX() / ((float)this.getWidth()));
                            z2 = true;
                        }
                        if(z2 || this.m0 == 2) {
                            this.getParent().requestDisallowInterceptTouchEvent(true);
                            this.setScrollState(1);
                            this.stopNestedScroll(1);
                        }
                        this.O0[1] = 0;
                        this.O0[0] = 0;
                        this.f0(0);
                        return this.m0 == 1;
                    }
                    case 1: {
                        this.o0.clear();
                        this.stopNestedScroll(0);
                        return this.m0 == 1;
                    }
                    case 2: {
                        int v2 = motionEvent0.findPointerIndex(this.n0);
                        if(v2 < 0) {
                            Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.n0 + " not found. Did any MotionEvents get skipped?");
                            return false;
                        }
                        float f2 = motionEvent0.getX(v2);
                        float f3 = motionEvent0.getY(v2);
                        if(this.m0 != 1) {
                            int v3 = ((int)(f3 + 0.5f)) - this.q0;
                            if(!z || Math.abs(((int)(f2 + 0.5f)) - this.p0) <= this.t0) {
                                z3 = false;
                            }
                            else {
                                this.r0 = (int)(f2 + 0.5f);
                                z3 = true;
                            }
                            if(z1 && Math.abs(v3) > this.t0) {
                                this.s0 = (int)(f3 + 0.5f);
                                z3 = true;
                            }
                            if(z3) {
                                this.setScrollState(1);
                                return this.m0 == 1;
                            }
                        }
                        return this.m0 == 1;
                    }
                    case 3: {
                        VelocityTracker velocityTracker1 = this.o0;
                        if(velocityTracker1 != null) {
                            velocityTracker1.clear();
                        }
                        this.stopNestedScroll(0);
                        this.V();
                        this.setScrollState(0);
                        return this.m0 == 1;
                    }
                    case 5: {
                        this.n0 = motionEvent0.getPointerId(v1);
                        float f4 = motionEvent0.getX(v1);
                        this.r0 = (int)(f4 + 0.5f);
                        this.p0 = (int)(f4 + 0.5f);
                        float f5 = motionEvent0.getY(v1);
                        this.s0 = (int)(f5 + 0.5f);
                        this.q0 = (int)(f5 + 0.5f);
                        return this.m0 == 1;
                    }
                    case 6: {
                        this.Q(motionEvent0);
                        return this.m0 == 1;
                    }
                    default: {
                        return this.m0 == 1;
                    }
                }
            }
        }
        return false;
    }

    @Override  // android.view.ViewGroup
    public void onLayout(boolean z, int v, int v1, int v2, int v3) {
        Trace.beginSection("RV OnLayout");
        this.q();
        Trace.endSection();
        this.G = true;
    }

    @Override  // android.view.View
    public void onMeasure(int v, int v1) {
        w0 w00 = this.n;
        if(w00 == null) {
            this.o(v, v1);
            return;
        }
        D0 d00 = this.c;
        boolean z = false;
        K0 k00 = this.D0;
        if(w00.isAutoMeasureEnabled()) {
            int v2 = View.MeasureSpec.getMode(v);
            int v3 = View.MeasureSpec.getMode(v1);
            this.n.onMeasure(d00, k00, v, v1);
            if(v2 == 0x40000000 && v3 == 0x40000000) {
                z = true;
            }
            this.S0 = z;
            if(!z && this.m != null) {
                if(k00.d == 1) {
                    this.r();
                }
                this.n.setMeasureSpecs(v, v1);
                k00.i = true;
                this.s();
                this.n.setMeasuredDimensionFromChildren(v, v1);
                if(this.n.shouldMeasureTwice()) {
                    this.n.setMeasureSpecs(View.MeasureSpec.makeMeasureSpec(this.getMeasuredWidth(), 0x40000000), View.MeasureSpec.makeMeasureSpec(this.getMeasuredHeight(), 0x40000000));
                    k00.i = true;
                    this.s();
                    this.n.setMeasuredDimensionFromChildren(v, v1);
                }
                this.T0 = this.getMeasuredWidth();
                this.U0 = this.getMeasuredHeight();
            }
            return;
        }
        if(this.E) {
            this.n.onMeasure(d00, k00, v, v1);
            return;
        }
        if(this.V) {
            this.e0();
            this.O();
            this.S();
            this.P(true);
            if(k00.k) {
                k00.g = true;
            }
            else {
                this.e.d();
                k00.g = false;
            }
            this.V = false;
            this.g0(false);
        }
        else if(k00.k) {
            this.setMeasuredDimension(this.getMeasuredWidth(), this.getMeasuredHeight());
            return;
        }
        j0 j00 = this.m;
        k00.e = j00 == null ? 0 : j00.getItemCount();
        this.e0();
        this.n.onMeasure(d00, k00, v, v1);
        this.g0(false);
        k00.g = false;
    }

    // 去混淆评级： 低(20)
    @Override  // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int v, Rect rect0) {
        return this.isComputingLayout() ? false : super.onRequestFocusInDescendants(v, rect0);
    }

    @Override  // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable0) {
        if(!(parcelable0 instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable0);
            return;
        }
        this.d = (SavedState)parcelable0;
        super.onRestoreInstanceState(((SavedState)parcelable0).a);
        this.requestLayout();
    }

    @Override  // android.view.View
    public Parcelable onSaveInstanceState() {
        Parcelable parcelable0 = new SavedState(super.onSaveInstanceState());  // 初始化器: Landroidx/customview/view/AbsSavedState;-><init>(Landroid/os/Parcelable;)V
        SavedState recyclerView$SavedState0 = this.d;
        if(recyclerView$SavedState0 != null) {
            parcelable0.c = recyclerView$SavedState0.c;
            return parcelable0;
        }
        w0 w00 = this.n;
        if(w00 != null) {
            parcelable0.c = w00.onSaveInstanceState();
            return parcelable0;
        }
        parcelable0.c = null;
        return parcelable0;
    }

    public void onScrollStateChanged(int v) {
    }

    public void onScrolled(int v, int v1) {
    }

    @Override  // android.view.View
    public void onSizeChanged(int v, int v1, int v2, int v3) {
        super.onSizeChanged(v, v1, v2, v3);
        if(v == v2 && v1 == v3) {
            return;
        }
        this.k0 = null;
        this.i0 = null;
        this.j0 = null;
        this.h0 = null;
    }

    @Override  // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent0) {
        boolean z3;
        boolean z;
        if(!this.N && !this.S) {
            z0 z00 = this.B;
            if(z00 != null) {
                z00.onTouchEvent(this, motionEvent0);
                switch(motionEvent0.getAction()) {
                    case 1: 
                    case 3: {
                        this.B = null;
                    }
                }
                z = true;
            }
            else if(motionEvent0.getAction() == 0) {
                z = false;
            }
            else {
                z = this.A(motionEvent0);
            }
            if(z) {
                VelocityTracker velocityTracker0 = this.o0;
                if(velocityTracker0 != null) {
                    velocityTracker0.clear();
                }
                this.stopNestedScroll(0);
                this.V();
                this.setScrollState(0);
                return true;
            }
            w0 w00 = this.n;
            if(w00 != null) {
                boolean z1 = w00.canScrollHorizontally();
                boolean z2 = this.n.canScrollVertically();
                if(this.o0 == null) {
                    this.o0 = VelocityTracker.obtain();
                }
                int v = motionEvent0.getActionMasked();
                int v1 = motionEvent0.getActionIndex();
                int[] arr_v = this.O0;
                if(v == 0) {
                    arr_v[1] = 0;
                    arr_v[0] = 0;
                }
                MotionEvent motionEvent1 = MotionEvent.obtain(motionEvent0);
                motionEvent1.offsetLocation(((float)arr_v[0]), ((float)arr_v[1]));
                switch(v) {
                    case 0: {
                        this.n0 = motionEvent0.getPointerId(0);
                        float f = motionEvent0.getX();
                        this.r0 = (int)(f + 0.5f);
                        this.p0 = (int)(f + 0.5f);
                        float f1 = motionEvent0.getY();
                        this.s0 = (int)(f1 + 0.5f);
                        this.q0 = (int)(f1 + 0.5f);
                        this.f0(0);
                        this.o0.addMovement(motionEvent1);
                        break;
                    }
                    case 1: {
                        this.o0.addMovement(motionEvent1);
                        this.o0.computeCurrentVelocity(1000, ((float)this.w0));
                        float f2 = z1 ? -this.o0.getXVelocity(this.n0) : 0.0f;
                        float f3 = z2 ? -this.o0.getYVelocity(this.n0) : 0.0f;
                        if(f2 == 0.0f && f3 == 0.0f || !this.fling(((int)f2), ((int)f3))) {
                            this.setScrollState(0);
                        }
                        VelocityTracker velocityTracker1 = this.o0;
                        if(velocityTracker1 != null) {
                            velocityTracker1.clear();
                        }
                        this.stopNestedScroll(0);
                        this.V();
                        break;
                    }
                    case 2: {
                        int v2 = motionEvent0.findPointerIndex(this.n0);
                        if(v2 < 0) {
                            Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.n0 + " not found. Did any MotionEvents get skipped?");
                            return false;
                        }
                        float f4 = motionEvent0.getX(v2);
                        float f5 = motionEvent0.getY(v2);
                        int v3 = this.r0 - ((int)(f4 + 0.5f));
                        int v4 = this.s0 - ((int)(f5 + 0.5f));
                        if(this.m0 != 1) {
                            if(z1) {
                                v3 = v3 <= 0 ? Math.min(0, v3 + this.t0) : Math.max(0, v3 - this.t0);
                                z3 = v3 == 0 ? false : true;
                            }
                            else {
                                z3 = false;
                            }
                            if(z2) {
                                v4 = v4 <= 0 ? Math.min(0, v4 + this.t0) : Math.max(0, v4 - this.t0);
                                if(v4 != 0) {
                                    z3 = true;
                                }
                            }
                            if(z3) {
                                this.setScrollState(1);
                            }
                        }
                        if(this.m0 == 1) {
                            int[] arr_v1 = this.P0;
                            arr_v1[0] = 0;
                            arr_v1[1] = 0;
                            int v5 = v3 - this.W(motionEvent0.getY(), v3);
                            int v6 = v4 - this.X(motionEvent0.getX(), v4);
                            boolean z4 = this.dispatchNestedPreScroll((z1 ? v5 : 0), (z2 ? v6 : 0), this.P0, this.N0, 0);
                            int[] arr_v2 = this.N0;
                            if(z4) {
                                v5 -= arr_v1[0];
                                v6 -= arr_v1[1];
                                arr_v[0] += arr_v2[0];
                                arr_v[1] += arr_v2[1];
                                this.getParent().requestDisallowInterceptTouchEvent(true);
                            }
                            this.r0 = ((int)(f4 + 0.5f)) - arr_v2[0];
                            this.s0 = ((int)(f5 + 0.5f)) - arr_v2[1];
                            if(this.Z((z1 ? v5 : 0), (z2 ? v6 : 0), motionEvent0, 0)) {
                                this.getParent().requestDisallowInterceptTouchEvent(true);
                            }
                            F f6 = this.B0;
                            if(f6 != null && (v5 != 0 || v6 != 0)) {
                                f6.a(this, v5, v6);
                            }
                        }
                        this.o0.addMovement(motionEvent1);
                        break;
                    }
                    case 3: {
                        VelocityTracker velocityTracker2 = this.o0;
                        if(velocityTracker2 != null) {
                            velocityTracker2.clear();
                        }
                        this.stopNestedScroll(0);
                        this.V();
                        this.setScrollState(0);
                        this.o0.addMovement(motionEvent1);
                        break;
                    }
                    case 5: {
                        this.n0 = motionEvent0.getPointerId(v1);
                        float f7 = motionEvent0.getX(v1);
                        this.r0 = (int)(f7 + 0.5f);
                        this.p0 = (int)(f7 + 0.5f);
                        float f8 = motionEvent0.getY(v1);
                        this.s0 = (int)(f8 + 0.5f);
                        this.q0 = (int)(f8 + 0.5f);
                        this.o0.addMovement(motionEvent1);
                        break;
                    }
                    case 6: {
                        this.Q(motionEvent0);
                        this.o0.addMovement(motionEvent1);
                        break;
                    }
                    default: {
                        this.o0.addMovement(motionEvent1);
                    }
                }
                motionEvent1.recycle();
                return true;
            }
        }
        return false;
    }

    public final void p(View view0) {
        RecyclerView.H(view0);
        ArrayList arrayList0 = this.b0;
        if(arrayList0 != null) {
            for(int v = arrayList0.size() - 1; v >= 0; --v) {
                ((x0)this.b0.get(v)).a(view0);
            }
        }
    }

    public final void q() {
        boolean z3;
        RecyclerView recyclerView1;
        if(this.m == null) {
            Log.w("RecyclerView", "No adapter attached; skipping layout");
            return;
        }
        if(this.n == null) {
            Log.e("RecyclerView", "No layout manager attached; skipping layout");
            return;
        }
        K0 k00 = this.D0;
        k00.i = false;
        boolean z = this.S0 && (this.T0 != this.getWidth() || this.U0 != this.getHeight());
        this.T0 = 0;
        this.U0 = 0;
        this.S0 = false;
        if(k00.d == 1) {
            this.r();
            this.n.setExactMeasureSpecsFrom(this);
            this.s();
        }
        else if(!((ArrayList)this.e.d).isEmpty() && !((ArrayList)this.e.c).isEmpty() || z || this.n.getWidth() != this.getWidth() || this.n.getHeight() != this.getHeight()) {
            this.n.setExactMeasureSpecsFrom(this);
            this.s();
        }
        else {
            this.n.setExactMeasureSpecsFrom(this);
        }
        k00.a(4);
        this.e0();
        this.O();
        k00.d = 1;
        D0 d00 = this.c;
        l l0 = this.g;
        if(k00.j) {
            for(int v = this.f.e() - 1; v >= 0; --v) {
                O0 o00 = RecyclerView.H(this.f.d(v));
                if(!o00.shouldIgnore()) {
                    long v1 = this.G(o00);
                    this.l0.getClass();
                    p0 p00 = new p0();  // 初始化器: Ljava/lang/Object;-><init>()V
                    p00.b(o00);
                    s s0 = (s)l0.c;
                    V v2 = (V)l0.b;
                    O0 o01 = (O0)s0.b(v1);
                    if(o01 == null || o01.shouldIgnore()) {
                        l0.e(o00, p00);
                    }
                    else {
                        a1 a10 = (a1)v2.get(o01);
                        boolean z1 = a10 != null && (a10.a & 1) != 0;
                        a1 a11 = (a1)v2.get(o00);
                        boolean z2 = a11 != null && (a11.a & 1) != 0;
                        if(!z1 || o01 != o00) {
                            p0 p01 = l0.l(o01, 4);
                            l0.e(o00, p00);
                            p0 p02 = l0.l(o00, 8);
                            if(p01 == null) {
                                int v3 = this.f.e();
                                for(int v4 = 0; v4 < v3; ++v4) {
                                    O0 o02 = RecyclerView.H(this.f.d(v4));
                                    if(o02 != o00 && this.G(o02) == v1) {
                                        if(this.m != null && this.m.hasStableIds()) {
                                            StringBuilder stringBuilder0 = new StringBuilder("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:");
                                            stringBuilder0.append(o02);
                                            stringBuilder0.append(" \n View Holder 2:");
                                            stringBuilder0.append(o00);
                                            throw new IllegalStateException(o.l(this, stringBuilder0));
                                        }
                                        StringBuilder stringBuilder1 = new StringBuilder("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:");
                                        stringBuilder1.append(o02);
                                        stringBuilder1.append(" \n View Holder 2:");
                                        stringBuilder1.append(o00);
                                        throw new IllegalStateException(o.l(this, stringBuilder1));
                                    }
                                }
                                Log.e("RecyclerView", "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + o01 + " cannot be found but it is necessary for " + o00 + this.y());
                            }
                            else {
                                o01.setIsRecyclable(false);
                                if(z1) {
                                    this.h(o01);
                                }
                                if(o01 != o00) {
                                    if(z2) {
                                        this.h(o00);
                                    }
                                    o01.mShadowedHolder = o00;
                                    this.h(o01);
                                    d00.l(o01);
                                    o00.setIsRecyclable(false);
                                    o00.mShadowingHolder = o01;
                                }
                                if(this.l0.a(o01, o00, p01, p02)) {
                                    this.R();
                                }
                            }
                        }
                        else {
                            l0.e(o00, p00);
                        }
                    }
                }
            }
            V v5 = (V)l0.b;
            for(int v6 = v5.size() - 1; v6 >= 0; --v6) {
                O0 o03 = (O0)v5.keyAt(v6);
                a1 a12 = (a1)v5.removeAt(v6);
                int v7 = a12.a;
                h0 h00 = this.W0;
                if((v7 & 3) == 3) {
                    h00.a.n.removeAndRecycleView(o03.itemView, h00.a.c);
                }
                else if((v7 & 1) != 0) {
                    p0 p03 = a12.b;
                    if(p03 == null) {
                        h00.a.n.removeAndRecycleView(o03.itemView, h00.a.c);
                    }
                    else {
                        h00.j(o03, p03, a12.c);
                    }
                }
                else if((v7 & 14) == 14) {
                    h00.i(o03, a12.b, a12.c);
                }
                else if((v7 & 12) == 12) {
                    p0 p04 = a12.b;
                    p0 p05 = a12.c;
                    h00.getClass();
                    o03.setIsRecyclable(false);
                    RecyclerView recyclerView0 = h00.a;
                    if(!recyclerView0.c0) {
                        androidx.recyclerview.widget.q q0 = (androidx.recyclerview.widget.q)recyclerView0.l0;
                        q0.getClass();
                        int v8 = p04.a;
                        int v9 = p05.a;
                        if(v8 != v9 || p04.b != p05.b) {
                            recyclerView1 = recyclerView0;
                            z3 = q0.g(o03, v8, p04.b, v9, p05.b);
                        }
                        else {
                            q0.c(o03);
                            recyclerView1 = recyclerView0;
                            z3 = false;
                        }
                        if(z3) {
                            recyclerView1.R();
                        }
                    }
                    else if(recyclerView0.l0.a(o03, o03, p04, p05)) {
                        recyclerView0.R();
                    }
                }
                else if((v7 & 4) != 0) {
                    h00.j(o03, a12.b, null);
                }
                else if((v7 & 8) != 0) {
                    h00.i(o03, a12.b, a12.c);
                }
                a12.a = 0;
                a12.b = null;
                a12.c = null;
                a1.d.release(a12);
            }
        }
        View view0 = null;
        this.n.removeAndRecycleScrapInt(d00);
        k00.b = k00.e;
        int v10 = 0;
        this.c0 = false;
        this.d0 = false;
        k00.j = false;
        k00.k = false;
        this.n.mRequestedSimpleAnimations = false;
        ArrayList arrayList0 = d00.b;
        if(arrayList0 != null) {
            arrayList0.clear();
        }
        w0 w00 = this.n;
        if(w00.mPrefetchMaxObservedInInitialPrefetch) {
            w00.mPrefetchMaxCountObserved = 0;
            w00.mPrefetchMaxObservedInInitialPrefetch = false;
            d00.m();
        }
        this.n.onLayoutCompleted(k00);
        this.P(true);
        this.g0(false);
        ((V)l0.b).clear();
        ((s)l0.c).a();
        int v11 = this.L0[0];
        int v12 = this.L0[true];
        this.B(this.L0);
        if(this.L0[0] != v11 || this.L0[true] != v12) {
            this.t(0, 0);
        }
        if(this.z0 && this.m != null && this.hasFocus() && this.getDescendantFocusability() != 0x60000 && (this.getDescendantFocusability() != 0x20000 || !this.isFocused())) {
            if(this.isFocused()) {
            label_175:
                O0 o04 = k00.m == -1L || !this.m.hasStableIds() ? null : this.findViewHolderForItemId(k00.m);
                if(o04 != null && !this.f.c.contains(o04.itemView) && o04.itemView.hasFocusable()) {
                    view0 = o04.itemView;
                }
                else if(this.f.e() > 0) {
                    int v13 = k00.l;
                    if(v13 != -1) {
                        v10 = v13;
                    }
                    int v14 = k00.b();
                    int v15 = v10;
                    while(v15 < v14) {
                        O0 o05 = this.findViewHolderForAdapterPosition(v15);
                        if(o05 == null) {
                            break;
                        }
                        if(o05.itemView.hasFocusable()) {
                            view0 = o05.itemView;
                            goto label_202;
                        }
                        ++v15;
                    }
                    for(int v16 = Math.min(v14, v10) - 1; v16 >= 0; --v16) {
                        O0 o06 = this.findViewHolderForAdapterPosition(v16);
                        if(o06 == null) {
                            break;
                        }
                        if(o06.itemView.hasFocusable()) {
                            view0 = o06.itemView;
                            break;
                        }
                    }
                }
            label_202:
                if(view0 != null) {
                    int v17 = k00.n;
                    if(((long)v17) != -1L) {
                        View view2 = view0.findViewById(v17);
                        if(view2 != null && view2.isFocusable()) {
                            view0 = view2;
                        }
                    }
                    view0.requestFocus();
                }
            }
            else {
                View view1 = this.getFocusedChild();
                if(this.f.c.contains(view1)) {
                    goto label_175;
                }
            }
        }
        k00.m = -1L;
        k00.l = -1;
        k00.n = -1;
    }

    public final void r() {
        int v3;
        K0 k00 = this.D0;
        k00.a(1);
        this.z(k00);
        k00.i = false;
        this.e0();
        V v0 = (V)this.g.b;
        V v1 = (V)this.g.b;
        v0.clear();
        s s0 = (s)this.g.c;
        s0.a();
        this.O();
        this.S();
        O0 o00 = null;
        View view0 = !this.z0 || !this.hasFocus() || this.m == null ? null : this.getFocusedChild();
        if(view0 != null) {
            o00 = this.findContainingViewHolder(view0);
        }
        long v2 = -1L;
        if(o00 == null) {
            k00.m = -1L;
            k00.l = -1;
            k00.n = -1;
        }
        else {
            if(this.m.hasStableIds()) {
                v2 = o00.getItemId();
            }
            k00.m = v2;
            if(this.c0) {
                v3 = -1;
            }
            else {
                v3 = o00.isRemoved() ? o00.mOldPosition : o00.getAbsoluteAdapterPosition();
            }
            k00.l = v3;
            View view1 = o00.itemView;
            int v4 = view1.getId();
            while(!view1.isFocused() && view1 instanceof ViewGroup && view1.hasFocus()) {
                view1 = ((ViewGroup)view1).getFocusedChild();
                if(view1.getId() != -1) {
                    v4 = view1.getId();
                }
            }
            k00.n = v4;
        }
        k00.h = k00.j && this.H0;
        this.H0 = false;
        this.G0 = false;
        k00.g = k00.k;
        k00.e = this.m.getItemCount();
        this.B(this.L0);
        if(k00.j) {
            int v5 = this.f.e();
            for(int v6 = 0; v6 < v5; ++v6) {
                O0 o01 = RecyclerView.H(this.f.d(v6));
                if(!o01.shouldIgnore() && (!o01.isInvalid() || this.m.hasStableIds())) {
                    q0 q00 = this.l0;
                    q0.b(o01);
                    o01.getUnmodifiedPayloads();
                    q00.getClass();
                    p0 p00 = new p0();  // 初始化器: Ljava/lang/Object;-><init>()V
                    p00.b(o01);
                    a1 a10 = (a1)v1.get(o01);
                    if(a10 == null) {
                        a10 = a1.a();
                        v1.put(o01, a10);
                    }
                    a10.b = p00;
                    a10.a |= 4;
                    if(k00.h && o01.isUpdated() && !o01.isRemoved() && !o01.shouldIgnore() && !o01.isInvalid()) {
                        s0.f(this.G(o01), o01);
                    }
                }
            }
        }
        if(k00.k) {
            int v7 = this.f.h();
            for(int v8 = 0; v8 < v7; ++v8) {
                O0 o02 = RecyclerView.H(this.f.g(v8));
                if(RecyclerView.Y0 && o02.mPosition == -1 && !o02.isRemoved()) {
                    throw new IllegalStateException(o.l(this, new StringBuilder("view holder cannot have position -1 unless it is removed")));
                }
                if(!o02.shouldIgnore()) {
                    o02.saveOldPosition();
                }
            }
            boolean z = k00.f;
            k00.f = false;
            this.n.onLayoutChildren(this.c, k00);
            k00.f = z;
            for(int v9 = 0; v9 < this.f.e(); ++v9) {
                O0 o03 = RecyclerView.H(this.f.d(v9));
                if(!o03.shouldIgnore()) {
                    a1 a11 = (a1)v1.get(o03);
                    if(a11 == null || (a11.a & 4) == 0) {
                        q0.b(o03);
                        boolean z1 = o03.hasAnyOfTheFlags(0x2000);
                        q0 q01 = this.l0;
                        o03.getUnmodifiedPayloads();
                        q01.getClass();
                        p0 p01 = new p0();  // 初始化器: Ljava/lang/Object;-><init>()V
                        p01.b(o03);
                        if(z1) {
                            this.U(o03, p01);
                        }
                        else {
                            a1 a12 = (a1)v1.get(o03);
                            if(a12 == null) {
                                a12 = a1.a();
                                v1.put(o03, a12);
                            }
                            a12.a |= 2;
                            a12.b = p01;
                        }
                    }
                }
            }
        }
        this.k();
        this.P(true);
        this.g0(false);
        k00.d = 2;
    }

    @Override  // android.view.ViewGroup
    public void removeDetachedView(View view0, boolean z) {
        O0 o00 = RecyclerView.H(view0);
        if(o00 != null) {
            if(o00.isTmpDetached()) {
                o00.clearTmpDetachFlag();
                view0.clearAnimation();
                this.p(view0);
                super.removeDetachedView(view0, z);
                return;
            }
            if(o00.shouldIgnore()) {
                view0.clearAnimation();
                this.p(view0);
                super.removeDetachedView(view0, z);
                return;
            }
            StringBuilder stringBuilder0 = new StringBuilder("Called removeDetachedView with a view which is not flagged as tmp detached.");
            stringBuilder0.append(o00);
            throw new IllegalArgumentException(o.l(this, stringBuilder0));
        }
        if(!RecyclerView.Y0) {
            view0.clearAnimation();
            this.p(view0);
            super.removeDetachedView(view0, z);
            return;
        }
        StringBuilder stringBuilder1 = new StringBuilder("No ViewHolder found for child: ");
        stringBuilder1.append(view0);
        throw new IllegalArgumentException(o.l(this, stringBuilder1));
    }

    public void removeItemDecoration(r0 r00) {
        w0 w00 = this.n;
        if(w00 != null) {
            w00.assertNotInLayoutOrScroll("Cannot remove item decoration during a scroll  or layout");
        }
        this.r.remove(r00);
        if(this.r.isEmpty()) {
            this.setWillNotDraw(this.getOverScrollMode() == 2);
        }
        this.L();
        this.requestLayout();
    }

    public void removeItemDecorationAt(int v) {
        int v1 = this.getItemDecorationCount();
        if(v < 0 || v >= v1) {
            throw new IndexOutOfBoundsException(v + " is an invalid index for size " + v1);
        }
        this.removeItemDecoration(this.getItemDecorationAt(v));
    }

    public void removeOnChildAttachStateChangeListener(x0 x00) {
        ArrayList arrayList0 = this.b0;
        if(arrayList0 == null) {
            return;
        }
        arrayList0.remove(x00);
    }

    public void removeOnItemTouchListener(z0 z00) {
        this.w.remove(z00);
        if(this.B == z00) {
            this.B = null;
        }
    }

    public void removeOnScrollListener(A0 a00) {
        ArrayList arrayList0 = this.F0;
        if(arrayList0 != null) {
            arrayList0.remove(a00);
        }
    }

    public void removeRecyclerListener(E0 e00) {
        this.o.remove(e00);
    }

    @Override  // android.view.ViewGroup
    public void requestChildFocus(View view0, View view1) {
        if(!this.n.onRequestChildFocus(this, this.D0, view0, view1) && view1 != null) {
            this.Y(view0, view1);
        }
        super.requestChildFocus(view0, view1);
    }

    @Override  // android.view.ViewGroup
    public boolean requestChildRectangleOnScreen(View view0, Rect rect0, boolean z) {
        return this.n.requestChildRectangleOnScreen(this, view0, rect0, z);
    }

    @Override  // android.view.ViewGroup
    public void requestDisallowInterceptTouchEvent(boolean z) {
        ArrayList arrayList0 = this.w;
        int v = arrayList0.size();
        for(int v1 = 0; v1 < v; ++v1) {
            ((z0)arrayList0.get(v1)).onRequestDisallowInterceptTouchEvent(z);
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    @Override  // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if(this.I == 0 && !this.N) {
            super.requestLayout();
            return;
        }
        this.M = true;
    }

    public final void s() {
        this.e0();
        this.O();
        K0 k00 = this.D0;
        k00.a(6);
        this.e.d();
        k00.e = this.m.getItemCount();
        k00.c = 0;
        if(this.d != null && this.m.canRestoreState()) {
            Parcelable parcelable0 = this.d.c;
            if(parcelable0 != null) {
                this.n.onRestoreInstanceState(parcelable0);
            }
            this.d = null;
        }
        k00.g = false;
        this.n.onLayoutChildren(this.c, k00);
        k00.f = false;
        k00.j = k00.j && this.l0 != null;
        k00.d = 4;
        this.P(true);
        this.g0(false);
    }

    @Override  // android.view.View
    public void scrollBy(int v, int v1) {
        w0 w00 = this.n;
        if(w00 == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if(!this.N) {
            boolean z = w00.canScrollHorizontally();
            boolean z1 = this.n.canScrollVertically();
            if(z || z1) {
                if(!z) {
                    v = 0;
                }
                if(!z1) {
                    v1 = 0;
                }
                this.Z(v, v1, null, 0);
            }
        }
    }

    @Override  // android.view.View
    public void scrollTo(int v, int v1) {
        Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    public void scrollToPosition(int v) {
        if(this.N) {
            return;
        }
        this.stopScroll();
        w0 w00 = this.n;
        if(w00 == null) {
            Log.e("RecyclerView", "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        w00.scrollToPosition(v);
        this.awakenScrollBars();
    }

    @Override  // android.view.View
    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent0) {
        int v = 0;
        if(this.isComputingLayout()) {
            int v1 = accessibilityEvent0 == null ? 0 : accessibilityEvent0.getContentChangeTypes();
            if(v1 != 0) {
                v = v1;
            }
            this.T |= v;
            return;
        }
        super.sendAccessibilityEventUnchecked(accessibilityEvent0);
    }

    public void setAccessibilityDelegateCompat(Q0 q00) {
        this.K0 = q00;
        W.o(this, q00);
    }

    public void setAdapter(j0 j00) {
        this.setLayoutFrozen(false);
        this.b0(j00, false, true);
        this.T(false);
        this.requestLayout();
    }

    public void setChildDrawingOrderCallback(n0 n00) {
        if(n00 == null) {
            return;
        }
        this.setChildrenDrawingOrderEnabled(n00 != null);
    }

    @Override  // android.view.ViewGroup
    public void setClipToPadding(boolean z) {
        if(z != this.h) {
            this.k0 = null;
            this.i0 = null;
            this.j0 = null;
            this.h0 = null;
        }
        this.h = z;
        super.setClipToPadding(z);
        if(this.G) {
            this.requestLayout();
        }
    }

    public static void setDebugAssertionsEnabled(boolean z) {
        RecyclerView.Y0 = z;
    }

    public void setEdgeEffectFactory(o0 o00) {
        o00.getClass();
        this.g0 = o00;
        this.k0 = null;
        this.i0 = null;
        this.j0 = null;
        this.h0 = null;
    }

    public void setHasFixedSize(boolean z) {
        this.E = z;
    }

    public void setItemAnimator(q0 q00) {
        q0 q01 = this.l0;
        if(q01 != null) {
            q01.e();
            this.l0.a = null;
        }
        this.l0 = q00;
        if(q00 != null) {
            q00.a = this.I0;
        }
    }

    public void setItemViewCacheSize(int v) {
        this.c.e = v;
        this.c.m();
    }

    @Deprecated
    public void setLayoutFrozen(boolean z) {
        this.suppressLayout(z);
    }

    public void setLayoutManager(w0 w00) {
        if(w00 == this.n) {
            return;
        }
        this.stopScroll();
        D0 d00 = this.c;
        if(this.n == null) {
            d00.a.clear();
            d00.f();
        }
        else {
            q0 q00 = this.l0;
            if(q00 != null) {
                q00.e();
            }
            this.n.removeAndRecycleAllViews(d00);
            this.n.removeAndRecycleScrapInt(d00);
            d00.a.clear();
            d00.f();
            if(this.D) {
                this.n.dispatchDetachedFromWindow(this, d00);
            }
            this.n.setRecyclerView(null);
            this.n = null;
        }
        RecyclerView recyclerView0 = this.f.a.a;
        this.f.b.E();
        ArrayList arrayList0 = this.f.c;
        for(int v = arrayList0.size() - 1; v >= 0; --v) {
            O0 o00 = RecyclerView.H(((View)arrayList0.get(v)));
            if(o00 != null) {
                o00.onLeftHiddenState(recyclerView0);
            }
            arrayList0.remove(v);
        }
        int v1 = recyclerView0.getChildCount();
        for(int v2 = 0; v2 < v1; ++v2) {
            View view0 = recyclerView0.getChildAt(v2);
            recyclerView0.p(view0);
            view0.clearAnimation();
        }
        recyclerView0.removeAllViews();
        this.n = w00;
        if(w00 != null) {
            if(w00.mRecyclerView != null) {
                goto label_46;
            }
            w00.setRecyclerView(this);
            if(this.D) {
                this.n.dispatchAttachedToWindow(this);
                d00.m();
                this.requestLayout();
                return;
            label_46:
                StringBuilder stringBuilder0 = new StringBuilder("LayoutManager ");
                stringBuilder0.append(w00);
                stringBuilder0.append(" is already attached to a RecyclerView:");
                throw new IllegalArgumentException(o.l(w00.mRecyclerView, stringBuilder0));
            }
        }
        d00.m();
        this.requestLayout();
    }

    @Override  // android.view.ViewGroup
    @Deprecated
    public void setLayoutTransition(LayoutTransition layoutTransition0) {
        if(layoutTransition0 != null) {
            throw new IllegalArgumentException("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
        }
        super.setLayoutTransition(null);
    }

    @Override  // android.view.View
    public void setNestedScrollingEnabled(boolean z) {
        this.getScrollingChildHelper().g(z);
    }

    public void setOnFlingListener(y0 y00) {
        this.u0 = y00;
    }

    @Deprecated
    public void setOnScrollListener(A0 a00) {
        this.E0 = a00;
    }

    public void setPreserveFocusAfterLayout(boolean z) {
        this.z0 = z;
    }

    public void setRecycledViewPool(C0 c00) {
        D0 d00 = this.c;
        RecyclerView recyclerView0 = d00.h;
        d00.e(recyclerView0.m, false);
        C0 c01 = d00.g;
        if(c01 != null) {
            --c01.b;
        }
        d00.g = c00;
        if(c00 != null && recyclerView0.getAdapter() != null) {
            ++d00.g.b;
        }
        d00.d();
    }

    @Deprecated
    public void setRecyclerListener(E0 e00) {
    }

    public void setScrollState(int v) {
        if(v != this.m0) {
            if(RecyclerView.Z0) {
                StringBuilder stringBuilder0 = x.n(v, "setting scroll state to ", " from ");
                stringBuilder0.append(this.m0);
                Log.d("RecyclerView", stringBuilder0.toString(), new Exception());
            }
            this.m0 = v;
            if(v != 2) {
                this.A0.g.removeCallbacks(this.A0);
                this.A0.c.abortAnimation();
                w0 w00 = this.n;
                if(w00 != null) {
                    w00.stopSmoothScroller();
                }
            }
            w0 w01 = this.n;
            if(w01 != null) {
                w01.onScrollStateChanged(v);
            }
            A0 a00 = this.E0;
            if(a00 != null) {
                a00.onScrollStateChanged(this, v);
            }
            ArrayList arrayList0 = this.F0;
            if(arrayList0 != null) {
                for(int v1 = arrayList0.size() - 1; v1 >= 0; --v1) {
                    ((A0)this.F0.get(v1)).onScrollStateChanged(this, v);
                }
            }
        }
    }

    public void setScrollingTouchSlop(int v) {
        ViewConfiguration viewConfiguration0 = ViewConfiguration.get(this.getContext());
        switch(v) {
            case 0: {
                break;
            }
            case 1: {
                this.t0 = viewConfiguration0.getScaledPagingTouchSlop();
                return;
            }
            default: {
                Log.w("RecyclerView", "setScrollingTouchSlop(): bad argument constant " + v + "; using default value");
                break;
            }
        }
        this.t0 = viewConfiguration0.getScaledTouchSlop();
    }

    public static void setVerboseLoggingEnabled(boolean z) {
        RecyclerView.Z0 = z;
    }

    public void setViewCacheExtension(M0 m00) {
        this.c.getClass();
    }

    public void smoothScrollBy(int v, int v1) {
        this.smoothScrollBy(v, v1, null);
    }

    public void smoothScrollBy(int v, int v1, Interpolator interpolator0) {
        this.smoothScrollBy(v, v1, interpolator0, 0x80000000);
    }

    public void smoothScrollBy(int v, int v1, Interpolator interpolator0, int v2) {
        this.d0(v, v1, interpolator0, v2, false);
    }

    public void smoothScrollToPosition(int v) {
        if(this.N) {
            return;
        }
        w0 w00 = this.n;
        if(w00 == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        w00.smoothScrollToPosition(this, this.D0, v);
    }

    @Override  // android.view.View
    public boolean startNestedScroll(int v) {
        return this.getScrollingChildHelper().h(v, 0);
    }

    public boolean startNestedScroll(int v, int v1) {
        return this.getScrollingChildHelper().h(v, v1);
    }

    @Override  // android.view.View
    public void stopNestedScroll() {
        this.getScrollingChildHelper().i(0);
    }

    public void stopNestedScroll(int v) {
        this.getScrollingChildHelper().i(v);
    }

    public void stopScroll() {
        this.setScrollState(0);
        this.A0.g.removeCallbacks(this.A0);
        this.A0.c.abortAnimation();
        w0 w00 = this.n;
        if(w00 != null) {
            w00.stopSmoothScroller();
        }
    }

    @Override  // android.view.ViewGroup
    public final void suppressLayout(boolean z) {
        if(z != this.N) {
            this.i("Do not suppressLayout in layout or scroll");
            if(!z) {
                this.N = false;
                if(this.M && this.n != null && this.m != null) {
                    this.requestLayout();
                }
                this.M = false;
                return;
            }
            long v = SystemClock.uptimeMillis();
            this.onTouchEvent(MotionEvent.obtain(v, v, 3, 0.0f, 0.0f, 0));
            this.N = true;
            this.S = true;
            this.stopScroll();
        }
    }

    public void swapAdapter(j0 j00, boolean z) {
        this.setLayoutFrozen(false);
        this.b0(j00, true, z);
        this.T(true);
        this.requestLayout();
    }

    public final void t(int v, int v1) {
        ++this.f0;
        int v2 = this.getScrollX();
        int v3 = this.getScrollY();
        this.onScrollChanged(v2, v3, v2 - v, v3 - v1);
        A0 a00 = this.E0;
        if(a00 != null) {
            a00.onScrolled(this, v, v1);
        }
        ArrayList arrayList0 = this.F0;
        if(arrayList0 != null) {
            for(int v4 = arrayList0.size() - 1; v4 >= 0; --v4) {
                ((A0)this.F0.get(v4)).onScrolled(this, v, v1);
            }
        }
        --this.f0;
    }

    public final void u() {
        if(this.k0 != null) {
            return;
        }
        ((L0)this.g0).getClass();
        EdgeEffect edgeEffect0 = new EdgeEffect(this.getContext());
        this.k0 = edgeEffect0;
        if(this.h) {
            edgeEffect0.setSize(this.getMeasuredWidth() - this.getPaddingLeft() - this.getPaddingRight(), this.getMeasuredHeight() - this.getPaddingTop() - this.getPaddingBottom());
            return;
        }
        edgeEffect0.setSize(this.getMeasuredWidth(), this.getMeasuredHeight());
    }

    public final void v() {
        if(this.h0 != null) {
            return;
        }
        ((L0)this.g0).getClass();
        EdgeEffect edgeEffect0 = new EdgeEffect(this.getContext());
        this.h0 = edgeEffect0;
        if(this.h) {
            edgeEffect0.setSize(this.getMeasuredHeight() - this.getPaddingTop() - this.getPaddingBottom(), this.getMeasuredWidth() - this.getPaddingLeft() - this.getPaddingRight());
            return;
        }
        edgeEffect0.setSize(this.getMeasuredHeight(), this.getMeasuredWidth());
    }

    public final void w() {
        if(this.j0 != null) {
            return;
        }
        ((L0)this.g0).getClass();
        EdgeEffect edgeEffect0 = new EdgeEffect(this.getContext());
        this.j0 = edgeEffect0;
        if(this.h) {
            edgeEffect0.setSize(this.getMeasuredHeight() - this.getPaddingTop() - this.getPaddingBottom(), this.getMeasuredWidth() - this.getPaddingLeft() - this.getPaddingRight());
            return;
        }
        edgeEffect0.setSize(this.getMeasuredHeight(), this.getMeasuredWidth());
    }

    public final void x() {
        if(this.i0 != null) {
            return;
        }
        ((L0)this.g0).getClass();
        EdgeEffect edgeEffect0 = new EdgeEffect(this.getContext());
        this.i0 = edgeEffect0;
        if(this.h) {
            edgeEffect0.setSize(this.getMeasuredWidth() - this.getPaddingLeft() - this.getPaddingRight(), this.getMeasuredHeight() - this.getPaddingTop() - this.getPaddingBottom());
            return;
        }
        edgeEffect0.setSize(this.getMeasuredWidth(), this.getMeasuredHeight());
    }

    public final String y() {
        return " " + super.toString() + ", adapter:" + this.m + ", layout:" + this.n + ", context:" + this.getContext();
    }

    public final void z(K0 k00) {
        if(this.getScrollState() == 2) {
            OverScroller overScroller0 = this.A0.c;
            overScroller0.getFinalX();
            overScroller0.getCurrX();
            k00.getClass();
            overScroller0.getFinalY();
            overScroller0.getCurrY();
            return;
        }
        k00.getClass();
    }
}

