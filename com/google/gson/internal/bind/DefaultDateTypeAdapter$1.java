package com.google.gson.internal.bind;

import com.google.gson.E;
import com.google.gson.F;
import com.google.gson.n;
import com.google.gson.reflect.TypeToken;
import java.util.Date;

class DefaultDateTypeAdapter.1 implements F {
    @Override  // com.google.gson.F
    public final E a(n n0, TypeToken typeToken0) {
        return typeToken0.getRawType() == Date.class ? new d(c.b, 2, 2) : null;
    }

    @Override
    public final String toString() {
        return "DefaultDateTypeAdapter#DEFAULT_STYLE_FACTORY";
    }
}

