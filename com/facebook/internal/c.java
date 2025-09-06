package com.facebook.internal;

import java.util.concurrent.Callable;

public final class c implements Callable {
    public final LockOnGetVariable a;
    public final Callable b;

    public c(LockOnGetVariable lockOnGetVariable0, Callable callable0) {
        this.a = lockOnGetVariable0;
        this.b = callable0;
    }

    @Override
    public final Object call() {
        return LockOnGetVariable._init_$lambda$0(this.a, this.b);
    }
}

