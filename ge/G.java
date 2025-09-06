package Ge;

import java.lang.reflect.Method;
import java.util.List;
import je.n;
import je.p;
import kotlin.jvm.internal.q;
import ye.a;

public final class g extends a {
    public final List m;

    public g(Class class0) {
        q.g(class0, "jClass");
        super();
        Method[] arr_method = class0.getDeclaredMethods();
        q.f(arr_method, "getDeclaredMethods(...)");
        this.m = n.v0(arr_method, new f(0));
    }

    @Override  // ye.a
    public final String s() {
        return p.q0(this.m, "", "<init>(", ")V", b.d, 24);
    }
}

