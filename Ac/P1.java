package Ac;

public final class p1 implements P3 {
    public static final p1 a;

    static {
        p1.a = new p1();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 ? true : object0 instanceof p1;
    }

    @Override
    public final int hashCode() {
        return 0x5B64159B;
    }

    @Override
    public final String toString() {
        return "CommentEmptyItemUiState";
    }
}

