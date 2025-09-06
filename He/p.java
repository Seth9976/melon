package He;

import java.lang.reflect.Field;
import je.n;

public final class p extends q {
    public final int f;

    public p(Field field0, boolean z, boolean z1, int v) {
        this.f = v;
        super(field0, z, z1);
    }

    @Override  // He.q
    public void d(Object[] arr_object) {
        if(this.f != 1) {
            super.d(arr_object);
            return;
        }
        kotlin.jvm.internal.q.g(arr_object, "args");
        super.d(arr_object);
        this.e(n.i0(arr_object));
    }
}

