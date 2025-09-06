package db;

import A7.d;
import U4.x;
import kotlin.jvm.internal.q;

public final class a {
    public final double a;
    public final double b;
    public final long c;
    public final String d;

    public a(double f, double f1, long v, String s) {
        this.a = f;
        this.b = f1;
        this.c = v;
        this.d = s;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof a)) {
            return false;
        }
        if(Double.compare(this.a, ((a)object0).a) != 0) {
            return false;
        }
        if(Double.compare(this.b, ((a)object0).b) != 0) {
            return false;
        }
        return this.c == ((a)object0).c ? q.b(this.d, ((a)object0).d) : false;
    }

    @Override
    public final int hashCode() {
        return this.d.hashCode() + d.c((Double.hashCode(this.b) + Double.hashCode(this.a) * 0x1F) * 0x1F, 0x1F, this.c);
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("Location(latitude=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", longitude=");
        stringBuilder0.append(this.b);
        com.iloen.melon.utils.a.s(this.c, ", timestamp=", ", provider=", stringBuilder0);
        return x.m(stringBuilder0, this.d, ")");
    }
}

