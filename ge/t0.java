package Ge;

import Ac.q0;
import Df.j;
import Gf.m;
import If.k;
import J0.h;
import Je.l;
import Je.n;
import Le.o;
import Me.O;
import Pe.A;
import Re.b;
import Re.e;
import Re.f;
import Se.c;
import Ze.t;
import Ze.z;
import cf.a;
import cf.d;
import com.google.firebase.messaging.u;
import ie.H;
import ie.i;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import je.w;
import kotlin.jvm.internal.q;
import pf.g;

public abstract class t0 {
    public static final ConcurrentHashMap a;

    static {
        t0.a = new ConcurrentHashMap();
    }

    public static final f a(Class class0) {
        o o2;
        o o1;
        q.g(class0, "<this>");
        ClassLoader classLoader0 = c.d(class0);
        B0 b00 = new B0(classLoader0);
        ConcurrentHashMap concurrentHashMap0 = t0.a;
        WeakReference weakReference0 = (WeakReference)concurrentHashMap0.get(b00);
        if(weakReference0 != null) {
            f f0 = (f)weakReference0.get();
            if(f0 != null) {
                return f0;
            }
            concurrentHashMap0.remove(b00, weakReference0);
        }
        j j0 = j.f;
        b b0 = new b(classLoader0);
        ClassLoader classLoader1 = H.class.getClassLoader();
        q.f(classLoader1, "getClassLoader(...)");
        b b1 = new b(classLoader1);
        b b2 = new b(classLoader0);
        e e0 = e.b;
        e e1 = e.c;
        q.g(("runtime module for " + classLoader0), "moduleName");
        m m0 = new m("DeserializationComponentsForJava.ModuleData");
        Le.j j1 = new Le.j(m0);
        A a0 = new A(qf.e.g(("<" + ("runtime module for " + classLoader0) + '>')), m0, j1, 56);
        Gf.o o0 = m0.a;
        o0.lock();
        try {
            if(j1.a != null) {
                throw new AssertionError("Built-ins module is already set: " + j1.a + " (attempting to reset to " + a0 + ")");
            }
            j1.a = a0;
        }
        catch(Throwable throwable0) {
            try {
                m0.b.getClass();
                throw throwable0;
            }
            catch(Throwable throwable1) {
                o0.unlock();
                throw throwable1;
            }
        }
        o0.unlock();
        j1.f = new l(a0, 1);
        jf.e e2 = new jf.e();  // 初始化器: Ljava/lang/Object;-><init>()V
        androidx.lifecycle.b b3 = new androidx.lifecycle.b(14);
        u u0 = new u(m0, a0);
        i i0 = new i(1, 9, 0);
        z z0 = Ze.q.d.b == null || Ze.q.d.b.c - i0.c > 0 ? Ze.q.d.a : Ze.q.d.c;
        q.g(z0, "globalReportLevel");
        h h0 = new h(new t(z0, (z0 == z.c ? null : z0)), new q0(i0, 16));
        wc.u u1 = new wc.u(m0);
        n n0 = new n(a0, u0);
        Ze.b b4 = new Ze.b(h0);
        hf.c c0 = new hf.c();  // 初始化器: Ljava/lang/Object;-><init>()V
        k.b.getClass();
        If.l l0 = If.j.b;
        jf.f f1 = new jf.f();  // 初始化器: Ljava/lang/Object;-><init>()V
        d d0 = new d(new a(m0, b2, b0, e2, af.h.c, e0, af.h.a, u1, e1, b3, jf.f.c, O.c, Ue.b.a, a0, n0, b4, c0, Ze.l.a, cf.b.a, l0, h0, f1));
        q.g(nf.e.g, "metadataVersion");
        d5.c c1 = new d5.c(12, b0, e2);
        E9.u u2 = new E9.u();  // 初始化器: Ljava/lang/Object;-><init>()V
        u2.a = b0;
        u2.b = m0.b(new q0(u2, 27));
        u2.c = a0;
        u2.d = u0;
        u2.e = new x9.b(a0, u0);
        u2.f = nf.e.g;
        List list0 = e.k.z(Hf.k.a);
        Le.j j2 = a0.d instanceof Le.j ? ((Le.j)a0.d) : null;
        jf.f f2 = jf.f.b;
        if(j2 == null) {
            o1 = Oe.a.b;
        }
        else {
            o1 = j2.K();
            if(o1 == null) {
                o1 = Oe.a.b;
            }
        }
        if(j2 == null) {
            o2 = Oe.a.d;
        }
        else {
            o2 = j2.K();
            if(o2 == null) {
                o2 = Oe.a.d;
            }
        }
        wc.u u3 = new wc.u(m0);
        Df.i i1 = new Df.i(m0, a0, c1, u2, d0, e0, f2, w.a, u0, o1, o2, g.a, l0, u3, list0, j0);
        e2.a = i1;
        b3.b = new wa.a(d0);
        o o3 = j1.K();
        o o4 = j1.K();
        wc.u u4 = new wc.u(m0);
        q.g(o3, "additionalClassPartsProvider");
        q.g(o4, "platformDependentDeclarationFilter");
        Le.q q0 = new Le.q(m0, b1, a0);
        q0.c = new Df.i(m0, a0, new A0.c(q0, 8), new x9.a(a0, u0, Ef.a.m), q0, e.k.A(new Oe.c[]{new Ke.a(m0, a0), new Le.g(m0, a0)}), u0, o3, o4, Ef.a.m.a, l0, u4, 0x40000);
        a0.g = new Pe.z(je.n.z0(new A[]{a0}), 0);
        a0.h = new Pe.l(e.k.A(new Me.H[]{d0, q0}), "CompositeProvider@RuntimeModuleData for " + a0);
        f f3 = new f(i1, new d5.m(e2, b0));
        while(true) {
            WeakReference weakReference1 = (WeakReference)concurrentHashMap0.putIfAbsent(b00, new WeakReference(f3));
            if(weakReference1 == null) {
                return f3;
            }
            f f4 = (f)weakReference1.get();
            if(f4 != null) {
                return f4;
            }
            concurrentHashMap0.remove(b00, weakReference1);
        }
    }
}

