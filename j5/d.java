package j5;

import C0.c;
import kotlin.jvm.internal.q;
import t5.f;

public final class d extends g {
    public final c a;
    public final f b;

    public d(c c0, f f0) {
        this.a = c0;
        this.b = f0;
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
        if(!(object0 instanceof d)) {
            return false;
        }
        return q.b(this.a, ((d)object0).a) ? q.b(this.b, ((d)object0).b) : false;
    }

    @Override
    public final int hashCode() {
        return this.a == null ? this.b.hashCode() : this.b.hashCode() + this.a.hashCode() * 0x1F;
    }

    @Override
    public final String toString() {
        return "Error(painter=" + this.a + ", result=" + this.b + ')';
    }
}

