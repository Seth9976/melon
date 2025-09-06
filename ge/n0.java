package Ge;

import Se.c;
import java.lang.reflect.Type;
import kotlin.jvm.internal.q;
import we.a;

public final class n0 implements a {
    public final int a;
    public final p0 b;

    public n0(p0 p00, int v) {
        this.a = v;
        this.b = p00;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        if(this.a != 0) {
            u0 u00 = this.b.b;
            Type type0 = u00 == null ? null : ((Type)u00.invoke());
            q.d(type0);
            return c.c(type0);
        }
        return this.b.c(this.b.a);
    }
}

