package We;

import Ve.Y;
import kotlin.jvm.internal.t;

public final class d extends t {
    public static final int b;

    static {
        new d(Y.class, "flags", "getFlags$kotlin_metadata()I", 0);  // 初始化器: Lkotlin/jvm/internal/t;-><init>(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;I)V
    }

    @Override  // kotlin.jvm.internal.t
    public final void a(Object object0, Object object1) {
        ((Y)object0).a = ((Number)object1).intValue();
    }

    @Override  // kotlin.jvm.internal.t
    public final Object get(Object object0) {
        return ((Y)object0).a;
    }
}

