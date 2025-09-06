package p1;

import kotlin.jvm.internal.q;

public final class a {
    public final String a;

    public a(String s) {
        this.a = s;
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof a && q.b(this.a, ((a)object0).a);
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return this.a;
    }
}

