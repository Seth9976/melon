package pf;

import Pe.z;
import e1.G;
import e1.x;
import i.n.i.b.a.s.e.qb;
import ie.m;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import je.p;
import kotlin.jvm.internal.q;
import lf.A;
import lf.E;
import lf.I;
import lf.T;
import lf.b0;
import lf.n;
import of.b;
import of.c;
import of.j;
import of.k;
import rf.f;

public final class g {
    public static final f a;

    static {
        f f0 = new f();
        f0.a(k.a);
        f0.a(k.b);
        f0.a(k.c);
        f0.a(k.d);
        f0.a(k.e);
        f0.a(k.f);
        f0.a(k.g);
        f0.a(k.h);
        f0.a(k.i);
        f0.a(k.j);
        f0.a(k.k);
        f0.a(k.l);
        f0.a(k.m);
        f0.a(k.n);
        g.a = f0;
    }

    public static e a(n n0, nf.f f0, z z0) {
        q.g(n0, "proto");
        q.g(f0, "nameResolver");
        q.g(z0, "typeTable");
        q.f(k.a, "constructorSignature");
        c c0 = (c)x.G(n0, k.a);
        String s = c0 == null || (c0.b & 1) != 1 ? "<init>" : f0.getString(c0.c);
        if(c0 != null && (c0.b & 2) == 2) {
            return new e(s, f0.getString(c0.d));
        }
        List list0 = n0.e;
        q.f(list0, "getValueParameterList(...)");
        ArrayList arrayList0 = new ArrayList(je.q.Q(10, list0));
        for(Object object0: list0) {
            q.d(((b0)object0));
            String s1 = g.e(G.K(((b0)object0), z0), f0);
            if(s1 == null) {
                return null;
            }
            arrayList0.add(s1);
        }
        return new e(s, p.q0(arrayList0, "", "(", ")V", null, 56));
    }

    public static d b(I i0, nf.f f0, z z0, boolean z1) {
        String s;
        q.g(i0, "proto");
        q.g(f0, "nameResolver");
        q.g(z0, "typeTable");
        q.f(k.d, "propertySignature");
        of.e e0 = (of.e)x.G(i0, k.d);
        if(e0 != null) {
            b b0 = (e0.b & 1) == 1 ? e0.c : null;
            if(b0 != null || !z1) {
                int v = b0 == null || (b0.b & 1) != 1 ? i0.f : b0.c;
                if(b0 != null && (b0.b & 2) == 2) {
                    s = f0.getString(b0.d);
                    return new d(f0.getString(v), s);
                }
                s = g.e(G.D(i0, z0), f0);
                return s == null ? null : new d(f0.getString(v), s);
            }
        }
        return null;
    }

    public static e c(A a0, nf.f f0, z z0) {
        String s;
        q.g(a0, "proto");
        q.g(f0, "nameResolver");
        q.g(z0, "typeTable");
        q.f(k.b, "methodSignature");
        c c0 = (c)x.G(a0, k.b);
        int v = c0 == null || (c0.b & 1) != 1 ? a0.f : c0.c;
        if(c0 != null && (c0.b & 2) == 2) {
            s = f0.getString(c0.d);
            return new e(f0.getString(v), s);
        }
        Collection collection0 = e.k.B(G.A(a0, z0));
        List list0 = a0.r;
        q.f(list0, "getValueParameterList(...)");
        ArrayList arrayList0 = new ArrayList(je.q.Q(10, list0));
        for(Object object0: list0) {
            q.d(((b0)object0));
            arrayList0.add(G.K(((b0)object0), z0));
        }
        ArrayList arrayList1 = p.A0(collection0, arrayList0);
        ArrayList arrayList2 = new ArrayList(je.q.Q(10, arrayList1));
        for(Object object1: arrayList1) {
            String s1 = g.e(((T)object1), f0);
            if(s1 == null) {
                return null;
            }
            arrayList2.add(s1);
        }
        String s2 = g.e(G.C(a0, z0), f0);
        if(s2 == null) {
            return null;
        }
        s = U4.x.m(new StringBuilder(), p.q0(arrayList2, "", "(", ")", null, 56), s2);
        return new e(f0.getString(v), s);
    }

    public static final boolean d(I i0) {
        q.g(i0, "proto");
        Object object0 = i0.i(k.e);
        q.f(object0, "getExtension(...)");
        return pf.c.a.e(((Number)object0).intValue()).booleanValue();
    }

    // 去混淆评级： 低(20)
    public static String e(T t0, nf.f f0) {
        return t0.n() ? pf.b.b(f0.e(t0.i)) : null;
    }

    public static final m f(String[] arr_s, String[] arr_s1) {
        q.g(arr_s1, "strings");
        ByteArrayInputStream byteArrayInputStream0 = new ByteArrayInputStream(a.a(arr_s));
        pf.f f0 = g.g(byteArrayInputStream0, arr_s1);
        lf.k.i0.getClass();
        qb qb0 = new qb(byteArrayInputStream0);
        rf.a a0 = (rf.a)lf.k.i0.a(qb0, g.a);
        try {
            qb0.d(0);
        }
        catch(rf.p p0) {
            p0.a = a0;
            throw p0;
        }
        if(a0.isInitialized()) {
            return new m(f0, ((lf.k)a0));
        }
        rf.p p1 = new rf.p("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
        p1.a = a0;
        throw p1;
    }

    public static pf.f g(ByteArrayInputStream byteArrayInputStream0, String[] arr_s) {
        j j0 = (j)j.h.b(byteArrayInputStream0, g.a);
        q.f(j0, "parseDelimitedFrom(...)");
        return new pf.f(j0, arr_s);
    }

    public static final m h(String[] arr_s, String[] arr_s1) {
        q.g(arr_s, "data");
        q.g(arr_s1, "strings");
        ByteArrayInputStream byteArrayInputStream0 = new ByteArrayInputStream(a.a(arr_s));
        pf.f f0 = g.g(byteArrayInputStream0, arr_s1);
        E.l.getClass();
        qb qb0 = new qb(byteArrayInputStream0);
        rf.a a0 = (rf.a)E.l.a(qb0, g.a);
        try {
            qb0.d(0);
        }
        catch(rf.p p0) {
            p0.a = a0;
            throw p0;
        }
        if(a0.isInitialized()) {
            return new m(f0, ((E)a0));
        }
        rf.p p1 = new rf.p("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
        p1.a = a0;
        throw p1;
    }
}

