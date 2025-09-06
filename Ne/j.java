package Ne;

import Af.g;
import Hf.x;
import Je.i;
import Me.N;
import ie.k;
import java.util.Map;
import kotlin.jvm.internal.q;
import qf.c;

public final class j implements b {
    public final i a;
    public final c b;
    public final Map c;
    public final Object d;

    public j(i i0, c c0, Map map0) {
        q.g(i0, "builtIns");
        q.g(c0, "fqName");
        super();
        this.a = i0;
        this.b = c0;
        this.c = map0;
        g g0 = new g(this, 21);
        this.d = d3.g.P(k.b, g0);
    }

    @Override  // Ne.b
    public final Map a() {
        return this.c;
    }

    @Override  // Ne.b
    public final c b() {
        return this.b;
    }

    @Override  // Ne.b
    public final N getSource() {
        return N.q;
    }

    @Override  // Ne.b
    public final x getType() {
        Object object0 = ((ie.j)this.d).getValue();
        q.f(object0, "getValue(...)");
        return (x)object0;
    }
}

