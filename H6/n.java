package H6;

import va.e;

public final class n implements k {
    public final Object a;
    public volatile k b;
    public Object c;
    public static final m d;

    static {
        n.d = new m(0);
    }

    public n(k k0) {
        this.a = new Object();
        this.b = k0;
    }

    @Override  // H6.k
    public final Object get() {
        m m0 = n.d;
        if(this.b != m0) {
            synchronized(this.a) {
                if(this.b != m0) {
                    Object object1 = this.b.get();
                    this.c = object1;
                    this.b = m0;
                    return object1;
                }
            }
        }
        return this.c;
    }

    @Override
    public final String toString() {
        k k0 = this.b;
        StringBuilder stringBuilder0 = new StringBuilder("Suppliers.memoize(");
        if(k0 == n.d) {
            k0 = e.d(new StringBuilder("<supplier that returned "), this.c, ">");
        }
        return e.d(stringBuilder0, k0, ")");
    }
}

