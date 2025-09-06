package H8;

import A7.d;
import U4.x;
import com.iloen.melon.utils.a;
import k8.Y;
import kotlin.jvm.internal.q;

public final class t {
    public long a;
    public long b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public long l;
    public int m;
    public int n;

    public t() {
        this(0L, 0L, "", "", "", "", "", "", "", "", "", 0L, 0, 0);
    }

    public t(long v, long v1, String s, String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8, long v2, int v3, int v4) {
        q.g(s, "mimeType");
        q.g(s1, "data");
        q.g(s2, "uri");
        q.g(s3, "displayName");
        q.g(s4, "title");
        q.g(s5, "albumId");
        q.g(s6, "album");
        q.g(s7, "artist");
        q.g(s8, "artistId");
        super();
        this.a = v;
        this.b = v1;
        this.c = s;
        this.d = s1;
        this.e = s2;
        this.f = s3;
        this.g = s4;
        this.h = s5;
        this.i = s6;
        this.j = s7;
        this.k = s8;
        this.l = v2;
        this.m = v3;
        this.n = v4;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof t)) {
            return false;
        }
        if(this.a != ((t)object0).a) {
            return false;
        }
        if(this.b != ((t)object0).b) {
            return false;
        }
        if(!q.b(this.c, ((t)object0).c)) {
            return false;
        }
        if(!q.b(this.d, ((t)object0).d)) {
            return false;
        }
        if(!q.b(this.e, ((t)object0).e)) {
            return false;
        }
        if(!q.b(this.f, ((t)object0).f)) {
            return false;
        }
        if(!q.b(this.g, ((t)object0).g)) {
            return false;
        }
        if(!q.b(this.h, ((t)object0).h)) {
            return false;
        }
        if(!q.b(this.i, ((t)object0).i)) {
            return false;
        }
        if(!q.b(this.j, ((t)object0).j)) {
            return false;
        }
        if(!q.b(this.k, ((t)object0).k)) {
            return false;
        }
        if(this.l != ((t)object0).l) {
            return false;
        }
        return this.m == ((t)object0).m ? this.n == ((t)object0).n : false;
    }

    @Override
    public final int hashCode() {
        return this.n + d.b(this.m, d.c(x.b(x.b(x.b(x.b(x.b(x.b(x.b(x.b(x.b(d.c(Long.hashCode(this.a) * 0x1F, 0x1F, this.b), 0x1F, this.c), 0x1F, this.d), 0x1F, this.e), 0x1F, this.f), 0x1F, this.g), 0x1F, this.h), 0x1F, this.i), 0x1F, this.j), 0x1F, this.k), 0x1F, this.l), 0x1F);
    }

    @Override
    public final String toString() {
        long v = this.b;
        String s = this.c;
        String s1 = this.d;
        String s2 = this.e;
        String s3 = this.f;
        String s4 = this.g;
        String s5 = this.h;
        String s6 = this.i;
        String s7 = this.j;
        String s8 = this.k;
        long v1 = this.l;
        int v2 = this.m;
        int v3 = this.n;
        StringBuilder stringBuilder0 = Y.o(this.a, "LocalPlaylistsMapEntity(id=", ", audioId=");
        stringBuilder0.append(v);
        stringBuilder0.append(", mimeType=");
        stringBuilder0.append(s);
        d.u(stringBuilder0, ", data=", s1, ", uri=", s2);
        d.u(stringBuilder0, ", displayName=", s3, ", title=", s4);
        d.u(stringBuilder0, ", albumId=", s5, ", album=", s6);
        d.u(stringBuilder0, ", artist=", s7, ", artistId=", s8);
        a.s(v1, ", playlistId=", ", playOrder=", stringBuilder0);
        stringBuilder0.append(v2);
        stringBuilder0.append(", duration=");
        stringBuilder0.append(v3);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }
}

