package hd;

import A7.d;
import U4.x;
import kotlin.jvm.internal.q;

public final class r0 extends J0 {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;

    public r0(String s, String s1, String s2, String s3, String s4) {
        q.g(s1, "albumName");
        q.g(s2, "artistId");
        q.g(s4, "ordNum");
        super();
        this.a = s;
        this.b = s1;
        this.c = s2;
        this.d = s3;
        this.e = s4;
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
        return q.b(this.d, ((r0)object0).d) ? q.b(this.e, ((r0)object0).e) : false;
    }

    @Override
    public final int hashCode() {
        return this.e.hashCode() + x.b(x.b(x.b(this.a.hashCode() * 0x1F, 0x1F, this.b), 0x1F, this.c), 0x1F, this.d);
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = d.o("ClickArtistAlbumItem(albumId=", this.a, ", albumName=", this.b, ", artistId=");
        d.u(stringBuilder0, this.c, ", artistName=", this.d, ", ordNum=");
        return x.m(stringBuilder0, this.e, ")");
    }
}

