package Ze;

import Hf.V;
import Hf.x;
import Me.b;
import Me.e;
import Pe.L;
import Pe.u;
import Q0.W0;
import Sf.h;
import Sf.n;
import Sf.t;
import java.util.List;
import je.p;
import k8.Y;
import kotlin.jvm.internal.q;
import tf.f;
import tf.j;
import tf.k;

public final class i implements f {
    @Override  // tf.f
    public final int a(b b0, b b1, e e0) {
        q.g(b0, "superDescriptor");
        q.g(b1, "subDescriptor");
        if(b1 instanceof bf.f && ((bf.f)b1).getTypeParameters().isEmpty()) {
            j j0 = k.i(b0, b1);
            if((j0 == null ? 0 : j0.b()) == 0) {
                List list0 = ((bf.f)b1).F();
                q.f(list0, "getValueParameters(...)");
                t t0 = n.n0(p.c0(list0), d.e);
                x x0 = ((bf.f)b1).g;
                q.d(x0);
                h h0 = n.j0(je.n.O(new Sf.k[]{t0, new W0(x0, 3)}));
                u u0 = ((bf.f)b1).i;
                Sf.f f0 = new Sf.f(n.j0(je.n.O(new Sf.k[]{h0, p.c0(e.k.B((u0 == null ? null : u0.getType())))})));
                while(f0.hasNext()) {
                    x x1 = (x)f0.next();
                    if(!x1.r().isEmpty() && !(x1.I() instanceof ef.h)) {
                        return 3;
                    }
                    if(false) {
                        break;
                    }
                }
                b b2 = (b)b0.c(new V(new ef.f()));
                if(b2 != null) {
                    if(b2 instanceof L && !((L)b2).getTypeParameters().isEmpty()) {
                        b2 = ((L)b2).N0().g().build();
                        q.d(b2);
                    }
                    int v = k.c.n(b2, b1, false).b();
                    Y.A(v, "getResult(...)");
                    return Ze.h.a[e0.b.b(v)] == 1 ? 1 : 3;
                }
            }
        }
        return 3;
    }

    @Override  // tf.f
    public final int b() {
        return 2;
    }
}

