package S5;

import javax.inject.Provider;

public final class a implements Provider {
    public volatile b a;
    public volatile Object b;
    public static final Object c;

    static {
        a.c = new Object();
    }

    public static Provider a(b b0) {
        if(b0 instanceof a) {
            return b0;
        }
        Provider provider0 = new a();  // 初始化器: Ljava/lang/Object;-><init>()V
        provider0.b = a.c;
        provider0.a = b0;
        return provider0;
    }

    @Override  // javax.inject.Provider
    public final Object get() {
        Object object0 = this.b;
        Object object1 = a.c;
        if(object0 == object1) {
            synchronized(this) {
                Object object2 = this.b;
                if(object2 == object1) {
                    object2 = this.a.get();
                    Object object3 = this.b;
                    if(object3 != object1 && object3 != object2) {
                        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + object3 + " & " + object2 + ". This is likely due to a circular dependency.");
                    }
                    this.b = object2;
                    this.a = null;
                }
                return object2;
            }
        }
        return object0;
    }
}

