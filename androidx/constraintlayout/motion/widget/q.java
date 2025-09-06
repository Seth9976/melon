package androidx.constraintlayout.motion.widget;

import A1.b;
import A1.e;
import B.a;
import I1.d;
import I1.f;
import I1.h;
import I1.i;
import I1.k;
import I1.m;
import I1.p;
import U4.x;
import android.graphics.Rect;
import android.util.Log;
import android.util.SparseArray;
import android.view.View.MeasureSpec;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Interpolator;
import androidx.constraintlayout.utils.widget.MotionLabel;
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams;
import h7.u0;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import k8.Y;

public final class q {
    public n[] A;
    public int B;
    public int C;
    public View D;
    public int E;
    public float F;
    public Interpolator G;
    public boolean H;
    public final Rect a;
    public final View b;
    public final int c;
    public boolean d;
    public int e;
    public final B f;
    public final B g;
    public final o h;
    public final o i;
    public a[] j;
    public b k;
    public float l;
    public float m;
    public float n;
    public int[] o;
    public double[] p;
    public double[] q;
    public String[] r;
    public int[] s;
    public final float[] t;
    public final ArrayList u;
    public final float[] v;
    public final ArrayList w;
    public HashMap x;
    public HashMap y;
    public HashMap z;

    public q(View view0) {
        this.a = new Rect();
        this.d = false;
        this.e = -1;
        this.f = new B();
        this.g = new B();
        this.h = new o();
        this.i = new o();
        this.l = NaNf;
        this.m = 0.0f;
        this.n = 1.0f;
        this.t = new float[4];
        this.u = new ArrayList();
        this.v = new float[1];
        this.w = new ArrayList();
        this.B = -1;
        this.C = -1;
        this.D = null;
        this.E = -1;
        this.F = NaNf;
        this.G = null;
        this.H = false;
        this.b = view0;
        this.c = view0.getId();
        ViewGroup.LayoutParams viewGroup$LayoutParams0 = view0.getLayoutParams();
        if(viewGroup$LayoutParams0 instanceof LayoutParams) {
            ((LayoutParams)viewGroup$LayoutParams0).getClass();
        }
    }

    public final void a(c c0) {
        this.w.add(c0);
    }

    public final float b(float[] arr_f, float f) {
        float f1 = 0.0f;
        float f2 = 1.0f;
        if(arr_f == null) {
            float f3 = this.n;
            if(((double)f3) != 1.0) {
                float f4 = this.m;
                if(f < f4) {
                    f = 0.0f;
                }
                if(f > f4 && ((double)f) < 1.0) {
                    f = Math.min((f - f4) * f3, 1.0f);
                }
            }
        }
        else {
            arr_f[0] = 1.0f;
        }
        e e0 = this.f.a;
        float f5 = NaNf;
        for(Object object0: this.u) {
            B b0 = (B)object0;
            e e1 = b0.a;
            if(e1 != null) {
                float f6 = b0.c;
                if(f6 < f) {
                    e0 = e1;
                    f1 = f6;
                }
                else if(Float.isNaN(f5)) {
                    f5 = b0.c;
                }
            }
        }
        if(e0 != null) {
            if(!Float.isNaN(f5)) {
                f2 = f5;
            }
            float f7 = f2 - f1;
            double f8 = (double)((f - f1) / f7);
            f = ((float)e0.a(f8)) * f7 + f1;
            if(arr_f != null) {
                arr_f[0] = (float)e0.b(f8);
            }
        }
        return f;
    }

    public final void c(double f, float[] arr_f, float[] arr_f1) {
        double[] arr_f2 = new double[4];
        double[] arr_f3 = new double[4];
        this.j[0].I(f, arr_f2);
        this.j[0].L(f, arr_f3);
        float f1 = 0.0f;
        Arrays.fill(arr_f1, 0.0f);
        int[] arr_v = this.o;
        B b0 = this.f;
        float f2 = b0.e;
        float f3 = b0.f;
        float f4 = b0.g;
        float f5 = b0.h;
        float f6 = 0.0f;
        float f7 = 0.0f;
        float f8 = 0.0f;
        for(int v = 0; v < arr_v.length; ++v) {
            float f9 = (float)arr_f2[v];
            float f10 = (float)arr_f3[v];
            switch(arr_v[v]) {
                case 1: {
                    f2 = f9;
                    f1 = f10;
                    break;
                }
                case 2: {
                    f3 = f9;
                    f8 = f10;
                    break;
                }
                case 3: {
                    f4 = f9;
                    f6 = f10;
                    break;
                }
                case 4: {
                    f5 = f9;
                    f7 = f10;
                }
            }
        }
        float f11 = f6 / 2.0f + f1;
        float f12 = f7 / 2.0f + f8;
        q q0 = b0.m;
        if(q0 != null) {
            float[] arr_f4 = new float[2];
            float[] arr_f5 = new float[2];
            q0.c(f, arr_f4, arr_f5);
            double f13 = Math.sin(f3);
            double f14 = Math.sin(f3);
            double f15 = Math.cos(f3);
            double f16 = Math.cos(f3);
            double f17 = Math.sin(f3);
            f3 = (float)(((double)arr_f4[1]) - Math.cos(f3) * ((double)f2) - ((double)(f5 / 2.0f)));
            f11 = (float)(f15 * ((double)f8) + (f14 * ((double)f1) + ((double)arr_f5[0])));
            f12 = (float)(f17 * ((double)f8) + (((double)arr_f5[1]) - f16 * ((double)f1)));
            f2 = (float)(f13 * ((double)f2) + ((double)arr_f4[0]) - ((double)(f4 / 2.0f)));
        }
        arr_f[0] = f4 / 2.0f + f2 + 0.0f;
        arr_f[1] = f5 / 2.0f + f3 + 0.0f;
        arr_f1[0] = f11;
        arr_f1[1] = f12;
    }

