package androidx.compose.runtime;

import kotlin.jvm.internal.q;

public final class d1 implements e1 {
    public final Object a;

    public d1(Object object0) {
        this.a = object0;
    }

    @Override  // androidx.compose.runtime.e1
    public final Object a(i0 i00) {
        return this.a;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof d1 ? q.b(this.a, ((d1)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a == null ? 0 : this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "StaticValueHolder(value=" + this.a + ')';
    }
}

