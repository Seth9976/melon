package hd;

import A7.d;
import Bc.i;
import U4.x;
import kotlin.jvm.internal.q;

public final class w0 extends J0 {
    public final i a;
    public final String b;
    public final String c;
    public final String d;

    public w0(i i0, String s, String s1, String s2) {
        q.g(i0, "item");
        q.g(s, "artistId");
        q.g(s1, "artistName");
        q.g(s2, "ordNum");
        super();
        this.a = i0;
        this.b = s;
        this.c = s1;
        this.d = s2;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof w0)) {
            return false;
        }
        if(!q.b(this.a, ((w0)object0).a)) {
            return false;
        }
        if(!q.b(this.b, ((w0)object0).b)) {
            return false;
        }
        return q.b(this.c, ((w0)object0).c) ? q.b(this.d, ((w0)object0).d) : false;
    }

    @Override
    public final int hashCode() {
        return this.d.hashCode() + x.b(x.b(this.a.hashCode() * 0x1F, 0x1F, this.b), 0x1F, this.c);
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("ClickArtistMvItem(item=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", artistId=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", artistName=");
        return d.n(stringBuilder0, this.c, ", ordNum=", this.d, ")");
    }
}

