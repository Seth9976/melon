package tg;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;

public final class c extends a {
    @Override  // tg.a
    public final List a(Executor executor0) {
        return Arrays.asList(new e[]{new k(), new o(executor0)});  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    @Override  // tg.a
    public final List b() {
        return Collections.singletonList(new b(1));
    }
}

