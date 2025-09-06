package cf;

import Ac.q0;
import Gf.j;
import Gf.m;
import Je.o;
import Ne.h;
import Q0.W0;
import Se.d;
import Sf.g;
import Sf.k;
import Sf.n;
import com.google.firebase.messaging.u;
import d5.f;
import gf.b;
import java.util.Iterator;
import je.p;
import kotlin.jvm.internal.q;

public final class c implements h {
    public final u a;
    public final b b;
    public final boolean c;
    public final j d;

    public c(u u0, b b0, boolean z) {
        q.g(u0, "c");
        q.g(b0, "annotationOwner");
        super();
        this.a = u0;
        this.b = b0;
        this.c = z;
        this.d = ((m)((a)u0.a).a).c(new q0(this, 19));
    }

    @Override  // Ne.h
    public final boolean c(qf.c c0) {
        return f.I(this, c0);
    }

    @Override  // Ne.h
    public final Ne.b e0(qf.c c0) {
        q.g(c0, "fqName");
        b b0 = this.b;
        d d0 = b0.a(c0);
        if(d0 != null) {
            Ne.b b1 = (Ne.b)this.d.invoke(d0);
            if(b1 != null) {
                return b1;
            }
        }
        return af.c.a(c0, b0, this.a);
    }

    @Override  // Ne.h
    public final boolean isEmpty() {
        return this.b.getAnnotations().isEmpty();
    }

    @Override
    public final Iterator iterator() {
        return new Sf.f(new g(n.j0(je.n.O(new k[]{n.n0(p.c0(this.b.getAnnotations()), this.d), new W0(af.c.a(o.m, this.b, this.a), 3)})), false, new Ma.k(12)));
    }
}

