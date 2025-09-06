package com.facebook.bolts;

import java.util.concurrent.Executor;

public final class b implements Continuation {
    public final int a;
    public final TaskCompletionSource b;
    public final Continuation c;
    public final Executor d;
    public final CancellationToken e;

    public b(TaskCompletionSource taskCompletionSource0, Continuation continuation0, Executor executor0, CancellationToken cancellationToken0, int v) {
        this.a = v;
        this.b = taskCompletionSource0;
        this.c = continuation0;
        this.d = executor0;
        this.e = cancellationToken0;
        super();
    }

    @Override  // com.facebook.bolts.Continuation
    public final Object then(Task task0) {
        return this.a == 0 ? Task.d(this.b, this.c, this.d, this.e, task0) : Task.continueWithTask$lambda$12$lambda$11(this.b, this.c, this.d, this.e, task0);
    }
}

