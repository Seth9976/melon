package Z6;

import M6.u;
import Q5.r;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayDeque;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Logger;

public final class i implements Executor {
    public final Executor a;
    public final ArrayDeque b;
    public int c;
    public long d;
    public final u e;
    public static final Logger f;

    static {
        i.f = Logger.getLogger("Z6.i");
    }

    public i(Executor executor0) {
        this.b = new ArrayDeque();
        this.c = 1;
        this.d = 0L;
        this.e = new u(this);
        this.a = (Executor)Preconditions.checkNotNull(executor0);
    }

    @Override
    public final void execute(Runnable runnable0) {
        ArrayDeque arrayDeque1;
        Preconditions.checkNotNull(runnable0);
        synchronized(this.b) {
            if(this.c != 3 && this.c != 4) {
                long v1 = this.d;
                r r0 = new r(runnable0, 1);
                this.b.add(r0);
                this.c = 2;
                try {
                    this.a.execute(this.e);
                }
                catch(RuntimeException | Error runtimeException0) {
                    boolean z = true;
                    arrayDeque1 = this.b;
                    synchronized(arrayDeque1) {
                        if(this.c != 1 && this.c != 2 || !this.b.removeLastOccurrence(r0)) {
                            z = false;
                        }
                        if(!(runtimeException0 instanceof RejectedExecutionException) || z) {
                            throw runtimeException0;
                        }
                    }
                    return;
                }
                if(this.c == 2) {
                    ArrayDeque arrayDeque2 = this.b;
                    synchronized(arrayDeque2) {
                        if(this.d == v1 && this.c == 2) {
                            this.c = 3;
                        }
                    }
                    return;
                }
                return;
            }
            this.b.add(runnable0);
        }
    }

    @Override
    public final String toString() {
        return "SequentialExecutor@" + System.identityHashCode(this) + "{" + this.a + "}";
    }
}

