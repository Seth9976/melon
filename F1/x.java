package f1;

import A7.d;
import a1.T;
import a1.g;
import a1.t;
import d5.l;
import kotlin.jvm.internal.q;

public final class x {
    public final g a;
    public final long b;
    public final T c;
    public static final l d;

    static {
        x.d = new l(13, w.f, b.i);
    }

    public x(g g0, long v, T t0) {
        this.a = g0;
        this.b = t.c(g0.b.length(), v);
        this.c = t0 == null ? null : new T(t.c(g0.b.length(), t0.a));
    }

    public x(String s, long v, int v1) {
        if((v1 & 1) != 0) {
            s = "";
        }
        if((v1 & 2) != 0) {
            v = T.b;
        }
        this(new g(s), v, null);
    }

    public static x a(x x0, g g0, long v, int v1) {
        if((v1 & 1) != 0) {
            g0 = x0.a;
        }
        if((v1 & 2) != 0) {
            v = x0.b;
        }
        x0.getClass();
        return new x(g0, v, ((v1 & 4) == 0 ? null : x0.c));
    }

    public static x b(x x0, String s) {
        x0.getClass();
        return new x(new g(s), x0.b, x0.c);
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof x ? T.a(this.b, ((x)object0).b) && q.b(this.c, ((x)object0).c) && q.b(this.a, ((x)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        int v = d.c(this.a.hashCode() * 0x1F, 0x1F, this.b);
        return this.c == null ? v : v + Long.hashCode(this.c.a);
    }

    @Override
    public final String toString() {
        return "TextFieldValue(text=\'" + this.a + "\', selection=" + T.g(this.b) + ", composition=" + this.c + ')';
    }
}

