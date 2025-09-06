package U4;

import java.util.concurrent.atomic.AtomicBoolean;

public final class o implements Runnable {
    public final int a;
    public final AtomicBoolean b;

    public o(AtomicBoolean atomicBoolean0, int v) {
        this.a = v;
        this.b = atomicBoolean0;
        super();
    }

    @Override
    public final void run() {
        if(this.a != 0) {
            this.b.set(true);
            return;
        }
        this.b.set(true);
    }
}

