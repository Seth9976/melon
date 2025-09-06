package kotlinx.coroutines;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.k;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B!\u0012\u0018\u0010\u0006\u001A\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u0002`\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\n\u001A\u00020\u00042\b\u0010\t\u001A\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\n\u0010\u000BR&\u0010\u0006\u001A\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u0002`\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\fR\u0014\u0010\u0010\u001A\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u000E\u0010\u000F¨\u0006\u0011"}, d2 = {"Lkotlinx/coroutines/InvokeOnCompletion;", "Lkotlinx/coroutines/JobNode;", "Lkotlin/Function1;", "", "Lie/H;", "Lkotlinx/coroutines/CompletionHandler;", "handler", "<init>", "(Lwe/k;)V", "cause", "invoke", "(Ljava/lang/Throwable;)V", "Lwe/k;", "", "getOnCancelling", "()Z", "onCancelling", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
final class InvokeOnCompletion extends JobNode {
    @NotNull
    private final k handler;

    public InvokeOnCompletion(@NotNull k k0) {
        this.handler = k0;
    }

    @Override  // kotlinx.coroutines.JobNode
    public boolean getOnCancelling() {
        return false;
    }

    @Override  // kotlinx.coroutines.JobNode
    public void invoke(@Nullable Throwable throwable0) {
        this.handler.invoke(throwable0);
    }
}

