package androidx.coordinatorlayout.widget;

import A1.f;
import J0.m;
import K1.a;
import L1.b;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup.OnHierarchyChangeListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.collection.V;
import androidx.customview.view.AbsSavedState;
import b2.e;
import c2.B0;
import c2.K;
import c2.M;
import c2.s;
import c2.t;
import c2.u;
import d5.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class CoordinatorLayout extends ViewGroup implements s, t {
    public static abstract class Behavior {
        public Behavior(Context context0, AttributeSet attributeSet0) {
        }

        public boolean e(View view0, Rect rect0) {
            return false;
        }

        public boolean f(View view0, View view1) {
            return false;
        }

        public void g(c c0) {
        }

        public boolean h(CoordinatorLayout coordinatorLayout0, View view0, View view1) {
            return false;
        }

        public void i(CoordinatorLayout coordinatorLayout0, View view0) {
        }

        public void j() {
        }

        public boolean k(CoordinatorLayout coordinatorLayout0, View view0, MotionEvent motionEvent0) {
            return false;
        }

        public boolean l(CoordinatorLayout coordinatorLayout0, View view0, int v) {
            return false;
        }

        public boolean m(CoordinatorLayout coordinatorLayout0, View view0, int v, int v1, int v2) {
            return false;
        }

        public boolean n(View view0) {
            return false;
        }

        public void o(CoordinatorLayout coordinatorLayout0, View view0, View view1, int v, int v1, int[] arr_v, int v2) {
        }

        public void p(CoordinatorLayout coordinatorLayout0, View view0, int v, int v1, int v2, int[] arr_v) {
            arr_v[0] += v1;
            arr_v[1] += v2;
        }

        public boolean q(CoordinatorLayout coordinatorLayout0, View view0, Rect rect0, boolean z) {
            return false;
        }

        public void r(View view0, Parcelable parcelable0) {
        }

        public Parcelable s(View view0) {
            return View.BaseSavedState.EMPTY_STATE;
        }

        public boolean t(CoordinatorLayout coordinatorLayout0, View view0, View view1, View view2, int v, int v1) {
            return false;
        }

        public void u(CoordinatorLayout coordinatorLayout0, View view0, View view1, int v) {
        }

        public boolean v(CoordinatorLayout coordinatorLayout0, View view0, MotionEvent motionEvent0) {
            return false;
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator CREATOR;
        public SparseArray c;

        static {
            SavedState.CREATOR = new d();  // 初始化器: Ljava/lang/Object;-><init>()V
        }

        public SavedState(Parcel parcel0, ClassLoader classLoader0) {
            super(parcel0, classLoader0);
            int v = parcel0.readInt();
            int[] arr_v = new int[v];
            parcel0.readIntArray(arr_v);
            Parcelable[] arr_parcelable = parcel0.readParcelableArray(classLoader0);
            this.c = new SparseArray(v);
            for(int v1 = 0; v1 < v; ++v1) {
                this.c.append(arr_v[v1], arr_parcelable[v1]);
            }
        }

        @Override  // androidx.customview.view.AbsSavedState
        public final void writeToParcel(Parcel parcel0, int v) {
            super.writeToParcel(parcel0, v);
            int v2 = this.c == null ? 0 : this.c.size();
            parcel0.writeInt(v2);
            int[] arr_v = new int[v2];
            Parcelable[] arr_parcelable = new Parcelable[v2];
            for(int v1 = 0; v1 < v2; ++v1) {
                arr_v[v1] = this.c.keyAt(v1);
                arr_parcelable[v1] = (Parcelable)this.c.valueAt(v1);
            }
            parcel0.writeIntArray(arr_v);
            parcel0.writeParcelableArray(arr_parcelable, v);
        }
    }

    public I7.c B;
    public final u D;
    public static final String E;
    public static final Class[] G;
    public static final ThreadLocal I;
    public static final f M;
    public static final b2.f N;
    public final ArrayList a;
    public final i b;
    public final ArrayList c;
    public final ArrayList d;
    public final int[] e;
    public final int[] f;
    public boolean g;
    public boolean h;
    public final int[] i;
    public View j;
    public View k;
    public b l;
    public boolean m;
    public B0 n;
    public boolean o;
    public Drawable r;
    public ViewGroup.OnHierarchyChangeListener w;

    static {
        Package package0 = CoordinatorLayout.class.getPackage();
        CoordinatorLayout.E = package0 == null ? null : package0.getName();
        CoordinatorLayout.M = new f(5);
        CoordinatorLayout.G = new Class[]{Context.class, AttributeSet.class};
        CoordinatorLayout.I = new ThreadLocal();
        CoordinatorLayout.N = new b2.f(12);
    }

    public CoordinatorLayout(Context context0) {
        this(context0, null);
    }

    public CoordinatorLayout(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0x7F0401CA);  // attr:coordinatorLayoutStyle
    }

    public CoordinatorLayout(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        this.a = new ArrayList();
        i i0 = new i();  // 初始化器: Ljava/lang/Object;-><init>()V
        i0.a = new e(10, 0);
        i0.b = new V(0);
        i0.c = new ArrayList();
        i0.d = new HashSet();
        this.b = i0;
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.e = new int[2];
        this.f = new int[2];
        this.D = new u();  // 初始化器: Ljava/lang/Object;-><init>()V
        int[] arr_v = a.a;
        TypedArray typedArray0 = v == 0 ? context0.obtainStyledAttributes(attributeSet0, arr_v, 0, 0x7F1404F4) : context0.obtainStyledAttributes(attributeSet0, arr_v, v, 0);  // style:Widget.Support.CoordinatorLayout
        if(Build.VERSION.SDK_INT >= 29) {
            if(v == 0) {
                m.p(this, context0, arr_v, attributeSet0, typedArray0);
            }
            else {
                m.q(this, context0, arr_v, attributeSet0, typedArray0, v);
            }
        }
        int v2 = typedArray0.getResourceId(0, 0);
        if(v2 != 0) {
            Resources resources0 = context0.getResources();
            int[] arr_v1 = resources0.getIntArray(v2);
            this.i = arr_v1;
            float f = resources0.getDisplayMetrics().density;
            for(int v1 = 0; v1 < arr_v1.length; ++v1) {
                this.i[v1] = (int)(((float)this.i[v1]) * f);
            }
        }
        this.r = typedArray0.getDrawable(1);
        typedArray0.recycle();
        this.w();
        super.setOnHierarchyChangeListener(new L1.a(this));
        if(this.getImportantForAccessibility() == 0) {
            this.setImportantForAccessibility(1);
        }
    }

    // 去混淆评级： 低(20)
    @Override  // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        return viewGroup$LayoutParams0 instanceof c && super.checkLayoutParams(viewGroup$LayoutParams0);
    }

    @Override  // android.view.ViewGroup
    public final boolean drawChild(Canvas canvas0, View view0, long v) {
        Behavior coordinatorLayout$Behavior0 = ((c)view0.getLayoutParams()).a;
        if(coordinatorLayout$Behavior0 != null) {
            coordinatorLayout$Behavior0.getClass();
        }
        return super.drawChild(canvas0, view0, v);
    }

    @Override  // android.view.ViewGroup
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        int[] arr_v = this.getDrawableState();
        Drawable drawable0 = this.r;
        if((drawable0 == null || !drawable0.isStateful() ? false : drawable0.setState(arr_v))) {
            this.invalidate();
        }
    }

    public static Rect e() {
        Rect rect0 = (Rect)CoordinatorLayout.N.acquire();
        return rect0 == null ? new Rect() : rect0;
    }

    public final void f(c c0, Rect rect0, int v, int v1) {
        int v2 = this.getWidth();
        int v3 = this.getHeight();
        int v4 = Math.max(this.getPaddingLeft() + c0.leftMargin, Math.min(rect0.left, v2 - this.getPaddingRight() - v - c0.rightMargin));
        int v5 = Math.max(this.getPaddingTop() + c0.topMargin, Math.min(rect0.top, v3 - this.getPaddingBottom() - v1 - c0.bottomMargin));
        rect0.set(v4, v5, v + v4, v1 + v5);
    }

    public final void g(View view0) {
        List list0 = (List)((V)this.b.b).get(view0);
        if(list0 != null && !list0.isEmpty()) {
            for(int v = 0; v < list0.size(); ++v) {
                View view1 = (View)list0.get(v);
                Behavior coordinatorLayout$Behavior0 = ((c)view1.getLayoutParams()).a;
                if(coordinatorLayout$Behavior0 != null) {
                    coordinatorLayout$Behavior0.h(this, view1, view0);
                }
            }
        }
    }

    @Override  // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new c();
    }

    @Override  // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet0) {
        return new c(this.getContext(), attributeSet0);
    }

    @Override  // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        if(viewGroup$LayoutParams0 instanceof c) {
            return new c(((c)viewGroup$LayoutParams0));
        }
        return viewGroup$LayoutParams0 instanceof ViewGroup.MarginLayoutParams ? new c(((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0)) : new c(viewGroup$LayoutParams0);
    }

    public final List getDependencySortedChildren() {
        this.s();
        return Collections.unmodifiableList(this.a);
    }

    public final B0 getLastWindowInsets() {
        return this.n;
    }

    @Override  // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.D.a();
    }

    public Drawable getStatusBarBackground() {
        return this.r;
    }

    @Override  // android.view.View
    public int getSuggestedMinimumHeight() {
        int v = super.getSuggestedMinimumHeight();
        int v1 = this.getPaddingTop();
        return Math.max(v, this.getPaddingBottom() + v1);
    }

    @Override  // android.view.View
    public int getSuggestedMinimumWidth() {
        int v = super.getSuggestedMinimumWidth();
        int v1 = this.getPaddingLeft();
        return Math.max(v, this.getPaddingRight() + v1);
    }

    public final void h(View view0, Rect rect0, boolean z) {
        if(!view0.isLayoutRequested() && view0.getVisibility() != 8) {
            if(z) {
                this.j(view0, rect0);
                return;
            }
            rect0.set(view0.getLeft(), view0.getTop(), view0.getRight(), view0.getBottom());
            return;
        }
        rect0.setEmpty();
    }

    public final ArrayList i(View view0) {
        V v0 = (V)this.b.b;
        int v1 = v0.size();
        Collection collection0 = null;
        for(int v2 = 0; v2 < v1; ++v2) {
            ArrayList arrayList0 = (ArrayList)v0.valueAt(v2);
            if(arrayList0 != null && arrayList0.contains(view0)) {
                if(collection0 == null) {
                    collection0 = new ArrayList();
                }
                ((ArrayList)collection0).add(v0.keyAt(v2));
            }
        }
        ArrayList arrayList1 = this.d;
        arrayList1.clear();
        if(collection0 != null) {
            arrayList1.addAll(collection0);
        }
        return arrayList1;
    }

    public final void j(View view0, Rect rect0) {
        rect0.set(0, 0, view0.getWidth(), view0.getHeight());
        ThreadLocal threadLocal0 = L1.c.a;
        Matrix matrix0 = (Matrix)threadLocal0.get();
        if(matrix0 == null) {
            matrix0 = new Matrix();
            threadLocal0.set(matrix0);
        }
        else {
            matrix0.reset();
        }
        L1.c.a(this, view0, matrix0);
        ThreadLocal threadLocal1 = L1.c.b;
        RectF rectF0 = (RectF)threadLocal1.get();
        if(rectF0 == null) {
            rectF0 = new RectF();
            threadLocal1.set(rectF0);
        }
        rectF0.set(rect0);
        matrix0.mapRect(rectF0);
        rect0.set(((int)(rectF0.left + 0.5f)), ((int)(rectF0.top + 0.5f)), ((int)(rectF0.right + 0.5f)), ((int)(rectF0.bottom + 0.5f)));
    }

    public static void k(int v, Rect rect0, Rect rect1, c c0, int v1, int v2) {
        int v7;
        int v6;
        int v3 = Gravity.getAbsoluteGravity((c0.c == 0 ? 17 : c0.c), v);
        int v4 = (c0.d & 7) == 0 ? c0.d | 0x800003 : c0.d;
        if((v4 & 0x70) == 0) {
            v4 |= 0x30;
        }
        int v5 = Gravity.getAbsoluteGravity(v4, v);
        switch(v5 & 7) {
            case 1: {
                v6 = rect0.left + rect0.width() / 2;
                break;
            }
            case 5: {
                v6 = rect0.right;
                break;
            }
            default: {
                v6 = rect0.left;
            }
        }
        switch(v5 & 0x70) {
            case 16: {
                v7 = rect0.top + rect0.height() / 2;
                break;
            }
            case 80: {
                v7 = rect0.bottom;
                break;
            }
            default: {
                v7 = rect0.top;
            }
        }
        if((v3 & 7) == 1) {
            v6 -= v1 / 2;
        }
        else if((v3 & 7) != 5) {
            v6 -= v1;
        }
        if((v3 & 0x70) == 16) {
            v7 -= v2 / 2;
        }
        else if((v3 & 0x70) != 80) {
            v7 -= v2;
        }
        rect1.set(v6, v7, v1 + v6, v2 + v7);
    }

    public final int l(int v) {
        int[] arr_v = this.i;
        if(arr_v == null) {
            Log.e("CoordinatorLayout", "No keylines defined for " + this + " - attempted index lookup " + v);
            return 0;
        }
        if(v >= 0 && v < arr_v.length) {
            return arr_v[v];
        }
        Log.e("CoordinatorLayout", "Keyline index " + v + " out of range for " + this);
        return 0;
    }

    public static c m(View view0) {
        c c0 = (c)view0.getLayoutParams();
        if(!c0.b) {
            if(view0 instanceof androidx.coordinatorlayout.widget.a) {
                Behavior coordinatorLayout$Behavior0 = ((androidx.coordinatorlayout.widget.a)view0).getBehavior();
                if(coordinatorLayout$Behavior0 == null) {
                    Log.e("CoordinatorLayout", "Attached behavior class is null");
                }
                Behavior coordinatorLayout$Behavior1 = c0.a;
                if(coordinatorLayout$Behavior1 != coordinatorLayout$Behavior0) {
                    if(coordinatorLayout$Behavior1 != null) {
                        coordinatorLayout$Behavior1.j();
                    }
                    c0.a = coordinatorLayout$Behavior0;
                    c0.b = true;
                    if(coordinatorLayout$Behavior0 != null) {
                        coordinatorLayout$Behavior0.g(c0);
                    }
                }
                c0.b = true;
                return c0;
            }
            Class class0 = view0.getClass();
            androidx.coordinatorlayout.widget.b b0 = null;
            while(class0 != null) {
                b0 = (androidx.coordinatorlayout.widget.b)class0.getAnnotation(androidx.coordinatorlayout.widget.b.class);
                if(b0 != null) {
                    break;
                }
                class0 = class0.getSuperclass();
            }
            if(b0 != null) {
                try {
                    Behavior coordinatorLayout$Behavior2 = (Behavior)b0.value().getDeclaredConstructor(null).newInstance(null);
                    Behavior coordinatorLayout$Behavior3 = c0.a;
                    if(coordinatorLayout$Behavior3 != coordinatorLayout$Behavior2) {
                        if(coordinatorLayout$Behavior3 != null) {
                            coordinatorLayout$Behavior3.j();
                        }
                        c0.a = coordinatorLayout$Behavior2;
                        c0.b = true;
                        if(coordinatorLayout$Behavior2 != null) {
                            coordinatorLayout$Behavior2.g(c0);
                        }
                    }
                }
                catch(Exception exception0) {
                    Log.e("CoordinatorLayout", "Default behavior class " + b0.value().getName() + " could not be instantiated. Did you forget a default constructor?", exception0);
                }
            }
            c0.b = true;
        }
        return c0;
    }

    public final boolean n(View view0, int v, int v1) {
        Rect rect0 = CoordinatorLayout.e();
        this.j(view0, rect0);
        try {
            return rect0.contains(v, v1);
        }
        finally {
            rect0.setEmpty();
            CoordinatorLayout.N.release(rect0);
        }
    }

    public final void o(int v) {
        int v5;
        Rect rect3;
        int v4;
        ArrayList arrayList1;
        boolean z3;
        boolean z2;
        boolean z1;
        Rect rect7;
        int v11;
        View view2;
        int v10;
        int v9;
        c c2;
        ArrayList arrayList2;
        b2.f f0;
        int v1 = this.getLayoutDirection();
        ArrayList arrayList0 = this.a;
        int v2 = arrayList0.size();
        Rect rect0 = CoordinatorLayout.e();
        Rect rect1 = CoordinatorLayout.e();
        Rect rect2 = CoordinatorLayout.e();
        int v3 = 0;
        while(true) {
            f0 = CoordinatorLayout.N;
            if(v3 >= v2) {
                break;
            }
            View view0 = (View)arrayList0.get(v3);
            c c0 = (c)view0.getLayoutParams();
            if(v != 0 || view0.getVisibility() != 8) {
                int v6 = 0;
                while(v6 < v3) {
                    View view1 = (View)arrayList0.get(v6);
                    if(c0.l == view1) {
                        c c1 = (c)view0.getLayoutParams();
                        if(c1.k != null) {
                            Rect rect4 = CoordinatorLayout.e();
                            Rect rect5 = CoordinatorLayout.e();
                            Rect rect6 = CoordinatorLayout.e();
                            this.j(c1.k, rect4);
                            this.h(view0, rect5, false);
                            int v7 = view0.getMeasuredWidth();
                            int v8 = view0.getMeasuredHeight();
                            arrayList2 = arrayList0;
                            c2 = c0;
                            v9 = v6;
                            v10 = v3;
                            view2 = view0;
                            CoordinatorLayout.k(v1, rect4, rect6, c1, v7, v8);
                            v11 = v2;
                            rect7 = rect2;
                            boolean z = rect6.left != rect5.left || rect6.top != rect5.top;
                            this.f(c1, rect6, v7, v8);
                            int v12 = rect6.left - rect5.left;
                            int v13 = rect6.top - rect5.top;
                            if(v12 != 0) {
                                view2.offsetLeftAndRight(v12);
                            }
                            if(v13 != 0) {
                                view2.offsetTopAndBottom(v13);
                            }
                            if(z) {
                                Behavior coordinatorLayout$Behavior0 = c1.a;
                                if(coordinatorLayout$Behavior0 != null) {
                                    coordinatorLayout$Behavior0.h(this, view2, c1.k);
                                }
                            }
                            rect4.setEmpty();
                            f0.release(rect4);
                            rect5.setEmpty();
                            f0.release(rect5);
                            rect6.setEmpty();
                            f0.release(rect6);
                        }
                    }
                    else {
                        arrayList2 = arrayList0;
                        c2 = c0;
                        v9 = v6;
                        v11 = v2;
                        rect7 = rect2;
                        v10 = v3;
                        view2 = view0;
                    }
                    v6 = v9 + 1;
                    c0 = c2;
                    view0 = view2;
                    arrayList0 = arrayList2;
                    v2 = v11;
                    v3 = v10;
                    rect2 = rect7;
                }
                ArrayList arrayList3 = arrayList0;
                v5 = v3;
                View view3 = view0;
                this.h(view3, rect1, true);
                if(c0.g != 0 && !rect1.isEmpty()) {
                    int v14 = Gravity.getAbsoluteGravity(c0.g, v1);
                    switch(v14 & 0x70) {
                        case 0x30: {
                            rect0.top = Math.max(rect0.top, rect1.bottom);
                            break;
                        }
                        case 80: {
                            rect0.bottom = Math.max(rect0.bottom, this.getHeight() - rect1.top);
                        }
                    }
                    switch(v14 & 7) {
                        case 3: {
                            rect0.left = Math.max(rect0.left, rect1.right);
                            break;
                        }
                        case 5: {
                            rect0.right = Math.max(rect0.right, this.getWidth() - rect1.left);
                        }
                    }
                }
                if(c0.h != 0 && view3.getVisibility() == 0 && view3.isLaidOut() && view3.getWidth() > 0 && view3.getHeight() > 0) {
                    c c3 = (c)view3.getLayoutParams();
                    Behavior coordinatorLayout$Behavior1 = c3.a;
                    Rect rect8 = CoordinatorLayout.e();
                    Rect rect9 = CoordinatorLayout.e();
                    rect9.set(view3.getLeft(), view3.getTop(), view3.getRight(), view3.getBottom());
                    if(coordinatorLayout$Behavior1 == null || !coordinatorLayout$Behavior1.e(view3, rect8)) {
                        rect8.set(rect9);
                    }
                    else if(!rect9.contains(rect8)) {
                        throw new IllegalArgumentException("Rect should be within the child\'s bounds. Rect:" + rect8.toShortString() + " | Bounds:" + rect9.toShortString());
                    }
                    rect9.setEmpty();
                    f0.release(rect9);
                    if(!rect8.isEmpty()) {
                        int v15 = Gravity.getAbsoluteGravity(c3.h, v1);
                        if((v15 & 0x30) == 0x30) {
                            int v16 = rect8.top - c3.topMargin - c3.j;
                            int v17 = rect0.top;
                            if(v16 < v17) {
                                CoordinatorLayout.v(view3, v17 - v16);
                                z1 = true;
                            }
                        }
                        else {
                            z1 = false;
                        }
                        if((v15 & 80) == 80) {
                            int v18 = this.getHeight() - rect8.bottom - c3.bottomMargin + c3.j;
                            int v19 = rect0.bottom;
                            if(v18 < v19) {
                                CoordinatorLayout.v(view3, v18 - v19);
                                z1 = true;
                            }
                        }
                        if(!z1) {
                            CoordinatorLayout.v(view3, 0);
                        }
                        if((v15 & 3) == 3) {
                            int v20 = rect8.left - c3.leftMargin - c3.i;
                            int v21 = rect0.left;
                            if(v20 < v21) {
                                CoordinatorLayout.u(view3, v21 - v20);
                                z2 = true;
                            }
                        }
                        else {
                            z2 = false;
                        }
                        if((v15 & 5) == 5) {
                            int v22 = this.getWidth() - rect8.right - c3.rightMargin + c3.i;
                            int v23 = rect0.right;
                            if(v22 < v23) {
                                CoordinatorLayout.u(view3, v22 - v23);
                                z2 = true;
                            }
                        }
                        if(!z2) {
                            CoordinatorLayout.u(view3, 0);
                        }
                    }
                    rect8.setEmpty();
                    f0.release(rect8);
                }
                if(v == 2) {
                label_148:
                    rect3 = rect2;
                }
                else {
                    rect3 = rect2;
                    rect3.set(((c)view3.getLayoutParams()).p);
                    if(rect3.equals(rect1)) {
                        arrayList1 = arrayList3;
                        v4 = v2;
                        goto label_170;
                    }
                    else {
                        ((c)view3.getLayoutParams()).p.set(rect1);
                        goto label_149;
                    }
                    goto label_148;
                }
            label_149:
                int v24 = v5 + 1;
                v4 = v2;
                while(true) {
                    arrayList1 = arrayList3;
                    if(v24 >= v4) {
                        break;
                    }
                    View view4 = (View)arrayList1.get(v24);
                    c c4 = (c)view4.getLayoutParams();
                    Behavior coordinatorLayout$Behavior2 = c4.a;
                    if(coordinatorLayout$Behavior2 != null && coordinatorLayout$Behavior2.f(view4, view3)) {
                        if(v != 0 || !c4.o) {
                            if(v == 2) {
                                coordinatorLayout$Behavior2.i(this, view3);
                                z3 = true;
                            }
                            else {
                                z3 = coordinatorLayout$Behavior2.h(this, view4, view3);
                            }
                            if(v == 1) {
                                c4.o = z3;
                            }
                        }
                        else {
                            c4.o = false;
                        }
                    }
                    ++v24;
                    arrayList3 = arrayList1;
                }
            }
            else {
                arrayList1 = arrayList0;
                v4 = v2;
                rect3 = rect2;
                v5 = v3;
            }
        label_170:
            v3 = v5 + 1;
            rect2 = rect3;
            v2 = v4;
            arrayList0 = arrayList1;
        }
        rect0.setEmpty();
        f0.release(rect0);
        rect1.setEmpty();
        f0.release(rect1);
        rect2.setEmpty();
        f0.release(rect2);
    }

    @Override  // android.view.ViewGroup
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.t(false);
        if(this.m) {
            if(this.l == null) {
                this.l = new b(this, 0);
            }
            this.getViewTreeObserver().addOnPreDrawListener(this.l);
        }
        if(this.n == null && this.getFitsSystemWindows()) {
            K.c(this);
        }
        this.h = true;
    }

    @Override  // android.view.ViewGroup
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.t(false);
        if(this.m && this.l != null) {
            this.getViewTreeObserver().removeOnPreDrawListener(this.l);
        }
        View view0 = this.k;
        if(view0 != null) {
            this.onStopNestedScroll(view0, 0);
        }
        this.h = false;
    }

    @Override  // android.view.View
    public final void onDraw(Canvas canvas0) {
        super.onDraw(canvas0);
        if(this.o && this.r != null) {
            int v = this.n == null ? 0 : this.n.d();
            if(v > 0) {
                this.r.setBounds(0, 0, this.getWidth(), v);
                this.r.draw(canvas0);
            }
        }
    }

    @Override  // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent0) {
        int v = motionEvent0.getActionMasked();
        if(v == 0) {
            this.t(true);
        }
        boolean z = this.r(motionEvent0, 0);
        if(v != 1 && v != 3) {
            return z;
        }
        this.t(true);
        return z;
    }

    @Override  // android.view.ViewGroup
    public final void onLayout(boolean z, int v, int v1, int v2, int v3) {
        int v4 = this.getLayoutDirection();
        ArrayList arrayList0 = this.a;
        int v5 = arrayList0.size();
        for(int v6 = 0; v6 < v5; ++v6) {
            View view0 = (View)arrayList0.get(v6);
            if(view0.getVisibility() != 8) {
                Behavior coordinatorLayout$Behavior0 = ((c)view0.getLayoutParams()).a;
                if(coordinatorLayout$Behavior0 == null || !coordinatorLayout$Behavior0.l(this, view0, v4)) {
                    this.p(view0, v4);
                }
            }
        }
    }

    @Override  // android.view.View
    public final void onMeasure(int v, int v1) {
        View view2;
        int v39;
        int v38;
        int v37;
        int v36;
        int v31;
        int v30;
        int v29;
        int v25;
        int v24;
        int v23;
        int v22;
        ArrayList arrayList2;
        this.s();
        int v2 = this.getChildCount();
    alab1:
        for(int v3 = 0; true; ++v3) {
            boolean z = false;
            if(v3 >= v2) {
                break;
            }
            View view0 = this.getChildAt(v3);
            V v4 = (V)this.b.b;
            int v5 = v4.size();
            for(int v6 = 0; v6 < v5; ++v6) {
                ArrayList arrayList0 = (ArrayList)v4.valueAt(v6);
                if(arrayList0 != null && arrayList0.contains(view0)) {
                    z = true;
                    break alab1;
                }
            }
        }
        if(z != this.m) {
            if(z) {
                if(this.h) {
                    if(this.l == null) {
                        this.l = new b(this, 0);
                    }
                    this.getViewTreeObserver().addOnPreDrawListener(this.l);
                }
                this.m = true;
            }
            else {
                if(this.h && this.l != null) {
                    this.getViewTreeObserver().removeOnPreDrawListener(this.l);
                }
                this.m = false;
            }
        }
        int v7 = this.getPaddingLeft();
        int v8 = this.getPaddingTop();
        int v9 = this.getPaddingRight();
        int v10 = this.getPaddingBottom();
        int v11 = this.getLayoutDirection();
        int v12 = View.MeasureSpec.getMode(v);
        int v13 = View.MeasureSpec.getSize(v);
        int v14 = View.MeasureSpec.getMode(v1);
        int v15 = View.MeasureSpec.getSize(v1);
        int v16 = v7 + v9;
        int v17 = this.getSuggestedMinimumWidth();
        int v18 = this.getSuggestedMinimumHeight();
        boolean z1 = this.n != null && this.getFitsSystemWindows();
        ArrayList arrayList1 = this.a;
        int v19 = arrayList1.size();
        int v20 = 0;
        int v21 = 0;
        while(v20 < v19) {
            View view1 = (View)arrayList1.get(v20);
            if(view1.getVisibility() == 8) {
                arrayList2 = arrayList1;
                v22 = v19;
                v23 = v20;
                v24 = v7;
                v25 = v9;
            }
            else {
                c c0 = (c)view1.getLayoutParams();
                int v26 = c0.e;
                if(v26 < 0 || v12 == 0) {
                    v29 = v18;
                }
                else {
                    int v27 = this.l(v26);
                    int v28 = Gravity.getAbsoluteGravity((c0.c == 0 ? 0x800035 : c0.c), v11) & 7;
                    v29 = v18;
                    if(v28 == 3 && v11 != 1 || v28 == 5 && v11 == 1) {
                        v30 = Math.max(0, v13 - v9 - v27);
                        v31 = v19;
                        goto label_73;
                    }
                    else if(v28 == 5 && v11 != 1 || v28 == 3 && v11 == 1) {
                        v30 = Math.max(0, v27 - v7);
                        v31 = v19;
                        goto label_73;
                    }
                }
                v31 = v19;
                v30 = 0;
            label_73:
                if(!z1 || view1.getFitsSystemWindows()) {
                    v22 = v31;
                    v36 = v;
                    v37 = v1;
                }
                else {
                    int v32 = this.n.b();
                    v22 = v31;
                    int v33 = this.n.c();
                    int v34 = this.n.d();
                    int v35 = this.n.a();
                    v36 = View.MeasureSpec.makeMeasureSpec(v13 - (v33 + v32), v12);
                    v37 = View.MeasureSpec.makeMeasureSpec(v15 - (v35 + v34), v14);
                }
                Behavior coordinatorLayout$Behavior0 = c0.a;
                if(coordinatorLayout$Behavior0 == null) {
                    v24 = v7;
                    v38 = v17;
                    v25 = v9;
                    v39 = v29;
                    arrayList2 = arrayList1;
                    view2 = view1;
                    v23 = v20;
                    this.measureChildWithMargins(view2, v36, v30, v37, 0);
                }
                else {
                    v24 = v7;
                    v38 = v17;
                    v25 = v9;
                    v39 = v29;
                    arrayList2 = arrayList1;
                    v23 = v20;
                    view2 = view1;
                    if(!coordinatorLayout$Behavior0.m(this, view1, v36, v30, v37)) {
                        this.measureChildWithMargins(view2, v36, v30, v37, 0);
                    }
                }
                int v40 = Math.max(v38, view2.getMeasuredWidth() + v16 + c0.leftMargin + c0.rightMargin);
                int v41 = Math.max(v39, view2.getMeasuredHeight() + (v8 + v10) + c0.topMargin + c0.bottomMargin);
                v21 = View.combineMeasuredStates(v21, view2.getMeasuredState());
                v17 = v40;
                v18 = v41;
            }
            v20 = v23 + 1;
            v7 = v24;
            v9 = v25;
            v19 = v22;
            arrayList1 = arrayList2;
        }
        this.setMeasuredDimension(View.resolveSizeAndState(v17, v, 0xFF000000 & v21), View.resolveSizeAndState(v18, v1, v21 << 16));
    }

    @Override  // android.view.ViewGroup
    public final boolean onNestedFling(View view0, float f, float f1, boolean z) {
        int v = this.getChildCount();
        for(int v1 = 0; v1 < v; ++v1) {
            View view1 = this.getChildAt(v1);
            if(view1.getVisibility() != 8) {
                boolean z1 = !((c)view1.getLayoutParams()).a(0);
            }
        }
        return false;
    }

    @Override  // android.view.ViewGroup
    public final boolean onNestedPreFling(View view0, float f, float f1) {
        int v = this.getChildCount();
        boolean z = false;
        for(int v1 = 0; v1 < v; ++v1) {
            View view1 = this.getChildAt(v1);
            if(view1.getVisibility() != 8) {
                c c0 = (c)view1.getLayoutParams();
                if(c0.a(0)) {
                    Behavior coordinatorLayout$Behavior0 = c0.a;
                    if(coordinatorLayout$Behavior0 != null) {
                        z |= coordinatorLayout$Behavior0.n(view0);
                    }
                }
            }
        }
        return z;
    }

    @Override  // android.view.ViewGroup
    public final void onNestedPreScroll(View view0, int v, int v1, int[] arr_v) {
        this.onNestedPreScroll(view0, v, v1, arr_v, 0);
    }

    @Override  // c2.s
    public final void onNestedPreScroll(View view0, int v, int v1, int[] arr_v, int v2) {
        int v3 = this.getChildCount();
        boolean z = false;
        int v5 = 0;
        int v6 = 0;
        for(int v4 = 0; v4 < v3; ++v4) {
            View view1 = this.getChildAt(v4);
            if(view1.getVisibility() != 8) {
                c c0 = (c)view1.getLayoutParams();
                if(c0.a(v2)) {
                    Behavior coordinatorLayout$Behavior0 = c0.a;
                    if(coordinatorLayout$Behavior0 != null) {
                        this.e[0] = 0;
                        this.e[1] = 0;
                        coordinatorLayout$Behavior0.o(this, view1, view0, v, v1, this.e, v2);
                        v5 = v <= 0 ? Math.min(v5, this.e[0]) : Math.max(v5, this.e[0]);
                        v6 = v1 <= 0 ? Math.min(v6, this.e[1]) : Math.max(v6, this.e[1]);
                        z = true;
                    }
                }
            }
        }
        arr_v[0] = v5;
        arr_v[1] = v6;
        if(z) {
            this.o(1);
        }
    }

    @Override  // android.view.ViewGroup
    public final void onNestedScroll(View view0, int v, int v1, int v2, int v3) {
        this.onNestedScroll(view0, v, v1, v2, v3, 0);
    }

    @Override  // c2.s
    public final void onNestedScroll(View view0, int v, int v1, int v2, int v3, int v4) {
        this.onNestedScroll(view0, v, v1, v2, v3, 0, this.f);
    }

    @Override  // c2.t
    public final void onNestedScroll(View view0, int v, int v1, int v2, int v3, int v4, int[] arr_v) {
        int v5 = this.getChildCount();
        int v7 = 0;
        int v8 = 0;
        boolean z = false;
        for(int v6 = 0; v6 < v5; ++v6) {
            View view1 = this.getChildAt(v6);
            if(view1.getVisibility() != 8) {
                c c0 = (c)view1.getLayoutParams();
                if(c0.a(v4)) {
                    Behavior coordinatorLayout$Behavior0 = c0.a;
                    if(coordinatorLayout$Behavior0 != null) {
                        this.e[0] = 0;
                        this.e[1] = 0;
                        coordinatorLayout$Behavior0.p(this, view1, v1, v2, v3, this.e);
                        v7 = v2 <= 0 ? Math.min(v7, this.e[0]) : Math.max(v7, this.e[0]);
                        v8 = v3 <= 0 ? Math.min(v8, this.e[1]) : Math.max(v8, this.e[1]);
                        z = true;
                    }
                }
            }
        }
        arr_v[0] += v7;
        arr_v[1] += v8;
        if(z) {
            this.o(1);
        }
    }

    @Override  // android.view.ViewGroup
    public final void onNestedScrollAccepted(View view0, View view1, int v) {
        this.onNestedScrollAccepted(view0, view1, v, 0);
    }

    @Override  // c2.s
    public final void onNestedScrollAccepted(View view0, View view1, int v, int v1) {
        u u0 = this.D;
        if(v1 == 1) {
            u0.b = v;
        }
        else {
            u0.a = v;
        }
        this.k = view1;
        int v2 = this.getChildCount();
        for(int v3 = 0; v3 < v2; ++v3) {
            ((c)this.getChildAt(v3).getLayoutParams()).getClass();
        }
    }

    @Override  // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable0) {
        if(!(parcelable0 instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable0);
            return;
        }
        super.onRestoreInstanceState(((SavedState)parcelable0).a);
        SparseArray sparseArray0 = ((SavedState)parcelable0).c;
        int v = this.getChildCount();
        for(int v1 = 0; v1 < v; ++v1) {
            View view0 = this.getChildAt(v1);
            int v2 = view0.getId();
            Behavior coordinatorLayout$Behavior0 = CoordinatorLayout.m(view0).a;
            if(v2 != -1 && coordinatorLayout$Behavior0 != null) {
                Parcelable parcelable1 = (Parcelable)sparseArray0.get(v2);
                if(parcelable1 != null) {
                    coordinatorLayout$Behavior0.r(view0, parcelable1);
                }
            }
        }
    }

    @Override  // android.view.View
    public final Parcelable onSaveInstanceState() {
        Parcelable parcelable0 = new SavedState(super.onSaveInstanceState());  // 初始化器: Landroidx/customview/view/AbsSavedState;-><init>(Landroid/os/Parcelable;)V
        SparseArray sparseArray0 = new SparseArray();
        int v = this.getChildCount();
        for(int v1 = 0; v1 < v; ++v1) {
            View view0 = this.getChildAt(v1);
            int v2 = view0.getId();
            Behavior coordinatorLayout$Behavior0 = ((c)view0.getLayoutParams()).a;
            if(v2 != -1 && coordinatorLayout$Behavior0 != null) {
                Parcelable parcelable1 = coordinatorLayout$Behavior0.s(view0);
                if(parcelable1 != null) {
                    sparseArray0.append(v2, parcelable1);
                }
            }
        }
        parcelable0.c = sparseArray0;
        return parcelable0;
    }

    @Override  // android.view.ViewGroup
    public final boolean onStartNestedScroll(View view0, View view1, int v) {
        return this.onStartNestedScroll(view0, view1, v, 0);
    }

    @Override  // c2.s
    public final boolean onStartNestedScroll(View view0, View view1, int v, int v1) {
        int v2 = this.getChildCount();
        boolean z = false;
        for(int v3 = 0; v3 < v2; ++v3) {
            View view2 = this.getChildAt(v3);
            if(view2.getVisibility() != 8) {
                c c0 = (c)view2.getLayoutParams();
                Behavior coordinatorLayout$Behavior0 = c0.a;
                if(coordinatorLayout$Behavior0 == null) {
                    switch(v1) {
                        case 0: {
                            c0.m = false;
                            break;
                        }
                        case 1: {
                            c0.n = false;
                        }
                    }
                }
                else {
                    boolean z1 = coordinatorLayout$Behavior0.t(this, view2, view0, view1, v, v1);
                    z |= z1;
                    switch(v1) {
                        case 0: {
                            c0.m = z1;
                            break;
                        }
                        case 1: {
                            c0.n = z1;
                        }
                    }
                }
            }
        }
        return z;
    }

    @Override  // android.view.ViewGroup
    public final void onStopNestedScroll(View view0) {
        this.onStopNestedScroll(view0, 0);
    }

    @Override  // c2.s
    public final void onStopNestedScroll(View view0, int v) {
        u u0 = this.D;
        if(v == 1) {
            u0.b = 0;
        }
        else {
            u0.a = 0;
        }
        int v1 = this.getChildCount();
        for(int v2 = 0; v2 < v1; ++v2) {
            View view1 = this.getChildAt(v2);
            c c0 = (c)view1.getLayoutParams();
            if(c0.a(v)) {
                Behavior coordinatorLayout$Behavior0 = c0.a;
                if(coordinatorLayout$Behavior0 != null) {
                    coordinatorLayout$Behavior0.u(this, view1, view0, v);
                }
                switch(v) {
                    case 0: {
                        c0.m = false;
                        break;
                    }
                    case 1: {
                        c0.n = false;
                    }
                }
                c0.o = false;
            }
        }
        this.k = null;
    }

    @Override  // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent0) {
        boolean z1;
        boolean z;
        int v = motionEvent0.getActionMasked();
        if(this.j == null) {
            z = this.r(motionEvent0, 1);
            if(z) {
                goto label_7;
            }
            else {
                z1 = false;
            }
        }
        else {
            z = false;
        label_7:
            Behavior coordinatorLayout$Behavior0 = ((c)this.j.getLayoutParams()).a;
            z1 = coordinatorLayout$Behavior0 == null ? false : coordinatorLayout$Behavior0.v(this, this.j, motionEvent0);
        }
        MotionEvent motionEvent1 = null;
        if(this.j == null) {
            z1 |= super.onTouchEvent(motionEvent0);
        }
        else if(z) {
            long v1 = SystemClock.uptimeMillis();
            motionEvent1 = MotionEvent.obtain(v1, v1, 3, 0.0f, 0.0f, 0);
            super.onTouchEvent(motionEvent1);
        }
        if(motionEvent1 != null) {
            motionEvent1.recycle();
        }
        if(v != 1 && v != 3) {
            return z1;
        }
        this.t(false);
        return z1;
    }

    public final void p(View view0, int v) {
        int v11;
        c c0 = (c)view0.getLayoutParams();
        View view1 = c0.k;
        if(view1 == null && c0.f != -1) {
            throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        }
        b2.f f0 = CoordinatorLayout.N;
        if(view1 != null) {
            Rect rect0 = CoordinatorLayout.e();
            Rect rect1 = CoordinatorLayout.e();
            try {
                this.j(view1, rect0);
                ViewGroup.LayoutParams viewGroup$LayoutParams0 = view0.getLayoutParams();
                int v2 = view0.getMeasuredWidth();
                int v3 = view0.getMeasuredHeight();
                CoordinatorLayout.k(v, rect0, rect1, ((c)viewGroup$LayoutParams0), v2, v3);
                this.f(((c)viewGroup$LayoutParams0), rect1, v2, v3);
                view0.layout(rect1.left, rect1.top, rect1.right, rect1.bottom);
            }
            finally {
                rect0.setEmpty();
                f0.release(rect0);
                rect1.setEmpty();
                f0.release(rect1);
            }
            return;
        }
        int v4 = c0.e;
        if(v4 >= 0) {
            c c1 = (c)view0.getLayoutParams();
            int v5 = Gravity.getAbsoluteGravity((c1.c == 0 ? 0x800035 : c1.c), v);
            int v6 = this.getWidth();
            int v7 = this.getHeight();
            int v8 = view0.getMeasuredWidth();
            int v9 = view0.getMeasuredHeight();
            if(v == 1) {
                v4 = v6 - v4;
            }
            int v10 = this.l(v4) - v8;
            switch(v5 & 7) {
                case 1: {
                    v10 += v8 / 2;
                    break;
                }
                case 5: {
                    v10 += v8;
                }
            }
            switch(v5 & 0x70) {
                case 16: {
                    v11 = v9 / 2;
                    break;
                }
                case 80: {
                    v11 = v9;
                    break;
                }
                default: {
                    v11 = 0;
                }
            }
            int v12 = Math.max(this.getPaddingLeft() + c1.leftMargin, Math.min(v10, v6 - this.getPaddingRight() - v8 - c1.rightMargin));
            int v13 = Math.max(this.getPaddingTop() + c1.topMargin, Math.min(v11, v7 - this.getPaddingBottom() - v9 - c1.bottomMargin));
            view0.layout(v12, v13, v8 + v12, v9 + v13);
            return;
        }
        c c2 = (c)view0.getLayoutParams();
        Rect rect2 = CoordinatorLayout.e();
        rect2.set(this.getPaddingLeft() + c2.leftMargin, this.getPaddingTop() + c2.topMargin, this.getWidth() - this.getPaddingRight() - c2.rightMargin, this.getHeight() - this.getPaddingBottom() - c2.bottomMargin);
        if(this.n != null && this.getFitsSystemWindows() && !view0.getFitsSystemWindows()) {
            int v14 = rect2.left;
            rect2.left = this.n.b() + v14;
            int v15 = rect2.top;
            rect2.top = this.n.d() + v15;
            rect2.right -= this.n.c();
            rect2.bottom -= this.n.a();
        }
        Rect rect3 = CoordinatorLayout.e();
        int v16 = (c2.c & 7) == 0 ? c2.c | 0x800003 : c2.c;
        if((v16 & 0x70) == 0) {
            v16 |= 0x30;
        }
        Gravity.apply(v16, view0.getMeasuredWidth(), view0.getMeasuredHeight(), rect2, rect3, v);
        view0.layout(rect3.left, rect3.top, rect3.right, rect3.bottom);
        rect2.setEmpty();
        f0.release(rect2);
        rect3.setEmpty();
        f0.release(rect3);
    }

    public final void q(View view0, int v, int v1, int v2) {
        this.measureChildWithMargins(view0, v, v1, v2, 0);
    }

    public final boolean r(MotionEvent motionEvent0, int v) {
        int v1 = motionEvent0.getActionMasked();
        ArrayList arrayList0 = this.c;
        arrayList0.clear();
        boolean z = this.isChildrenDrawingOrderEnabled();
        int v2 = this.getChildCount();
        for(int v3 = v2 - 1; v3 >= 0; --v3) {
            arrayList0.add(this.getChildAt((z ? this.getChildDrawingOrder(v2, v3) : v3)));
        }
        f f0 = CoordinatorLayout.M;
        if(f0 != null) {
            Collections.sort(arrayList0, f0);
        }
        int v4 = arrayList0.size();
        MotionEvent motionEvent1 = null;
        boolean z1 = false;
        for(int v5 = 0; v5 < v4; ++v5) {
            View view0 = (View)arrayList0.get(v5);
            Behavior coordinatorLayout$Behavior0 = ((c)view0.getLayoutParams()).a;
            if(!z1 || v1 == 0) {
                if(!z1 && coordinatorLayout$Behavior0 != null) {
                    switch(v) {
                        case 0: {
                            z1 = coordinatorLayout$Behavior0.k(this, view0, motionEvent0);
                            break;
                        }
                        case 1: {
                            z1 = coordinatorLayout$Behavior0.v(this, view0, motionEvent0);
                        }
                    }
                    if(z1) {
                        this.j = view0;
                    }
                }
            }
            else if(coordinatorLayout$Behavior0 != null) {
                if(motionEvent1 == null) {
                    long v6 = SystemClock.uptimeMillis();
                    motionEvent1 = MotionEvent.obtain(v6, v6, 3, 0.0f, 0.0f, 0);
                }
                switch(v) {
                    case 0: {
                        coordinatorLayout$Behavior0.k(this, view0, motionEvent1);
                        break;
                    }
                    case 1: {
                        coordinatorLayout$Behavior0.v(this, view0, motionEvent1);
                    }
                }
            }
        }
        arrayList0.clear();
        return z1;
    }

    @Override  // android.view.ViewGroup
    public final boolean requestChildRectangleOnScreen(View view0, Rect rect0, boolean z) {
        Behavior coordinatorLayout$Behavior0 = ((c)view0.getLayoutParams()).a;
        return coordinatorLayout$Behavior0 == null || !coordinatorLayout$Behavior0.q(this, view0, rect0, z) ? super.requestChildRectangleOnScreen(view0, rect0, z) : true;
    }

    @Override  // android.view.ViewGroup
    public final void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        if(z && !this.g) {
            this.t(false);
            this.g = true;
        }
    }

    public final void s() {
        ArrayList arrayList0 = this.a;
        arrayList0.clear();
        i i0 = this.b;
        V v0 = (V)i0.b;
        e e0 = (e)i0.a;
        V v1 = (V)i0.b;
        int v2 = v0.size();
        for(int v4 = 0; v4 < v2; ++v4) {
            ArrayList arrayList1 = (ArrayList)v0.valueAt(v4);
            if(arrayList1 != null) {
                arrayList1.clear();
                e0.release(arrayList1);
            }
        }
        v0.clear();
        int v5 = this.getChildCount();
        int v6 = 0;
        while(v6 < v5) {
            View view0 = this.getChildAt(v6);
            c c0 = CoordinatorLayout.m(view0);
            int v7 = c0.f;
            if(v7 == -1) {
                c0.l = null;
                c0.k = null;
            }
            else {
                if(c0.k != null && c0.k.getId() == v7) {
                    View view1 = c0.k;
                    ViewParent viewParent0 = view1.getParent();
                    while(viewParent0 != this) {
                        if(viewParent0 != null && viewParent0 != view0) {
                            if(viewParent0 instanceof View) {
                                view1 = (View)viewParent0;
                            }
                            viewParent0 = viewParent0.getParent();
                            continue;
                        }
                        c0.l = null;
                        c0.k = null;
                        goto label_41;
                    }
                    c0.l = view1;
                    goto label_67;
                }
            label_41:
                View view2 = this.findViewById(v7);
                c0.k = view2;
                if(view2 == null) {
                    if(!this.isInEditMode()) {
                        throw new IllegalStateException("Could not find CoordinatorLayout descendant view with id " + this.getResources().getResourceName(v7) + " to anchor view " + view0);
                    }
                    c0.l = null;
                    c0.k = null;
                }
                else if(view2 == this) {
                    if(!this.isInEditMode()) {
                        throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
                    }
                    c0.l = null;
                    c0.k = null;
                }
                else {
                    ViewParent viewParent1 = view2.getParent();
                    while(viewParent1 != this && viewParent1 != null) {
                        if(viewParent1 == view0) {
                            if(!this.isInEditMode()) {
                                throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
                            }
                            c0.l = null;
                            c0.k = null;
                            goto label_67;
                        }
                        if(viewParent1 instanceof View) {
                            view2 = (View)viewParent1;
                        }
                        viewParent1 = viewParent1.getParent();
                    }
                    c0.l = view2;
                }
            }
        label_67:
            if(!v1.containsKey(view0)) {
                v1.put(view0, null);
            }
            int v8 = 0;
            while(v8 < v5) {
                if(v8 != v6) {
                    View view3 = this.getChildAt(v8);
                    if(view3 == c0.l) {
                    label_77:
                        if(!v1.containsKey(view3) && !v1.containsKey(view3)) {
                            v1.put(view3, null);
                        }
                        if(!v1.containsKey(view3) || !v1.containsKey(view0)) {
                            throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
                        }
                        ArrayList arrayList2 = (ArrayList)v1.get(view3);
                        if(arrayList2 == null) {
                            arrayList2 = (ArrayList)e0.acquire();
                            if(arrayList2 == null) {
                                arrayList2 = new ArrayList();
                            }
                            v1.put(view3, arrayList2);
                        }
                        arrayList2.add(view0);
                    }
                    else {
                        int v9 = this.getLayoutDirection();
                        int v10 = Gravity.getAbsoluteGravity(((c)view3.getLayoutParams()).g, v9);
                        if(v10 != 0 && (Gravity.getAbsoluteGravity(c0.h, v9) & v10) == v10 || c0.a != null && c0.a.f(view0, view3)) {
                            goto label_77;
                        }
                    }
                }
                ++v8;
            }
            ++v6;
        }
        ArrayList arrayList3 = (ArrayList)i0.c;
        arrayList3.clear();
        HashSet hashSet0 = (HashSet)i0.d;
        hashSet0.clear();
        int v11 = v1.size();
        for(int v3 = 0; v3 < v11; ++v3) {
            i0.e(v1.keyAt(v3), arrayList3, hashSet0);
        }
        arrayList0.addAll(arrayList3);
        Collections.reverse(arrayList0);
    }

    @Override  // android.view.View
    public void setFitsSystemWindows(boolean z) {
        super.setFitsSystemWindows(z);
        this.w();
    }

    @Override  // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener viewGroup$OnHierarchyChangeListener0) {
        this.w = viewGroup$OnHierarchyChangeListener0;
    }

    public void setStatusBarBackground(Drawable drawable0) {
        Drawable drawable1 = null;
        Drawable drawable2 = this.r;
        if(drawable2 != drawable0) {
            if(drawable2 != null) {
                drawable2.setCallback(null);
            }
            if(drawable0 != null) {
                drawable1 = drawable0.mutate();
            }
            this.r = drawable1;
            if(drawable1 != null) {
                if(drawable1.isStateful()) {
                    this.r.setState(this.getDrawableState());
                }
                this.r.setLayoutDirection(this.getLayoutDirection());
                this.r.setVisible(this.getVisibility() == 0, false);
                this.r.setCallback(this);
            }
            this.postInvalidateOnAnimation();
        }
    }

    public void setStatusBarBackgroundColor(int v) {
        this.setStatusBarBackground(new ColorDrawable(v));
    }

    public void setStatusBarBackgroundResource(int v) {
        this.setStatusBarBackground((v == 0 ? null : P1.c.getDrawable(this.getContext(), v)));
    }

    @Override  // android.view.View
    public void setVisibility(int v) {
        super.setVisibility(v);
        if(this.r != null && this.r.isVisible() != (v == 0)) {
            this.r.setVisible(v == 0, false);
        }
    }

    public final void t(boolean z) {
        int v = this.getChildCount();
        for(int v1 = 0; v1 < v; ++v1) {
            View view0 = this.getChildAt(v1);
            Behavior coordinatorLayout$Behavior0 = ((c)view0.getLayoutParams()).a;
            if(coordinatorLayout$Behavior0 != null) {
                long v2 = SystemClock.uptimeMillis();
                MotionEvent motionEvent0 = MotionEvent.obtain(v2, v2, 3, 0.0f, 0.0f, 0);
                if(z) {
                    coordinatorLayout$Behavior0.k(this, view0, motionEvent0);
                }
                else {
                    coordinatorLayout$Behavior0.v(this, view0, motionEvent0);
                }
                motionEvent0.recycle();
            }
        }
        for(int v3 = 0; v3 < v; ++v3) {
            ((c)this.getChildAt(v3).getLayoutParams()).getClass();
        }
        this.j = null;
        this.g = false;
    }

    public static void u(View view0, int v) {
        c c0 = (c)view0.getLayoutParams();
        int v1 = c0.i;
        if(v1 != v) {
            view0.offsetLeftAndRight(v - v1);
            c0.i = v;
        }
    }

    public static void v(View view0, int v) {
        c c0 = (c)view0.getLayoutParams();
        int v1 = c0.j;
        if(v1 != v) {
            view0.offsetTopAndBottom(v - v1);
            c0.j = v;
        }
    }

    @Override  // android.view.View
    public final boolean verifyDrawable(Drawable drawable0) {
        return super.verifyDrawable(drawable0) || drawable0 == this.r;
    }

    public final void w() {
        if(this.getFitsSystemWindows()) {
            if(this.B == null) {
                this.B = new I7.c(this, 10);
            }
            M.n(this, this.B);
            this.setSystemUiVisibility(0x500);
            return;
        }
        M.n(this, null);
    }
}

