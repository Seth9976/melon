package Ge;

import B.a;
import Se.c;
import Ze.u;
import java.lang.reflect.Field;
import kotlin.jvm.internal.q;

public final class l extends a {
    public final Field e;

    public l(Field field0) {
        q.g(field0, "field");
        super();
        this.e = field0;
    }

    @Override  // B.a
    public final String k() {
        String s = this.e.getName();
        q.f(s, "getName(...)");
        Class class0 = this.e.getType();
        q.f(class0, "getType(...)");
        return u.a(s) + "()" + c.b(class0);
    }
}

