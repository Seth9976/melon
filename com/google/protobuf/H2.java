package com.google.protobuf;

public final class h2 {
    public final g2 a(Object object0, Object object1) {
        g2 g20 = (g2)object0;
        if(!((g2)object1).isEmpty()) {
            if(!g20.a) {
                g20 = g20.c();
            }
            g20.b();
            if(!((g2)object1).isEmpty()) {
                g20.putAll(((g2)object1));
            }
        }
        return g20;
    }
}

