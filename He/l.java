package He;

import java.lang.reflect.Field;
import je.n;
import kotlin.jvm.internal.q;

public final class l extends m {
    public final int e;

    public l(Field field0, boolean z, int v) {
        this.e = v;
        super(field0, z);
    }

    @Override  // He.x
    public void d(Object[] arr_object) {
        if(this.e != 1) {
            super.d(arr_object);
            return;
        }
        q.g(arr_object, "args");
        super.d(arr_object);
        this.e(n.i0(arr_object));
    }
}

