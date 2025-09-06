package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.FusibleFlow;
import me.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u00032\b\u0012\u0004\u0012\u00028\u00000\u0004B\u001F\u0012\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\b\u0010\u0007\u001A\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ-\u0010\u0011\u001A\b\u0012\u0004\u0012\u00028\u00000\u00102\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\r\u001A\u00020\f2\u0006\u0010\u000F\u001A\u00020\u000EH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001E\u0010\u0016\u001A\u00020\u00152\f\u0010\u0014\u001A\b\u0012\u0004\u0012\u00028\u00000\u0013H\u0096A¢\u0006\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0007\u001A\u0004\u0018\u00010\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0018¨\u0006\u0019"}, d2 = {"Lkotlinx/coroutines/flow/ReadonlySharedFlow;", "T", "Lkotlinx/coroutines/flow/SharedFlow;", "", "Lkotlinx/coroutines/flow/internal/FusibleFlow;", "flow", "Lkotlinx/coroutines/Job;", "job", "<init>", "(Lkotlinx/coroutines/flow/SharedFlow;Lkotlinx/coroutines/Job;)V", "Lme/i;", "context", "", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "Lkotlinx/coroutines/flow/Flow;", "fuse", "(Lme/i;ILkotlinx/coroutines/channels/BufferOverflow;)Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/FlowCollector;", "collector", "", "collect", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/Job;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
final class ReadonlySharedFlow implements Flow, SharedFlow, FusibleFlow {
    private final SharedFlow $$delegate_0;
    @Nullable
    private final Job job;

    public ReadonlySharedFlow(@NotNull SharedFlow sharedFlow0, @Nullable Job job0) {
        this.$$delegate_0 = sharedFlow0;
        this.job = job0;
    }

    @Override  // kotlinx.coroutines.flow.SharedFlow, kotlinx.coroutines.flow.Flow
    @Nullable
    public Object collect(@NotNull FlowCollector flowCollector0, @NotNull Continuation continuation0) {
        return this.$$delegate_0.collect(flowCollector0, continuation0);
    }

    @Override  // kotlinx.coroutines.flow.internal.FusibleFlow
    @NotNull
    public Flow fuse(@NotNull i i0, int v, @NotNull BufferOverflow bufferOverflow0) {
        return SharedFlowKt.fuseSharedFlow(this, i0, v, bufferOverflow0);
    }
}

