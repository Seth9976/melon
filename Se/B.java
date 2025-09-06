package Se;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import je.n;
import kotlin.jvm.internal.q;
import qf.e;
import we.k;

public final class b implements k {
    public final int a;
    public static final b b;
    public static final b c;
    public static final b d;
    public static final b e;

    static {
        b.b = new b(0);
        b.c = new b(1);
        b.d = new b(2);
        b.e = new b(3);
    }

    public b(int v) {
        this.a = v;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        switch(this.a) {
            case 0: {
                q.g(((ParameterizedType)object0), "it");
                Type type0 = ((ParameterizedType)object0).getOwnerType();
                return type0 instanceof ParameterizedType ? ((ParameterizedType)type0) : null;
            }
            case 1: {
                q.g(((ParameterizedType)object0), "it");
                Type[] arr_type = ((ParameterizedType)object0).getActualTypeArguments();
                q.f(arr_type, "getActualTypeArguments(...)");
                return n.O(arr_type);
            }
            case 2: {
                return ((Class)object0).getSimpleName().length() == 0;
            }
            default: {
                String s = ((Class)object0).getSimpleName();
                if(!e.f(s)) {
                    s = null;
                }
                return s != null ? e.e(s) : null;
            }
        }
    }
}

