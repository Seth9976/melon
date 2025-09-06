package kc;

import A7.d;
import U4.x;
import kotlin.jvm.internal.q;

public final class h3 extends i3 {
    public final String a;
    public final String b;
    public final long c;

    public h3(String s, String s1, long v) {
        q.g(s, "pcId");
        q.g(s1, "trackId");
        super();
        this.a = s;
        this.b = s1;
        this.c = v;
    }

    @Override  // kc.i3
    public final String a() {
        return this.a;
    }

    public final long b() {
        return this.c;
    }

    public final String c() {
        return this.b;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof h3)) {
            return false;
        }
        if(!q.b(this.a, ((h3)object0).a)) {
            return false;
        }
        return q.b(this.b, ((h3)object0).b) ? this.c == ((h3)object0).c : false;
    }

    @Override
    public final int hashCode() {
        return Long.hashCode(this.c) + x.b(this.a.hashCode() * 0x1F, 0x1F, this.b);
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = d.o("SmartPlaylist(pcId=", this.a, ", trackId=", this.b, ", playedTime=");
        return x.h(this.c, ")", stringBuilder0);
    }
}

