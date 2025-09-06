package H8;

import A7.d;
import U4.x;
import com.iloen.melon.utils.a;
import kotlin.jvm.internal.q;
import va.e;

public final class k {
    public long a;
    public String b;
    public String c;
    public String d;
    public String e;
    public int f;
    public long g;
    public String h;
    public long i;
    public long j;
    public String k;
    public int l;
    public String m;
    public String n;
    public String o;
    public String p;
    public String q;
    public String r;
    public String s;
    public int t;
    public Integer u;
    public long v;
    public long w;

    public k() {
        this("", "", "", "", 0, 0L, "", 0L, 0L, "", 0, "", "", "", "", "", "", "", 0, 0, 0L, 0L);
    }

    public k(String s, String s1, String s2, String s3, int v, long v1, String s4, long v2, long v3, String s5, int v4, String s6, String s7, String s8, String s9, String s10, String s11, String s12, int v5, Integer integer0, long v6, long v7) {
        q.g(s, "data");
        q.g(s1, "uri");
        q.g(s2, "displayName");
        q.g(s3, "songId");
        q.g(s4, "mimeType");
        q.g(s5, "title");
        q.g(s6, "artists");
        q.g(s7, "artistIds");
        q.g(s8, "album");
        q.g(s9, "albumKey");
        q.g(s10, "albumId");
        q.g(s11, "genre");
        q.g(s12, "genreId");
        super();
        this.b = s;
        this.c = s1;
        this.d = s2;
        this.e = s3;
        this.f = v;
        this.g = v1;
        this.h = s4;
        this.i = v2;
        this.j = v3;
        this.k = s5;
        this.l = v4;
        this.m = s6;
        this.n = s7;
        this.o = s8;
        this.p = s9;
        this.q = s10;
        this.r = s11;
        this.s = s12;
        this.t = v5;
        this.u = integer0;
        this.v = v6;
        this.w = v7;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof k)) {
            return false;
        }
        k k0 = (k)object0;
        if(!q.b(this.b, k0.b)) {
            return false;
        }
        if(!q.b(this.c, k0.c)) {
            return false;
        }
        if(!q.b(this.d, k0.d)) {
            return false;
        }
        if(!q.b(this.e, k0.e)) {
            return false;
        }
        if(this.f != k0.f) {
            return false;
        }
        if(this.g != k0.g) {
            return false;
        }
        if(!q.b(this.h, k0.h)) {
            return false;
        }
        if(this.i != k0.i) {
            return false;
        }
        if(this.j != k0.j) {
            return false;
        }
        if(!q.b(this.k, k0.k)) {
            return false;
        }
        if(this.l != k0.l) {
            return false;
        }
        if(!q.b(this.m, k0.m)) {
            return false;
        }
        if(!q.b(this.n, k0.n)) {
            return false;
        }
        if(!q.b(this.o, k0.o)) {
            return false;
        }
        if(!q.b(this.p, k0.p)) {
            return false;
        }
        if(!q.b(this.q, k0.q)) {
            return false;
        }
        if(!q.b(this.r, k0.r)) {
            return false;
        }
        if(!q.b(this.s, k0.s)) {
            return false;
        }
        if(this.t != k0.t) {
            return false;
        }
        if(!q.b(this.u, k0.u)) {
            return false;
        }
        return this.v == k0.v ? this.w == k0.w : false;
    }

    @Override
    public final int hashCode() {
        int v = d.b(this.t, x.b(x.b(x.b(x.b(x.b(x.b(x.b(d.b(this.l, x.b(d.c(d.c(x.b(d.c(d.b(this.f, x.b(x.b(x.b(this.b.hashCode() * 0x1F, 0x1F, this.c), 0x1F, this.d), 0x1F, this.e), 0x1F), 0x1F, this.g), 0x1F, this.h), 0x1F, this.i), 0x1F, this.j), 0x1F, this.k), 0x1F), 0x1F, this.m), 0x1F, this.n), 0x1F, this.o), 0x1F, this.p), 0x1F, this.q), 0x1F, this.r), 0x1F, this.s), 0x1F);
        return this.u == null ? Long.hashCode(this.w) + d.c(v * 0x1F, 0x1F, this.v) : Long.hashCode(this.w) + d.c((v + this.u.hashCode()) * 0x1F, 0x1F, this.v);
    }

    @Override
    public final String toString() {
        String s = this.d;
        String s1 = this.e;
        int v = this.f;
        long v1 = this.g;
        String s2 = this.h;
        long v2 = this.i;
        long v3 = this.j;
        String s3 = this.m;
        String s4 = this.n;
        String s5 = this.o;
        String s6 = this.p;
        String s7 = this.q;
        String s8 = this.r;
        String s9 = this.s;
        int v4 = this.t;
        Integer integer0 = this.u;
        String s10 = this.k;
        int v5 = this.l;
        long v6 = this.v;
        long v7 = this.w;
        StringBuilder stringBuilder0 = d.o("LocalContentEntity(data=", this.b, ", uri=", this.c, ", displayName=");
        d.u(stringBuilder0, s, ", songId=", s1, ", matchStat=");
        stringBuilder0.append(v);
        stringBuilder0.append(", size=");
        stringBuilder0.append(v1);
        e.g(stringBuilder0, ", mimeType=", s2, ", dateAdded=");
        stringBuilder0.append(v2);
        a.s(v3, ", dataModified=", ", title=", stringBuilder0);
        d.t(stringBuilder0, s10, ", duration=", v5, ", artists=");
        d.u(stringBuilder0, s3, ", artistIds=", s4, ", album=");
        d.u(stringBuilder0, s5, ", albumKey=", s6, ", albumId=");
        d.u(stringBuilder0, s7, ", genre=", s8, ", genreId=");
        d.t(stringBuilder0, s9, ", track=", v4, ", year=");
        stringBuilder0.append(integer0);
        stringBuilder0.append(", mediaStoreMediaId=");
        stringBuilder0.append(v6);
        stringBuilder0.append(", mediaStoreAlbumId=");
        stringBuilder0.append(v7);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }
}

