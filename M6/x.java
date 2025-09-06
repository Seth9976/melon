package M6;

import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import va.e;
import y5.a;

public final class x implements B {
    public final Object a;
    public static final x b;
    public static final A c;

    static {
        x.b = new x(null);
        x.c = new A(x.class);
    }

    public x(Object object0) {
        this.a = object0;
    }

    @Override  // M6.B
    public final void addListener(Runnable runnable0, Executor executor0) {
        a.o(runnable0, "Runnable was null.");
        a.o(executor0, "Executor was null.");
        try {
            executor0.execute(runnable0);
        }
        catch(Exception exception0) {
            x.c.a().log(Level.SEVERE, "RuntimeException while executing runnable " + runnable0 + " with executor " + executor0, exception0);
        }
    }

    @Override
    public final boolean cancel(boolean z) {
        return false;
    }

    @Override
    public final Object get() {
        return this.a;
    }

    @Override
    public final Object get(long v, TimeUnit timeUnit0) {
        timeUnit0.getClass();
        return this.a;
    }

    @Override
    public final boolean isCancelled() {
        return false;
    }

    @Override
    public final boolean isDone() {
        return true;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder();
        stringBuilder0.append(super.toString());
        stringBuilder0.append("[status=SUCCESS, result=[");
        return e.d(stringBuilder0, this.a, "]]");
    }
}

