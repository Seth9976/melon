package jd;

import A7.d;
import U4.x;
import kotlin.jvm.internal.q;

public final class a {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;

    public a(String s, String s1, String s2, String s3, String s4, String s5, String s6) {
        this.a = s;
        this.b = s1;
        this.c = s2;
        this.d = s3;
        this.e = s4;
        this.f = s5;
        this.g = s6;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof a)) {
            return false;
        }
        if(!q.b(this.a, ((a)object0).a)) {
            return false;
        }
        if(!q.b(this.b, ((a)object0).b)) {
            return false;
        }
        if(!q.b(this.c, ((a)object0).c)) {
            return false;
        }
        if(!q.b(this.d, ((a)object0).d)) {
            return false;
        }
        if(!q.b(this.e, ((a)object0).e)) {
            return false;
        }
        return q.b(this.f, ((a)object0).f) ? q.b(this.g, ((a)object0).g) : false;
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
        String s = this.g;
        if(s != null) {
            v = s.hashCode();
        }
        return (((((v1 * 0x1F + v2) * 0x1F + v3) * 0x1F + v4) * 0x1F + v5) * 0x1F + v6) * 0x1F + v;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = d.o("ArtistImage(imageSeq=", this.a, ", smallImageUrl=", this.b, ", largeImageUrl=");
        d.u(stringBuilder0, this.c, ", memberKey=", this.d, ", name=");
        d.u(stringBuilder0, this.e, ", profileImageUrl=", this.f, ", dpDate=");
        return x.m(stringBuilder0, this.g, ")");
    }
}

