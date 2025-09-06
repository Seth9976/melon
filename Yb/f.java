package Yb;

import Bf.a;
import kotlin.jvm.internal.q;

public final class f {
    public final c a;
    public final a b;
    public static final f c;

    static {
        f.c = new f(3);
    }

    public f(int v) {
        b b0 = (v & 1) == 0 ? Yb.a.a : b.a;
        this(b0, d.b);
    }

    public f(c c0, a a0) {
        q.g(c0, "command");
        q.g(a0, "modification");
        super();
        this.a = c0;
        this.b = a0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof f)) {
            return false;
        }
        return q.b(this.a, ((f)object0).a) ? q.b(this.b, ((f)object0).b) : false;
    }

    @Override
    public final int hashCode() {
        return this.b.hashCode() + this.a.hashCode() * 0x1F;
    }

    @Override
    public final String toString() {
        return "AfterAction(command=" + this.a + ", modification=" + this.b + ")";
    }
}

