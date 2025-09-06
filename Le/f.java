package Le;

import Me.c;
import Me.z;
import P4.a;
import Pe.w;
import java.util.ArrayList;
import java.util.List;
import je.p;
import kotlin.jvm.internal.q;
import qf.d;
import tf.e;
import we.k;

public final class f implements k {
    public final int a;
    public static final f b;

    static {
        f.b = new f();
    }

    public f() {
        this.a = 0;
        super();
    }

    public f(o o0) {
        this.a = 1;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        boolean z = false;
        if(this.a != 0) {
            if(((c)object0).getKind() == 1) {
                Me.k k0 = ((c)object0).e();
                q.e(k0, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                d d0 = e.g(((Me.e)k0));
                if(Le.d.j.containsKey(d0)) {
                    z = true;
                }
            }
            return Boolean.valueOf(z);
        }
        q.g(((z)object0), "module");
        Iterable iterable0 = (List)a.r(((w)((z)object0).K0(g.f)).e, w.h[0]);
        ArrayList arrayList0 = new ArrayList();
        for(Object object1: iterable0) {
            if(object1 instanceof Ef.c) {
                arrayList0.add(object1);
            }
        }
        return (Ef.c)p.k0(arrayList0);
    }
}

