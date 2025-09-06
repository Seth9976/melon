package androidx.glance.appwidget.protobuf;

import java.util.Collections;
import java.util.Map;

public final class p {
    public final Map a;
    public static volatile p b;
    public static final p c;

    static {
        p.c = new p();
    }

    public p() {
        this.a = Collections.EMPTY_MAP;
    }

    public static p a() {
        p p0 = p.b;
        if(p0 == null) {
            synchronized(p.class) {
                p p1 = p.b;
                if(p1 == null) {
                    p p2 = null;
                    Class class1 = o.a;
                    if(class1 != null) {
                        try {
                            p2 = (p)class1.getDeclaredMethod("getEmptyRegistry", null).invoke(null, null);
                        }
                        catch(Exception unused_ex) {
                        }
                    }
                    p1 = p2 == null ? p.c : p2;
                    p.b = p1;
                }
                return p1;
            }
        }
        return p0;
    }
}

