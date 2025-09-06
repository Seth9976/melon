package com.google.android.flexbox;

import P.z;
import android.util.SparseIntArray;
import android.view.View.MeasureSpec;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import b3.Z;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class d {
    public final a a;
    public boolean[] b;
    public int[] c;
    public long[] d;
    public long[] e;

    public d(a a0) {
        this.a = a0;
    }

    public final void a(List list0, b b0, int v, int v1) {
        b0.m = v1;
        this.a.i(b0);
        b0.p = v;
        list0.add(b0);
    }

    public final void b(z z0, int v, int v1, int v2, int v3, int v4, List list0) {
        int v31;
        int v21;
        int v19;
        a a0 = this.a;
        boolean z1 = a0.m();
        int v5 = View.MeasureSpec.getMode(v);
        int v6 = View.MeasureSpec.getSize(v);
        List list1 = list0 == null ? new ArrayList() : list0;
        z0.b = list1;
        int v7 = z1 ? a0.getPaddingStart() : a0.getPaddingTop();
        int v8 = z1 ? a0.getPaddingEnd() : a0.getPaddingBottom();
        int v9 = z1 ? a0.getPaddingTop() : a0.getPaddingStart();
        int v10 = z1 ? a0.getPaddingBottom() : a0.getPaddingEnd();
        b b0 = new b();
        int v11 = v3;
        b0.o = v11;
        int v12 = v7 + v8;
        b0.e = v12;
        int v13 = a0.getFlexItemCount();
        int v14 = v4 == -1 ? 1 : 0;
        int v15 = 0x80000000;
        int v16 = 0;
        int v17 = 0;
        int v18 = 0;
        while(v11 < v13) {
            View view0 = a0.j(v11);
            if(view0 == null) {
                if(v11 == v13 - 1 && b0.a() != 0) {
                    this.a(list1, b0, v11, v17);
                }
                v19 = v14;
            }
            else if(view0.getVisibility() == 8) {
                ++b0.i;
                ++b0.h;
                if(v11 == v13 - 1 && b0.a() != 0) {
                    this.a(list1, b0, v11, v17);
                }
                v19 = v14;
            }
            else {
                FlexItem flexItem0 = (FlexItem)view0.getLayoutParams();
                FlexItem flexItem1 = flexItem0;
                if(flexItem0.o() == 4) {
                    b0.n.add(v11);
                }
                int v20 = z1 ? flexItem1.getWidth() : flexItem1.getHeight();
                if(flexItem1.A() != -1.0f && v5 == 0x40000000) {
                    v20 = Math.round(((float)v6) * flexItem1.A());
                }
                if(z1) {
                    v21 = a0.b(v, flexItem1.P() + v12 + flexItem1.b0(), v20);
                    int v22 = a0.d(v1, v9 + v10 + flexItem1.r() + flexItem1.N() + v17, flexItem1.getHeight());
                    view0.measure(v21, v22);
                    this.v(view0, v11, v21, v22);
                }
                else {
                    int v23 = a0.b(v1, v9 + v10 + flexItem1.P() + flexItem1.b0() + v17, flexItem1.getWidth());
                    v21 = a0.d(v, flexItem1.r() + v12 + flexItem1.N(), v20);
                    view0.measure(v23, v21);
                    this.v(view0, v11, v23, v21);
                }
                a0.e(view0, v11);
                this.c(view0, v11);
                v16 = View.combineMeasuredStates(v16, view0.getMeasuredState());
                int v24 = b0.e;
                int v25 = (z1 ? view0.getMeasuredWidth() : view0.getMeasuredHeight()) + (z1 ? flexItem1.P() : flexItem1.r()) + (z1 ? flexItem1.b0() : flexItem1.N());
                int v26 = list1.size();
                if(a0.getFlexWrap() == 0) {
                    ++b0.h;
                    ++v18;
                    v31 = v15;
                }
                else if(flexItem1.C()) {
                label_70:
                    if(b0.a() > 0) {
                        this.a(list1, b0, (v11 <= 0 ? 0 : v11 - 1), v17);
                        v17 += b0.g;
                    }
                    if(!z1) {
                        if(flexItem1.getWidth() == -1) {
                            int v30 = a0.getPaddingLeft();
                            view0.measure(a0.b(v1, a0.getPaddingRight() + v30 + flexItem1.P() + flexItem1.b0() + v17, flexItem1.getWidth()), v21);
                            this.c(view0, v11);
                        }
                    }
                    else if(flexItem1.getHeight() == -1) {
                        int v29 = a0.getPaddingTop();
                        view0.measure(v21, a0.d(v1, a0.getPaddingBottom() + v29 + flexItem1.r() + flexItem1.N() + v17, flexItem1.getHeight()));
                        this.c(view0, v11);
                    }
                    b0 = new b();
                    b0.h = 1;
                    b0.e = v12;
                    b0.o = v11;
                    v31 = 0x80000000;
                    v18 = 0;
                }
                else if(v5 != 0) {
                    int v27 = a0.getMaxLine();
                    if(v27 == -1 || v27 > v26 + 1) {
                        int v28 = a0.k(view0, v11, v18);
                        if(v28 > 0) {
                            v25 += v28;
                        }
                        if(v6 < v24 + v25) {
                            goto label_70;
                        }
                    }
                }
                int[] arr_v = this.c;
                if(arr_v != null) {
                    arr_v[v11] = list1.size();
                }
                int v32 = b0.e;
                b0.e = (z1 ? view0.getMeasuredWidth() : view0.getMeasuredHeight()) + (z1 ? flexItem1.P() : flexItem1.r()) + (z1 ? flexItem1.b0() : flexItem1.N()) + v32;
                b0.j += flexItem1.s();
                b0.k += flexItem1.p();
                a0.a(view0, v11, v18, b0);
                int v33 = z1 ? view0.getMeasuredHeight() : view0.getMeasuredWidth();
                int v34 = z1 ? flexItem1.r() : flexItem1.P();
                int v35 = z1 ? flexItem1.N() : flexItem1.b0();
                int v36 = Math.max(v31, a0.f(view0) + (v33 + v34 + v35));
                b0.g = Math.max(b0.g, v36);
                if(z1) {
                    b0.l = a0.getFlexWrap() == 2 ? Math.max(b0.l, view0.getMeasuredHeight() - view0.getBaseline() + flexItem1.N()) : Math.max(b0.l, view0.getBaseline() + flexItem1.r());
                }
                if(v11 == v13 - 1 && b0.a() != 0) {
                    this.a(list1, b0, v11, v17);
                    v17 += b0.g;
                }
                if(v4 == -1 || list1.size() <= 0 || ((b)Z.h(1, list1)).p < v4 || v11 < v4 || v14 != 0) {
                    v19 = v14;
                }
                else {
                    v17 = -b0.g;
                    v19 = 1;
                }
                if(v17 > v2 && v19 != 0) {
                    break;
                }
                v15 = v36;
            }
            ++v11;
            v14 = v19;
        }
        z0.a = v16;
    }

    public final void c(View view0, int v) {
        int v4;
        FlexItem flexItem0 = (FlexItem)view0.getLayoutParams();
        int v1 = view0.getMeasuredWidth();
        int v2 = view0.getMeasuredHeight();
        int v3 = 1;
        if(v1 < flexItem0.q()) {
            v1 = flexItem0.q();
            v4 = 1;
        }
        else if(v1 > flexItem0.E()) {
            v1 = flexItem0.E();
            v4 = 1;
        }
        else {
            v4 = 0;
        }
        if(v2 < flexItem0.d0()) {
            v2 = flexItem0.d0();
        }
        else if(v2 > flexItem0.g0()) {
            v2 = flexItem0.g0();
        }
        else {
            v3 = v4;
        }
        if(v3 != 0) {
            int v5 = View.MeasureSpec.makeMeasureSpec(v1, 0x40000000);
            int v6 = View.MeasureSpec.makeMeasureSpec(v2, 0x40000000);
            view0.measure(v5, v6);
            this.v(view0, v, v5, v6);
            this.a.e(view0, v);
        }
    }

    public final void d(int v, List list0) {
        int v1 = this.c[v];
        if(v1 == -1) {
            v1 = 0;
        }
        for(int v2 = list0.size() - 1; v2 >= v1; --v2) {
            list0.remove(v2);
        }
        int[] arr_v = this.c;
        int v3 = arr_v.length - 1;
        if(v > v3) {
            Arrays.fill(arr_v, -1);
        }
        else {
            Arrays.fill(arr_v, v, v3, -1);
        }
        long[] arr_v1 = this.d;
        int v4 = arr_v1.length - 1;
        if(v > v4) {
            Arrays.fill(arr_v1, 0L);
            return;
        }
        Arrays.fill(arr_v1, v, v4, 0L);
    }

    public static ArrayList e(int v, int v1, List list0) {
        ArrayList arrayList0 = new ArrayList();
        b b0 = new b();
        b0.g = (v - v1) / 2;
        int v2 = list0.size();
        for(int v3 = 0; v3 < v2; ++v3) {
            if(v3 == 0) {
                arrayList0.add(b0);
            }
            arrayList0.add(((b)list0.get(v3)));
            if(v3 == list0.size() - 1) {
                arrayList0.add(b0);
            }
        }
        return arrayList0;
    }

    public final ArrayList f(int v) {
        ArrayList arrayList0 = new ArrayList(v);
        for(int v1 = 0; v1 < v; ++v1) {
            FlexItem flexItem0 = (FlexItem)this.a.c(v1).getLayoutParams();
            c c0 = new c();  // 初始化器: Ljava/lang/Object;-><init>()V
            c0.b = flexItem0.getOrder();
            c0.a = v1;
            arrayList0.add(c0);
        }
        return arrayList0;
    }

    public final void g(int v, int v1, int v2) {
        int v5;
        int v4;
        a a0 = this.a;
        int v3 = a0.getFlexDirection();
        switch(v3) {
            case 0: 
            case 1: {
                v4 = View.MeasureSpec.getMode(v1);
                v5 = View.MeasureSpec.getSize(v1);
                break;
            }
            case 2: 
            case 3: {
                v4 = View.MeasureSpec.getMode(v);
                v5 = View.MeasureSpec.getSize(v);
                break;
            }
            default: {
                throw new IllegalArgumentException("Invalid flex direction: " + v3);
            }
        }
        List list0 = a0.getFlexLinesInternal();
        if(v4 == 0x40000000) {
            int v6 = a0.getSumOfCrossSize() + v2;
            int v7 = 0;
            if(list0.size() == 1) {
                ((b)list0.get(0)).g = v5 - v2;
                return;
            }
            if(list0.size() >= 2) {
                switch(a0.getAlignContent()) {
                    case 1: {
                        b b0 = new b();
                        b0.g = v5 - v6;
                        list0.add(0, b0);
                        return;
                    }
                    case 2: {
                        a0.setFlexLines(d.e(v5, v6, list0));
                        return;
                    }
                    case 3: {
                        if(v6 < v5) {
                            float f = ((float)(v5 - v6)) / ((float)(list0.size() - 1));
                            ArrayList arrayList1 = new ArrayList();
                            int v8 = list0.size();
                            float f1 = 0.0f;
                            while(v7 < v8) {
                                arrayList1.add(((b)list0.get(v7)));
                                if(v7 != list0.size() - 1) {
                                    b b2 = new b();
                                    if(v7 == list0.size() - 2) {
                                        b2.g = Math.round(f1 + f);
                                        f1 = 0.0f;
                                    }
                                    else {
                                        b2.g = Math.round(f);
                                    }
                                    int v9 = b2.g;
                                    float f2 = f - ((float)v9) + f1;
                                    if(f2 > 1.0f) {
                                        b2.g = v9 + 1;
                                        --f2;
                                    }
                                    else if(f2 < -1.0f) {
                                        b2.g = v9 - 1;
                                        ++f2;
                                    }
                                    f1 = f2;
                                    arrayList1.add(b2);
                                }
                                ++v7;
                            }
                            a0.setFlexLines(arrayList1);
                            return;
                        }
                        break;
                    }
                    case 4: {
                        if(v6 >= v5) {
                            a0.setFlexLines(d.e(v5, v6, list0));
                            return;
                        }
                        ArrayList arrayList0 = new ArrayList();
                        b b1 = new b();
                        b1.g = (v5 - v6) / (list0.size() * 2);
                        for(Object object0: list0) {
                            arrayList0.add(b1);
                            arrayList0.add(((b)object0));
                            arrayList0.add(b1);
                        }
                        a0.setFlexLines(arrayList0);
                        return;
                    }
                    case 5: {
                        if(v6 < v5) {
                            float f3 = ((float)(v5 - v6)) / ((float)list0.size());
                            int v10 = list0.size();
                            float f4 = 0.0f;
                            while(true) {
                                if(v7 >= v10) {
                                    break;
                                }
                                b b3 = (b)list0.get(v7);
                                float f5 = ((float)b3.g) + f3;
                                if(v7 == list0.size() - 1) {
                                    f5 += f4;
                                    f4 = 0.0f;
                                }
                                int v11 = Math.round(f5);
                                float f6 = f5 - ((float)v11) + f4;
                                if(f6 > 1.0f) {
                                    ++v11;
                                    --f6;
                                }
                                else if(f6 < -1.0f) {
                                    --v11;
                                    ++f6;
                                }
                                f4 = f6;
                                b3.g = v11;
                                ++v7;
                            }
                        }
                        break;
                    }
                }
            }
        }
    }

    public final void h(int v, int v1, int v2) {
        int v11;
        int v10;
        int v9;
        a a0 = this.a;
        int v3 = a0.getFlexItemCount();
        boolean[] arr_z = this.b;
        int v4 = 0;
        if(arr_z == null) {
            if(v3 < 10) {
                v3 = 10;
            }
            this.b = new boolean[v3];
        }
        else if(arr_z.length < v3) {
            int v5 = arr_z.length * 2;
            if(v5 >= v3) {
                v3 = v5;
            }
            this.b = new boolean[v3];
        }
        else {
            Arrays.fill(arr_z, false);
        }
        if(v2 < a0.getFlexItemCount()) {
            int v6 = a0.getFlexDirection();
            int v7 = a0.getFlexDirection();
            if(v7 == 0) {
            label_30:
                int v12 = View.MeasureSpec.getMode(v);
                v9 = View.MeasureSpec.getSize(v);
                if(v12 != 0x40000000) {
                    v9 = a0.getLargestMainSize();
                }
                v10 = a0.getPaddingLeft();
                v11 = a0.getPaddingRight();
            }
            else {
                switch(v7) {
                    case 1: {
                        goto label_30;
                    }
                    case 2: {
                    label_23:
                        int v8 = View.MeasureSpec.getMode(v1);
                        v9 = View.MeasureSpec.getSize(v1);
                        if(v8 != 0x40000000) {
                            v9 = a0.getLargestMainSize();
                        }
                        v10 = a0.getPaddingTop();
                        v11 = a0.getPaddingBottom();
                        break;
                    }
                    default: {
                        if(v7 != 3) {
                            throw new IllegalArgumentException("Invalid flex direction: " + v6);
                        }
                        goto label_23;
                    }
                }
            }
            int v13 = v11 + v10;
            int[] arr_v = this.c;
            if(arr_v != null) {
                v4 = arr_v[v2];
            }
            List list0 = a0.getFlexLinesInternal();
            int v14 = list0.size();
            while(v4 < v14) {
                b b0 = (b)list0.get(v4);
                if(b0.e < v9) {
                    this.l(v, v1, b0, v9, v13, false);
                }
                else {
                    this.q(v, v1, b0, v9, v13, false);
                }
                ++v4;
            }
        }
    }

    public final void i(int v) {
        int[] arr_v = this.c;
        if(arr_v == null) {
            if(v < 10) {
                v = 10;
            }
            this.c = new int[v];
            return;
        }
        if(arr_v.length < v) {
            int v1 = arr_v.length * 2;
            if(v1 >= v) {
                v = v1;
            }
            this.c = Arrays.copyOf(arr_v, v);
        }
    }

    public final void j(int v) {
        long[] arr_v = this.d;
        if(arr_v == null) {
            if(v < 10) {
                v = 10;
            }
            this.d = new long[v];
            return;
        }
        if(arr_v.length < v) {
            int v1 = arr_v.length * 2;
            if(v1 >= v) {
                v = v1;
            }
            this.d = Arrays.copyOf(arr_v, v);
        }
    }

    public final void k(int v) {
        long[] arr_v = this.e;
        if(arr_v == null) {
            if(v < 10) {
                v = 10;
            }
            this.e = new long[v];
            return;
        }
        if(arr_v.length < v) {
            int v1 = arr_v.length * 2;
            if(v1 >= v) {
                v = v1;
            }
            this.e = Arrays.copyOf(arr_v, v);
        }
    }

    public final void l(int v, int v1, b b0, int v2, int v3, boolean z) {
        int v11;
        int v10;
        float f3;
        int v9;
        int v23;
        int v16;
        int v13;
        float f4;
        float f = b0.j;
        if(f > 0.0f) {
            int v4 = b0.e;
            if(v2 >= v4) {
                float f1 = ((float)(v2 - v4)) / f;
                b0.e = v3 + b0.f;
                if(!z) {
                    b0.g = 0x80000000;
                }
                int v5 = 0;
                int v6 = 0;
                int v7 = 0;
                float f2 = 0.0f;
                while(v5 < b0.h) {
                    int v8 = b0.o + v5;
                    a a0 = this.a;
                    View view0 = a0.j(v8);
                    if(view0 != null && view0.getVisibility() != 8) {
                        FlexItem flexItem0 = (FlexItem)view0.getLayoutParams();
                        switch(a0.getFlexDirection()) {
                            case 0: 
                            case 1: {
                                v9 = v4;
                                v10 = v6;
                                int v25 = view0.getMeasuredWidth();
                                long[] arr_v2 = this.e;
                                if(arr_v2 != null) {
                                    v25 = (int)arr_v2[v8];
                                }
                                int v26 = view0.getMeasuredHeight();
                                long[] arr_v3 = this.e;
                                if(arr_v3 != null) {
                                    v26 = (int)(arr_v3[v8] >> 0x20);
                                }
                                if(this.b[v8] || flexItem0.s() <= 0.0f) {
                                    v11 = v5;
                                    f3 = f1;
                                }
                                else {
                                    float f8 = f1 * flexItem0.s() + ((float)v25);
                                    if(v5 == b0.h - 1) {
                                        f8 += f2;
                                        f2 = 0.0f;
                                    }
                                    int v27 = Math.round(f8);
                                    if(v27 > flexItem0.E()) {
                                        v27 = flexItem0.E();
                                        this.b[v8] = true;
                                        b0.j -= flexItem0.s();
                                        v10 = 1;
                                        v11 = v5;
                                        f3 = f1;
                                    }
                                    else {
                                        float f9 = f8 - ((float)v27) + f2;
                                        v11 = v5;
                                        f3 = f1;
                                        double f10 = (double)f9;
                                        if(f10 > 1.0) {
                                            ++v27;
                                            f2 = (float)(f10 - 1.0);
                                        }
                                        else if(f10 < -1.0) {
                                            --v27;
                                            f2 = (float)(f10 + 1.0);
                                        }
                                        else {
                                            f2 = f9;
                                        }
                                    }
                                    int v28 = this.m(v1, flexItem0, b0.m);
                                    int v29 = View.MeasureSpec.makeMeasureSpec(v27, 0x40000000);
                                    view0.measure(v29, v28);
                                    int v30 = view0.getMeasuredWidth();
                                    int v31 = view0.getMeasuredHeight();
                                    this.v(view0, v8, v29, v28);
                                    a0.e(view0, v8);
                                    v25 = v30;
                                    v26 = v31;
                                }
                                int v32 = flexItem0.r();
                                int v33 = flexItem0.N();
                                int v34 = Math.max(v7, a0.f(view0) + (v26 + v32 + v33));
                                int v35 = b0.e;
                                b0.e = v25 + flexItem0.P() + flexItem0.b0() + v35;
                                v23 = v34;
                                break;
                            }
                            default: {
                                int v12 = view0.getMeasuredHeight();
                                long[] arr_v = this.e;
                                if(arr_v == null) {
                                    f4 = f1;
                                    v13 = v6;
                                }
                                else {
                                    f4 = f1;
                                    v13 = v6;
                                    v12 = (int)(arr_v[v8] >> 0x20);
                                }
                                int v14 = view0.getMeasuredWidth();
                                long[] arr_v1 = this.e;
                                if(arr_v1 != null) {
                                    v14 = (int)arr_v1[v8];
                                }
                                if(this.b[v8] || flexItem0.s() <= 0.0f) {
                                    v9 = v4;
                                    v16 = v13;
                                }
                                else {
                                    float f5 = flexItem0.s() * f4 + ((float)v12);
                                    if(v5 == b0.h - 1) {
                                        f5 += f2;
                                        f2 = 0.0f;
                                    }
                                    int v15 = Math.round(f5);
                                    if(v15 > flexItem0.g0()) {
                                        v15 = flexItem0.g0();
                                        this.b[v8] = true;
                                        b0.j -= flexItem0.s();
                                        v16 = 1;
                                        v9 = v4;
                                    }
                                    else {
                                        float f6 = f5 - ((float)v15) + f2;
                                        v9 = v4;
                                        double f7 = (double)f6;
                                        if(f7 > 1.0) {
                                            ++v15;
                                            f2 = (float)(f7 - 1.0);
                                        }
                                        else if(f7 < -1.0) {
                                            --v15;
                                            f2 = (float)(f7 + 1.0);
                                        }
                                        else {
                                            f2 = f6;
                                        }
                                        v16 = v13;
                                    }
                                    int v17 = this.n(v, flexItem0, b0.m);
                                    int v18 = View.MeasureSpec.makeMeasureSpec(v15, 0x40000000);
                                    view0.measure(v17, v18);
                                    int v19 = view0.getMeasuredWidth();
                                    int v20 = view0.getMeasuredHeight();
                                    this.v(view0, v8, v17, v18);
                                    a0.e(view0, v8);
                                    v14 = v19;
                                    v12 = v20;
                                }
                                int v21 = flexItem0.P();
                                int v22 = flexItem0.b0();
                                v23 = Math.max(v7, a0.f(view0) + (v14 + v21 + v22));
                                int v24 = b0.e;
                                b0.e = v12 + flexItem0.r() + flexItem0.N() + v24;
                                f3 = f4;
                                v10 = v16;
                                v11 = v5;
                            }
                        }
                        b0.g = Math.max(b0.g, v23);
                        v7 = v23;
                    }
                    else {
                        v9 = v4;
                        f3 = f1;
                        v10 = v6;
                        v11 = v5;
                    }
                    v5 = v11 + 1;
                    f1 = f3;
                    v4 = v9;
                    v6 = v10;
                }
                if(v6 != 0 && v4 != b0.e) {
                    this.l(v, v1, b0, v2, v3, true);
                }
            }
        }
    }

    public final int m(int v, FlexItem flexItem0, int v1) {
        int v2 = this.a.getPaddingTop();
        int v3 = this.a.getPaddingBottom();
        int v4 = flexItem0.r();
        int v5 = flexItem0.N();
        int v6 = flexItem0.getHeight();
        int v7 = this.a.d(v, v3 + v2 + v4 + v5 + v1, v6);
        int v8 = View.MeasureSpec.getSize(v7);
        if(v8 > flexItem0.g0()) {
            return View.MeasureSpec.makeMeasureSpec(flexItem0.g0(), View.MeasureSpec.getMode(v7));
        }
        return v8 >= flexItem0.d0() ? v7 : View.MeasureSpec.makeMeasureSpec(flexItem0.d0(), View.MeasureSpec.getMode(v7));
    }

    public final int n(int v, FlexItem flexItem0, int v1) {
        int v2 = this.a.getPaddingLeft();
        int v3 = this.a.getPaddingRight();
        int v4 = flexItem0.P();
        int v5 = flexItem0.b0();
        int v6 = flexItem0.getWidth();
        int v7 = this.a.b(v, v3 + v2 + v4 + v5 + v1, v6);
        int v8 = View.MeasureSpec.getSize(v7);
        if(v8 > flexItem0.E()) {
            return View.MeasureSpec.makeMeasureSpec(flexItem0.E(), View.MeasureSpec.getMode(v7));
        }
        return v8 >= flexItem0.q() ? v7 : View.MeasureSpec.makeMeasureSpec(flexItem0.q(), View.MeasureSpec.getMode(v7));
    }

    public final void o(View view0, b b0, int v, int v1, int v2, int v3) {
        FlexItem flexItem0 = (FlexItem)view0.getLayoutParams();
        a a0 = this.a;
        int v4 = a0.getAlignItems();
        if(flexItem0.o() != -1) {
            v4 = flexItem0.o();
        }
        int v5 = b0.g;
        if(v4 != 0) {
            switch(v4) {
                case 1: {
                    if(a0.getFlexWrap() != 2) {
                        view0.layout(v, v1 + v5 - view0.getMeasuredHeight() - flexItem0.N(), v2, v1 + v5 - flexItem0.N());
                        return;
                    }
                    view0.layout(v, view0.getMeasuredHeight() + (v1 - v5) + flexItem0.r(), v2, view0.getMeasuredHeight() + (v3 - v5) + flexItem0.r());
                    return;
                }
                case 2: {
                    int v6 = (v5 - view0.getMeasuredHeight() + flexItem0.r() - flexItem0.N()) / 2;
                    if(a0.getFlexWrap() != 2) {
                        view0.layout(v, v1 + v6, v2, view0.getMeasuredHeight() + (v1 + v6));
                        return;
                    }
                    view0.layout(v, v1 - v6, v2, view0.getMeasuredHeight() + (v1 - v6));
                    return;
                }
                case 3: {
                    if(a0.getFlexWrap() != 2) {
                        int v7 = Math.max(b0.l - view0.getBaseline(), flexItem0.r());
                        view0.layout(v, v1 + v7, v2, v3 + v7);
                        return;
                    }
                    int v8 = b0.l;
                    int v9 = view0.getMeasuredHeight();
                    int v10 = Math.max(view0.getBaseline() + (v8 - v9), flexItem0.N());
                    view0.layout(v, v1 - v10, v2, v3 - v10);
                    return;
                }
                case 4: {
                    break;
                }
                default: {
                    return;
                }
            }
        }
        if(a0.getFlexWrap() != 2) {
            view0.layout(v, v1 + flexItem0.r(), v2, v3 + flexItem0.r());
            return;
        }
        view0.layout(v, v1 - flexItem0.N(), v2, v3 - flexItem0.N());
    }

    public final void p(View view0, b b0, boolean z, int v, int v1, int v2, int v3) {
        FlexItem flexItem0 = (FlexItem)view0.getLayoutParams();
        int v4 = this.a.getAlignItems();
        if(flexItem0.o() != -1) {
            v4 = flexItem0.o();
        }
        int v5 = b0.g;
        switch(v4) {
            case 1: {
                if(!z) {
                    view0.layout(v + v5 - view0.getMeasuredWidth() - flexItem0.b0(), v1, v2 + v5 - view0.getMeasuredWidth() - flexItem0.b0(), v3);
                    return;
                }
                view0.layout(view0.getMeasuredWidth() + (v - v5) + flexItem0.P(), v1, view0.getMeasuredWidth() + (v2 - v5) + flexItem0.P(), v3);
                return;
            }
            case 2: {
                ViewGroup.MarginLayoutParams viewGroup$MarginLayoutParams0 = (ViewGroup.MarginLayoutParams)view0.getLayoutParams();
                int v6 = view0.getMeasuredWidth();
                int v7 = (viewGroup$MarginLayoutParams0.getMarginStart() + (v5 - v6) - viewGroup$MarginLayoutParams0.getMarginEnd()) / 2;
                if(!z) {
                    view0.layout(v + v7, v1, v2 + v7, v3);
                    return;
                }
                view0.layout(v - v7, v1, v2 - v7, v3);
                return;
            }
            case 0: 
            case 3: 
            case 4: {
                if(!z) {
                    view0.layout(v + flexItem0.P(), v1, v2 + flexItem0.P(), v3);
                    return;
                }
                view0.layout(v - flexItem0.b0(), v1, v2 - flexItem0.b0(), v3);
            }
        }
    }

    public final void q(int v, int v1, b b0, int v2, int v3, boolean z) {
        float f3;
        int v18;
        int v11;
        int v23;
        int v4 = b0.e;
        float f = b0.k;
        if(f > 0.0f && v2 <= v4) {
            float f1 = ((float)(v4 - v2)) / f;
            b0.e = v3 + b0.f;
            if(!z) {
                b0.g = 0x80000000;
            }
            int v5 = 0;
            boolean z1 = false;
            int v6 = 0;
            float f2 = 0.0f;
            while(v5 < b0.h) {
                int v7 = b0.o + v5;
                a a0 = this.a;
                View view0 = a0.j(v7);
                if(view0 != null && view0.getVisibility() != 8) {
                    FlexItem flexItem0 = (FlexItem)view0.getLayoutParams();
                    switch(a0.getFlexDirection()) {
                        case 0: 
                        case 1: {
                            f3 = f1;
                            int v20 = view0.getMeasuredWidth();
                            long[] arr_v2 = this.e;
                            if(arr_v2 != null) {
                                v20 = (int)arr_v2[v7];
                            }
                            int v21 = view0.getMeasuredHeight();
                            long[] arr_v3 = this.e;
                            if(arr_v3 != null) {
                                v21 = (int)(arr_v3[v7] >> 0x20);
                            }
                            if(!this.b[v7] && flexItem0.p() > 0.0f) {
                                float f7 = ((float)v20) - f3 * flexItem0.p();
                                if(v5 == b0.h - 1) {
                                    f7 += f2;
                                    f2 = 0.0f;
                                }
                                int v22 = Math.round(f7);
                                if(v22 < flexItem0.q()) {
                                    v23 = flexItem0.q();
                                    this.b[v7] = true;
                                    b0.k -= flexItem0.p();
                                    z1 = true;
                                }
                                else {
                                    float f8 = f7 - ((float)v22) + f2;
                                    double f9 = (double)f8;
                                    if(f9 > 1.0) {
                                        v23 = v22 + 1;
                                        --f8;
                                    }
                                    else if(f9 < -1.0) {
                                        v23 = v22 - 1;
                                        ++f8;
                                    }
                                    else {
                                        v23 = v22;
                                    }
                                    f2 = f8;
                                }
                                int v24 = this.m(v1, flexItem0, b0.m);
                                int v25 = View.MeasureSpec.makeMeasureSpec(v23, 0x40000000);
                                view0.measure(v25, v24);
                                int v26 = view0.getMeasuredWidth();
                                int v27 = view0.getMeasuredHeight();
                                this.v(view0, v7, v25, v24);
                                a0.e(view0, v7);
                                v20 = v26;
                                v21 = v27;
                            }
                            int v28 = flexItem0.r();
                            int v29 = flexItem0.N();
                            int v30 = Math.max(v6, a0.f(view0) + (v21 + v28 + v29));
                            int v31 = b0.e;
                            b0.e = v20 + flexItem0.P() + flexItem0.b0() + v31;
                            v18 = v30;
                            break;
                        }
                        default: {
                            int v8 = view0.getMeasuredHeight();
                            long[] arr_v = this.e;
                            if(arr_v != null) {
                                v8 = (int)(arr_v[v7] >> 0x20);
                            }
                            int v9 = view0.getMeasuredWidth();
                            long[] arr_v1 = this.e;
                            if(arr_v1 != null) {
                                v9 = (int)arr_v1[v7];
                            }
                            if(this.b[v7] || flexItem0.p() <= 0.0f) {
                                f3 = f1;
                            }
                            else {
                                float f4 = ((float)v8) - flexItem0.p() * f1;
                                if(v5 == b0.h - 1) {
                                    f4 += f2;
                                    f2 = 0.0f;
                                }
                                int v10 = Math.round(f4);
                                if(v10 < flexItem0.d0()) {
                                    v11 = flexItem0.d0();
                                    this.b[v7] = true;
                                    b0.k -= flexItem0.p();
                                    z1 = true;
                                    f3 = f1;
                                }
                                else {
                                    float f5 = f4 - ((float)v10) + f2;
                                    f3 = f1;
                                    double f6 = (double)f5;
                                    if(f6 > 1.0) {
                                        v11 = v10 + 1;
                                        --f5;
                                    }
                                    else if(f6 < -1.0) {
                                        v11 = v10 - 1;
                                        ++f5;
                                    }
                                    else {
                                        v11 = v10;
                                    }
                                    f2 = f5;
                                }
                                int v12 = this.n(v, flexItem0, b0.m);
                                int v13 = View.MeasureSpec.makeMeasureSpec(v11, 0x40000000);
                                view0.measure(v12, v13);
                                int v14 = view0.getMeasuredWidth();
                                int v15 = view0.getMeasuredHeight();
                                this.v(view0, v7, v12, v13);
                                a0.e(view0, v7);
                                v9 = v14;
                                v8 = v15;
                            }
                            int v16 = flexItem0.P();
                            int v17 = flexItem0.b0();
                            v18 = Math.max(v6, a0.f(view0) + (v9 + v16 + v17));
                            int v19 = b0.e;
                            b0.e = v8 + flexItem0.r() + flexItem0.N() + v19;
                        }
                    }
                    b0.g = Math.max(b0.g, v18);
                    v6 = v18;
                }
                else {
                    f3 = f1;
                }
                ++v5;
                f1 = f3;
            }
            if(z1 && v4 != b0.e) {
                this.q(v, v1, b0, v2, v3, true);
            }
        }
    }

    public static int[] r(int v, ArrayList arrayList0, SparseIntArray sparseIntArray0) {
        Collections.sort(arrayList0);
        sparseIntArray0.clear();
        int[] arr_v = new int[v];
        int v1 = 0;
        for(Object object0: arrayList0) {
            int v2 = ((c)object0).a;
            arr_v[v1] = v2;
            sparseIntArray0.append(v2, ((c)object0).b);
            ++v1;
        }
        return arr_v;
    }

    public final void s(View view0, int v, int v1) {
        FlexItem flexItem0 = (FlexItem)view0.getLayoutParams();
        int v2 = Math.min(Math.max(v - flexItem0.P() - flexItem0.b0() - this.a.f(view0), flexItem0.q()), flexItem0.E());
        long[] arr_v = this.e;
        int v3 = View.MeasureSpec.makeMeasureSpec((arr_v == null ? view0.getMeasuredHeight() : ((int)(arr_v[v1] >> 0x20))), 0x40000000);
        int v4 = View.MeasureSpec.makeMeasureSpec(v2, 0x40000000);
        view0.measure(v4, v3);
        this.v(view0, v1, v4, v3);
        this.a.e(view0, v1);
    }

    public final void t(View view0, int v, int v1) {
        FlexItem flexItem0 = (FlexItem)view0.getLayoutParams();
        int v2 = Math.min(Math.max(v - flexItem0.r() - flexItem0.N() - this.a.f(view0), flexItem0.d0()), flexItem0.g0());
        long[] arr_v = this.e;
        int v3 = View.MeasureSpec.makeMeasureSpec((arr_v == null ? view0.getMeasuredWidth() : ((int)arr_v[v1])), 0x40000000);
        int v4 = View.MeasureSpec.makeMeasureSpec(v2, 0x40000000);
        view0.measure(v3, v4);
        this.v(view0, v1, v3, v4);
        this.a.e(view0, v1);
    }

    public final void u(int v) {
        a a0 = this.a;
        if(v < a0.getFlexItemCount()) {
            int v1 = a0.getFlexDirection();
            if(a0.getAlignItems() == 4) {
                int v2 = this.c == null ? 0 : this.c[v];
                List list0 = a0.getFlexLinesInternal();
                int v3 = list0.size();
                while(v2 < v3) {
                    b b0 = (b)list0.get(v2);
                    int v4 = b0.h;
                    for(int v5 = 0; v5 < v4; ++v5) {
                        int v6 = b0.o + v5;
                        if(v5 < a0.getFlexItemCount()) {
                            View view0 = a0.j(v6);
                            if(view0 != null && view0.getVisibility() != 8) {
                                switch(((FlexItem)view0.getLayoutParams()).o()) {
                                    case -1: 
                                    case 4: {
                                        switch(v1) {
                                            case 0: 
                                            case 1: {
                                                this.t(view0, b0.g, v6);
                                                break;
                                            }
                                            case 2: 
                                            case 3: {
                                                this.s(view0, b0.g, v6);
                                                break;
                                            }
                                            default: {
                                                throw new IllegalArgumentException("Invalid flex direction: " + v1);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    ++v2;
                }
                return;
            }
            for(Object object0: a0.getFlexLinesInternal()) {
                b b1 = (b)object0;
                for(Object object1: b1.n) {
                    Integer integer0 = (Integer)object1;
                    View view1 = a0.j(((int)integer0));
                    if(v1 != 0 && v1 != 1) {
                        if(v1 != 2 && v1 != 3) {
                            throw new IllegalArgumentException("Invalid flex direction: " + v1);
                        }
                        this.s(view1, b1.g, ((int)integer0));
                    }
                    else {
                        this.t(view1, b1.g, ((int)integer0));
                    }
                }
            }
        }
    }

    public final void v(View view0, int v, int v1, int v2) {
        long[] arr_v = this.d;
        if(arr_v != null) {
            arr_v[v] = ((long)v1) & 0xFFFFFFFFL | ((long)v2) << 0x20;
        }
        long[] arr_v1 = this.e;
        if(arr_v1 != null) {
            arr_v1[v] = ((long)view0.getMeasuredWidth()) & 0xFFFFFFFFL | ((long)view0.getMeasuredHeight()) << 0x20;
        }
    }
}

