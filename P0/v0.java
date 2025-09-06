package P0;

import N0.N;
import kotlin.jvm.internal.q;

public final class v0 implements s0 {
    public final N a;
    public final P b;

    public v0(N n0, P p0) {
        this.a = n0;
        this.b = p0;
    }

    @Override  // P0.s0
    public final boolean G() {
        return this.b.x0().h();
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof v0)) {
            return false;
        }
        return q.b(this.a, ((v0)object0).a) ? q.b(this.b, ((v0)object0).b) : false;
    }

    @Override
    public final int hashCode() {
        return this.b.hashCode() + this.a.hashCode() * 0x1F;
    }

    @Override
    public final String toString() {
        return "PlaceableResult(result=" + this.a + ", placeable=" + this.b + ')';
    }
}

