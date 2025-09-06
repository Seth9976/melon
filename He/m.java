package He;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import je.n;
import kotlin.jvm.internal.q;

public abstract class m extends x {
    public m(Field field0, boolean z) {
        Type type0 = field0.getGenericType();
        q.f(type0, "getGenericType(...)");
        super(field0, type0, (z ? field0.getDeclaringClass() : null), new Type[0]);
    }

    @Override  // He.g
    public Object call(Object[] arr_object) {
        q.g(arr_object, "args");
        this.d(arr_object);
        Field field0 = (Field)this.a;
        return this.c == null ? field0.get(null) : field0.get(n.h0(arr_object));
    }
}

