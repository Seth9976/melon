package androidx.constraintlayout.motion.widget;

import F1.d;
import F1.e;
import F1.f;
import F1.h;
import F1.j;
import F1.m;
import G1.c;
import I1.l;
import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.view.View.MeasureSpec;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.Constraints.LayoutParams;
import androidx.constraintlayout.widget.i;
import androidx.constraintlayout.widget.n;
import java.util.ArrayList;
import java.util.HashMap;
import ye.a;

public final class v {
    public f a;
    public f b;
    public n c;
    public n d;
    public int e;
    public int f;
    public final MotionLayout g;

    public v(MotionLayout motionLayout0) {
        this.g = motionLayout0;
        this.a = new f();
        this.b = new f();
        this.c = null;
        this.d = null;
    }

    public final void a() {
        Interpolator interpolator0;
        int v4;
        MotionLayout motionLayout0 = this.g;
        int v = motionLayout0.getChildCount();
        motionLayout0.S.clear();
        SparseArray sparseArray0 = new SparseArray();
        int[] arr_v = new int[v];
        for(int v1 = 0; v1 < v; ++v1) {
            View view0 = motionLayout0.getChildAt(v1);
            q q0 = new q(view0);
            int v2 = view0.getId();
            arr_v[v1] = v2;
            sparseArray0.put(v2, q0);
            motionLayout0.S.put(view0, q0);
        }
        for(int v3 = 0; v3 < v; v3 = v4 + 1) {
            View view1 = motionLayout0.getChildAt(v3);
            q q1 = (q)motionLayout0.S.get(view1);
            if(q1 == null) {
                v4 = v3;
            }
            else {
                o o0 = q1.h;
                B b0 = q1.f;
                if(this.c == null) {
                    v4 = v3;
                    if(motionLayout0.R0) {
                        l l0 = (l)motionLayout0.T0.get(view1);
                        int v10 = motionLayout0.S0;
                        int v11 = motionLayout0.U0;
                        int v12 = motionLayout0.V0;
                        b0.c = 0.0f;
                        b0.d = 0.0f;
                        Rect rect1 = new Rect();
                        switch(v10) {
                            case 1: {
                                int v13 = (l0.c + l0.e - (l0.d - l0.b)) / 2;
                                rect1.left = v13;
                                int v14 = v11 - (l0.e - l0.c + (l0.b + l0.d)) / 2;
                                rect1.top = v14;
                                rect1.right = l0.d - l0.b + v13;
                                rect1.bottom = l0.e - l0.c + v14;
                                break;
                            }
                            case 2: {
                                int v15 = v12 - (l0.d - l0.b + (l0.c + l0.e)) / 2;
                                rect1.left = v15;
                                int v16 = (l0.b + l0.d - (l0.e - l0.c)) / 2;
                                rect1.top = v16;
                                rect1.right = l0.d - l0.b + v15;
                                rect1.bottom = l0.e - l0.c + v16;
                            }
                        }
                        b0.d(((float)rect1.left), ((float)rect1.top), ((float)rect1.width()), ((float)rect1.height()));
                        float f = l0.a;
                        o0.getClass();
                        rect1.width();
                        rect1.height();
                        o0.b(view1);
                        o0.k = NaNf;
                        o0.l = NaNf;
                        switch(v10) {
                            case 1: {
                                o0.g = f - 90.0f;
                                break;
                            }
                            case 2: {
                                o0.g = f + 90.0f;
                            }
                        }
                    }
                }
                else {
                    e e0 = v.d(this.a, view1);
                    if(e0 == null) {
                        v4 = v3;
                        if(motionLayout0.h0 != 0) {
                            Log.e("MotionLayout", ".(null:-1)no widget for  " + a.G(view1) + " (" + view1.getClass().getName() + ")");
                        }
                    }
                    else {
                        Rect rect0 = MotionLayout.c(motionLayout0, e0);
                        n n0 = this.c;
                        int v5 = motionLayout0.getWidth();
                        v4 = v3;
                        int v6 = motionLayout0.getHeight();
                        int v7 = n0.d;
                        if(v7 != 0) {
                            q.h(rect0, q1.a, v7, v5, v6);
                        }
                        b0.c = 0.0f;
                        b0.d = 0.0f;
                        q1.g(b0);
                        b0.d(((float)rect0.left), ((float)rect0.top), ((float)rect0.width()), ((float)rect0.height()));
                        i i0 = n0.l(q1.c);
                        b0.a(i0);
                        q1.l = i0.d.g;
                        o0.d(rect0, n0, v7, q1.c);
                        q1.C = i0.f.i;
                        q1.E = i0.d.j;
                        q1.F = i0.d.i;
                        Context context0 = q1.b.getContext();
                        int v8 = i0.d.l;
                        String s = i0.d.k;
                        int v9 = i0.d.m;
                        if(v8 == -2) {
                            interpolator0 = AnimationUtils.loadInterpolator(context0, v9);
                        }
                        else {
                            switch(v8) {
                                case -1: {
                                    interpolator0 = new p(A1.e.d(s), 0);
                                    break;
                                }
                                case 0: {
                                    interpolator0 = new AccelerateDecelerateInterpolator();
                                    break;
                                }
                                case 1: {
                                    interpolator0 = new AccelerateInterpolator();
                                    break;
                                }
                                case 2: {
                                    interpolator0 = new DecelerateInterpolator();
                                    break;
                                }
                                case 4: {
                                    interpolator0 = new BounceInterpolator();
                                    break;
                                }
                                case 5: {
                                    interpolator0 = new OvershootInterpolator();
                                    break;
                                }
                                default: {
                                    interpolator0 = null;
                                }
                            }
                        }
                        q1.G = interpolator0;
                    }
                }
                if(this.d != null) {
                    e e1 = v.d(this.b, view1);
                    if(e1 != null) {
                        Rect rect2 = MotionLayout.c(motionLayout0, e1);
                        n n1 = this.d;
                        int v17 = motionLayout0.getWidth();
                        int v18 = motionLayout0.getHeight();
                        B b1 = q1.g;
                        int v19 = n1.d;
                        if(v19 != 0) {
                            q.h(rect2, q1.a, v19, v17, v18);
                            rect2 = q1.a;
                        }
                        b1.c = 1.0f;
                        b1.d = 1.0f;
                        q1.g(b1);
                        b1.d(((float)rect2.left), ((float)rect2.top), ((float)rect2.width()), ((float)rect2.height()));
                        b1.a(n1.l(q1.c));
                        q1.i.d(rect2, n1, v19, q1.c);
                    }
                    else if(motionLayout0.h0 != 0) {
                        Log.e("MotionLayout", ".(null:-1)no widget for  " + a.G(view1) + " (" + view1.getClass().getName() + ")");
                    }
                }
            }
        }
        for(int v20 = 0; v20 < v; ++v20) {
            q q2 = (q)sparseArray0.get(arr_v[v20]);
            int v21 = q2.f.k;
            if(v21 != -1) {
                q q3 = (q)sparseArray0.get(v21);
                q2.f.f(q3, q3.f);
                q2.g.f(q3, q3.g);
            }
        }
    }

