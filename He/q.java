package He;

import ie.H;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import je.n;

public abstract class q extends x {
    public final boolean e;

    public q(Field field0, boolean z, boolean z1) {
        Class class0 = Void.TYPE;
        kotlin.jvm.internal.q.f(class0, "TYPE");
        super(field0, class0, (z1 ? field0.getDeclaringClass() : null), new Type[]{field0.getGenericType()});
        this.e = z;
    }

    @Override  // He.g
    public Object call(Object[] arr_object) {
        kotlin.jvm.internal.q.g(arr_object, "args");
        this.d(arr_object);
        Object object0 = this.c == null ? null : n.h0(arr_object);
        ((Field)this.a).set(object0, n.s0(arr_object));
        return H.a;
    }

    @Override  // He.x
    public void d(Object[] arr_object) {
        kotlin.jvm.internal.q.g(arr_object, "args");
        super.d(arr_object);
        if(this.e && n.s0(arr_object) == null) {
            throw new IllegalArgumentException("null is not allowed as a value for this property.");
        }
    }
}

