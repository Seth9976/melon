package com.google.gson.internal.bind;

import com.google.gson.E;
import com.google.gson.F;
import com.google.gson.n;
import com.google.gson.reflect.TypeToken;

class TypeAdapters.30 implements F {
    public final Class a;
    public final Class b;
    public final E c;

    public TypeAdapters.30(Class class0, Class class1, E e0) {
        this.a = class0;
        this.b = class1;
        this.c = e0;
    }

    @Override  // com.google.gson.F
    public final E a(n n0, TypeToken typeToken0) {
        Class class0 = typeToken0.getRawType();
        return class0 == this.a || class0 == this.b ? this.c : null;
    }

    @Override
    public final String toString() {
        return "Factory[type=" + this.b.getName() + "+" + this.a.getName() + ",adapter=" + this.c + "]";
    }
}

