package n1;

import G.j0;
import G.t0;
import G.x;
import Ic.h;
import P0.d0;
import Q0.n;
import androidx.compose.foundation.w;
import ie.H;
import kotlin.jvm.internal.r;
import we.k;

public final class j extends r implements k {
    public final int f;
    public final d0 g;

    public j(d0 d00, int v) {
        this.f = v;
        this.g = d00;
        super(1);
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        switch(this.f) {
            case 0: {
                q q1 = (q)((n)this.g.b).get();
                q1.getClass();
                l l0 = new l(((f)object0), q1);
                q1.b(((f)object0).a, l0);
                return H.a;
            }
            case 1: {
                q q2 = (q)((n)this.g.b).get();
                q2.getClass();
                q2.b(((t0)object0), new m(((t0)object0), q2));
                return H.a;
            }
            case 2: {
                q q3 = (q)((n)this.g.b).get();
                h h0 = (h)this.g.c;
                q3.getClass();
                if(((t0)object0).c() instanceof Boolean) {
                    q3.b(((t0)object0), new n1.n(((t0)object0), h0, q3));
                }
                return H.a;
            }
            case 3: {
                q q4 = (q)((n)this.g.b).get();
                q4.getClass();
                o o0 = new o(((n1.h)object0), q4);
                q4.b(((n1.h)object0).a, o0);
                return H.a;
            }
            case 4: {
                q q5 = (q)((n)this.g.b).get();
                q5.getClass();
                q5.b(((t0)object0), new p(((t0)object0), q5));
                return H.a;
            }
            case 5: {
                q q6 = (q)((n)this.g.b).get();
                q6.getClass();
                q6.b(object0, new w(16, q6, "animateContentSize"));
                return H.a;
            }
            case 6: {
                q q7 = (q)((n)this.g.b).get();
                q7.getClass();
                q7.b(((j0)object0), new w(16, q7, "TargetBasedAnimation"));
                return H.a;
            }
            default: {
                q q0 = (q)((n)this.g.b).get();
                q0.getClass();
                q0.b(((x)object0), new w(16, q0, "DecayAnimation"));
                return H.a;
            }
        }
    }
}

