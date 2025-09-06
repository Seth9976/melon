package If;

import Hf.B;
import Hf.L;
import Hf.V;
import Hf.b0;
import Hf.c;
import Hf.x;
import Kf.d;
import Kf.e;
import kotlin.jvm.internal.q;

public final class a extends c {
    public final b a;
    public final V b;

    public a(b b0, V v0) {
        this.a = b0;
        this.b = v0;
    }

    @Override  // Hf.c
    public final e D(L l0, d d0) {
        q.g(l0, "state");
        q.g(d0, "type");
        B b0 = this.a.k0(d0);
        x x0 = this.b.g(b0, b0.c);
        e e0 = this.a.A(x0);
        q.d(e0);
        return e0;
    }
}

