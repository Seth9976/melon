package kotlinx.coroutines.flow;

import ie.H;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.internal.ChannelFlow;
import kotlinx.coroutines.flow.internal.SendingCollector;
import me.i;
import me.j;
import ne.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B;\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\b\b\u0002\u0010\b\u001A\u00020\u0007\u0012\b\b\u0002\u0010\n\u001A\u00020\t\u0012\b\b\u0002\u0010\f\u001A\u00020\u000B¢\u0006\u0004\b\r\u0010\u000EJ\u000F\u0010\u0010\u001A\u00020\u000FH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J-\u0010\u0012\u001A\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\b\u001A\u00020\u00072\u0006\u0010\n\u001A\u00020\t2\u0006\u0010\f\u001A\u00020\u000BH\u0014¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0015\u001A\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001E\u0010\u0019\u001A\u00020\u000F2\f\u0010\u0018\u001A\b\u0012\u0004\u0012\u00028\u00000\u0017H\u0094@¢\u0006\u0004\b\u0019\u0010\u001AJ\u001D\u0010\u001C\u001A\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0018\u001A\u00020\u001BH\u0016¢\u0006\u0004\b\u001C\u0010\u001DJ\u001E\u0010 \u001A\u00020\u000F2\f\u0010\u001F\u001A\b\u0012\u0004\u0012\u00028\u00000\u001EH\u0096@¢\u0006\u0004\b \u0010!J\u000F\u0010#\u001A\u00020\"H\u0014¢\u0006\u0004\b#\u0010$R\u001A\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010%R\u0014\u0010\u0006\u001A\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010&R\u000B\u0010(\u001A\u00020\'8\u0002X\u0082\u0004¨\u0006)"}, d2 = {"Lkotlinx/coroutines/flow/ChannelAsFlow;", "T", "Lkotlinx/coroutines/flow/internal/ChannelFlow;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "channel", "", "consume", "Lme/i;", "context", "", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "<init>", "(Lkotlinx/coroutines/channels/ReceiveChannel;ZLme/i;ILkotlinx/coroutines/channels/BufferOverflow;)V", "Lie/H;", "markConsumed", "()V", "create", "(Lme/i;ILkotlinx/coroutines/channels/BufferOverflow;)Lkotlinx/coroutines/flow/internal/ChannelFlow;", "Lkotlinx/coroutines/flow/Flow;", "dropChannelOperators", "()Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/channels/ProducerScope;", "scope", "collectTo", "(Lkotlinx/coroutines/channels/ProducerScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/CoroutineScope;", "produceImpl", "(Lkotlinx/coroutines/CoroutineScope;)Lkotlinx/coroutines/channels/ReceiveChannel;", "Lkotlinx/coroutines/flow/FlowCollector;", "collector", "collect", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "additionalToStringProps", "()Ljava/lang/String;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "Z", "Lkotlinx/atomicfu/AtomicBoolean;", "consumed", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
final class ChannelAsFlow extends ChannelFlow {
    @NotNull
    private final ReceiveChannel channel;
    private final boolean consume;
    private volatile int consumed$volatile;
    private static final AtomicIntegerFieldUpdater consumed$volatile$FU;

    static {
        ChannelAsFlow.consumed$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(ChannelAsFlow.class, "consumed$volatile");
    }

    public ChannelAsFlow(@NotNull ReceiveChannel receiveChannel0, boolean z, @NotNull i i0, int v, @NotNull BufferOverflow bufferOverflow0) {
        super(i0, v, bufferOverflow0);
        this.channel = receiveChannel0;
        this.consume = z;
    }

    public ChannelAsFlow(ReceiveChannel receiveChannel0, boolean z, i i0, int v, BufferOverflow bufferOverflow0, int v1, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v1 & 4) != 0) {
            i0 = j.a;
        }
        if((v1 & 8) != 0) {
            v = -3;
        }
        if((v1 & 16) != 0) {
            bufferOverflow0 = BufferOverflow.SUSPEND;
        }
        this(receiveChannel0, z, i0, v, bufferOverflow0);
    }

    @Override  // kotlinx.coroutines.flow.internal.ChannelFlow
    @NotNull
    public String additionalToStringProps() {
        return "channel=" + this.channel;
    }

    @Override  // kotlinx.coroutines.flow.internal.ChannelFlow
    @Nullable
    public Object collect(@NotNull FlowCollector flowCollector0, @NotNull Continuation continuation0) {
        H h0 = H.a;
        if(this.capacity == -3) {
            this.markConsumed();
            Object object0 = FlowKt__ChannelsKt.access$emitAllImpl$FlowKt__ChannelsKt(flowCollector0, this.channel, this.consume, continuation0);
            return object0 == a.a ? object0 : h0;
        }
        Object object1 = super.collect(flowCollector0, continuation0);
        return object1 == a.a ? object1 : h0;
    }

    @Override  // kotlinx.coroutines.flow.internal.ChannelFlow
    @Nullable
    public Object collectTo(@NotNull ProducerScope producerScope0, @NotNull Continuation continuation0) {
        Object object0 = FlowKt__ChannelsKt.access$emitAllImpl$FlowKt__ChannelsKt(new SendingCollector(producerScope0), this.channel, this.consume, continuation0);
        return object0 == a.a ? object0 : H.a;
    }

    @Override  // kotlinx.coroutines.flow.internal.ChannelFlow
    @NotNull
    public ChannelFlow create(@NotNull i i0, int v, @NotNull BufferOverflow bufferOverflow0) {
        return new ChannelAsFlow(this.channel, this.consume, i0, v, bufferOverflow0);
    }

    @Override  // kotlinx.coroutines.flow.internal.ChannelFlow
    @NotNull
    public Flow dropChannelOperators() {
        return new ChannelAsFlow(this.channel, this.consume, null, 0, null, 28, null);
    }

    private final void markConsumed() {
        if(this.consume && ChannelAsFlow.consumed$volatile$FU.getAndSet(this, 1) == 1) {
            throw new IllegalStateException("ReceiveChannel.consumeAsFlow can be collected just once");
        }
    }

    @Override  // kotlinx.coroutines.flow.internal.ChannelFlow
    @NotNull
    public ReceiveChannel produceImpl(@NotNull CoroutineScope coroutineScope0) {
        this.markConsumed();
        return this.capacity == -3 ? this.channel : super.produceImpl(coroutineScope0);
    }
}

