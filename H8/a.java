package H8;

import A7.d;
import H0.b;
import U4.x;
import kotlin.jvm.internal.q;

public final class a {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final long f;
    public final String g;
    public final Integer h;
    public final int i;

    public a(String s, String s1, String s2, String s3, String s4, long v, String s5, Integer integer0, int v1) {
        q.g(s, "data");
        q.g(s1, "uri");
        q.g(s2, "album");
        q.g(s3, "albumKey");
        q.g(s4, "albumId");
        q.g(s5, "artists");
        super();
        this.a = s;
        this.b = s1;
        this.c = s2;
        this.d = s3;
        this.e = s4;
        this.f = v;
        this.g = s5;
        this.h = integer0;
        this.i = v1;
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
        if(this.f != ((a)object0).f) {
            return false;
        }
        if(!q.b(this.g, ((a)object0).g)) {
            return false;
        }
        return q.b(this.h, ((a)object0).h) ? this.i == ((a)object0).i : false;
    }

    @Override
    public final int hashCode() {
        int v = x.b(d.c(x.b(x.b(x.b(x.b(this.a.hashCode() * 0x1F, 0x1F, this.b), 0x1F, this.c), 0x1F, this.d), 0x1F, this.e), 0x1F, this.f), 0x1F, this.g);
        return this.h == null ? this.i + v * 0x1F : this.i + (v + this.h.hashCode()) * 0x1F;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = d.o("LocalAlbumInfo(data=", this.a, ", uri=", this.b, ", album=");
        d.u(stringBuilder0, this.c, ", albumKey=", this.d, ", albumId=");
        b.t(this.f, this.e, ", mediaStoreAlbumId=", stringBuilder0);
        stringBuilder0.append(", artists=");
        stringBuilder0.append(this.g);
        stringBuilder0.append(", year=");
        stringBuilder0.append(this.h);
        stringBuilder0.append(", count=");
        stringBuilder0.append(this.i);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }
}

