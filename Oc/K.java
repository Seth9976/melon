package oc;

import A7.d;
import kotlin.jvm.internal.q;
import rc.n;

public final class k implements l {
    public final Q a;
    public final long b;

    public k(n n0, long v) {
        q.g(n0, "playlistState");
        super();
        this.a = n0;
        this.b = v;
    }

    // 去混淆评级： 低(30)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 ? true : object0 instanceof k && q.b(this.a, ((k)object0).a) && this.b == ((k)object0).b;
    }

    @Override
    public final int hashCode() {
        return d.c(this.a.hashCode() * 0x1F, 0x1F, this.b) + 0x4CF;
    }

    @Override
    public final String toString() {
        return "PlaylistChanged(playlistState=" + this.a + ", timePositionMs=" + this.b + ", play=true)";
    }
}

