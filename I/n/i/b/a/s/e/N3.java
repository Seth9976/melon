package i.n.i.b.a.s.e;

import java.util.ArrayList;

public final class n3 implements sd {
    public final ArrayList a;
    public final long b;
    public long c;

    public n3(long v) {
        this.b = v;
        this.c = 0L;
        this.a = new ArrayList();
    }

    @Override  // i.n.i.b.a.s.e.sd
    public final rd b(long v) {
        ArrayList arrayList0 = this.a;
        if(arrayList0.isEmpty()) {
            return new rd(Nd.c, Nd.c);
        }
        long v1 = 0x7FFFFFFFFFFFFFFFL;
        long v2 = 0x7FFFFFFFFFFFFFFFL;
        for(Object object0: arrayList0) {
            o3 o30 = (o3)object0;
            int v3 = L7.y(o30.b, v, true);
            long v4 = o30.a[v3];
            if(v4 < v2) {
                v1 = o30.b[v3];
                v2 = v4;
            }
        }
        this.c = v1 == 0x7FFFFFFFFFFFFFFFL ? 0L : v1;
        Nd nd0 = new Nd(this.c, v2);
        return new rd(nd0, nd0);
    }

    @Override  // i.n.i.b.a.s.e.sd
    public final boolean b() {
        return this.a.size() > 0;
    }

    @Override  // i.n.i.b.a.s.e.sd
    public final long d() {
        return this.b;
    }
}

