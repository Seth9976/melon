package p0;

import B7.b;
import androidx.collection.L;
import androidx.compose.foundation.lazy.layout.Z;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import je.w;
import kotlin.jvm.internal.q;
import m0.a;
import m0.j;
import we.k;
import we.n;

public abstract class m {
    public static final d5.m a;
    public static final Object b;
    public static l c;
    public static long d;
    public static final Z e;
    public static final b f;
    public static Object g;
    public static Object h;
    public static final c i;
    public static final a j;

    static {
        m.a = new d5.m(17);
        m.b = new Object();
        l l0 = l.e;
        m.c = l0;
        m.d = 2L;
        Z z0 = new Z();  // 初始化器: Ljava/lang/Object;-><init>()V
        z0.c = new long[16];
        z0.d = new int[16];
        int[] arr_v = new int[16];
        for(int v = 0; v < 16; ++v) {
            arr_v[v] = v + 1;
        }
        z0.e = arr_v;
        m.e = z0;
        b b0 = new b();  // 初始化器: Ljava/lang/Object;-><init>()V
        b0.b = new int[16];
        b0.c = new j[16];
        m.f = b0;
        m.g = w.a;
        m.h = w.a;
        long v1 = m.d;
        m.d = v1 + 1L;
        c c0 = new c(v1, l0, null, p0.a.g);  // 初始化器: Lp0/d;-><init>(JLp0/l;Lwe/k;Lwe/k;)V
        m.c = m.c.g(c0.b);
        m.i = c0;
        m.j = new a(0);  // 初始化器: Ljava/util/concurrent/atomic/AtomicInteger;-><init>(I)V
    }

    public static final void a() {
        m.f(p0.a.h);
    }

    public static final k b(k k0, k k1) {
        if(k0 != null && k1 != null && k0 != k1) {
            return new p0.b(k0, k1, 2);
        }
        return k0 == null ? k1 : k0;
    }

    public static final HashMap c(long v, d d0, l l0) {
        l l4;
        long[] arr_v2;
        l l3;
        long[] arr_v1;
        L l1 = d0.x();
        if(l1 != null) {
            l l2 = d0.d().g(d0.g()).e(d0.j);
            Object[] arr_object = l1.b;
            long[] arr_v = l1.a;
            int v1 = arr_v.length - 2;
            if(v1 >= 0) {
                int v2 = 0;
                HashMap hashMap0 = null;
            alab1:
                while(true) {
                    long v3 = arr_v[v2];
                    if((~v3 << 7 & v3 & 0x8080808080808080L) == 0x8080808080808080L) {
                        arr_v2 = arr_v;
                        l4 = l2;
                    }
                    else {
                        int v4 = 8 - (~(v2 - v1) >>> 0x1F);
                        int v5 = 0;
                        while(v5 < v4) {
                            if((v3 & 0xFFL) < 0x80L) {
                                t t0 = (t)arr_object[(v2 << 3) + v5];
                                v v6 = t0.e();
                                arr_v1 = arr_v;
                                v v7 = m.s(v6, v, l0);
                                if(v7 != null) {
                                    v v8 = m.s(v6, v, l2);
                                    if(v8 != null && !v7.equals(v8)) {
                                        l3 = l2;
                                        v v9 = m.s(v6, d0.g(), d0.d());
                                        if(v9 != null) {
                                            v v10 = t0.a(v8, v7, v9);
                                            if(v10 == null) {
                                                break alab1;
                                            }
                                            if(hashMap0 == null) {
                                                hashMap0 = new HashMap();
                                            }
                                            hashMap0.put(v7, v10);
                                            goto label_37;
                                        }
                                        m.r();
                                        throw null;
                                    }
                                }
                            }
                            else {
                                arr_v1 = arr_v;
                            }
                            l3 = l2;
                        label_37:
                            v3 >>= 8;
                            ++v5;
                            arr_v = arr_v1;
                            l2 = l3;
                        }
                        arr_v2 = arr_v;
                        l4 = l2;
                        if(v4 != 8) {
                            return hashMap0;
                        }
                    }
                    if(v2 != v1) {
                        ++v2;
                        arr_v = arr_v2;
                        l2 = l4;
                        continue;
                    }
                    return hashMap0;
                }
            }
        }
        return null;
    }

