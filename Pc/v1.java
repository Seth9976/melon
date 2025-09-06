package pc;

import android.util.Log;
import kotlinx.coroutines.CoroutineExceptionHandler;
import me.a;
import me.i;

public final class v1 extends a implements CoroutineExceptionHandler {
    @Override  // kotlinx.coroutines.CoroutineExceptionHandler
    public final void handleException(i i0, Throwable throwable0) {
        Log.e("MixUpType", "exceptionHandler " + throwable0);
    }
}

