package androidx.compose.runtime;

import E1.a;
import Q5.h;
import androidx.collection.L;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public abstract class q {
    public static final d0 a;
    public static final d0 b;
    public static final d0 c;
    public static final d0 d;
    public static final d0 e;
    public static final a f;

    static {
        q.a = new d0("provider");
        q.b = new d0("provider");
        q.c = new d0("compositionLocalMap");
        q.d = new d0("providers");
        q.e = new d0("reference");
        q.f = new a(8);
    }

    public static final void a(int v, int v1, List list0) {
        int v2 = q.f(v, list0);
        if(v2 < 0) {
            v2 = -(v2 + 1);
        }
        while(v2 < list0.size() && ((O)list0.get(v2)).b < v1) {
            list0.remove(v2);
        }
    }

    public static final void b(A0 a00, ArrayList arrayList0, int v) {
        int[] arr_v = a00.b;
        if(a00.i(v)) {
            arrayList0.add(a00.k(v));
            return;
        }
        int v1 = v + 1;
        int v2 = arr_v[v * 5 + 3] + v;
        while(v1 < v2) {
            q.b(a00, arrayList0, v1);
            v1 += arr_v[v1 * 5 + 3];
        }
    }

    public static final void c(@NotNull String s) {
        throw new j("Compose Runtime internal error. Unexpected or incorrect use of the Compose internal runtime API (" + s + "). Please report to Google or use https://goo.gle/compose-feedback");
    }

    @NotNull
    public static final Void d(@NotNull String s) {
        throw new j("Compose Runtime internal error. Unexpected or incorrect use of the Compose internal runtime API (" + s + "). Please report to Google or use https://goo.gle/compose-feedback");
    }

    public static final void e(E0 e00, h h0) {
        int v4;
        int v = e00.f(e00.q(e00.t), e00.b);
        int v1 = e00.f(e00.q(e00.s(e00.t) + e00.t), e00.b);
        while(v < v1) {
            Object object0 = e00.c[e00.g(v)];
            int v2 = -1;
            if(object0 instanceof i) {
                h0.f(e00.o() - v, -1, -1, ((i)object0));
            }
            else if(!(object0 instanceof x0)) {
                if(object0 instanceof n0) {
                    q.h(e00, v, object0);
                    ((n0)object0).d();
                }
            }
            else if(!(((x0)object0).a instanceof m)) {
                q.h(e00, v, object0);
                int v3 = e00.o();
                androidx.compose.runtime.a a0 = ((x0)object0).b;
                if(a0 == null || !a0.a()) {
                    v4 = -1;
                }
                else {
                    v2 = e00.c(a0);
                    v4 = e00.o() - e00.M(v2);
                }
                h0.f(v3 - v, v2, v4, ((x0)object0));
            }
            ++v;
        }
    }

    public static final int f(int v, List list0) {
        int v1 = list0.size() - 1;
        int v2 = 0;
        while(v2 <= v1) {
            int v3 = v2 + v1 >>> 1;
            int v4 = kotlin.jvm.internal.q.h(((O)list0.get(v3)).b, v);
            if(v4 < 0) {
                v2 = v3 + 1;
                continue;
            }
            if(v4 > 0) {
                v1 = v3 - 1;
                continue;
            }
            return v3;
        }
        return -(v2 + 1);
    }

    public static final void g(E0 e00, h h0) {
        int v5;
        int v = e00.f(e00.q(e00.t), e00.b);
        int v1 = e00.f(e00.q(e00.s(e00.t) + e00.t), e00.b);
        while(v < v1) {
            Object object0 = e00.c[e00.g(v)];
            int v2 = -1;
            if(object0 instanceof i) {
                int v3 = e00.o();
                L l0 = (L)h0.f;
                if(l0 == null) {
                    l0 = new L();
                    h0.f = l0;
                }
                l0.k(((i)object0));
                h0.f(v3 - v, -1, -1, ((i)object0));
            }
            if(object0 instanceof x0) {
                int v4 = e00.o();
                androidx.compose.runtime.a a0 = ((x0)object0).b;
                if(a0 == null || !a0.a()) {
                    v5 = -1;
                }
                else {
                    v2 = e00.c(a0);
                    v5 = e00.o() - e00.M(v2);
                }
                h0.f(v4 - v, v2, v5, ((x0)object0));
            }
            if(object0 instanceof n0) {
                ((n0)object0).d();
            }
            ++v;
        }
        e00.F();
    }

    public static final void h(E0 e00, int v, Object object0) {
        int v1 = e00.g(v);
        Object[] arr_object = e00.c;
        Object object1 = arr_object[v1];
        arr_object[v1] = k.a;
        if(object0 == object1) {
            return;
        }
        q.c(("Slot table is out of sync (expected " + object0 + ", got " + object1 + ')'));
    }
}

