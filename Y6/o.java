package Y6;

import y7.b;

public final class o implements b {
    public volatile Object a;
    public volatile b b;
    public static final Object c;

    static {
        o.c = new Object();
    }

    public o(b b0) {
        this.a = o.c;
        this.b = b0;
    }

    @Override  // y7.b
    public final Object get() {
        Object object0 = this.a;
        Object object1 = o.c;
        if(object0 == object1) {
            synchronized(this) {
                Object object2 = this.a;
                if(object2 == object1) {
                    object2 = this.b.get();
                    this.a = object2;
                    this.b = null;
                }
                return object2;
            }
        }
        return object0;
    }
}

