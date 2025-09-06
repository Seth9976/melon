package com.google.gson.internal.bind;

import W7.a;
import W7.b;
import com.google.gson.E;

public class z extends E {
    @Override  // com.google.gson.E
    public final Object b(a a0) {
        int v = a0.Z();
        if(v == 9) {
            a0.T();
            return null;
        }
        return v == 8 ? Boolean.toString(a0.H()) : a0.W();
    }

    @Override  // com.google.gson.E
    public final void c(b b0, Object object0) {
        b0.P(((String)object0));
    }
}

