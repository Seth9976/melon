package qe;

import java.lang.reflect.Method;
import kotlin.jvm.internal.q;

public abstract class a {
    public static final Method a;

    static {
        Method method0;
        Class class0 = Throwable.class;
        Method[] arr_method = class0.getMethods();
        q.d(arr_method);
        for(int v1 = 0; true; ++v1) {
            method0 = null;
            if(v1 >= arr_method.length) {
                break;
            }
            Method method1 = arr_method[v1];
            if(q.b(method1.getName(), "addSuppressed")) {
                Class[] arr_class = method1.getParameterTypes();
                q.f(arr_class, "getParameterTypes(...)");
                if(arr_class.length == 1) {
                    method0 = arr_class[0];
                }
                if(q.b(method0, class0)) {
                    method0 = method1;
                    break;
                }
            }
        }
        a.a = method0;
        for(int v = 0; v < arr_method.length && !q.b(arr_method[v].getName(), "getSuppressed"); ++v) {
        }
    }
}