    public final void d(float f, float f1, float f2, float[] arr_f) {
        double[] arr_f2;
        float[] arr_f1 = this.v;
        float f3 = this.b(arr_f1, f);
        a[] arr_a = this.j;
        if(arr_a != null) {
            arr_a[0].L(((double)f3), this.q);
            this.j[0].I(((double)f3), this.p);
            float f4 = arr_f1[0];
            for(int v = 0; true; ++v) {
                arr_f2 = this.q;
                if(v >= arr_f2.length) {
                    break;
                }
                arr_f2[v] *= (double)f4;
            }
            b b0 = this.k;
            if(b0 != null) {
                double[] arr_f3 = this.p;
                if(arr_f3.length > 0) {
                    b0.I(((double)f3), arr_f3);
                    this.k.L(((double)f3), this.q);
                    int[] arr_v = this.o;
                    double[] arr_f4 = this.q;
                    double[] arr_f5 = this.p;
                    this.f.getClass();
                    B.e(f1, f2, arr_f, arr_v, arr_f4, arr_f5);
                }
                return;
            }
            int[] arr_v1 = this.o;
            double[] arr_f6 = this.p;
            this.f.getClass();
            B.e(f1, f2, arr_f, arr_v1, arr_f2, arr_f6);
            return;
        }
        float f5 = this.g.e - this.f.e;
        float f6 = this.g.f - this.f.f;
        float f7 = this.g.h - this.f.h + f6;
        arr_f[0] = (this.g.g - this.f.g + f5) * f1 + (1.0f - f1) * f5;
        arr_f[1] = f7 * f2 + (1.0f - f2) * f6;
    }

    public final float e() {
        float[] arr_f = new float[2];
        double f = 0.0;
        double f1 = 0.0;
        float f2 = 0.0f;
        for(int v = 0; v < 100; ++v) {
            float f3 = ((float)v) * 0.010101f;
            double f4 = (double)f3;
            e e0 = this.f.a;
            float f5 = NaNf;
            float f6 = 0.0f;
            for(Object object0: this.u) {
                B b0 = (B)object0;
                e e1 = b0.a;
                if(e1 != null) {
                    float f7 = b0.c;
                    if(f7 < f3) {
                        e0 = e1;
                        f6 = f7;
                    }
                    else if(Float.isNaN(f5)) {
                        f5 = b0.c;
                    }
                }
            }
            if(e0 != null) {
                if(Float.isNaN(f5)) {
                    f5 = 1.0f;
                }
                f4 = (double)(((float)e0.a(((double)((f3 - f6) / (f5 - f6))))) * (f5 - f6) + f6);
            }
            this.j[0].I(f4, this.p);
            this.f.c(f4, this.o, this.p, arr_f, 0);
            if(v > 0) {
                f2 += (float)Math.hypot(f1 - ((double)arr_f[1]), f - ((double)arr_f[0]));
            }
            f = (double)arr_f[0];
            f1 = (double)arr_f[1];
        }
        return f2;
    }

