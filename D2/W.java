package D2;

import A7.d;
import J2.a;
import J2.b;

public final class w {
    public final x0 a;
    public final int b;
    public final int c;

    public w(x0 x00, int v, int v1) {
        this.a = x00;
        this.b = v;
        this.c = v1;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof w)) {
            return false;
        }
        return this.a == ((w)object0).a ? this.b == ((w)object0).b && this.c == ((w)object0).c : false;
    }

    @Override
    public final int hashCode() {
        return this.c + d.b(this.b, this.a.hashCode() * 0x1F, 0x1F);
    }

    @Override
    public final String toString() {
        return "BoxChildSelector(type=" + this.a + ", horizontalAlignment=" + a.b(this.b) + ", verticalAlignment=" + b.b(this.c) + ')';
    }
}

