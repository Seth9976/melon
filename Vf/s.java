package vf;

import kotlin.jvm.internal.q;

public final class s extends t {
    public final f a;

    public s(f f0) {
        this.a = f0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof s ? q.b(this.a, ((s)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "NormalClass(value=" + this.a + ')';
    }
}

