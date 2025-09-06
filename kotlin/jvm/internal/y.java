package kotlin.jvm.internal;

import De.c;
import De.p;
import De.s;
import De.t;

public abstract class y extends B implements t {
    @Override  // kotlin.jvm.internal.e
    public c computeReflected() {
        return I.a.g(this);
    }

    @Override  // De.t
    public Object getDelegate(Object object0) {
        return ((t)this.getReflected()).getDelegate(object0);
    }

    @Override  // De.w
    public p getGetter() {
        return this.getGetter();
    }

    @Override  // De.t
    public s getGetter() {
        return ((t)this.getReflected()).getGetter();
    }

    @Override  // we.k
    public Object invoke(Object object0) {
        return this.get(object0);
    }
}

