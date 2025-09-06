package Z;

import A7.d;
import y0.s;

public final class j {
    public final long a;
    public final long b;
    public final long c;
    public final long d;

    public j(long v, long v1, long v2, long v3) {
        this.a = v;
        this.b = v1;
        this.c = v2;
        this.d = v3;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 != null) {
            Class class0 = object0.getClass();
            if(j.class != class0 || !s.d(this.a, ((j)object0).a)) {
                return false;
            }
            if(!s.d(this.b, ((j)object0).b)) {
                return false;
            }
            return s.d(this.c, ((j)object0).c) ? s.d(this.d, ((j)object0).d) : false;
        }
        return false;
    }

    @Override
    public final int hashCode() {
        return Long.hashCode(this.d) + d.c(d.c(Long.hashCode(this.a) * 0x1F, 0x1F, this.b), 0x1F, this.c);
    }
}

