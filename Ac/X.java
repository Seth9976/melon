package ac;

import A7.d;
import kotlin.jvm.internal.q;

public final class x {
    public final String a;
    public final String b;
    public final String c;

    public x(String s, String s1, String s2) {
        this.a = s;
        this.b = s1;
        this.c = s2;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof x)) {
            return false;
        }
        if(!q.b(this.a, ((x)object0).a)) {
            return false;
        }
        return q.b(this.b, ((x)object0).b) ? q.b(this.c, ((x)object0).c) : false;
    }

    @Override
    public final int hashCode() {
        return this.c.hashCode() + U4.x.b(this.a.hashCode() * 0x1F, 0x1F, this.b);
    }

    @Override
    public final String toString() {
        return U4.x.m(d.o("OfflineUpdateInfo(productInfo=", this.a, ", fileUpdateDate=", this.b, ", fileSize="), this.c, ")");
    }
}

