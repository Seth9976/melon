package androidx.compose.runtime;

import i.n.i.b.a.s.e.M3;
import kotlin.jvm.internal.r;
import we.a;

public final class z extends r implements a {
    public static final z f;

    static {
        z.f = new z(0);  // 初始化器: Lkotlin/jvm/internal/r;-><init>(I)V
    }

    @Override  // we.a
    public final Object invoke() {
        q.d("Unexpected call to default provider");
        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
    }
}

