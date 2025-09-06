package y4;

import Ic.h;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public final class a {
    public final h a;
    public final AtomicInteger b;
    public final AtomicBoolean c;

    public a(h h0) {
        this.a = h0;
        this.b = new AtomicInteger(0);
        this.c = new AtomicBoolean(false);
    }

    public final boolean a() {
        synchronized(this) {
            if(this.c.get()) {
                return false;
            }
            this.b.incrementAndGet();
            return true;
        }
    }

    public final void b() {
        synchronized(this) {
            this.b.decrementAndGet();
            if(this.b.get() >= 0) {
                return;
            }
        }
        throw new IllegalStateException("Unbalanced call to unblock() detected.");
    }
}

