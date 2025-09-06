package gd;

import A7.d;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import kotlin.jvm.internal.q;

public final class q4 extends r4 {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final StatsElementsBase i;
    public final String j;
    public final String k;
    public final String l;
    public final String m;
    public final String n;

    public q4(String s, String s1, String s2, String s3, String s4, String s5, String s6, String s7, StatsElementsBase statsElementsBase0, String s8, String s9, String s10, String s11, String s12) {
        this.a = s;
        this.b = s1;
        this.c = s2;
        this.d = s3;
        this.e = s4;
        this.f = s5;
        this.g = s6;
        this.h = s7;
        this.i = statsElementsBase0;
        this.j = s8;
        this.k = s9;
        this.l = s10;
        this.m = s11;
        this.n = s12;
    }

    // 去混淆评级： 中等(160)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 ? true : object0 instanceof q4 && q.b(this.a, ((q4)object0).a) && q.b(this.b, ((q4)object0).b) && q.b(this.c, ((q4)object0).c) && q.b(this.d, ((q4)object0).d) && q.b(this.e, ((q4)object0).e) && q.b(this.f, ((q4)object0).f) && q.b(this.g, ((q4)object0).g) && q.b(this.h, ((q4)object0).h) && q.b(this.i, ((q4)object0).i) && q.b(this.j, ((q4)object0).j) && q.b(this.k, ((q4)object0).k) && q.b(this.l, ((q4)object0).l) && q.b(this.m, ((q4)object0).m) && q.b(this.n, ((q4)object0).n);
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
        int v10 = this.j == null ? 0 : this.j.hashCode();
        int v11 = this.k == null ? 0 : this.k.hashCode();
        int v12 = this.l == null ? 0 : this.l.hashCode();
        int v13 = this.m == null ? 0 : this.m.hashCode();
        String s = this.n;
        if(s != null) {
            v = s.hashCode();
        }
        return 0x4CF + (((((((((((((v1 * 0x1F + v2) * 0x1F + v3) * 0x1F + v4) * 0x1F + v5) * 0x1F + v6) * 0x1F + v7) * 0x1F + v8) * 0x1F + v9) * 0x1F + v10) * 0x1F + v11) * 0x1F + v12) * 0x1F + v13) * 0x1F + v) * 0x1F;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = d.o("PlaylistNewHolderWithoutTag(playlistTitle=", this.a, ", ownerNickname=", this.b, ", likeCount=");
        d.u(stringBuilder0, this.c, ", thumbImgUrl=", this.d, ", currentRank=");
        d.u(stringBuilder0, this.e, ", rankType=", this.f, ", rankGap=");
        d.u(stringBuilder0, this.g, ", playlistSeq=", this.h, ", statsElements=");
        stringBuilder0.append(this.i);
        stringBuilder0.append(", ownerMemberKey=");
        stringBuilder0.append(this.j);
        stringBuilder0.append(", fameregyn=");
        d.u(stringBuilder0, this.k, ", songCnt=", this.l, ", withDrawYN=");
        return d.n(stringBuilder0, this.m, ", deleteYN=", this.n, ", isOpen=true)");
    }
}

