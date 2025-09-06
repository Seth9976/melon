package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.k;
import we.o;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000\u0002JO\u0010\f\u001A\u0004\u0018\u00010\u0005\"\b\b\u0001\u0010\u0003*\u00028\u00002\u0006\u0010\u0004\u001A\u00028\u00012\b\u0010\u0006\u001A\u0004\u0018\u00010\u00052 \u0010\u000B\u001A\u001C\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007H\'¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000F\u001A\u0004\u0018\u00010\u00052\u0006\u0010\u000E\u001A\u00020\bH\'¢\u0006\u0004\b\u000F\u0010\u0010J\u0017\u0010\u0012\u001A\u00020\n2\u0006\u0010\u0011\u001A\u00020\u0005H\'¢\u0006\u0004\b\u0012\u0010\u0013J\u001B\u0010\u0016\u001A\u00020\u00152\n\b\u0002\u0010\u0014\u001A\u0004\u0018\u00010\bH&¢\u0006\u0004\b\u0016\u0010\u0017J)\u0010\u001B\u001A\u00020\n2\u0018\u0010\u001A\u001A\u0014\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\n0\u0018j\u0002`\u0019H&¢\u0006\u0004\b\u001B\u0010\u001CJ\u001B\u0010\u001E\u001A\u00020\n*\u00020\u001D2\u0006\u0010\u0004\u001A\u00028\u0000H\'¢\u0006\u0004\b\u001E\u0010\u001FJC\u0010 \u001A\u00020\n\"\b\b\u0001\u0010\u0003*\u00028\u00002\u0006\u0010\u0004\u001A\u00028\u00012 \u0010\u000B\u001A\u001C\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007H&¢\u0006\u0004\b \u0010!R\u0014\u0010\"\u001A\u00020\u00158&X¦\u0004¢\u0006\u0006\u001A\u0004\b\"\u0010#R\u0014\u0010$\u001A\u00020\u00158&X¦\u0004¢\u0006\u0006\u001A\u0004\b$\u0010#¨\u0006%"}, d2 = {"Lkotlinx/coroutines/CancellableContinuation;", "T", "Lkotlin/coroutines/Continuation;", "R", "value", "", "idempotent", "Lkotlin/Function3;", "", "Lme/i;", "Lie/H;", "onCancellation", "tryResume", "(Ljava/lang/Object;Ljava/lang/Object;Lwe/o;)Ljava/lang/Object;", "exception", "tryResumeWithException", "(Ljava/lang/Throwable;)Ljava/lang/Object;", "token", "completeResume", "(Ljava/lang/Object;)V", "cause", "", "cancel", "(Ljava/lang/Throwable;)Z", "Lkotlin/Function1;", "Lkotlinx/coroutines/CompletionHandler;", "handler", "invokeOnCancellation", "(Lwe/k;)V", "Lkotlinx/coroutines/CoroutineDispatcher;", "resumeUndispatched", "(Lkotlinx/coroutines/CoroutineDispatcher;Ljava/lang/Object;)V", "resume", "(Ljava/lang/Object;Lwe/o;)V", "isActive", "()Z", "isCompleted", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public interface CancellableContinuation extends Continuation {
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 0x30)
    public static abstract class DefaultImpls {
        public static boolean cancel$default(CancellableContinuation cancellableContinuation0, Throwable throwable0, int v, Object object0) {
            if(object0 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
            }
            if((v & 1) != 0) {
                throwable0 = null;
            }
            return cancellableContinuation0.cancel(throwable0);
        }
    }

    boolean cancel(@Nullable Throwable arg1);

    void completeResume(@NotNull Object arg1);

    void invokeOnCancellation(@NotNull k arg1);

    boolean isActive();

    boolean isCompleted();

    void resume(Object arg1, @Nullable o arg2);

    void resumeUndispatched(@NotNull CoroutineDispatcher arg1, Object arg2);

    @Nullable
    Object tryResume(Object arg1, @Nullable Object arg2, @Nullable o arg3);

    @Nullable
    Object tryResumeWithException(@NotNull Throwable arg1);
}

