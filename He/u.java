package He;

import Q8.h;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import je.n;
import kotlin.jvm.internal.q;

public final class u extends w implements f {
    public final Object[] f;

    public u(Method method0, Object[] arr_object) {
        q.g(method0, "method");
        q.g(arr_object, "boundReceiverComponents");
        Type[] arr_type = method0.getGenericParameterTypes();
        q.f(arr_type, "getGenericParameterTypes(...)");
        super(method0, false, ((Type[])n.b0(arr_object.length, arr_type).toArray(new Type[0])));
        this.f = arr_object;
    }

    @Override  // He.g
    public final Object call(Object[] arr_object) {
        q.g(arr_object, "args");
        this.d(arr_object);
        h h0 = new h(2);
        h0.h(this.f);
        h0.h(arr_object);
        return this.f(h0.a.toArray(new Object[h0.a.size()]), null);
    }
}

