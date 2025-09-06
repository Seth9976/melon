package kotlinx.coroutines;

import ie.H;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u001D\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\b\u0010\tJ\u000F\u0010\n\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\n\u0010\u000BR\u0014\u0010\u0004\u001A\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\fR\u001A\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\u00060\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\r¨\u0006\u000E"}, d2 = {"Lkotlinx/coroutines/ResumeUndispatchedRunnable;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "Lkotlinx/coroutines/CoroutineDispatcher;", "dispatcher", "Lkotlinx/coroutines/CancellableContinuation;", "Lie/H;", "continuation", "<init>", "(Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CancellableContinuation;)V", "run", "()V", "Lkotlinx/coroutines/CoroutineDispatcher;", "Lkotlinx/coroutines/CancellableContinuation;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
final class ResumeUndispatchedRunnable implements Runnable {
    @NotNull
    private final CancellableContinuation continuation;
    @NotNull
    private final CoroutineDispatcher dispatcher;

    public ResumeUndispatchedRunnable(@NotNull CoroutineDispatcher coroutineDispatcher0, @NotNull CancellableContinuation cancellableContinuation0) {
        this.dispatcher = coroutineDispatcher0;
        this.continuation = cancellableContinuation0;
    }

    @Override
    public void run() {
        this.continuation.resumeUndispatched(this.dispatcher, H.a);
    }
}

