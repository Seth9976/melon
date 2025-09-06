package i.n.i.b.a.s.e;

import java.util.Comparator;

public final class k8 implements Comparator {
    public final Comparator a;
    public final Ma b;

    public k8(Comparator comparator0, Ma ma0) {
        this.a = comparator0;
        this.b = ma0;
    }

    @Override
    public final int compare(Object object0, Object object1) {
        u u0 = this.b.f(object0);
        u u1 = this.b.f(object1);
        return this.a.compare(u0, u1);
    }
}

