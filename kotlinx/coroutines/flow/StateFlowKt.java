package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import kotlinx.coroutines.internal.Symbol;
import me.i;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001A!\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001A\u00028\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001A=\u0010\r\u001A\b\u0012\u0004\u0012\u00028\u00000\f\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00052\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\u000B\u001A\u00020\nH\u0000¢\u0006\u0004\b\r\u0010\u000E\"\u0014\u0010\u0010\u001A\u00020\u000F8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011\"\u0014\u0010\u0012\u001A\u00020\u000F8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011¨\u0006\u0013"}, d2 = {"T", "value", "Lkotlinx/coroutines/flow/MutableStateFlow;", "MutableStateFlow", "(Ljava/lang/Object;)Lkotlinx/coroutines/flow/MutableStateFlow;", "Lkotlinx/coroutines/flow/StateFlow;", "Lme/i;", "context", "", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "Lkotlinx/coroutines/flow/Flow;", "fuseStateFlow", "(Lkotlinx/coroutines/flow/StateFlow;Lme/i;ILkotlinx/coroutines/channels/BufferOverflow;)Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/internal/Symbol;", "NONE", "Lkotlinx/coroutines/internal/Symbol;", "PENDING", "kotlinx-coroutines-core"}, k = 2, mv = {2, 1, 0}, xi = 0x30)
public abstract class StateFlowKt {
    @NotNull
    private static final Symbol NONE;
    @NotNull
    private static final Symbol PENDING;

    static {
        StateFlowKt.NONE = new Symbol("NONE");
        StateFlowKt.PENDING = new Symbol("PENDING");
    }

    @NotNull
    public static final MutableStateFlow MutableStateFlow(Object object0) {
        if(object0 == null) {
            object0 = NullSurrogateKt.NULL;
        }
        return new StateFlowImpl(object0);
    }

    @NotNull
    public static final Flow fuseStateFlow(@NotNull StateFlow stateFlow0, @NotNull i i0, int v, @NotNull BufferOverflow bufferOverflow0) {
        return (v >= 0 && v < 2 || v == -2) && bufferOverflow0 == BufferOverflow.DROP_OLDEST ? stateFlow0 : SharedFlowKt.fuseSharedFlow(stateFlow0, i0, v, bufferOverflow0);
    }
}

