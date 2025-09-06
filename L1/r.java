package l1;

import r1.o;

public final class r {
    public final long a;
    public final long b;
    public static final r c;

    // 去混淆评级： 低(20)
    static {
        r.c = new r(0x100000000L, 0x100000000L);
    }

    public r(long v, long v1) {
        this.a = v;
        this.b = v1;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof r)) {
            return false;
        }
        return o.a(this.a, ((r)object0).a) ? o.a(this.b, ((r)object0).b) : false;
    }

    @Override
    public final int hashCode() {
        return Long.hashCode(this.b) + Long.hashCode(this.a) * 0x1F;
    }

    @Override
    public final String toString() {
        return "TextIndent(firstLine=" + o.d(this.a) + ", restLine=" + o.d(this.b) + ')';
    }
}

