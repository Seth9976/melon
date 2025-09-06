package kotlinx.coroutines.intrinsics;

import d5.n;
import e1.u;
import ie.H;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.DispatchException;
import kotlinx.coroutines.internal.DispatchedContinuationKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0004\u001AQ\u0010\b\u001A\u00020\u0007\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u001E\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00022\u0006\u0010\u0005\u001A\u00028\u00002\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00028\u00010\u0003H\u0000¢\u0006\u0004\b\b\u0010\t\u001A%\u0010\b\u001A\u00020\u0007*\b\u0012\u0004\u0012\u00020\u00070\u00032\n\u0010\n\u001A\u0006\u0012\u0002\b\u00030\u0003H\u0000¢\u0006\u0004\b\b\u0010\u000B\u001A#\u0010\u000E\u001A\u00020\u00072\n\u0010\u0006\u001A\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\r\u001A\u00020\fH\u0002¢\u0006\u0004\b\u000E\u0010\u000F¨\u0006\u0010"}, d2 = {"R", "T", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "receiver", "completion", "Lie/H;", "startCoroutineCancellable", "(Lwe/n;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)V", "fatalCompletion", "(Lkotlin/coroutines/Continuation;Lkotlin/coroutines/Continuation;)V", "", "e", "dispatcherFailure", "(Lkotlin/coroutines/Continuation;Ljava/lang/Throwable;)V", "kotlinx-coroutines-core"}, k = 2, mv = {2, 1, 0}, xi = 0x30)
public abstract class CancellableKt {
    private static final void dispatcherFailure(Continuation continuation0, Throwable throwable0) {
        if(throwable0 instanceof DispatchException) {
            throwable0 = ((DispatchException)throwable0).getCause();
        }
        continuation0.resumeWith(n.t(throwable0));
        throw throwable0;
    }

    public static final void startCoroutineCancellable(@NotNull Continuation continuation0, @NotNull Continuation continuation1) {
        try {
            DispatchedContinuationKt.resumeCancellableWith(u.D(continuation0), H.a);
        }
        catch(Throwable throwable0) {
            CancellableKt.dispatcherFailure(continuation1, throwable0);
        }
    }

    public static final void startCoroutineCancellable(@NotNull we.n n0, Object object0, @NotNull Continuation continuation0) {
        try {
            DispatchedContinuationKt.resumeCancellableWith(u.D(u.q(n0, object0, continuation0)), H.a);
        }
        catch(Throwable throwable0) {
            CancellableKt.dispatcherFailure(continuation0, throwable0);
        }
    }
}

