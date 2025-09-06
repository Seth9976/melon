package vb;

import A7.d;
import U4.x;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import kotlin.jvm.internal.q;

public final class a extends Q0.a {
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final ContsTypeCode g;

    public a(String s, String s1, String s2, String s3) {
        this.c = s;
        this.d = s1;
        this.e = s2;
        this.f = s3;
        q.f(ContsTypeCode.ALBUM, "ALBUM");
        this.g = ContsTypeCode.ALBUM;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof a)) {
            return false;
        }
        if(!q.b(this.c, ((a)object0).c)) {
            return false;
        }
        if(!q.b(this.d, ((a)object0).d)) {
            return false;
        }
        return q.b(this.e, ((a)object0).e) ? q.b(this.f, ((a)object0).f) : false;
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
        return d.n(d.o("AlbumSharableProperties(contentsId=", this.c, ", albumName=", this.d, ", issueDate="), this.e, ", artistNames=", this.f, ")");
    }
}

