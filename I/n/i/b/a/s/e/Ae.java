package i.n.i.b.a.s.e;

import U4.x;

public final class ae {
    public final long a;
    public final long b;
    public final long c;

    public ae(long v, long v1, long v2) {
        this.a = v;
        this.b = v1;
        this.c = v2;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("Sample(");
        stringBuilder0.append(this.a);
        stringBuilder0.append("/");
        stringBuilder0.append(this.b);
        stringBuilder0.append(",");
        return x.h(this.a * 8L / (this.b + 1L), "Kbps)", stringBuilder0);
    }
}

