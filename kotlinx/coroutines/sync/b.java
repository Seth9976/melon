package kotlinx.coroutines.sync;

import we.k;

public final class b implements k {
    public final MutexImpl a;
    public final CancellableContinuationWithOwner b;

    public b(MutexImpl mutexImpl0, CancellableContinuationWithOwner mutexImpl$CancellableContinuationWithOwner0) {
        this.a = mutexImpl0;
        this.b = mutexImpl$CancellableContinuationWithOwner0;
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        return CancellableContinuationWithOwner.resume$lambda$6(this.a, this.b, ((Throwable)object0));
    }
}

