package H8;

import A7.d;
import U4.x;
import kotlin.jvm.internal.q;

public final class b {
    public final String a;
    public final String b;
    public final String c;
    public final int d;

    public b(int v, String s, String s1, String s2) {
        q.g(s, "data");
        q.g(s1, "artists");
        q.g(s2, "artistIds");
        super();
        this.a = s;
        this.b = s1;
        this.c = s2;
        this.d = v;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof b)) {
            return false;
        }
        if(!q.b(this.a, ((b)object0).a)) {
            return false;
        }
        if(!q.b(this.b, ((b)object0).b)) {
            return false;
        }
        return q.b(this.c, ((b)object0).c) ? this.d == ((b)object0).d : false;
    }

    @Override
    public final int hashCode() {
        return this.d + x.b(x.b(this.a.hashCode() * 0x1F, 0x1F, this.b), 0x1F, this.c);
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = d.o("LocalArtistInfo(data=", this.a, ", artists=", this.b, ", artistIds=");
        stringBuilder0.append(this.c);
        stringBuilder0.append(", count=");
        stringBuilder0.append(this.d);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }
}

