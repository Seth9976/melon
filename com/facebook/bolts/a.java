package com.facebook.bolts;

public final class a implements Continuation {
    public final int a;
    public final CancellationToken b;
    public final Object c;

    public a(CancellationToken cancellationToken0, Object object0, int v) {
        this.a = v;
        this.b = cancellationToken0;
        this.c = object0;
        super();
    }

    @Override  // com.facebook.bolts.Continuation
    public final Object then(Task task0) {
        switch(this.a) {
            case 0: {
                return Task.onSuccessTask$lambda$14(this.b, ((Continuation)this.c), task0);
            }
            case 1: {
                return Task.onSuccess$lambda$13(this.b, ((Continuation)this.c), task0);
            }
            default: {
                return Companion.e(this.b, ((TaskCompletionSource)this.c), task0);
            }
        }
    }
}

