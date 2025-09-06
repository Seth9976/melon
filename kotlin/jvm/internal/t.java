package kotlin.jvm.internal;

import De.c;
import De.h;
import De.k;
import De.l;
import De.p;
import Ge.s;

public class t extends u implements l {
    public t(Class class0, String s, String s1, int v) {
        super(e.NO_RECEIVER, class0, s, s1, v);
    }

    @Override  // De.l
    public void a(Object object0, Object object1) {
        ((s)this.b()).call(new Object[]{object0, object1});
    }

    @Override  // De.m
    public final h b() {
        return this.b();
    }

    @Override  // De.l
    public final k b() {
        return ((l)this.getReflected()).b();
    }

    @Override  // kotlin.jvm.internal.e
    public final c computeReflected() {
        return I.a.e(this);
    }

    @Override  // De.t
    public Object get(Object object0) {
        return ((s)this.getGetter()).call(new Object[]{object0});
    }

    @Override  // De.t
    public final Object getDelegate(Object object0) {
        return ((l)this.getReflected()).getDelegate(object0);
    }

    @Override  // De.w
    public final p getGetter() {
        return this.getGetter();
    }

    @Override  // De.t
    public final De.s getGetter() {
        return ((l)this.getReflected()).getGetter();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        return this.get(object0);
    }
}

