package androidx.lifecycle;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map.Entry;

public final class e {
    public final HashMap a;
    public final HashMap b;
    public static final e c;

    static {
        e.c = new e();
    }

    public e() {
        this.a = new HashMap();
        this.b = new HashMap();
    }

    public final c a(Class class0, Method[] arr_method) {
        int v2;
        Class class1 = class0.getSuperclass();
        HashMap hashMap0 = new HashMap();
        HashMap hashMap1 = this.a;
        if(class1 != null) {
            c c0 = (c)hashMap1.get(class1);
            if(c0 == null) {
                c0 = this.a(class1, null);
            }
            hashMap0.putAll(c0.b);
        }
        Class[] arr_class = class0.getInterfaces();
        for(int v = 0; v < arr_class.length; ++v) {
            Class class2 = arr_class[v];
            c c1 = (c)hashMap1.get(class2);
            if(c1 == null) {
                c1 = this.a(class2, null);
            }
            for(Object object0: c1.b.entrySet()) {
                e.b(hashMap0, ((d)((Map.Entry)object0).getKey()), ((r)((Map.Entry)object0).getValue()), class0);
            }
        }
        if(arr_method == null) {
            arr_method = class0.getDeclaredMethods();
        }
        boolean z = false;
        for(int v1 = 0; v1 < arr_method.length; ++v1) {
            Method method0 = arr_method[v1];
            N n0 = (N)method0.getAnnotation(N.class);
            if(n0 != null) {
                Class[] arr_class1 = method0.getParameterTypes();
                if(arr_class1.length > 0) {
                    if(!D.class.isAssignableFrom(arr_class1[0])) {
                        throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                    }
                    v2 = 1;
                }
                else {
                    v2 = 0;
                }
                r r0 = n0.value();
                if(arr_class1.length > 1) {
                    if(!r.class.isAssignableFrom(arr_class1[1])) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    }
                    if(r0 != r.ON_ANY) {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                    v2 = 2;
                }
                if(arr_class1.length > 2) {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
                e.b(hashMap0, new d(method0, v2), r0, class0);
                z = true;
            }
        }
        c c2 = new c(hashMap0);
        hashMap1.put(class0, c2);
        this.b.put(class0, Boolean.valueOf(z));
        return c2;
    }

    public static void b(HashMap hashMap0, d d0, r r0, Class class0) {
        r r1 = (r)hashMap0.get(d0);
        if(r1 != null && r0 != r1) {
            throw new IllegalArgumentException("Method " + d0.b.getName() + " in " + class0.getName() + " already declared with different @OnLifecycleEvent value: previous value " + r1 + ", new value " + r0);
        }
        if(r1 == null) {
            hashMap0.put(d0, r0);
        }
    }
}

