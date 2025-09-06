package b3;

import e3.x;
import java.util.Objects;

public final class q {
    public final String a;
    public final String b;
    public static final String c;
    public static final String d;

    static {
        q.c = "0";
        q.d = "1";
    }

    public q(String s, String s1) {
        this.a = x.N(s);
        this.b = s1;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 != null) {
            Class class0 = object0.getClass();
            return q.class == class0 && Objects.equals(this.a, ((q)object0).a) && Objects.equals(this.b, ((q)object0).b);
        }
        return false;
    }

    @Override
    public final int hashCode() {
        int v = this.b.hashCode();
        return this.a == null ? v * 0x1F : v * 0x1F + this.a.hashCode();
    }
}

