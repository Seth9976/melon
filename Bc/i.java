package Bc;

import A7.d;
import U4.x;
import com.iloen.melon.constants.CType;
import com.melon.ui.K4;
import java.util.LinkedHashMap;
import java.util.List;
import k8.Y;
import va.e;

public final class i implements K4 {
    public final boolean B;
    public final boolean D;
    public final boolean E;
    public final String G;
    public final CType I;
    public final Object M;
    public final String a;
    public final String b;
    public final boolean c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    public final String j;
    public final String k;
    public final LinkedHashMap l;
    public final String m;
    public final boolean n;
    public final boolean o;
    public final boolean r;
    public final boolean w;

    public i(String s, String s1, boolean z, String s2, String s3, String s4, String s5, String s6, String s7, String s8, String s9, LinkedHashMap linkedHashMap0, String s10, boolean z1, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, String s11, CType cType0, List list0) {
        this.a = s;
        this.b = s1;
        this.c = z;
        this.d = s2;
        this.e = s3;
        this.f = s4;
        this.g = s5;
        this.h = s6;
        this.i = s7;
        this.j = s8;
        this.k = s9;
        this.l = linkedHashMap0;
        this.m = s10;
        this.n = z1;
        this.o = z2;
        this.r = z3;
        this.w = z4;
        this.B = z5;
        this.D = z6;
        this.E = z7;
        this.G = s11;
        this.I = cType0;
        this.M = list0;
    }

    // 去混淆评级： 低(26)
    @Override
    public final boolean equals(Object object0) {
        if(this != object0) {
            if(object0 instanceof i) {
                i i0 = (i)object0;
                return this.a.equals(i0.a) && this.b.equals(i0.b) && this.c == i0.c && this.d.equals(i0.d) && this.e.equals(i0.e) && this.f.equals(i0.f) && this.g.equals(i0.g) && this.h.equals(i0.h) && this.i.equals(i0.i) && this.j.equals(i0.j) && this.k.equals(i0.k) && this.l.equals(i0.l) && this.m.equals(i0.m) && this.n == i0.n && this.o == i0.o && this.r == i0.r && this.w == i0.w && this.B == i0.B && this.D == i0.D && this.E == i0.E && this.G.equals(i0.G) && this.I.equals(i0.I) && this.M.equals(i0.M);
            }
            return false;
        }
        return true;
    }

    @Override
    public final int hashCode() {
        return this.M.hashCode() + (this.I.hashCode() + x.b(d.e(d.e(d.e(d.e(d.e(d.e(d.e(x.b((this.l.hashCode() + x.b(x.b(x.b(x.b(x.b(x.b(x.b(x.b(d.e(x.b(this.a.hashCode() * 0x1F, 0x1F, this.b), 0x1F, this.c), 0x1F, this.d), 0x1F, this.e), 0x1F, this.f), 0x1F, this.g), 0x1F, this.h), 0x1F, this.i), 0x1F, this.j), 0x1F, this.k)) * 0x1F, 0x1F, this.m), 0x1F, this.n), 0x1F, this.o), 0x1F, this.r), 0x1F, this.w), 0x1F, this.B), 0x1F, this.D), 0x1F, this.E), 0x1F, this.G)) * 0x1F;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = d.o("VideoListItemUiState(mvName=", this.a, ", mv169Img=", this.b, ", canService=");
        Y.y(stringBuilder0, this.c, ", issueData=", this.d, ", mvId=");
        d.u(stringBuilder0, this.e, ", songId=", this.f, ", songName=");
        d.u(stringBuilder0, this.g, ", albumId=", this.h, ", albumName=");
        d.u(stringBuilder0, this.i, ", albumImage=", this.j, ", albumImageThumb=");
        stringBuilder0.append(this.k);
        stringBuilder0.append(", artistMap=");
        stringBuilder0.append(this.l);
        stringBuilder0.append(", artistName=");
        Y.x(stringBuilder0, this.m, ", isAdult=", this.n, ", isService=");
        x.y(stringBuilder0, this.o, ", isTitle=", this.r, ", isHitSong=");
        x.y(stringBuilder0, this.w, ", isHoldBack=", this.B, ", isFree=");
        x.y(stringBuilder0, this.D, ", isSong=", this.E, ", playTime=");
        stringBuilder0.append(this.G);
        stringBuilder0.append(", cType=");
        stringBuilder0.append(this.I);
        stringBuilder0.append(", genreList=");
        return e.d(stringBuilder0, this.M, ")");
    }
}

