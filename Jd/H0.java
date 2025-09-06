package jd;

import gd.Z3;
import kotlin.jvm.internal.q;

public final class h0 extends Z3 {
    public final String a;
    public final String b;

    public h0(String s, String s1) {
        q.g(s, "albumId");
        super();
        this.a = s;
        this.b = s1;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof h0)) {
            return false;
        }
        return q.b(this.a, ((h0)object0).a) ? q.b(this.b, ((h0)object0).b) : false;
    }

    @Override
    public final int hashCode() {
        int v = this.a.hashCode();
        return this.b == null ? v * 0x1F : v * 0x1F + this.b.hashCode();
    }

    @Override
    public final String toString() {
        return "UpdateColorList(albumId=" + this.a + ", albumImgUrl=" + this.b + ")";
    }
}

