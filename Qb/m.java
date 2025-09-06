package qb;

public final class m extends u {
    public static final m a;

    static {
        m.a = new m();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 ? true : object0 instanceof m;
    }

    @Override
    public final int hashCode() {
        return 0x5234FABF;
    }

    @Override
    public final String toString() {
        return "MusicWaveChannelDelete";
    }
}

