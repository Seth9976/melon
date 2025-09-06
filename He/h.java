package He;

import java.lang.reflect.Constructor;
import java.lang.reflect.Type;
import je.n;
import kotlin.jvm.internal.q;

public final class h extends x implements f {
    public final int e;
    public final Object f;

    public h(Constructor constructor0, Object object0, int v) {
        this.e = v;
        if(v != 1) {
            q.g(constructor0, "constructor");
            Class class0 = constructor0.getDeclaringClass();
            q.f(class0, "getDeclaringClass(...)");
            Type[] arr_type = constructor0.getGenericParameterTypes();
            q.f(arr_type, "getGenericParameterTypes(...)");
            Type[] arr_type1 = arr_type.length <= 2 ? new Type[0] : n.a0(arr_type, 1, arr_type.length - 1);
            super(constructor0, class0, null, arr_type1);
            this.f = object0;
            return;
        }
        q.g(constructor0, "constructor");
        Class class1 = constructor0.getDeclaringClass();
        q.f(class1, "getDeclaringClass(...)");
        Type[] arr_type2 = constructor0.getGenericParameterTypes();
        q.f(arr_type2, "getGenericParameterTypes(...)");
        super(constructor0, class1, null, arr_type2);
        this.f = object0;
    }

    @Override  // He.g
    public final Object call(Object[] arr_object) {
        if(this.e != 0) {
            q.g(arr_object, "args");
            this.d(arr_object);
            Q8.h h0 = new Q8.h(2);
            h0.f(this.f);
            h0.h(arr_object);
            Object[] arr_object1 = h0.a.toArray(new Object[h0.a.size()]);
            return ((Constructor)this.a).newInstance(arr_object1);
        }
        q.g(arr_object, "args");
        this.d(arr_object);
        Q8.h h1 = new Q8.h(3);
        h1.f(this.f);
        h1.h(arr_object);
        h1.f(null);
        Object[] arr_object2 = h1.a.toArray(new Object[h1.a.size()]);
        return ((Constructor)this.a).newInstance(arr_object2);
    }
}

