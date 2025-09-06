package r0;

import androidx.appcompat.app.o;
import we.n;

public final class k implements q {
    public final q a;
    public final q b;

    public k(q q0, q q1) {
        this.a = q0;
        this.b = q1;
    }

    // 去混淆评级： 低(20)
    @Override  // r0.q
    public final boolean all(we.k k0) {
        return this.a.all(k0) && this.b.all(k0);
    }

    // 去混淆评级： 低(20)
    @Override  // r0.q
    public final boolean any(we.k k0) {
        return this.a.any(k0) || this.b.any(k0);
    }

    // 去混淆评级： 低(30)
    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof k && kotlin.jvm.internal.q.b(this.a, ((k)object0).a) && kotlin.jvm.internal.q.b(this.b, ((k)object0).b);
    }

    @Override  // r0.q
    public final Object foldIn(Object object0, n n0) {
        Object object1 = this.a.foldIn(object0, n0);
        return this.b.foldIn(object1, n0);
    }

    @Override
    public final int hashCode() {
        return this.b.hashCode() * 0x1F + this.a.hashCode();
    }

    @Override
    public final String toString() {
        return o.r(new StringBuilder("["), ((String)this.foldIn("", j.f)), ']');
    }
}

