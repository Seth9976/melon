package pg;

import d8.d;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import jg.g;
import jg.i;

public final class a implements i {
    public final AtomicReference a;
    public final boolean b;
    public static final long c;

    static {
        a.c = (long)g.c;
    }

    public a(ExecutorService executorService0, boolean z) {
        this.b = z;
        this.a = new AtomicReference(executorService0);
    }

    @Override  // jg.i
    public final boolean execute(Runnable runnable0) {
        ExecutorService executorService0 = (ExecutorService)this.a.get();
        if(executorService0 != null) {
            try {
                executorService0.execute(runnable0);
                return true;
            }
            catch(RejectedExecutionException unused_ex) {
            }
        }
        return false;
    }

    @Override  // jg.i
    public final void terminate() {
        ExecutorService executorService0 = (ExecutorService)this.a.getAndSet(null);
        if(executorService0 != null) {
            if(!this.b) {
                executorService0.shutdownNow();
                return;
            }
            try {
                executorService0.shutdown();
                if(!executorService0.awaitTermination(a.c, TimeUnit.MILLISECONDS)) {
                    executorService0.shutdownNow();
                }
            }
            catch(InterruptedException interruptedException0) {
                executorService0.shutdownNow();
                d.I(interruptedException0);
            }
        }
    }
}

