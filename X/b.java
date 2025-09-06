package X;

import a1.U;
import a1.t;
import b3.Z;
import com.iloen.melon.utils.a;
import e1.i;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import k6.j;
import k6.k;
import k6.l;
import r1.d;
import r1.m;

public final class b {
    public float a;
    public float b;
    public final Object c;
    public final Object d;
    public final Object e;
    public final Object f;
    public final Object g;
    public static b h;

    public b(l l0, ArrayList arrayList0, ArrayList arrayList1) {
        this.c = l0;
        this.d = Collections.unmodifiableList(arrayList0);
        this.e = Collections.unmodifiableList(arrayList1);
        k k0 = ((l)a.i(1, arrayList0)).b();
        k k1 = l0.b();
        float f = k0.a - k1.a;
        this.a = f;
        k k2 = l0.d();
        k k3 = ((l)a.i(1, arrayList1)).d();
        float f1 = k2.a - k3.a;
        this.b = f1;
        this.f = b.e(f, arrayList0, true);
        this.g = b.e(f1, arrayList1, false);
    }

    public b(m m0, U u0, d d0, i i0) {
        this.c = m0;
        this.d = u0;
        this.f = d0;
        this.g = i0;
        this.e = t.i(u0, m0);
        this.a = NaNf;
        this.b = NaNf;
    }

    public long a(int v, long v1) {
        d d0 = (d)this.f;
        float f = this.b;
        float f1 = this.a;
        int v2 = 0;
        if(Float.isNaN(f) || Float.isNaN(f1)) {
            long v3 = r1.b.b(0, 0, 15);
            float f2 = t.a("HHHHHHHHHH", ((U)this.e), v3, d0, ((i)this.g), 1, 0x60).b();
            long v4 = r1.b.b(0, 0, 15);
            f1 = t.a("HHHHHHHHHH\nHHHHHHHHHH", ((U)this.e), v4, d0, ((i)this.g), 2, 0x60).b() - f2;
            this.b = f2;
            this.a = f1;
            f = f2;
        }
        if(v != 1) {
            int v5 = Math.round(f1 * ((float)(v - 1)) + f);
            if(v5 >= 0) {
                v2 = v5;
            }
            int v6 = r1.a.g(v1);
            return v2 <= v6 ? r1.b.a(r1.a.j(v1), r1.a.h(v1), v2, r1.a.g(v1)) : r1.b.a(r1.a.j(v1), r1.a.h(v1), v6, r1.a.g(v1));
        }
        return r1.b.a(r1.a.j(v1), r1.a.h(v1), r1.a.i(v1), r1.a.g(v1));
    }

    public l b() {
        return (l)Z.h(1, ((List)this.e));
    }

    public l c(float f, float f1, float f2) {
        float[] arr_f1;
        float[] arr_f;
        List list0;
        float f9;
        float f3 = this.a;
        float f4 = f1 + f3;
        float f5 = this.b;
        float f6 = f2 - f5;
        float f7 = this.d().a().g;
        float f8 = this.b().c().h;
        if(f3 == f7) {
            f4 += f7;
        }
        if(f5 == f8) {
            f6 -= f8;
        }
        if(Float.compare(f, f4) < 0) {
            f9 = e6.a.b(1.0f, 0.0f, f1, f4, f);
            list0 = (List)this.d;
            arr_f = (float[])this.f;
        }
        else if(f > f6) {
            f9 = e6.a.b(0.0f, 1.0f, f6, f2, f);
            list0 = (List)this.e;
            arr_f = (float[])this.g;
        }
        else {
            return (l)this.c;
        }
        int v = list0.size();
        float f10 = arr_f[0];
        int v2 = 1;
        while(true) {
            if(v2 >= v) {
                arr_f1 = new float[]{0.0f, 0.0f, 0.0f};
                break;
            }
            float f11 = arr_f[v2];
            if(f9 <= f11) {
                arr_f1 = new float[]{e6.a.b(0.0f, 1.0f, f10, f11, f9), ((float)(v2 - 1)), ((float)v2)};
                break;
            }
            ++v2;
            f10 = f11;
        }
        l l0 = (l)list0.get(((int)arr_f1[1]));
        l l1 = (l)list0.get(((int)arr_f1[2]));
        float f12 = arr_f1[0];
        List list1 = l0.b;
        if(l0.a != l1.a) {
            throw new IllegalArgumentException("Keylines being linearly interpolated must have the same item size.");
        }
        List list2 = l1.b;
        if(list1.size() != list2.size()) {
            throw new IllegalArgumentException("Keylines being linearly interpolated must have the same number of keylines.");
        }
        ArrayList arrayList0 = new ArrayList();
        for(int v1 = 0; v1 < list1.size(); ++v1) {
            k k0 = (k)list1.get(v1);
            k k1 = (k)list2.get(v1);
            arrayList0.add(new k(e6.a.a(k0.a, k1.a, f12), e6.a.a(k0.b, k1.b, f12), e6.a.a(k0.c, k1.c, f12), e6.a.a(k0.d, k1.d, f12), false, 0.0f, 0.0f, 0.0f));
        }
        return new l(l0.a, arrayList0, e6.a.c(l0.c, l1.c, f12), e6.a.c(l0.d, l1.d, f12));
    }

