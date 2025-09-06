package Ge;

import B.a;
import H0.e;
import java.lang.reflect.Method;
import kotlin.jvm.internal.q;

public final class m extends a {
    public final Method e;
    public final Method f;

    public m(Method method0, Method method1) {
        q.g(method0, "getterMethod");
        super();
        this.e = method0;
        this.f = method1;
    }

    @Override  // B.a
    public final String k() {
        return e.r(this.e);
    }
}

