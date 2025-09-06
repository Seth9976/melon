package He;

import java.lang.reflect.Field;
import kotlin.jvm.internal.q;

public final class j extends m implements f {
    public final Object e;

    public j(Field field0, Object object0) {
        q.g(field0, "field");
        super(field0, false);
        this.e = object0;
    }

    @Override  // He.m
    public final Object call(Object[] arr_object) {
        q.g(arr_object, "args");
        this.d(arr_object);
        return ((Field)this.a).get(this.e);
    }
}

