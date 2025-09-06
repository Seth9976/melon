package com.google.gson.internal.bind;

import R6.c;
import T7.p;
import W7.a;
import W7.b;
import com.google.gson.E;
import com.google.gson.n;
import com.google.gson.reflect.TypeToken;
import com.google.gson.v;
import com.google.gson.x;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Map;

public final class k extends E {
    public final int a;
    public final Object b;
    public final E c;
    public final Object d;

    public k(MapTypeAdapterFactory mapTypeAdapterFactory0, k k0, k k1, p p0) {
        this.a = 0;
        super();
        this.b = k0;
        this.c = k1;
        this.d = p0;
    }

    public k(n n0, E e0, Type type0) {
        this.a = 1;
        super();
        this.b = n0;
        this.c = e0;
        this.d = type0;
    }

    @Override  // com.google.gson.E
    public final Object b(a a0) {
        if(this.a != 0) {
            return this.c.b(a0);
        }
        int v = a0.Z();
        if(v == 9) {
            a0.T();
            return null;
        }
        Map map0 = (Map)((p)this.d).f();
        if(v == 1) {
            a0.h();
            while(a0.E()) {
                a0.h();
                Object object0 = ((k)this.b).c.b(a0);
                if(map0.put(object0, ((k)this.c).c.b(a0)) != null) {
                    throw new x("duplicate key: " + object0);  // 初始化器: Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V
                }
                a0.q();
            }
            a0.q();
            return map0;
        }
        a0.m();
        while(a0.E()) {
            c.c.getClass();
            if(a0 instanceof h) {
                ((h)a0).o0(5);
                Object object1 = ((Iterator)((h)a0).s0()).next();
                ((h)a0).u0(((Map.Entry)object1).getValue());
                ((h)a0).u0(new v(((String)((Map.Entry)object1).getKey())));
            }
            else {
                switch((a0.g == 0 ? a0.p() : a0.g)) {
                    case 12: {
                        a0.g = 8;
                        break;
                    }
                    case 13: {
                        a0.g = 9;
                        break;
                    }
                    case 14: {
                        a0.g = 10;
                        break;
                    }
                    default: {
                        throw a0.n0("a name");
                    }
                }
            }
            Object object2 = ((k)this.b).c.b(a0);
            if(map0.put(object2, ((k)this.c).c.b(a0)) != null) {
                throw new x("duplicate key: " + object2);  // 初始化器: Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V
            }
            if(false) {
                break;
            }
        }
        a0.r();
        return map0;
    }

    @Override  // com.google.gson.E
    public final void c(b b0, Object object0) {
        if(this.a != 0) {
            Type type0 = (Type)this.d;
            Type type1 = object0 == null || !(type0 instanceof Class) && !(type0 instanceof TypeVariable) ? type0 : object0.getClass();
            E e0 = this.c;
            if(type1 != type0) {
                TypeToken typeToken0 = TypeToken.get(type1);
                E e1 = ((n)this.b).g(typeToken0);
                if(e1 instanceof o) {
                    E e2;
                    for(e2 = e0; e2 instanceof s; e2 = e3) {
                        E e3 = ((s)e2).d();
                        if(e3 == e2) {
                            break;
                        }
                    }
                    if(e2 instanceof o) {
                        e0 = e1;
                    }
                }
                else {
                    e0 = e1;
                }
            }
            e0.c(b0, object0);
            return;
        }
        k k0 = (k)this.c;
        if(((Map)object0) == null) {
            b0.B();
            return;
        }
        b0.o();
        for(Object object1: ((Map)object0).entrySet()) {
            b0.s(String.valueOf(((Map.Entry)object1).getKey()));
            k0.c(b0, ((Map.Entry)object1).getValue());
        }
        b0.r();
    }
}

