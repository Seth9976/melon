package o1;

import G.j0;
import G.t0;
import je.p;
import n1.c;

public final class a implements b {
    public final int a;
    public Object b;
    public Object c;

    public a() {
        this.a = 0;
        super();
    }

    public a(c c0) {
        this.a = 1;
        super();
        this.b = c0;
        this.c = ((Boolean)c0.a.c()).booleanValue() ? "Exit" : "Enter";
    }

    @Override  // o1.b
    public final long a() {
        if(this.a != 0) {
            Object object0 = p.n0(0, ((c)this.b).a.j);
            t0 t00 = object0 instanceof t0 ? ((t0)object0) : null;
            return t00 == null ? 0L : (((Number)t00.l.getValue()).longValue() + 0xF423FL) / 1000000L;
        }
        return (((j0)this.c).e() + 0xF423FL) / 1000000L;
    }
}

