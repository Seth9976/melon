package ge;

public final class a implements b {
    public volatile b a;
    public volatile Object b;
    public static final Object c;

    static {
        a.c = new Object();
    }

    public static b a(b b0) {
        if(b0 instanceof a) {
            return b0;
        }
        b b1 = new a();  // 初始化器: Ljava/lang/Object;-><init>()V
        b1.b = a.c;
        b1.a = b0;
        return b1;
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

