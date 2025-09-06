package w8;

import B2.l;
import J2.s;
import V4.u;
import a.a;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.p;
import ie.H;
import we.o;

public final class n implements o {
    public final int a;
    public final q b;
    public final boolean c;
    public final b0 d;

    public n(q q0, boolean z, b0 b00, int v) {
        this.a = v;
        this.b = q0;
        this.c = z;
        this.d = b00;
        super();
    }

    @Override  // we.o
    public final Object invoke(Object object0, Object object1, Object object2) {
        p p1;
        p p0;
        ((Integer)object2).getClass();
        if(this.a != 0) {
            kotlin.jvm.internal.q.g(((s)object0), "$this$Row");
            l l0 = l.a;
            a.i(u.J(l0, 18.0f), ((androidx.compose.runtime.l)object1), 0);
            q q0 = this.b;
            q0.i(((androidx.compose.runtime.l)object1), 0);
            if(((Boolean)this.d.getValue()).booleanValue()) {
                p0 = (p)(((androidx.compose.runtime.l)object1));
                p0.a0(0x12C989E8);
                a.i(u.J(l0, 6.0f), p0, 0);
                q0.l(p0, 0);
            }
            else {
                p0 = (p)(((androidx.compose.runtime.l)object1));
                p0.a0(310999040);
            }
            p0.p(false);
            a.i(((s)object0).a(l0), ((androidx.compose.runtime.l)object1), 0);
            q0.j(this.c, ((androidx.compose.runtime.l)object1), 0);
            a.i(u.J(l0, 6.0f), ((androidx.compose.runtime.l)object1), 0);
            return H.a;
        }
        kotlin.jvm.internal.q.g(((s)object0), "$this$Row");
        l l1 = l.a;
        a.i(u.J(l1, 18.0f), ((androidx.compose.runtime.l)object1), 0);
        q q1 = this.b;
        q1.i(((androidx.compose.runtime.l)object1), 0);
        if(((Boolean)this.d.getValue()).booleanValue()) {
            p1 = (p)(((androidx.compose.runtime.l)object1));
            p1.a0(-364072585);
            a.i(u.J(l1, 6.0f), p1, 0);
            q1.l(p1, 0);
        }
        else {
            p1 = (p)(((androidx.compose.runtime.l)object1));
            p1.a0(-370954833);
        }
        p1.p(false);
        a.i(((s)object0).a(l1), ((androidx.compose.runtime.l)object1), 0);
        q1.j(this.c, ((androidx.compose.runtime.l)object1), 0);
        a.i(u.J(l1, 6.0f), ((androidx.compose.runtime.l)object1), 0);
        return H.a;
    }
}

