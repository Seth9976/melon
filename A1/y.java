package a1;

import A0.e;
import H8.i;
import android.graphics.Matrix;
import android.graphics.Shader;
import android.text.Layout;
import android.text.TextUtils.TruncateAt;
import e.k;
import i1.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import je.p;
import je.u;
import kotlin.jvm.internal.E;
import kotlin.jvm.internal.F;
import l1.l;
import r1.a;
import r1.b;
import y0.O;
import y0.P;
import y0.o;
import y0.q;

public final class y {
    public final i a;
    public final int b;
    public final boolean c;
    public final float d;
    public final float e;
    public final int f;
    public final ArrayList g;
    public final ArrayList h;

    public y(i i0, long v, int v1, int v2) {
        int v12;
        int v9;
        int v7;
        this.a = i0;
        this.b = v1;
        if(a.j(v) != 0 || a.i(v) != 0) {
            g1.a.a("Setting Constraints.minWidth and Constraints.minHeight is not supported, these should be the default zero values instead.");
        }
        boolean z = false;
        ArrayList arrayList0 = new ArrayList();
        ArrayList arrayList1 = (ArrayList)i0.f;
        int v3 = arrayList1.size();
        float f = 0.0f;
        int v4 = 0;
        int v5 = 0;
        while(v4 < v3) {
            B b0 = (B)arrayList1.get(v4);
            c c0 = b0.a;
            int v6 = a.h(v);
            if(a.c(v)) {
                v7 = v4;
                int v8 = a.g(v) - ((int)(((float)Math.ceil(f))));
                v9 = v8 >= 0 ? v8 : 0;
            }
            else {
                v7 = v4;
                v9 = a.g(v);
            }
            long v10 = b.b(v6, v9, 5);
            a1.a a0 = new a1.a(c0, this.b - v5, v2, v10);
            float f1 = a0.b();
            int v11 = v5 + a0.d.g;
            float f2 = f1 + f;
            arrayList0.add(new A(a0, b0.b, b0.c, v5, v11, f, f2));
            if(a0.d.d) {
                z = true;
                v5 = v11;
                f = f2;
                break;
            }
            if(v11 == this.b) {
                v12 = v7;
                if(v12 != k.s(((ArrayList)this.a.f))) {
                    z = true;
                    v5 = v11;
                    f = f2;
                    break;
                }
            }
            else {
                v12 = v7;
            }
            v4 = v12 + 1;
            v5 = v11;
            f = f2;
        }
        this.e = f;
        this.f = v5;
        this.c = z;
        this.h = arrayList0;
        this.d = (float)a.h(v);
        ArrayList arrayList2 = new ArrayList(arrayList0.size());
        int v13 = arrayList0.size();
        for(int v14 = 0; v14 < v13; ++v14) {
            A a1 = (A)arrayList0.get(v14);
            Object object0 = a1.a.f;
            ArrayList arrayList3 = new ArrayList(((List)object0).size());
            int v15 = ((Collection)object0).size();
            for(int v16 = 0; v16 < v15; ++v16) {
                x0.c c1 = (x0.c)((List)object0).get(v16);
                arrayList3.add((c1 == null ? null : a1.a(c1)));
            }
            u.U(arrayList2, arrayList3);
        }
        if(arrayList2.size() < ((List)this.a.c).size()) {
            int v17 = ((List)this.a.c).size() - arrayList2.size();
            ArrayList arrayList4 = new ArrayList(v17);
            for(int v18 = 0; v18 < v17; ++v18) {
                arrayList4.add(null);
            }
            arrayList2 = p.A0(arrayList2, arrayList4);
        }
        this.g = arrayList2;
    }

    public final void a(long v, float[] arr_f) {
        this.k(T.e(v));
        this.l(T.d(v));
        F f0 = new F();  // 初始化器: Ljava/lang/Object;-><init>()V
        f0.a = 0;
        x x0 = new x(v, arr_f, f0, new E());  // 初始化器: Ljava/lang/Object;-><init>()V
        t.g(this.h, v, x0);
    }

    public final float b(int v) {
        this.m(v);
        int v1 = t.e(v, this.h);
        A a0 = (A)this.h.get(v1);
        return a0.a.d.e(v - a0.d) + a0.f;
    }

    public final int c(int v, boolean z) {
        this.m(v);
        int v1 = t.e(v, this.h);
        A a0 = (A)this.h.get(v1);
        int v2 = v - a0.d;
        b1.i i0 = a0.a.d;
        if(z) {
            Layout layout0 = i0.f;
            if(layout0.getEllipsisCount(v2) > 0 && i0.b == TextUtils.TruncateAt.END) {
                int v3 = layout0.getLineStart(v2);
                return layout0.getEllipsisStart(v2) + v3 + a0.b;
            }
            i i1 = i0.c();
            Layout layout1 = (Layout)i1.b;
            return i1.w(layout1.getLineEnd(v2), layout1.getLineStart(v2)) + a0.b;
        }
        return i0.f(v2) + a0.b;
    }

    public final int d(int v) {
        int v1;
        ArrayList arrayList0 = this.h;
        if(v >= ((g)this.a.b).b.length()) {
            v1 = k.s(arrayList0);
        }
        else {
            v1 = v >= 0 ? t.d(v, arrayList0) : 0;
        }
        A a0 = (A)arrayList0.get(v1);
        int v2 = a0.d(v);
        return a0.a.d.f.getLineForOffset(v2) + a0.d;
    }

    public final int e(float f) {
        int v = t.f(this.h, f);
        A a0 = (A)this.h.get(v);
        return a0.c - a0.b == 0 ? a0.d : a0.a.d.f.getLineForVertical(((int)(f - a0.f)) - a0.a.d.h) + a0.d;
    }

