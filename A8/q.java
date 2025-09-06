package A8;

import A7.d;
import U4.x;

public final class q {
    public final String a;
    public final String b;
    public final String c;
    public final r d;
    public final String e;
    public final String f;
    public final c g;
    public final e h;
    public final String i;
    public final K j;
    public final g k;
    public final u l;
    public final String m;
    public final String n;
    public final String o;
    public final J p;

    public q(String s, String s1, String s2, r r0, String s3, String s4, c c0, e e0, String s5, K k0, g g0, u u0, String s6, String s7, String s8, J j0) {
        kotlin.jvm.internal.q.g(r0, "loginType");
        kotlin.jvm.internal.q.g(s3, "mdn");
        kotlin.jvm.internal.q.g(s4, "min");
        kotlin.jvm.internal.q.g(c0, "dcf");
        kotlin.jvm.internal.q.g(u0, "option");
        kotlin.jvm.internal.q.g(j0, "storeType");
        super();
        this.a = s;
        this.b = s1;
        this.c = s2;
        this.d = r0;
        this.e = s3;
        this.f = s4;
        this.g = c0;
        this.h = e0;
        this.i = s5;
        this.j = k0;
        this.k = g0;
        this.l = u0;
        this.m = s6;
        this.n = s7;
        this.o = s8;
        this.p = j0;
    }

    public static q a(q q0, String s, String s1, String s2, String s3, String s4, String s5, int v) {
        String s6 = (v & 1) == 0 ? s : q0.a;
        kotlin.jvm.internal.q.g(s6, "id");
        kotlin.jvm.internal.q.g(q0.d, "loginType");
        kotlin.jvm.internal.q.g(q0.e, "mdn");
        kotlin.jvm.internal.q.g(q0.f, "min");
        kotlin.jvm.internal.q.g(q0.g, "dcf");
        kotlin.jvm.internal.q.g(q0.l, "option");
        kotlin.jvm.internal.q.g(q0.p, "storeType");
        return new q(s6, ((v & 2) == 0 ? s1 : q0.b), ((v & 4) == 0 ? s2 : q0.c), q0.d, q0.e, q0.f, q0.g, q0.h, q0.i, q0.j, q0.k, q0.l, ((v & 0x1000) == 0 ? s3 : q0.m), ((v & 0x2000) == 0 ? s4 : q0.n), ((v & 0x4000) == 0 ? s5 : q0.o), q0.p);
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof q)) {
            return false;
        }
        if(!kotlin.jvm.internal.q.b(this.a, ((q)object0).a)) {
            return false;
        }
        if(!kotlin.jvm.internal.q.b(this.b, ((q)object0).b)) {
            return false;
        }
        if(!kotlin.jvm.internal.q.b(this.c, ((q)object0).c)) {
            return false;
        }
        if(this.d != ((q)object0).d) {
            return false;
        }
        if(!kotlin.jvm.internal.q.b(this.e, ((q)object0).e)) {
            return false;
        }
        if(!kotlin.jvm.internal.q.b(this.f, ((q)object0).f)) {
            return false;
        }
        if(this.g != ((q)object0).g) {
            return false;
        }
        if(this.h != ((q)object0).h) {
            return false;
        }
        if(!kotlin.jvm.internal.q.b(this.i, ((q)object0).i)) {
            return false;
        }
        if(this.j != ((q)object0).j) {
            return false;
        }
        if(this.k != ((q)object0).k) {
            return false;
        }
        if(this.l != ((q)object0).l) {
            return false;
        }
        if(!kotlin.jvm.internal.q.b(this.m, ((q)object0).m)) {
            return false;
        }
        if(!kotlin.jvm.internal.q.b(this.n, ((q)object0).n)) {
            return false;
        }
        return kotlin.jvm.internal.q.b(this.o, ((q)object0).o) ? this.p == ((q)object0).p : false;
    }

    @Override
    public final int hashCode() {
        int v = 0;
        int v1 = x.b((this.h.hashCode() + (this.g.hashCode() + x.b(x.b((this.d.hashCode() + ((this.a.hashCode() * 0x1F + (this.b == null ? 0 : this.b.hashCode())) * 0x1F + (this.c == null ? 0 : this.c.hashCode())) * 0x1F) * 0x1F, 0x1F, this.e), 0x1F, this.f)) * 0x1F) * 0x1F, 0x1F, this.i);
        int v2 = this.j.hashCode();
        int v3 = this.k.hashCode();
        int v4 = this.l.hashCode();
        int v5 = this.m == null ? 0 : this.m.hashCode();
        int v6 = this.n == null ? 0 : this.n.hashCode();
        String s = this.o;
        if(s != null) {
            v = s.hashCode();
        }
        return this.p.hashCode() + ((((v4 + (v3 + (v2 + v1) * 0x1F) * 0x1F) * 0x1F + v5) * 0x1F + v6) * 0x1F + v) * 0x1F;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = d.o("LoginParam(id=", this.a, ", pwd=", this.b, ", token=");
        stringBuilder0.append(this.c);
        stringBuilder0.append(", loginType=");
        stringBuilder0.append(this.d);
        stringBuilder0.append(", mdn=");
        d.u(stringBuilder0, this.e, ", min=", this.f, ", dcf=");
        stringBuilder0.append(this.g);
        stringBuilder0.append(", deviceType=");
        stringBuilder0.append(this.h);
        stringBuilder0.append(", mac=");
        stringBuilder0.append(this.i);
        stringBuilder0.append(", sktFlag=");
        stringBuilder0.append(this.j);
        stringBuilder0.append(", drmInst=");
        stringBuilder0.append(this.k);
        stringBuilder0.append(", option=");
        stringBuilder0.append(this.l);
        stringBuilder0.append(", kakaoId=");
        d.u(stringBuilder0, this.m, ", kakaoToken=", this.n, ", kakaoRefreshToken=");
        stringBuilder0.append(this.o);
        stringBuilder0.append(", storeType=");
        stringBuilder0.append(this.p);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }
}

