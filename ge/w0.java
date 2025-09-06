package Ge;

import De.d;
import De.f;
import De.g;
import De.j;
import De.l;
import De.r;
import De.v;
import Hf.x;
import Me.u;
import Pe.z;
import Q0.n;
import W.p;
import i.n.i.b.a.s.e.qb;
import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.A;
import kotlin.jvm.internal.J;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.w;
import kotlin.jvm.internal.y;
import nf.e;
import pf.a;
import we.k;

public class w0 extends J {
    @Override  // kotlin.jvm.internal.J
    public final g a(m m0) {
        F f0 = w0.k(m0);
        String s = m0.getName();
        String s1 = m0.getSignature();
        q.g(f0, "container");
        q.g(s, "name");
        q.g(s1, "signature");
        return new H(f0, s, s1, null, m0.getBoundReceiver());
    }

    @Override  // kotlin.jvm.internal.J
    public final d b(Class class0) {
        return c.a(class0);
    }

    @Override  // kotlin.jvm.internal.J
    public final f c(Class class0) {
        q.g(class0, "jClass");
        p p0 = c.b;
        p0.getClass();
        ConcurrentHashMap concurrentHashMap0 = (ConcurrentHashMap)p0.b;
        Object object0 = concurrentHashMap0.get(class0);
        if(object0 == null) {
            object0 = ((k)p0.a).invoke(class0);
            Object object1 = concurrentHashMap0.putIfAbsent(class0, object0);
            if(object1 != null) {
                object0 = object1;
            }
        }
        return (f)object0;
    }

    @Override  // kotlin.jvm.internal.J
    public final j d(n n0) {
        return new Ge.J(w0.k(n0), n0.getName(), n0.getSignature(), n0.getBoundReceiver());
    }

    @Override  // kotlin.jvm.internal.J
    public final l e(t t0) {
        return new L(w0.k(t0), t0.getName(), t0.getSignature(), t0.getBoundReceiver());
    }

    @Override  // kotlin.jvm.internal.J
    public final r f(w w0) {
        return new Z(w0.k(w0), w0.getName(), w0.getSignature(), w0.getBoundReceiver());
    }

    @Override  // kotlin.jvm.internal.J
    public final De.t g(y y0) {
        return new c0(w0.k(y0), y0.getName(), y0.getSignature(), y0.getBoundReceiver());
    }

    @Override  // kotlin.jvm.internal.J
    public final v h(A a0) {
        return new f0(w0.k(a0), a0.getName(), a0.getSignature());
    }

    @Override  // kotlin.jvm.internal.J
    public final String i(kotlin.jvm.internal.l l0) {
        Metadata metadata0 = (Metadata)l0.getClass().getAnnotation(Metadata.class);
        H h0 = null;
        if(metadata0 != null) {
            String[] arr_s = metadata0.d1();
            if(arr_s.length == 0) {
                arr_s = null;
            }
            if(arr_s != null) {
                String[] arr_s1 = metadata0.d2();
                q.g(arr_s1, "strings");
                ByteArrayInputStream byteArrayInputStream0 = new ByteArrayInputStream(a.a(arr_s));
                pf.f f0 = pf.g.g(byteArrayInputStream0, arr_s1);
                lf.A.T.getClass();
                qb qb0 = new qb(byteArrayInputStream0);
                rf.a a0 = (rf.a)lf.A.T.a(qb0, pf.g.a);
                boolean z = false;
                try {
                    qb0.d(0);
                }
                catch(rf.p p0) {
                    p0.a = a0;
                    throw p0;
                }
                if(a0.isInitialized()) {
                    int[] arr_v = metadata0.mv();
                    if((metadata0.xi() & 8) != 0) {
                        z = true;
                    }
                    e e0 = new e(arr_v, z);
                    Class class0 = l0.getClass();
                    lf.Z z1 = ((lf.A)a0).w;
                    q.f(z1, "getTypeTable(...)");
                    Pe.L l1 = (Pe.L)A0.f(class0, ((lf.A)a0), f0, new z(z1), e0, Fe.a.b);
                    h0 = new H(Ge.d.b, l1);
                    goto label_34;
                }
                rf.p p1 = new rf.p("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
                p1.a = a0;
                throw p1;
            }
        }
    label_34:
        if(h0 != null) {
            H h1 = A0.b(h0);
            if(h1 != null) {
                u u0 = h1.t();
                StringBuilder stringBuilder0 = new StringBuilder();
                x0.a(u0, stringBuilder0);
                List list0 = u0.F();
                q.f(list0, "getValueParameters(...)");
                je.p.p0(list0, stringBuilder0, ", ", "(", ")", b.i, 0x30);
                stringBuilder0.append(" -> ");
                x x0 = u0.getReturnType();
                q.d(x0);
                stringBuilder0.append(x0.d(x0));
                return stringBuilder0.toString();
            }
        }
        return super.i(l0);
    }

    @Override  // kotlin.jvm.internal.J
    public final String j(kotlin.jvm.internal.r r0) {
        return this.i(r0);
    }

    public static F k(kotlin.jvm.internal.e e0) {
        f f0 = e0.getOwner();
        return f0 instanceof F ? ((F)f0) : Ge.d.b;
    }
}

