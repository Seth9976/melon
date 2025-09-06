package x1;

import C1.g;
import C1.h;
import F1.b;
import F1.d;
import F1.e;
import F1.f;
import F1.j;
import F1.m;
import G1.c;
import N0.L;
import N0.Z;
import N0.a0;
import android.util.Log;
import androidx.collection.k;
import androidx.compose.foundation.w;
import androidx.media3.session.legacy.V;
import e1.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import r1.a;

public final class q implements c {
    public final f a;
    public Map b;
    public final LinkedHashMap c;
    public final LinkedHashMap d;
    public final s e;
    public final int[] f;
    public final int[] g;

    public q(r1.c c0) {
        f f0 = new f(0, 0);  // 初始化器: LF1/e;-><init>(II)V
        f0.v0 = new ArrayList();
        f0.w0 = new V(f0);
        f0.x0 = new G1.f(f0);
        f0.z0 = null;
        f0.A0 = false;
        f0.B0 = new y1.c();
        f0.E0 = 0;
        f0.F0 = 0;
        f0.G0 = new b[4];
        f0.H0 = new b[4];
        f0.I0 = 0x101;
        f0.J0 = false;
        f0.K0 = false;
        f0.L0 = null;
        f0.M0 = null;
        f0.N0 = null;
        f0.O0 = null;
        f0.P0 = new HashSet();
        f0.Q0 = new G1.b();  // 初始化器: Ljava/lang/Object;-><init>()V
        f0.z0 = this;
        f0.x0.g = this;
        this.a = f0;
        this.b = new LinkedHashMap();
        this.c = new LinkedHashMap();
        this.d = new LinkedHashMap();
        this.e = new s(c0);
        this.f = new int[2];
        this.g = new int[2];
    }

    @Override  // G1.c
    public final void a() {
    }

    @Override  // G1.c
    public final void b(e e0, G1.b b0) {
        int v8;
        int v7;
        int v6;
        String s = e0.k;
        LinkedHashMap linkedHashMap0 = this.c;
        Integer[] arr_integer = (Integer[])linkedHashMap0.get(s);
        int v = a.h(this.e.l);
        s s1 = this.e;
        q.d(b0.a, b0.c, e0.s, b0.j, (arr_integer == null ? 0 : ((int)arr_integer[1])) == e0.m(), e0.C(), v, this.f);
        int v1 = a.g(s1.l);
        q.d(b0.b, b0.d, e0.t, b0.j, (arr_integer == null ? 0 : ((int)arr_integer[0])) == e0.s(), e0.D(), v1, this.g);
        long v2 = r1.b.a(this.f[0], this.f[1], this.g[0], this.g[1]);
        if(b0.j == 1 || b0.j == 2 || (b0.a != d.c || e0.s != 0 || b0.b != d.c || e0.t != 0)) {
            long v3 = this.c(e0, v2);
            e0.g = false;
            int v4 = ((Number)P4.a.l(((int)(v3 >> 0x20)), (e0.v > 0 ? e0.v : null), (e0.w <= 0 ? null : e0.w))).intValue();
            int v5 = ((Number)P4.a.l(((int)(v3 & 0xFFFFFFFFL)), (e0.y > 0 ? e0.y : null), (e0.z <= 0 ? null : e0.z))).intValue();
            if(v4 == ((int)(v3 >> 0x20))) {
                v6 = 0;
            }
            else {
                v2 = r1.b.a(v4, v4, a.i(v2), a.g(v2));
                v6 = 1;
            }
            if(v5 == ((int)(v3 & 0xFFFFFFFFL))) {
                v7 = v6;
            }
            else {
                v2 = r1.b.a(a.j(v2), a.h(v2), v5, v5);
                v7 = 1;
            }
            if(v7 != 0) {
                this.c(e0, v2);
                e0.g = false;
            }
        }
        a0 a00 = (a0)this.b.get(e0.i0);
        b0.e = a00 == null ? e0.s() : a00.a;
        b0.f = a00 == null ? e0.m() : a00.b;
        if(a00 == null) {
            v8 = 0x80000000;
        }
        else {
            ArrayList arrayList0 = s1.i;
            if(s1.j) {
                arrayList0.clear();
                for(Object object0: s1.h) {
                    e e1 = ((h)s1.c.get(object0)).a();
                    if(e1 != null) {
                        arrayList0.add(e1);
                    }
                }
                s1.j = false;
            }
            v8 = arrayList0.contains(e0) ? a00.n0(N0.c.a) : 0x80000000;
        }
        b0.h = v8 != 0x80000000;
        b0.g = v8;
        Integer[] arr_integer1 = linkedHashMap0.get(s);
        if(arr_integer1 == null) {
            arr_integer1 = new Integer[]{0, 0, 0x80000000};
            linkedHashMap0.put(s, arr_integer1);
        }
        arr_integer1[0] = b0.e;
        arr_integer1[1] = b0.f;
        arr_integer1[2] = b0.g;
        b0.i = b0.e != b0.c || b0.f != b0.d;
    }

