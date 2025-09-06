package gd;

import A7.d;
import kotlin.jvm.internal.q;

public final class v extends B {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    public final String j;

    public v(String s, String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8, String s9) {
        this.a = s;
        this.b = s1;
        this.c = s2;
        this.d = s3;
        this.e = s4;
        this.f = s5;
        this.g = s6;
        this.h = s7;
        this.i = s8;
        this.j = s9;
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
        if(!q.b(this.b, ((v)object0).b)) {
            return false;
        }
        if(!q.b(this.c, ((v)object0).c)) {
            return false;
        }
        if(!q.b(this.d, ((v)object0).d)) {
            return false;
        }
        if(!q.b(this.e, ((v)object0).e)) {
            return false;
        }
        if(!q.b(this.f, ((v)object0).f)) {
            return false;
        }
        if(!q.b(this.g, ((v)object0).g)) {
            return false;
        }
        if(!q.b(this.h, ((v)object0).h)) {
            return false;
        }
        return q.b(this.i, ((v)object0).i) ? q.b(this.j, ((v)object0).j) : false;
    }

    @Override
    public final int hashCode() {
        int v = 0;
        int v1 = this.a == null ? 0 : this.a.hashCode();
        int v2 = this.b == null ? 0 : this.b.hashCode();
        int v3 = this.c == null ? 0 : this.c.hashCode();
        int v4 = this.d == null ? 0 : this.d.hashCode();
        int v5 = this.e == null ? 0 : this.e.hashCode();
        int v6 = this.f == null ? 0 : this.f.hashCode();
        int v7 = this.g == null ? 0 : this.g.hashCode();
        int v8 = this.h == null ? 0 : this.h.hashCode();
        int v9 = this.i == null ? 0 : this.i.hashCode();
        String s = this.j;
        if(s != null) {
            v = s.hashCode();
        }
        return ((((((((v1 * 0x1F + v2) * 0x1F + v3) * 0x1F + v4) * 0x1F + v5) * 0x1F + v6) * 0x1F + v7) * 0x1F + v8) * 0x1F + v9) * 0x1F + v;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = d.o("DjHomePopularPlaylistSubContentListItem(thumbUrl=", this.a, ", title=", this.b, ", artist=");
        d.u(stringBuilder0, this.c, ", rankType=", this.d, ", rankText=");
        d.u(stringBuilder0, this.e, ", rankGap=", this.f, ", playlistSeq=");
        d.u(stringBuilder0, this.g, ", playlistTitle=", this.h, ", ownerNickName=");
        return d.n(stringBuilder0, this.i, ", ownerMemberKey=", this.j, ")");
    }
}

