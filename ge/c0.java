package Ge;

import De.p;
import De.s;
import De.t;
import Me.L;
import d3.g;
import ie.j;
import ie.k;
import java.lang.reflect.Member;
import kotlin.jvm.internal.q;

public class c0 extends m0 implements t {
    public final Object n;
    public final Object o;

    public c0(F f0, L l0) {
        q.g(l0, "descriptor");
        super(f0, l0);
        a0 a00 = new a0(this, 0);
        this.n = g.P(k.b, a00);
        a0 a01 = new a0(this, 1);
        this.o = g.P(k.b, a01);
    }

    public c0(F f0, String s, String s1, Object object0) {
        q.g(f0, "container");
        q.g(s, "name");
        q.g(s1, "signature");
        super(f0, s, s1, object0);
        a0 a00 = new a0(this, 0);
        this.n = g.P(k.b, a00);
        a0 a01 = new a0(this, 1);
        this.o = g.P(k.b, a01);
    }

    @Override  // De.t
    public final Object get(Object object0) {
        return ((b0)((j)this.n).getValue()).call(new Object[]{object0});
    }

    @Override  // De.t
    public final Object getDelegate(Object object0) {
        return this.s(((Member)((j)this.o).getValue()), object0);
    }

    @Override  // De.w
    public final p getGetter() {
        return (b0)((j)this.n).getValue();
    }

    @Override  // De.t
    public final s getGetter() {
        return (b0)((j)this.n).getValue();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        return this.get(object0);
    }

    @Override  // Ge.m0
    public final j0 u() {
        return (b0)((j)this.n).getValue();
    }
}

