package i.n.i.b.a.s.e;

import java.util.HashSet;

public abstract class pa {
    public static final HashSet a;
    public static String b;

    static {
        pa.a = new HashSet();
        pa.b = "goog.exo.core";
    }

    public static void a(String s) {
        synchronized(pa.class) {
            if(pa.a.add(s)) {
                pa.b = pa.b + ", " + s;
            }
        }
    }
}

