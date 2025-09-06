package ac;

import A7.d;
import H0.e;
import U4.x;
import Vb.i;
import com.iloen.melon.constants.CType;
import k8.Y;
import kotlin.jvm.internal.q;
import we.a;

public final class m {
    public final String a;
    public final String b;
    public final CType c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final boolean h;
    public final String i;
    public final String j;
    public final String k;
    public final String l;
    public final e m;
    public final n n;
    public final a o;
    public static final m p;

    static {
        q.f(CType.UNKNOWN, "UNKNOWN");
        i i0 = new i(6);
        m.p = new m("", "", CType.UNKNOWN, "", "", "", "", false, "", "", "", "", g.e, n.d, i0);
    }

    public m(String s, String s1, CType cType0, String s2, String s3, String s4, String s5, boolean z, String s6, String s7, String s8, String s9, e e0, n n0, a a0) {
        q.g(n0, "djMalrangTiaraInfo");
        super();
        this.a = s;
        this.b = s1;
        this.c = cType0;
        this.d = s2;
        this.e = s3;
        this.f = s4;
        this.g = s5;
        this.h = z;
        this.i = s6;
        this.j = s7;
        this.k = s8;
        this.l = s9;
        this.m = e0;
        this.n = n0;
        this.o = a0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof m)) {
            return false;
        }
        if(!q.b(this.a, ((m)object0).a)) {
            return false;
        }
        if(!q.b(this.b, ((m)object0).b)) {
            return false;
        }
        if(!q.b(this.c, ((m)object0).c)) {
            return false;
        }
        if(!q.b(this.d, ((m)object0).d)) {
            return false;
        }
        if(!q.b(this.e, ((m)object0).e)) {
            return false;
        }
        if(!q.b(this.f, ((m)object0).f)) {
            return false;
        }
        if(!q.b(this.g, ((m)object0).g)) {
            return false;
        }
        if(this.h != ((m)object0).h) {
            return false;
        }
        if(!q.b(this.i, ((m)object0).i)) {
            return false;
        }
        if(!q.b(this.j, ((m)object0).j)) {
            return false;
        }
        if(!q.b(this.k, ((m)object0).k)) {
            return false;
        }
        if(!q.b(this.l, ((m)object0).l)) {
            return false;
        }
        if(!q.b(this.m, ((m)object0).m)) {
            return false;
        }
        return q.b(this.n, ((m)object0).n) ? q.b(this.o, ((m)object0).o) : false;
    }

    @Override
    public final int hashCode() {
        return this.o.hashCode() + (this.n.hashCode() + (this.m.hashCode() + x.b(x.b(x.b(x.b(d.e(x.b(x.b(x.b(x.b((this.c.hashCode() + x.b(this.a.hashCode() * 0x1F, 0x1F, this.b)) * 0x1F, 0x1F, this.d), 0x1F, this.e), 0x1F, this.f), 0x1F, this.g), 0x1F, this.h), 0x1F, this.i), 0x1F, this.j), 0x1F, this.k), 0x1F, this.l)) * 0x1F) * 0x1F;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = d.o("ContentsAnalytics(trackId=", this.a, ", contentsId=", this.b, ", contentsType=");
        stringBuilder0.append(this.c);
        stringBuilder0.append(", contentName=");
        stringBuilder0.append(this.d);
        stringBuilder0.append(", createdDate=");
        d.u(stringBuilder0, this.e, ", bitrate=", this.f, ", metaType=");
        Y.x(stringBuilder0, this.g, ", isPreview=", this.h, ", freeYn=");
        d.u(stringBuilder0, this.i, ", menuId=", this.j, ", originMenuId=");
        d.u(stringBuilder0, this.k, ", statsElements=", this.l, ", source=");
        stringBuilder0.append(this.m);
        stringBuilder0.append(", djMalrangTiaraInfo=");
        stringBuilder0.append(this.n);
        stringBuilder0.append(", tiaraAction=");
        stringBuilder0.append(this.o);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }
}