    public final void b(int v, int v1) {
        MotionLayout motionLayout0 = this.g;
        int v2 = motionLayout0.getOptimizationLevel();
        if(motionLayout0.E == motionLayout0.getStartState()) {
            motionLayout0.resolveSystem(this.b, v2, (this.d == null || this.d.d == 0 ? v : v1), (this.d == null || this.d.d == 0 ? v1 : v));
            n n0 = this.c;
            if(n0 != null) {
                f f0 = this.a;
                int v3 = n0.d == 0 ? v : v1;
                if(n0.d == 0) {
                    v = v1;
                }
                motionLayout0.resolveSystem(f0, v2, v3, v);
            }
            return;
        }
        n n1 = this.c;
        if(n1 != null) {
            motionLayout0.resolveSystem(this.a, v2, (n1.d == 0 ? v : v1), (n1.d == 0 ? v1 : v));
        }
        f f1 = this.b;
        int v4 = this.d == null || this.d.d == 0 ? v : v1;
        if(this.d == null || this.d.d == 0) {
            v = v1;
        }
        motionLayout0.resolveSystem(f1, v2, v4, v);
    }

    public static void c(f f0, f f1) {
        e e1;
        ArrayList arrayList0 = f0.v0;
        HashMap hashMap0 = new HashMap();
        hashMap0.put(f0, f1);
        f1.v0.clear();
        f1.h(f0, hashMap0);
        for(Object object0: arrayList0) {
            e e0 = (e)object0;
            if(e0 instanceof F1.a) {
                e1 = new F1.a();
            }
            else if(e0 instanceof F1.i) {
                e1 = new F1.i();
            }
            else if(e0 instanceof h) {
                e1 = new h();
            }
            else if(e0 instanceof F1.l) {
                e1 = new F1.l();  // 初始化器: LF1/m;-><init>()V
            }
            else if(e0 instanceof j) {
                e1 = new j();
            }
            else {
                e1 = new e();
            }
            f1.W(e1);
            hashMap0.put(e0, e1);
        }
        for(Object object1: arrayList0) {
            ((e)hashMap0.get(((e)object1))).h(((e)object1), hashMap0);
        }
    }

