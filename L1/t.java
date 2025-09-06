package l1;

public final class t {
    public final int a;
    public final boolean b;
    public static final t c;
    public static final t d;

    static {
        t.c = new t(2, false);
        t.d = new t(1, true);
    }

    public t(int v, boolean z) {
        this.a = v;
        this.b = z;
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof t && this.a == ((t)object0).a && this.b == ((t)object0).b;
    }

    @Override
    public final int hashCode() {
        return Boolean.hashCode(this.b) + this.a * 0x1F;
    }

    @Override
    public final String toString() {
        if(this.equals(t.c)) {
            return "TextMotion.Static";
        }
        return this.equals(t.d) ? "TextMotion.Animated" : "Invalid";
    }
}

