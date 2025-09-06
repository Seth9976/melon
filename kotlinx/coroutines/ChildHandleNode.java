package kotlinx.coroutines;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u000F\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\n\u001A\u00020\t2\b\u0010\b\u001A\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000BJ\u0017\u0010\r\u001A\u00020\f2\u0006\u0010\b\u001A\u00020\u0007H\u0016¢\u0006\u0004\b\r\u0010\u000ER\u0014\u0010\u0004\u001A\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u000FR\u0014\u0010\u0013\u001A\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001A\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lkotlinx/coroutines/ChildHandleNode;", "Lkotlinx/coroutines/JobNode;", "Lkotlinx/coroutines/ChildHandle;", "Lkotlinx/coroutines/ChildJob;", "childJob", "<init>", "(Lkotlinx/coroutines/ChildJob;)V", "", "cause", "Lie/H;", "invoke", "(Ljava/lang/Throwable;)V", "", "childCancelled", "(Ljava/lang/Throwable;)Z", "Lkotlinx/coroutines/ChildJob;", "Lkotlinx/coroutines/Job;", "getParent", "()Lkotlinx/coroutines/Job;", "parent", "getOnCancelling", "()Z", "onCancelling", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
final class ChildHandleNode extends JobNode implements ChildHandle {
    @NotNull
    public final ChildJob childJob;

    public ChildHandleNode(@NotNull ChildJob childJob0) {
        this.childJob = childJob0;
    }

    @Override  // kotlinx.coroutines.ChildHandle
    public boolean childCancelled(@NotNull Throwable throwable0) {
        return this.getJob().childCancelled(throwable0);
    }

    @Override  // kotlinx.coroutines.JobNode
    public boolean getOnCancelling() {
        return true;
    }

    @Override  // kotlinx.coroutines.ChildHandle
    @NotNull
    public Job getParent() {
        return this.getJob();
    }

    @Override  // kotlinx.coroutines.JobNode
    public void invoke(@Nullable Throwable throwable0) {
        JobSupport jobSupport0 = this.getJob();
        this.childJob.parentCancelled(jobSupport0);
    }
}

