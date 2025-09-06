package Ge;

import java.lang.reflect.Constructor;
import je.n;
import kotlin.jvm.internal.q;
import ye.a;

public final class h extends a {
    public final Constructor m;

    public h(Constructor constructor0) {
        q.g(constructor0, "constructor");
        super();
        this.m = constructor0;
    }

    @Override  // ye.a
    public final String s() {
        Class[] arr_class = this.m.getParameterTypes();
        q.f(arr_class, "getParameterTypes(...)");
        return n.r0(arr_class, "", "<init>(", ")V", b.e, 24);
    }
}

