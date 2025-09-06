package kotlinx.coroutines.internal;

import e2.a;
import kotlin.Metadata;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;
import me.i;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A\u001F\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0001\u001A\u00020\u00002\u0006\u0010\u0003\u001A\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lme/i;", "context", "", "exception", "Lie/H;", "handleUncaughtCoroutineException", "(Lme/i;Ljava/lang/Throwable;)V", "kotlinx-coroutines-core"}, k = 2, mv = {2, 1, 0}, xi = 0x30)
public abstract class CoroutineExceptionHandlerImpl_commonKt {
    public static final void handleUncaughtCoroutineException(@NotNull i i0, @NotNull Throwable throwable0) {
        for(Object object0: CoroutineExceptionHandlerImplKt.getPlatformExceptionHandlers()) {
            CoroutineExceptionHandler coroutineExceptionHandler0 = (CoroutineExceptionHandler)object0;
            try {
                coroutineExceptionHandler0.handleException(i0, throwable0);
            }
            catch(Throwable throwable1) {
                CoroutineExceptionHandlerImplKt.propagateExceptionFinalResort(CoroutineExceptionHandlerKt.handlerException(throwable0, throwable1));
            }
        }
        try {
            a.q(throwable0, new DiagnosticCoroutineContextException(i0));
        }
        catch(Throwable unused_ex) {
        }
        CoroutineExceptionHandlerImplKt.propagateExceptionFinalResort(throwable0);
    }
}

