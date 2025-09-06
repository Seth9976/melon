package com.google.gson.internal.bind;

import com.google.gson.E;
import com.google.gson.F;
import com.google.gson.n;
import com.google.gson.reflect.TypeToken;

class TypeAdapters.29 implements F {
    public final Class a;
    public final E b;

    public TypeAdapters.29(Class class0, E e0) {
        this.a = class0;
        this.b = e0;
    }

    @Override  // com.google.gson.F
    public final E a(n n0, TypeToken typeToken0) {
        return typeToken0.getRawType() == this.a ? this.b : null;
    }

    @Override
    public final String toString() {
        return "Factory[type=" + this.a.getName() + ",adapter=" + this.b + "]";
    }
}

