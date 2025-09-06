package e1;

import kotlin.jvm.internal.q;

public final class f {
    public final H a;

    public f(H h0) {
        this.a = h0;
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof f && q.b(this.a, ((f)object0).a);
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode() * 0x1F;
    }

    @Override
    public final String toString() {
        return "Key(font=" + this.a + ", loaderKey=null)";
    }
}

