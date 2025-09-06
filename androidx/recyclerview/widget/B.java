package androidx.recyclerview.widget;

import Q1.c;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.widget.TextView;
import b2.e;
import e1.n;
import e3.p;
import f3.k;
import f3.l;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;
import z6.i;
import z6.o;

public final class b {
    public int a;
    public final Object b;
    public final Object c;
    public final Object d;
    public final Object e;
    public Object f;

    public b(ColorStateList colorStateList0, ColorStateList colorStateList1, ColorStateList colorStateList2, int v, o o0, Rect rect0) {
        c.m(rect0.left);
        c.m(rect0.top);
        c.m(rect0.right);
        c.m(rect0.bottom);
        this.b = rect0;
        this.c = colorStateList1;
        this.d = colorStateList0;
        this.e = colorStateList2;
        this.a = v;
        this.f = o0;
    }

    public b(h0 h00) {
        this.b = new e(30, 0);
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.a = 0;
        this.e = h00;
        this.f = new androidx.recyclerview.widget.c(this);
    }

    public b(l l0) {
        this.b = l0;
        this.c = new ArrayDeque();
        this.d = new ArrayDeque();
        this.e = new PriorityQueue();
        this.a = -1;
    }

    public void a(long v, p p0) {
        ArrayDeque arrayDeque0 = (ArrayDeque)this.d;
        PriorityQueue priorityQueue0 = (PriorityQueue)this.e;
        switch(this.a) {
            case -1: {
            label_4:
                ArrayDeque arrayDeque1 = (ArrayDeque)this.c;
                p p1 = arrayDeque1.isEmpty() ? new p() : ((p)arrayDeque1.pop());
                p1.D(p0.a());
                boolean z = false;
                System.arraycopy(p0.a, p0.b, p1.a, 0, p1.a());
                k k0 = (k)this.f;
                if(k0 != null && v == k0.b) {
                    k0.a.add(p1);
                    return;
                }
                k k1 = arrayDeque0.isEmpty() ? new k() : ((k)arrayDeque0.pop());
                ArrayList arrayList0 = k1.a;
                if(v != 0x8000000000000001L) {
                    z = true;
                }
                e3.b.c(z);
                e3.b.j(arrayList0.isEmpty());
                k1.b = v;
                arrayList0.add(p1);
                priorityQueue0.add(k1);
                this.f = k1;
                int v1 = this.a;
                if(v1 != -1) {
                    this.i(v1);
                }
                return;
            }
            case 0: {
                break;
            }
            default: {
                if(priorityQueue0.size() < this.a || v >= ((k)priorityQueue0.peek()).b) {
                    goto label_4;
                }
            }
        }
        ((l)this.b).c(v, p0);
    }

    public boolean b(int v) {
        ArrayList arrayList0 = (ArrayList)this.d;
        int v1 = arrayList0.size();
        for(int v2 = 0; v2 < v1; ++v2) {
            a a0 = (a)arrayList0.get(v2);
            int v3 = a0.a;
            if(v3 == 8) {
                if(this.h(a0.d, v2 + 1) == v) {
                    return true;
                }
            }
            else if(v3 == 1) {
                int v4 = a0.b;
                int v5 = a0.d + v4;
                while(v4 < v5) {
                    if(this.h(v4, v2 + 1) == v) {
                        return true;
                    }
                    ++v4;
                }
            }
        }
        return false;
    }

    public void c() {
        ArrayList arrayList0 = (ArrayList)this.d;
        int v = arrayList0.size();
        for(int v1 = 0; v1 < v; ++v1) {
            a a0 = (a)arrayList0.get(v1);
            ((h0)this.e).d(a0);
        }
        this.n(arrayList0);
        this.a = 0;
    }

    public void d() {
        h0 h00 = (h0)this.e;
        this.c();
        ArrayList arrayList0 = (ArrayList)this.c;
        int v = arrayList0.size();
        for(int v1 = 0; v1 < v; ++v1) {
            a a0 = (a)arrayList0.get(v1);
            switch(a0.a) {
                case 1: {
                    h00.d(a0);
                    h00.g(a0.b, a0.d);
                    break;
                }
                case 2: {
                    h00.d(a0);
                    int v2 = a0.d;
                    h00.a.N(a0.b, v2, true);
                    h00.a.G0 = true;
                    h00.a.D0.c += v2;
                    break;
                }
                case 4: {
                    h00.d(a0);
                    h00.f(a0.b, a0.d, a0.c);
                    break;
                }
                case 8: {
                    h00.d(a0);
                    h00.h(a0.b, a0.d);
                }
            }
        }
        this.n(arrayList0);
        this.a = 0;
    }

