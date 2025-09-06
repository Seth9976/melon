package com.google.protobuf;

import java.util.Collections;
import java.util.Map;

public final class g1 {
    public final Map a;
    public static volatile g1 b;
    public static final g1 c;

    static {
        g1.c = new g1();
    }

    public g1() {
        this.a = Collections.EMPTY_MAP;
    }

    public final y1 a(int v, l2 l20) {
        f1 f10 = new f1(v, l20);
        return (y1)this.a.get(f10);
    }

    public static g1 b() {
        g1 g10 = g1.b;
        if(g10 == null) {
            synchronized(g1.class) {
                g1 g11 = g1.b;
                if(g11 == null) {
                    g1 g12 = null;
                    Class class1 = e1.a;
                    if(class1 != null) {
                        try {
                            g12 = (g1)class1.getDeclaredMethod("getEmptyRegistry", null).invoke(null, null);
                        }
                        catch(Exception unused_ex) {
                        }
                    }
                    g11 = g12 == null ? g1.c : g12;
                    g1.b = g11;
                }
                return g11;
            }
        }
        return g10;
    }
}