    public static final void d(h h0) {
        long v1;
        if(!m.c.d(h0.g())) {
            StringBuilder stringBuilder0 = new StringBuilder("Snapshot is not open: snapshotId=");
            stringBuilder0.append(h0.g());
            stringBuilder0.append(", disposed=");
            stringBuilder0.append(h0.c);
            stringBuilder0.append(", applied=");
            d d0 = h0 instanceof d ? ((d)h0) : null;
            Boolean boolean0 = d0 == null ? "read-only" : Boolean.valueOf(d0.m);
            stringBuilder0.append(boolean0);
            stringBuilder0.append(", lowestPin=");
            synchronized(m.b) {
                v1 = m.e.a <= 0 ? -1L : ((long[])m.e.c)[0];
            }
            stringBuilder0.append(v1);
            throw new IllegalStateException(stringBuilder0.toString().toString());
        }
    }

    public static final l e(l l0, long v, long v1) {
        while(v < v1) {
            l0 = l0.g(v);
            ++v;
        }
        return l0;
    }

    public static final Object f(k k0) {
        Object object1;
        L l0;
        c c0 = m.i;
        synchronized(m.b) {
            l0 = c0.h;
            if(l0 != null) {
                m.j.addAndGet(1);
            }
            object1 = m.v(c0, k0);
        }
        if(l0 != null) {
            try {
                Object object2 = m.g;
                int v2 = ((Collection)object2).size();
                for(int v3 = 0; v3 < v2; ++v3) {
                    ((n)((List)object2).get(v3)).invoke(new g0.h(l0), c0);
                }
            }
            finally {
                m.j.addAndGet(-1);
            }
        }
        synchronized(m.b) {
            m.g();
            if(l0 != null) {
                Object[] arr_object = l0.b;
                long[] arr_v = l0.a;
                int v5 = arr_v.length - 2;
                if(v5 >= 0) {
                    int v6 = 0;
                    while(true) {
                        long v7 = arr_v[v6];
                        if((~v7 << 7 & v7 & 0x8080808080808080L) != 0x8080808080808080L) {
                            int v8 = 8 - (~(v6 - v5) >>> 0x1F);
                            for(int v9 = 0; v9 < v8; ++v9) {
                                if((0xFFL & v7) < 0x80L) {
                                    m.q(((t)arr_object[(v6 << 3) + v9]));
                                }
                                v7 >>= 8;
                            }
                            if(v8 == 8) {
                                goto label_44;
                            }
                            break;
                        }
                    label_44:
                        if(v6 == v5) {
                            break;
                        }
                        ++v6;
                    }
                }
            }
            return object1;
        }
    }

    public static final void g() {
        b b0 = m.f;
        int v = b0.a;
        int v2 = 0;
        for(int v1 = 0; true; ++v1) {
            Object object0 = null;
            if(v1 >= v) {
                break;
            }
            j j0 = ((j[])b0.c)[v1];
            if(j0 != null) {
                object0 = j0.get();
            }
            if(object0 != null && m.p(((t)object0))) {
                if(v2 != v1) {
                    ((j[])b0.c)[v2] = j0;
                    int[] arr_v = (int[])b0.b;
                    arr_v[v2] = arr_v[v1];
                }
                ++v2;
            }
        }
        for(int v3 = v2; v3 < v; ++v3) {
            ((j[])b0.c)[v3] = null;
            ((int[])b0.b)[v3] = 0;
        }
        if(v2 != v) {
            b0.a = v2;
        }
    }

    public static final h h(h h0, k k0, boolean z) {
        if(!(h0 instanceof d) && h0 != null) {
            return new y(h0, k0, z);
        }
        return h0 instanceof d ? new x(((d)h0), k0, null, false, z) : new x(null, k0, null, false, z);
    }

    public static final v i(v v0) {
        v v3;
        h h0 = m.k();
        v v1 = m.s(v0, h0.g(), h0.d());
        if(v1 == null) {
            synchronized(m.b) {
                h h1 = m.k();
                v3 = m.s(v0, h1.g(), h1.d());
            }
            if(v3 != null) {
                return v3;
            }
            m.r();
            throw null;
        }
        return v1;
    }

    public static final v j(v v0, h h0) {
        v v3;
        v v1 = m.s(v0, h0.g(), h0.d());
        if(v1 == null) {
            synchronized(m.b) {
                v3 = m.s(v0, h0.g(), h0.d());
            }
            if(v3 != null) {
                return v3;
            }
            m.r();
            throw null;
        }
        return v1;
    }

    public static final h k() {
        h h0 = (h)m.a.i();
        return h0 == null ? m.i : h0;
    }

    public static final k l(k k0, k k1, boolean z) {
        if(!z) {
            k1 = null;
        }
        if(k0 != null && k1 != null && k0 != k1) {
            return new p0.b(k0, k1, 1);
        }
        return k0 == null ? k1 : k0;
    }

