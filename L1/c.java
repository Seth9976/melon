package l1;

import g1.a;
import y0.o;
import y0.s;

public final class c implements p {
    public final long a;

    public c(long v) {
        this.a = v;
        if(v != 16L) {
            return;
        }
        a.a("ColorStyle value must be specified, use TextForegroundStyle.Unspecified instead.");
    }

    @Override  // l1.p
    public final float a() {
        return s.e(this.a);
    }

    @Override  // l1.p
    public final long b() {
        return this.a;
    }

    @Override  // l1.p
    public final o c() {
        return null;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof c ? s.d(this.a, ((c)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return Long.hashCode(this.a);
    }

    @Override
    public final String toString() {
        return "ColorStyle(value=" + s.j(this.a) + ')';
    }
}

