package He;

import Q8.h;
import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Type;
import java.util.Arrays;
import kotlin.jvm.internal.q;

public final class i extends x {
    public final int e;

    public i(Member member0, Type type0, Class class0, Type[] arr_type, int v) {
        this.e = v;
        super(member0, type0, class0, arr_type);
    }

    @Override  // He.g
    public final Object call(Object[] arr_object) {
        if(this.e != 0) {
            q.g(arr_object, "args");
            this.d(arr_object);
            Object[] arr_object1 = Arrays.copyOf(arr_object, arr_object.length);
            return ((Constructor)this.a).newInstance(arr_object1);
        }
        q.g(arr_object, "args");
        this.d(arr_object);
        h h0 = new h(2);
        h0.h(arr_object);
        h0.f(null);
        Object[] arr_object2 = h0.a.toArray(new Object[h0.a.size()]);
        return ((Constructor)this.a).newInstance(arr_object2);
    }
}

