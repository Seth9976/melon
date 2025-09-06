package m;

import java.util.HashMap;

public final class a extends f {
    public final HashMap e;

    public a() {
        this.e = new HashMap();
    }

    @Override  // m.f
    public final c a(Object object0) {
        return (c)this.e.get(object0);
    }

    @Override  // m.f
    public final Object b(Object object0) {
        Object object1 = super.b(object0);
        this.e.remove(object0);
        return object1;
    }
}

