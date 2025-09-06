package e5;

import java.util.WeakHashMap;

public final class m {
    public static final m a;
    public static final WeakHashMap b;

    static {
        m.a = new m();  // 初始化器: Ljava/lang/Object;-><init>()V
        m.b = new WeakHashMap();
    }
}

