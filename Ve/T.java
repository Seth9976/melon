package Ve;

import kotlin.jvm.internal.q;

public final class t extends M {
    public final s a;

    public t(s s0) {
        this.a = s0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof t ? q.b(this.a, ((t)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "AnnotationValue(" + this.a + ')';
    }
}