    public final boolean f(float f, long v, e e0, View view0) {
        boolean z4;
        boolean z3;
        boolean z2;
        float f9;
        I1.o o2;
        boolean z;
        float f4;
        I1.o o0 = null;
        float f1 = this.b(null, f);
        int v1 = this.E;
        if(v1 != -1) {
            float f2 = ((float)Math.floor(f1 / (1.0f / ((float)v1)))) * (1.0f / ((float)v1));
            float f3 = f1 % (1.0f / ((float)v1)) / (1.0f / ((float)v1));
            if(!Float.isNaN(this.F)) {
                f3 = (f3 + this.F) % 1.0f;
            }
            Interpolator interpolator0 = this.G;
            if(interpolator0 == null) {
                f4 = ((double)f3) > 0.5 ? 1.0f : 0.0f;
            }
            else {
                f4 = interpolator0.getInterpolation(f3);
            }
            f1 = f4 * (1.0f / ((float)v1)) + f2;
        }
        HashMap hashMap0 = this.y;
        if(hashMap0 != null) {
            for(Object object0: hashMap0.values()) {
                ((k)object0).c(view0, f1);
            }
        }
        HashMap hashMap1 = this.x;
        if(hashMap1 == null) {
            z = false;
        }
        else {
            I1.o o1 = null;
            z = false;
            for(Object object1: hashMap1.values()) {
                I1.q q0 = (I1.q)object1;
                if(q0 instanceof I1.o) {
                    o1 = (I1.o)q0;
                }
                else {
                    z |= q0.d(f1, v, e0, view0);
                }
            }
            o0 = o1;
        }
        a[] arr_a = this.j;
        B b0 = this.f;
        if(arr_a == null) {
            float f29 = (this.g.e - b0.e) * f1 + b0.e;
            float f30 = (this.g.f - b0.f) * f1 + b0.f;
            int v16 = (int)(f29 + 0.5f + ((this.g.g - b0.g) * f1 + b0.g));
            int v17 = (int)(f30 + 0.5f + ((this.g.h - b0.h) * f1 + b0.h));
            if(this.g.g != b0.g || this.g.h != b0.h || this.d) {
                view0.measure(View.MeasureSpec.makeMeasureSpec(v16 - ((int)(f29 + 0.5f)), 0x40000000), View.MeasureSpec.makeMeasureSpec(v17 - ((int)(f30 + 0.5f)), 0x40000000));
                this.d = false;
            }
            view0.layout(((int)(f29 + 0.5f)), ((int)(f30 + 0.5f)), v16, v17);
            z4 = z;
        }
        else {
            arr_a[0].I(((double)f1), this.p);
            this.j[0].L(((double)f1), this.q);
            b b1 = this.k;
            if(b1 != null) {
                double[] arr_f = this.p;
                if(arr_f.length > 0) {
                    b1.I(((double)f1), arr_f);
                    this.k.L(((double)f1), this.q);
                }
            }
            if(this.H) {
                o2 = o0;
                z3 = z;
            }
            else {
                int[] arr_v = this.o;
                double[] arr_f1 = this.p;
                double[] arr_f2 = this.q;
                boolean z1 = this.d;
                float f5 = b0.e;
                float f6 = b0.f;
                float f7 = b0.g;
                float f8 = b0.h;
                o2 = o0;
                if(arr_v.length == 0) {
                    f9 = f7;
                }
                else {
                    f9 = f7;
                    if(b0.r.length <= arr_v[arr_v.length - 1]) {
                        int v2 = arr_v[arr_v.length - 1] + 1;
                        b0.r = new double[v2];
                        b0.w = new double[v2];
                    }
                }
                Arrays.fill(b0.r, NaN);
                for(int v3 = 0; v3 < arr_v.length; ++v3) {
                    double[] arr_f3 = b0.r;
                    int v4 = arr_v[v3];
                    arr_f3[v4] = arr_f1[v3];
                    b0.w[v4] = arr_f2[v3];
                }
                float f10 = NaNf;
                float f11 = 0.0f;
                float f12 = 0.0f;
                float f13 = 0.0f;
                int v5 = 0;
                float f14 = f9;
                float f15 = 0.0f;
                while(true) {
                    double f16 = 0.0;
                    double[] arr_f4 = b0.r;
                    if(v5 >= b0.r.length) {
                        break;
                    }
                    if(Double.isNaN(arr_f4[v5])) {
                        z2 = z;
                    }
                    else {
                        if(!Double.isNaN(b0.r[v5])) {
                            f16 = b0.r[v5] + 0.0;
                        }
                        z2 = z;
                        float f17 = (float)b0.w[v5];
                        switch(v5) {
                            case 1: {
                                f5 = (float)f16;
                                f11 = f17;
                                break;
                            }
                            case 2: {
                                f6 = (float)f16;
                                f12 = f17;
                                break;
                            }
                            case 3: {
                                f14 = (float)f16;
                                f15 = f17;
                                break;
                            }
                            case 4: {
                                f8 = (float)f16;
                                f13 = f17;
                                break;
                            }
                            case 5: {
                                f10 = (float)f16;
                            }
                        }
                    }
                    ++v5;
                    z = z2;
                }
                z3 = z;
                q q1 = b0.m;
                if(q1 != null) {
                    float[] arr_f5 = new float[2];
                    float[] arr_f6 = new float[2];
                    q1.c(((double)f1), arr_f5, arr_f6);
                    float f18 = arr_f5[0];
                    double f19 = Math.sin(f6);
                    float f20 = (float)(((double)arr_f5[1]) - Math.cos(f6) * ((double)f5) - ((double)(f8 / 2.0f)));
                    float f21 = (float)(Math.cos(f6) * ((double)f5) * ((double)f12) + (Math.sin(f6) * ((double)f11) + ((double)arr_f6[0])));
                    float f22 = (float)(Math.sin(f6) * ((double)f5) * ((double)f12) + (((double)arr_f6[1]) - Math.cos(f6) * ((double)f11)));
                    if(arr_f2.length >= 2) {
                        arr_f2[0] = (double)f21;
                        arr_f2[1] = (double)f22;
                    }
                    if(!Float.isNaN(f10)) {
                        view0.setRotation(((float)(Math.toDegrees(Math.atan2(f22, f21)) + ((double)f10))));
                    }
                    f5 = (float)(f19 * ((double)f5) + ((double)f18) - ((double)(f14 / 2.0f)));
                    f6 = f20;
                }
                else if(!Float.isNaN(f10)) {
                    view0.setRotation(f10 + ((float)Math.toDegrees(Math.atan2(f13 / 2.0f + f12, f15 / 2.0f + f11))) + 0.0f);
                }
                if(view0 instanceof androidx.constraintlayout.motion.widget.b) {
                    ((MotionLabel)(((androidx.constraintlayout.motion.widget.b)view0))).c(f5, f6, f5 + f14, f6 + f8);
                }
                else {
                    int v6 = (int)(f5 + 0.5f + f14);
                    int v7 = (int)(f6 + 0.5f + f8);
                    int v8 = v6 - ((int)(f5 + 0.5f));
                    int v9 = v7 - ((int)(f6 + 0.5f));
                    if(v8 != view0.getMeasuredWidth() || v9 != view0.getMeasuredHeight() || z1) {
                        view0.measure(View.MeasureSpec.makeMeasureSpec(v8, 0x40000000), View.MeasureSpec.makeMeasureSpec(v9, 0x40000000));
                    }
                    view0.layout(((int)(f5 + 0.5f)), ((int)(f6 + 0.5f)), v6, v7);
                }
                this.d = false;
            }
            if(this.C != -1) {
                if(this.D == null) {
                    this.D = ((View)view0.getParent()).findViewById(this.C);
                }
                View view1 = this.D;
                if(view1 != null) {
                    int v10 = view1.getTop();
                    int v11 = this.D.getBottom();
                    int v12 = this.D.getLeft();
                    int v13 = this.D.getRight();
                    if(view0.getRight() - view0.getLeft() > 0 && view0.getBottom() - view0.getTop() > 0) {
                        float f23 = ((float)(v13 + v12)) / 2.0f - ((float)view0.getLeft());
                        float f24 = ((float)(v11 + v10)) / 2.0f - ((float)view0.getTop());
                        view0.setPivotX(f23);
                        view0.setPivotY(f24);
                    }
                }
            }
            HashMap hashMap2 = this.y;
            if(hashMap2 != null) {
                for(Object object2: hashMap2.values()) {
                    k k0 = (k)object2;
                    if(k0 instanceof i) {
                        double[] arr_f7 = this.q;
                        if(arr_f7.length > 1) {
                            double f25 = arr_f7[0];
                            double f26 = arr_f7[1];
                            view0.setRotation(((i)k0).a(f1) + ((float)Math.toDegrees(Math.atan2(f26, f25))));
                        }
                    }
                }
            }
            if(o2 == null) {
                z4 = z3;
            }
            else {
                double[] arr_f8 = this.q;
                double f27 = arr_f8[0];
                double f28 = arr_f8[1];
                view0.setRotation(o2.b(f1, v, e0, view0) + ((float)Math.toDegrees(Math.atan2(f28, f27))));
                z4 = z3 | o2.h;
            }
            for(int v14 = 1; true; ++v14) {
                a[] arr_a1 = this.j;
                if(v14 >= arr_a1.length) {
                    break;
                }
                arr_a1[v14].J(((double)f1), this.t);
                u0.R(((androidx.constraintlayout.widget.a)b0.n.get(this.r[v14 - 1])), view0, this.t);
            }
            o o3 = this.h;
            if(o3.b == 0) {
                if(f1 <= 0.0f) {
                    view0.setVisibility(o3.c);
                }
                else {
                    o o4 = this.i;
                    if(Float.compare(f1, 1.0f) >= 0) {
                        view0.setVisibility(o4.c);
                    }
                    else if(o4.c != o3.c) {
                        view0.setVisibility(0);
                    }
                }
            }
            if(this.A != null) {
                for(int v15 = 0; true; ++v15) {
                    n[] arr_n = this.A;
                    if(v15 >= arr_n.length) {
                        break;
                    }
                    arr_n[v15].h(view0, f1);
                }
            }
        }
        HashMap hashMap3 = this.z;
        if(hashMap3 != null) {
            for(Object object3: hashMap3.values()) {
                f f31 = (f)object3;
                if(f31 instanceof d) {
                    double[] arr_f9 = this.q;
                    double f32 = arr_f9[0];
                    double f33 = arr_f9[1];
                    view0.setRotation(((d)f31).a(f1) + ((float)Math.toDegrees(Math.atan2(f33, f32))));
                }
                else {
                    f31.e(view0, f1);
                }
            }
        }
        return z4;
    }

