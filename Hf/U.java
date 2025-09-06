package Hf;

import Je.o;
import kotlin.jvm.internal.q;
import qf.c;
import we.k;

public final class u implements k {
    public final int a;
    public static final u b;

    static {
        u.b = new u(0);
    }

    public u(int v) {
        this.a = v;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        if(this.a != 0) {
            if(((c)object0) == null) {
                throw new IllegalArgumentException("Argument for @NotNull parameter \'name\' of kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor$1.invoke must not be null");
            }
            return Boolean.valueOf(!((c)object0).equals(o.y));
        }
        q.g(((x)object0), "it");
        return ((x)object0).toString();
    }
}

