package i5;

import kotlinx.coroutines.CoroutineExceptionHandler.Key;
import kotlinx.coroutines.CoroutineExceptionHandler;
import me.a;
import me.i;
import x5.k;

public final class m extends a implements CoroutineExceptionHandler {
    public final n b;

    public m(Key coroutineExceptionHandler$Key0, n n0) {
        this.b = n0;
        super(coroutineExceptionHandler$Key0);
    }

    @Override  // kotlinx.coroutines.CoroutineExceptionHandler
    public final void handleException(i i0, Throwable throwable0) {
        if(this.b.g != null) {
            k.a("RealImageLoader", 6, null, throwable0);
        }
    }
}