    public l d() {
        return (l)Z.h(1, ((List)this.d));
    }

    public static float[] e(float f, ArrayList arrayList0, boolean z) {
        float f1;
        int v = arrayList0.size();
        float[] arr_f = new float[v];
        for(int v1 = 1; v1 < v; ++v1) {
            l l0 = (l)arrayList0.get(v1 - 1);
            l l1 = (l)arrayList0.get(v1);
            if(z) {
                k k0 = l1.b();
                k k1 = l0.b();
                f1 = k0.a - k1.a;
            }
            else {
                k k2 = l0.d();
                k k3 = l1.d();
                f1 = k2.a - k3.a;
            }
            arr_f[v1] = v1 == v - 1 ? 1.0f : arr_f[v1 - 1] + f1 / f;
        }
        return arr_f;
    }

    public static l f(l l0, int v, int v1, float f, int v2, int v3, float f1) {
        ArrayList arrayList0 = new ArrayList(l0.b);
        arrayList0.add(v1, ((k)arrayList0.remove(v)));
        j j0 = new j(l0.a, f1);
        float f2 = f;
        for(int v4 = 0; v4 < arrayList0.size(); ++v4) {
            Object object0 = arrayList0.get(v4);
            float f3 = ((k)object0).d;
            j0.b(f3 / 2.0f + f2, ((k)object0).c, f3, v4 >= v2 && v4 <= v3, ((k)object0).e, ((k)object0).f, 0.0f, 0.0f);
            f2 += ((k)object0).d;
        }
        return j0.d();
    }

    public static l g(l l0, float f, float f1, boolean z, float f2) {
        int v3;
        List list0 = l0.b;
        ArrayList arrayList0 = new ArrayList(list0);
        float f3 = l0.a;
        j j0 = new j(f3, f1);
        int v = 0;
        for(Object object0: list0) {
            if(((k)object0).e) {
                ++v;
            }
        }
        int v1 = list0.size();
        float f4 = z ? f : 0.0f;
        for(int v2 = 0; v2 < arrayList0.size(); v2 = v3 + 1) {
            k k0 = (k)arrayList0.get(v2);
            if(k0.e) {
                v3 = v2;
                j0.b(k0.b, k0.c, k0.d, false, true, k0.f, 0.0f, 0.0f);
            }
            else {
                v3 = v2;
                boolean z1 = v3 >= l0.c && v3 <= l0.d;
                float f5 = k0.d - f / ((float)(v1 - v));
                float f6 = f5 / 2.0f + f4;
                float f7 = f6 - k0.b;
                float f8 = k0.f;
                float f9 = f7;
                if(!z) {
                    f7 = 0.0f;
                }
                if(z) {
                    f9 = 0.0f;
                }
                j0.b(f6, 1.0f - (f5 - f2) / (f3 - f2), f5, z1, false, f8, f7, f9);
                f4 += f5;
            }
        }
        return j0.d();
    }
}

