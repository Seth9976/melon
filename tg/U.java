package tg;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class u {
    public final Class a;
    public final Object b;
    public final Method c;
    public final List d;

    public u(Class class0, Object object0, Method method0, ArrayList arrayList0) {
        this.a = class0;
        this.b = object0;
        this.c = method0;
        this.d = Collections.unmodifiableList(arrayList0);
    }

    @Override
    public final String toString() {
        String s = this.c.getName();
        return String.format("%s.%s() %s", this.a.getName(), s, this.d);
    }
}

