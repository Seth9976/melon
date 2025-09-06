package com.google.gson.internal.bind;

import com.google.gson.C;
import com.google.gson.E;
import com.google.gson.F;
import com.google.gson.n;
import com.google.gson.reflect.TypeToken;

class ObjectTypeAdapter.1 implements F {
    public final C a;

    public ObjectTypeAdapter.1(C c0) {
        this.a = c0;
    }

    @Override  // com.google.gson.F
    public final E a(n n0, TypeToken typeToken0) {
        return typeToken0.getRawType() == Object.class ? new m(n0, this.a) : null;
    }
}

