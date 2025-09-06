package Se;

import gf.b;
import java.util.Collection;
import je.w;
import kotlin.jvm.internal.q;
import qf.c;

public final class x extends r implements b {
    public final c a;

    public x(c c0) {
        q.g(c0, "fqName");
        super();
        this.a = c0;
    }

    @Override  // gf.b
    public final d a(c c0) {
        q.g(c0, "fqName");
        return null;
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof x && q.b(this.a, ((x)object0).a);
    }

    @Override  // gf.b
    public final Collection getAnnotations() {
        return w.a;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    // 去混淆评级： 低(40)
    @Override
    public final String toString() {
        return "Se.x: " + this.a;
    }
}

