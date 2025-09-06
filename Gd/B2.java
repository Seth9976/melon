package gd;

import A7.d;
import kotlin.jvm.internal.q;

public final class b2 extends e2 {
    public final String a;
    public final String b;
    public final String c;
    public final String d;

    public b2(String s, String s1, String s2, String s3) {
        this.a = s;
        this.b = s1;
        this.c = s2;
        this.d = s3;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof b2)) {
            return false;
        }
        if(!q.b(this.a, ((b2)object0).a)) {
            return false;
        }
        if(!q.b(this.b, ((b2)object0).b)) {
            return false;
        }
        return q.b(this.c, ((b2)object0).c) ? q.b(this.d, ((b2)object0).d) : false;
    }

    @Override
    public final int hashCode() {
        int v = 0;
        int v1 = this.a == null ? 0 : this.a.hashCode();
        int v2 = this.b == null ? 0 : this.b.hashCode();
        int v3 = this.c == null ? 0 : this.c.hashCode();
        String s = this.d;
        if(s != null) {
            v = s.hashCode();
        }
        return ((v1 * 0x1F + v2) * 0x1F + v3) * 0x1F + v;
    }

    @Override
    public final String toString() {
        return d.n(d.o("CastItemUiState(castSeq=", this.a, ", castTitle=", this.b, ", castDate="), this.c, ", castImgUrl=", this.d, ")");
    }
}

