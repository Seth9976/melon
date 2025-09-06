package vb;

import Q0.a;
import U4.x;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import kotlin.jvm.internal.q;

public final class d extends a {
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final ContsTypeCode h;

    public d(String s, String s1, String s2, String s3, String s4) {
        q.g(s, "contentsId");
        super();
        this.c = s;
        this.d = s1;
        this.e = s2;
        this.f = s3;
        this.g = s4;
        q.f(ContsTypeCode.DJ_PLAYLIST, "DJ_PLAYLIST");
        this.h = ContsTypeCode.DJ_PLAYLIST;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof d)) {
            return false;
        }
        if(!q.b(this.c, ((d)object0).c)) {
            return false;
        }
        if(!q.b(this.d, ((d)object0).d)) {
            return false;
        }
        if(!q.b(this.e, ((d)object0).e)) {
            return false;
        }
        return q.b(this.f, ((d)object0).f) ? q.b(this.g, ((d)object0).g) : false;
    }

    @Override  // Q0.a
    public final String h() {
        return this.c;
    }

    @Override
    public final int hashCode() {
        int v = this.c.hashCode();
        int v1 = 0;
        int v2 = this.d == null ? 0 : this.d.hashCode();
        int v3 = this.e == null ? 0 : this.e.hashCode();
        int v4 = this.f == null ? 0 : this.f.hashCode();
        String s = this.g;
        if(s != null) {
            v1 = s.hashCode();
        }
        return (((v * 0x1F + v2) * 0x1F + v3) * 0x1F + v4) * 0x1F + v1;
    }

    @Override  // Q0.a
    public final ContsTypeCode i() {
        return this.h;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = A7.d.o("DJPlaylistSharableProperties(contentsId=", this.c, ", playlistTitle=", this.d, ", ownerNicknames=");
        A7.d.u(stringBuilder0, this.e, ", ownerMemberKey=", this.f, ", songCount=");
        return x.m(stringBuilder0, this.g, ")");
    }
}

