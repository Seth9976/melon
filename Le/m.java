package Le;

import Af.o;
import Af.p;
import Me.z;
import Pe.C;
import kotlin.jvm.internal.q;
import qf.c;

public final class m extends C {
    public final int g;

    public m(z z0, c c0, int v) {
        this.g = v;
        if(v != 1) {
            super(z0, c0);
            return;
        }
        q.g(z0, "module");
        q.g(c0, "fqName");
        super(z0, c0);
    }

    @Override  // Me.E
    public final p E() {
        return o.b;
    }
}

