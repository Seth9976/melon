package kotlin.jvm.internal;

import De.c;
import De.p;
import De.q;
import De.r;

public abstract class w extends B implements r {
    @Override  // kotlin.jvm.internal.e
    public c computeReflected() {
        return I.a.f(this);
    }

    @Override  // De.w
    public p getGetter() {
        return this.getGetter();
    }

    @Override  // De.r
    public q getGetter() {
        return ((r)this.getReflected()).getGetter();
    }

    @Override  // we.a
    public Object invoke() {
        return this.get();
    }
}

