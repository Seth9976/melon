package hd;

import A7.d;
import Kd.g;
import U4.x;
import kotlin.jvm.internal.q;

public final class z0 extends J0 {
    public final g a;
    public final String b;
    public final String c;
    public final String d;

    public z0(g g0, String s, String s1, String s2) {
        q.g(s, "artistId");
        q.g(s1, "artistName");
        q.g(s2, "ordNum");
        super();
        this.a = g0;
        this.b = s;
        this.c = s1;
        this.d = s2;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof z0)) {
            return false;
        }
        if(!q.b(this.a, ((z0)object0).a)) {
            return false;
        }
        if(!q.b(this.b, ((z0)object0).b)) {
            return false;
        }
        return q.b(this.c, ((z0)object0).c) ? q.b(this.d, ((z0)object0).d) : false;
    }

    @Override
    public final int hashCode() {
        return this.d.hashCode() + x.b(x.b(this.a.hashCode() * 0x1F, 0x1F, this.b), 0x1F, this.c);
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("ClickArtistSongPlayButton(item=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", artistId=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", artistName=");
        return d.n(stringBuilder0, this.c, ", ordNum=", this.d, ")");
    }
}

