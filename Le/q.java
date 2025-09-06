package Le;

import Ac.q0;
import Df.i;
import Ef.a;
import Ef.d;
import Gf.j;
import Gf.m;
import Je.p;
import Me.E;
import Me.H;
import Pe.A;
import Qf.k;
import Re.b;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import je.y;
import qf.c;

public final class q implements H {
    public final m a;
    public final A b;
    public i c;
    public final j d;

    public q(m m0, b b0, A a0) {
        this.a = m0;
        this.b = a0;
        this.d = m0.c(new q0(this, 2));
    }

    @Override  // Me.H
    public final void a(c c0, ArrayList arrayList0) {
        kotlin.jvm.internal.q.g(c0, "fqName");
        k.a(arrayList0, this.d.invoke(c0));
    }

    @Override  // Me.H
    public final boolean b(c c0) {
        kotlin.jvm.internal.q.g(c0, "fqName");
        Object object0 = ((ConcurrentHashMap)this.d.c).get(c0);
        return object0 == null || object0 == Gf.k.b ? this.c(c0) == null : ((E)this.d.invoke(c0)) == null;
    }

    public final Ef.c c(c c0) {
        kotlin.jvm.internal.q.g(c0, "fqName");
        if(!c0.c(p.k)) {
            return null;
        }
        a.m.getClass();
        InputStream inputStream0 = d.a(a.a(c0));
        return inputStream0 == null ? null : y5.a.w(c0, this.a, this.b, inputStream0);
    }

    @Override  // Me.H
    public final Collection l(c c0, we.k k0) {
        kotlin.jvm.internal.q.g(c0, "fqName");
        return y.a;
    }
}

