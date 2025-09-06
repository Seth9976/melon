package b3;

public final class t0 {
    public final int a;
    public final boolean b;
    public final boolean c;
    public static final t0 d;
    public static final String e;
    public static final String f;
    public static final String g;

    static {
        t0.d = new t0(new s0());
        t0.e = "1";
        t0.f = "2";
        t0.g = "3";
    }

    public t0(s0 s00) {
        this.a = s00.a;
        this.b = s00.b;
        this.c = s00.c;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 != null) {
            Class class0 = object0.getClass();
            return t0.class == class0 && this.a == ((t0)object0).a && this.b == ((t0)object0).b && this.c == ((t0)object0).c;
        }
        return false;
    }

    @Override
    public final int hashCode() {
        return ((this.a + 0x1F) * 0x1F + this.b) * 0x1F + this.c;
    }
}

