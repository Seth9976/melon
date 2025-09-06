package t9;

import com.iloen.melon.sns.target.SnsPostListener;
import com.iloen.melon.utils.log.LogU;
import k8.Y;
import kotlinx.coroutines.CoroutineExceptionHandler.Key;
import kotlinx.coroutines.CoroutineExceptionHandler;
import me.a;
import me.i;

public final class c extends a implements CoroutineExceptionHandler {
    public final d b;

    public c(Key coroutineExceptionHandler$Key0, d d0) {
        this.b = d0;
        super(coroutineExceptionHandler$Key0);
    }

    @Override  // kotlinx.coroutines.CoroutineExceptionHandler
    public final void handleException(i i0, Throwable throwable0) {
        Y.w("exceptionHandler - ", throwable0.getMessage(), LogU.Companion, "Facebook");
        d d0 = this.b;
        SnsPostListener snsPostListener0 = d0.a;
        if(snsPostListener0 != null) {
            snsPostListener0.onError("facebook", d0.b, throwable0);
        }
    }
}

