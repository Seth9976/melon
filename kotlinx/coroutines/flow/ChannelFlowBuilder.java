package kotlinx.coroutines.flow;

import ie.H;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.internal.ChannelFlow;
import me.i;
import me.j;
import ne.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.n;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000E\n\u0002\b\u0004\b\u0012\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002BO\u0012(\u0010\b\u001A$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0003\u0012\b\b\u0002\u0010\n\u001A\u00020\t\u0012\b\b\u0002\u0010\f\u001A\u00020\u000B\u0012\b\b\u0002\u0010\u000E\u001A\u00020\r¢\u0006\u0004\b\u000F\u0010\u0010J-\u0010\u0011\u001A\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\n\u001A\u00020\t2\u0006\u0010\f\u001A\u00020\u000B2\u0006\u0010\u000E\u001A\u00020\rH\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u001E\u0010\u0014\u001A\u00020\u00062\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0094@¢\u0006\u0004\b\u0014\u0010\u0015J\u000F\u0010\u0017\u001A\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R6\u0010\b\u001A$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0019¨\u0006\u001A"}, d2 = {"Lkotlinx/coroutines/flow/ChannelFlowBuilder;", "T", "Lkotlinx/coroutines/flow/internal/ChannelFlow;", "Lkotlin/Function2;", "Lkotlinx/coroutines/channels/ProducerScope;", "Lkotlin/coroutines/Continuation;", "Lie/H;", "", "block", "Lme/i;", "context", "", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "<init>", "(Lwe/n;Lme/i;ILkotlinx/coroutines/channels/BufferOverflow;)V", "create", "(Lme/i;ILkotlinx/coroutines/channels/BufferOverflow;)Lkotlinx/coroutines/flow/internal/ChannelFlow;", "scope", "collectTo", "(Lkotlinx/coroutines/channels/ProducerScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "toString", "()Ljava/lang/String;", "Lwe/n;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
class ChannelFlowBuilder extends ChannelFlow {
    @NotNull
    private final n block;

    public ChannelFlowBuilder(@NotNull n n0, @NotNull i i0, int v, @NotNull BufferOverflow bufferOverflow0) {
        super(i0, v, bufferOverflow0);
        this.block = n0;
    }

    public ChannelFlowBuilder(n n0, i i0, int v, BufferOverflow bufferOverflow0, int v1, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v1 & 2) != 0) {
            i0 = j.a;
        }
        if((v1 & 4) != 0) {
            v = -2;
        }
        if((v1 & 8) != 0) {
            bufferOverflow0 = BufferOverflow.SUSPEND;
        }
        this(n0, i0, v, bufferOverflow0);
    }

    @Override  // kotlinx.coroutines.flow.internal.ChannelFlow
    @Nullable
    public Object collectTo(@NotNull ProducerScope producerScope0, @NotNull Continuation continuation0) {
        return ChannelFlowBuilder.collectTo$suspendImpl(this, producerScope0, continuation0);
    }

    public static Object collectTo$suspendImpl(ChannelFlowBuilder channelFlowBuilder0, ProducerScope producerScope0, Continuation continuation0) {
        Object object0 = channelFlowBuilder0.block.invoke(producerScope0, continuation0);
        return object0 == a.a ? object0 : H.a;
    }

    @Override  // kotlinx.coroutines.flow.internal.ChannelFlow
    @NotNull
    public ChannelFlow create(@NotNull i i0, int v, @NotNull BufferOverflow bufferOverflow0) {
        return new ChannelFlowBuilder(this.block, i0, v, bufferOverflow0);
    }

    @Override  // kotlinx.coroutines.flow.internal.ChannelFlow
    @NotNull
    public String toString() {
        return "block[" + this.block + "] -> " + super.toString();
    }
}