    public final void g(B b0) {
        b0.d(((float)(((int)this.b.getX()))), ((float)(((int)this.b.getY()))), ((float)this.b.getWidth()), ((float)this.b.getHeight()));
    }

    public static void h(Rect rect0, Rect rect1, int v, int v1, int v2) {
        switch(v) {
            case 1: {
                int v3 = rect0.left + rect0.right;
                rect1.left = (rect0.top + rect0.bottom - rect0.width()) / 2;
                rect1.top = v2 - (rect0.height() + v3) / 2;
                int v4 = rect1.left;
                rect1.right = rect0.width() + v4;
                int v5 = rect1.top;
                rect1.bottom = rect0.height() + v5;
                return;
            }
            case 2: {
                int v6 = rect0.left + rect0.right;
                int v7 = rect0.top + rect0.bottom;
                rect1.left = v1 - (rect0.width() + v7) / 2;
                rect1.top = (v6 - rect0.height()) / 2;
                int v8 = rect1.left;
                rect1.right = rect0.width() + v8;
                int v9 = rect1.top;
                rect1.bottom = rect0.height() + v9;
                return;
            }
            case 3: {
                int v10 = rect0.left + rect0.right;
                rect1.left = rect0.height() / 2 + rect0.top - v10 / 2;
                rect1.top = v2 - (rect0.height() + v10) / 2;
                int v11 = rect1.left;
                rect1.right = rect0.width() + v11;
                int v12 = rect1.top;
                rect1.bottom = rect0.height() + v12;
                return;
            }
            case 4: {
                int v13 = rect0.left + rect0.right;
                int v14 = rect0.bottom + rect0.top;
                rect1.left = v1 - (rect0.width() + v14) / 2;
                rect1.top = (v13 - rect0.height()) / 2;
                int v15 = rect1.left;
                rect1.right = rect0.width() + v15;
                int v16 = rect1.top;
                rect1.bottom = rect0.height() + v16;
            }
        }
    }