    public static e d(f f0, View view0) {
        if(f0.i0 == view0) {
            return f0;
        }
        ArrayList arrayList0 = f0.v0;
        int v = arrayList0.size();
        for(int v1 = 0; v1 < v; ++v1) {
            e e0 = (e)arrayList0.get(v1);
            if(e0.i0 == view0) {
                return e0;
            }
        }
        return null;
    }

    public final void e(n n0, n n1) {
        this.c = n0;
        this.d = n1;
        this.a = new f();
        this.b = new f();
        MotionLayout motionLayout0 = this.g;
        c c0 = motionLayout0.mLayoutWidget.z0;
        this.a.z0 = c0;
        this.a.x0.g = c0;
        c c1 = motionLayout0.mLayoutWidget.z0;
        this.b.z0 = c1;
        this.b.x0.g = c1;
        this.a.v0.clear();
        this.b.v0.clear();
        v.c(motionLayout0.mLayoutWidget, this.a);
        v.c(motionLayout0.mLayoutWidget, this.b);
        if(((double)motionLayout0.b0) > 0.5) {
            if(n0 != null) {
                this.g(this.a, n0);
            }
            this.g(this.b, n1);
        }
        else {
            this.g(this.b, n1);
            if(n0 != null) {
                this.g(this.a, n0);
            }
        }
        f f0 = this.a;
        f0.A0 = motionLayout0.isRtl();
        this.a.w0.F(this.a);
        f f1 = this.b;
        f1.A0 = motionLayout0.isRtl();
        this.b.w0.F(this.b);
        ViewGroup.LayoutParams viewGroup$LayoutParams0 = motionLayout0.getLayoutParams();
        if(viewGroup$LayoutParams0 != null) {
            d d0 = d.b;
            if(viewGroup$LayoutParams0.width == -2) {
                this.a.P(d0);
                this.b.P(d0);
            }
            if(viewGroup$LayoutParams0.height == -2) {
                this.a.R(d0);
                this.b.R(d0);
            }
        }
    }

