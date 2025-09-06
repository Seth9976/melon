package M6;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public final class G extends D implements ScheduledExecutorService {
    public final ScheduledExecutorService b;

    public G(ScheduledExecutorService scheduledExecutorService0) {
        super(scheduledExecutorService0);
        this.b = scheduledExecutorService0;
    }

    @Override
    public final ScheduledFuture schedule(Runnable runnable0, long v, TimeUnit timeUnit0) {
        J j0 = new J(Executors.callable(runnable0, null));
        return new E(j0, this.b.schedule(j0, v, timeUnit0));
    }

    @Override
    public final ScheduledFuture schedule(Callable callable0, long v, TimeUnit timeUnit0) {
        J j0 = new J(callable0);
        return new E(j0, this.b.schedule(j0, v, timeUnit0));
    }

    @Override
    public final ScheduledFuture scheduleAtFixedRate(Runnable runnable0, long v, long v1, TimeUnit timeUnit0) {
        F f0 = new F(runnable0);
        return new E(f0, this.b.scheduleAtFixedRate(f0, v, v1, timeUnit0));
    }

    @Override
    public final ScheduledFuture scheduleWithFixedDelay(Runnable runnable0, long v, long v1, TimeUnit timeUnit0) {
        F f0 = new F(runnable0);
        return new E(f0, this.b.scheduleWithFixedDelay(f0, v, v1, timeUnit0));
    }
}

