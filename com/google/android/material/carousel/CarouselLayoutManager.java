package com.google.android.material.carousel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View.OnLayoutChangeListener;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.D0;
import androidx.recyclerview.widget.I0;
import androidx.recyclerview.widget.K0;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.w0;
import com.iloen.melon.custom.P0;
import d5.v;
import d6.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import k6.b;
import k6.c;
import k6.d;
import k6.e;
import k6.f;
import k6.g;
import k6.h;
import k6.j;
import k6.k;
import k6.l;
import k6.m;
import k6.n;

public class CarouselLayoutManager extends w0 implements I0, b {
    public int a;
    public int b;
    public int c;
    public final e d;
    public final n e;
    public X.b f;
    public l g;
    public int h;
    public HashMap i;
    public h j;
    public final View.OnLayoutChangeListener k;
    public int l;
    public int m;
    public final int n;

    public CarouselLayoutManager() {
        n n0 = new n();
        super();
        this.d = new e();
        this.h = 0;
        this.k = new P0(this, 1);
        this.m = -1;
        this.n = 0;
        this.e = n0;
        this.I();
        this.setOrientation(0);
    }

    @SuppressLint({"UnknownNullness"})
    public CarouselLayoutManager(Context context0, AttributeSet attributeSet0, int v, int v1) {
        this.d = new e();
        this.h = 0;
        this.k = new P0(this, 1);
        this.m = -1;
        this.n = 0;
        this.e = new n();
        this.I();
        if(attributeSet0 != null) {
            TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, a.i);
            this.n = typedArray0.getInt(0, 0);
            this.I();
            this.setOrientation(typedArray0.getInt(0, 0));
            typedArray0.recycle();
        }
    }

    public final int A(int v, l l0) {
        int v1 = 0x7FFFFFFF;
        for(Object object0: l0.b.subList(l0.c, l0.d + 1)) {
            k k0 = (k)object0;
            float f = l0.a / 2.0f + ((float)v) * l0.a;
            int v2 = (this.D() ? ((int)(((float)this.x()) - k0.a - f)) : ((int)(f - k0.a))) - this.a;
            if(Math.abs(v1) > Math.abs(v2)) {
                v1 = v2;
            }
        }
        return v1;
    }

    public static v B(List list0, float f, boolean z) {
        float f1 = 3.402823E+38f;
        int v = -1;
        int v1 = -1;
        int v2 = -1;
        int v3 = -1;
        float f2 = -3.402823E+38f;
        float f3 = 3.402823E+38f;
        float f4 = 3.402823E+38f;
        for(int v4 = 0; v4 < list0.size(); ++v4) {
            k k0 = (k)list0.get(v4);
            float f5 = z ? k0.b : k0.a;
            float f6 = Math.abs(f5 - f);
            if(f5 <= f && f6 <= f1) {
                v = v4;
                f1 = f6;
            }
            if(f5 > f && f6 <= f3) {
                v2 = v4;
                f3 = f6;
            }
            if(f5 <= f4) {
                v1 = v4;
                f4 = f5;
            }
            if(f5 > f2) {
                v3 = v4;
                f2 = f5;
            }
        }
        if(v == -1) {
            v = v1;
        }
        if(v2 == -1) {
            v2 = v3;
        }
        k k1 = (k)list0.get(v);
        k k2 = (k)list0.get(v2);
        v v5 = new v();  // 初始化器: Ljava/lang/Object;-><init>()V
        if(k1.a > k2.a) {
            throw new IllegalArgumentException();
        }
        v5.a = k1;
        v5.b = k2;
        return v5;
    }

    public final boolean C() {
        return this.j.a == 0;
    }

    public final boolean D() {
        return this.C() && this.getLayoutDirection() == 1;
    }

    public final boolean E(float f, v v0) {
        k k0 = (k)v0.a;
        float f1 = e6.a.b(k0.d, ((k)v0.b).d, k0.b, ((k)v0.b).b, f);
        float f2 = this.D() ? f + f1 / 2.0f : f - f1 / 2.0f;
        return this.D() ? f2 < 0.0f : f2 > ((float)this.x());
    }

    public final boolean F(float f, v v0) {
        k k0 = (k)v0.a;
        float f1 = this.r(f, e6.a.b(k0.d, ((k)v0.b).d, k0.b, ((k)v0.b).b, f) / 2.0f);
        return this.D() ? f1 > ((float)this.x()) : f1 < 0.0f;
    }

    public final d G(D0 d00, float f, int v) {
        O0 o00 = d00.k(v, 0x7FFFFFFFFFFFFFFFL);
        this.measureChildWithMargins(o00.itemView, 0, 0);
        float f1 = this.r(f, this.g.a / 2.0f);
        v v1 = CarouselLayoutManager.B(this.g.b, f1, false);
        float f2 = this.u(o00.itemView, f1, v1);
        return new d(o00.itemView, f1, f2, v1);
    }

    public final void H(D0 d00) {
        int v50;
        List list3;
        int v39;
        l l2;
        int v33;
        int v30;
        int v29;
        int v27;
        int v26;
        int v25;
        int v24;
        int v23;
        l l0;
        int[] arr_v4;
        View view0 = d00.k(0, 0x7FFFFFFFFFFFFFFFL).itemView;
        this.measureChildWithMargins(view0, 0, 0);
        n n0 = this.e;
        n0.getClass();
        float f = this.C() ? ((float)this.getWidth()) : ((float)this.getHeight());
        LayoutParams recyclerView$LayoutParams0 = (LayoutParams)view0.getLayoutParams();
        float f1 = (float)(recyclerView$LayoutParams0.topMargin + recyclerView$LayoutParams0.bottomMargin);
        float f2 = (float)view0.getMeasuredHeight();
        if(this.C()) {
            f1 = (float)(recyclerView$LayoutParams0.leftMargin + recyclerView$LayoutParams0.rightMargin);
            f2 = (float)view0.getMeasuredWidth();
        }
        float f3 = n0.a + f1;
        float f4 = Math.max(n0.b + f1, f3);
        float f5 = Math.min(f2 + f1, f);
        float f6 = E9.h.q(f2 / 3.0f + f1, f3 + f1, f4 + f1);
        float f7 = (f5 + f6) / 2.0f;
        int[] arr_v = Float.compare(f, f3 * 2.0f) >= 0 ? n.d : new int[]{0};
        int[] arr_v1 = n.e;
        if(this.n == 1) {
            int v1 = arr_v.length;
            int[] arr_v2 = new int[v1];
            for(int v = 0; v < v1; ++v) {
                arr_v2[v] = arr_v[v] * 2;
            }
            int[] arr_v3 = new int[2];
            for(int v2 = 0; v2 < 2; ++v2) {
                arr_v3[v2] = arr_v1[v2] * 2;
            }
            arr_v4 = arr_v3;
            arr_v = arr_v2;
        }
        else {
            arr_v4 = arr_v1;
        }
        int v4 = 0x80000000;
        for(int v3 = 0; v3 < arr_v4.length; ++v3) {
            int v5 = arr_v4[v3];
            if(v5 > v4) {
                v4 = v5;
            }
        }
        int v6 = 0x80000000;
        for(int v7 = 0; v7 < arr_v.length; ++v7) {
            int v8 = arr_v[v7];
            if(v8 > v6) {
                v6 = v8;
            }
        }
        int v9 = (int)Math.ceil(f / f5);
        int v10 = v9 - ((int)Math.max(1.0, Math.floor((f - ((float)v4) * f7 - ((float)v6) * f4) / f5))) + 1;
        int[] arr_v5 = new int[v10];
        for(int v11 = 0; v11 < v10; ++v11) {
            arr_v5[v11] = v9 - v11;
        }
        k6.a a0 = k6.a.a(f, f6, f3, f4, arr_v, f7, arr_v4, f5, arr_v5);
        int v12 = a0.g;
        n0.c = a0.c + a0.d + v12;
        int v13 = this.getItemCount();
        int v14 = a0.c + a0.d + v12 - v13;
        boolean z = v14 > 0 && (a0.c > 0 || a0.d > 1);
        while(v14 > 0) {
            int v15 = a0.c;
            if(v15 > 0) {
                a0.c = v15 - 1;
            }
            else {
                int v16 = a0.d;
                if(v16 > 1) {
                    a0.d = v16 - 1;
                }
            }
            --v14;
        }
        if(z) {
            a0 = k6.a.a(f, f6, f3, f4, new int[]{a0.c}, f7, new int[]{a0.d}, f5, new int[]{v12});
        }
        Context context0 = view0.getContext();
        if(this.n == 1) {
            float f8 = Math.min(context0.getResources().getDimension(0x7F070197) + f1, a0.f);  // dimen:m3_carousel_gone_size
            float f9 = e1.b.n(0.0f, a0.b, a0.c);
            float f10 = e1.b.M(0.0f, e1.b.m(f9, a0.b, ((int)Math.floor(((float)a0.c) / 2.0f))), a0.b, a0.c);
            float f11 = e1.b.n(f10, a0.e, a0.d);
            float f12 = e1.b.M(f10, e1.b.m(f11, a0.e, ((int)Math.floor(((float)a0.d) / 2.0f))), a0.e, a0.d);
            float f13 = e1.b.n(f12, a0.f, a0.g);
            float f14 = e1.b.M(f12, e1.b.m(f13, a0.f, a0.g), a0.f, a0.g);
            float f15 = e1.b.n(f14, a0.e, a0.d);
            float f16 = e1.b.n(e1.b.M(f14, e1.b.m(f15, a0.e, ((int)Math.ceil(((float)a0.d) / 2.0f))), a0.e, a0.d), a0.b, a0.c);
            float f17 = 1.0f - (f8 - f1) / (a0.f - f1);
            float f18 = 1.0f - (a0.b - f1) / (a0.f - f1);
            float f19 = 1.0f - (a0.e - f1) / (a0.f - f1);
            j j0 = new j(a0.f, f);
            j0.a(0.0f - f8 / 2.0f, f17, f8, false, true);
            int v17 = a0.c;
            if(v17 > 0) {
                j0.c(f9, f18, a0.b, ((int)Math.floor(((float)v17) / 2.0f)), false);
            }
            int v18 = a0.d;
            if(v18 > 0) {
                j0.c(f11, f19, a0.e, ((int)Math.floor(((float)v18) / 2.0f)), false);
            }
            j0.c(f13, 0.0f, a0.f, a0.g, true);
            int v19 = a0.d;
            if(v19 > 0) {
                j0.c(f15, f19, a0.e, ((int)Math.ceil(((float)v19) / 2.0f)), false);
            }
            int v20 = a0.c;
            if(v20 > 0) {
                j0.c(f16, f18, a0.b, ((int)Math.ceil(((float)v20) / 2.0f)), false);
            }
            j0.a(f8 / 2.0f + f, f17, f8, false, true);
            l0 = j0.d();
        }
        else {
            float f20 = Math.min(context0.getResources().getDimension(0x7F070197) + f1, a0.f);  // dimen:m3_carousel_gone_size
            float f21 = e1.b.n(0.0f, a0.f, a0.g);
            float f22 = e1.b.M(0.0f, e1.b.m(f21, a0.f, a0.g), a0.f, a0.g);
            float f23 = e1.b.n(f22, a0.e, a0.d);
            float f24 = e1.b.n(e1.b.M(f22, f23, a0.e, a0.d), a0.b, a0.c);
            float f25 = 1.0f - (f20 - f1) / (a0.f - f1);
            float f26 = 1.0f - (a0.b - f1) / (a0.f - f1);
            float f27 = 1.0f - (a0.e - f1) / (a0.f - f1);
            j j1 = new j(a0.f, f);
            j1.a(0.0f - f20 / 2.0f, f25, f20, false, true);
            j1.c(f21, 0.0f, a0.f, a0.g, true);
            if(a0.d > 0) {
                j1.a(f23, f27, a0.e, false, false);
            }
            int v21 = a0.c;
            if(v21 > 0) {
                j1.c(f24, f26, a0.b, v21, false);
            }
            j1.a(f20 / 2.0f + f, f25, f20, false, true);
            l0 = j1.d();
        }
        if(this.D()) {
            float f28 = (float)this.x();
            j j2 = new j(l0.a, f28);
            k k0 = l0.d();
            k k1 = l0.d();
            float f29 = f28 - k0.b - k1.d / 2.0f;
            List list0 = l0.b;
            for(int v22 = list0.size() - 1; v22 >= 0; --v22) {
                k k2 = (k)list0.get(v22);
                j2.a(k2.d / 2.0f + f29, k2.c, k2.d, v22 >= l0.c && v22 <= l0.d, k2.e);
                f29 += k2.d;
            }
            l0 = j2.d();
        }
        List list1 = l0.b;
        if(this.getChildCount() > 0) {
            LayoutParams recyclerView$LayoutParams1 = (LayoutParams)this.getChildAt(0).getLayoutParams();
            if(this.j.a == 0) {
                v23 = recyclerView$LayoutParams1.leftMargin;
                v24 = recyclerView$LayoutParams1.rightMargin;
            }
            else {
                v23 = recyclerView$LayoutParams1.topMargin;
                v24 = recyclerView$LayoutParams1.bottomMargin;
            }
            v25 = v24 + v23;
        }
        else {
            v25 = 0;
        }
        if(this.getClipToPadding()) {
            v26 = 0;
        }
        else {
            this.e.getClass();
            v26 = this.j.a == 1 ? this.getPaddingTop() : this.getPaddingLeft();
        }
        if(this.getClipToPadding()) {
            v27 = 0;
        }
        else {
            this.e.getClass();
            v27 = this.j.a == 1 ? this.getPaddingBottom() : this.getPaddingRight();
        }
        ArrayList arrayList0 = new ArrayList();
        arrayList0.add(l0);
        int v28;
        for(v28 = 0; true; ++v28) {
            v29 = l0.d;
            v30 = l0.c;
            if(v28 >= list1.size()) {
                v28 = -1;
                break;
            }
            if(!((k)list1.get(v28)).e) {
                break;
            }
        }
        int v31 = this.C() ? this.getWidth() : this.getHeight();
        k k3 = l0.a();
        k k4 = l0.a();
        if(Float.compare(k3.b - k4.d / 2.0f, 0.0f) >= 0) {
            k k5 = l0.a();
            for(int v32 = 0; true; ++v32) {
                k k6 = null;
                if(v32 >= list1.size()) {
                    break;
                }
                k k7 = (k)list1.get(v32);
                if(!k7.e) {
                    k6 = k7;
                    break;
                }
            }
            if(k5 == k6) {
                goto label_199;
            }
            else {
                goto label_198;
            }
        }
        else {
        label_198:
            if(v28 == -1) {
            label_199:
                if(((float)v26) > 0.0f) {
                    arrayList0.add(X.b.g(l0, ((float)v26), ((float)v31), true, ((float)v25)));
                }
                v33 = v30;
            }
            else {
                int v34 = v30 - v28;
                k k8 = l0.b();
                k k9 = l0.b();
                float f30 = k8.b - k9.d / 2.0f;
                if(v34 > 0 || l0.a().f <= 0.0f) {
                    v33 = v30;
                    float f31 = 0.0f;
                    int v35 = 0;
                    while(v35 < v34) {
                        l l1 = (l)com.iloen.melon.utils.a.i(1, arrayList0);
                        int v36 = v28 + v35;
                        int v37 = list1.size() - 1;
                        f31 += ((k)list1.get(v36)).f;
                        int v38 = v36 - 1;
                        if(v38 >= 0) {
                            float f32 = ((k)list1.get(v38)).c;
                            List list2 = l1.b;
                            l2 = l1;
                            v39 = v34;
                            int v40 = l1.d;
                            while(true) {
                                if(v40 < list2.size()) {
                                    if(f32 == ((k)list2.get(v40)).c) {
                                        break;
                                    }
                                    else {
                                        ++v40;
                                        continue;
                                    }
                                }
                                v40 = list2.size() - 1;
                                break;
                            }
                            v37 = v40 - 1;
                        }
                        else {
                            l2 = l1;
                            v39 = v34;
                        }
                        l l3 = X.b.f(l2, v28, v37, f30 + f31, v33 - v35 - 1, v29 - v35 - 1, ((float)v31));
                        if(v35 == v39 - 1 && ((float)v26) > 0.0f) {
                            l3 = X.b.g(l3, ((float)v26), ((float)v31), true, ((float)v25));
                        }
                        arrayList0.add(l3);
                        ++v35;
                        v34 = v39;
                    }
                }
                else {
                    v33 = v30;
                    arrayList0.add(X.b.f(l0, 0, 0, f30 + l0.a().f, l0.c, l0.d, ((float)v31)));
                }
            }
        }
        ArrayList arrayList1 = new ArrayList();
        arrayList1.add(l0);
        int v41;
        for(v41 = list1.size() - 1; true; --v41) {
            if(v41 < 0) {
                v41 = -1;
                break;
            }
            if(!((k)list1.get(v41)).e) {
                break;
            }
        }
        int v42 = this.C() ? this.getWidth() : this.getHeight();
        int v43 = this.C() ? this.getWidth() : this.getHeight();
        k k10 = l0.c();
        if(l0.c().d / 2.0f + k10.b <= ((float)v43)) {
            k k11 = l0.c();
            for(int v44 = list1.size() - 1; true; --v44) {
                k k12 = null;
                if(v44 < 0) {
                    break;
                }
                k k13 = (k)list1.get(v44);
                if(!k13.e) {
                    k12 = k13;
                    break;
                }
            }
            if(k11 == k12) {
                goto label_269;
            }
            else {
                goto label_268;
            }
        }
        else {
        label_268:
            if(v41 == -1) {
            label_269:
                if(((float)v27) > 0.0f) {
                    arrayList1.add(X.b.g(l0, ((float)v27), ((float)v42), false, ((float)v25)));
                }
            }
            else {
                int v45 = v41 - v29;
                k k14 = l0.b();
                k k15 = l0.b();
                float f33 = k14.b - k15.d / 2.0f;
                if(v45 > 0 || l0.c().f <= 0.0f) {
                    float f34 = 0.0f;
                    int v46 = 0;
                    while(v46 < v45) {
                        l l4 = (l)com.iloen.melon.utils.a.i(1, arrayList1);
                        int v47 = v41 - v46;
                        f34 += ((k)list1.get(v47)).f;
                        int v48 = v47 + 1;
                        if(v48 < list1.size()) {
                            float f35 = ((k)list1.get(v48)).c;
                            int v49 = l4.c - 1;
                            while(true) {
                                if(v49 >= 0) {
                                    list3 = list1;
                                    if(f35 == ((k)l4.b.get(v49)).c) {
                                        break;
                                    }
                                    else {
                                        --v49;
                                        list1 = list3;
                                        continue;
                                    }
                                }
                                list3 = list1;
                                v49 = 0;
                                break;
                            }
                            v50 = v49 + 1;
                        }
                        else {
                            list3 = list1;
                            v50 = 0;
                        }
                        l l5 = X.b.f(l4, v41, v50, f33 - f34, v33 + v46 + 1, v29 + v46 + 1, ((float)v42));
                        if(v46 == v45 - 1 && ((float)v27) > 0.0f) {
                            l5 = X.b.g(l5, ((float)v27), ((float)v42), false, ((float)v25));
                        }
                        arrayList1.add(l5);
                        ++v46;
                        list1 = list3;
                    }
                }
                else {
                    arrayList1.add(X.b.f(l0, 0, 0, f33 - l0.c().f, l0.c, l0.d, ((float)v42)));
                }
            }
        }
        this.f = new X.b(l0, arrayList0, arrayList1);
    }

    public final void I() {
        this.f = null;
        this.requestLayout();
    }

    public final int J(int v, D0 d00, K0 k00) {
        if(this.getChildCount() != 0 && v != 0) {
            if(this.f == null) {
                this.H(d00);
            }
            int v1 = this.a;
            int v2 = this.b;
            int v3 = this.c;
            int v4 = v1 + v;
            if(v4 < v2) {
                v = v2 - v1;
            }
            else if(v4 > v3) {
                v = v3 - v1;
            }
            this.a = v1 + v;
            this.L(this.f);
            float f = this.g.a / 2.0f;
            float f1 = this.v(this.getPosition(this.getChildAt(0)));
            Rect rect0 = new Rect();
            float f2 = this.D() ? this.g.c().b : this.g.a().b;
            float f3 = 3.402823E+38f;
            for(int v5 = 0; v5 < this.getChildCount(); ++v5) {
                View view0 = this.getChildAt(v5);
                float f4 = this.r(f1, f);
                v v6 = CarouselLayoutManager.B(this.g.b, f4, false);
                float f5 = this.u(view0, f4, v6);
                super.getDecoratedBoundsWithMargins(view0, rect0);
                this.K(view0, f4, v6);
                this.j.l(view0, rect0, f, f5);
                float f6 = Math.abs(f2 - f5);
                if(f6 < f3) {
                    this.m = this.getPosition(view0);
                    f3 = f6;
                }
                f1 = this.r(f1, this.g.a);
            }
            this.w(d00, k00);
            return v;
        }
        return 0;
    }

    public final void K(View view0, float f, v v0) {
        if(!(view0 instanceof m)) {
            return;
        }
        k k0 = (k)v0.a;
        float f1 = e6.a.b(k0.c, ((k)v0.b).c, k0.a, ((k)v0.b).a, f);
        float f2 = (float)view0.getHeight();
        float f3 = (float)view0.getWidth();
        RectF rectF0 = this.j.c(f2, f3, e6.a.b(0.0f, f2 / 2.0f, 0.0f, 1.0f, f1), e6.a.b(0.0f, f3 / 2.0f, 0.0f, 1.0f, f1));
        float f4 = this.u(view0, f, v0);
        float f5 = rectF0.height();
        float f6 = rectF0.height();
        RectF rectF1 = new RectF(f4 - rectF0.width() / 2.0f, f4 - f5 / 2.0f, rectF0.width() / 2.0f + f4, f6 / 2.0f + f4);
        RectF rectF2 = new RectF(((float)this.j.f()), ((float)this.j.i()), ((float)this.j.g()), ((float)this.j.d()));
        this.e.getClass();
        this.j.a(rectF0, rectF1, rectF2);
        this.j.k(rectF0, rectF1, rectF2);
        ((m)view0).setMaskRectF(rectF0);
    }

    public final void L(X.b b0) {
        int v = this.c;
        int v1 = this.b;
        if(v <= v1) {
            this.g = this.D() ? b0.b() : b0.d();
        }
        else {
            this.g = b0.c(((float)this.a), ((float)v1), ((float)v));
        }
        List list0 = this.g.b;
        this.d.getClass();
        this.d.b = Collections.unmodifiableList(list0);
    }

    public final void M() {
        int v = this.getItemCount();
        int v1 = this.l;
        if(v != v1 && this.f != null) {
            if(v1 < this.e.c && this.getItemCount() >= this.e.c || v1 >= this.e.c && this.getItemCount() < this.e.c) {
                this.I();
            }
            this.l = v;
        }
    }

    @Override  // androidx.recyclerview.widget.w0
    public final boolean canScrollHorizontally() {
        return this.C();
    }

    @Override  // androidx.recyclerview.widget.w0
    public final boolean canScrollVertically() {
        return !this.C();
    }

    @Override  // androidx.recyclerview.widget.w0
    public final int computeHorizontalScrollExtent(K0 k00) {
        return this.getChildCount() == 0 || this.f == null || this.getItemCount() <= 1 ? 0 : ((int)(((float)this.getWidth()) * (((l)this.f.c).a / ((float)this.computeHorizontalScrollRange(k00)))));
    }

    @Override  // androidx.recyclerview.widget.w0
    public final int computeHorizontalScrollOffset(K0 k00) {
        return this.a;
    }

    @Override  // androidx.recyclerview.widget.w0
    public final int computeHorizontalScrollRange(K0 k00) {
        return this.c - this.b;
    }

    @Override  // androidx.recyclerview.widget.I0
    public final PointF computeScrollVectorForPosition(int v) {
        if(this.f == null) {
            return null;
        }
        int v1 = this.z(v, this.y(v)) - this.a;
        return this.C() ? new PointF(((float)v1), 0.0f) : new PointF(0.0f, ((float)v1));
    }

    @Override  // androidx.recyclerview.widget.w0
    public final int computeVerticalScrollExtent(K0 k00) {
        return this.getChildCount() == 0 || this.f == null || this.getItemCount() <= 1 ? 0 : ((int)(((float)this.getHeight()) * (((l)this.f.c).a / ((float)this.computeVerticalScrollRange(k00)))));
    }

    @Override  // androidx.recyclerview.widget.w0
    public final int computeVerticalScrollOffset(K0 k00) {
        return this.a;
    }

    @Override  // androidx.recyclerview.widget.w0
    public final int computeVerticalScrollRange(K0 k00) {
        return this.c - this.b;
    }

    @Override  // androidx.recyclerview.widget.w0
    public final LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override  // androidx.recyclerview.widget.w0
    public final void getDecoratedBoundsWithMargins(View view0, Rect rect0) {
        super.getDecoratedBoundsWithMargins(view0, rect0);
        float f = (float)rect0.centerY();
        if(this.C()) {
            f = (float)rect0.centerX();
        }
        v v0 = CarouselLayoutManager.B(this.g.b, f, true);
        k k0 = (k)v0.a;
        float f1 = e6.a.b(k0.d, ((k)v0.b).d, k0.b, ((k)v0.b).b, f);
        float f2 = 0.0f;
        float f3 = this.C() ? (((float)rect0.width()) - f1) / 2.0f : 0.0f;
        if(!this.C()) {
            f2 = (((float)rect0.height()) - f1) / 2.0f;
        }
        rect0.set(((int)(((float)rect0.left) + f3)), ((int)(((float)rect0.top) + f2)), ((int)(((float)rect0.right) - f3)), ((int)(((float)rect0.bottom) - f2)));
    }

    @Override  // androidx.recyclerview.widget.w0
    public final boolean isAutoMeasureEnabled() {
        return true;
    }

    @Override  // androidx.recyclerview.widget.w0
    public final void measureChildWithMargins(View view0, int v, int v1) {
        if(!(view0 instanceof m)) {
            throw new IllegalStateException("All children of a RecyclerView using CarouselLayoutManager must use MaskableFrameLayout as their root ViewGroup.");
        }
        LayoutParams recyclerView$LayoutParams0 = (LayoutParams)view0.getLayoutParams();
        Rect rect0 = new Rect();
        this.calculateItemDecorationsForChild(view0, rect0);
        int v2 = rect0.left + rect0.right + v;
        int v3 = rect0.top + rect0.bottom + v1;
        X.b b0 = this.f;
        float f = b0 == null || this.j.a != 0 ? ((float)recyclerView$LayoutParams0.width) : ((l)b0.c).a;
        float f1 = b0 == null || this.j.a != 1 ? ((float)recyclerView$LayoutParams0.height) : ((l)b0.c).a;
        int v4 = this.getPaddingLeft();
        int v5 = w0.getChildMeasureSpec(this.getWidth(), this.getWidthMode(), this.getPaddingRight() + v4 + recyclerView$LayoutParams0.leftMargin + recyclerView$LayoutParams0.rightMargin + v2, ((int)f), this.C());
        int v6 = this.getPaddingTop();
        view0.measure(v5, w0.getChildMeasureSpec(this.getHeight(), this.getHeightMode(), this.getPaddingBottom() + v6 + recyclerView$LayoutParams0.topMargin + recyclerView$LayoutParams0.bottomMargin + v3, ((int)f1), this.canScrollVertically()));
    }

    @Override  // androidx.recyclerview.widget.w0
    public final void onAttachedToWindow(RecyclerView recyclerView0) {
        super.onAttachedToWindow(recyclerView0);
        Context context0 = recyclerView0.getContext();
        this.e.a = this.e.a > 0.0f ? this.e.a : context0.getResources().getDimension(0x7F07019A);  // dimen:m3_carousel_small_item_size_min
        this.e.b = this.e.b > 0.0f ? this.e.b : context0.getResources().getDimension(0x7F070199);  // dimen:m3_carousel_small_item_size_max
        this.I();
        recyclerView0.addOnLayoutChangeListener(this.k);
    }

    @Override  // androidx.recyclerview.widget.w0
    public final void onDetachedFromWindow(RecyclerView recyclerView0, D0 d00) {
        recyclerView0.removeOnLayoutChangeListener(this.k);
    }

    @Override  // androidx.recyclerview.widget.w0
    public final View onFocusSearchFailed(View view0, int v, D0 d00, K0 k00) {
        int v2;
        if(this.getChildCount() != 0) {
            int v1 = this.j.a;
            switch(v) {
                case 1: {
                    v2 = -1;
                    break;
                }
                case 2: {
                    v2 = 1;
                    break;
                }
                case 17: {
                    if(v1 != 0) {
                        v2 = 0x80000000;
                    }
                    else if(this.D()) {
                        v2 = 1;
                    }
                    else {
                        v2 = -1;
                    }
                    break;
                }
                case 33: {
                    v2 = v1 == 1 ? -1 : 0x80000000;
                    break;
                }
                case 66: {
                    if(v1 != 0) {
                        v2 = 0x80000000;
                    }
                    else if(!this.D()) {
                        v2 = 1;
                    }
                    else {
                        v2 = -1;
                    }
                    break;
                }
                case 130: {
                    v2 = v1 == 1 ? 1 : 0x80000000;
                    break;
                }
                default: {
                    va.e.f(v, "Unknown focus request:", "CarouselLayoutManager");
                    v2 = 0x80000000;
                }
            }
            int v3 = 0;
            if(v2 != 0x80000000) {
                if(v2 == -1) {
                    if(this.getPosition(view0) != 0) {
                        int v4 = this.getPosition(this.getChildAt(0));
                        if(v4 - 1 >= 0 && v4 - 1 < this.getItemCount()) {
                            d d0 = this.G(d00, this.v(v4 - 1), v4 - 1);
                            this.q(d0.a, 0, d0);
                        }
                        if(this.D()) {
                            v3 = this.getChildCount() - 1;
                        }
                        return this.getChildAt(v3);
                    }
                }
                else if(this.getPosition(view0) != this.getItemCount() - 1) {
                    int v5 = this.getPosition(this.getChildAt(this.getChildCount() - 1));
                    if(v5 + 1 >= 0 && v5 + 1 < this.getItemCount()) {
                        d d1 = this.G(d00, this.v(v5 + 1), v5 + 1);
                        this.q(d1.a, -1, d1);
                    }
                    if(!this.D()) {
                        v3 = this.getChildCount() - 1;
                    }
                    return this.getChildAt(v3);
                }
            }
        }
        return null;
    }

    @Override  // androidx.recyclerview.widget.w0
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent0) {
        super.onInitializeAccessibilityEvent(accessibilityEvent0);
        if(this.getChildCount() > 0) {
            accessibilityEvent0.setFromIndex(this.getPosition(this.getChildAt(0)));
            accessibilityEvent0.setToIndex(this.getPosition(this.getChildAt(this.getChildCount() - 1)));
        }
    }

    @Override  // androidx.recyclerview.widget.w0
    public final void onItemsAdded(RecyclerView recyclerView0, int v, int v1) {
        super.onItemsAdded(recyclerView0, v, v1);
        this.M();
    }

    @Override  // androidx.recyclerview.widget.w0
    public final void onItemsRemoved(RecyclerView recyclerView0, int v, int v1) {
        super.onItemsRemoved(recyclerView0, v, v1);
        this.M();
    }

    @Override  // androidx.recyclerview.widget.w0
    public final void onLayoutChildren(D0 d00, K0 k00) {
        int v17;
        if(k00.b() <= 0 || ((float)this.x()) <= 0.0f) {
            this.removeAndRecycleAllViews(d00);
            this.h = 0;
            return;
        }
        boolean z = this.D();
        boolean z1 = this.f == null;
        if(z1) {
            this.H(d00);
        }
        X.b b0 = this.f;
        boolean z2 = this.D();
        l l0 = z2 ? b0.b() : b0.d();
        float f = (z2 ? l0.c() : l0.a()).a;
        float f1 = l0.a / 2.0f;
        float f2 = this.D() ? f + f1 : f - f1;
        int v = (int)(((float)this.j.h()) - f2);
        X.b b1 = this.f;
        boolean z3 = this.D();
        l l1 = z3 ? b1.d() : b1.b();
        k k0 = z3 ? l1.a() : l1.c();
        float f3 = ((float)(k00.b() - 1)) * l1.a;
        float f4 = (float)this.j.h();
        float f5 = (float)this.j.e();
        int v1 = (int)(f3 * (z3 ? -1.0f : 1.0f) - (k0.a - f4) + (f5 - k0.a) + (z3 ? -k0.g : k0.h));
        int v2 = z3 ? Math.min(0, v1) : Math.max(0, v1);
        this.b = z ? v2 : v;
        if(z) {
            v2 = v;
        }
        this.c = v2;
        if(z1) {
            this.a = v;
            X.b b2 = this.f;
            int v3 = this.getItemCount();
            int v4 = this.b;
            int v5 = this.c;
            boolean z4 = this.D();
            List list0 = (List)b2.d;
            List list1 = (List)b2.e;
            float f6 = ((l)b2.c).a;
            HashMap hashMap0 = new HashMap();
            int v7 = 0;
            for(int v6 = 0; true; ++v6) {
                int v8 = -1;
                if(v6 >= v3) {
                    break;
                }
                int v9 = z4 ? v3 - v6 - 1 : v6;
                if(!z4) {
                    v8 = 1;
                }
                if(((float)v9) * f6 * ((float)v8) > ((float)v5) - b2.b || v6 >= v3 - list1.size()) {
                    hashMap0.put(v9, ((l)list1.get(E9.h.r(v7, 0, list1.size() - 1))));
                    ++v7;
                }
            }
            int v10 = v3 - 1;
            int v11 = 0;
            while(v10 >= 0) {
                int v12 = z4 ? v3 - v10 - 1 : v10;
                if(((float)v12) * f6 * ((float)(z4 ? -1 : 1)) < ((float)v4) + b2.a || v10 < list0.size()) {
                    hashMap0.put(v12, ((l)list0.get(E9.h.r(v11, 0, list0.size() - 1))));
                    ++v11;
                }
                --v10;
            }
            this.i = hashMap0;
            int v13 = this.m;
            if(v13 != -1) {
                this.a = this.z(v13, this.y(v13));
            }
        }
        int v14 = this.a;
        int v15 = this.b;
        int v16 = this.c;
        if(v14 < v15) {
            v17 = v15 - v14;
        }
        else {
            v17 = v14 <= v16 ? 0 : v16 - v14;
        }
        this.a = v17 + v14;
        this.h = E9.h.r(this.h, 0, k00.b());
        this.L(this.f);
        this.detachAndScrapAttachedViews(d00);
        this.w(d00, k00);
        this.l = this.getItemCount();
    }

    @Override  // androidx.recyclerview.widget.w0
    public final void onLayoutCompleted(K0 k00) {
        if(this.getChildCount() == 0) {
            this.h = 0;
            return;
        }
        this.h = this.getPosition(this.getChildAt(0));
    }

    public final void q(View view0, int v, d d0) {
        float f = this.g.a / 2.0f;
        this.addView(view0, v);
        this.j.j(view0, ((int)(d0.c - f)), ((int)(d0.c + f)));
        this.K(view0, d0.b, d0.d);
    }

    // 去混淆评级： 低(20)
    public final float r(float f, float f1) {
        return this.D() ? f - f1 : f + f1;
    }

    @Override  // androidx.recyclerview.widget.w0
    public final boolean requestChildRectangleOnScreen(RecyclerView recyclerView0, View view0, Rect rect0, boolean z, boolean z1) {
        if(this.f != null) {
            int v = this.A(this.getPosition(view0), this.y(this.getPosition(view0)));
            if(v != 0) {
                int v1 = this.a;
                int v2 = this.b;
                int v3 = this.c;
                int v4 = v1 + v;
                if(v4 < v2) {
                    v = v2 - v1;
                }
                else if(v4 > v3) {
                    v = v3 - v1;
                }
                l l0 = this.f.c(((float)(v1 + v)), ((float)v2), ((float)v3));
                int v5 = this.A(this.getPosition(view0), l0);
                if(this.C()) {
                    recyclerView0.scrollBy(v5, 0);
                    return true;
                }
                recyclerView0.scrollBy(0, v5);
                return true;
            }
        }
        return false;
    }

    public final void s(int v, D0 d00, K0 k00) {
        float f = this.v(v);
        while(v < k00.b()) {
            d d0 = this.G(d00, f, v);
            v v1 = d0.d;
            float f1 = d0.c;
            if(this.E(f1, v1)) {
                break;
            }
            f = this.r(f, this.g.a);
            if(!this.F(f1, v1)) {
                this.q(d0.a, -1, d0);
            }
            ++v;
        }
    }

    // 去混淆评级： 低(20)
    @Override  // androidx.recyclerview.widget.w0
    public final int scrollHorizontallyBy(int v, D0 d00, K0 k00) {
        return this.C() ? this.J(v, d00, k00) : 0;
    }

    @Override  // androidx.recyclerview.widget.w0
    public final void scrollToPosition(int v) {
        this.m = v;
        if(this.f == null) {
            return;
        }
        this.a = this.z(v, this.y(v));
        this.h = E9.h.r(v, 0, Math.max(0, this.getItemCount() - 1));
        this.L(this.f);
        this.requestLayout();
    }

    // 去混淆评级： 低(20)
    @Override  // androidx.recyclerview.widget.w0
    public final int scrollVerticallyBy(int v, D0 d00, K0 k00) {
        return this.canScrollVertically() ? this.J(v, d00, k00) : 0;
    }

    public final void setOrientation(int v) {
        g g0;
        if(v != 0 && v != 1) {
            throw new IllegalArgumentException("invalid orientation:" + v);
        }
        this.assertNotInLayoutOrScroll(null);
        if(this.j != null && v == this.j.a) {
            return;
        }
        switch(v) {
            case 0: {
                g0 = new g(this);
                break;
            }
            case 1: {
                g0 = new f(this);
                break;
            }
            default: {
                throw new IllegalArgumentException("invalid orientation");
            }
        }
        this.j = g0;
        this.I();
    }

    @Override  // androidx.recyclerview.widget.w0
    public final void smoothScrollToPosition(RecyclerView recyclerView0, K0 k00, int v) {
        c c0 = new c(this, recyclerView0.getContext());
        c0.setTargetPosition(v);
        this.startSmoothScroll(c0);
    }

    public final void t(int v, D0 d00) {
        float f = this.v(v);
        while(v >= 0) {
            d d0 = this.G(d00, f, v);
            v v1 = d0.d;
            float f1 = d0.c;
            if(this.F(f1, v1)) {
                break;
            }
            float f2 = this.g.a;
            f = this.D() ? f + f2 : f - f2;
            if(!this.E(f1, v1)) {
                this.q(d0.a, 0, d0);
            }
            --v;
        }
    }

    public final float u(View view0, float f, v v0) {
        k k0 = (k)v0.a;
        k k1 = (k)v0.b;
        float f1 = k1.a;
        float f2 = e6.a.b(k0.b, k1.b, k0.a, f1, f);
        if(k1 != this.g.b() && k0 != this.g.d()) {
            return f2;
        }
        LayoutParams recyclerView$LayoutParams0 = (LayoutParams)view0.getLayoutParams();
        float f3 = this.j.b(recyclerView$LayoutParams0);
        return (1.0f - k1.c + f3 / this.g.a) * (f - f1) + f2;
    }

    public final float v(int v) {
        return this.r(((float)(this.j.h() - this.a)), this.g.a * ((float)v));
    }

    public final void w(D0 d00, K0 k00) {
        while(this.getChildCount() > 0) {
            View view0 = this.getChildAt(0);
            Rect rect0 = new Rect();
            super.getDecoratedBoundsWithMargins(view0, rect0);
            int v = this.C() ? rect0.centerX() : rect0.centerY();
            if(!this.F(((float)v), CarouselLayoutManager.B(this.g.b, ((float)v), true))) {
                break;
            }
            this.removeAndRecycleView(view0, d00);
        }
        while(this.getChildCount() - 1 >= 0) {
            View view1 = this.getChildAt(this.getChildCount() - 1);
            Rect rect1 = new Rect();
            super.getDecoratedBoundsWithMargins(view1, rect1);
            int v1 = this.C() ? rect1.centerX() : rect1.centerY();
            if(!this.E(((float)v1), CarouselLayoutManager.B(this.g.b, ((float)v1), true))) {
                break;
            }
            this.removeAndRecycleView(view1, d00);
        }
        if(this.getChildCount() == 0) {
            this.t(this.h - 1, d00);
            this.s(this.h, d00, k00);
            return;
        }
        int v2 = this.getPosition(this.getChildAt(0));
        int v3 = this.getPosition(this.getChildAt(this.getChildCount() - 1));
        this.t(v2 - 1, d00);
        this.s(v3 + 1, d00, k00);
    }

    // 去混淆评级： 低(20)
    public final int x() {
        return this.C() ? this.getWidth() : this.getHeight();
    }

    public final l y(int v) {
        HashMap hashMap0 = this.i;
        if(hashMap0 != null) {
            l l0 = (l)hashMap0.get(E9.h.r(v, 0, Math.max(0, this.getItemCount() - 1)));
            return l0 == null ? ((l)this.f.c) : l0;
        }
        return (l)this.f.c;
    }

    public final int z(int v, l l0) {
        if(this.D()) {
            return (int)(((float)this.x()) - l0.c().a - ((float)v) * l0.a - l0.a / 2.0f);
        }
        k k0 = l0.a();
        return (int)(l0.a / 2.0f + (((float)v) * l0.a - k0.a));
    }
}

