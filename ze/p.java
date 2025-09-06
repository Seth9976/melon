package Ze;

import B.a;
import Je.i;
import Me.b;
import Me.c;
import Me.e;
import Me.u;
import Pe.m;
import d5.n;
import kotlin.jvm.internal.q;
import tf.f;

public final class p implements f {
    @Override  // tf.f
    public final int a(b b0, b b1, e e0) {
        q.g(b0, "superDescriptor");
        q.g(b1, "subDescriptor");
        if(b0 instanceof c && b1 instanceof u && !i.A(b1)) {
            qf.e e1 = ((m)(((u)b1))).getName();
            q.f(e1, "getName(...)");
            if(Ze.e.b(e1)) {
            label_9:
                c c0 = a.E(((c)b0));
                u u0 = b0 instanceof u ? ((u)b0) : null;
                if((u0 == null || ((u)b1).H0() != u0.H0()) && (c0 == null || !((u)b1).H0())) {
                    return 2;
                }
                if(e0 instanceof bf.c && ((u)b1).y0() == null && c0 != null && !a.O(e0, c0)) {
                    if(!(c0 instanceof u) || !(b0 instanceof u) || Ze.e.a(((u)c0)) == null) {
                        return 2;
                    }
                    String s = n.q(((u)b1), 2);
                    u u1 = ((u)b0).a();
                    q.f(u1, "getOriginal(...)");
                    if(!q.b(s, n.q(u1, 2))) {
                        return 2;
                    }
                }
            }
            else {
                qf.e e2 = ((m)(((u)b1))).getName();
                q.f(e2, "getName(...)");
                if(E.j.contains(e2)) {
                    goto label_9;
                }
            }
        }
        return y5.a.y(b0, b1) ? 2 : 3;
    }

    @Override  // tf.f
    public final int b() {
        return 1;
    }
}

