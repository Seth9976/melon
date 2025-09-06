package H8;

import A7.d;
import U4.x;
import kotlin.jvm.internal.q;

public final class l {
    public final String a;
    public final String b;
    public final long c;
    public final int d;

    public l(int v, String s, String s1, long v1) {
        q.g(s, "data");
        q.g(s1, "genre");
        super();
        this.a = s;
        this.b = s1;
        this.c = v1;
        this.d = v;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof l)) {
            return false;
        }
        if(!q.b(this.a, ((l)object0).a)) {
            return false;
        }
        if(!q.b(this.b, ((l)object0).b)) {
            return false;
        }
        return this.c == ((l)object0).c ? this.d == ((l)object0).d : false;
    }

    @Override
    public final int hashCode() {
        return this.d + d.c(x.b(this.a.hashCode() * 0x1F, 0x1F, this.b), 0x1F, this.c);
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = d.o("LocalGenreInfo(data=", this.a, ", genre=", this.b, ", genreId=");
        stringBuilder0.append(this.c);
        stringBuilder0.append(", count=");
        stringBuilder0.append(this.d);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }
}

