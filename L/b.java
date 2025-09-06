package l;

import e1.G;

public final class b extends G {
    public final c g;
    public static volatile b h;
    public static final a i;

    static {
        b.i = new a(0);
    }

    public b() {
        this.g = new c();
    }

    public static b P() {
        if(b.h != null) {
            return b.h;
        }
        synchronized(b.class) {
            if(b.h == null) {
                b.h = new b();
            }
            return b.h;
        }
    }
}

