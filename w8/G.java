package w8;

import B2.l;
import B2.n;
import J2.s;
import V4.u;
import a.a;
import androidx.compose.runtime.b0;
import ie.H;
import kc.s2;
import kotlin.jvm.internal.q;
import ob.z;
import we.o;

public final class g implements o {
    public final m a;
    public final boolean b;
    public final z c;
    public final s2 d;
    public final b0 e;
    public final b0 f;

    public g(m m0, boolean z, z z1, s2 s20, b0 b00, b0 b01) {
        this.a = m0;
        this.b = z;
        this.c = z1;
        this.d = s20;
        this.e = b00;
        this.f = b01;
    }

    @Override  // we.o
    public final Object invoke(Object object0, Object object1, Object object2) {
        ((Integer)object2).getClass();
        q.g(((s)object0), "$this$Row");
        a.i(u.J(l.a, 10.0f), ((androidx.compose.runtime.l)object1), 0);
        this.a.i(((androidx.compose.runtime.l)object1), 0);
        a.i(u.J(l.a, 6.0f), ((androidx.compose.runtime.l)object1), 0);
        n n0 = ((s)object0).a(l.a);
        Object object3 = this.e.getValue();
        this.a.w(n0, ((String)object3), this.b, ((androidx.compose.runtime.l)object1), 0);
        boolean z = ((Boolean)this.f.getValue()).booleanValue();
        this.a.x(this.c, this.d, z, this.b, false, ((androidx.compose.runtime.l)object1), 0x6000);
        this.a.j(this.b, ((androidx.compose.runtime.l)object1), 0);
        a.i(u.J(l.a, 6.0f), ((androidx.compose.runtime.l)object1), 0);
        return H.a;
    }
}

