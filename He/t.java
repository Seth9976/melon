package He;

import Q8.h;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import je.n;
import kotlin.jvm.internal.q;

public final class t extends w implements f {
    public final boolean f;
    public final Object g;

    public t(Method method0, boolean z, Object object0) {
        q.g(method0, "method");
        Type[] arr_type = method0.getGenericParameterTypes();
        q.f(arr_type, "getGenericParameterTypes(...)");
        Type[] arr_type1 = arr_type.length <= 1 ? new Type[0] : n.a0(arr_type, 1, arr_type.length);
        super(method0, false, arr_type1);
        this.f = z;
        this.g = object0;
    }

    @Override  // He.g
    public final Object call(Object[] arr_object) {
        q.g(arr_object, "args");
        this.d(arr_object);
        h h0 = new h(2);
        h0.f(this.g);
        h0.h(arr_object);
        return this.f(h0.a.toArray(new Object[h0.a.size()]), null);
    }
}

