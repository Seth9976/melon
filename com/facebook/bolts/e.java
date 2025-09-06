package com.facebook.bolts;

import java.util.concurrent.atomic.AtomicBoolean;

public final class e implements Continuation {
    public final int a;
    public final AtomicBoolean b;
    public final TaskCompletionSource c;

    public e(AtomicBoolean atomicBoolean0, TaskCompletionSource taskCompletionSource0, int v) {
        this.a = v;
        this.b = atomicBoolean0;
        this.c = taskCompletionSource0;
        super();
    }

    @Override  // com.facebook.bolts.Continuation
    public final Object then(Task task0) {
        return this.a == 0 ? Companion.h(this.b, this.c, task0) : Companion.c(this.b, this.c, task0);
    }
}

