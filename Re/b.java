package Re;

import Tf.v;
import V4.u;
import a.a;
import i.n.i.b.a.s.e.Ga;
import kotlin.jvm.internal.q;
import nf.e;
import qf.c;

public final class b {
    public final ClassLoader a;

    public b(ClassLoader classLoader0) {
        this.a = classLoader0;
        super();
    }

    public Ga a(qf.b b0, e e0) {
        q.g(b0, "classId");
        q.g(e0, "metadataVersion");
        String s = v.o0(b0.b.a.a, '.', '$');
        c c0 = b0.a;
        if(!c0.a.c()) {
            s = c0 + '.' + s;
        }
        Class class0 = u.I(this.a, s);
        if(class0 != null) {
            Re.c c1 = a.q(class0);
            return c1 == null ? null : new Ga(c1, 19);
        }
        return null;
    }
}

