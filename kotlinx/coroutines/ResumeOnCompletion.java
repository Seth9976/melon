package kotlinx.coroutines;

import ie.H;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001A\u00020\u00032\b\u0010\b\u001A\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\t\u0010\nR\u001A\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u000BR\u0014\u0010\u000F\u001A\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\r\u0010\u000E¨\u0006\u0010"}, d2 = {"Lkotlinx/coroutines/ResumeOnCompletion;", "Lkotlinx/coroutines/JobNode;", "Lkotlin/coroutines/Continuation;", "Lie/H;", "continuation", "<init>", "(Lkotlin/coroutines/Continuation;)V", "", "cause", "invoke", "(Ljava/lang/Throwable;)V", "Lkotlin/coroutines/Continuation;", "", "getOnCancelling", "()Z", "onCancelling", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
final class ResumeOnCompletion extends JobNode {
    @NotNull
    private final Continuation continuation;

    public ResumeOnCompletion(@NotNull Continuation continuation0) {
        this.continuation = continuation0;
    }

    @Override  // kotlinx.coroutines.JobNode
    public boolean getOnCancelling() {
        return false;
    }

    @Override  // kotlinx.coroutines.JobNode
    public void invoke(@Nullable Throwable throwable0) {
        this.continuation.resumeWith(H.a);
    }
}

