package j5;

import A7.d;
import M.t;
import N0.k;
import r0.e;
import r0.q;

public final class w implements t {
    public final t a;
    public final l b;
    public final String c;
    public final e d;
    public final k e;
    public final float f;
    public final y0.t g;

    public w(t t0, l l0, String s, e e0, k k0, float f, y0.t t1) {
        this.a = t0;
        this.b = l0;
        this.c = s;
        this.d = e0;
        this.e = k0;
        this.f = f;
        this.g = t1;
    }

    @Override  // M.t
    public final q a(q q0, e e0) {
        return this.a.a(q0, e0);
    }

    // 去混淆评级： 中等(80)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 ? true : object0 instanceof w && kotlin.jvm.internal.q.b(this.a, ((w)object0).a) && this.b.equals(((w)object0).b) && kotlin.jvm.internal.q.b(this.c, ((w)object0).c) && kotlin.jvm.internal.q.b(this.d, ((w)object0).d) && kotlin.jvm.internal.q.b(this.e, ((w)object0).e) && Float.compare(this.f, ((w)object0).f) == 0 && kotlin.jvm.internal.q.b(this.g, ((w)object0).g);
    }

    @Override
    public final int hashCode() {
        int v = 0;
        int v1 = d.a(this.f, (this.e.hashCode() + (this.d.hashCode() + ((this.b.hashCode() + this.a.hashCode() * 0x1F) * 0x1F + (this.c == null ? 0 : this.c.hashCode())) * 0x1F) * 0x1F) * 0x1F, 0x1F);
        y0.t t0 = this.g;
        if(t0 != null) {
            v = t0.hashCode();
        }
        return 0x4CF + (v1 + v) * 0x1F;
    }

    @Override
    public final String toString() {
        return "RealSubcomposeAsyncImageScope(parentScope=" + this.a + ", painter=" + this.b + ", contentDescription=" + this.c + ", alignment=" + this.d + ", contentScale=" + this.e + ", alpha=" + this.f + ", colorFilter=" + this.g + ", clipToBounds=true)";
    }
}

