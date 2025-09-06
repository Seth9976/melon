package n1;

import G.j0;
import G.u;
import androidx.compose.runtime.O0;
import ie.H;
import kotlin.jvm.internal.r;
import we.k;

public final class l extends r implements k {
    public final f f;
    public final q g;

    public l(f f0, q q0) {
        this.f = f0;
        this.g = q0;
        super(1);
    }

    public final void d() {
        a a0 = !a.e || this.f.a.d() == null ? null : new a(this.f.a, this.f.b, this.f.c);
        q q0 = this.g;
        if(a0 != null) {
            o1.a a1 = new o1.a();
            Object object0 = a0.c.d();
            Object object1 = a0.c.d();
            a1.b = ((O0)a0.a.a).getValue();
            Object object2 = a0.c.a.b.invoke(a0.c.c.c);
            Object object3 = a0.c.a.a.invoke(object2);
            a1.c = new j0(a0.b, a0.c.a, object0, object1, ((u)object3));
            q0.c.put(a0, a1);
            return;
        }
        q0.a();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        this.d();
        return H.a;
    }
}

