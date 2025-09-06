package kotlinx.coroutines.guava;

import M6.B;
import d5.f;
import d5.n;
import ie.o;
import java.util.concurrent.ExecutionException;
import kotlin.Metadata;
import kotlinx.coroutines.CancellableContinuation.DefaultImpls;
import kotlinx.coroutines.CancellableContinuation;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00060\u0002j\u0002`\u0003B#\u0012\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0004\b\b\u0010\tJ\u000F\u0010\u000B\u001A\u00020\nH\u0016¢\u0006\u0004\b\u000B\u0010\fR\u001D\u0010\u0005\u001A\b\u0012\u0004\u0012\u00028\u00000\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\r\u001A\u0004\b\u000E\u0010\u000FR\u001D\u0010\u0007\u001A\b\u0012\u0004\u0012\u00028\u00000\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0010\u001A\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lkotlinx/coroutines/guava/ToContinuation;", "T", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "LM6/B;", "futureToObserve", "Lkotlinx/coroutines/CancellableContinuation;", "continuation", "<init>", "(LM6/B;Lkotlinx/coroutines/CancellableContinuation;)V", "Lie/H;", "run", "()V", "LM6/B;", "getFutureToObserve", "()LM6/B;", "Lkotlinx/coroutines/CancellableContinuation;", "getContinuation", "()Lkotlinx/coroutines/CancellableContinuation;", "kotlinx-coroutines-guava"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
final class ToContinuation implements Runnable {
    @NotNull
    private final CancellableContinuation continuation;
    @NotNull
    private final B futureToObserve;

    public ToContinuation(@NotNull B b0, @NotNull CancellableContinuation cancellableContinuation0) {
        this.futureToObserve = b0;
        this.continuation = cancellableContinuation0;
    }

    @Override
    public void run() {
        if(this.futureToObserve.isCancelled()) {
            DefaultImpls.cancel$default(this.continuation, null, 1, null);
            return;
        }
        try {
            Object object0 = f.H(this.futureToObserve);
            this.continuation.resumeWith(object0);
        }
        catch(ExecutionException executionException0) {
            o o0 = n.t(ListenableFutureKt.nonNullCause(executionException0));
            this.continuation.resumeWith(o0);
        }
    }
}

