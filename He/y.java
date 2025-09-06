package He;

import java.lang.reflect.Method;
import java.util.Arrays;
import je.w;
import kotlin.jvm.internal.q;

public final class y extends A implements f {
    public final Object d;

    public y(Method method0, Object object0) {
        super(method0, w.a);
        this.d = object0;
    }

    @Override  // He.g
    public final Object call(Object[] arr_object) {
        q.g(arr_object, "args");
        this.d(arr_object);
        Object[] arr_object1 = Arrays.copyOf(arr_object, arr_object.length);
        return this.a.invoke(this.d, arr_object1);
    }
}

