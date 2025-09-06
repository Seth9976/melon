package tf;

import Hf.B;
import Hf.Y;
import Hf.x;
import Me.A;
import Me.L;
import Me.T;
import Me.V;
import Me.e;
import Me.h;
import Me.k;
import Me.v;
import Pe.J;
import d5.n;
import kotlin.jvm.internal.q;
import qf.c;

public abstract class g {
    static {
        c c0 = new c("kotlin.jvm.JvmInline");
        c0.b();
        n.E(c0.a.f()).a.c();
        new c("kotlin.jvm.JvmName");
    }

    public static final boolean a(Me.c c0) {
        q.g(c0, "<this>");
        if(c0 instanceof J) {
            L l0 = ((J)c0).t1();
            q.f(l0, "getCorrespondingProperty(...)");
            if(l0.Q() == null) {
                k k0 = l0.e();
                e e0 = k0 instanceof e ? ((e)k0) : null;
                if(e0 != null) {
                    T t0 = e0.a0();
                    if(t0 != null) {
                        qf.e e1 = l0.getName();
                        q.f(e1, "getName(...)");
                        return t0.a(e1);
                    }
                }
            }
        }
        return false;
    }

    public static final boolean b(k k0) {
        q.g(k0, "<this>");
        return k0 instanceof e && ((e)k0).a0() instanceof v;
    }

    public static final boolean c(x x0) {
        q.g(x0, "<this>");
        h h0 = x0.w().e();
        return h0 == null ? false : g.b(h0);
    }

    public static final boolean d(k k0) {
        q.g(k0, "<this>");
        return k0 instanceof e && ((e)k0).a0() instanceof A;
    }

    public static final boolean e(V v0) {
        if(v0.Q() == null) {
            k k0 = v0.e();
            qf.e e0 = null;
            e e1 = k0 instanceof e ? ((e)k0) : null;
            if(e1 != null) {
                T t0 = e1.a0();
                v v1 = t0 instanceof v ? ((v)t0) : null;
                if(v1 != null) {
                    e0 = v1.a;
                }
            }
            return q.b(e0, v0.getName());
        }
        return false;
    }

    public static final boolean f(k k0) {
        q.g(k0, "<this>");
        return g.b(k0) || g.d(k0);
    }

    public static final boolean g(x x0) {
        h h0 = x0.w().e();
        return h0 == null ? false : g.f(h0);
    }

    public static final boolean h(x x0) {
        q.g(x0, "<this>");
        h h0 = x0.w().e();
        return h0 != null && g.d(h0) && !Y.e(x0);
    }

    public static final B i(x x0) {
        q.g(x0, "<this>");
        h h0 = x0.w().e();
        e e0 = h0 instanceof e ? ((e)h0) : null;
        if(e0 != null) {
            T t0 = e0.a0();
            v v0 = t0 instanceof v ? ((v)t0) : null;
            return v0 == null ? null : ((B)v0.b);
        }
        return null;
    }
}

