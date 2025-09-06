package kotlinx.coroutines;

import d5.n;
import ie.o;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0015\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\n\u001A\u00020\t2\b\u0010\b\u001A\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000BR\u001A\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\fR\u0014\u0010\u0010\u001A\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u000E\u0010\u000F¨\u0006\u0011"}, d2 = {"Lkotlinx/coroutines/ResumeAwaitOnCompletion;", "T", "Lkotlinx/coroutines/JobNode;", "Lkotlinx/coroutines/CancellableContinuationImpl;", "continuation", "<init>", "(Lkotlinx/coroutines/CancellableContinuationImpl;)V", "", "cause", "Lie/H;", "invoke", "(Ljava/lang/Throwable;)V", "Lkotlinx/coroutines/CancellableContinuationImpl;", "", "getOnCancelling", "()Z", "onCancelling", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
final class ResumeAwaitOnCompletion extends JobNode {
    @NotNull
    private final CancellableContinuationImpl continuation;

    public ResumeAwaitOnCompletion(@NotNull CancellableContinuationImpl cancellableContinuationImpl0) {
        this.continuation = cancellableContinuationImpl0;
    }

    @Override  // kotlinx.coroutines.JobNode
    public boolean getOnCancelling() {
        return false;
    }

    @Override  // kotlinx.coroutines.JobNode
    public void invoke(@Nullable Throwable throwable0) {
        Object object0 = this.getJob().getState$kotlinx_coroutines_core();
        if(object0 instanceof CompletedExceptionally) {
            o o0 = n.t(((CompletedExceptionally)object0).cause);
            this.continuation.resumeWith(o0);
            return;
        }
        Object object1 = JobSupportKt.unboxState(object0);
        this.continuation.resumeWith(object1);
    }
}

