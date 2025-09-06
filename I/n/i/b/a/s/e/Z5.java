package i.n.i.b.a.s.e;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class z5 {
    public final u a;
    public final String b;
    public final long c;
    public final List d;
    public final R4 e;

    public z5(u u0, String s, k6 k60, ArrayList arrayList0) {
        this.a = u0;
        this.b = s;
        this.d = Collections.unmodifiableList(arrayList0);
        this.e = k60.a(this);
        this.c = L7.C(k60.c, 1000000L, k60.b);
    }

    public abstract String e();

    public abstract Wc f();

    public abstract R4 i();
}

