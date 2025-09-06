package wd;

import U4.x;
import gd.Z3;
import kotlin.jvm.internal.q;

public final class k extends Z3 {
    public final int a;
    public final String b;
    public final String c;

    public k(int v, String s, String s1) {
        this.a = v;
        this.b = s;
        this.c = s1;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof k)) {
            return false;
        }
        if(this.a != ((k)object0).a) {
            return false;
        }
        return q.b(this.b, ((k)object0).b) ? q.b(this.c, ((k)object0).c) : false;
    }

    @Override
    public final int hashCode() {
        return this.c.hashCode() + x.b(this.a * 0x1F, 0x1F, this.b);
    }

    @Override
    public final String toString() {
        return x.m(x.o(this.a, "ClickListItem(position=", ", playlistSeq=", this.b, ", playlistName="), this.c, ")");
    }
}

