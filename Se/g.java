package Se;

import gf.a;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import kotlin.jvm.internal.q;

public final class g extends e implements a {
    public final Object[] b;

    public g(qf.e e0, Object[] arr_object) {
        super(e0);
        this.b = arr_object;
    }

    public final ArrayList a() {
        s s0;
        Object[] arr_object = this.b;
        ArrayList arrayList0 = new ArrayList(arr_object.length);
        for(int v = 0; v < arr_object.length; ++v) {
            Object object0 = arr_object[v];
            q.d(object0);
            Class class0 = object0.getClass();
            if(Enum.class.isAssignableFrom(class0)) {
                s0 = new s(null, ((Enum)object0));
            }
            else if(object0 instanceof Annotation) {
                s0 = new f(null, ((Annotation)object0));
            }
            else if(object0 instanceof Object[]) {
                s0 = new g(null, ((Object[])object0));
            }
            else if(object0 instanceof Class) {
                s0 = new o(null, ((Class)object0));
            }
            else {
                s0 = new u(null, object0);
            }
            arrayList0.add(s0);
        }
        return arrayList0;
    }
}

