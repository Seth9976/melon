package kotlin.jvm.internal;

import De.c;
import De.p;
import De.u;
import De.v;
import Ge.s;

public final class A extends B implements v {
    @Override  // kotlin.jvm.internal.e
    public final c computeReflected() {
        return I.a.h(this);
    }

    @Override  // De.w
    public final p getGetter() {
        return this.getGetter();
    }

    @Override  // De.v
    public final u getGetter() {
        return ((v)this.getReflected()).getGetter();
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((s)this.getGetter()).call(new Object[]{object0, object1});
    }
}

