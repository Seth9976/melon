package ie;

import java.io.Serializable;
import kotlin.jvm.internal.q;

public final class p implements Serializable {
    public final Object a;

    public p(Object object0) {
        this.a = object0;
    }

    // 去混淆评级： 低(20)
    public static final Throwable a(Object object0) {
        return object0 instanceof o ? ((o)object0).a : null;
    }

    public static final boolean b(Object object0) {
        return object0 instanceof o;
    }

    public static final boolean c(Object object0) {
        return !(object0 instanceof o);
    }

    public final Object d() {
        return this.a;
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof p && q.b(this.a, ((p)object0).a);
    }

    @Override
    public final int hashCode() {
        return this.a == null ? 0 : this.a.hashCode();
    }

    // 去混淆评级： 低(20)
    @Override
    public final String toString() {
        return this.a instanceof o ? ((o)this.a).toString() : "Success(" + this.a + ')';
    }
}

