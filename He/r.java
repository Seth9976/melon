package He;

import java.lang.reflect.Method;
import kotlin.jvm.internal.q;

public final class r extends w implements f {
    public final Object f;

    public r(Method method0, Object object0) {
        q.g(method0, "method");
        super(method0, false, 4);
        this.f = object0;
    }

    @Override  // He.g
    public final Object call(Object[] arr_object) {
        q.g(arr_object, "args");
        this.d(arr_object);
        return this.f(arr_object, this.f);
    }
}

