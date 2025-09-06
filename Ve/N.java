package Ve;

import kotlin.jvm.internal.t;

public final class n extends t {
    public static final n b;

    static {
        n.b = new n(S.class, "flags", "getFlags$kotlin_metadata()I", 0);  // 初始化器: Lkotlin/jvm/internal/t;-><init>(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;I)V
    }

    @Override  // kotlin.jvm.internal.t
    public final void a(Object object0, Object object1) {
        ((S)object0).a = ((Number)object1).intValue();
    }

    @Override  // kotlin.jvm.internal.t
    public final Object get(Object object0) {
        return ((S)object0).a;
    }
}

