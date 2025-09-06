package vb;

import A7.d;
import Q0.a;
import U4.x;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import kotlin.jvm.internal.q;

public final class b extends a {
    public final String c;
    public final String d;
    public final String e;
    public final ContsTypeCode f;

    public b(String s, String s1, String s2) {
        q.g(s, "contentsId");
        q.g(s1, "memberKey");
        q.g(s2, "nickname");
        super();
        this.c = s;
        this.d = s1;
        this.e = s2;
        q.f(ContsTypeCode.UNKNOWN, "UNKNOWN");
        this.f = ContsTypeCode.UNKNOWN;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof b)) {
            return false;
        }
        if(!q.b(this.c, ((b)object0).c)) {
            return false;
        }
        return q.b(this.d, ((b)object0).d) ? q.b(this.e, ((b)object0).e) : false;
    }

    @Override  // Q0.a
    public final String h() {
        return this.c;
    }

    @Override
    public final int hashCode() {
        return this.e.hashCode() + x.b(this.c.hashCode() * 0x1F, 0x1F, this.d);
    }

    @Override  // Q0.a
    public final ContsTypeCode i() {
        return this.f;
    }

    @Override
    public final String toString() {
        return x.m(d.o("BrandDjSharableProperties(contentsId=", this.c, ", memberKey=", this.d, ", nickname="), this.e, ")");
    }
}

