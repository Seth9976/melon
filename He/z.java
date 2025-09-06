package He;

import java.util.Arrays;
import je.n;
import kotlin.jvm.internal.q;

public final class z extends A {
    @Override  // He.g
    public final Object call(Object[] arr_object) {
        q.g(arr_object, "args");
        this.d(arr_object);
        Object object0 = arr_object[0];
        Object[] arr_object1 = arr_object.length > 1 ? n.a0(arr_object, 1, arr_object.length) : new Object[0];
        Object[] arr_object2 = Arrays.copyOf(arr_object1, arr_object1.length);
        return this.a.invoke(object0, arr_object2);
    }
}

