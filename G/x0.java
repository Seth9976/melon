package G;

import kotlin.jvm.internal.q;

public final class x0 implements z {
    public final int a;
    public final int b;
    public final A c;

    public x0(int v, int v1, A a0) {
        this.a = v;
        this.b = v1;
        this.c = a0;
    }

    public x0(int v, A a0, int v1) {
        if((v1 & 4) != 0) {
            a0 = C.a;
        }
        this(v, ((v1 & 2) == 0 ? 400 : 0), a0);
    }

    @Override  // G.o
    public final A0 a(y0 y00) {
        return new I0(this.a, this.b, this.c);
    }

    @Override  // G.z
    public final C0 a(y0 y00) {
        return new I0(this.a, this.b, this.c);
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof x0 && ((x0)object0).a == this.a && ((x0)object0).b == this.b && q.b(((x0)object0).c, this.c);
    }

    @Override
    public final int hashCode() {
        return (this.c.hashCode() + this.a * 0x1F) * 0x1F + this.b;
    }
}

