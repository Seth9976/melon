package Ic;

import A7.d;
import H0.b;
import com.melon.ui.K4;
import java.util.ArrayList;
import k8.Y;
import we.a;

public final class s implements K4 {
    public final String B;
    public final p D;
    public final a E;
    public final n a;
    public final boolean b;
    public final u c;
    public final String d;
    public final u e;
    public final boolean f;
    public final A g;
    public final boolean h;
    public final t i;
    public final boolean j;
    public final boolean k;
    public final String l;
    public final x m;
    public final ArrayList n;
    public final String o;
    public final String r;
    public final String w;

    public s(n n0, boolean z, u u0, String s, u u1, boolean z1, A a0, boolean z2, t t0, boolean z3, boolean z4, String s1, x x0, ArrayList arrayList0, String s2, String s3, String s4, String s5, p p0, a a1) {
        this.a = n0;
        this.b = z;
        this.c = u0;
        this.d = s;
        this.e = u1;
        this.f = z1;
        this.g = a0;
        this.h = z2;
        this.i = t0;
        this.j = z3;
        this.k = z4;
        this.l = s1;
        this.m = x0;
        this.n = arrayList0;
        this.o = s2;
        this.r = s3;
        this.w = s4;
        this.B = s5;
        this.D = p0;
        this.E = a1;
    }

    // 去混淆评级： 低(26)
    @Override
    public final boolean equals(Object object0) {
        if(this != object0) {
            if(object0 instanceof s) {
                s s0 = (s)object0;
                return this.a.equals(s0.a) && this.b == s0.b && this.c.equals(s0.c) && this.d.equals(s0.d) && this.e.equals(s0.e) && this.f == s0.f && this.g.equals(s0.g) && this.h == s0.h && this.i.equals(s0.i) && this.j == s0.j && this.k == s0.k && this.l.equals(s0.l) && this.m.equals(s0.m) && this.n.equals(s0.n) && this.o.equals(s0.o) && this.r.equals(s0.r) && this.w.equals(s0.w) && this.B.equals(s0.B) && this.D.equals(s0.D) && this.E.equals(s0.E);
            }
            return false;
        }
        return true;
    }

    @Override
    public final int hashCode() {
        return this.E.hashCode() + (this.D.hashCode() + U4.x.b(U4.x.b(U4.x.b(U4.x.b(b.a(this.n, (this.m.hashCode() + U4.x.b(d.e(d.e((this.i.hashCode() + d.e((this.g.hashCode() + d.e((this.e.hashCode() + U4.x.b((this.c.hashCode() + d.e(this.a.hashCode() * 0x1F, 0x1F, this.b)) * 0x1F, 0x1F, this.d)) * 0x1F, 0x1F, this.f)) * 0x1F, 0x1F, this.h)) * 0x1F, 0x1F, this.j), 0x1F, this.k), 0x1F, this.l)) * 0x1F, 0x1F), 0x1F, this.o), 0x1F, this.r), 0x1F, this.w), 0x1F, this.B)) * 0x1F;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("HeaderUiState(albumInfo=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", isVisibleFame=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", fameLink=");
        stringBuilder0.append(this.c);
        stringBuilder0.append(", badgeText=");
        stringBuilder0.append(this.d);
        stringBuilder0.append(", badgeLink=");
        stringBuilder0.append(this.e);
        stringBuilder0.append(", isVisibleSpotlight=");
        stringBuilder0.append(this.f);
        stringBuilder0.append(", spotLight=");
        stringBuilder0.append(this.g);
        stringBuilder0.append(", isVisibleHiRising=");
        stringBuilder0.append(this.h);
        stringBuilder0.append(", hiRising=");
        stringBuilder0.append(this.i);
        stringBuilder0.append(", supportedDolby=");
        stringBuilder0.append(this.j);
        stringBuilder0.append(", isMasterPiece=");
        Y.y(stringBuilder0, this.k, ", flacInfo=", this.l, ", ratingInfo=");
        stringBuilder0.append(this.m);
        stringBuilder0.append(", bookletImageList=");
        stringBuilder0.append(this.n);
        stringBuilder0.append(", albumPrice=");
        d.u(stringBuilder0, this.o, ", albumPriceFlac16=", this.r, ", albumPriceFlac24=");
        d.u(stringBuilder0, this.w, ", albumMessage=", this.B, ", bannerUiState=");
        stringBuilder0.append(this.D);
        stringBuilder0.append(", shareAction=");
        stringBuilder0.append(this.E);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }
}

