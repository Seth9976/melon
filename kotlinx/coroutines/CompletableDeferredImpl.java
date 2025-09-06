package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0007\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0011\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000F\u0010\b\u001A\u00028\u0000H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001A\u00028\u0000H\u0096@¢\u0006\u0004\b\n\u0010\u000BJ\u0017\u0010\u000E\u001A\u00020\r2\u0006\u0010\f\u001A\u00028\u0000H\u0016¢\u0006\u0004\b\u000E\u0010\u000FJ\u0017\u0010\u0012\u001A\u00020\r2\u0006\u0010\u0011\u001A\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0016\u001A\u00020\r8PX\u0090\u0004¢\u0006\u0006\u001A\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lkotlinx/coroutines/CompletableDeferredImpl;", "T", "Lkotlinx/coroutines/JobSupport;", "Lkotlinx/coroutines/CompletableDeferred;", "Lkotlinx/coroutines/Job;", "parent", "<init>", "(Lkotlinx/coroutines/Job;)V", "getCompleted", "()Ljava/lang/Object;", "await", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "value", "", "complete", "(Ljava/lang/Object;)Z", "", "exception", "completeExceptionally", "(Ljava/lang/Throwable;)Z", "getOnCancelComplete$kotlinx_coroutines_core", "()Z", "onCancelComplete", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
final class CompletableDeferredImpl extends JobSupport implements CompletableDeferred {
    public CompletableDeferredImpl(@Nullable Job job0) {
        super(true);
        this.initParentJob(job0);
    }

    @Override  // kotlinx.coroutines.Deferred
    @Nullable
    public Object await(@NotNull Continuation continuation0) {
        return this.awaitInternal(continuation0);
    }

    @Override  // kotlinx.coroutines.CompletableDeferred
    public boolean complete(Object object0) {
        return this.makeCompleting$kotlinx_coroutines_core(object0);
    }

    @Override  // kotlinx.coroutines.CompletableDeferred
    public boolean completeExceptionally(@NotNull Throwable throwable0) {
        return this.makeCompleting$kotlinx_coroutines_core(new CompletedExceptionally(throwable0, false, 2, null));
    }

    @Override  // kotlinx.coroutines.Deferred
    public Object getCompleted() {
        return this.getCompletedInternal$kotlinx_coroutines_core();
    }

    @Override  // kotlinx.coroutines.JobSupport
    public boolean getOnCancelComplete$kotlinx_coroutines_core() {
        return true;
    }
}

