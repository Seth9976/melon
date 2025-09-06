package gd;

import A7.d;
import kotlin.jvm.internal.q;

public final class w extends B {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;

    public w(String s, String s1, String s2, String s3, String s4, String s5) {
        this.a = s;
        this.b = s1;
        this.c = s2;
        this.d = s3;
        this.e = s4;
        this.f = s5;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof w)) {
            return false;
        }
        if(!q.b(this.a, ((w)object0).a)) {
            return false;
        }
        if(!q.b(this.b, ((w)object0).b)) {
            return false;
        }
        if(!q.b(this.c, ((w)object0).c)) {
            return false;
        }
        if(!q.b(this.d, ((w)object0).d)) {
            return false;
        }
        return q.b(this.e, ((w)object0).e) ? q.b(this.f, ((w)object0).f) : false;
    }

    @Override
    public final int hashCode() {
        int v = 0;
        int v1 = this.a == null ? 0 : this.a.hashCode();
        int v2 = this.b == null ? 0 : this.b.hashCode();
        int v3 = this.c == null ? 0 : this.c.hashCode();
        int v4 = this.d == null ? 0 : this.d.hashCode();
        int v5 = this.e == null ? 0 : this.e.hashCode();
        String s = this.f;
        if(s != null) {
            v = s.hashCode();
        }
        return ((((v1 * 0x1F + v2) * 0x1F + v3) * 0x1F + v4) * 0x1F + v5) * 0x1F + v;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = d.o("DjHomePowerDjPlaylistSubContentListItem(thumbImg=", this.a, ", playlistTitle=", this.b, ", memberKey=");
        d.u(stringBuilder0, this.c, ", memberNickName=", this.d, ", playlistSeq=");
        return d.n(stringBuilder0, this.e, ", ownerNickName=", this.f, ")");
    }
}

