package com.google.gson.internal.bind;

import W7.b;
import com.google.gson.E;
import com.google.gson.F;
import com.google.gson.n;
import java.lang.reflect.Array;
import java.util.ArrayList;

public final class a extends E {
    public final Class a;
    public final k b;
    public static final F c;

    static {
        a.c = new ArrayTypeAdapter.1();
    }

    public a(n n0, E e0, Class class0) {
        this.b = new k(n0, e0, class0);
        this.a = class0;
    }

    @Override  // com.google.gson.E
    public final Object b(W7.a a0) {
        if(a0.Z() == 9) {
            a0.T();
            return null;
        }
        ArrayList arrayList0 = new ArrayList();
        a0.h();
        while(a0.E()) {
            arrayList0.add(this.b.c.b(a0));
        }
        a0.q();
        int v = arrayList0.size();
        Class class0 = this.a;
        if(class0.isPrimitive()) {
            Object object0 = Array.newInstance(class0, v);
            for(int v1 = 0; v1 < v; ++v1) {
                Array.set(object0, v1, arrayList0.get(v1));
            }
            return object0;
        }
        return arrayList0.toArray(((Object[])Array.newInstance(class0, v)));
    }

    @Override  // com.google.gson.E
    public final void c(b b0, Object object0) {
        if(object0 == null) {
            b0.B();
            return;
        }
        b0.m();
        int v = Array.getLength(object0);
        for(int v1 = 0; v1 < v; ++v1) {
            Object object1 = Array.get(object0, v1);
            this.b.c(b0, object1);
        }
        b0.q();
    }
}

