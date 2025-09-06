package lg;

import java.util.concurrent.TimeUnit;
import kg.p;
import kotlin.jvm.internal.q;

public final class c {
    public int a;
    public long b;
    public long c;
    public final p d;
    public long e;
    public boolean f;
    public static final long g;

    static {
        c.g = TimeUnit.SECONDS.toMillis(10L);
    }

    public c(p p0, long v, boolean z) {
        this.d = p0;
        this.e = v;
        this.f = z;
        long v1 = System.currentTimeMillis();
        this.b = v1;
        this.c = v1 + this.e;
    }

    public final long a() {
        long v = this.e * ((long)(this.a + 1)) / 2L;
        return v <= c.g * 2L ? this.b + v / 2L : this.b + (v - c.g);
    }

    @Override
    public final boolean equals(Object object0) {
        if(object0 == null) {
            return false;
        }
        if(object0 == this) {
            return true;
        }
        return object0 instanceof c ? q.b(this.d, ((c)object0).d) : false;
    }

    @Override
    public final int hashCode() {
        return this.d.hashCode();
    }
}

