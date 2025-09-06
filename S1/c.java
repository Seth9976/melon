package s1;

import e1.F;
import java.util.Arrays;
import kotlin.jvm.internal.q;

public final class c implements a {
    public final float[] a;
    public final float[] b;

    static {
    }

    public c(float[] arr_f, float[] arr_f1) {
        if(arr_f.length != arr_f1.length || arr_f.length == 0) {
            throw new IllegalArgumentException("Array lengths must match and be nonzero");
        }
        this.a = arr_f;
        this.b = arr_f1;
    }

    @Override  // s1.a
    public final float a(float f) {
        return F.m(f, this.b, this.a);
    }

    @Override  // s1.a
    public final float b(float f) {
        return F.m(f, this.a, this.b);
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof c ? Arrays.equals(this.a, ((c)object0).a) && Arrays.equals(this.b, ((c)object0).b) : false;
    }

    @Override
    public final int hashCode() {
        int v = Arrays.hashCode(this.a);
        return Arrays.hashCode(this.b) + v * 0x1F;
    }

    @Override
    public final String toString() {
        String s = Arrays.toString(this.a);
        q.f(s, "toString(...)");
        String s1 = Arrays.toString(this.b);
        q.f(s1, "toString(...)");
        return "FontScaleConverter{fromSpValues=" + s + ", toDpValues=" + s1 + '}';
    }
}

