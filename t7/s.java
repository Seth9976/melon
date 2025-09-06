package T7;

import J0.h;
import java.lang.reflect.Method;

public final class s extends u {
    public final Method b;

    public s(Method method0) {
        this.b = method0;
    }

    @Override  // T7.u
    public final Object a(Class class0) {
        String s = h.h(class0);
        if(s != null) {
            throw new AssertionError("UnsafeAllocator is used for non-instantiable type: " + s);
        }
        return this.b.invoke(null, class0, Object.class);
    }
}