    // This method was un-flattened
    public final void i(int v, int v1, long v2) {
        int v35;
        String s11;
        int v34;
        String[] arr_s1;
        HashSet hashSet7;
        I1.n n1;
        Iterator iterator7;
        int v6;
        ArrayList arrayList5;
        B b4;
        HashSet hashSet5;
        HashSet hashSet4;
        h h1;
        Iterator iterator3;
        ArrayList arrayList4;
        B b3;
        HashSet hashSet3;
        ArrayList arrayList3;
        new HashSet();
        HashSet hashSet0 = new HashSet();
        HashSet hashSet1 = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashMap hashMap0 = new HashMap();
        int v3 = this.B;
        B b0 = this.f;
        if(v3 != -1) {
            b0.j = v3;
        }
        o o0 = this.h;
        o o1 = this.i;
        if(o.c(o0.e, o1.e)) {
            hashSet1.add("alpha");
        }
        if(o.c(o0.f, o1.f)) {
            hashSet1.add("elevation");
        }
        if(o0.c != o1.c && o0.b == 0 && (o0.c == 0 || o1.c == 0)) {
            hashSet1.add("alpha");
        }
        if(o.c(o0.g, o1.g)) {
            hashSet1.add("rotation");
        }
        if(!Float.isNaN(o0.r) || !Float.isNaN(o1.r)) {
            hashSet1.add("transitionPathRotate");
        }
        if(!Float.isNaN(o0.w) || !Float.isNaN(o1.w)) {
            hashSet1.add("progress");
        }
        if(o.c(o0.h, o1.h)) {
            hashSet1.add("rotationX");
        }
        if(o.c(o0.a, o1.a)) {
            hashSet1.add("rotationY");
        }
        if(o.c(o0.k, o1.k)) {
            hashSet1.add("transformPivotX");
        }
        if(o.c(o0.l, o1.l)) {
            hashSet1.add("transformPivotY");
        }
        if(o.c(o0.i, o1.i)) {
            hashSet1.add("scaleX");
        }
        if(o.c(o0.j, o1.j)) {
            hashSet1.add("scaleY");
        }
        if(o.c(o0.m, o1.m)) {
            hashSet1.add("translationX");
        }
        if(o.c(o0.n, o1.n)) {
            hashSet1.add("translationY");
        }
        if(o.c(o0.o, o1.o)) {
            hashSet1.add("translationZ");
        }
        B b1 = this.g;
        ArrayList arrayList0 = this.u;
        ArrayList arrayList1 = this.w;
        if(arrayList1 == null) {
            arrayList3 = null;
        }
        else {
            ArrayList arrayList2 = null;
            for(Object object0: arrayList1) {
                c c0 = (c)object0;
                if(c0 instanceof j) {
                    j j0 = (j)c0;
                    B b2 = new B();  // 初始化器: Ljava/lang/Object;-><init>()V
                    b2.b = 0;
                    b2.i = NaNf;
                    b2.j = -1;
                    b2.k = -1;
                    b2.l = NaNf;
                    b2.m = null;
                    b2.n = new LinkedHashMap();
                    b2.o = 0;
                    b2.r = new double[18];
                    b2.w = new double[18];
                    if(b0.k == -1) {
                        switch(j0.m) {
                            case 1: {
                                float f8 = ((float)j0.a) / 100.0f;
                                b2.c = f8;
                                b2.b = j0.h;
                                float f9 = Float.isNaN(j0.i) ? f8 : j0.i;
                                float f10 = Float.isNaN(j0.j) ? f8 : j0.j;
                                float f11 = b1.g - b0.g;
                                float f12 = f8;
                                float f13 = b1.h - b0.h;
                                b2.d = b2.c;
                                if(!Float.isNaN(j0.k)) {
                                    f12 = j0.k;
                                }
                                float f14 = b1.g / 2.0f + b1.e - (b0.g / 2.0f + b0.e);
                                float f15 = b1.h / 2.0f + b1.f - (b0.h / 2.0f + b0.f);
                                float f16 = f11 * f9;
                                float f17 = f13 * f10;
                                b2.g = (float)(((int)(b0.g + f16)));
                                b2.h = (float)(((int)(b0.h + f17)));
                                float f18 = Float.isNaN(j0.l) ? 0.0f : j0.l;
                                b2.o = 1;
                                b2.e = ((float)(((int)(b0.e + f14 * f12 - f16 / 2.0f)))) + -f15 * f18;
                                b2.f = ((float)(((int)(b0.f + f12 * f15 - f17 / 2.0f)))) + f14 * f18;
                                b2.k = b2.k;
                                b2.a = e.d(j0.f);
                                b2.j = j0.g;
                                break;
                            }
                            case 2: {
                                float f19 = ((float)j0.a) / 100.0f;
                                b2.c = f19;
                                b2.b = j0.h;
                                b2.d = b2.c;
                                float f20 = (b1.g - b0.g) * (Float.isNaN(j0.i) ? f19 : j0.i);
                                b2.e = (float)(((int)((b1.g / 2.0f + b1.e - (b0.g / 2.0f + b0.e)) * f19 + b0.e - f20 / 2.0f)));
                                float f21 = (b1.h - b0.h) * (Float.isNaN(j0.j) ? f19 : j0.j);
                                b2.f = (float)(((int)((b1.h / 2.0f + b1.f - (b0.h / 2.0f + b0.f)) * f19 + b0.f - f21 / 2.0f)));
                                b2.g = (float)(((int)(b0.g + f20)));
                                b2.h = (float)(((int)(b0.h + f21)));
                                b2.o = 2;
                                if(!Float.isNaN(j0.k)) {
                                    b2.e = (float)(((int)(j0.k * ((float)(v - ((int)b2.g))))));
                                }
                                if(!Float.isNaN(j0.l)) {
                                    b2.f = (float)(((int)(j0.l * ((float)(v1 - ((int)b2.h))))));
                                }
                                b2.k = b2.k;
                                b2.a = e.d(j0.f);
                                b2.j = j0.g;
                                break;
                            }
                            case 3: {
                                float f22 = ((float)j0.a) / 100.0f;
                                b2.c = f22;
                                b2.b = j0.h;
                                float f23 = Float.isNaN(j0.i) ? f22 : j0.i;
                                float f24 = Float.isNaN(j0.j) ? f22 : j0.j;
                                float f25 = b0.g;
                                float f26 = b1.g - f25;
                                float f27 = b1.h - b0.h;
                                float f28 = b0.h;
                                b2.d = b2.c;
                                float f29 = f25 / 2.0f + b0.e;
                                float f30 = f28 / 2.0f + b0.f;
                                float f31 = b1.g / 2.0f + b1.e;
                                float f32 = b1.h / 2.0f + b1.f;
                                if(f29 > f31) {
                                    float f33 = f29;
                                    f29 = f31;
                                    f31 = f33;
                                }
                                if(f30 <= f32) {
                                    float f34 = f30;
                                    f30 = f32;
                                    f32 = f34;
                                }
                                float f35 = f31 - f29;
                                float f36 = f30 - f32;
                                float f37 = f26 * f23;
                                float f38 = f27 * f24;
                                b2.g = (float)(((int)(f25 + f37)));
                                b2.h = (float)(((int)(f28 + f38)));
                                b2.o = 0;
                                b2.e = (float)(((int)(0.0f * f36 + ((Float.isNaN(j0.k) ? f22 : j0.k) * f35 + b0.e) - f37 / 2.0f)));
                                b2.f = (float)(((int)(f36 * (Float.isNaN(j0.l) ? f22 : j0.l) + (f35 * 0.0f + b0.f) - f38 / 2.0f)));
                                b2.a = e.d(j0.f);
                                b2.j = j0.g;
                                break;
                            }
                            default: {
                                float f3 = ((float)j0.a) / 100.0f;
                                b2.c = f3;
                                b2.b = j0.h;
                                b2.d = b2.c;
                                float f4 = b1.g / 2.0f + b1.e - (b0.g / 2.0f + b0.e);
                                float f5 = b1.h / 2.0f + b1.f - (b0.h / 2.0f + b0.f);
                                float f6 = (b1.g - b0.g) * (Float.isNaN(j0.i) ? f3 : j0.i);
                                float f7 = (b1.h - b0.h) * (Float.isNaN(j0.j) ? f3 : j0.j);
                                b2.g = (float)(((int)(b0.g + f6)));
                                b2.h = (float)(((int)(b0.h + f7)));
                                b2.o = 0;
                                b2.e = (float)(((int)(0.0f * f5 + ((Float.isNaN(j0.k) ? f3 : j0.k) * f4 + b0.e) - f6 / 2.0f)));
                                b2.f = (float)(((int)(f5 * (Float.isNaN(j0.l) ? f3 : j0.l) + (f4 * 0.0f + b0.f) - f7 / 2.0f)));
                                b2.a = e.d(j0.f);
                                b2.j = j0.g;
                            }
                        }
                    }
                    else {
                        float f = ((float)j0.a) / 100.0f;
                        b2.c = f;
                        b2.b = j0.h;
                        b2.o = j0.m;
                        float f1 = Float.isNaN(j0.i) ? f : j0.i;
                        float f2 = Float.isNaN(j0.j) ? f : j0.j;
                        b2.d = b2.c;
                        b2.g = (float)(((int)((b1.g - b0.g) * f1 + b0.g)));
                        b2.h = (float)(((int)((b1.h - b0.h) * f2 + b0.h)));
                        if(j0.m == 2) {
                            b2.e = Float.isNaN(j0.k) ? (b1.e - b0.e) * f + b0.e : j0.k * Math.min(f2, f1);
                            b2.f = Float.isNaN(j0.l) ? (b1.f - b0.f) * f + b0.f : j0.l;
                        }
                        else {
                            b2.e = (b1.e - b0.e) * (Float.isNaN(j0.k) ? f : j0.k) + b0.e;
                            if(!Float.isNaN(j0.l)) {
                                f = j0.l;
                            }
                            b2.f = (b1.f - b0.f) * f + b0.f;
                        }
                        b2.k = b0.k;
                        b2.a = e.d(j0.f);
                        b2.j = j0.g;
                    }
                    int v4 = Collections.binarySearch(arrayList0, b2);
                    if(v4 == 0) {
                        Log.e("MotionController", " KeyPath position \"" + b2.d + "\" outside of range");
                    }
                    arrayList0.add(-v4 - 1, b2);
                    int v5 = j0.e;
                    if(v5 == -1) {
                        continue;
                    }
                    this.e = v5;
                }
                else if(c0 instanceof g) {
                    c0.d(hashSet2);
                }
                else if(c0 instanceof l) {
                    c0.d(hashSet0);
                }
                else if(c0 instanceof n) {
                    if(arrayList2 == null) {
                        arrayList2 = new ArrayList();
                    }
                    arrayList2.add(((n)c0));
                }
                else {
                    c0.f(hashMap0);
                    c0.d(hashSet1);
                }
            }
            arrayList3 = arrayList2;
        }
        if(arrayList3 != null) {
            this.A = (n[])arrayList3.toArray(new n[0]);
        }
        if(hashSet1.isEmpty()) {
            hashSet4 = hashSet0;
            hashSet5 = hashSet1;
            b4 = b1;
            arrayList5 = arrayList0;
        }
        else {
            this.y = new HashMap();
            Iterator iterator1 = hashSet1.iterator();
            while(iterator1.hasNext()) {
                Object object1 = iterator1.next();
                String s = (String)object1;
                if(s.startsWith("CUSTOM,")) {
                    SparseArray sparseArray0 = new SparseArray();
                    String s1 = s.split(",")[1];
                    for(Object object2: arrayList1) {
                        c c1 = (c)object2;
                        HashMap hashMap1 = c1.d;
                        if(hashMap1 != null) {
                            androidx.constraintlayout.widget.a a0 = (androidx.constraintlayout.widget.a)hashMap1.get(s1);
                            if(a0 != null) {
                                sparseArray0.append(c1.a, a0);
                            }
                        }
                    }
                    hashSet3 = hashSet0;
                    h h0 = new h();  // 初始化器: LI1/k;-><init>()V
                    String s2 = s.split(",")[1];
                    h0.f = sparseArray0;
                    b3 = b1;
                    arrayList4 = arrayList0;
                    iterator3 = iterator1;
                    h1 = h0;
                }
                else {
                    hashSet3 = hashSet0;
                    switch(s.hashCode()) {
                        case -1249320806: {
                            arrayList4 = arrayList0;
                            iterator3 = iterator1;
                            b3 = b1;
                            if(s.equals("rotationX")) {
                                h1 = new I1.g(5);
                                goto label_345;
                            }
                            break;
                        }
                        case -1249320805: {
                            arrayList4 = arrayList0;
                            iterator3 = iterator1;
                            if(s.equals("rotationY")) {
                                b3 = b1;
                                h1 = new I1.g(6);
                                goto label_345;
                            }
                            b3 = b1;
                            break;
                        }
                        case 0xB6F463C7: {
                            arrayList4 = arrayList0;
                            iterator3 = iterator1;
                            if(s.equals("translationX")) {
                                b3 = b1;
                                h1 = new I1.g(9);
                                goto label_345;
                            }
                            b3 = b1;
                            break;
                        }
                        case 0xB6F463C8: {
                            arrayList4 = arrayList0;
                            iterator3 = iterator1;
                            if(s.equals("translationY")) {
                                b3 = b1;
                                h1 = new I1.g(10);
                                goto label_345;
                            }
                            b3 = b1;
                            break;
                        }
                        case 0xB6F463C9: {
                            arrayList4 = arrayList0;
                            iterator3 = iterator1;
                            if(s.equals("translationZ")) {
                                b3 = b1;
                                h1 = new I1.g(11);
                                goto label_345;
                            }
                            b3 = b1;
                            break;
                        }
                        case -1001078227: {
                            arrayList4 = arrayList0;
                            if(s.equals("progress")) {
                                iterator3 = iterator1;
                                b3 = b1;
                                h1 = new I1.j();  // 初始化器: LI1/k;-><init>()V
                                h1.f = false;
                                goto label_345;
                            }
                            iterator3 = iterator1;
                            b3 = b1;
                            break;
                        }
                        case 0xC9DE204E: {
                            if(s.equals("scaleX")) {
                                arrayList4 = arrayList0;
                                iterator3 = iterator1;
                                b3 = b1;
                                h1 = new I1.g(7);
                                goto label_345;
                            }
                            arrayList4 = arrayList0;
                            iterator3 = iterator1;
                            b3 = b1;
                            break;
                        }
                        case 0xC9DE204F: {
                            if(s.equals("scaleY")) {
                                arrayList4 = arrayList0;
                                iterator3 = iterator1;
                                b3 = b1;
                                h1 = new I1.g(8);
                                goto label_345;
                            }
                            arrayList4 = arrayList0;
                            iterator3 = iterator1;
                            b3 = b1;
                            break;
                        }
                        case 0xD076CCE0: {
                            if(s.equals("waveVariesBy")) {
                                arrayList4 = arrayList0;
                                iterator3 = iterator1;
                                b3 = b1;
                                h1 = new I1.g(0);
                                goto label_345;
                            }
                            arrayList4 = arrayList0;
                            iterator3 = iterator1;
                            b3 = b1;
                            break;
                        }
                        case -760884510: {
                            if(s.equals("transformPivotX")) {
                                arrayList4 = arrayList0;
                                iterator3 = iterator1;
                                b3 = b1;
                                h1 = new I1.g(2);
                                goto label_345;
                            }
                            arrayList4 = arrayList0;
                            iterator3 = iterator1;
                            b3 = b1;
                            break;
                        }
                        case -760884509: {
                            if(s.equals("transformPivotY")) {
                                b3 = b1;
                                arrayList4 = arrayList0;
                                iterator3 = iterator1;
                                h1 = new I1.g(3);
                                goto label_345;
                            }
                            arrayList4 = arrayList0;
                            iterator3 = iterator1;
                            b3 = b1;
                            break;
                        }
                        case -40300674: {
                            if(s.equals("rotation")) {
                                b3 = b1;
                                arrayList4 = arrayList0;
                                iterator3 = iterator1;
                                h1 = new I1.g(4);
                                goto label_345;
                            }
                            arrayList4 = arrayList0;
                            iterator3 = iterator1;
                            b3 = b1;
                            break;
                        }
                        case -4379043: {
                            if(s.equals("elevation")) {
                                arrayList4 = arrayList0;
                                iterator3 = iterator1;
                                b3 = b1;
                                h1 = new I1.g(1);
                                goto label_345;
                            }
                            arrayList4 = arrayList0;
                            iterator3 = iterator1;
                            b3 = b1;
                            break;
                        }
                        case 0x2382115: {
                            if(s.equals("transitionPathRotate")) {
                                arrayList4 = arrayList0;
                                iterator3 = iterator1;
                                b3 = b1;
                                h1 = new i();  // 初始化器: LI1/k;-><init>()V
                                goto label_345;
                            }
                            arrayList4 = arrayList0;
                            iterator3 = iterator1;
                            b3 = b1;
                            break;
                        }
                        case 92909918: {
                            if(s.equals("alpha")) {
                                arrayList4 = arrayList0;
                                iterator3 = iterator1;
                                b3 = b1;
                                h1 = new I1.g(0);
                                goto label_345;
                            }
                            arrayList4 = arrayList0;
                            iterator3 = iterator1;
                            b3 = b1;
                            break;
                        }
                        case 156108012: {
                            if(s.equals("waveOffset")) {
                                arrayList4 = arrayList0;
                                iterator3 = iterator1;
                                b3 = b1;
                                h1 = new I1.g(0);
                                goto label_345;
                            }
                            else {
                                arrayList4 = arrayList0;
                                iterator3 = iterator1;
                                b3 = b1;
                            }
                            break;
                        }
                        default: {
                            arrayList4 = arrayList0;
                            iterator3 = iterator1;
                            b3 = b1;
                        }
                    }
                    h1 = null;
                }
            label_345:
                if(h1 != null) {
                    h1.e = s;
                    this.y.put(s, h1);
                }
                b1 = b3;
                hashSet0 = hashSet3;
                iterator1 = iterator3;
                arrayList0 = arrayList4;
            }
            hashSet4 = hashSet0;
            hashSet5 = hashSet1;
            b4 = b1;
            arrayList5 = arrayList0;
            if(arrayList1 != null) {
                for(Object object3: arrayList1) {
                    c c2 = (c)object3;
                    if(c2 instanceof androidx.constraintlayout.motion.widget.e) {
                        c2.a(this.y);
                    }
                }
            }
            o0.a(this.y, 0);
            o1.a(this.y, 100);
            for(Object object4: this.y.keySet()) {
                String s3 = (String)object4;
                if(hashMap0.containsKey(s3)) {
                    Integer integer0 = (Integer)hashMap0.get(s3);
                    if(integer0 != null) {
                        v6 = (int)integer0;
                    }
                }
                else {
                    v6 = 0;
                }
                k k0 = (k)this.y.get(s3);
                if(k0 != null) {
                    k0.d(v6);
                }
            }
        }
        if(!hashSet4.isEmpty()) {
            if(this.x == null) {
                this.x = new HashMap();
            }
            Iterator iterator6 = hashSet4.iterator();
            while(iterator6.hasNext()) {
                Object object5 = iterator6.next();
                String s4 = (String)object5;
                if(!this.x.containsKey(s4)) {
                    if(s4.startsWith("CUSTOM,")) {
                        SparseArray sparseArray1 = new SparseArray();
                        iterator7 = iterator6;
                        String s5 = s4.split(",")[1];
                        for(Object object6: arrayList1) {
                            c c3 = (c)object6;
                            HashMap hashMap2 = c3.d;
                            if(hashMap2 != null) {
                                androidx.constraintlayout.widget.a a1 = (androidx.constraintlayout.widget.a)hashMap2.get(s5);
                                if(a1 != null) {
                                    sparseArray1.append(c3.a, a1);
                                }
                            }
                        }
                        I1.n n0 = new I1.n();  // 初始化器: LI1/q;-><init>()V
                        n0.m = new SparseArray();
                        n0.k = s4.split(",")[1];
                        n0.l = sparseArray1;
                        n1 = n0;
                    }
                    else {
                        iterator7 = iterator6;
                        switch(s4) {
                            case "alpha": {
                                n1 = new m(0);
                                n1.i = v2;
                                break;
                            }
                            case "elevation": {
                                n1 = new m(1);
                                n1.i = v2;
                                break;
                            }
                            case "progress": {
                                n1 = new p();  // 初始化器: LI1/q;-><init>()V
                                n1.k = false;
                                n1.i = v2;
                                break;
                            }
                            case "rotation": {
                                n1 = new m(2);
                                n1.i = v2;
                                break;
                            }
                            case "rotationX": {
                                n1 = new m(3);
                                n1.i = v2;
                                break;
                            }
                            case "rotationY": {
                                n1 = new m(4);
                                n1.i = v2;
                                break;
                            }
                            case "scaleX": {
                                n1 = new m(5);
                                n1.i = v2;
                                break;
                            }
                            case "scaleY": {
                                n1 = new m(6);
                                n1.i = v2;
                                break;
                            }
                            case "transitionPathRotate": {
                                n1 = new I1.o();  // 初始化器: LI1/q;-><init>()V
                                n1.i = v2;
                                break;
                            }
                            case "translationX": {
                                n1 = new m(7);
                                n1.i = v2;
                                break;
                            }
                            case "translationY": {
                                n1 = new m(8);
                                n1.i = v2;
                                break;
                            }
                            case "translationZ": {
                                n1 = new m(9);
                                n1.i = v2;
                                break;
                            }
                            default: {
                                n1 = null;
                            }
                        }
                    }
                    if(n1 != null) {
                        n1.f = s4;
                        this.x.put(s4, n1);
                    }
                    iterator6 = iterator7;
                }
            }
            if(arrayList1 != null) {
                for(Object object7: arrayList1) {
                    c c4 = (c)object7;
                    if(c4 instanceof l) {
                        ((l)c4).h(this.x);
                    }
                }
            }
            for(Object object8: this.x.keySet()) {
                String s6 = (String)object8;
                int v7 = hashMap0.containsKey(s6) ? ((int)(((Integer)hashMap0.get(s6)))) : 0;
                ((I1.q)this.x.get(s6)).e(v7);
            }
        }
        int v8 = arrayList5.size();
        B[] arr_b = new B[v8 + 2];
        arr_b[0] = b0;
        arr_b[v8 + 1] = b4;
        if(arrayList5.size() > 0 && this.e == -1) {
            this.e = 0;
        }
        int v9 = 1;
        for(Object object9: arrayList5) {
            arr_b[v9] = (B)object9;
            ++v9;
        }
        HashSet hashSet6 = new HashSet();
        for(Object object10: b4.n.keySet()) {
            String s7 = (String)object10;
            if(b0.n.containsKey(s7)) {
                hashSet7 = hashSet5;
                if(!hashSet7.contains("CUSTOM," + s7)) {
                    hashSet6.add(s7);
                }
            }
            else {
                hashSet7 = hashSet5;
            }
            hashSet5 = hashSet7;
        }
        String[] arr_s = (String[])hashSet6.toArray(new String[0]);
        this.r = arr_s;
        this.s = new int[arr_s.length];
        for(int v10 = 0; true; ++v10) {
            arr_s1 = this.r;
            if(v10 >= arr_s1.length) {
                break;
            }
            String s8 = arr_s1[v10];
            this.s[v10] = 0;
            for(int v11 = 0; v11 < v8 + 2; ++v11) {
                if(arr_b[v11].n.containsKey(s8)) {
                    androidx.constraintlayout.widget.a a2 = (androidx.constraintlayout.widget.a)arr_b[v11].n.get(s8);
                    if(a2 != null) {
                        int[] arr_v = this.s;
                        int v12 = arr_v[v10];
                        arr_v[v10] = a2.c() + v12;
                        break;
                    }
                }
            }
        }
        int v13 = arr_b[0].j == -1 ? 0 : 1;
        int v14 = arr_s1.length + 18;
        boolean[] arr_z = new boolean[v14];
        for(int v15 = 1; v15 < v8 + 2; ++v15) {
            B b5 = arr_b[v15];
            B b6 = arr_b[v15 - 1];
            boolean z = B.b(b5.e, b6.e);
            boolean z1 = B.b(b5.f, b6.f);
            arr_z[0] |= B.b(b5.d, b6.d);
            int v16 = z | z1 | v13;
            arr_z[1] |= v16;
            arr_z[2] |= v16;
            arr_z[3] |= B.b(b5.g, b6.g);
            arr_z[4] |= B.b(b5.h, b6.h);
        }
        int v17 = 0;
        for(int v18 = 1; v18 < v14; ++v18) {
            if(arr_z[v18]) {
                ++v17;
            }
        }
        this.o = new int[v17];
        int v19 = Math.max(2, v17);
        this.p = new double[v19];
        this.q = new double[v19];
        int v20 = 0;
        for(int v21 = 1; v21 < v14; ++v21) {
            if(arr_z[v21]) {
                this.o[v20] = v21;
                ++v20;
            }
        }
        Class class0 = Double.TYPE;
        double[][] arr2_f = (double[][])Array.newInstance(class0, new int[]{v8 + 2, this.o.length});
        double[] arr_f = new double[v8 + 2];
        for(int v22 = 0; v22 < v8 + 2; ++v22) {
            B b7 = arr_b[v22];
            double[] arr_f1 = arr2_f[v22];
            int[] arr_v1 = this.o;
            float[] arr_f2 = {b7.d, b7.e, b7.f, b7.g, b7.h, b7.i};
            int v24 = 0;
            for(int v23 = 0; v23 < arr_v1.length; ++v23) {
                int v25 = arr_v1[v23];
                if(v25 < 6) {
                    arr_f1[v24] = (double)arr_f2[v25];
                    ++v24;
                }
            }
            arr_f[v22] = (double)arr_b[v22].c;
        }
        for(int v26 = 0; true; ++v26) {
            int[] arr_v2 = this.o;
            if(v26 >= arr_v2.length) {
                break;
            }
            if(arr_v2[v26] < 6) {
                String s9 = x.m(new StringBuilder(), B.B[this.o[v26]], " [");
                for(int v27 = 0; v27 < v8 + 2; ++v27) {
                    StringBuilder stringBuilder0 = Y.p(s9);
                    stringBuilder0.append(arr2_f[v27][v26]);
                    s9 = stringBuilder0.toString();
                }
            }
        }
        this.j = new a[this.r.length + 1];
        for(int v28 = 0; true; ++v28) {
            String[] arr_s2 = this.r;
            if(v28 >= arr_s2.length) {
                break;
            }
            String s10 = arr_s2[v28];
            int v29 = 0;
            int v30 = 0;
            double[] arr_f3 = null;
            Object[] arr_object = null;
            while(v29 < v8 + 2) {
                if(arr_b[v29].n.containsKey(s10)) {
                    if(arr_object == null) {
                        arr_f3 = new double[v8 + 2];
                        androidx.constraintlayout.widget.a a3 = (androidx.constraintlayout.widget.a)arr_b[v29].n.get(s10);
                        arr_object = (double[][])Array.newInstance(class0, new int[]{v8 + 2, (a3 == null ? 0 : a3.c())});
                    }
                    B b8 = arr_b[v29];
                    arr_f3[v30] = (double)b8.c;
                    Object object11 = arr_object[v30];
                    androidx.constraintlayout.widget.a a4 = (androidx.constraintlayout.widget.a)b8.n.get(s10);
                    if(a4 != null) {
                        if(a4.c() == 1) {
                            object11[0] = (double)a4.a();
                        }
                        else {
                            int v31 = a4.c();
                            float[] arr_f4 = new float[v31];
                            a4.b(arr_f4);
                            int v32 = 0;
                            for(int v33 = 0; v32 < v31; ++v33) {
                                object11[v33] = (double)arr_f4[v32];
                                ++v32;
                            }
                        }
                    }
                    v34 = v28;
                    s11 = s10;
                    v35 = v29;
                    ++v30;
                }
                else {
                    v34 = v28;
                    s11 = s10;
                    v35 = v29;
                }
                v29 = v35 + 1;
                s10 = s11;
                v28 = v34;
            }
            double[] arr_f5 = Arrays.copyOf(arr_f3, v30);
            double[][] arr2_f1 = (double[][])Arrays.copyOf(arr_object, v30);
            a[] arr_a = this.j;
            arr_a[v28 + 1] = a.x(this.e, arr_f5, arr2_f1);
        }
        a[] arr_a1 = this.j;
        arr_a1[0] = a.x(this.e, arr_f, arr2_f);
        if(arr_b[0].j != -1) {
            int[] arr_v3 = new int[v8 + 2];
            double[] arr_f6 = new double[v8 + 2];
            double[][] arr2_f2 = (double[][])Array.newInstance(class0, new int[]{v8 + 2, 2});
            for(int v36 = 0; v36 < v8 + 2; ++v36) {
                B b9 = arr_b[v36];
                arr_v3[v36] = b9.j;
                arr_f6[v36] = (double)b9.c;
                double[] arr_f7 = arr2_f2[v36];
                arr_f7[0] = (double)b9.e;
                arr_f7[1] = (double)b9.f;
            }
            this.k = new b(arr_v3, arr_f6, arr2_f2);
        }
        this.z = new HashMap();
        if(arrayList1 != null) {
            float f39 = NaNf;
            for(Object object12: hashSet2) {
                String s12 = (String)object12;
                f f40 = f.c(s12);
                if(f40 != null) {
                    if(f40.e == 1 && Float.isNaN(f39)) {
                        f39 = this.e();
                    }
                    f40.b = s12;
                    this.z.put(s12, f40);
                }
            }
            for(Object object13: arrayList1) {
                c c5 = (c)object13;
                if(c5 instanceof g) {
                    ((g)c5).h(this.z);
                }
            }
            for(Object object14: this.z.values()) {
                ((f)object14).f();
            }
        }
    }

    @Override
    public final String toString() {
        return " start: x: " + this.f.e + " y: " + this.f.f + " end: x: " + this.g.e + " y: " + this.g.f;
    }
}

