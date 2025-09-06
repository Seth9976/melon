package Vc;

import A7.d;
import U4.x;
import kotlin.jvm.internal.q;

public final class v {
    public final String a;
    public final String b;
    public final String c;

    public v(String s, String s1, String s2) {
        this.a = s;
        this.b = s1;
        this.c = s2;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof v)) {
            return false;
        }
        if(!q.b(this.a, ((v)object0).a)) {
            return false;
        }
        return q.b(this.b, ((v)object0).b) ? q.b(this.c, ((v)object0).c) : false;
    }

    @Override
    public final int hashCode() {
        int v = 0;
        int v1 = this.a == null ? 0 : this.a.hashCode();
        int v2 = this.b == null ? 0 : this.b.hashCode();
        String s = this.c;
        if(s != null) {
            v = s.hashCode();
        }
        return (v1 * 0x1F + v2) * 0x1F + v;
    }

    @Override
    public final String toString() {
        return x.m(d.o("MediaDisplayState(artistUrl=", this.a, ", albumUrl=", this.b, ", songId="), this.c, ")");
    }
}

