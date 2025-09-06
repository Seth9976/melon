package gd;

import A7.d;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import kotlin.jvm.internal.q;

public final class c8 {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final StatsElementsBase g;

    public c8(String s, String s1, String s2, String s3, String s4, String s5, StatsElementsBase statsElementsBase0) {
        this.a = s;
        this.b = s1;
        this.c = s2;
        this.d = s3;
        this.e = s4;
        this.f = s5;
        this.g = statsElementsBase0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof c8)) {
            return false;
        }
        if(!q.b(this.a, ((c8)object0).a)) {
            return false;
        }
        if(!q.b(this.b, ((c8)object0).b)) {
            return false;
        }
        if(!q.b(this.c, ((c8)object0).c)) {
            return false;
        }
        if(!q.b(this.d, ((c8)object0).d)) {
            return false;
        }
        if(!q.b(this.e, ((c8)object0).e)) {
            return false;
        }
        return q.b(this.f, ((c8)object0).f) ? q.b(this.g, ((c8)object0).g) : false;
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
        StatsElementsBase statsElementsBase0 = this.g;
        if(statsElementsBase0 != null) {
            v = statsElementsBase0.hashCode();
        }
        return (((((v1 * 0x1F + v2) * 0x1F + v3) * 0x1F + v4) * 0x1F + v5) * 0x1F + v6) * 0x1F + v;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = d.o("RecommendTagPlayListData(playlistTitle=", this.a, ", imageUrl=", this.b, ", likeCount=");
        d.u(stringBuilder0, this.c, ", contentsTypeCode=", this.d, ", playlistSeq=");
        d.u(stringBuilder0, this.e, ", ownerNickName=", this.f, ", statsElementsBase=");
        stringBuilder0.append(this.g);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }
}

