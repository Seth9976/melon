package H6;

public final class d extends b {
    public static final d a;

    static {
        d.a = new d();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    @Override  // H6.b
    public final boolean a(char c) {
        return false;
    }

    @Override
    public final String toString() {
        return "CharMatcher.none()";
    }
}

