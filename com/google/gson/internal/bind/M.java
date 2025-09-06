package com.google.gson.internal.bind;

import T7.o;
import U4.x;
import W7.a;
import com.google.gson.C;
import com.google.gson.E;
import com.google.gson.F;
import com.google.gson.n;
import com.google.gson.reflect.TypeToken;
import e0.b;
import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class m extends E {
    public final n a;
    public final C b;
    public static final F c;

    static {
        m.c = new ObjectTypeAdapter.1(C.a);
    }

    public m(n n0, C c0) {
        this.a = n0;
        this.b = c0;
    }

    @Override  // com.google.gson.E
    public final Object b(a a0) {
        Serializable serializable0;
        Object object0;
        int v = a0.Z();
        switch(b.b(v)) {
            case 0: {
                a0.h();
                object0 = new ArrayList();
                break;
            }
            case 2: {
                a0.m();
                object0 = new o(true);
                break;
            }
            default: {
                object0 = null;
            }
        }
        if(object0 == null) {
            return this.e(a0, v);
        }
        ArrayDeque arrayDeque0 = new ArrayDeque();
        while(true) {
            if(a0.E()) {
                String s = object0 instanceof Map ? a0.P() : null;
                int v1 = a0.Z();
                switch(b.b(v1)) {
                    case 0: {
                        a0.h();
                        serializable0 = new ArrayList();
                        break;
                    }
                    case 2: {
                        a0.m();
                        serializable0 = new o(true);
                        break;
                    }
                    default: {
                        serializable0 = null;
                    }
                }
                boolean z = serializable0 != null;
                if(serializable0 == null) {
                    serializable0 = this.e(a0, v1);
                }
                if(object0 instanceof List) {
                    ((List)object0).add(serializable0);
                }
                else {
                    ((Map)object0).put(s, serializable0);
                }
                if(!z) {
                    continue;
                }
                arrayDeque0.addLast(object0);
                object0 = serializable0;
            }
            else {
                if(object0 instanceof List) {
                    a0.q();
                }
                else {
                    a0.r();
                }
                if(arrayDeque0.isEmpty()) {
                    break;
                }
                object0 = arrayDeque0.removeLast();
            }
        }
        return object0;
    }

    @Override  // com.google.gson.E
    public final void c(W7.b b0, Object object0) {
        if(object0 == null) {
            b0.B();
            return;
        }
        Class class0 = object0.getClass();
        this.a.getClass();
        TypeToken typeToken0 = TypeToken.get(class0);
        E e0 = this.a.g(typeToken0);
        if(e0 instanceof m) {
            b0.o();
            b0.r();
            return;
        }
        e0.c(b0, object0);
    }

    public static F d(C c0) {
        return c0 == C.a ? m.c : new ObjectTypeAdapter.1(c0);
    }

    public final Serializable e(a a0, int v) {
        switch(b.b(v)) {
            case 5: {
                return a0.W();
            }
            case 6: {
                return this.b.a(a0);
            }
            case 7: {
                return Boolean.valueOf(a0.H());
            }
            case 8: {
                a0.T();
                return null;
            }
            default: {
                throw new IllegalStateException("Unexpected token: " + x.B(v));
            }
        }
    }
}

