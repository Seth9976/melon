package androidx.compose.runtime;

import kotlin.jvm.internal.q;

public final class I implements e1 {
    public final b0 a;

    public I(b0 b00) {
        this.a = b00;
    }

    @Override  // androidx.compose.runtime.e1
    public final Object a(i0 i00) {
        return ((O0)this.a).getValue();
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof I ? q.b(this.a, ((I)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "DynamicValueHolder(state=" + this.a + ')';
    }
}

