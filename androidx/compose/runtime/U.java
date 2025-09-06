package androidx.compose.runtime;

import q0.a;

public final class u implements a {
    public final v a;

    public u(v v0) {
        this.a = v0;
    }

    @Override  // q0.a
    public final Iterable d() {
        this.a.f.getClass();
        return this.a.f;
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof u && this.a.equals(((u)object0).a);
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode() * 0x1F;
    }
}