    public final float f(int v) {
        this.m(v);
        int v1 = t.e(v, this.h);
        A a0 = (A)this.h.get(v1);
        return a0.a.d.g(v - a0.d) + a0.f;
    }

    public final int g(long v) {
        int v1 = t.f(this.h, Float.intBitsToFloat(((int)(v & 0xFFFFFFFFL))));
        A a0 = (A)this.h.get(v1);
        int v2 = a0.b;
        if(a0.c - v2 == 0) {
            return v2;
        }
        long v3 = ((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(v & 0xFFFFFFFFL))) - a0.f)) & 0xFFFFFFFFL | ((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(v >> 0x20))))) << 0x20;
        int v4 = a0.a.d.f.getLineForVertical(((int)Float.intBitsToFloat(((int)(0xFFFFFFFFL & v3)))) - a0.a.d.h);
        float f = a0.a.d.b(v4);
        return a0.a.d.f.getOffsetForHorizontal(v4, f * -1.0f + Float.intBitsToFloat(((int)(v3 >> 0x20)))) + v2;
    }

    public final long h(x0.c c0, int v, T7.b b0) {
        long v5;
        long v4;
        ArrayList arrayList0 = this.h;
        int v1 = t.f(arrayList0, c0.b);
        float f = ((A)arrayList0.get(v1)).g;
        float f1 = c0.d;
        if(Float.compare(f, f1) < 0 && v1 != k.s(arrayList0)) {
            int v2 = t.f(arrayList0, f1);
            long v3 = T.b;
            while(true) {
                v4 = T.b;
                if(!T.a(v3, v4) || v1 > v2) {
                    break;
                }
                A a0 = (A)arrayList0.get(v1);
                x0.c c1 = a0.c(c0);
                v3 = a0.b(a0.a.c(c1, v, b0), true);
                ++v1;
            }
            if(T.a(v3, v4)) {
                return v4;
            }
            while(true) {
                v5 = T.b;
                if(!T.a(v4, v5) || v1 > v2) {
                    break;
                }
                A a1 = (A)arrayList0.get(v2);
                x0.c c2 = a1.c(c0);
                v4 = a1.b(a1.a.c(c2, v, b0), true);
                --v2;
            }
            return T.a(v4, v5) ? v3 : t.b(((int)(v3 >> 0x20)), ((int)(0xFFFFFFFFL & v4)));
        }
        A a2 = (A)arrayList0.get(v1);
        x0.c c3 = a2.c(c0);
        return a2.b(a2.a.c(c3, v, b0), true);
    }

    public static void i(y y0, q q0, long v, P p0, l l0, e e0) {
        q0.q();
        ArrayList arrayList0 = y0.h;
        int v1 = arrayList0.size();
        for(int v2 = 0; v2 < v1; ++v2) {
            A a0 = (A)arrayList0.get(v2);
            a0.a.f(q0, v, p0, l0, e0);
            q0.i(0.0f, a0.a.b());
        }
        q0.j();
    }

    public static void j(y y0, q q0, o o0, float f, P p0, l l0, e e0) {
        q0.q();
        ArrayList arrayList0 = y0.h;
        if(arrayList0.size() <= 1) {
            i1.i.a(y0, q0, o0, f, p0, l0, e0);
        }
        else if(o0 instanceof y0.T) {
            i1.i.a(y0, q0, o0, f, p0, l0, e0);
        }
        else if(o0 instanceof O) {
            int v = arrayList0.size();
            float f1 = 0.0f;
            float f2 = 0.0f;
            for(int v2 = 0; v2 < v; ++v2) {
                A a0 = (A)arrayList0.get(v2);
                f2 += a0.a.b();
                f1 = Math.max(f1, a0.a.d());
            }
            Shader shader0 = ((O)o0).b(((long)Float.floatToRawIntBits(f1)) << 0x20 | ((long)Float.floatToRawIntBits(f2)) & 0xFFFFFFFFL);
            Matrix matrix0 = new Matrix();
            shader0.getLocalMatrix(matrix0);
            int v3 = arrayList0.size();
            for(int v1 = 0; v1 < v3; ++v1) {
                a1.a a1 = ((A)arrayList0.get(v1)).a;
                a1.g(q0, new y0.p(shader0), f, p0, l0, e0);
                q0.i(0.0f, a1.b());
                matrix0.setTranslate(0.0f, -a1.b());
                shader0.setLocalMatrix(matrix0);
            }
        }
        q0.j();
    }

    public final void k(int v) {
        i i0 = this.a;
        if(v < 0 || v >= ((g)i0.b).b.length()) {
            StringBuilder stringBuilder0 = U4.x.n(v, "offset(", ") is out of bounds [0, ");
            stringBuilder0.append(((g)i0.b).b.length());
            stringBuilder0.append(')');
            g1.a.a(stringBuilder0.toString());
        }
    }

    public final void l(int v) {
        i i0 = this.a;
        if(v < 0 || v > ((g)i0.b).b.length()) {
            StringBuilder stringBuilder0 = U4.x.n(v, "offset(", ") is out of bounds [0, ");
            stringBuilder0.append(((g)i0.b).b.length());
            stringBuilder0.append(']');
            g1.a.a(stringBuilder0.toString());
        }
    }

    public final void m(int v) {
        int v1 = this.f;
        if(v < 0 || v >= v1) {
            g1.a.a(("lineIndex(" + v + ") is out of bounds [0, " + v1 + ')'));
        }
    }
}

