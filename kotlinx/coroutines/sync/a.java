package kotlinx.coroutines.sync;

import ie.H;
import me.i;
import we.o;

public final class a implements o {
    public final MutexImpl a;
    public final CancellableContinuationWithOwner b;

    public a(MutexImpl mutexImpl0, CancellableContinuationWithOwner mutexImpl$CancellableContinuationWithOwner0) {
        this.a = mutexImpl0;
        this.b = mutexImpl$CancellableContinuationWithOwner0;
    }

    @Override  // we.o
    public final Object invoke(Object object0, Object object1, Object object2) {
        return CancellableContinuationWithOwner.tryResume$lambda$3(this.a, this.b, ((Throwable)object0), ((H)object1), ((i)object2));
    }
}

