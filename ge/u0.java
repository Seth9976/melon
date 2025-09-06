package Ge;

import java.lang.ref.SoftReference;
import we.a;

public final class u0 implements a {
    public final a a;
    public volatile SoftReference b;
    public static final v0 c;

    static {
        u0.c = new v0();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public u0(Object object0, a a0) {
        if(a0 == null) {
            throw new IllegalArgumentException("Argument for @NotNull parameter \'initializer\' of kotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal.<init> must not be null");
        }
        super();
        this.b = null;
        this.a = a0;
        if(object0 != null) {
            this.b = new SoftReference(object0);
        }
    }

    @Override  // we.a
    public final Object invoke() {
        v0 v00 = u0.c;
        SoftReference softReference0 = this.b;
        if(softReference0 != null) {
            Object object0 = softReference0.get();
            if(object0 != null) {
                return object0 == v00 ? null : object0;
            }
        }
        Object object1 = this.a.invoke();
        if(object1 != null) {
            v00 = object1;
        }
        this.b = new SoftReference(v00);
        return object1;
    }
}

