package w8;

import B2.l;
import J2.i;
import U4.F;
import V4.u;
import a.a;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.p;
import cd.W1;
import ie.H;
import kc.s2;
import kotlin.jvm.internal.q;
import m0.c;
import ob.z;
import we.o;

public final class x implements o {
    public final boolean a;
    public final A b;
    public final z c;
    public final s2 d;
    public final boolean e;
    public final b0 f;
    public final b0 g;
    public final b0 h;
    public final b0 i;

    public x(boolean z, A a0, z z1, s2 s20, boolean z2, b0 b00, b0 b01, b0 b02, b0 b03) {
        this.a = z;
        this.b = a0;
        this.c = z1;
        this.d = s20;
        this.e = z2;
        this.f = b00;
        this.g = b01;
        this.h = b02;
        this.i = b03;
    }

    @Override  // we.o
    public final Object invoke(Object object0, Object object1, Object object2) {
        ((Integer)object2).getClass();
        q.g(((i)object0), "$this$Column");
        l l0 = l.a;
        boolean z = this.a;
        if(z) {
            ((p)(((androidx.compose.runtime.l)object1))).a0(0xA71ECAC3);
            a.i(u.w(l0, 10.0f), ((p)(((androidx.compose.runtime.l)object1))), 0);
        }
        else {
            ((p)(((androidx.compose.runtime.l)object1))).a0(0xA6CEDBFA);
        }
        ((p)(((androidx.compose.runtime.l)object1))).p(false);
        F.f(u.o(l0), 0, 1, c.e(0x5239FDCC, ((androidx.compose.runtime.l)object1), new W1(this.b, this.e, this.f, 3)), ((androidx.compose.runtime.l)object1), 0xC00, 2);
        boolean z1 = ((Boolean)this.g.getValue()).booleanValue();
        boolean z2 = ((Boolean)this.h.getValue()).booleanValue();
        boolean z3 = ((Boolean)this.i.getValue()).booleanValue();
        this.b.x(z1, z2, this.c, this.d, z3, this.e, true, z, ((androidx.compose.runtime.l)object1), 0x180000, 0);
        return H.a;
    }
}

