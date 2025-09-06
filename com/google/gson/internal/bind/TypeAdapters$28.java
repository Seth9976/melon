package com.google.gson.internal.bind;

import com.google.gson.E;
import com.google.gson.F;
import com.google.gson.n;
import com.google.gson.reflect.TypeToken;

class TypeAdapters.28 implements F {
    public final TypeToken a;
    public final E b;

    public TypeAdapters.28(TypeToken typeToken0, E e0) {
        this.a = typeToken0;
        this.b = e0;
    }

    // 去混淆评级： 低(20)
    @Override  // com.google.gson.F
    public final E a(n n0, TypeToken typeToken0) {
        return typeToken0.equals(this.a) ? this.b : null;
    }
}

