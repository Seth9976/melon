package me;

import java.io.Serializable;
import kotlin.jvm.internal.q;
import we.n;

public final class j implements Serializable, i {
    public static final j a;
    private static final long serialVersionUID;

    static {
        j.a = new j();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    @Override  // me.i
    public final Object fold(Object object0, n n0) {
        q.g(n0, "operation");
        return object0;
    }

    @Override  // me.i
    public final g get(h h0) {
        q.g(h0, "key");
        return null;
    }

    @Override
    public final int hashCode() {
        return 0;
    }

    @Override  // me.i
    public final i minusKey(h h0) {
        q.g(h0, "key");
        return this;
    }

    @Override  // me.i
    public final i plus(i i0) {
        q.g(i0, "context");
        return i0;
    }

    private final Object readResolve() {
        return j.a;
    }

    @Override
    public final String toString() {
        return "EmptyCoroutineContext";
    }
}

