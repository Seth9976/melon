package j5;

import C0.c;
import kotlin.jvm.internal.q;
import t5.s;

public final class f extends g {
    public final c a;
    public final s b;

    public f(c c0, s s0) {
        this.a = c0;
        this.b = s0;
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
        if(!(object0 instanceof f)) {
            return false;
        }
        return q.b(this.a, ((f)object0).a) ? q.b(this.b, ((f)object0).b) : false;
    }

    @Override
    public final int hashCode() {
        return this.b.hashCode() + this.a.hashCode() * 0x1F;
    }

    @Override
    public final String toString() {
        return "Success(painter=" + this.a + ", result=" + this.b + ')';
    }
}

