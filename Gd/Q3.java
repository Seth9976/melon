package gd;

import A7.d;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import kotlin.jvm.internal.q;

public final class q3 extends r3 {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final StatsElementsBase g;
    public final String h;
    public final String i;
    public final String j;
    public final String k;
    public final boolean l;

    public q3(String s, String s1, String s2, String s3, String s4, String s5, StatsElementsBase statsElementsBase0, String s6, String s7, String s8, String s9, boolean z) {
        this.a = s;
        this.b = s1;
        this.c = s2;
        this.d = s3;
        this.e = s4;
        this.f = s5;
        this.g = statsElementsBase0;
        this.h = s6;
        this.i = s7;
        this.j = s8;
        this.k = s9;
        this.l = z;
    }

    // 去混淆评级： 中等(120)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof q3 && q.b(this.a, ((q3)object0).a) && q.b(this.b, ((q3)object0).b) && q.b(this.c, ((q3)object0).c) && q.b(this.d, ((q3)object0).d) && q.b(this.e, ((q3)object0).e) && q.b(this.f, ((q3)object0).f) && q.b(this.g, ((q3)object0).g) && q.b(this.h, ((q3)object0).h) && q.b(this.i, ((q3)object0).i) && q.b(this.j, ((q3)object0).j) && q.b(this.k, ((q3)object0).k) && this.l == ((q3)object0).l;
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
        String s = this.k;
        if(s != null) {
            v = s.hashCode();
        }
        return Boolean.hashCode(this.l) + ((((((((((v1 * 0x1F + v2) * 961 + v3) * 0x1F + v4) * 0x1F + v5) * 0x1F + v6) * 0x1F + v7) * 0x1F + v8) * 0x1F + v9) * 0x1F + v10) * 0x1F + v) * 0x1F;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = d.o("PlaylistItemUiState(playlistSeq=", this.a, ", thumbnailUrl=", this.b, ", rankData=null, playlistTitle=");
        d.u(stringBuilder0, this.c, ", ownerMemberKey=", this.d, ", ownerNickname=");
        d.u(stringBuilder0, this.e, ", likeCount=", this.f, ", statsElements=");
        stringBuilder0.append(this.g);
        stringBuilder0.append(", fameregyn=");
        stringBuilder0.append(this.h);
        stringBuilder0.append(", songCnt=");
        d.u(stringBuilder0, this.i, ", withDrawYN=", this.j, ", deleteYN=");
        stringBuilder0.append(this.k);
        stringBuilder0.append(", isOpen=");
        stringBuilder0.append(this.l);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }
}

