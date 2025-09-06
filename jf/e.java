package jf;

import Df.d;
import Df.i;
import Ff.l;
import Ff.s;
import Ff.y;
import Me.E;
import Re.c;
import e1.m;
import java.util.Set;
import je.n;
import je.w;
import kf.a;
import kotlin.jvm.internal.q;
import lf.k;
import pf.f;
import pf.g;
import rf.p;

public final class e {
    public i a;
    public static final Set b;
    public static final Set c;
    public static final nf.e d;
    public static final nf.e e;

    static {
        e.b = m.E(a.e);
        e.c = n.A0(new a[]{a.f, a.i});
        new nf.e(new int[]{1, 1, 2}, false);
        e.d = new nf.e(new int[]{1, 1, 11}, false);
        e.e = new nf.e(new int[]{1, 1, 13}, false);
    }

    public final s a(E e0, c c0) {
        ie.m m0;
        q.g(c0, "kotlinClass");
        A7.a a0 = c0.b;
        String[] arr_s = (String[])a0.f;
        if(arr_s == null) {
            arr_s = (String[])a0.g;
        }
        if(arr_s == null || !e.c.contains(((a)a0.d))) {
            arr_s = null;
        }
        if(arr_s != null) {
            nf.e e1 = (nf.e)a0.e;
            String[] arr_s1 = (String[])a0.h;
            if(arr_s1 != null) {
                try {
                    try {
                        m0 = g.h(arr_s, arr_s1);
                    }
                    catch(p p0) {
                        throw new IllegalStateException("Could not read data from " + c0.a(), p0);
                    }
                }
                catch(Throwable throwable0) {
                    this.c().c.getClass();
                    if(e1.b(this.e())) {
                        throw throwable0;
                    }
                    m0 = null;
                }
                if(m0 != null) {
                    this.d(c0);
                    boolean z = this.f(c0);
                    l l0 = this.b(c0);
                    jf.g g0 = new jf.g(c0, ((lf.E)m0.b), ((f)m0.a), z, l0);
                    i i0 = this.c();
                    return new s(e0, ((lf.E)m0.b), ((f)m0.a), e1, g0, i0, "scope for " + g0 + " in " + e0, () -> w.a);
                }
            }
        }
        return null;
    }

    public final l b(c c0) {
        this.c().c.getClass();
        int v = c0.b.c;
        return (v & 16) == 0 || (v & 0x20) != 0 ? l.a : l.b;
    }

    public final i c() {
        i i0 = this.a;
        if(i0 != null) {
            return i0;
        }
        q.m("components");
        throw null;
    }

    public final Df.n d(c c0) {
        this.c().c.getClass();
        if(((nf.e)c0.b.e).b(this.e())) {
            return null;
        }
        nf.e e0 = (nf.e)c0.b.e;
        nf.e e1 = nf.e.g;
        nf.e e2 = this.e();
        nf.e e3 = this.e();
        e3.getClass();
        nf.e e4 = e0.f ? e1 : nf.e.h;
        if(e4.b > e3.b || e4.b >= e3.b && e4.c > e3.c) {
            e3 = e4;
        }
        return new Df.n(e0, e1, e2, e3, c0.a());
    }

    public final nf.e e() {
        this.c().c.getClass();
        return nf.e.g;
    }

    public final boolean f(c c0) {
        this.c().c.getClass();
        this.c().c.getClass();
        return (c0.b.c & 2) != 0 && ((nf.e)c0.b.e).equals(e.d);
    }

    public final d g(c c0) {
        ie.m m0;
        A7.a a0 = c0.b;
        String[] arr_s = (String[])a0.f;
        if(arr_s == null) {
            arr_s = (String[])a0.g;
        }
        if(arr_s == null || !e.b.contains(((a)a0.d))) {
            arr_s = null;
        }
        if(arr_s != null) {
            nf.e e0 = (nf.e)a0.e;
            String[] arr_s1 = (String[])a0.h;
            if(arr_s1 != null) {
                try {
                    try {
                        m0 = g.f(arr_s, arr_s1);
                    }
                    catch(p p0) {
                        throw new IllegalStateException("Could not read data from " + c0.a(), p0);
                    }
                }
                catch(Throwable throwable0) {
                    this.c().c.getClass();
                    if(e0.b(this.e())) {
                        throw throwable0;
                    }
                    m0 = null;
                }
                if(m0 != null) {
                    this.d(c0);
                    o o0 = new o(c0, new y(this.f(c0)), this.b(c0));
                    return new d(((f)m0.a), ((k)m0.b), e0, o0);
                }
            }
        }
        return null;
    }
}

