package androidx.compose.runtime;

import kotlin.jvm.internal.q;

public final class z0 {
    public final l a;

    public z0(l l0) {
        this.a = l0;
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof z0 && q.b(this.a, ((z0)object0).a);
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "SkippableUpdater(composer=" + this.a + ')';
    }
}

