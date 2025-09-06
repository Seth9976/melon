package kotlinx.coroutines.flow.internal;

import ie.H;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import me.e;
import me.i;
import ne.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.n;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0002\b\u0004\b \u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u00028\u00010\u0003B-\u0012\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0007\u001A\u00020\u0006\u0012\u0006\u0010\t\u001A\u00020\b\u0012\u0006\u0010\u000B\u001A\u00020\n¢\u0006\u0004\b\f\u0010\rJ&\u0010\u0012\u001A\u00020\u00112\f\u0010\u000F\u001A\b\u0012\u0004\u0012\u00028\u00010\u000E2\u0006\u0010\u0010\u001A\u00020\u0006H\u0082@¢\u0006\u0004\b\u0012\u0010\u0013J\u001E\u0010\u0014\u001A\u00020\u00112\f\u0010\u000F\u001A\b\u0012\u0004\u0012\u00028\u00010\u000EH¤@¢\u0006\u0004\b\u0014\u0010\u0015J\u001E\u0010\u0018\u001A\u00020\u00112\f\u0010\u0017\u001A\b\u0012\u0004\u0012\u00028\u00010\u0016H\u0094@¢\u0006\u0004\b\u0018\u0010\u0019J\u001E\u0010\u001A\u001A\u00020\u00112\f\u0010\u000F\u001A\b\u0012\u0004\u0012\u00028\u00010\u000EH\u0096@¢\u0006\u0004\b\u001A\u0010\u0015J\u000F\u0010\u001C\u001A\u00020\u001BH\u0016¢\u0006\u0004\b\u001C\u0010\u001DR\u001A\u0010\u0005\u001A\b\u0012\u0004\u0012\u00028\u00000\u00048\u0004X\u0085\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001E¨\u0006\u001F"}, d2 = {"Lkotlinx/coroutines/flow/internal/ChannelFlowOperator;", "S", "T", "Lkotlinx/coroutines/flow/internal/ChannelFlow;", "Lkotlinx/coroutines/flow/Flow;", "flow", "Lme/i;", "context", "", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "<init>", "(Lkotlinx/coroutines/flow/Flow;Lme/i;ILkotlinx/coroutines/channels/BufferOverflow;)V", "Lkotlinx/coroutines/flow/FlowCollector;", "collector", "newContext", "Lie/H;", "collectWithContextUndispatched", "(Lkotlinx/coroutines/flow/FlowCollector;Lme/i;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "flowCollect", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/ProducerScope;", "scope", "collectTo", "(Lkotlinx/coroutines/channels/ProducerScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "collect", "", "toString", "()Ljava/lang/String;", "Lkotlinx/coroutines/flow/Flow;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public abstract class ChannelFlowOperator extends ChannelFlow {
    @NotNull
    protected final Flow flow;

    public ChannelFlowOperator(@NotNull Flow flow0, @NotNull i i0, int v, @NotNull BufferOverflow bufferOverflow0) {
        super(i0, v, bufferOverflow0);
        this.flow = flow0;
    }

    @Override  // kotlinx.coroutines.flow.internal.ChannelFlow
    @Nullable
    public Object collect(@NotNull FlowCollector flowCollector0, @NotNull Continuation continuation0) {
        return ChannelFlowOperator.collect$suspendImpl(this, flowCollector0, continuation0);
    }

    public static Object collect$suspendImpl(ChannelFlowOperator channelFlowOperator0, FlowCollector flowCollector0, Continuation continuation0) {
        if(channelFlowOperator0.capacity == -3) {
            i i0 = continuation0.getContext();
            i i1 = CoroutineContextKt.newCoroutineContext(i0, channelFlowOperator0.context);
            if(q.b(i1, i0)) {
                Object object0 = channelFlowOperator0.flowCollect(flowCollector0, continuation0);
                if(object0 == a.a) {
                    return object0;
                }
            }
            else if(q.b(i1.get(e.a), i0.get(e.a))) {
                Object object1 = channelFlowOperator0.collectWithContextUndispatched(flowCollector0, i1, continuation0);
                if(object1 == a.a) {
                    return object1;
                }
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            Object object2 = channelFlowOperator0.super.collect(flowCollector0, continuation0);
            if(object2 == a.a) {
                return object2;
            }
        }
        return H.a;
    }

    @Override  // kotlinx.coroutines.flow.internal.ChannelFlow
    @Nullable
    public Object collectTo(@NotNull ProducerScope producerScope0, @NotNull Continuation continuation0) {
        return ChannelFlowOperator.collectTo$suspendImpl(this, producerScope0, continuation0);
    }

    public static Object collectTo$suspendImpl(ChannelFlowOperator channelFlowOperator0, ProducerScope producerScope0, Continuation continuation0) {
        Object object0 = channelFlowOperator0.flowCollect(new SendingCollector(producerScope0), continuation0);
        return object0 == a.a ? object0 : H.a;
    }

    private final Object collectWithContextUndispatched(FlowCollector flowCollector0, i i0, Continuation continuation0) {
        return ChannelFlowKt.withContextUndispatched$default(i0, ChannelFlowKt.withUndispatchedContextCollector(flowCollector0, continuation0.getContext()), null, new n(null) {
            Object L$0;
            int label;

            {
                ChannelFlowOperator.this = channelFlowOperator0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                Continuation continuation1 = new kotlinx.coroutines.flow.internal.ChannelFlowOperator.collectWithContextUndispatched.2(ChannelFlowOperator.this, continuation0);
                continuation1.L$0 = object0;
                return continuation1;
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((FlowCollector)object0), ((Continuation)object1));
            }

            public final Object invoke(FlowCollector flowCollector0, Continuation continuation0) {
                return ((kotlinx.coroutines.flow.internal.ChannelFlowOperator.collectWithContextUndispatched.2)this.create(flowCollector0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                a a0 = a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        this.label = 1;
                        return ChannelFlowOperator.this.flowCollect(((FlowCollector)this.L$0), this) == a0 ? a0 : H.a;
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
        }, continuation0, 4, null);
    }

    @Nullable
    public abstract Object flowCollect(@NotNull FlowCollector arg1, @NotNull Continuation arg2);

    @Override  // kotlinx.coroutines.flow.internal.ChannelFlow
    @NotNull
    public String toString() {
        return this.flow + " -> " + super.toString();
    }
}

