package qf;

import Tf.o;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.jvm.internal.q;

public final class d {
    public final String a;
    public transient c b;
    public transient d c;
    public transient e d;
    public static final e e;

    static {
        d.e = e.g("<root>");
        q.f(Pattern.compile("\\."), "compile(...)");
    }

    public d(String s) {
        this.a = s;
    }

    public d(String s, c c0) {
        q.g(s, "fqName");
        super();
        this.a = s;
        this.b = c0;
    }

    public d(String s, d d0, e e0) {
        this.a = s;
        this.c = d0;
        this.d = e0;
    }

    public final d a(e e0) {
        q.g(e0, "name");
        String s = this.c() ? e0.b() : this.a + '.' + e0.b();
        q.d(s);
        return new d(s, this, e0);
    }

    public final void b() {
        String s = this.a;
        int v = s.length() - 1;
        int v1 = 0;
        while(true) {
            if(v < 0) {
                v = -1;
                break;
            }
            int v2 = s.charAt(v);
            if(v2 == 46 && v1 == 0) {
                break;
            }
            switch(v2) {
                case 92: {
                    --v;
                    break;
                }
                case 0x60: {
                    v1 ^= 1;
                }
            }
            --v;
        }
        if(v >= 0) {
            String s1 = s.substring(v + 1);
            q.f(s1, "substring(...)");
            this.d = e.d(s1);
            String s2 = s.substring(0, v);
            q.f(s2, "substring(...)");
            this.c = new d(s2);
            return;
        }
        this.d = e.d(s);
        this.c = c.c.a;
    }

    public final boolean c() {
        return this.a.length() == 0;
    }

    public final boolean d() {
        return this.b != null || o.E0(this.a, '<', 0, 6) < 0;
    }

    public static final List e(d d0) {
        if(d0.c()) {
            return new ArrayList();
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
        List list0 = d.e(d1);
        list0.add(d0.f());
        return list0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof d ? q.b(this.a, ((d)object0).a) : false;
    }

    public final e f() {
        e e0 = this.d;
        if(e0 != null) {
            return e0;
        }
        if(this.c()) {
            throw new IllegalStateException("root");
        }
        this.b();
        e e1 = this.d;
        q.d(e1);
        return e1;
    }

    public final c g() {
        c c0 = this.b;
        if(c0 == null) {
            c0 = new c(this);
            this.b = c0;
        }
        return c0;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        if(this.c()) {
            q.f("<root>", "asString(...)");
            return "<root>";
        }
        return this.a;
    }
}

