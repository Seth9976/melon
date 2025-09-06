package T7;

import J0.h;
import java.lang.reflect.Method;

public final class q extends u {
    public final Method b;
    public final Object c;

    public q(Method method0, Object object0) {
        this.b = method0;
        this.c = object0;
    }

    @Override  // T7.u
    public final Object a(Class class0) {
        String s = h.h(class0);
        if(s != null) {
            throw new AssertionError("UnsafeAllocator is used for non-instantiable type: " + s);
        }
        return this.b.invoke(this.c, class0);
    }
}

