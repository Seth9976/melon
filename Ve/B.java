package Ve;

import kotlin.jvm.internal.t;

public final class b extends t {
    public static final b b;

    static {
        b.b = new b(X.class, "flags", "getFlags$kotlin_metadata()I", 0);  // 初始化器: Lkotlin/jvm/internal/t;-><init>(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;I)V
    }

    @Override  // kotlin.jvm.internal.t
    public final void a(Object object0, Object object1) {
        ((X)object0).a = ((Number)object1).intValue();
    }

    @Override  // kotlin.jvm.internal.t
    public final Object get(Object object0) {
        return ((X)object0).a;
    }
}

