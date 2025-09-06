package M6;

import java.util.concurrent.locks.AbstractOwnableSynchronizer;

public final class y extends AbstractOwnableSynchronizer implements Runnable {
    public final I a;

    public y(I i0) {
        this.a = i0;
    }

    public static void a(y y0, Thread thread0) {
        y0.setExclusiveOwnerThread(thread0);
    }

    @Override
    public final void run() {
    }

    @Override
    public final String toString() {
        return this.a.toString();
    }
}

