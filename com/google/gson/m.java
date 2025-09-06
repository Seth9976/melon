package com.google.gson;

import W7.a;
import W7.b;
import com.google.gson.internal.bind.s;

public class m extends s {
    public E a;

    public m() {
        this.a = null;
    }

    @Override  // com.google.gson.E
    public final Object b(a a0) {
        E e0 = this.a;
        if(e0 == null) {
            throw new IllegalStateException("Adapter for type with cyclic dependency has been used before dependency has been resolved");
        }
        return e0.b(a0);
    }

    @Override  // com.google.gson.E
    public final void c(b b0, Object object0) {
        E e0 = this.a;
        if(e0 == null) {
            throw new IllegalStateException("Adapter for type with cyclic dependency has been used before dependency has been resolved");
        }
        e0.c(b0, object0);
    }

    @Override  // com.google.gson.internal.bind.s
    public final E d() {
        E e0 = this.a;
        if(e0 == null) {
            throw new IllegalStateException("Adapter for type with cyclic dependency has been used before dependency has been resolved");
        }
        return e0;
    }
}

