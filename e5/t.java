package e5;

import U4.w;
import V4.b;
import d5.j;
import java.util.HashMap;

public final class t {
    public final b a;
    public final HashMap b;
    public final HashMap c;
    public final Object d;
    public static final String e;

    static {
        t.e = "WM-WorkTimer";
    }

    public t(b b0) {
        this.b = new HashMap();
        this.c = new HashMap();
        this.d = new Object();
        this.a = b0;
    }

    public final void a(j j0) {
        synchronized(this.d) {
            if(((s)this.b.remove(j0)) != null) {
                w.e().a("WM-WorkTimer", "Stopping timer for " + j0);
                this.c.remove(j0);
            }
        }
    }
}

