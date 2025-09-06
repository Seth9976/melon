package com.google.gson.internal.bind;

import V7.c;
import W7.a;
import com.google.gson.u;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;

public final class r extends o {
    public final Constructor b;
    public final Object[] c;
    public final HashMap d;
    public static final HashMap e;

    static {
        HashMap hashMap0 = new HashMap();
        hashMap0.put(Byte.TYPE, ((byte)0));
        hashMap0.put(Short.TYPE, ((short)0));
        hashMap0.put(Integer.TYPE, 0);
        hashMap0.put(Long.TYPE, 0L);
        hashMap0.put(Float.TYPE, 0.0f);
        hashMap0.put(Double.TYPE, 0.0);
        hashMap0.put(Character.TYPE, Character.valueOf('\u0000'));
        hashMap0.put(Boolean.TYPE, Boolean.FALSE);
        r.e = hashMap0;
    }

    public r(Class class0, q q0) {
        super(q0);
        this.d = new HashMap();
        Constructor constructor0 = c.a.y(class0);
        this.b = constructor0;
        c.f(constructor0);
        String[] arr_s = c.a.C(class0);
        for(int v1 = 0; v1 < arr_s.length; ++v1) {
            this.d.put(arr_s[v1], v1);
        }
        Class[] arr_class = this.b.getParameterTypes();
        this.c = new Object[arr_class.length];
        for(int v = 0; v < arr_class.length; ++v) {
            this.c[v] = r.e.get(arr_class[v]);
        }
    }

    @Override  // com.google.gson.internal.bind.o
    public final Object d() {
        return (Object[])this.c.clone();
    }

    @Override  // com.google.gson.internal.bind.o
    public final Object e(Object object0) {
        Object[] arr_object = (Object[])object0;
        Constructor constructor0 = this.b;
        try {
            return constructor0.newInstance(arr_object);
        }
        catch(IllegalAccessException illegalAccessException0) {
            throw new RuntimeException("Unexpected IllegalAccessException occurred (Gson 2.13.1). Certain ReflectionAccessFilter features require Java >= 9 to work correctly. If you are not using ReflectionAccessFilter, report this to the Gson maintainers.", illegalAccessException0);
        }
        catch(InstantiationException | IllegalArgumentException instantiationException0) {
            throw new RuntimeException("Failed to invoke constructor \'" + c.b(constructor0) + "\' with args " + Arrays.toString(arr_object), instantiationException0);
        }
        catch(InvocationTargetException invocationTargetException0) {
            throw new RuntimeException("Failed to invoke constructor \'" + c.b(constructor0) + "\' with args " + Arrays.toString(arr_object), invocationTargetException0.getCause());
        }
    }

    @Override  // com.google.gson.internal.bind.o
    public final void f(Object object0, a a0, n n0) {
        String s = n0.c;
        Integer integer0 = (Integer)this.d.get(s);
        if(integer0 == null) {
            throw new IllegalStateException("Could not find the index in the constructor \'" + c.b(this.b) + "\' for field with name \'" + s + "\', unable to determine which argument in the constructor the field corresponds to. This is unexpected behavior, as we expect the RecordComponents to have the same names as the fields in the Java class, and that the order of the RecordComponents is the same as the order of the canonical constructor parameters.");
        }
        int v = (int)integer0;
        Object object1 = n0.f.b(a0);
        if(object1 == null && n0.g) {
            throw new u("null is not allowed as value for record component \'" + n0.c + "\' of primitive type; at path " + a0.A());  // 初始化器: Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V
        }
        ((Object[])object0)[v] = object1;
    }
}

