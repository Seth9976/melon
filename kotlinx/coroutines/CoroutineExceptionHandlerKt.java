package kotlinx.coroutines;

import e2.a;
import kotlin.Metadata;
import kotlinx.coroutines.internal.CoroutineExceptionHandlerImpl_commonKt;
import me.i;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001A\u001F\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0001\u001A\u00020\u00002\u0006\u0010\u0003\u001A\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001A\u001F\u0010\t\u001A\u00020\u00022\u0006\u0010\u0007\u001A\u00020\u00022\u0006\u0010\b\u001A\u00020\u0002H\u0000¢\u0006\u0004\b\t\u0010\n¨\u0006\u000B"}, d2 = {"Lme/i;", "context", "", "exception", "Lie/H;", "handleCoroutineException", "(Lme/i;Ljava/lang/Throwable;)V", "originalException", "thrownException", "handlerException", "(Ljava/lang/Throwable;Ljava/lang/Throwable;)Ljava/lang/Throwable;", "kotlinx-coroutines-core"}, k = 2, mv = {2, 1, 0}, xi = 0x30)
public abstract class CoroutineExceptionHandlerKt {
    public static final void handleCoroutineException(@NotNull i i0, @NotNull Throwable throwable0) {
        if(throwable0 instanceof DispatchException) {
            throwable0 = ((DispatchException)throwable0).getCause();
        }
        try {
            CoroutineExceptionHandler coroutineExceptionHandler0 = (CoroutineExceptionHandler)i0.get(CoroutineExceptionHandler.Key);
            if(coroutineExceptionHandler0 != null) {
                coroutineExceptionHandler0.handleException(i0, throwable0);
                return;
            }
        }
        catch(Throwable throwable1) {
            CoroutineExceptionHandlerImpl_commonKt.handleUncaughtCoroutineException(i0, CoroutineExceptionHandlerKt.handlerException(throwable0, throwable1));
            return;
        }
        CoroutineExceptionHandlerImpl_commonKt.handleUncaughtCoroutineException(i0, throwable0);
    }

    @NotNull
    public static final Throwable handlerException(@NotNull Throwable throwable0, @NotNull Throwable throwable1) {
        if(throwable0 == throwable1) {
            return throwable0;
        }
        Throwable throwable2 = new RuntimeException("Exception while trying to handle coroutine exception", throwable1);
        a.q(throwable2, throwable0);
        return throwable2;
    }
}

