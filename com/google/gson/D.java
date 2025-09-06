package com.google.gson;

import W7.a;
import W7.b;

public final class D extends E {
    public final E a;

    public D(E e0) {
        this.a = e0;
    }

    @Override  // com.google.gson.E
    public final Object b(a a0) {
        if(a0.Z() == 9) {
            a0.T();
            return null;
        }
        return this.a.b(a0);
    }

    @Override  // com.google.gson.E
    public final void c(b b0, Object object0) {
        if(object0 == null) {
            b0.B();
            return;
        }
        this.a.c(b0, object0);
    }

    @Override
    public final String toString() {
        return "NullSafeTypeAdapter[" + this.a + "]";
    }
}

