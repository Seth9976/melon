package e1;

import kotlin.jvm.internal.q;

public final class e {
    public final Object a;

    public e(Object object0) {
        this.a = object0;
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof e && q.b(this.a, ((e)object0).a);
    }

    @Override
    public final int hashCode() {
        return this.a == null ? 0 : this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "AsyncTypefaceResult(result=" + this.a + ')';
    }
}

