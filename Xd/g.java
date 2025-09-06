package xd;

import U4.x;
import kotlin.jvm.internal.q;

public final class g extends h {
    public final int a;
    public final String b;
    public final String c;

    public g(int v, String s, String s1) {
        this.a = v;
        this.b = s;
        this.c = s1;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof g)) {
            return false;
        }
        if(this.a != ((g)object0).a) {
            return false;
        }
        return q.b(this.b, ((g)object0).b) ? q.b(this.c, ((g)object0).c) : false;
    }

    @Override
    public final int hashCode() {
        return this.c.hashCode() + x.b(this.a * 0x1F, 0x1F, this.b);
    }

    @Override
    public final String toString() {
        return x.m(x.o(this.a, "ClickListItem(position=", ", artistId=", this.b, ", artistName="), this.c, ")");
    }
}

