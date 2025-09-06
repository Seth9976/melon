package qb;

import A7.d;
import U4.x;
import java.util.List;
import kotlin.jvm.internal.q;

public final class j extends u {
    public final String a;
    public final String b;
    public final boolean c;
    public final boolean d;
    public final boolean e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final boolean i;
    public final boolean j;
    public final List k;
    public final boolean l;

    public j(String s, String s1, List list0, boolean z, boolean z1, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8) {
        q.g(list0, "itemList");
        super();
        this.a = s;
        this.b = s1;
        this.c = z;
        this.d = z1;
        this.e = z2;
        this.f = z3;
        this.g = z4;
        this.h = z5;
        this.i = z6;
        this.j = z7;
        this.k = list0;
        this.l = z8;
    }

    // 去混淆评级： 低(40)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof j && q.b(this.a, ((j)object0).a) && q.b(this.b, ((j)object0).b) && this.c == ((j)object0).c && this.d == ((j)object0).d && this.e == ((j)object0).e && this.f == ((j)object0).f && this.g == ((j)object0).g && this.h == ((j)object0).h && this.i == ((j)object0).i && this.j == ((j)object0).j && q.b(this.k, ((j)object0).k) && this.l == ((j)object0).l;
    }

    @Override
    public final int hashCode() {
        int v = this.a == null ? 0 : this.a.hashCode();
        return this.b == null ? Boolean.hashCode(this.l) + d.d(d.e(d.e(d.e(d.e(d.e(d.e(d.e(d.e(d.e(v * 961, 0x1F, this.c), 0x1F, this.d), 0x1F, this.e), 0x1F, this.f), 0x1F, this.g), 0x1F, this.h), 0x1F, false), 0x1F, this.i), 0x1F, this.j), 0x1F, this.k) : Boolean.hashCode(this.l) + d.d(d.e(d.e(d.e(d.e(d.e(d.e(d.e(d.e(d.e((v * 0x1F + this.b.hashCode()) * 0x1F, 0x1F, this.c), 0x1F, this.d), 0x1F, this.e), 0x1F, this.f), 0x1F, this.g), 0x1F, this.h), 0x1F, false), 0x1F, this.i), 0x1F, this.j), 0x1F, this.k);
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = d.o("ContextItemList(title=", this.a, ", subTitle=", this.b, ", isSongEnabled=");
        x.y(stringBuilder0, this.c, ", isAlbumEnabled=", this.d, ", isArtistEnabled=");
        x.y(stringBuilder0, this.e, ", isMvEnabled=", this.f, ", isLikeEnabled=");
        x.y(stringBuilder0, this.g, ", isShowLikeBtn=", this.h, ", isLiked=false, isShowShareBtn=");
        x.y(stringBuilder0, this.i, ", isShareEnabled=", this.j, ", itemList=");
        stringBuilder0.append(this.k);
        stringBuilder0.append(", isInitLayout=");
        stringBuilder0.append(this.l);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }
}