    public static b e(Context context0, int v) {
        c.l(v != 0, "Cannot create a CalendarItemStyle with a styleResId of 0");
        TypedArray typedArray0 = context0.obtainStyledAttributes(v, d6.a.D);
        Rect rect0 = new Rect(typedArray0.getDimensionPixelOffset(0, 0), typedArray0.getDimensionPixelOffset(2, 0), typedArray0.getDimensionPixelOffset(1, 0), typedArray0.getDimensionPixelOffset(3, 0));
        ColorStateList colorStateList0 = n.r(context0, typedArray0, 4);
        ColorStateList colorStateList1 = n.r(context0, typedArray0, 9);
        ColorStateList colorStateList2 = n.r(context0, typedArray0, 7);
        int v1 = typedArray0.getDimensionPixelSize(8, 0);
        o o0 = o.a(context0, typedArray0.getResourceId(5, 0), typedArray0.getResourceId(6, 0)).a();
        typedArray0.recycle();
        return new b(colorStateList0, colorStateList1, colorStateList2, v1, o0, rect0);
    }

    public void f(a a0) {
        int v3;
        int v = a0.a;
        if(v == 1 || v == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int v1 = this.p(a0.b, v);
        int v2 = a0.b;
        switch(a0.a) {
            case 2: {
                v3 = 0;
                break;
            }
            case 4: {
                v3 = 1;
                break;
            }
            default: {
                throw new IllegalArgumentException("op should be remove or update." + a0);
            }
        }
        int v5 = 1;
        for(int v4 = 1; v4 < a0.d; ++v4) {
            int v6 = this.p(v3 * v4 + a0.b, a0.a);
            int v7 = a0.a;
            switch(v7) {
                case 2: {
                    if(v6 == v1) {
                        ++v5;
                        continue;
                    }
                    break;
                }
                case 4: {
                    if(v6 == v1 + 1) {
                        ++v5;
                        continue;
                    }
                }
            }
            a a1 = this.k(v7, v1, v5, a0.c);
            this.g(a1, v2);
            a1.c = null;
            ((e)this.b).release(a1);
            if(a0.a == 4) {
                v2 += v5;
            }
            v5 = 1;
            v1 = v6;
        }
        Object object0 = a0.c;
        a0.c = null;
        ((e)this.b).release(a0);
        if(v5 > 0) {
            a a2 = this.k(a0.a, v1, v5, object0);
            this.g(a2, v2);
            a2.c = null;
            ((e)this.b).release(a2);
        }
    }

    public void g(a a0, int v) {
        h0 h00 = (h0)this.e;
        h00.d(a0);
        switch(a0.a) {
            case 2: {
                int v1 = a0.d;
                h00.a.N(v, v1, true);
                h00.a.G0 = true;
                h00.a.D0.c += v1;
                return;
            }
            case 4: {
                h00.f(v, a0.d, a0.c);
                return;
            }
            default: {
                throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
            }
        }
    }

    public int h(int v, int v1) {
        ArrayList arrayList0 = (ArrayList)this.d;
        int v2 = arrayList0.size();
        while(v1 < v2) {
            a a0 = (a)arrayList0.get(v1);
            int v3 = a0.a;
            if(v3 == 8) {
                int v4 = a0.b;
                if(v4 == v) {
                    v = a0.d;
                }
                else {
                    if(v4 < v) {
                        --v;
                    }
                    if(a0.d <= v) {
                        ++v;
                    }
                }
            }
            else {
                int v5 = a0.b;
                if(v5 <= v) {
                    switch(v3) {
                        case 1: {
                            v += a0.d;
                            break;
                        }
                        case 2: {
                            int v6 = a0.d;
                            if(v < v5 + v6) {
                                return -1;
                            }
                            v -= v6;
                        }
                    }
                }
            }
            ++v1;
        }
        return v;
    }

    public void i(int v) {
        ArrayList arrayList0;
        PriorityQueue priorityQueue0 = (PriorityQueue)this.e;
        while(priorityQueue0.size() > v) {
            k k0 = (k)priorityQueue0.poll();
            for(int v1 = 0; true; ++v1) {
                arrayList0 = k0.a;
                if(v1 >= arrayList0.size()) {
                    break;
                }
                long v2 = k0.b;
                p p0 = (p)arrayList0.get(v1);
                ((l)this.b).c(v2, p0);
                p p1 = (p)arrayList0.get(v1);
                ((ArrayDeque)this.c).push(p1);
            }
            arrayList0.clear();
            k k1 = (k)this.f;
            if(k1 != null && k1.b == k0.b) {
                this.f = null;
            }
            ((ArrayDeque)this.d).push(k0);
        }
    }

    public boolean j() {
        return ((ArrayList)this.c).size() > 0;
    }

    public a k(int v, int v1, int v2, Object object0) {
        a a0 = (a)((e)this.b).acquire();
        if(a0 == null) {
            a a1 = new a();  // 初始化器: Ljava/lang/Object;-><init>()V
            a1.a = v;
            a1.b = v1;
            a1.d = v2;
            a1.c = object0;
            return a1;
        }
        a0.a = v;
        a0.b = v1;
        a0.d = v2;
        a0.c = object0;
        return a0;
    }

    public void l(a a0) {
        h0 h00 = (h0)this.e;
        ((ArrayList)this.d).add(a0);
        switch(a0.a) {
            case 1: {
                h00.g(a0.b, a0.d);
                return;
            }
            case 2: {
                h00.a.N(a0.b, a0.d, false);
                h00.a.G0 = true;
                return;
            }
            case 4: {
                h00.f(a0.b, a0.d, a0.c);
                return;
            }
            case 8: {
                h00.h(a0.b, a0.d);
                return;
            }
            default: {
                throw new IllegalArgumentException("Unknown update op type for " + a0);
            }
        }
    }

    // This method was un-flattened
    public void m() {
        a a5;
        a a4;
        a a3;
        boolean z2;
        boolean z1;
        h0 h00 = (h0)this.e;
        androidx.recyclerview.widget.c c0 = (androidx.recyclerview.widget.c)this.f;
        ArrayList arrayList0 = (ArrayList)this.c;
        c0.getClass();
        while(true) {
            int v = arrayList0.size() - 1;
            boolean z = false;
            while(true) {
                if(v < 0) {
                    v = -1;
                    break;
                }
                if(((a)arrayList0.get(v)).a != 8) {
                    z = true;
                }
                else if(z) {
                    break;
                }
                --v;
            }
            if(v == -1) {
                break;
            }
            b b0 = (b)c0.a;
            a a0 = (a)arrayList0.get(v);
            a a1 = (a)arrayList0.get(v + 1);
            switch(a1.a) {
                case 1: {
                    int v1 = a0.d;
                    int v2 = a1.b;
                    int v3 = v1 >= v2 ? 0 : -1;
                    int v4 = a0.b;
                    if(v4 < v2) {
                        ++v3;
                    }
                    if(v2 <= v4) {
                        a0.b = v4 + a1.d;
                    }
                    int v5 = a1.b;
                    if(v5 <= v1) {
                        a0.d = v1 + a1.d;
                    }
                    a1.b = v5 + v3;
                    arrayList0.set(v, a1);
                    arrayList0.set(v + 1, a0);
                    break;
                }
                case 2: {
                    int v6 = a0.b;
                    int v7 = a0.d;
                    if(v6 < v7) {
                        z1 = a1.b == v6 && a1.d == v7 - v6;
                        z2 = false;
                    }
                    else if(a1.b != v7 + 1 || a1.d != v6 - v7) {
                        z2 = true;
                        z1 = false;
                    }
                    else {
                        z1 = true;
                        z2 = true;
                    }
                    int v8 = a1.b;
                    if(v7 < v8) {
                        a1.b = v8 - 1;
                    }
                    else {
                        int v9 = a1.d;
                        if(v7 < v8 + v9) {
                            a1.d = v9 - 1;
                            a0.a = 2;
                            a0.d = 1;
                            if(a1.d != 0) {
                                break;
                            }
                            arrayList0.remove(v + 1);
                            a1.c = null;
                            ((e)b0.b).release(a1);
                            break;
                        }
                    }
                    int v10 = a0.b;
                    int v11 = a1.b;
                    if(v10 <= v11) {
                        a1.b = v11 + 1;
                    }
                    else {
                        int v12 = v11 + a1.d;
                        if(v10 < v12) {
                            a a2 = b0.k(2, v10 + 1, v12 - v10, null);
                            a1.d = a0.b - a1.b;
                            a3 = a2;
                            goto label_74;
                        }
                    }
                    a3 = null;
                label_74:
                    if(z1) {
                        arrayList0.set(v, a1);
                        arrayList0.remove(v + 1);
                        a0.c = null;
                        ((e)b0.b).release(a0);
                    }
                    else {
                        if(z2) {
                            if(a3 != null) {
                                int v13 = a0.b;
                                if(v13 > a3.b) {
                                    a0.b = v13 - a3.d;
                                }
                                int v14 = a0.d;
                                if(v14 > a3.b) {
                                    a0.d = v14 - a3.d;
                                }
                            }
                            int v15 = a0.b;
                            if(v15 > a1.b) {
                                a0.b = v15 - a1.d;
                            }
                            int v16 = a0.d;
                            if(v16 > a1.b) {
                                a0.d = v16 - a1.d;
                            }
                        }
                        else {
                            if(a3 != null) {
                                int v17 = a0.b;
                                if(v17 >= a3.b) {
                                    a0.b = v17 - a3.d;
                                }
                                int v18 = a0.d;
                                if(v18 >= a3.b) {
                                    a0.d = v18 - a3.d;
                                }
                            }
                            int v19 = a0.b;
                            if(v19 >= a1.b) {
                                a0.b = v19 - a1.d;
                            }
                            int v20 = a0.d;
                            if(v20 >= a1.b) {
                                a0.d = v20 - a1.d;
                            }
                        }
                        arrayList0.set(v, a1);
                        if(a0.b == a0.d) {
                            arrayList0.remove(v + 1);
                        }
                        else {
                            arrayList0.set(v + 1, a0);
                        }
                        if(a3 == null) {
                            break;
                        }
                        arrayList0.add(v, a3);
                    }
                    break;
                }
                case 4: {
                    int v21 = a0.d;
                    int v22 = a1.b;
                    if(v21 < v22) {
                        a1.b = v22 - 1;
                    }
                    else {
                        int v23 = a1.d;
                        if(v21 < v22 + v23) {
                            a1.d = v23 - 1;
                            a4 = b0.k(4, a0.b, 1, a1.c);
                            goto label_127;
                        }
                    }
                    a4 = null;
                label_127:
                    int v24 = a0.b;
                    int v25 = a1.b;
                    if(v24 <= v25) {
                        a1.b = v25 + 1;
                    }
                    else {
                        int v26 = v25 + a1.d;
                        if(v24 < v26) {
                            int v27 = v26 - v24;
                            a5 = b0.k(4, v24 + 1, v27, a1.c);
                            a1.d -= v27;
                            goto label_139;
                        }
                    }
                    a5 = null;
                label_139:
                    arrayList0.set(v + 1, a0);
                    if(a1.d > 0) {
                        arrayList0.set(v, a1);
                    }
                    else {
                        arrayList0.remove(v);
                        a1.c = null;
                        ((e)b0.b).release(a1);
                    }
                    if(a4 != null) {
                        arrayList0.add(v, a4);
                    }
                    if(a5 == null) {
                        break;
                    }
                    arrayList0.add(v, a5);
                }
            }
        }
        int v28 = arrayList0.size();
        int v29 = 0;
        while(v29 < v28) {
            a a6 = (a)arrayList0.get(v29);
            int v30 = a6.a;
            if(v30 == 1) {
                this.l(a6);
            }
            else {
                switch(v30) {
                    case 2: {
                        int v31 = a6.b;
                        int v32 = a6.d + v31;
                        int v33 = v31;
                        int v34 = -1;
                        int v35 = 0;
                        while(v33 < v32) {
                            if(h00.e(v33) != null || this.b(v33)) {
                            label_172:
                                if(v34 == 0) {
                                    this.f(this.k(2, v31, v35, null));
                                    v34 = 1;
                                    v33 -= v35;
                                    v32 -= v35;
                                    v35 = 1;
                                    goto label_181;
                                }
                                else {
                                    v34 = 1;
                                }
                            }
                            else {
                                if(v34 == 1) {
                                    this.l(this.k(2, v31, v35, null));
                                    v34 = 0;
                                    v33 -= v35;
                                    v32 -= v35;
                                    v35 = 1;
                                    goto label_181;
                                }
                                else {
                                    v34 = 0;
                                    goto label_180;
                                }
                                goto label_172;
                            }
                        label_180:
                            ++v35;
                        label_181:
                            ++v33;
                        }
                        if(v35 != a6.d) {
                            a6.c = null;
                            ((e)this.b).release(a6);
                            a6 = this.k(2, v31, v35, null);
                        }
                        if(v34 == 0) {
                            this.f(a6);
                        }
                        else {
                            this.l(a6);
                        }
                        break;
                    }
                    case 4: {
                        int v36 = a6.b;
                        int v37 = a6.d + v36;
                        int v38 = v36;
                        int v39 = -1;
                        int v40 = 0;
                        while(v36 < v37) {
                            if(h00.e(v36) != null || this.b(v36)) {
                                if(v39 == 0) {
                                    this.f(this.k(4, v38, v40, a6.c));
                                    v38 = v36;
                                    v40 = 0;
                                }
                                v39 = 1;
                            }
                            else {
                                if(v39 == 1) {
                                    this.l(this.k(4, v38, v40, a6.c));
                                    v38 = v36;
                                    v40 = 0;
                                }
                                v39 = 0;
                            }
                            ++v40;
                            ++v36;
                        }
                        if(v40 != a6.d) {
                            Object object0 = a6.c;
                            a6.c = null;
                            ((e)this.b).release(a6);
                            a6 = this.k(4, v38, v40, object0);
                        }
                        if(v39 == 0) {
                            this.f(a6);
                        }
                        else {
                            this.l(a6);
                        }
                        break;
                    }
                    case 8: {
                        this.l(a6);
                    }
                }
            }
            ++v29;
        }
        arrayList0.clear();
    }

    public void n(ArrayList arrayList0) {
        int v = arrayList0.size();
        for(int v1 = 0; v1 < v; ++v1) {
            a a0 = (a)arrayList0.get(v1);
            a0.c = null;
            ((e)this.b).release(a0);
        }
        arrayList0.clear();
    }

    public void o(TextView textView0) {
        i i0 = new i();
        i i1 = new i();
        o o0 = (o)this.f;
        i0.setShapeAppearanceModel(o0);
        i1.setShapeAppearanceModel(o0);
        i0.m(((ColorStateList)this.d));
        i0.s(((float)this.a));
        i0.r(((ColorStateList)this.e));
        textView0.setTextColor(((ColorStateList)this.c));
        textView0.setBackground(new InsetDrawable(new RippleDrawable(((ColorStateList)this.c).withAlpha(30), i0, i1), ((Rect)this.b).left, ((Rect)this.b).top, ((Rect)this.b).right, ((Rect)this.b).bottom));
    }

    public int p(int v, int v1) {
        int v7;
        int v6;
        ArrayList arrayList0 = (ArrayList)this.d;
        for(int v2 = arrayList0.size() - 1; v2 >= 0; --v2) {
            a a0 = (a)arrayList0.get(v2);
            int v3 = a0.a;
            if(v3 == 8) {
                int v4 = a0.b;
                int v5 = a0.d;
                if(v4 < v5) {
                    v6 = v4;
                    v7 = v5;
                }
                else {
                    v7 = v4;
                    v6 = v5;
                }
                if(v < v6 || v > v7) {
                    if(v < v4) {
                        if(v1 == 1) {
                            a0.b = v4 + 1;
                            a0.d = v5 + 1;
                        }
                        else if(v1 == 2) {
                            a0.b = v4 - 1;
                            a0.d = v5 - 1;
                        }
                    }
                }
                else if(v6 == v4) {
                    if(v1 == 1) {
                        a0.d = v5 + 1;
                    }
                    else if(v1 == 2) {
                        a0.d = v5 - 1;
                    }
                    ++v;
                }
                else {
                    if(v1 == 1) {
                        a0.b = v4 + 1;
                    }
                    else if(v1 == 2) {
                        a0.b = v4 - 1;
                    }
                    --v;
                }
            }
            else {
                int v8 = a0.b;
                if(v8 > v) {
                    if(v1 == 1) {
                        a0.b = v8 + 1;
                    }
                    else if(v1 == 2) {
                        a0.b = v8 - 1;
                    }
                }
                else if(v3 == 1) {
                    v -= a0.d;
                }
                else if(v3 == 2) {
                    v += a0.d;
                }
            }
        }
        for(int v9 = arrayList0.size() - 1; v9 >= 0; --v9) {
            a a1 = (a)arrayList0.get(v9);
            if(a1.a != 8) {
                if(a1.d <= 0) {
                    arrayList0.remove(v9);
                    a1.c = null;
                    ((e)this.b).release(a1);
                }
            }
            else if(a1.d == a1.b || a1.d < 0) {
                arrayList0.remove(v9);
                a1.c = null;
                ((e)this.b).release(a1);
            }
        }
        return v;
    }
}

