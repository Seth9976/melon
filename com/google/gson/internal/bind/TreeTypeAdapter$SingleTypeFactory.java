package com.google.gson.internal.bind;

import T7.h;
import com.google.gson.E;
import com.google.gson.F;
import com.google.gson.n;
import com.google.gson.reflect.TypeToken;
import com.google.gson.w;

final class TreeTypeAdapter.SingleTypeFactory implements F {
    public final TypeToken a;
    public final boolean b;
    public final w c;

    public TreeTypeAdapter.SingleTypeFactory(Object object0, TypeToken typeToken0, boolean z) {
        w w0 = object0 instanceof w ? ((w)object0) : null;
        this.c = w0;
        h.b(w0 != null);
        this.a = typeToken0;
        this.b = z;
    }

    @Override  // com.google.gson.F
    public final E a(n n0, TypeToken typeToken0) {
        TypeToken typeToken1 = this.a;
        if(typeToken1 == null) {
            throw null;
        }
        return !typeToken1.equals(typeToken0) && (!this.b || typeToken1.getType() != typeToken0.getRawType()) ? null : new t(this.c, n0, typeToken0, this, true);
    }
}

