package He;

import java.lang.reflect.Method;
import kotlin.jvm.internal.q;

public final class s extends w implements f {
    public s(Method method0) {
        q.g(method0, "method");
        super(method0, false, 4);
    }

    @Override  // He.g
    public final Object call(Object[] arr_object) {
        q.g(arr_object, "args");
        this.d(arr_object);
        return this.f(arr_object, null);
    }
}

