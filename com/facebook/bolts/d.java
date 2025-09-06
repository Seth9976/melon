package com.facebook.bolts;

public final class d implements Runnable {
    public final int a;
    public final CancellationToken b;
    public final TaskCompletionSource c;
    public final Continuation d;
    public final Task e;

    public d(CancellationToken cancellationToken0, TaskCompletionSource taskCompletionSource0, Continuation continuation0, Task task0, int v) {
        this.a = v;
        this.b = cancellationToken0;
        this.c = taskCompletionSource0;
        this.d = continuation0;
        this.e = task0;
        super();
    }

    @Override
    public final void run() {
        if(this.a != 0) {
            Companion.g(this.b, this.c, this.d, this.e);
            return;
        }
        Companion.d(this.b, this.c, this.d, this.e);
    }
}

