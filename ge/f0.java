package Ge;

import De.p;
import De.u;
import De.v;
import Me.L;
import d3.g;
import ie.j;
import ie.k;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.q;

public class f0 extends m0 implements v {
    public final Object n;

    public f0(F f0, L l0) {
        q.g(l0, "descriptor");
        super(f0, l0);
        d0 d00 = new d0(this, 0);
        this.n = g.P(k.b, d00);
        d0 d01 = new d0(this, 1);
        g.P(k.b, d01);
    }

    public f0(F f0, String s, String s1) {
        q.g(f0, "container");
        q.g(s, "name");
        q.g(s1, "signature");
        super(f0, s, s1, e.NO_RECEIVER);
        d0 d00 = new d0(this, 0);
        this.n = g.P(k.b, d00);
        d0 d01 = new d0(this, 1);
        g.P(k.b, d01);
    }

    @Override  // De.w
    public final p getGetter() {
        return (e0)((j)this.n).getValue();
    }

    @Override  // De.v
    public final u getGetter() {
        return (e0)((j)this.n).getValue();
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((e0)((j)this.n).getValue()).call(new Object[]{object0, object1});
    }

    @Override  // Ge.m0
    public final j0 u() {
        return (e0)((j)this.n).getValue();
    }
}

