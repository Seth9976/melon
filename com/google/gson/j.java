package com.google.gson;

import W7.a;
import W7.b;

public final class j extends E {
    public final int a;

    public j(int v) {
        this.a = v;
        super();
    }

    @Override  // com.google.gson.E
    public final Object b(a a0) {
        switch(this.a) {
            case 0: {
                if(a0.Z() == 9) {
                    a0.T();
                    return null;
                }
                return a0.K();
            }
            case 1: {
                if(a0.Z() == 9) {
                    a0.T();
                    return null;
                }
                return (float)a0.K();
            }
            default: {
                a0.i0();
                return null;
            }
        }
    }

    @Override  // com.google.gson.E
    public final void c(b b0, Object object0) {
        switch(this.a) {
            case 0: {
                if(((Number)object0) == null) {
                    b0.B();
                    return;
                }
                double f = ((Number)object0).doubleValue();
                n.a(f);
                b0.H(f);
                return;
            }
            case 1: {
                Number number0 = (Number)object0;
                if(number0 == null) {
                    b0.B();
                    return;
                }
                float f1 = number0.floatValue();
                n.a(f1);
                if(!(number0 instanceof Float)) {
                    number0 = f1;
                }
                b0.N(number0);
                return;
            }
            default: {
                b0.B();
            }
        }
    }

    @Override
    public String toString() {
        return this.a == 2 ? "AnonymousOrNonStaticLocalClassAdapter" : super.toString();
    }
}

