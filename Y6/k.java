package Y6;

import B.a;
import U4.x;

public final class k {
    public final s a;
    public final int b;
    public final int c;

    public k(int v, int v1, Class class0) {
        this(s.a(class0), v, v1);
    }

    public k(s s0, int v, int v1) {
        a.o(s0, "Null dependency anInterface.");
        this.a = s0;
        this.b = v;
        this.c = v1;
    }

    public static k a(s s0) {
        return new k(s0, 1, 0);
    }

    public static k b(Class class0) {
        return new k(1, 0, class0);
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof k && this.a.equals(((k)object0).a) && this.b == ((k)object0).b && this.c == ((k)object0).c;
    }

    @Override
    public final int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003 ^ this.b) * 1000003 ^ this.c;
    }

    @Override
    public final String toString() {
        String s;
        StringBuilder stringBuilder0 = new StringBuilder("Dependency{anInterface=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", type=");
        int v = this.b;
        if(v == 1) {
            s = "required";
        }
        else {
            s = v == 0 ? "optional" : "set";
        }
        stringBuilder0.append(s);
        stringBuilder0.append(", injection=");
        int v1 = this.c;
        switch(v1) {
            case 0: {
                return x.m(stringBuilder0, "direct", "}");
            }
            case 1: {
                return x.m(stringBuilder0, "provider", "}");
            }
            default: {
                if(v1 != 2) {
                    throw new AssertionError("Unsupported injection: " + v1);
                }
                return x.m(stringBuilder0, "deferred", "}");
            }
        }
    }
}

