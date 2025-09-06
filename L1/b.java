package l1;

import A7.d;
import kotlin.jvm.internal.q;
import y0.O;
import y0.o;
import y0.s;

public final class b implements p {
    public final O a;
    public final float b;

    public b(O o0, float f) {
        this.a = o0;
        this.b = f;
    }

    @Override  // l1.p
    public final float a() {
        return this.b;
    }

    @Override  // l1.p
    public final long b() {
        return s.g;
    }

    @Override  // l1.p
    public final o c() {
        return this.a;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof b)) {
            return false;
        }
        return q.b(this.a, ((b)object0).a) ? Float.compare(this.b, ((b)object0).b) == 0 : false;
    }

    @Override
    public final int hashCode() {
        return Float.hashCode(this.b) + this.a.hashCode() * 0x1F;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("BrushStyle(value=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", alpha=");
        return d.m(stringBuilder0, this.b, ')');
    }
}

