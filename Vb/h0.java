package Vb;

import Nb.z0;
import Yb.o;
import kotlinx.coroutines.CoroutineExceptionHandler.Key;
import kotlinx.coroutines.CoroutineExceptionHandler;
import me.a;
import me.i;

public final class h0 extends a implements CoroutineExceptionHandler {
    public final o0 b;

    public h0(Key coroutineExceptionHandler$Key0, o0 o00) {
        this.b = o00;
        super(coroutineExceptionHandler$Key0);
    }

    @Override  // kotlinx.coroutines.CoroutineExceptionHandler
    public final void handleException(i i0, Throwable throwable0) {
        o o0 = new o("coroutineExceptionHandler", throwable0);
        z0 z00 = this.b.n.e.a1();
        this.b.k1(o0, z00, null);
    }
}

