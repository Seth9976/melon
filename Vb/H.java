package vb;

import A7.d;
import Q0.a;
import U4.x;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import kotlin.jvm.internal.q;

public final class h extends a {
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final ContsTypeCode h;

    public h(String s, String s1, String s2, String s3, String s4) {
        q.g(s, "contentsId");
        super();
        this.c = s;
        this.d = s1;
        this.e = s2;
        this.f = s3;
        this.g = s4;
        q.f(ContsTypeCode.PLAYLIST, "PLAYLIST");
        this.h = ContsTypeCode.PLAYLIST;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof h)) {
            return false;
        }
        if(!q.b(this.c, ((h)object0).c)) {
            return false;
        }
        if(!q.b(this.d, ((h)object0).d)) {
            return false;
        }
        if(!q.b(this.e, ((h)object0).e)) {
            return false;
        }
        return q.b(this.f, ((h)object0).f) ? q.b(this.g, ((h)object0).g) : false;
    }

    @Override  // Q0.a
    public final String h() {
        return this.c;
    }

    @Override
    public final int hashCode() {
        int v = 0;
        int v1 = x.b((x.b(this.c.hashCode() * 0x1F, 0x1F, this.d) + (this.e == null ? 0 : this.e.hashCode())) * 0x1F, 0x1F, this.f);
        String s = this.g;
        if(s != null) {
            v = s.hashCode();
        }
        return v1 + v;
    }

    @Override  // Q0.a
    public final ContsTypeCode i() {
        return this.h;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = d.o("PlaylistSharableProperties(contentsId=", this.c, ", playlistName=", this.d, ", ownerMemberKey=");
        d.u(stringBuilder0, this.e, ", nicknames=", this.f, ", updateDateTime=");
        return x.m(stringBuilder0, this.g, ")");
    }
}

