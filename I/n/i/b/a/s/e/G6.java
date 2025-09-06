package i.n.i.b.a.s.e;

import java.util.List;

public final class g6 extends f6 {
    public final List j;

    public g6(R4 r40, long v, long v1, long v2, long v3, List list0, long v4, List list1, long v5, long v6) {
        super(r40, v, v1, v2, v3, list0, v4, v5, v6);
        this.j = list1;
    }

    @Override  // i.n.i.b.a.s.e.f6
    public final long b(long v) {
        return (long)this.j.size();
    }

    @Override  // i.n.i.b.a.s.e.f6
    public final R4 d(x5 x50, long v) {
        return (R4)this.j.get(((int)(v - this.d)));
    }

    @Override  // i.n.i.b.a.s.e.f6
    public final boolean h() {
        return true;
    }
}

