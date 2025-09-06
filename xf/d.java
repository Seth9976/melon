package xf;

import If.g;
import Je.i;
import Le.n;
import Me.E;
import Me.K;
import Me.h;
import Me.l;
import Me.z;
import Ne.b;
import Pe.C;
import Pe.G;
import Pe.S;
import Qf.k;
import Sf.r;
import java.util.Collection;
import je.p;
import kotlin.jvm.internal.H;
import kotlin.jvm.internal.q;
import qf.e;

public abstract class d {
    public static final int a;

    static {
        e.e("value");
    }

    public static final boolean a(S s0) {
        Boolean boolean0 = k.h(e.k.z(s0), a.b, c.b);
        q.f(boolean0, "ifAny(...)");
        return boolean0.booleanValue();
    }

    public static Me.c b(Me.c c0, we.k k0) {
        q.g(c0, "<this>");
        H h0 = new H();  // 初始化器: Ljava/lang/Object;-><init>()V
        return (Me.c)k.f(e.k.z(c0), new a(1), new n(h0, k0));
    }

    public static final qf.c c(l l0) {
        q.g(l0, "<this>");
        qf.d d0 = d.h(l0);
        if(!d0.d()) {
            d0 = null;
        }
        return d0 == null ? null : d0.g();
    }

    public static final Me.e d(b b0) {
        q.g(b0, "<this>");
        h h0 = b0.getType().w().e();
        return h0 instanceof Me.e ? ((Me.e)h0) : null;
    }

    public static final i e(Me.k k0) {
        q.g(k0, "<this>");
        return d.j(k0).d();
    }

    public static final qf.b f(h h0) {
        if(h0 != null) {
            Me.k k0 = h0.e();
            if(k0 != null) {
                if(k0 instanceof E) {
                    e e0 = h0.getName();
                    q.f(e0, "getName(...)");
                    return new qf.b(((C)(((E)k0))).e, e0);
                }
                if(k0 instanceof Me.i) {
                    qf.b b0 = d.f(((h)k0));
                    if(b0 != null) {
                        e e1 = h0.getName();
                        q.f(e1, "getName(...)");
                        return b0.d(e1);
                    }
                }
            }
        }
        return null;
    }

    public static final qf.c g(Me.k k0) {
        q.g(k0, "<this>");
        qf.c c0 = tf.e.h(k0);
        return c0 == null ? tf.e.g(k0.e()).a(k0.getName()).g() : c0;
    }

    public static final qf.d h(Me.k k0) {
        q.g(k0, "<this>");
        qf.d d0 = tf.e.g(k0);
        q.f(d0, "getFqName(...)");
        return d0;
    }

    public static final void i(z z0) {
        q.g(z0, "<this>");
        if(z0.L0(g.a) != null) {
            throw new ClassCastException();
        }
    }

    public static final z j(Me.k k0) {
        q.g(k0, "<this>");
        z z0 = tf.e.d(k0);
        q.f(z0, "getContainingModule(...)");
        return z0;
    }

    public static final Me.c k(Me.c c0) {
        q.g(c0, "<this>");
        if(c0 instanceof K) {
            c0 = ((G)(((K)c0))).t1();
            q.f(c0, "getCorrespondingProperty(...)");
        }
        return c0;
    }

    public static final Sf.h l(Me.c c0) {
        q.g(c0, "<this>");
        Sf.k k0 = je.n.O(new Me.c[]{c0});
        Collection collection0 = c0.f();
        q.f(collection0, "getOverriddenDescriptors(...)");
        return Sf.n.j0(je.n.O(new Sf.k[]{k0, new Sf.h(p.c0(collection0), new xf.b(1), r.b)}));
    }
}

