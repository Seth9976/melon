package ge;

import k8.n;

public final class c implements b {
    public volatile n a;
    public volatile Object b;
    public static final Object c;

    static {
        c.c = new Object();
    }

    public static b a(n n0) {
        b b0 = new c();  // 初始化器: Ljava/lang/Object;-><init>()V
        b0.b = c.c;
        b0.a = n0;
        return b0;
    }

    @Override  // javax.inject.Provider
    public final Object get() {
        Object object0 = this.b;
        if(object0 == c.c) {
            n n0 = this.a;
            if(n0 == null) {
                return this.b;
            }
            object0 = n0.get();
            this.b = object0;
            this.a = null;
        }
        return object0;
    }
}

