package Ge;

import H0.e;
import java.lang.reflect.Method;
import kotlin.jvm.internal.q;
import ye.a;

public final class i extends a {
    public final Method m;

    public i(Method method0) {
        q.g(method0, "method");
        super();
        this.m = method0;
    }

    @Override  // ye.a
    public final String s() {
        return e.r(this.m);
    }
}

