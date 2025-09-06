package kotlinx.coroutines.flow.internal;

import ie.H;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.Flow;
import me.i;
import me.j;
import ne.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.n;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u001C\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B9\u0012\u0012\u0010\u0005\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0003\u0012\b\b\u0002\u0010\u0007\u001A\u00020\u0006\u0012\b\b\u0002\u0010\t\u001A\u00020\b\u0012\b\b\u0002\u0010\u000B\u001A\u00020\n¢\u0006\u0004\b\f\u0010\rJ-\u0010\u000E\u001A\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\u000B\u001A\u00020\nH\u0014¢\u0006\u0004\b\u000E\u0010\u000FJ\u001D\u0010\u0013\u001A\b\u0012\u0004\u0012\u00028\u00000\u00122\u0006\u0010\u0011\u001A\u00020\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001E\u0010\u0017\u001A\u00020\u00162\f\u0010\u0011\u001A\b\u0012\u0004\u0012\u00028\u00000\u0015H\u0094@¢\u0006\u0004\b\u0017\u0010\u0018R \u0010\u0005\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0019¨\u0006\u001A"}, d2 = {"Lkotlinx/coroutines/flow/internal/ChannelLimitedFlowMerge;", "T", "Lkotlinx/coroutines/flow/internal/ChannelFlow;", "", "Lkotlinx/coroutines/flow/Flow;", "flows", "Lme/i;", "context", "", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "<init>", "(Ljava/lang/Iterable;Lme/i;ILkotlinx/coroutines/channels/BufferOverflow;)V", "create", "(Lme/i;ILkotlinx/coroutines/channels/BufferOverflow;)Lkotlinx/coroutines/flow/internal/ChannelFlow;", "Lkotlinx/coroutines/CoroutineScope;", "scope", "Lkotlinx/coroutines/channels/ReceiveChannel;", "produceImpl", "(Lkotlinx/coroutines/CoroutineScope;)Lkotlinx/coroutines/channels/ReceiveChannel;", "Lkotlinx/coroutines/channels/ProducerScope;", "Lie/H;", "collectTo", "(Lkotlinx/coroutines/channels/ProducerScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ljava/lang/Iterable;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public final class ChannelLimitedFlowMerge extends ChannelFlow {
    @NotNull
    private final Iterable flows;

    public ChannelLimitedFlowMerge(@NotNull Iterable iterable0, @NotNull i i0, int v, @NotNull BufferOverflow bufferOverflow0) {
        super(i0, v, bufferOverflow0);
        this.flows = iterable0;
    }

    public ChannelLimitedFlowMerge(Iterable iterable0, i i0, int v, BufferOverflow bufferOverflow0, int v1, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v1 & 2) != 0) {
            i0 = j.a;
        }
        if((v1 & 4) != 0) {
            v = -2;
        }
        if((v1 & 8) != 0) {
            bufferOverflow0 = BufferOverflow.SUSPEND;
        }
        this(iterable0, i0, v, bufferOverflow0);
    }

    @Override  // kotlinx.coroutines.flow.internal.ChannelFlow
    @Nullable
    public Object collectTo(@NotNull ProducerScope producerScope0, @NotNull Continuation continuation0) {
        SendingCollector sendingCollector0 = new SendingCollector(producerScope0);
        for(Object object0: this.flows) {
            BuildersKt__Builders_commonKt.launch$default(producerScope0, null, null, new n(sendingCollector0, null) {
                final SendingCollector $collector;
                final Flow $flow;
                int label;

                {
                    this.$flow = flow0;
                    this.$collector = sendingCollector0;
                    super(2, continuation0);
                }

                @Override  // oe.a
                public final Continuation create(Object object0, Continuation continuation0) {
                    return new kotlinx.coroutines.flow.internal.ChannelLimitedFlowMerge.collectTo.2.1(this.$flow, this.$collector, continuation0);
                }

                @Override  // we.n
                public Object invoke(Object object0, Object object1) {
                    return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                }

                public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                    return ((kotlinx.coroutines.flow.internal.ChannelLimitedFlowMerge.collectTo.2.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                }

                @Override  // oe.a
                public final Object invokeSuspend(Object object0) {
                    a a0 = a.a;
                    switch(this.label) {
                        case 0: {
                            d5.n.D(object0);
                            this.label = 1;
                            return this.$flow.collect(this.$collector, this) == a0 ? a0 : H.a;
                        }
                        case 1: {
                            d5.n.D(object0);
                            return H.a;
                        }
                        default: {
                            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                        }
                    }
                }
            }, 3, null);
        }
        return H.a;
    }

    @Override  // kotlinx.coroutines.flow.internal.ChannelFlow
    @NotNull
    public ChannelFlow create(@NotNull i i0, int v, @NotNull BufferOverflow bufferOverflow0) {
        return new ChannelLimitedFlowMerge(this.flows, i0, v, bufferOverflow0);
    }

    @Override  // kotlinx.coroutines.flow.internal.ChannelFlow
    @NotNull
    public ReceiveChannel produceImpl(@NotNull CoroutineScope coroutineScope0) {
        n n0 = this.getCollectToFun$kotlinx_coroutines_core();
        return ProduceKt.produce(coroutineScope0, this.context, this.capacity, n0);
    }
}