    public static final v m(v v0, t t0) {
        v v1 = t0.e();
        long v2 = m.d;
        Z z0 = m.e;
        if(z0.a > 0) {
            v2 = ((long[])z0.c)[0];
        }
        v v3 = null;
        v v4 = null;
        while(v1 != null) {
            long v5 = v1.a;
            if(v5 != 0L) {
                if(v5 > v2 - 1L) {
                    v1 = v1.b;
                    continue;
                }
                else if(v4 == null) {
                    v4 = v1;
                    v1 = v1.b;
                    continue;
                }
                else if(v1.a >= v4.a) {
                    v3 = v4;
                    break;
                }
            }
            v3 = v1;
            if(true) {
                break;
            }
        }
        if(v3 != null) {
            v3.a = 0x7FFFFFFFFFFFFFFFL;
            return v3;
        }
        v v6 = v0.b(0x7FFFFFFFFFFFFFFFL);
        v6.b = t0.e();
        t0.b(v6);
        return v6;
    }

    public static final void n(h h0, t t0) {
        h0.t(h0.h() + 1);
        k k0 = h0.i();
        if(k0 != null) {
            k0.invoke(t0);
        }
    }

    public static final v o(v v0, u u0, h h0, v v1) {
        v v4;
        if(h0.f()) {
            h0.n(u0);
        }
        long v2 = h0.g();
        if(v1.a == v2) {
            return v1;
        }
        synchronized(m.b) {
            v4 = m.m(v0, u0);
        }
        v4.a = v2;
        if(v1.a != 1L) {
            h0.n(u0);
        }
        return v4;
    }

    public static final boolean p(t t0) {
        v v6;
        v v0 = t0.e();
        long v1 = m.d;
        Z z0 = m.e;
        if(z0.a > 0) {
            v1 = ((long[])z0.c)[0];
        }
        v v2 = null;
        v v3 = null;
        int v4 = 0;
        while(v0 != null) {
            long v5 = v0.a;
            if(v5 != 0L) {
                if(v5 >= v1) {
                    ++v4;
                }
                else if(v2 == null) {
                    ++v4;
                    v2 = v0;
                }
                else {
                    if(v5 < v2.a) {
                        v6 = v2;
                        v2 = v0;
                    }
                    else {
                        v6 = v0;
                    }
                    if(v3 == null) {
                        v3 = t0.e();
                        v v7 = v3;
                        while(true) {
                            if(v3 != null) {
                                long v8 = v3.a;
                                if(v8 < v1) {
                                    if(v7.a < v8) {
                                        v7 = v3;
                                    }
                                    v3 = v3.b;
                                    continue;
                                }
                                else {
                                    break;
                                }
                            }
                            v3 = v7;
                            break;
                        }
                    }
                    v2.a = 0L;
                    v2.a(v3);
                    v2 = v6;
                }
            }
            v0 = v0.b;
        }
        return v4 > 1;
    }

    public static final void q(t t0) {
        if(m.p(t0)) {
            b b0 = m.f;
            int v = b0.a;
            int v1 = System.identityHashCode(t0);
            int v2 = -1;
            if(v > 0) {
                int v3 = b0.a - 1;
                int v4 = 0;
                while(v4 <= v3) {
                    int v5 = v4 + v3 >>> 1;
                    int v6 = ((int[])b0.b)[v5];
                    if(v6 < v1) {
                        v4 = v5 + 1;
                        continue;
                    }
                    if(v6 > v1) {
                        v3 = v5 - 1;
                        continue;
                    }
                    j j0 = ((j[])b0.c)[v5];
                    if(t0 != (j0 == null ? null : j0.get())) {
                        int v7 = v5 - 1;
                        while(-1 < v7 && ((int[])b0.b)[v7] == v1) {
                            j j1 = ((j[])b0.c)[v7];
                            if((j1 == null ? null : j1.get()) == t0) {
                                v2 = v7;
                                goto label_42;
                            }
                            --v7;
                        }
                        ++v5;
                        int v8 = b0.a;
                        while(v5 < v8) {
                            if(((int[])b0.b)[v5] != v1) {
                                v2 = -(v5 + 1);
                                goto label_42;
                            }
                            j j2 = ((j[])b0.c)[v5];
                            if((j2 == null ? null : j2.get()) == t0) {
                                v2 = v5;
                                goto label_42;
                            }
                            ++v5;
                        }
                        v2 = -(b0.a + 1);
                        goto label_42;
                    }
                    v2 = v5;
                    goto label_42;
                }
                v2 = -(v4 + 1);
            label_42:
                if(v2 < 0) {
                    goto label_43;
                }
            }
            else {
            label_43:
                j[] arr_j = (j[])b0.c;
                if(v == arr_j.length) {
                    j[] arr_j1 = new j[arr_j.length * 2];
                    int[] arr_v = new int[arr_j.length * 2];
                    System.arraycopy(arr_j, -(v2 + 1), arr_j1, -v2, v - -(v2 + 1));
                    System.arraycopy(((j[])b0.c), 0, arr_j1, 0, -(v2 + 1));
                    je.n.S(-v2, -(v2 + 1), v, ((int[])b0.b), arr_v);
                    je.n.X(0, -(v2 + 1), 6, ((int[])b0.b), arr_v);
                    b0.c = arr_j1;
                    b0.b = arr_v;
                }
                else {
                    System.arraycopy(arr_j, -(v2 + 1), arr_j, -v2, v - -(v2 + 1));
                    int[] arr_v1 = (int[])b0.b;
                    je.n.S(-v2, -(v2 + 1), v, arr_v1, arr_v1);
                }
                j[] arr_j2 = (j[])b0.c;
                arr_j2[-(v2 + 1)] = new j(t0);  // 初始化器: Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V
                ((int[])b0.b)[-(v2 + 1)] = v1;
                ++b0.a;
            }
        }
    }

