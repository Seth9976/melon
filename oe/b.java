package oe;

import kotlin.coroutines.Continuation;
import me.i;

public final class b implements Continuation {
    public static final b a;

    static {
        b.a = new b();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    @Override  // kotlin.coroutines.Continuation
    public final i getContext() {
        throw new IllegalStateException("This continuation is already complete");
    }

    @Override  // kotlin.coroutines.Continuation
    public final void resumeWith(Object object0) {
        throw new IllegalStateException("This continuation is already complete");
    }

    @Override
    public final String toString() {
        return "This continuation is already complete";
    }
}

