package com.google.gson.internal.bind;

import S7.b;
import W7.a;
import com.google.gson.E;
import com.google.gson.F;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;

public final class e extends E {
    public final HashMap a;
    public final HashMap b;
    public final HashMap c;
    public static final F d;

    static {
        e.d = new EnumTypeAdapter.1();
    }

    public e(Class class0) {
        this.a = new HashMap();
        this.b = new HashMap();
        this.c = new HashMap();
        try {
            Field[] arr_field = class0.getDeclaredFields();
            int v1 = 0;
            for(int v = 0; v < arr_field.length; ++v) {
                Field field0 = arr_field[v];
                if(field0.isEnumConstant()) {
                    arr_field[v1] = field0;
                    ++v1;
                }
            }
            Field[] arr_field1 = (Field[])Arrays.copyOf(arr_field, v1);
            AccessibleObject.setAccessible(arr_field1, true);
            for(int v2 = 0; v2 < arr_field1.length; ++v2) {
                Field field1 = arr_field1[v2];
                Enum enum0 = (Enum)field1.get(null);
                String s = enum0.name();
                String s1 = enum0.toString();
                b b0 = (b)field1.getAnnotation(b.class);
                if(b0 != null) {
                    s = b0.value();
                    String[] arr_s = b0.alternate();
                    for(int v3 = 0; v3 < arr_s.length; ++v3) {
                        this.a.put(arr_s[v3], enum0);
                    }
                }
                this.a.put(s, enum0);
                this.b.put(s1, enum0);
                this.c.put(enum0, s);
            }
            return;
        }
        catch(IllegalAccessException illegalAccessException0) {
        }
        throw new AssertionError(illegalAccessException0);
    }

    @Override  // com.google.gson.E
    public final Object b(a a0) {
        if(a0.Z() == 9) {
            a0.T();
            return null;
        }
        String s = a0.W();
        Enum enum0 = (Enum)this.a.get(s);
        return enum0 == null ? ((Enum)this.b.get(s)) : enum0;
    }

    @Override  // com.google.gson.E
    public final void c(W7.b b0, Object object0) {
        b0.P((((Enum)object0) == null ? null : ((String)this.c.get(((Enum)object0)))));
    }
}

