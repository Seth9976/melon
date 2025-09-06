package n1;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import we.k;

public final class q {
    public final LinkedHashMap a;
    public final LinkedHashMap b;
    public final LinkedHashMap c;
    public final LinkedHashMap d;
    public final LinkedHashMap e;
    public final LinkedHashSet f;
    public final LinkedHashSet g;
    public final Object h;

    public q() {
        this.a = new LinkedHashMap();
        this.b = new LinkedHashMap();
        this.c = new LinkedHashMap();
        this.d = new LinkedHashMap();
        this.e = new LinkedHashMap();
        this.f = new LinkedHashSet();
        this.g = new LinkedHashSet();
        this.h = new Object();
    }

    public final void a() {
        u u0 = u.a ? new u() : null;
        if(u0 != null) {
            this.f.add(u0);
        }
    }

    public final void b(Object object0, k k0) {
        synchronized(this.h) {
            if(this.g.contains(object0)) {
                return;
            }
            this.g.add(object0);
        }
        k0.invoke(object0);
    }
}

