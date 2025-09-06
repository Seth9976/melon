package He;

import java.lang.reflect.Method;
import je.n;
import kotlin.jvm.internal.q;

public final class v extends w {
    public final int f;

    public v(Method method0, int v) {
        this.f = v;
        switch(v) {
            case 1: {
                q.g(method0, "method");
                super(method0, true, 4);
                return;
            }
            case 2: {
                q.g(method0, "method");
                super(method0, false, 6);
                return;
            }
            default: {
                q.g(method0, "method");
                super(method0, false, 6);
            }
        }
    }

    @Override  // He.g
    public final Object call(Object[] arr_object) {
        switch(this.f) {
            case 0: {
                q.g(arr_object, "args");
                this.d(arr_object);
                Object object0 = arr_object[0];
                return arr_object.length > 1 ? this.f(n.a0(arr_object, 1, arr_object.length), object0) : this.f(new Object[0], object0);
            }
            case 1: {
                q.g(arr_object, "args");
                this.d(arr_object);
                this.e(n.i0(arr_object));
                return arr_object.length > 1 ? this.f(n.a0(arr_object, 1, arr_object.length), null) : this.f(new Object[0], null);
            }
            default: {
                q.g(arr_object, "args");
                this.d(arr_object);
                return this.f(arr_object, null);
            }
        }
    }
}

