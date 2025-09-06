package U;

import we.k;

public final class d0 {
    public final k a;
    public final k b;
    public static final d0 c;

    static {
        d0.c = new d0(null, null, 0x3F);
    }

    public d0(k k0, k k1, int v) {
        if((v & 1) != 0) {
            k0 = null;
        }
        if((v & 16) != 0) {
            k1 = null;
        }
        super();
        this.a = k0;
        this.b = k1;
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 ? true : object0 instanceof d0 && this.a == ((d0)object0).a && this.b == ((d0)object0).b;
    }

    @Override
    public final int hashCode() {
        int v = 0;
        int v1 = this.a == null ? 0 : this.a.hashCode();
        k k0 = this.b;
        if(k0 != null) {
            v = k0.hashCode();
        }
        return (v1 * 0xE1781 + v) * 0x1F;
    }
}

