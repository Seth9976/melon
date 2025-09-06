package i3;

import b3.p0;
import java.util.Arrays;
import s3.z;

public final class a {
    public final long a;
    public final p0 b;
    public final int c;
    public final z d;
    public final long e;
    public final p0 f;
    public final int g;
    public final z h;
    public final long i;
    public final long j;

    public a(long v, p0 p00, int v1, z z0, long v2, p0 p01, int v3, z z1, long v4, long v5) {
        this.a = v;
        this.b = p00;
        this.c = v1;
        this.d = z0;
        this.e = v2;
        this.f = p01;
        this.g = v3;
        this.h = z1;
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
            return a.class == class0 && this.a == ((a)object0).a && this.c == ((a)object0).c && this.e == ((a)object0).e && this.g == ((a)object0).g && this.i == ((a)object0).i && this.j == ((a)object0).j && x1.a.w(this.b, ((a)object0).b) && x1.a.w(this.d, ((a)object0).d) && x1.a.w(this.f, ((a)object0).f) && x1.a.w(this.h, ((a)object0).h);
        }
        return false;
    }

    @Override
    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j});
    }
}

