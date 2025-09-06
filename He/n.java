package He;

import ie.H;
import java.lang.reflect.Field;

public final class n extends q implements f {
    public final Object f;

    public n(Field field0, boolean z, Object object0) {
        kotlin.jvm.internal.q.g(field0, "field");
        super(field0, z, false);
        this.f = object0;
    }

    @Override  // He.q
    public final Object call(Object[] arr_object) {
        kotlin.jvm.internal.q.g(arr_object, "args");
        this.d(arr_object);
        Object object0 = je.n.h0(arr_object);
        ((Field)this.a).set(this.f, object0);
        return H.a;
    }
}

