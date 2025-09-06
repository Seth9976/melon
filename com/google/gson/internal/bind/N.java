package com.google.gson.internal.bind;

import U4.x;
import V7.c;
import W7.b;
import com.google.gson.E;
import com.google.gson.r;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class n {
    public final String a;
    public final Field b;
    public final String c;
    public final Method d;
    public final E e;
    public final E f;
    public final boolean g;
    public final boolean h;

    public n(String s, Field field0, Method method0, E e0, E e1, boolean z, boolean z1) {
        this.d = method0;
        this.e = e0;
        this.f = e1;
        this.g = z;
        this.h = z1;
        super();
        this.a = s;
        this.b = field0;
        this.c = field0.getName();
    }

    public final void a(b b0, Object object0) {
        Object object1;
        Method method0 = this.d;
        if(method0 == null) {
            object1 = this.b.get(object0);
        }
        else {
            try {
                object1 = method0.invoke(object0, null);
            }
            catch(InvocationTargetException invocationTargetException0) {
                throw new r(x.k("Accessor ", c.d(method0, false), " threw exception"), invocationTargetException0.getCause());  // 初始化器: Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V
            }
        }
        if(object1 == object0) {
            return;
        }
        b0.s(this.a);
        this.e.c(b0, object1);
    }
}

