package i.n.i.b.a.s.e;

import java.util.Arrays;

public final class y2 {
    public final long a;
    public final i b;
    public final int c;
    public final e2 d;
    public final long e;
    public final i f;
    public final int g;
    public final e2 h;
    public final long i;
    public final long j;

    public y2(long v, i i0, int v1, e2 e20, long v2, i i1, int v3, e2 e21, long v4, long v5) {
        this.a = v;
        this.b = i0;
        this.c = v1;
        this.d = e20;
        this.e = v2;
        this.f = i1;
        this.g = v3;
        this.h = e21;
        this.i = v4;
        this.j = v5;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 != null) {
            Class class0 = object0.getClass();
            return y2.class == class0 && this.a == ((y2)object0).a && this.c == ((y2)object0).c && this.e == ((y2)object0).e && this.g == ((y2)object0).g && this.i == ((y2)object0).i && this.j == ((y2)object0).j && M7.v(this.b, ((y2)object0).b) && M7.v(this.d, ((y2)object0).d) && M7.v(this.f, ((y2)object0).f) && M7.v(this.h, ((y2)object0).h);
        }
        return false;
    }

    @Override
    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j});
    }
}

