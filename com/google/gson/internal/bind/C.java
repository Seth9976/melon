package com.google.gson.internal.bind;

import com.google.gson.F;
import java.util.Date;

public abstract class c {
    public final Class a;
    public static final b b;

    static {
        c.b = new b(Date.class);  // 初始化器: Lcom/google/gson/internal/bind/c;-><init>(Ljava/lang/Class;)V
    }

    public c(Class class0) {
        this.a = class0;
    }

    public final F a(int v, int v1) {
        d d0 = new d(this, v, v1);
        return new TypeAdapters.29(this.a, d0);
    }

    public abstract Date b(Date arg1);
}

