package kotlinx.coroutines.flow.internal;

import ie.H;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import me.i;
import me.j;
import ne.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00000\u0002B3\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0005\u0012\b\b\u0002\u0010\b\u001A\u00020\u0007\u0012\b\b\u0002\u0010\n\u001A\u00020\t¢\u0006\u0004\b\u000B\u0010\fJ-\u0010\u000E\u001A\b\u0012\u0004\u0012\u00028\u00000\r2\u0006\u0010\u0006\u001A\u00020\u00052\u0006\u0010\b\u001A\u00020\u00072\u0006\u0010\n\u001A\u00020\tH\u0014¢\u0006\u0004\b\u000E\u0010\u000FJ\u0015\u0010\u0010\u001A\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001E\u0010\u0015\u001A\u00020\u00142\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u00028\u00000\u0012H\u0094@¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lkotlinx/coroutines/flow/internal/ChannelFlowOperatorImpl;", "T", "Lkotlinx/coroutines/flow/internal/ChannelFlowOperator;", "Lkotlinx/coroutines/flow/Flow;", "flow", "Lme/i;", "context", "", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "<init>", "(Lkotlinx/coroutines/flow/Flow;Lme/i;ILkotlinx/coroutines/channels/BufferOverflow;)V", "Lkotlinx/coroutines/flow/internal/ChannelFlow;", "create", "(Lme/i;ILkotlinx/coroutines/channels/BufferOverflow;)Lkotlinx/coroutines/flow/internal/ChannelFlow;", "dropChannelOperators", "()Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/FlowCollector;", "collector", "Lie/H;", "flowCollect", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public final class ChannelFlowOperatorImpl extends ChannelFlowOperator {
    public ChannelFlowOperatorImpl(@NotNull Flow flow0, @NotNull i i0, int v, @NotNull BufferOverflow bufferOverflow0) {
        super(flow0, i0, v, bufferOverflow0);
    }

    public ChannelFlowOperatorImpl(Flow flow0, i i0, int v, BufferOverflow bufferOverflow0, int v1, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v1 & 2) != 0) {
            i0 = j.a;
        }
        if((v1 & 4) != 0) {
            v = -3;
        }
        if((v1 & 8) != 0) {
            bufferOverflow0 = BufferOverflow.SUSPEND;
        }
        this(flow0, i0, v, bufferOverflow0);
    }

    @Override  // kotlinx.coroutines.flow.internal.ChannelFlow
    @NotNull
    public ChannelFlow create(@NotNull i i0, int v, @NotNull BufferOverflow bufferOverflow0) {
        return new ChannelFlowOperatorImpl(this.flow, i0, v, bufferOverflow0);
    }

    @Override  // kotlinx.coroutines.flow.internal.ChannelFlow
    @NotNull
    public Flow dropChannelOperators() {
        return this.flow;
    }

    @Override  // kotlinx.coroutines.flow.internal.ChannelFlowOperator
    @Nullable
    public Object flowCollect(@NotNull FlowCollector flowCollector0, @NotNull Continuation continuation0) {
        Object object0 = this.flow.collect(flowCollector0, continuation0);
        return object0 == a.a ? object0 : H.a;
    }
}

