package Ve;

import kotlin.jvm.internal.t;

public final class l extends t {
    public static final l b;

    static {
        l.b = new l(a0.class, "flags", "getFlags$kotlin_metadata()I", 0);  // 初始化器: Lkotlin/jvm/internal/t;-><init>(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;I)V
    }

    @Override  // kotlin.jvm.internal.t
    public final void a(Object object0, Object object1) {
        ((a0)object0).a = ((Number)object1).intValue();
    }

    @Override  // kotlin.jvm.internal.t
    public final Object get(Object object0) {
        return ((a0)object0).a;
    }
}

