package b3;

import Vd.w;
import java.util.Objects;

public final class k {
    public final int a;
    public final int b;
    public final int c;
    public final String d;
    public static final k e;
    public static final String f;
    public static final String g;
    public static final String h;
    public static final String i;

    static {
        k.e = new w(0).e();
        k.f = "0";
        k.g = "1";
        k.h = "2";
        k.i = "3";
    }

    public k(w w0) {
        this.a = w0.b;
        this.b = w0.c;
        this.c = w0.d;
        this.d = (String)w0.e;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof k ? this.a == ((k)object0).a && this.b == ((k)object0).b && this.c == ((k)object0).c && Objects.equals(this.d, ((k)object0).d) : false;
    }

    @Override
    public final int hashCode() {
        int v = (((this.a + 0x20F) * 0x1F + this.b) * 0x1F + this.c) * 0x1F;
        return this.d == null ? v : v + this.d.hashCode();
    }
}

