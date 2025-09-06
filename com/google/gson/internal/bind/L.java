package com.google.gson.internal.bind;

import W7.a;
import com.google.gson.C;
import com.google.gson.E;
import com.google.gson.F;
import com.google.gson.x;
import e0.b;

public final class l extends E {
    public final C a;
    public static final F b;

    static {
        l.b = l.d(C.b);
    }

    public l(C c0) {
        this.a = c0;
    }

    @Override  // com.google.gson.E
    public final Object b(a a0) {
        int v = a0.Z();
        switch(b.b(v)) {
            case 5: 
            case 6: {
                return this.a.a(a0);
            }
            case 8: {
                a0.T();
                return null;
            }
            default: {
                throw new x("Expecting number, got: " + U4.x.B(v) + "; at path " + a0.A());  // 初始化器: Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V
            }
        }
    }

    @Override  // com.google.gson.E
    public final void c(W7.b b0, Object object0) {
        b0.N(((Number)object0));
    }

    public static F d(C c0) {
        return new NumberTypeAdapter.1(new l(c0));
    }
}

