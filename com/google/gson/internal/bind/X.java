package com.google.gson.internal.bind;

import W7.a;
import W7.b;
import com.google.gson.E;

public class x extends E {
    @Override  // com.google.gson.E
    public final Object b(a a0) {
        if(a0.Z() == 9) {
            a0.T();
            return null;
        }
        return a0.K();
    }

    @Override  // com.google.gson.E
    public final void c(b b0, Object object0) {
        if(((Number)object0) == null) {
            b0.B();
            return;
        }
        b0.H(((Number)object0).doubleValue());
    }
}

