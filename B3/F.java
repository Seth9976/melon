package b3;

import java.util.HashSet;

public abstract class F {
    public static final HashSet a;
    public static String b;

    static {
        F.a = new HashSet();
        F.b = "media3.common";
    }

    public static void a(String s) {
        synchronized(F.class) {
            if(F.a.add(s)) {
                F.b = "media3.common, " + s;
            }
        }
    }
}

