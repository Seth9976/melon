package zd;

import A7.d;
import java.util.ArrayList;
import kotlin.jvm.internal.q;

public final class r0 extends m {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    public final String j;
    public final String k;

    public r0(String s, String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8, String s9, String s10) {
        this.a = s;
        this.b = s1;
        this.c = s2;
        this.d = s3;
        this.e = s4;
        this.f = s5;
        this.g = s6;
        this.h = s7;
        this.i = s8;
        this.j = s9;
        this.k = s10;
    }

    @Override  // zd.Q
    public final ArrayList c() {
        ArrayList arrayList0 = new ArrayList();
        arrayList0.add(x.C0);
        arrayList0.add(x.D0);
        return arrayList0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof r0)) {
            return false;
        }
        if(!q.b(this.a, ((r0)object0).a)) {
            return false;
        }
        if(!q.b(this.b, ((r0)object0).b)) {
            return false;
        }
        if(!q.b(this.c, ((r0)object0).c)) {
            return false;
        }
        if(!q.b(this.d, ((r0)object0).d)) {
            return false;
        }
        if(!q.b(this.e, ((r0)object0).e)) {
            return false;
        }
        if(!q.b(this.f, ((r0)object0).f)) {
            return false;
        }
        if(!q.b(this.g, ((r0)object0).g)) {
            return false;
        }
        if(!q.b(this.h, ((r0)object0).h)) {
            return false;
        }
        if(!q.b(this.i, ((r0)object0).i)) {
            return false;
        }
        return q.b(this.j, ((r0)object0).j) ? q.b(this.k, ((r0)object0).k) : false;
    }

    @Override  // zd.Q
    public final int g() {
        return 40;
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
        return (((((((((v1 * 0x1F + v2) * 0x1F + v3) * 0x1F + v4) * 0x1F + v5) * 0x1F + v6) * 0x1F + v7) * 0x1F + v8) * 0x1F + v9) * 0x1F + v10) * 0x1F + v;
    }

    @Override  // zd.m
    public final String q() {
        return this.e == null ? "" : this.e;
    }

    @Override  // zd.Q
    public final String r() {
        return this.d == null ? "" : this.d;
    }

    @Override  // zd.m
    public final Object s() {
        return this.c;
    }

    @Override  // zd.m
    public final l t() {
        return l.d;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = d.o("MusicWaveReportPopupType(profileCleanUrl=", this.a, ", chatCleanUrl=", this.b, ", userImgUrl=");
        d.u(stringBuilder0, this.c, ", userNickName=", this.d, ", chatText=");
        d.u(stringBuilder0, this.e, ", targetMemberKey=", this.f, ", channelId=");
        d.u(stringBuilder0, this.g, ", channelType=", this.h, ", channelKey=");
        d.u(stringBuilder0, this.i, ", channelTitle=", this.j, ", cmtSeq=");
        return U4.x.m(stringBuilder0, this.k, ")");
    }
}

