package kotlinx.coroutines;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0003\u001A\u0006\u0012\u0002\b\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\t\u001A\u00020\b2\b\u0010\u0007\u001A\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0018\u0010\u0003\u001A\u0006\u0012\u0002\b\u00030\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000BR\u0014\u0010\u000F\u001A\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\r\u0010\u000E¨\u0006\u0010"}, d2 = {"Lkotlinx/coroutines/ChildContinuation;", "Lkotlinx/coroutines/JobNode;", "Lkotlinx/coroutines/CancellableContinuationImpl;", "child", "<init>", "(Lkotlinx/coroutines/CancellableContinuationImpl;)V", "", "cause", "Lie/H;", "invoke", "(Ljava/lang/Throwable;)V", "Lkotlinx/coroutines/CancellableContinuationImpl;", "", "getOnCancelling", "()Z", "onCancelling", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
final class ChildContinuation extends JobNode {
    @NotNull
    public final CancellableContinuationImpl child;

    public ChildContinuation(@NotNull CancellableContinuationImpl cancellableContinuationImpl0) {
        this.child = cancellableContinuationImpl0;
    }

    @Override  // kotlinx.coroutines.JobNode
    public boolean getOnCancelling() {
        return true;
    }

    @Override  // kotlinx.coroutines.JobNode
    public void invoke(@Nullable Throwable throwable0) {
        JobSupport jobSupport0 = this.getJob();
        Throwable throwable1 = this.child.getContinuationCancellationCause(jobSupport0);
        this.child.parentCancelled$kotlinx_coroutines_core(throwable1);
    }
}

