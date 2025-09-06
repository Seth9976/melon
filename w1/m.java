package w1;

import M6.B;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public final class m implements B {
    public final WeakReference a;
    public final l b;

    public m(j j0) {
        this.b = new l(this);
        this.a = new WeakReference(j0);
    }

    @Override  // M6.B
    public final void addListener(Runnable runnable0, Executor executor0) {
        this.b.addListener(runnable0, executor0);
    }

    @Override
    public final boolean cancel(boolean z) {
        j j0 = (j)this.a.get();
        boolean z1 = this.b.cancel(z);
        if(z1 && j0 != null) {
            j0.a = null;
            j0.b = null;
            j0.c.i(null);
        }
        return z1;
    }

    @Override
    public final Object get() {
        return this.b.get();
    }

    @Override
    public final Object get(long v, TimeUnit timeUnit0) {
        return this.b.get(v, timeUnit0);
    }

    @Override
    public final boolean isCancelled() {
        return this.b.a instanceof a;
    }

    @Override
    public final boolean isDone() {
        return this.b.isDone();
    }

    @Override
    public final String toString() {
        return this.b.toString();
    }
}

