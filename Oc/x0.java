package oc;

public final class x0 extends y0 {
    public static final x0 b;

    static {
        x0.b = new x0(7);  // 初始化器: Loc/y0;-><init>(I)V
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 ? true : object0 instanceof x0;
    }

    @Override
    public final int hashCode() {
        return 0x5F4B0B1B;
    }

    @Override
    public final String toString() {
        return "SongNameReverse";
    }
}

