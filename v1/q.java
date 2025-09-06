package v1;

import A7.d;

public final class q {
    public final int a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final boolean e;

    public q(boolean z, r r0, boolean z1) {
        int v = z ? 0x40000 : 0x40008;
        if(r0 == r.b) {
            v |= 0x2000;
        }
        if(!z1) {
            v |= 0x200;
        }
        super();
        this.a = v;
        this.b = r0 == r.a;
        this.c = true;
        this.d = true;
        this.e = true;
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 ? true : object0 instanceof q && this.a == ((q)object0).a && this.b == ((q)object0).b && this.c == ((q)object0).c && this.d == ((q)object0).d && this.e == ((q)object0).e;
    }

    @Override
    public final int hashCode() {
        return d.e(d.e(d.e(d.e(this.a * 0x1F, 0x1F, this.b), 0x1F, this.c), 0x1F, this.d), 0x1F, this.e) + 0x4D5;
    }
}