    public final void f() {
        boolean z1;
        f f1;
        MotionLayout motionLayout0 = this.g;
        int v = motionLayout0.I;
        int v1 = motionLayout0.M;
        int v2 = View.MeasureSpec.getMode(v);
        int v3 = View.MeasureSpec.getMode(v1);
        motionLayout0.I0 = v2;
        motionLayout0.J0 = v3;
        this.b(v, v1);
        boolean z = true;
        int v4 = 0;
        if(!(motionLayout0.getParent() instanceof MotionLayout) || v2 != 0x40000000 || v3 != 0x40000000) {
            this.b(v, v1);
            motionLayout0.E0 = this.a.s();
            motionLayout0.F0 = this.a.m();
            motionLayout0.G0 = this.b.s();
            int v5 = this.b.m();
            motionLayout0.H0 = v5;
            motionLayout0.mMeasureDuringTransition = motionLayout0.E0 != motionLayout0.G0 || motionLayout0.F0 != v5;
        }
        int v6 = motionLayout0.E0;
        int v7 = motionLayout0.F0;
        if(motionLayout0.I0 == 0x80000000 || motionLayout0.I0 == 0) {
            v6 = (int)(motionLayout0.K0 * ((float)(motionLayout0.G0 - v6)) + ((float)v6));
        }
        if(motionLayout0.J0 == 0x80000000 || motionLayout0.J0 == 0) {
            v7 = (int)(motionLayout0.K0 * ((float)(motionLayout0.H0 - v7)) + ((float)v7));
        }
        f f0 = this.a;
        if(f0.J0 || this.b.J0) {
            f1 = f0;
            z1 = true;
        }
        else {
            f1 = f0;
            z1 = false;
        }
        motionLayout0.resolveMeasuredDimension(v, v1, v6, v7, z1, f1.K0 || this.b.K0);
        HashMap hashMap0 = motionLayout0.S;
        int v8 = motionLayout0.getChildCount();
        motionLayout0.a1.a();
        motionLayout0.f0 = true;
        SparseArray sparseArray0 = new SparseArray();
        for(int v9 = 0; v9 < v8; ++v9) {
            View view0 = motionLayout0.getChildAt(v9);
            sparseArray0.put(view0.getId(), ((q)hashMap0.get(view0)));
        }
        int v10 = motionLayout0.getWidth();
        int v11 = motionLayout0.getHeight();
        D d0 = motionLayout0.o.c;
        int v12 = d0 == null ? -1 : d0.p;
        if(v12 != -1) {
            for(int v13 = 0; v13 < v8; ++v13) {
                q q0 = (q)hashMap0.get(motionLayout0.getChildAt(v13));
                if(q0 != null) {
                    q0.B = v12;
                }
            }
        }
        SparseBooleanArray sparseBooleanArray0 = new SparseBooleanArray();
        int[] arr_v = new int[hashMap0.size()];
        int v15 = 0;
        for(int v14 = 0; v14 < v8; ++v14) {
            q q1 = (q)hashMap0.get(motionLayout0.getChildAt(v14));
            int v16 = q1.f.k;
            if(v16 != -1) {
                sparseBooleanArray0.put(v16, true);
                arr_v[v15] = q1.f.k;
                ++v15;
            }
        }
        if(motionLayout0.x0 == null) {
            for(int v19 = 0; v19 < v15; ++v19) {
                q q4 = (q)hashMap0.get(motionLayout0.findViewById(arr_v[v19]));
                if(q4 != null) {
                    motionLayout0.o.f(q4);
                    q4.i(v10, v11, 0xCA43D917F88L);
                }
            }
        }
        else {
            for(int v17 = 0; v17 < v15; ++v17) {
                q q2 = (q)hashMap0.get(motionLayout0.findViewById(arr_v[v17]));
                if(q2 != null) {
                    motionLayout0.o.f(q2);
                }
            }
            for(Object object0: motionLayout0.x0) {
                ((MotionHelper)object0).q(motionLayout0, hashMap0);
            }
            for(int v18 = 0; v18 < v15; ++v18) {
                q q3 = (q)hashMap0.get(motionLayout0.findViewById(arr_v[v18]));
                if(q3 != null) {
                    q3.i(v10, v11, 13899546669500L);
                }
            }
        }
        for(int v20 = 0; v20 < v8; ++v20) {
            View view1 = motionLayout0.getChildAt(v20);
            q q5 = (q)hashMap0.get(view1);
            if(!sparseBooleanArray0.get(view1.getId()) && q5 != null) {
                motionLayout0.o.f(q5);
                q5.i(v10, v11, 13899547503900L);
            }
        }
        D d1 = motionLayout0.o.c;
        float f2 = d1 == null ? 0.0f : d1.i;
        if(f2 != 0.0f) {
            if(((double)f2) >= 0.0) {
                z = false;
            }
            float f3 = Math.abs(f2);
            float f4 = -3.402823E+38f;
            float f5 = 3.402823E+38f;
            float f6 = -3.402823E+38f;
            float f7 = 3.402823E+38f;
            for(int v21 = 0; v21 < v8; ++v21) {
                q q6 = (q)hashMap0.get(motionLayout0.getChildAt(v21));
                if(!Float.isNaN(q6.l)) {
                    for(int v22 = 0; v22 < v8; ++v22) {
                        q q7 = (q)hashMap0.get(motionLayout0.getChildAt(v22));
                        if(!Float.isNaN(q7.l)) {
                            f5 = Math.min(f5, q7.l);
                            f4 = Math.max(f4, q7.l);
                        }
                    }
                    while(v4 < v8) {
                        q q8 = (q)hashMap0.get(motionLayout0.getChildAt(v4));
                        if(!Float.isNaN(q8.l)) {
                            q8.n = 1.0f / (1.0f - f3);
                            q8.m = z ? f3 - (f4 - q8.l) / (f4 - f5) * f3 : f3 - (q8.l - f5) * f3 / (f4 - f5);
                        }
                        ++v4;
                    }
                    return;
                }
                float f8 = q6.g.e;
                float f9 = q6.g.f;
                float f10 = z ? f9 - f8 : f9 + f8;
                f7 = Math.min(f7, f10);
                f6 = Math.max(f6, f10);
            }
            while(v4 < v8) {
                q q9 = (q)hashMap0.get(motionLayout0.getChildAt(v4));
                float f11 = q9.g.e;
                float f12 = q9.g.f;
                q9.n = 1.0f / (1.0f - f3);
                q9.m = f3 - ((z ? f12 - f11 : f12 + f11) - f7) * f3 / (f6 - f7);
                ++v4;
            }
        }
    }

