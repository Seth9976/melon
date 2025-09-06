package r0;

import kotlin.jvm.internal.r;
import we.n;

public final class j extends r implements n {
    public static final j f;

    static {
        j.f = new j(2);  // 初始化器: Lkotlin/jvm/internal/r;-><init>(I)V
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((String)object0).length() == 0 ? ((o)object1).toString() : ((String)object0) + ", " + ((o)object1);
    }
}

