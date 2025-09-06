package com.google.gson.internal.bind;

import com.google.gson.E;
import com.google.gson.F;
import com.google.gson.n;
import com.google.gson.reflect.TypeToken;

class NumberTypeAdapter.1 implements F {
    public final l a;

    public NumberTypeAdapter.1(l l0) {
        this.a = l0;
    }

    @Override  // com.google.gson.F
    public final E a(n n0, TypeToken typeToken0) {
        return typeToken0.getRawType() == Number.class ? this.a : null;
    }
}

