package z0;

import A7.d;
import kotlin.jvm.internal.q;

public abstract class c {
    public final String a;
    public final long b;
    public final int c;

    public c(String s, long v, int v1) {
        this.a = s;
        this.b = v;
        this.c = v1;
        if(s.length() == 0) {
            throw new IllegalArgumentException("The name of a color space cannot be null and must contain at least 1 character");
        }
        if(v1 < -1 || v1 > 0x3F) {
            throw new IllegalArgumentException("The id must be between -1 and 63");
        }
    }

    public abstract float a(int arg1);

    public abstract float b(int arg1);

    public boolean c() {
        return false;
    }

    public abstract long d(float arg1, float arg2, float arg3);

    public abstract float e(float arg1, float arg2, float arg3);

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 == null || this.getClass() != object0.getClass() || this.c != ((c)object0).c) {
            return false;
        }
        return q.b(this.a, ((c)object0).a) ? b.a(this.b, ((c)object0).b) : false;
    }

    public abstract long f(float arg1, float arg2, float arg3, float arg4, c arg5);

    @Override
    public int hashCode() {
        return d.c(this.a.hashCode() * 0x1F, 0x1F, this.b) + this.c;
    }

    @Override
    public final String toString() {
        return this.a + " (id=" + this.c + ", model=" + b.b(this.b) + ')';
    }
}