    public static final void r() {
        throw new IllegalStateException("Reading a state that was created after the snapshot was taken or in a snapshot that has not yet been applied");
    }

    public static final v s(v v0, long v1, l l0) {
        v v2 = null;
        while(v0 != null) {
            if(v0.a != 0L && v0.a <= v1 && !l0.d(v0.a) && (v2 == null || v2.a < v0.a)) {
                v2 = v0;
            }
            v0 = v0.b;
        }
        return v2 == null ? null : v2;
    }

    public static final v t(v v0, t t0) {
        h h0 = m.k();
        k k0 = h0.e();
        if(k0 != null) {
            k0.invoke(t0);
        }
        v v1 = m.s(v0, h0.g(), h0.d());
        if(v1 == null) {
            synchronized(m.b) {
                h h1 = m.k();
                v v3 = t0.e();
                q.e(v3, "null cannot be cast to non-null type T of androidx.compose.runtime.snapshots.SnapshotKt.readable");
                v v4 = m.s(v3, h1.g(), h1.d());
                if(v4 != null) {
                    return v4;
                }
                m.r();
            }
            throw null;
        }
        return v1;
    }

    public static final void u(int v) {
        Z z0 = m.e;
        int v1 = ((int[])z0.e)[v];
        z0.r(v1, z0.a - 1);
        --z0.a;
        long[] arr_v = (long[])z0.c;
        long v2 = arr_v[v1];
        for(int v3 = v1; v3 > 0; v3 = v4) {
            int v4 = (v3 + 1 >> 1) - 1;
            if(arr_v[v4] <= v2) {
                break;
            }
            z0.r(v4, v3);
        }
        long[] arr_v1 = (long[])z0.c;
        int v5 = z0.a >> 1;
        while(v1 < v5) {
            int v6 = v1 + 1 << 1;
            int v7 = v6 - 1;
            if(v6 < z0.a) {
                long v8 = arr_v1[v6];
                if(v8 < arr_v1[v7]) {
                    if(v8 >= arr_v1[v1]) {
                        break;
                    }
                    z0.r(v6, v1);
                    v1 = v6;
                    continue;
                }
            }
            if(arr_v1[v7] >= arr_v1[v1]) {
                break;
            }
            z0.r(v7, v1);
            v1 = v7;
        }
        ((int[])z0.e)[v] = z0.b;
        z0.b = v;
    }

    public static final Object v(c c0, k k0) {
        long v = c0.b;
        Object object0 = k0.invoke(m.c.b(v));
        long v1 = m.d;
        m.d = v1 + 1L;
        l l0 = m.c.b(v);
        m.c = l0;
        c0.b = v1;
        c0.a = l0;
        c0.g = 0;
        c0.h = null;
        c0.o();
        m.c = m.c.g(v1);
        return object0;
    }

    public static final v w(v v0, t t0, h h0) {
        if(h0.f()) {
            h0.n(t0);
        }
        long v1 = h0.g();
        v v2 = m.s(v0, v1, h0.d());
        if(v2 != null) {
            if(v2.a == h0.g()) {
                return v2;
            }
            synchronized(m.b) {
                v v4 = m.s(t0.e(), v1, h0.d());
                if(v4 != null) {
                    if(v4.a != v1) {
                        v v5 = m.m(v4, t0);
                        v5.a(v4);
                        v5.a = h0.g();
                        v4 = v5;
                    }
                    if(v2.a != 1L) {
                        h0.n(t0);
                    }
                    return v4;
                }
                m.r();
            }
            throw null;
        }
        m.r();
        throw null;
    }
}

