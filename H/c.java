package H;

import A7.d;
import androidx.appcompat.app.o;
import y0.s;

public final class c {
    public final long a;
    public final long b;
    public final long c;
    public final long d;
    public final long e;

    public c(long v, long v1, long v2, long v3, long v4) {
        this.a = v;
        this.b = v1;
        this.c = v2;
        this.d = v3;
        this.e = v4;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 == null || !(object0 instanceof c) || !s.d(this.a, ((c)object0).a)) {
            return false;
        }
        if(!s.d(this.b, ((c)object0).b)) {
            return false;
        }
        if(!s.d(this.c, ((c)object0).c)) {
            return false;
        }
        return s.d(this.d, ((c)object0).d) ? s.d(this.e, ((c)object0).e) : false;
    }

    @Override
    public final int hashCode() {
        return Long.hashCode(this.e) + d.c(d.c(d.c(Long.hashCode(this.a) * 0x1F, 0x1F, this.b), 0x1F, this.c), 0x1F, this.d);
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("ContextMenuColors(backgroundColor=");
        o.x(this.a, ", textColor=", stringBuilder0);
        o.x(this.b, ", iconColor=", stringBuilder0);
        o.x(this.c, ", disabledTextColor=", stringBuilder0);
        o.x(this.d, ", disabledIconColor=", stringBuilder0);
        stringBuilder0.append(s.j(this.e));
        stringBuilder0.append(')');
        return stringBuilder0.toString();
    }
}

