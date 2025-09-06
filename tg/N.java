package tg;

import ea.c;
import java.util.concurrent.Executor;
import okhttp3.Request;
import okio.Timeout;

public final class n implements d {
    public final Executor a;
    public final d b;

    public n(Executor executor0, d d0) {
        this.a = executor0;
        this.b = d0;
    }

    @Override  // tg.d
    public final void cancel() {
        this.b.cancel();
    }

    @Override
    public final Object clone() {
        return this.clone();
    }

    @Override  // tg.d
    public final d clone() {
        d d0 = this.b.clone();
        return new n(this.a, d0);
    }

    @Override  // tg.d
    public final void enqueue(g g0) {
        c c0 = new c(this, g0);
        this.b.enqueue(c0);
    }

    @Override  // tg.d
    public final Q execute() {
        return this.b.execute();
    }

    @Override  // tg.d
    public final boolean isCanceled() {
        return this.b.isCanceled();
    }

    @Override  // tg.d
    public final boolean isExecuted() {
        return this.b.isExecuted();
    }

    @Override  // tg.d
    public final Request request() {
        return this.b.request();
    }

    @Override  // tg.d
    public final Timeout timeout() {
        return this.b.timeout();
    }
}

