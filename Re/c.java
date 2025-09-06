package Re;

import A7.a;
import Tf.v;
import kotlin.jvm.internal.q;

public final class c {
    public final Class a;
    public final a b;

    public c(Class class0, a a0) {
        this.a = class0;
        this.b = a0;
    }

    public final String a() {
        return v.o0(this.a.getName(), '.', '/') + ".class";
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof c && q.b(this.a, ((c)object0).a);
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    // 去混淆评级： 低(40)
    @Override
    public final String toString() {
        return "Re.c: " + this.a;
    }
}

