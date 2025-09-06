package com.google.gson.internal.bind;

import J0.h;
import S7.a;
import S7.b;
import U4.x;
import V7.c;
import com.google.gson.E;
import com.google.gson.F;
import com.google.gson.internal.Excluder;
import com.google.gson.j;
import com.google.gson.n;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public final class ReflectiveTypeAdapterFactory implements F {
    public final h a;
    public final com.google.gson.h b;
    public final Excluder c;
    public final JsonAdapterAnnotationTypeAdapterFactory d;
    public final List e;

    public ReflectiveTypeAdapterFactory(h h0, com.google.gson.h h1, Excluder excluder0, JsonAdapterAnnotationTypeAdapterFactory jsonAdapterAnnotationTypeAdapterFactory0, List list0) {
        this.a = h0;
        this.b = h1;
        this.c = excluder0;
        this.d = jsonAdapterAnnotationTypeAdapterFactory0;
        this.e = list0;
    }

    @Override  // com.google.gson.F
    public final E a(n n0, TypeToken typeToken0) {
        Class class0 = typeToken0.getRawType();
        if(!Object.class.isAssignableFrom(class0)) {
            return null;
        }
        if(!Modifier.isStatic(class0.getModifiers()) && (class0.isAnonymousClass() || class0.isLocalClass())) {
            return new j(2);
        }
        T7.h.f(this.e);
        return c.a.I(class0) ? new r(class0, this.c(n0, typeToken0, class0, true)) : new p(this.a.i(typeToken0, true), this.c(n0, typeToken0, class0, false));
    }

    public static void b(Class class0, String s, Field field0, Field field1) {
        throw new IllegalArgumentException("Class " + class0.getName() + " declares multiple JSON fields named \'" + s + "\'; conflict is caused by fields " + c.c(field0) + " and " + c.c(field1) + "\nSee " + "https://github.com/google/gson/blob/main/Troubleshooting.md#duplicate-fields");
    }

    public final q c(n n0, TypeToken typeToken0, Class class0, boolean z) {
        E e2;
        E e0;
        List list2;
        Field field1;
        List list1;
        List list0;
        String s;
        Method method1;
        boolean z3;
        if(class0.isInterface()) {
            return q.c;
        }
        LinkedHashMap linkedHashMap0 = new LinkedHashMap();
        LinkedHashMap linkedHashMap1 = new LinkedHashMap();
        TypeToken typeToken1 = typeToken0;
        Class class1 = class0;
        while(class1 != Object.class) {
            Field[] arr_field = class1.getDeclaredFields();
            if(class1 != class0 && arr_field.length > 0) {
                T7.h.f(this.e);
            }
            int v = arr_field.length;
            int v1 = 0;
            while(v1 < v) {
                Field field0 = arr_field[v1];
                boolean z1 = this.d(field0, true);
                boolean z2 = this.d(field0, false);
                if(z1 || z2) {
                    Class class2 = b.class;
                    if(z) {
                        if(Modifier.isStatic(field0.getModifiers())) {
                            z3 = false;
                            goto label_30;
                        }
                        else {
                            Method method0 = c.a.x(class1, field0);
                            c.f(method0);
                            if(method0.getAnnotation(class2) != null && field0.getAnnotation(class2) == null) {
                                throw new com.google.gson.r(x.k("@SerializedName on ", c.d(method0, false), " is not supported"));  // 初始化器: Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V
                            }
                            z3 = z2;
                            method1 = method0;
                            goto label_31;
                        }
                        goto label_29;
                    }
                    else {
                    label_29:
                        z3 = z2;
                    }
                label_30:
                    method1 = null;
                label_31:
                    if(method1 == null) {
                        c.f(field0);
                    }
                    Type type0 = T7.h.k(typeToken1.getType(), class1, field0.getGenericType(), new HashMap());
                    b b0 = (b)field0.getAnnotation(class2);
                    if(b0 == null) {
                        s = this.b.b(field0);
                        list0 = Collections.EMPTY_LIST;
                    }
                    else {
                        String s1 = b0.value();
                        list0 = Arrays.asList(b0.alternate());
                        s = s1;
                    }
                    if(list0.isEmpty()) {
                        list1 = Collections.singletonList(s);
                    }
                    else {
                        ArrayList arrayList0 = new ArrayList(list0.size() + 1);
                        arrayList0.add(s);
                        arrayList0.addAll(list0);
                        list1 = arrayList0;
                    }
                    Object object0 = list1.get(0);
                    TypeToken typeToken2 = TypeToken.get(type0);
                    Class class3 = typeToken2.getRawType();
                    boolean z4 = class3 != null && class3.isPrimitive();
                    int v2 = field0.getModifiers();
                    boolean z5 = Modifier.isStatic(v2) && Modifier.isFinal(v2);
                    a a0 = (a)field0.getAnnotation(a.class);
                    if(a0 == null) {
                        field1 = field0;
                        list2 = list1;
                        e0 = null;
                    }
                    else {
                        field1 = field0;
                        list2 = list1;
                        e0 = this.d.b(this.a, n0, typeToken2, a0, false);
                    }
                    boolean z6 = e0 != null;
                    if(e0 == null) {
                        e0 = n0.g(typeToken2);
                    }
                    if(z1) {
                        E e1 = z6 ? e0 : new k(n0, e0, typeToken2.getType());
                        e2 = e1;
                    }
                    else {
                        e2 = e0;
                    }
                    com.google.gson.internal.bind.n n1 = new com.google.gson.internal.bind.n(((String)object0), field1, method1, e2, e0, z4, z5);
                    if(z3) {
                        for(Object object1: list2) {
                            String s2 = (String)object1;
                            com.google.gson.internal.bind.n n2 = (com.google.gson.internal.bind.n)linkedHashMap0.put(s2, n1);
                            if(n2 != null) {
                                ReflectiveTypeAdapterFactory.b(class0, s2, n2.b, field1);
                                throw null;
                            }
                            if(false) {
                                break;
                            }
                        }
                    }
                    if(z1) {
                        com.google.gson.internal.bind.n n3 = (com.google.gson.internal.bind.n)linkedHashMap1.put(((String)object0), n1);
                        if(n3 != null) {
                            ReflectiveTypeAdapterFactory.b(class0, ((String)object0), n3.b, field1);
                            throw null;
                        }
                    }
                }
                ++v1;
            }
            typeToken1 = TypeToken.get(T7.h.k(typeToken1.getType(), class1, class1.getGenericSuperclass(), new HashMap()));
            class1 = typeToken1.getRawType();
        }
        return new q(linkedHashMap0, new ArrayList(linkedHashMap1.values()));
    }

    public final boolean d(Field field0, boolean z) {
        Excluder excluder0 = this.c;
        excluder0.getClass();
        if((0x88 & field0.getModifiers()) == 0 && (!field0.isSynthetic() && !excluder0.b(field0.getType(), z))) {
            List list0 = z ? excluder0.a : excluder0.b;
            if(!list0.isEmpty()) {
                Iterator iterator0 = list0.iterator();
                if(iterator0.hasNext()) {
                    throw H0.b.b(iterator0);
                }
            }
            return 1;
        }
        return 0;
    }
}