    public final long c(e e0, long v) {
        int v2;
        Object object0 = e0.i0;
        String s = e0.k;
        int v1 = 0;
        if(e0 instanceof m) {
            if(a.f(v)) {
                v2 = 0x40000000;
            }
            else {
                v2 = a.d(v) ? 0x80000000 : 0;
            }
            if(a.e(v)) {
                v1 = 0x40000000;
            }
            else if(a.c(v)) {
                v1 = 0x80000000;
            }
            ((m)e0).Z(v2, a.h(v), v1, a.g(v));
            return k.a(((m)e0).E0, ((m)e0).F0);
        }
        if(object0 instanceof L) {
            a0 a00 = ((L)object0).O(v);
            this.b.put(object0, a00);
            return ((long)a00.b) & 0xFFFFFFFFL | ((long)a00.a) << 0x20;
        }
        Log.w("CCL", "Nothing to measure for widget: " + s);
        return 0L;
    }

    public static void d(d d0, int v, int v1, int v2, boolean z, boolean z1, int v3, int[] arr_v) {
        switch(d0.ordinal()) {
            case 0: {
                arr_v[0] = v;
                arr_v[1] = v;
                return;
            }
            case 1: {
                arr_v[0] = 0;
                arr_v[1] = v3;
                return;
            }
            case 2: {
                boolean z2 = z1 || (v2 == 1 || v2 == 2) && (v2 == 2 || v1 != 1 || z);
                arr_v[0] = z2 ? v : 0;
                if(!z2) {
                    v = v3;
                }
                arr_v[1] = v;
                return;
            }
            case 3: {
                arr_v[0] = v3;
                arr_v[1] = v3;
                return;
            }
            default: {
                throw new IllegalStateException((d0 + " is not supported").toString());
            }
        }
    }

    public final void e(Z z0, List list0, Map map0) {
        String s3;
        String s1;
        this.b = map0;
        LinkedHashMap linkedHashMap0 = this.d;
        if(linkedHashMap0.isEmpty()) {
            ArrayList arrayList0 = this.a.v0;
            int v1 = arrayList0.size();
            for(int v2 = 0; v2 < v1; ++v2) {
                e e0 = (e)arrayList0.get(v2);
                Object object0 = e0.i0;
                if(object0 instanceof L) {
                    C1.k k0 = e0.j;
                    e e1 = k0.a;
                    if(e1 != null) {
                        k0.b = e1.t();
                        k0.c = e1.u();
                        e1.t();
                        e1.u();
                        k0.a(e1.j);
                    }
                    C1.k k1 = new C1.k(k0);
                    Object object1 = androidx.compose.ui.layout.a.a(((L)object0));
                    if(object1 == null) {
                        ((L)object0).q();
                        object1 = null;
                    }
                    if(object1 == null) {
                        s1 = "null";
                    }
                    else {
                        String s = object1.toString();
                        if(s != null) {
                            s1 = s;
                        }
                    }
                    linkedHashMap0.put(s1, k1);
                }
            }
        }
        int v3 = list0.size();
        for(int v = 0; v < v3; ++v) {
            L l0 = (L)list0.get(v);
            Object object2 = androidx.compose.ui.layout.a.a(l0);
            if(object2 == null) {
                l0.q();
                object2 = null;
            }
            if(object2 == null) {
                s3 = "null";
            }
            else {
                String s2 = object2.toString();
                if(s2 != null) {
                    s3 = s2;
                }
            }
            C1.k k2 = (C1.k)linkedHashMap0.get(s3);
            if(k2 != null) {
                a0 a00 = (a0)this.b.get(l0);
                if(a00 != null && k2.o != 8) {
                    if(!Float.isNaN(k2.f) || !Float.isNaN(k2.g) || !Float.isNaN(k2.h) || !Float.isNaN(k2.i) || !Float.isNaN(k2.j) || !Float.isNaN(k2.k) || !Float.isNaN(k2.l) || !Float.isNaN(k2.m) || !Float.isNaN(k2.n)) {
                        w w0 = new w(k2, 26);
                        z0.j(a00, k2.b, k2.c, (Float.isNaN(k2.k) ? 0.0f : k2.k), w0);
                    }
                    else {
                        Z.f(z0, a00, ((long)k2.c) & 0xFFFFFFFFL | ((long)k2.b) << 0x20);
                    }
                }
            }
        }
    }

