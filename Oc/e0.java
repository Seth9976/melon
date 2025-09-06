package oc;

import kotlin.jvm.internal.q;

public final class e0 implements f0 {
    public final Q a;
    public final long b;

    public e0(Q q0, long v) {
        q.g(q0, "playlistState");
        super();
        this.a = q0;
        this.b = v;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof e0)) {
            return false;
        }
        return q.b(this.a, ((e0)object0).a) ? this.b == ((e0)object0).b : false;
    }

    @Override
    public final int hashCode() {
        return Long.hashCode(this.b) + this.a.hashCode() * 0x1F;
    }

    @Override
    public final String toString() {
        return "Success(playlistState=" + this.a + ", timePositionMs=" + this.b + ")";
    }
}

