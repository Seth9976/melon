package co.ab180.airbridge.internal.d0.b.b;

import java.lang.reflect.InvocationHandler;
import java.util.ArrayList;

public abstract class b implements InvocationHandler {
    public static Class[] a(Object[] arr_object) {
        ArrayList arrayList0 = new ArrayList();
        for(int v = 0; v < arr_object.length; ++v) {
            arrayList0.add(arr_object[v].getClass());
        }
        return (Class[])arrayList0.toArray(new Class[arrayList0.size()]);
    }
}

