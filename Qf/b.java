package qf;

import Tf.o;
import Tf.v;
import d5.n;
import kotlin.jvm.internal.q;

public final class b {
    public final c a;
    public final c b;
    public final boolean c;

    public b(c c0, c c1, boolean z) {
        q.g(c0, "packageFqName");
        q.g(c1, "relativeClassName");
        super();
        this.a = c0;
        this.b = c1;
        this.c = z;
        c1.a.c();
    }

    public b(c c0, e e0) {
        q.g(c0, "packageFqName");
        q.g(e0, "topLevelName");
        this(c0, n.E(e0), false);
    }

    // 去混淆评级： 低(20)
    public final c a() {
        return this.a.a.c() ? this.b : new c(this.a.a.a + '.' + this.b.a.a);
    }

    // 去混淆评级： 低(20)
    public final String b() {
        return this.a.a.c() ? b.c(this.b) : v.o0(this.a.a.a, '.', '/') + "/" + b.c(this.b);
    }

    public static final String c(c c0) {
        String s = c0.a.a;
        return o.w0(s, '/') ? "`" + s + '`' : s;
    }

    public final b d(e e0) {
        q.g(e0, "name");
        c c0 = this.b.a(e0);
        return new b(this.a, c0, this.c);
    }

    public final b e() {
        c c0 = this.b.b();
        return c0.a.c() ? null : new b(this.a, c0, this.c);
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof b)) {
            return false;
        }
        if(!q.b(this.a, ((b)object0).a)) {
            return false;
        }
        return q.b(this.b, ((b)object0).b) ? this.c == ((b)object0).c : false;
    }

    public final e f() {
        return this.b.a.f();
    }

    public final boolean g() {
        return !this.b.b().a.c();
    }

    @Override
    public final int hashCode() {
        return Boolean.hashCode(this.c) + (this.b.hashCode() + this.a.hashCode() * 0x1F) * 0x1F;
    }

    // 去混淆评级： 低(20)
    @Override
    public final String toString() {
        return this.a.a.c() ? "/" + this.b() : this.b();
    }
}

