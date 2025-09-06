package qf;

import Tf.o;
import Tf.v;
import kotlin.jvm.internal.q;

public final class c {
    public final d a;
    public transient c b;
    public static final c c;

    static {
        c.c = new c("");
    }

    public c(String s) {
        q.g(s, "fqName");
        super();
        this.a = new d(s, this);
    }

    public c(d d0) {
        this.a = d0;
    }

    public c(d d0, c c0) {
        this.a = d0;
        this.b = c0;
    }

    public final c a(e e0) {
        q.g(e0, "name");
        return new c(this.a.a(e0), this);
    }

    public final c b() {
        c c0 = this.b;
        if(c0 != null) {
            return c0;
        }
        d d0 = this.a;
        if(d0.c()) {
            throw new IllegalStateException("root");
        }
        d d1 = d0.c;
        if(d1 == null) {
            if(d0.c()) {
                throw new IllegalStateException("root");
            }
            d0.b();
            d1 = d0.c;
            q.d(d1);
        }
        c c1 = new c(d1);
        this.b = c1;
        return c1;
    }

    public final boolean c(e e0) {
        q.g(e0, "segment");
        d d0 = this.a;
        d0.getClass();
        String s = d0.a;
        if(!d0.c()) {
            int v = o.E0(s, '.', 0, 6);
            if(v == -1) {
                v = s.length();
            }
            String s1 = e0.b();
            q.f(s1, "asString(...)");
            return v == s1.length() && v.m0(0, 0, v, d0.a, s1, false);
        }
        return false;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof c ? q.b(this.a, ((c)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.a.hashCode();
    }

    @Override
    public final String toString() {
        return this.a.toString();
    }
}

