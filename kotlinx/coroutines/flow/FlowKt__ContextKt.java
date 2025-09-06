package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.ChannelFlowOperatorImpl;
import kotlinx.coroutines.flow.internal.FusibleFlow.DefaultImpls;
import kotlinx.coroutines.flow.internal.FusibleFlow;
import me.i;
import me.j;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001A7\u0010\u0006\u001A\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\u0003\u001A\u00020\u00022\b\b\u0002\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007\u001A#\u0010\b\u001A\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\b\u0010\t\u001A+\u0010\f\u001A\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u000B\u001A\u00020\n¢\u0006\u0004\b\f\u0010\r\u001A\u0017\u0010\u0011\u001A\u00020\u000E2\u0006\u0010\u000B\u001A\u00020\nH\u0002¢\u0006\u0004\b\u000F\u0010\u0010¨\u0006\u0012"}, d2 = {"T", "Lkotlinx/coroutines/flow/Flow;", "", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "buffer", "(Lkotlinx/coroutines/flow/Flow;ILkotlinx/coroutines/channels/BufferOverflow;)Lkotlinx/coroutines/flow/Flow;", "conflate", "(Lkotlinx/coroutines/flow/Flow;)Lkotlinx/coroutines/flow/Flow;", "Lme/i;", "context", "flowOn", "(Lkotlinx/coroutines/flow/Flow;Lme/i;)Lkotlinx/coroutines/flow/Flow;", "Lie/H;", "checkFlowContext$FlowKt__ContextKt", "(Lme/i;)V", "checkFlowContext", "kotlinx-coroutines-core"}, k = 5, mv = {2, 1, 0}, xi = 0x30, xs = "kotlinx/coroutines/flow/FlowKt")
abstract class FlowKt__ContextKt {
    @NotNull
    public static final Flow buffer(@NotNull Flow flow0, int v, @NotNull BufferOverflow bufferOverflow0) {
        if(v < 0 && (v != -2 && v != -1)) {
            throw new IllegalArgumentException(("Buffer size should be non-negative, BUFFERED, or CONFLATED, but was " + v).toString());
        }
        if(v == -1 && bufferOverflow0 != BufferOverflow.SUSPEND) {
            throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow");
        }
        if(v == -1) {
            bufferOverflow0 = BufferOverflow.DROP_OLDEST;
            v = 0;
        }
        return flow0 instanceof FusibleFlow ? DefaultImpls.fuse$default(((FusibleFlow)flow0), null, v, bufferOverflow0, 1, null) : new ChannelFlowOperatorImpl(flow0, null, v, bufferOverflow0, 2, null);
    }

    public static Flow buffer$default(Flow flow0, int v, BufferOverflow bufferOverflow0, int v1, Object object0) {
        if((v1 & 1) != 0) {
            v = -2;
        }
        if((v1 & 2) != 0) {
            bufferOverflow0 = BufferOverflow.SUSPEND;
        }
        return FlowKt.buffer(flow0, v, bufferOverflow0);
    }

    private static final void checkFlowContext$FlowKt__ContextKt(i i0) {
        if(i0.get(Job.Key) != null) {
            throw new IllegalArgumentException(("Flow context cannot contain job in it. Had " + i0).toString());
        }
    }

    @NotNull
    public static final Flow conflate(@NotNull Flow flow0) {
        return FlowKt__ContextKt.buffer$default(flow0, -1, null, 2, null);
    }

    @NotNull
    public static final Flow flowOn(@NotNull Flow flow0, @NotNull i i0) {
        FlowKt__ContextKt.checkFlowContext$FlowKt__ContextKt(i0);
        if(q.b(i0, j.a)) {
            return flow0;
        }
        return flow0 instanceof FusibleFlow ? DefaultImpls.fuse$default(((FusibleFlow)flow0), i0, 0, null, 6, null) : new ChannelFlowOperatorImpl(flow0, i0, 0, null, 12, null);
    }
}

