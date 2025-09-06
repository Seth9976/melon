package j5;

import C0.c;
import kotlin.jvm.internal.q;

public final class e extends g {
    public final c a;

    public e(c c0) {
        this.a = c0;
    }

    @Override  // j5.g
    public final c a() {
        return this.a;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof e ? q.b(this.a, ((e)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a == null ? 0 : this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "Loading(painter=" + this.a + ')';
    }
}

