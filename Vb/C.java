package vb;

import A7.d;
import Q0.a;
import U4.x;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import kotlin.jvm.internal.q;

public final class c extends a {
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final ContsTypeCode g;

    public c(String s, String s1, String s2, String s3) {
        q.g(s, "contentsId");
        q.g(s1, "castTitle");
        q.g(s2, "castImgUrl");
        super();
        this.c = s;
        this.d = s1;
        this.e = s2;
        this.f = s3;
        q.f(ContsTypeCode.RADIO_CAST, "RADIO_CAST");
        this.g = ContsTypeCode.RADIO_CAST;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof c)) {
            return false;
        }
        if(!q.b(this.c, ((c)object0).c)) {
            return false;
        }
        if(!q.b(this.d, ((c)object0).d)) {
            return false;
        }
        return q.b(this.e, ((c)object0).e) ? q.b(this.f, ((c)object0).f) : false;
    }

    @Override  // Q0.a
    public final String h() {
        return this.c;
    }

    @Override
    public final int hashCode() {
        return this.f.hashCode() + x.b(x.b(this.c.hashCode() * 0x1F, 0x1F, this.d), 0x1F, this.e);
    }

    @Override  // Q0.a
    public final ContsTypeCode i() {
        return this.g;
    }

    @Override
    public final String toString() {
        return d.n(d.o("CastSharableProperties(contentsId=", this.c, ", castTitle=", this.d, ", castImgUrl="), this.e, ", creatorNames=", this.f, ")");
    }
}

