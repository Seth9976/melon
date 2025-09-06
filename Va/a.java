package va;

import A7.d;
import U4.x;
import kotlin.jvm.internal.q;

public final class a {
    public final String a;
    public final String b;
    public final String c;

    public a(String s, String s1, String s2) {
        q.g(s1, "caller");
        super();
        this.a = s;
        this.b = s1;
        this.c = s2;
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
        return q.b(this.b, ((a)object0).b) ? q.b(this.c, ((a)object0).c) : false;
    }

    @Override
    public final int hashCode() {
        return this.c.hashCode() + x.b(this.a.hashCode() * 0x1F, 0x1F, this.b);
    }

    @Override
    public final String toString() {
        return x.m(d.o("AutoLoginEventData(executeTime=", this.a, ", caller=", this.b, ", result="), this.c, ")");
    }
}

