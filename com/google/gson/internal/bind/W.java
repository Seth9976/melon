package com.google.gson.internal.bind;

import W7.a;
import W7.b;
import com.google.gson.E;

public class w extends E {
    @Override  // com.google.gson.E
    public final Object b(a a0) {
        if(a0.Z() == 9) {
            a0.T();
            return null;
        }
        return (float)a0.K();
    }

    @Override  // com.google.gson.E
    public final void c(b b0, Object object0) {
        Number number0 = (Number)object0;
        if(number0 == null) {
            b0.B();
            return;
        }
        if(!(number0 instanceof Float)) {
            number0 = number0.floatValue();
        }
        b0.N(number0);
    }
}

