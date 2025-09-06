package kotlinx.coroutines.flow;

import ie.H;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import ne.a;
import org.jetbrains.annotations.NotNull;
import we.n;

@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u001AE\u0010\b\u001A\b\u0012\u0004\u0012\u00028\u00000\u0007\"\u0004\b\u0000\u0010\u00002*\b\u0001\u0010\u0006\u001A$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0001¢\u0006\u0004\b\b\u0010\t\u001A!\u0010\u000B\u001A\b\u0012\u0004\u0012\u00028\u00000\u0007\"\u0004\b\u0000\u0010\u00002\u0006\u0010\n\u001A\u00028\u0000¢\u0006\u0004\b\u000B\u0010\f\u001A\u0019\u0010\r\u001A\b\u0012\u0004\u0012\u00028\u00000\u0007\"\u0004\b\u0000\u0010\u0000¢\u0006\u0004\b\r\u0010\u000E\u001AE\u0010\u0010\u001A\b\u0012\u0004\u0012\u00028\u00000\u0007\"\u0004\b\u0000\u0010\u00002*\b\u0001\u0010\u0006\u001A$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000F\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0001¢\u0006\u0004\b\u0010\u0010\t\u001AE\u0010\u0011\u001A\b\u0012\u0004\u0012\u00028\u00000\u0007\"\u0004\b\u0000\u0010\u00002*\b\u0001\u0010\u0006\u001A$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000F\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0001¢\u0006\u0004\b\u0011\u0010\t¨\u0006\u0012"}, d2 = {"T", "Lkotlin/Function2;", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlin/coroutines/Continuation;", "Lie/H;", "", "block", "Lkotlinx/coroutines/flow/Flow;", "flow", "(Lwe/n;)Lkotlinx/coroutines/flow/Flow;", "value", "flowOf", "(Ljava/lang/Object;)Lkotlinx/coroutines/flow/Flow;", "emptyFlow", "()Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/channels/ProducerScope;", "channelFlow", "callbackFlow", "kotlinx-coroutines-core"}, k = 5, mv = {2, 1, 0}, xi = 0x30, xs = "kotlinx/coroutines/flow/FlowKt")
abstract class FlowKt__BuildersKt {
    @NotNull
    public static final Flow callbackFlow(@NotNull n n0) {
        return new CallbackFlowBuilder(n0, null, 0, null, 14, null);
    }

    @NotNull
    public static final Flow channelFlow(@NotNull n n0) {
        return new ChannelFlowBuilder(n0, null, 0, null, 14, null);
    }

    @NotNull
    public static final Flow emptyFlow() {
        return (FlowCollector flowCollector0, Continuation continuation0) -> H.a;
    }

    @NotNull
    public static final Flow flow(@NotNull n n0) {
        return new SafeFlow(n0);
    }

    @NotNull
    public static final Flow flowOf(Object object0) {
        return new Flow() {
            @Override  // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector0, Continuation continuation0) {
                Object object0 = flowCollector0.emit(object0, continuation0);
                return object0 == a.a ? object0 : H.a;
            }
        };
    }
}

