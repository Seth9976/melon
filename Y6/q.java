package Y6;

import B9.g;
import H7.k;
import y7.a;
import y7.b;

public final class q implements b {
    public a a;
    public volatile b b;
    public static final T7.b c;
    public static final k d;

    static {
        q.c = new T7.b(17);
        q.d = new k(2);
    }

    public q(T7.b b0, b b1) {
        this.a = b0;
        this.b = b1;
    }

    public final void a(a a0) {
        b b1;
        b b2;
        b b0 = this.b;
        k k0 = q.d;
        if(b0 != k0) {
            a0.g(b0);
            return;
        }
        synchronized(this) {
            b1 = this.b;
            if(b1 == k0) {
                this.a = new g(17, this.a, a0);
                b2 = null;
            }
            else {
                b2 = b1;
            }
        }
        if(b2 != null) {
            a0.g(b1);
        }
    }

    @Override  // y7.b
    public final Object get() {
        return this.b.get();
    }
}

