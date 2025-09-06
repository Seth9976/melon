package r0;

import we.k;

public final class n implements q {
    public static final n a;

    static {
        n.a = new n();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    @Override  // r0.q
    public final boolean all(k k0) {
        return true;
    }

    @Override  // r0.q
    public final boolean any(k k0) {
        return false;
    }

    @Override  // r0.q
    public final Object foldIn(Object object0, we.n n0) {
        return object0;
    }

    @Override  // r0.q
    public final q then(q q0) {
        return q0;
    }

    @Override
    public final String toString() {
        return "Modifier";
    }
}

