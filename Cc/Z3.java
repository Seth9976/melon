package Cc;

import A7.d;
import U4.x;
import kotlin.jvm.internal.q;

public final class z3 extends A3 {
    public final String a;
    public final String b;
    public final int c;

    public z3(String s, String s1, int v) {
        this.a = s;
        this.b = s1;
        this.c = v;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof z3)) {
            return false;
        }
        if(!q.b(this.a, ((z3)object0).a)) {
            return false;
        }
        return q.b(this.b, ((z3)object0).b) ? this.c == ((z3)object0).c : false;
    }

    @Override
    public final int hashCode() {
        return this.c + x.b(this.a.hashCode() * 0x1F, 0x1F, this.b);
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = d.o("OnPlayButtonClick(castSeq=", this.a, ", castTitle=", this.b, ", index=");
        return x.g(this.c, ")", stringBuilder0);
    }
}