    public final long f(long v, r1.m m0, x1.k k0, List list0, LinkedHashMap linkedHashMap0, int v1) {
        C1.f f1;
        C1.f f0;
        this.b = linkedHashMap0;
        if(list0.isEmpty()) {
            return ((long)a.i(v)) & 0xFFFFFFFFL | ((long)a.j(v)) << 0x20;
        }
        if(a.f(v)) {
            f0 = C1.f.b(a.h(v));
        }
        else {
            f0 = new C1.f("WRAP_DIMENSION");
            int v2 = a.j(v);
            if(v2 >= 0) {
                f0.a = v2;
            }
        }
        s s0 = this.e;
        C1.b b0 = s0.f;
        s0.f.d0 = f0;
        if(a.e(v)) {
            f1 = C1.f.b(a.g(v));
        }
        else {
            f1 = new C1.f("WRAP_DIMENSION");
            int v3 = a.i(v);
            if(v3 >= 0) {
                f1.a = v3;
            }
        }
        b0.e0 = f1;
        f f2 = this.a;
        b0.d0.a(f2, 0);
        b0.e0.a(f2, 1);
        s0.l = v;
        s0.b = (m0 == r1.m.b ? 1 : 0) ^ 1;
        this.b.clear();
        this.c.clear();
        this.d.clear();
        if(k0.b(list0)) {
            HashMap hashMap0 = s0.c;
            for(Object object0: hashMap0.keySet()) {
                ((h)hashMap0.get(object0)).a().E();
            }
            hashMap0.clear();
            hashMap0.put(0, b0);
            s0.d.clear();
            s0.e.clear();
            s0.h.clear();
            s0.j = true;
            k0.a(s0, list0);
            n.h(s0, list0);
            HashMap hashMap1 = s0.c;
            f2.v0.clear();
            b0.d0.a(f2, 0);
            b0.e0.a(f2, 1);
            HashMap hashMap2 = s0.d;
            for(Object object1: hashMap2.keySet()) {
                j j0 = ((g)hashMap2.get(object1)).s();
                if(j0 != null) {
                    h h0 = (h)hashMap1.get(object1);
                    if(h0 == null) {
                        h0 = s0.b(object1);
                    }
                    h0.b(j0);
                }
            }
            for(Object object2: hashMap1.keySet()) {
                h h1 = (h)hashMap1.get(object2);
                if(h1 != b0 && h1.c() instanceof g) {
                    j j1 = ((g)h1.c()).s();
                    if(j1 != null) {
                        h h2 = (h)hashMap1.get(object2);
                        if(h2 == null) {
                            h2 = s0.b(object2);
                        }
                        h2.b(j1);
                    }
                }
            }
            for(Object object3: hashMap1.keySet()) {
                h h3 = (h)hashMap1.get(object3);
                if(h3 == b0) {
                    h3.b(f2);
                }
                else {
                    e e0 = h3.a();
                    e0.l0 = h3.getKey().toString();
                    e0.W = null;
                    if(h3.c() instanceof D1.g) {
                        h3.apply();
                    }
                    f2.W(e0);
                }
            }
            for(Object object4: hashMap2.keySet()) {
                g g0 = (g)hashMap2.get(object4);
                if(g0.s() != null) {
                    for(Object object5: g0.m0) {
                        e e1 = ((h)hashMap1.get(object5)).a();
                        g0.s().W(e1);
                    }
                }
                g0.apply();
            }
            for(Object object6: hashMap1.keySet()) {
                h h4 = (h)hashMap1.get(object6);
                if(h4 != b0 && h4.c() instanceof g) {
                    g g1 = (g)h4.c();
                    j j2 = g1.s();
                    if(j2 != null) {
                        for(Object object7: g1.m0) {
                            h h5 = (h)hashMap1.get(object7);
                            if(h5 != null) {
                                j2.W(h5.a());
                            }
                            else if(object7 instanceof h) {
                                j2.W(((h)object7).a());
                            }
                            else {
                                System.out.println("couldn\'t find reference for " + object7);
                            }
                        }
                        h4.apply();
                    }
                }
            }
            for(Object object8: hashMap1.keySet()) {
                h h6 = (h)hashMap1.get(object8);
                h6.apply();
                e e2 = h6.a();
                if(e2 != null && object8 != null) {
                    e2.k = object8.toString();
                }
            }
        }
        else {
            n.h(s0, list0);
        }
        f2.T(a.h(v));
        f2.O(a.g(v));
        f2.w0.F(f2);
        f2.I0 = v1;
        y1.c.q = f2.d0(0x200);
        f2.b0(f2.I0, 0, 0, 0, 0, 0, 0);
        return n.c(f2.s(), f2.m());
    }
}

