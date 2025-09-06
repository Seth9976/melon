package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.internal.DispatchedContinuation;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001A\'\u0010\u0005\u001A\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001A\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001A)\u0010\n\u001A\b\u0012\u0004\u0012\u00028\u00000\t\"\u0004\b\u0000\u0010\u00002\f\u0010\b\u001A\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0000¢\u0006\u0004\b\n\u0010\u000B\u001A\u001F\u0010\u000E\u001A\u00020\u0004*\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010\r\u001A\u00020\fH\u0007¢\u0006\u0004\b\u000E\u0010\u000F¨\u0006\u0010"}, d2 = {"T", "Lkotlinx/coroutines/CancellableContinuation;", "Lkotlinx/coroutines/CancelHandler;", "handler", "Lie/H;", "invokeOnCancellation", "(Lkotlinx/coroutines/CancellableContinuation;Lkotlinx/coroutines/CancelHandler;)V", "Lkotlin/coroutines/Continuation;", "delegate", "Lkotlinx/coroutines/CancellableContinuationImpl;", "getOrCreateCancellableContinuation", "(Lkotlin/coroutines/Continuation;)Lkotlinx/coroutines/CancellableContinuationImpl;", "Lkotlinx/coroutines/DisposableHandle;", "handle", "disposeOnCancellation", "(Lkotlinx/coroutines/CancellableContinuation;Lkotlinx/coroutines/DisposableHandle;)V", "kotlinx-coroutines-core"}, k = 2, mv = {2, 1, 0}, xi = 0x30)
public abstract class CancellableContinuationKt {
    public static final void disposeOnCancellation(@NotNull CancellableContinuation cancellableContinuation0, @NotNull DisposableHandle disposableHandle0) {
        CancellableContinuationKt.invokeOnCancellation(cancellableContinuation0, new DisposeOnCancel(disposableHandle0));
    }

    @NotNull
    public static final CancellableContinuationImpl getOrCreateCancellableContinuation(@NotNull Continuation continuation0) {
        if(!(continuation0 instanceof DispatchedContinuation)) {
            return new CancellableContinuationImpl(continuation0, 1);
        }
        CancellableContinuationImpl cancellableContinuationImpl0 = ((DispatchedContinuation)continuation0).claimReusableCancellableContinuation$kotlinx_coroutines_core();
        if(cancellableContinuationImpl0 != null) {
            if(!cancellableContinuationImpl0.resetStateReusable()) {
                cancellableContinuationImpl0 = null;
            }
            return cancellableContinuationImpl0 == null ? new CancellableContinuationImpl(continuation0, 2) : cancellableContinuationImpl0;
        }
        return new CancellableContinuationImpl(continuation0, 2);
    }

    public static final void invokeOnCancellation(@NotNull CancellableContinuation cancellableContinuation0, @NotNull CancelHandler cancelHandler0) {
        if(!(cancellableContinuation0 instanceof CancellableContinuationImpl)) {
            throw new UnsupportedOperationException("third-party implementation of CancellableContinuation is not supported");
        }
        ((CancellableContinuationImpl)cancellableContinuation0).invokeOnCancellationInternal$kotlinx_coroutines_core(cancelHandler0);
    }
}

