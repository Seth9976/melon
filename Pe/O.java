package Pe;

import Ue.c;
import java.util.Collection;
import qf.e;
import we.k;

public final class o implements k {
    public final int a;
    public final p b;

    public o(p p0, int v) {
        this.a = v;
        this.b = p0;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        if(this.a != 0) {
            if(((e)object0) != null) {
                Collection collection0 = this.b.i().b(((e)object0), c.f);
                return this.b.j(((e)object0), collection0);
            }
            p.h(4);
            throw null;
        }
        if(((e)object0) != null) {
            Collection collection1 = this.b.i().f(((e)object0), c.f);
            return this.b.j(((e)object0), collection1);
        }
        p.h(8);
        throw null;
    }
}