    public final void g(f f0, n n0) {
        SparseArray sparseArray0 = new SparseArray();
        LayoutParams constraints$LayoutParams0 = new LayoutParams();
        sparseArray0.clear();
        sparseArray0.put(0, f0);
        MotionLayout motionLayout0 = this.g;
        sparseArray0.put(motionLayout0.getId(), f0);
        if(n0 != null && n0.d != 0) {
            motionLayout0.resolveSystem(this.b, motionLayout0.getOptimizationLevel(), View.MeasureSpec.makeMeasureSpec(motionLayout0.getHeight(), 0x40000000), View.MeasureSpec.makeMeasureSpec(motionLayout0.getWidth(), 0x40000000));
        }
        for(Object object0: f0.v0) {
            ((e)object0).k0 = true;
            sparseArray0.put(((View)((e)object0).i0).getId(), ((e)object0));
        }
        for(Object object1: f0.v0) {
            e e0 = (e)object1;
            View view0 = (View)e0.i0;
            int v = view0.getId();
            HashMap hashMap0 = n0.g;
            if(hashMap0.containsKey(v)) {
                i i0 = (i)hashMap0.get(v);
                if(i0 != null) {
                    i0.a(constraints$LayoutParams0);
                }
            }
            e0.T(n0.l(view0.getId()).e.c);
            e0.O(n0.l(view0.getId()).e.d);
            if(view0 instanceof ConstraintHelper) {
                int v1 = ((ConstraintHelper)view0).getId();
                HashMap hashMap1 = n0.g;
                if(hashMap1.containsKey(v1)) {
                    i i1 = (i)hashMap1.get(v1);
                    if(i1 != null && e0 instanceof j) {
                        ((ConstraintHelper)view0).k(i1, ((j)e0), constraints$LayoutParams0, sparseArray0);
                    }
                }
                if(view0 instanceof Barrier) {
                    ((Barrier)view0).p();
                }
            }
            constraints$LayoutParams0.resolveLayoutDirection(motionLayout0.getLayoutDirection());
            motionLayout0.applyConstraintsFromLayoutParams(false, view0, e0, constraints$LayoutParams0, sparseArray0);
            e0.j0 = n0.l(view0.getId()).c.c == 1 ? view0.getVisibility() : n0.l(view0.getId()).c.b;
        }
        for(Object object2: f0.v0) {
            e e1 = (e)object2;
            if(e1 instanceof m) {
                ((ConstraintHelper)e1.i0).o(((j)e1), sparseArray0);
                m m0 = (m)(((j)e1));
                for(int v2 = 0; v2 < m0.w0; ++v2) {
                    e e2 = m0.v0[v2];
                    if(e2 != null) {
                        e2.H = true;
                    }
                }
            }
        }
    }
}

