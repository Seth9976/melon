package m1;

import Q0.W0;
import java.util.ArrayList;
import je.p;
import q1.j;
import r1.k;

public final class o {
    public o a;
    public final q b;
    public final ArrayList c;
    public final W0 d;

    public o(o o0, q q0) {
        this.a = o0;
        this.b = q0;
        ArrayList arrayList0 = new ArrayList(je.q.Q(10, q0.e));
        for(Object object0: q0.e) {
            arrayList0.add(new o(this, ((q)object0)));
        }
        this.c = p.Q0(arrayList0);
        this.d = new W0(new n(this, null));
    }

    public final o a() {
        o o0 = this.a;
        if(o0 == null) {
            return this;
        }
        kotlin.jvm.internal.q.d(o0);
        return o0.a();
    }

    public final q b() {
        q q0 = this.b;
        String s = q0.a;
        int v = q0.b;
        k k0 = q0.c;
        j j0 = q0.d;
        ArrayList arrayList0 = new ArrayList(je.q.Q(10, this.c));
        for(Object object0: this.c) {
            arrayList0.add(((o)object0).b());
        }
        return new q(s, v, k0, j0, arrayList0, q0.f);
    }
}

