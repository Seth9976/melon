package gd;

import A7.d;
import U4.x;
import Ud.a;
import Ud.h;
import com.iloen.melon.net.v6x.response.DjBrandDetailRecmSongListRes.RESPONSE.RECMSONGLIST;
import com.melon.ui.K4;
import k8.Y;
import kotlin.jvm.internal.q;

public final class z1 implements a, h, K4 {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final boolean i;
    public final RECMSONGLIST j;
    public final boolean k;
    public final boolean l;

    public z1(String s, String s1, String s2, String s3, String s4, boolean z, boolean z1, boolean z2, boolean z3, RECMSONGLIST djBrandDetailRecmSongListRes$RESPONSE$RECMSONGLIST0, boolean z4, boolean z5) {
        this.a = s;
        this.b = s1;
        this.c = s2;
        this.d = s3;
        this.e = s4;
        this.f = z;
        this.g = z1;
        this.h = z2;
        this.i = z3;
        this.j = djBrandDetailRecmSongListRes$RESPONSE$RECMSONGLIST0;
        this.k = z4;
        this.l = z5;
    }

    public static z1 a(z1 z10, boolean z, boolean z1, int v) {
        String s = z10.a;
        String s1 = z10.b;
        String s2 = z10.c;
        String s3 = z10.d;
        String s4 = z10.e;
        boolean z2 = z10.f;
        boolean z3 = z10.g;
        boolean z4 = z10.h;
        boolean z5 = z10.i;
        RECMSONGLIST djBrandDetailRecmSongListRes$RESPONSE$RECMSONGLIST0 = z10.j;
        if((v & 0x400) != 0) {
            z = z10.k;
        }
        z10.getClass();
        return new z1(s, s1, s2, s3, s4, z2, z3, z4, z5, djBrandDetailRecmSongListRes$RESPONSE$RECMSONGLIST0, z, ((v & 0x800) == 0 ? z1 : z10.l));
    }

    // 去混淆评级： 中等(70)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof z1 && q.b(this.a, ((z1)object0).a) && q.b(this.b, ((z1)object0).b) && q.b(this.c, ((z1)object0).c) && q.b(this.d, ((z1)object0).d) && q.b(this.e, ((z1)object0).e) && this.f == ((z1)object0).f && this.g == ((z1)object0).g && this.h == ((z1)object0).h && this.i == ((z1)object0).i && this.j.equals(((z1)object0).j) && this.k == ((z1)object0).k && this.l == ((z1)object0).l;
    }

    @Override
    public final int hashCode() {
        int v = 0;
        int v1 = this.a == null ? 0 : this.a.hashCode();
        int v2 = this.b == null ? 0 : this.b.hashCode();
        int v3 = this.c == null ? 0 : this.c.hashCode();
        int v4 = this.d == null ? 0 : this.d.hashCode();
        String s = this.e;
        if(s != null) {
            v = s.hashCode();
        }
        return Boolean.hashCode(this.l) + d.e((this.j.hashCode() + d.e(d.e(d.e(d.e(((((v1 * 0x1F + v2) * 0x1F + v3) * 0x1F + v4) * 0x1F + v) * 0x1F, 0x1F, this.f), 0x1F, this.g), 0x1F, this.h), 0x1F, this.i)) * 0x1F, 0x1F, this.k);
    }

    @Override  // Ud.a
    public final boolean isMarquee() {
        return this.l;
    }

    @Override  // Ud.h
    public final boolean isSelected() {
        return this.k;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = d.o("MelonDjBrandRecommendSongItemUiState(songId=", this.a, ", title=", this.b, ", artist=");
        d.u(stringBuilder0, this.c, ", albumId=", this.d, ", thumbnailUrl=");
        Y.x(stringBuilder0, this.e, ", canService=", this.f, ", isAdult=");
        x.y(stringBuilder0, this.g, ", isFree=", this.h, ", isHoldBack=");
        stringBuilder0.append(this.i);
        stringBuilder0.append(", songInfoBase=");
        stringBuilder0.append(this.j);
        stringBuilder0.append(", isSelected=");
        stringBuilder0.append(this.k);
        stringBuilder0.append(", isMarquee=");
        stringBuilder0.append(this.l);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }
}

