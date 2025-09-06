package com.google.gson.internal.bind;

import V7.c;
import W7.a;
import com.google.gson.r;
import java.lang.reflect.Field;
import va.e;

public final class p extends o {
    public final T7.p b;

    public p(T7.p p0, q q0) {
        super(q0);
        this.b = p0;
    }

    @Override  // com.google.gson.internal.bind.o
    public final Object d() {
        return this.b.f();
    }

    @Override  // com.google.gson.internal.bind.o
    public final Object e(Object object0) {
        return object0;
    }

    @Override  // com.google.gson.internal.bind.o
    public final void f(Object object0, a a0, n n0) {
        Field field0 = n0.b;
        Object object1 = n0.f.b(a0);
        if(object1 == null && n0.g) {
            return;
        }
        if(n0.h) {
            throw new r(e.b("Cannot set value of \'static final\' ", c.d(field0, false)));  // 初始化器: Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V
        }
        field0.set(object0, object1);
    }
}

